package androidx.core.app;

import android.app.Notification;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import java.util.ArrayList;
import java.util.List;

public class DecoratedCustomViewStyle extends NotificationCompat.Style {
  private static final int MAX_ACTION_BUTTONS = 3;
  
  private RemoteViews createRemoteViews(RemoteViews paramRemoteViews, boolean paramBoolean) {
    // Byte code:
    //   0: getstatic androidx/core/R$layout.notification_template_custom_big : I
    //   3: istore_3
    //   4: iconst_1
    //   5: istore #4
    //   7: iconst_0
    //   8: istore #5
    //   10: aload_0
    //   11: iconst_1
    //   12: iload_3
    //   13: iconst_0
    //   14: invokevirtual applyStandardTemplate : (ZIZ)Landroid/widget/RemoteViews;
    //   17: astore #6
    //   19: aload #6
    //   21: getstatic androidx/core/R$id.actions : I
    //   24: invokevirtual removeAllViews : (I)V
    //   27: aload_0
    //   28: getfield mBuilder : Landroidx/core/app/NotificationCompat$Builder;
    //   31: getfield mActions : Ljava/util/ArrayList;
    //   34: invokestatic getNonContextualActions : (Ljava/util/List;)Ljava/util/List;
    //   37: astore #7
    //   39: iload_2
    //   40: ifeq -> 111
    //   43: aload #7
    //   45: ifnull -> 111
    //   48: aload #7
    //   50: invokeinterface size : ()I
    //   55: iconst_3
    //   56: invokestatic min : (II)I
    //   59: istore #8
    //   61: iload #8
    //   63: ifle -> 111
    //   66: iconst_0
    //   67: istore_3
    //   68: iload #4
    //   70: istore #9
    //   72: iload_3
    //   73: iload #8
    //   75: if_icmpge -> 114
    //   78: aload_0
    //   79: aload #7
    //   81: iload_3
    //   82: invokeinterface get : (I)Ljava/lang/Object;
    //   87: checkcast androidx/core/app/NotificationCompat$Action
    //   90: invokespecial generateActionButton : (Landroidx/core/app/NotificationCompat$Action;)Landroid/widget/RemoteViews;
    //   93: astore #10
    //   95: aload #6
    //   97: getstatic androidx/core/R$id.actions : I
    //   100: aload #10
    //   102: invokevirtual addView : (ILandroid/widget/RemoteViews;)V
    //   105: iinc #3, 1
    //   108: goto -> 68
    //   111: iconst_0
    //   112: istore #9
    //   114: iload #9
    //   116: ifeq -> 125
    //   119: iload #5
    //   121: istore_3
    //   122: goto -> 128
    //   125: bipush #8
    //   127: istore_3
    //   128: aload #6
    //   130: getstatic androidx/core/R$id.actions : I
    //   133: iload_3
    //   134: invokevirtual setViewVisibility : (II)V
    //   137: aload #6
    //   139: getstatic androidx/core/R$id.action_divider : I
    //   142: iload_3
    //   143: invokevirtual setViewVisibility : (II)V
    //   146: aload_0
    //   147: aload #6
    //   149: aload_1
    //   150: invokevirtual buildIntoRemoteViews : (Landroid/widget/RemoteViews;Landroid/widget/RemoteViews;)V
    //   153: aload #6
    //   155: areturn
  }
  
  private RemoteViews generateActionButton(NotificationCompat.Action paramAction) {
    boolean bool;
    int i;
    if (paramAction.actionIntent == null) {
      bool = true;
    } else {
      bool = false;
    } 
    String str = this.mBuilder.mContext.getPackageName();
    if (bool) {
      i = R.layout.notification_action_tombstone;
    } else {
      i = R.layout.notification_action;
    } 
    RemoteViews remoteViews = new RemoteViews(str, i);
    remoteViews.setImageViewBitmap(R.id.action_image, createColoredBitmap(paramAction.getIconCompat(), this.mBuilder.mContext.getResources().getColor(R.color.notification_action_color_filter)));
    remoteViews.setTextViewText(R.id.action_text, paramAction.title);
    if (!bool)
      remoteViews.setOnClickPendingIntent(R.id.action_container, paramAction.actionIntent); 
    if (Build.VERSION.SDK_INT >= 15)
      remoteViews.setContentDescription(R.id.action_container, paramAction.title); 
    return remoteViews;
  }
  
  private static List<NotificationCompat.Action> getNonContextualActions(List<NotificationCompat.Action> paramList) {
    if (paramList == null)
      return null; 
    ArrayList<NotificationCompat.Action> arrayList = new ArrayList();
    for (NotificationCompat.Action action : paramList) {
      if (!action.isContextual())
        arrayList.add(action); 
    } 
    return arrayList;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor) {
    if (Build.VERSION.SDK_INT >= 24)
      paramNotificationBuilderWithBuilderAccessor.getBuilder().setStyle((Notification.Style)new Notification.DecoratedCustomViewStyle()); 
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor) {
    if (Build.VERSION.SDK_INT >= 24)
      return null; 
    RemoteViews remoteViews = this.mBuilder.getBigContentView();
    if (remoteViews == null)
      remoteViews = this.mBuilder.getContentView(); 
    return (remoteViews == null) ? null : createRemoteViews(remoteViews, true);
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor) {
    return (Build.VERSION.SDK_INT >= 24) ? null : ((this.mBuilder.getContentView() == null) ? null : createRemoteViews(this.mBuilder.getContentView(), false));
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor) {
    RemoteViews remoteViews1;
    if (Build.VERSION.SDK_INT >= 24)
      return null; 
    RemoteViews remoteViews2 = this.mBuilder.getHeadsUpContentView();
    if (remoteViews2 != null) {
      remoteViews1 = remoteViews2;
    } else {
      remoteViews1 = this.mBuilder.getContentView();
    } 
    return (remoteViews2 == null) ? null : createRemoteViews(remoteViews1, true);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationCompat$DecoratedCustomViewStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */