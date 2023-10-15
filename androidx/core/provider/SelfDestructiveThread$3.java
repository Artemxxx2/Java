package androidx.core.provider;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class null implements Runnable {
  public void run() {
    try {
      holder.set(callable.call());
    } catch (Exception exception) {}
    lock.lock();
    try {
      running.set(false);
      cond.signal();
      return;
    } finally {
      lock.unlock();
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\provider\SelfDestructiveThread$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */