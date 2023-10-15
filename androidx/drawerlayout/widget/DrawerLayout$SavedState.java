package androidx.drawerlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.view.AbsSavedState;

public class SavedState extends AbsSavedState {
  public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
      public DrawerLayout.SavedState createFromParcel(Parcel param2Parcel) {
        return new DrawerLayout.SavedState(param2Parcel, null);
      }
      
      public DrawerLayout.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
        return new DrawerLayout.SavedState(param2Parcel, param2ClassLoader);
      }
      
      public DrawerLayout.SavedState[] newArray(int param2Int) {
        return new DrawerLayout.SavedState[param2Int];
      }
    };
  
  int lockModeEnd;
  
  int lockModeLeft;
  
  int lockModeRight;
  
  int lockModeStart;
  
  int openDrawerGravity = 0;
  
  public SavedState(@NonNull Parcel paramParcel, @Nullable ClassLoader paramClassLoader) {
    super(paramParcel, paramClassLoader);
    this.openDrawerGravity = paramParcel.readInt();
    this.lockModeLeft = paramParcel.readInt();
    this.lockModeRight = paramParcel.readInt();
    this.lockModeStart = paramParcel.readInt();
    this.lockModeEnd = paramParcel.readInt();
  }
  
  public SavedState(@NonNull Parcelable paramParcelable) {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.openDrawerGravity);
    paramParcel.writeInt(this.lockModeLeft);
    paramParcel.writeInt(this.lockModeRight);
    paramParcel.writeInt(this.lockModeStart);
    paramParcel.writeInt(this.lockModeEnd);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\drawerlayout\widget\DrawerLayout$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */