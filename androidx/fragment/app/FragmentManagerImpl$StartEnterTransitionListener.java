package androidx.fragment.app;

class StartEnterTransitionListener implements Fragment.OnStartEnterTransitionListener {
  final boolean mIsBack;
  
  private int mNumPostponed;
  
  final BackStackRecord mRecord;
  
  StartEnterTransitionListener(BackStackRecord paramBackStackRecord, boolean paramBoolean) {
    this.mIsBack = paramBoolean;
    this.mRecord = paramBackStackRecord;
  }
  
  public void cancelTransaction() {
    this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, false, false);
  }
  
  public void completeTransaction() {
    int i = this.mNumPostponed;
    byte b = 0;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    } 
    FragmentManagerImpl fragmentManagerImpl = this.mRecord.mManager;
    int j = fragmentManagerImpl.mAdded.size();
    while (b < j) {
      Fragment fragment = fragmentManagerImpl.mAdded.get(b);
      fragment.setOnStartEnterTransitionListener(null);
      if (i != 0 && fragment.isPostponed())
        fragment.startPostponedEnterTransition(); 
      b++;
    } 
    this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, i ^ 0x1, true);
  }
  
  public boolean isReady() {
    boolean bool;
    if (this.mNumPostponed == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void onStartEnterTransition() {
    this.mNumPostponed--;
    if (this.mNumPostponed != 0)
      return; 
    this.mRecord.mManager.scheduleCommit();
  }
  
  public void startListening() {
    this.mNumPostponed++;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentManagerImpl$StartEnterTransitionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */