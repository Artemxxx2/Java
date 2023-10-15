package androidx.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CallbackInfo {
  final Map<Lifecycle.Event, List<ClassesInfoCache.MethodReference>> mEventToHandlers;
  
  final Map<ClassesInfoCache.MethodReference, Lifecycle.Event> mHandlerToEvent;
  
  CallbackInfo(Map<ClassesInfoCache.MethodReference, Lifecycle.Event> paramMap) {
    this.mHandlerToEvent = paramMap;
    this.mEventToHandlers = new HashMap<Lifecycle.Event, List<ClassesInfoCache.MethodReference>>();
    for (Map.Entry<ClassesInfoCache.MethodReference, Lifecycle.Event> entry : paramMap.entrySet()) {
      Lifecycle.Event event = (Lifecycle.Event)entry.getValue();
      List<ClassesInfoCache.MethodReference> list2 = this.mEventToHandlers.get(event);
      List<ClassesInfoCache.MethodReference> list1 = list2;
      if (list2 == null) {
        list1 = new ArrayList();
        this.mEventToHandlers.put(event, list1);
      } 
      list1.add((ClassesInfoCache.MethodReference)entry.getKey());
    } 
  }
  
  private static void invokeMethodsForEvent(List<ClassesInfoCache.MethodReference> paramList, LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent, Object paramObject) {
    if (paramList != null)
      for (int i = paramList.size() - 1; i >= 0; i--)
        ((ClassesInfoCache.MethodReference)paramList.get(i)).invokeCallback(paramLifecycleOwner, paramEvent, paramObject);  
  }
  
  void invokeCallbacks(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent, Object paramObject) {
    invokeMethodsForEvent(this.mEventToHandlers.get(paramEvent), paramLifecycleOwner, paramEvent, paramObject);
    invokeMethodsForEvent(this.mEventToHandlers.get(Lifecycle.Event.ON_ANY), paramLifecycleOwner, paramEvent, paramObject);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\lifecycle\ClassesInfoCache$CallbackInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */