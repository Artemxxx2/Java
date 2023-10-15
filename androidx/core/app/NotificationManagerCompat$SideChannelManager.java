package androidx.core.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class SideChannelManager implements Handler.Callback, ServiceConnection {
  private static final int MSG_QUEUE_TASK = 0;
  
  private static final int MSG_RETRY_LISTENER_QUEUE = 3;
  
  private static final int MSG_SERVICE_CONNECTED = 1;
  
  private static final int MSG_SERVICE_DISCONNECTED = 2;
  
  private Set<String> mCachedEnabledPackages = new HashSet<String>();
  
  private final Context mContext;
  
  private final Handler mHandler;
  
  private final HandlerThread mHandlerThread;
  
  private final Map<ComponentName, ListenerRecord> mRecordMap = new HashMap<ComponentName, ListenerRecord>();
  
  SideChannelManager(Context paramContext) {
    this.mContext = paramContext;
    this.mHandlerThread = new HandlerThread("NotificationManagerCompat");
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
  }
  
  private boolean ensureServiceBound(ListenerRecord paramListenerRecord) {
    if (paramListenerRecord.bound)
      return true; 
    Intent intent = (new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL")).setComponent(paramListenerRecord.componentName);
    paramListenerRecord.bound = this.mContext.bindService(intent, this, 33);
    if (paramListenerRecord.bound) {
      paramListenerRecord.retryCount = 0;
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to bind to listener ");
      stringBuilder.append(paramListenerRecord.componentName);
      Log.w("NotifManCompat", stringBuilder.toString());
      this.mContext.unbindService(this);
    } 
    return paramListenerRecord.bound;
  }
  
  private void ensureServiceUnbound(ListenerRecord paramListenerRecord) {
    if (paramListenerRecord.bound) {
      this.mContext.unbindService(this);
      paramListenerRecord.bound = false;
    } 
    paramListenerRecord.service = null;
  }
  
  private void handleQueueTask(NotificationManagerCompat.Task paramTask) {
    updateListenerMap();
    for (ListenerRecord listenerRecord : this.mRecordMap.values()) {
      listenerRecord.taskQueue.add(paramTask);
      processListenerQueue(listenerRecord);
    } 
  }
  
  private void handleRetryListenerQueue(ComponentName paramComponentName) {
    ListenerRecord listenerRecord = this.mRecordMap.get(paramComponentName);
    if (listenerRecord != null)
      processListenerQueue(listenerRecord); 
  }
  
  private void handleServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    ListenerRecord listenerRecord = this.mRecordMap.get(paramComponentName);
    if (listenerRecord != null) {
      listenerRecord.service = INotificationSideChannel.Stub.asInterface(paramIBinder);
      listenerRecord.retryCount = 0;
      processListenerQueue(listenerRecord);
    } 
  }
  
  private void handleServiceDisconnected(ComponentName paramComponentName) {
    ListenerRecord listenerRecord = this.mRecordMap.get(paramComponentName);
    if (listenerRecord != null)
      ensureServiceUnbound(listenerRecord); 
  }
  
  private void processListenerQueue(ListenerRecord paramListenerRecord) {
    if (Log.isLoggable("NotifManCompat", 3)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Processing component ");
      stringBuilder.append(paramListenerRecord.componentName);
      stringBuilder.append(", ");
      stringBuilder.append(paramListenerRecord.taskQueue.size());
      stringBuilder.append(" queued tasks");
      Log.d("NotifManCompat", stringBuilder.toString());
    } 
    if (paramListenerRecord.taskQueue.isEmpty())
      return; 
    if (!ensureServiceBound(paramListenerRecord) || paramListenerRecord.service == null) {
      scheduleListenerRetry(paramListenerRecord);
      return;
    } 
    while (true) {
      NotificationManagerCompat.Task task = paramListenerRecord.taskQueue.peek();
      if (task == null)
        break; 
      try {
        if (Log.isLoggable("NotifManCompat", 3)) {
          StringBuilder stringBuilder = new StringBuilder();
          this();
          stringBuilder.append("Sending task ");
          stringBuilder.append(task);
          Log.d("NotifManCompat", stringBuilder.toString());
        } 
        task.send(paramListenerRecord.service);
        paramListenerRecord.taskQueue.remove();
        continue;
      } catch (DeadObjectException deadObjectException) {
        if (Log.isLoggable("NotifManCompat", 3)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Remote service has died: ");
          stringBuilder.append(paramListenerRecord.componentName);
          Log.d("NotifManCompat", stringBuilder.toString());
        } 
      } catch (RemoteException remoteException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RemoteException communicating with ");
        stringBuilder.append(paramListenerRecord.componentName);
        Log.w("NotifManCompat", stringBuilder.toString(), (Throwable)remoteException);
        break;
      } 
      if (!paramListenerRecord.taskQueue.isEmpty())
        scheduleListenerRetry(paramListenerRecord); 
      return;
    } 
    if (!paramListenerRecord.taskQueue.isEmpty())
      scheduleListenerRetry(paramListenerRecord); 
  }
  
  private void scheduleListenerRetry(ListenerRecord paramListenerRecord) {
    if (this.mHandler.hasMessages(3, paramListenerRecord.componentName))
      return; 
    paramListenerRecord.retryCount++;
    if (paramListenerRecord.retryCount > 6) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Giving up on delivering ");
      stringBuilder.append(paramListenerRecord.taskQueue.size());
      stringBuilder.append(" tasks to ");
      stringBuilder.append(paramListenerRecord.componentName);
      stringBuilder.append(" after ");
      stringBuilder.append(paramListenerRecord.retryCount);
      stringBuilder.append(" retries");
      Log.w("NotifManCompat", stringBuilder.toString());
      paramListenerRecord.taskQueue.clear();
      return;
    } 
    int i = (1 << paramListenerRecord.retryCount - 1) * 1000;
    if (Log.isLoggable("NotifManCompat", 3)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Scheduling retry for ");
      stringBuilder.append(i);
      stringBuilder.append(" ms");
      Log.d("NotifManCompat", stringBuilder.toString());
    } 
    Message message = this.mHandler.obtainMessage(3, paramListenerRecord.componentName);
    this.mHandler.sendMessageDelayed(message, i);
  }
  
  private void updateListenerMap() {
    Set<String> set = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
    if (set.equals(this.mCachedEnabledPackages))
      return; 
    this.mCachedEnabledPackages = set;
    List list = this.mContext.getPackageManager().queryIntentServices((new Intent()).setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
    HashSet<ComponentName> hashSet = new HashSet();
    for (ResolveInfo resolveInfo : list) {
      if (!set.contains(resolveInfo.serviceInfo.packageName))
        continue; 
      ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
      if (resolveInfo.serviceInfo.permission != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Permission present on component ");
        stringBuilder.append(componentName);
        stringBuilder.append(", not adding listener record.");
        Log.w("NotifManCompat", stringBuilder.toString());
        continue;
      } 
      hashSet.add(componentName);
    } 
    for (ComponentName componentName : hashSet) {
      if (!this.mRecordMap.containsKey(componentName)) {
        if (Log.isLoggable("NotifManCompat", 3)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Adding listener record for ");
          stringBuilder.append(componentName);
          Log.d("NotifManCompat", stringBuilder.toString());
        } 
        this.mRecordMap.put(componentName, new ListenerRecord(componentName));
      } 
    } 
    Iterator<Map.Entry> iterator = this.mRecordMap.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      if (!hashSet.contains(entry.getKey())) {
        if (Log.isLoggable("NotifManCompat", 3)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Removing listener record for ");
          stringBuilder.append(entry.getKey());
          Log.d("NotifManCompat", stringBuilder.toString());
        } 
        ensureServiceUnbound((ListenerRecord)entry.getValue());
        iterator.remove();
      } 
    } 
  }
  
  public boolean handleMessage(Message paramMessage) {
    NotificationManagerCompat.ServiceConnectedEvent serviceConnectedEvent;
    switch (paramMessage.what) {
      default:
        return false;
      case 3:
        handleRetryListenerQueue((ComponentName)paramMessage.obj);
        return true;
      case 2:
        handleServiceDisconnected((ComponentName)paramMessage.obj);
        return true;
      case 1:
        serviceConnectedEvent = (NotificationManagerCompat.ServiceConnectedEvent)paramMessage.obj;
        handleServiceConnected(serviceConnectedEvent.componentName, serviceConnectedEvent.iBinder);
        return true;
      case 0:
        break;
    } 
    handleQueueTask((NotificationManagerCompat.Task)((Message)serviceConnectedEvent).obj);
    return true;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    if (Log.isLoggable("NotifManCompat", 3)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Connected to service ");
      stringBuilder.append(paramComponentName);
      Log.d("NotifManCompat", stringBuilder.toString());
    } 
    this.mHandler.obtainMessage(1, new NotificationManagerCompat.ServiceConnectedEvent(paramComponentName, paramIBinder)).sendToTarget();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {
    if (Log.isLoggable("NotifManCompat", 3)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Disconnected from service ");
      stringBuilder.append(paramComponentName);
      Log.d("NotifManCompat", stringBuilder.toString());
    } 
    this.mHandler.obtainMessage(2, paramComponentName).sendToTarget();
  }
  
  public void queueTask(NotificationManagerCompat.Task paramTask) {
    this.mHandler.obtainMessage(0, paramTask).sendToTarget();
  }
  
  private static class ListenerRecord {
    boolean bound = false;
    
    final ComponentName componentName;
    
    int retryCount = 0;
    
    INotificationSideChannel service;
    
    ArrayDeque<NotificationManagerCompat.Task> taskQueue = new ArrayDeque<NotificationManagerCompat.Task>();
    
    ListenerRecord(ComponentName param2ComponentName) {
      this.componentName = param2ComponentName;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationManagerCompat$SideChannelManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */