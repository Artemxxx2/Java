package androidx.fragment.app;

import java.util.ArrayList;

class PopBackStackState implements FragmentManagerImpl.OpGenerator {
  final int mFlags;
  
  final int mId;
  
  final String mName;
  
  PopBackStackState(String paramString, int paramInt1, int paramInt2) {
    this.mName = paramString;
    this.mId = paramInt1;
    this.mFlags = paramInt2;
  }
  
  public boolean generateOps(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1) {
    if (FragmentManagerImpl.this.mPrimaryNav != null && this.mId < 0 && this.mName == null) {
      FragmentManager fragmentManager = FragmentManagerImpl.this.mPrimaryNav.peekChildFragmentManager();
      if (fragmentManager != null && fragmentManager.popBackStackImmediate())
        return false; 
    } 
    return FragmentManagerImpl.this.popBackStackState(paramArrayList, paramArrayList1, this.mName, this.mId, this.mFlags);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentManagerImpl$PopBackStackState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */