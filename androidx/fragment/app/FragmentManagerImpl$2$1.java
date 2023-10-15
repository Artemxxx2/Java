package androidx.fragment.app;

class null implements Runnable {
  public void run() {
    if (fragment.getAnimatingAway() != null) {
      fragment.setAnimatingAway(null);
      this.this$1.this$0.moveToState(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentManagerImpl$2$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */