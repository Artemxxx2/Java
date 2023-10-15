package androidx.viewpager.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.customview.view.AbsSavedState;

public class SavedState extends AbsSavedState {
  public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
      public ViewPager.SavedState createFromParcel(Parcel param2Parcel) {
        return new ViewPager.SavedState(param2Parcel, null);
      }
      
      public ViewPager.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
        return new ViewPager.SavedState(param2Parcel, param2ClassLoader);
      }
      
      public ViewPager.SavedState[] newArray(int param2Int) {
        return new ViewPager.SavedState[param2Int];
      }
    };
  
  Parcelable adapterState;
  
  ClassLoader loader;
  
  int position;
  
  SavedState(Parcel paramParcel, ClassLoader paramClassLoader) {
    super(paramParcel, paramClassLoader);
    ClassLoader classLoader = paramClassLoader;
    if (paramClassLoader == null)
      classLoader = getClass().getClassLoader(); 
    this.position = paramParcel.readInt();
    this.adapterState = paramParcel.readParcelable(classLoader);
    this.loader = classLoader;
  }
  
  public SavedState(@NonNull Parcelable paramParcelable) {
    super(paramParcelable);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("FragmentPager.SavedState{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" position=");
    stringBuilder.append(this.position);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.position);
    paramParcel.writeParcelable(this.adapterState, paramInt);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\viewpager\widget\ViewPager$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */