package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

class SavedState extends View.BaseSavedState {
  public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
      public FragmentTabHost.SavedState createFromParcel(Parcel param2Parcel) {
        return new FragmentTabHost.SavedState(param2Parcel);
      }
      
      public FragmentTabHost.SavedState[] newArray(int param2Int) {
        return new FragmentTabHost.SavedState[param2Int];
      }
    };
  
  String curTab;
  
  SavedState(Parcel paramParcel) {
    super(paramParcel);
    this.curTab = paramParcel.readString();
  }
  
  SavedState(Parcelable paramParcelable) {
    super(paramParcelable);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("FragmentTabHost.SavedState{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" curTab=");
    stringBuilder.append(this.curTab);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.curTab);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentTabHost$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */