package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MethodReference {
  final int mCallType;
  
  final Method mMethod;
  
  MethodReference(int paramInt, Method paramMethod) {
    this.mCallType = paramInt;
    this.mMethod = paramMethod;
    this.mMethod.setAccessible(true);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    if (this.mCallType != ((MethodReference)paramObject).mCallType || !this.mMethod.getName().equals(((MethodReference)paramObject).mMethod.getName()))
      bool = false; 
    return bool;
  }
  
  public int hashCode() {
    return this.mCallType * 31 + this.mMethod.getName().hashCode();
  }
  
  void invokeCallback(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent, Object paramObject) {
    try {
      switch (this.mCallType) {
        default:
          return;
        case 2:
          this.mMethod.invoke(paramObject, new Object[] { paramLifecycleOwner, paramEvent });
        case 1:
          this.mMethod.invoke(paramObject, new Object[] { paramLifecycleOwner });
        case 0:
          break;
      } 
      this.mMethod.invoke(paramObject, new Object[0]);
    } catch (InvocationTargetException invocationTargetException) {
      throw new RuntimeException("Failed to call observer method", invocationTargetException.getCause());
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException(illegalAccessException);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\lifecycle\ClassesInfoCache$MethodReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */