package androidx.coordinatorlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.customview.view.AbsSavedState;

public class SavedState extends AbsSavedState {
  public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
      public CoordinatorLayout.SavedState createFromParcel(Parcel param2Parcel) {
        return new CoordinatorLayout.SavedState(param2Parcel, null);
      }
      
      public CoordinatorLayout.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
        return new CoordinatorLayout.SavedState(param2Parcel, param2ClassLoader);
      }
      
      public CoordinatorLayout.SavedState[] newArray(int param2Int) {
        return new CoordinatorLayout.SavedState[param2Int];
      }
    };
  
  SparseArray<Parcelable> behaviorStates;
  
  public SavedState(Parcel paramParcel, ClassLoader paramClassLoader) {
    super(paramParcel, paramClassLoader);
    int i = paramParcel.readInt();
    int[] arrayOfInt = new int[i];
    paramParcel.readIntArray(arrayOfInt);
    Parcelable[] arrayOfParcelable = paramParcel.readParcelableArray(paramClassLoader);
    this.behaviorStates = new SparseArray(i);
    for (byte b = 0; b < i; b++)
      this.behaviorStates.append(arrayOfInt[b], arrayOfParcelable[b]); 
  }
  
  public SavedState(Parcelable paramParcelable) {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    byte b2;
    super.writeToParcel(paramParcel, paramInt);
    SparseArray<Parcelable> sparseArray = this.behaviorStates;
    byte b1 = 0;
    if (sparseArray != null) {
      b2 = sparseArray.size();
    } else {
      b2 = 0;
    } 
    paramParcel.writeInt(b2);
    int[] arrayOfInt = new int[b2];
    Parcelable[] arrayOfParcelable = new Parcelable[b2];
    while (b1 < b2) {
      arrayOfInt[b1] = this.behaviorStates.keyAt(b1);
      arrayOfParcelable[b1] = (Parcelable)this.behaviorStates.valueAt(b1);
      b1++;
    } 
    paramParcel.writeIntArray(arrayOfInt);
    paramParcel.writeParcelableArray(arrayOfParcelable, paramInt);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\coordinatorlayout\widget\CoordinatorLayout$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */