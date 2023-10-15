package androidx.core.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;

class SavedState extends View.BaseSavedState {
  public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
      public NestedScrollView.SavedState createFromParcel(Parcel param2Parcel) {
        return new NestedScrollView.SavedState(param2Parcel);
      }
      
      public NestedScrollView.SavedState[] newArray(int param2Int) {
        return new NestedScrollView.SavedState[param2Int];
      }
    };
  
  public int scrollPosition;
  
  SavedState(Parcel paramParcel) {
    super(paramParcel);
    this.scrollPosition = paramParcel.readInt();
  }
  
  SavedState(Parcelable paramParcelable) {
    super(paramParcelable);
  }
  
  @NonNull
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("HorizontalScrollView.SavedState{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" scrollPosition=");
    stringBuilder.append(this.scrollPosition);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.scrollPosition);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\widget\NestedScrollView$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */