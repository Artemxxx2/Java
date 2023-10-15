package androidx.core.os;

import android.os.Parcel;
import androidx.annotation.NonNull;

public final class ParcelCompat {
  public static boolean readBoolean(@NonNull Parcel paramParcel) {
    boolean bool;
    if (paramParcel.readInt() != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static void writeBoolean(@NonNull Parcel paramParcel, boolean paramBoolean) {
    paramParcel.writeInt(paramBoolean);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\os\ParcelCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */