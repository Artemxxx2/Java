package androidx.print;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import androidx.annotation.RequiresApi;

@RequiresApi(19)
class PrintBitmapAdapter extends PrintDocumentAdapter {
  private PrintAttributes mAttributes;
  
  private final Bitmap mBitmap;
  
  private final PrintHelper.OnPrintFinishCallback mCallback;
  
  private final int mFittingMode;
  
  private final String mJobName;
  
  PrintBitmapAdapter(String paramString, int paramInt, Bitmap paramBitmap, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback) {
    this.mJobName = paramString;
    this.mFittingMode = paramInt;
    this.mBitmap = paramBitmap;
    this.mCallback = paramOnPrintFinishCallback;
  }
  
  public void onFinish() {
    PrintHelper.OnPrintFinishCallback onPrintFinishCallback = this.mCallback;
    if (onPrintFinishCallback != null)
      onPrintFinishCallback.onFinish(); 
  }
  
  public void onLayout(PrintAttributes paramPrintAttributes1, PrintAttributes paramPrintAttributes2, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback, Bundle paramBundle) {
    this.mAttributes = paramPrintAttributes2;
    paramLayoutResultCallback.onLayoutFinished((new PrintDocumentInfo.Builder(this.mJobName)).setContentType(1).setPageCount(1).build(), paramPrintAttributes2.equals(paramPrintAttributes1) ^ true);
  }
  
  public void onWrite(PageRange[] paramArrayOfPageRange, ParcelFileDescriptor paramParcelFileDescriptor, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback) {
    PrintHelper.this.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, paramParcelFileDescriptor, paramCancellationSignal, paramWriteResultCallback);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\print\PrintHelper$PrintBitmapAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */