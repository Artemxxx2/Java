package androidx.core.view;

import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

class UnhandledKeyEventManager {
  private static final ArrayList<WeakReference<View>> sViewsWithListeners = new ArrayList<WeakReference<View>>();
  
  private SparseArray<WeakReference<View>> mCapturedKeys = null;
  
  private WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent = null;
  
  @Nullable
  private WeakHashMap<View, Boolean> mViewsContainingListeners = null;
  
  static UnhandledKeyEventManager at(View paramView) {
    UnhandledKeyEventManager unhandledKeyEventManager1 = (UnhandledKeyEventManager)paramView.getTag(R.id.tag_unhandled_key_event_manager);
    UnhandledKeyEventManager unhandledKeyEventManager2 = unhandledKeyEventManager1;
    if (unhandledKeyEventManager1 == null) {
      unhandledKeyEventManager2 = new UnhandledKeyEventManager();
      paramView.setTag(R.id.tag_unhandled_key_event_manager, unhandledKeyEventManager2);
    } 
    return unhandledKeyEventManager2;
  }
  
  @Nullable
  private View dispatchInOrder(View paramView, KeyEvent paramKeyEvent) {
    WeakHashMap<View, Boolean> weakHashMap = this.mViewsContainingListeners;
    if (weakHashMap == null || !weakHashMap.containsKey(paramView))
      return null; 
    if (paramView instanceof ViewGroup) {
      ViewGroup viewGroup = (ViewGroup)paramView;
      for (int i = viewGroup.getChildCount() - 1; i >= 0; i--) {
        View view = dispatchInOrder(viewGroup.getChildAt(i), paramKeyEvent);
        if (view != null)
          return view; 
      } 
    } 
    return onUnhandledKeyEvent(paramView, paramKeyEvent) ? paramView : null;
  }
  
  private SparseArray<WeakReference<View>> getCapturedKeys() {
    if (this.mCapturedKeys == null)
      this.mCapturedKeys = new SparseArray(); 
    return this.mCapturedKeys;
  }
  
  private boolean onUnhandledKeyEvent(@NonNull View paramView, @NonNull KeyEvent paramKeyEvent) {
    ArrayList<ViewCompat.OnUnhandledKeyEventListenerCompat> arrayList = (ArrayList)paramView.getTag(R.id.tag_unhandled_key_listeners);
    if (arrayList != null)
      for (int i = arrayList.size() - 1; i >= 0; i--) {
        if (((ViewCompat.OnUnhandledKeyEventListenerCompat)arrayList.get(i)).onUnhandledKeyEvent(paramView, paramKeyEvent))
          return true; 
      }  
    return false;
  }
  
  private void recalcViewsWithUnhandled() {
    null = this.mViewsContainingListeners;
    if (null != null)
      null.clear(); 
    if (sViewsWithListeners.isEmpty())
      return; 
    synchronized (sViewsWithListeners) {
      if (this.mViewsContainingListeners == null) {
        null = new WeakHashMap<View, Boolean>();
        this();
        this.mViewsContainingListeners = null;
      } 
      for (int i = sViewsWithListeners.size() - 1; i >= 0; i--) {
        View view = ((WeakReference<View>)sViewsWithListeners.get(i)).get();
        if (view == null) {
          sViewsWithListeners.remove(i);
        } else {
          this.mViewsContainingListeners.put(view, Boolean.TRUE);
          for (ViewParent viewParent = view.getParent(); viewParent instanceof View; viewParent = viewParent.getParent())
            this.mViewsContainingListeners.put((View)viewParent, Boolean.TRUE); 
        } 
      } 
      return;
    } 
  }
  
  static void registerListeningView(View paramView) {
    synchronized (sViewsWithListeners) {
      Iterator<WeakReference<View>> iterator = sViewsWithListeners.iterator();
      while (iterator.hasNext()) {
        if (((WeakReference<View>)iterator.next()).get() == paramView)
          return; 
      } 
      ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
      WeakReference<View> weakReference = new WeakReference();
      this((T)paramView);
      arrayList.add(weakReference);
      return;
    } 
  }
  
  static void unregisterListeningView(View paramView) {
    // Byte code:
    //   0: getstatic androidx/core/view/ViewCompat$UnhandledKeyEventManager.sViewsWithListeners : Ljava/util/ArrayList;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: iconst_0
    //   7: istore_2
    //   8: iload_2
    //   9: getstatic androidx/core/view/ViewCompat$UnhandledKeyEventManager.sViewsWithListeners : Ljava/util/ArrayList;
    //   12: invokevirtual size : ()I
    //   15: if_icmpge -> 52
    //   18: getstatic androidx/core/view/ViewCompat$UnhandledKeyEventManager.sViewsWithListeners : Ljava/util/ArrayList;
    //   21: iload_2
    //   22: invokevirtual get : (I)Ljava/lang/Object;
    //   25: checkcast java/lang/ref/WeakReference
    //   28: invokevirtual get : ()Ljava/lang/Object;
    //   31: aload_0
    //   32: if_acmpne -> 46
    //   35: getstatic androidx/core/view/ViewCompat$UnhandledKeyEventManager.sViewsWithListeners : Ljava/util/ArrayList;
    //   38: iload_2
    //   39: invokevirtual remove : (I)Ljava/lang/Object;
    //   42: pop
    //   43: aload_1
    //   44: monitorexit
    //   45: return
    //   46: iinc #2, 1
    //   49: goto -> 8
    //   52: aload_1
    //   53: monitorexit
    //   54: return
    //   55: astore_0
    //   56: aload_1
    //   57: monitorexit
    //   58: aload_0
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   8	45	55	finally
    //   52	54	55	finally
    //   56	58	55	finally
  }
  
  boolean dispatch(View paramView, KeyEvent paramKeyEvent) {
    boolean bool;
    if (paramKeyEvent.getAction() == 0)
      recalcViewsWithUnhandled(); 
    paramView = dispatchInOrder(paramView, paramKeyEvent);
    if (paramKeyEvent.getAction() == 0) {
      int i = paramKeyEvent.getKeyCode();
      if (paramView != null && !KeyEvent.isModifierKey(i))
        getCapturedKeys().put(i, new WeakReference<View>(paramView)); 
    } 
    if (paramView != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  boolean preDispatch(KeyEvent paramKeyEvent) {
    WeakReference<KeyEvent> weakReference1 = this.mLastDispatchedPreViewKeyEvent;
    if (weakReference1 != null && weakReference1.get() == paramKeyEvent)
      return false; 
    this.mLastDispatchedPreViewKeyEvent = new WeakReference<KeyEvent>(paramKeyEvent);
    WeakReference<KeyEvent> weakReference2 = null;
    SparseArray<WeakReference<View>> sparseArray = getCapturedKeys();
    weakReference1 = weakReference2;
    if (paramKeyEvent.getAction() == 1) {
      int i = sparseArray.indexOfKey(paramKeyEvent.getKeyCode());
      weakReference1 = weakReference2;
      if (i >= 0) {
        weakReference1 = (WeakReference<KeyEvent>)sparseArray.valueAt(i);
        sparseArray.removeAt(i);
      } 
    } 
    weakReference2 = weakReference1;
    if (weakReference1 == null)
      weakReference2 = (WeakReference<KeyEvent>)sparseArray.get(paramKeyEvent.getKeyCode()); 
    if (weakReference2 != null) {
      View view = (View)weakReference2.get();
      if (view != null && ViewCompat.isAttachedToWindow(view))
        onUnhandledKeyEvent(view, paramKeyEvent); 
      return true;
    } 
    return false;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\ViewCompat$UnhandledKeyEventManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */