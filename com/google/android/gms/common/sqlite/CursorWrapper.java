package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class CursorWrapper extends CursorWrapper implements CrossProcessCursor {
  private AbstractWindowedCursor zza;
  
  @KeepForSdk
  public CursorWrapper(@NonNull Cursor paramCursor) {
    super(paramCursor);
    for (byte b = 0; b < 10 && paramCursor instanceof CursorWrapper; b++)
      paramCursor = ((CursorWrapper)paramCursor).getWrappedCursor(); 
    if (paramCursor instanceof AbstractWindowedCursor) {
      this.zza = (AbstractWindowedCursor)paramCursor;
      return;
    } 
    throw new IllegalArgumentException("Unknown type: ".concat(String.valueOf(paramCursor.getClass().getName())));
  }
  
  @KeepForSdk
  public void fillWindow(int paramInt, @NonNull CursorWindow paramCursorWindow) {
    this.zza.fillWindow(paramInt, paramCursorWindow);
  }
  
  @Nullable
  @KeepForSdk
  public CursorWindow getWindow() {
    return this.zza.getWindow();
  }
  
  public final boolean onMove(int paramInt1, int paramInt2) {
    return this.zza.onMove(paramInt1, paramInt2);
  }
  
  @KeepForSdk
  public void setWindow(@Nullable CursorWindow paramCursorWindow) {
    this.zza.setWindow(paramCursorWindow);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\sqlite\CursorWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */