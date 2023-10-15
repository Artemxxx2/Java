package androidx.fragment.app;

final class Op {
  int cmd;
  
  int enterAnim;
  
  int exitAnim;
  
  Fragment fragment;
  
  int popEnterAnim;
  
  int popExitAnim;
  
  Op() {}
  
  Op(int paramInt, Fragment paramFragment) {
    this.cmd = paramInt;
    this.fragment = paramFragment;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\BackStackRecord$Op.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */