package androidx.print;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import androidx.annotation.RequiresApi;
import java.io.FileNotFoundException;

@RequiresApi(19)
class PrintUriAdapter extends PrintDocumentAdapter {
  PrintAttributes mAttributes;
  
  Bitmap mBitmap;
  
  final PrintHelper.OnPrintFinishCallback mCallback;
  
  final int mFittingMode;
  
  final Uri mImageFile;
  
  final String mJobName;
  
  AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;
  
  PrintUriAdapter(String paramString, Uri paramUri, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback, int paramInt) {
    this.mJobName = paramString;
    this.mImageFile = paramUri;
    this.mCallback = paramOnPrintFinishCallback;
    this.mFittingMode = paramInt;
    this.mBitmap = null;
  }
  
  void cancelLoad() {
    synchronized (PrintHelper.this.mLock) {
      if (PrintHelper.this.mDecodeOptions != null) {
        if (Build.VERSION.SDK_INT < 24)
          PrintHelper.this.mDecodeOptions.requestCancelDecode(); 
        PrintHelper.this.mDecodeOptions = null;
      } 
      return;
    } 
  }
  
  public void onFinish() {
    super.onFinish();
    cancelLoad();
    AsyncTask<Uri, Boolean, Bitmap> asyncTask = this.mLoadBitmap;
    if (asyncTask != null)
      asyncTask.cancel(true); 
    PrintHelper.OnPrintFinishCallback onPrintFinishCallback = this.mCallback;
    if (onPrintFinishCallback != null)
      onPrintFinishCallback.onFinish(); 
    Bitmap bitmap = this.mBitmap;
    if (bitmap != null) {
      bitmap.recycle();
      this.mBitmap = null;
    } 
  }
  
  public void onLayout(PrintAttributes paramPrintAttributes1, PrintAttributes paramPrintAttributes2, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback, Bundle paramBundle) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: putfield mAttributes : Landroid/print/PrintAttributes;
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_3
    //   10: invokevirtual isCanceled : ()Z
    //   13: ifeq -> 22
    //   16: aload #4
    //   18: invokevirtual onLayoutCancelled : ()V
    //   21: return
    //   22: aload_0
    //   23: getfield mBitmap : Landroid/graphics/Bitmap;
    //   26: ifnull -> 64
    //   29: aload #4
    //   31: new android/print/PrintDocumentInfo$Builder
    //   34: dup
    //   35: aload_0
    //   36: getfield mJobName : Ljava/lang/String;
    //   39: invokespecial <init> : (Ljava/lang/String;)V
    //   42: iconst_1
    //   43: invokevirtual setContentType : (I)Landroid/print/PrintDocumentInfo$Builder;
    //   46: iconst_1
    //   47: invokevirtual setPageCount : (I)Landroid/print/PrintDocumentInfo$Builder;
    //   50: invokevirtual build : ()Landroid/print/PrintDocumentInfo;
    //   53: aload_2
    //   54: aload_1
    //   55: invokevirtual equals : (Ljava/lang/Object;)Z
    //   58: iconst_1
    //   59: ixor
    //   60: invokevirtual onLayoutFinished : (Landroid/print/PrintDocumentInfo;Z)V
    //   63: return
    //   64: aload_0
    //   65: new androidx/print/PrintHelper$PrintUriAdapter$1
    //   68: dup
    //   69: aload_0
    //   70: aload_3
    //   71: aload_2
    //   72: aload_1
    //   73: aload #4
    //   75: invokespecial <init> : (Landroidx/print/PrintHelper$PrintUriAdapter;Landroid/os/CancellationSignal;Landroid/print/PrintAttributes;Landroid/print/PrintAttributes;Landroid/print/PrintDocumentAdapter$LayoutResultCallback;)V
    //   78: iconst_0
    //   79: anewarray android/net/Uri
    //   82: invokevirtual execute : ([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   85: putfield mLoadBitmap : Landroid/os/AsyncTask;
    //   88: return
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	89	finally
    //   90	92	89	finally
  }
  
  public void onWrite(PageRange[] paramArrayOfPageRange, ParcelFileDescriptor paramParcelFileDescriptor, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback) {
    PrintHelper.this.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, paramParcelFileDescriptor, paramCancellationSignal, paramWriteResultCallback);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\print\PrintHelper$PrintUriAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */