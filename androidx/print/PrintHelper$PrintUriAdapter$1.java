package androidx.print;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import java.io.FileNotFoundException;

class null extends AsyncTask<Uri, Boolean, Bitmap> {
  protected Bitmap doInBackground(Uri... paramVarArgs) {
    try {
      return this.this$1.this$0.loadConstrainedBitmap(PrintHelper.PrintUriAdapter.this.mImageFile);
    } catch (FileNotFoundException fileNotFoundException) {
      return null;
    } 
  }
  
  protected void onCancelled(Bitmap paramBitmap) {
    layoutResultCallback.onLayoutCancelled();
    PrintHelper.PrintUriAdapter.this.mLoadBitmap = null;
  }
  
  protected void onPostExecute(Bitmap paramBitmap) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial onPostExecute : (Ljava/lang/Object;)V
    //   5: aload_1
    //   6: astore_2
    //   7: aload_1
    //   8: ifnull -> 106
    //   11: getstatic androidx/print/PrintHelper.PRINT_ACTIVITY_RESPECTS_ORIENTATION : Z
    //   14: ifeq -> 32
    //   17: aload_1
    //   18: astore_2
    //   19: aload_0
    //   20: getfield this$1 : Landroidx/print/PrintHelper$PrintUriAdapter;
    //   23: getfield this$0 : Landroidx/print/PrintHelper;
    //   26: getfield mOrientation : I
    //   29: ifne -> 106
    //   32: aload_0
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield this$1 : Landroidx/print/PrintHelper$PrintUriAdapter;
    //   38: getfield mAttributes : Landroid/print/PrintAttributes;
    //   41: invokevirtual getMediaSize : ()Landroid/print/PrintAttributes$MediaSize;
    //   44: astore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: astore_2
    //   49: aload_3
    //   50: ifnull -> 106
    //   53: aload_1
    //   54: astore_2
    //   55: aload_3
    //   56: invokevirtual isPortrait : ()Z
    //   59: aload_1
    //   60: invokestatic isPortrait : (Landroid/graphics/Bitmap;)Z
    //   63: if_icmpeq -> 106
    //   66: new android/graphics/Matrix
    //   69: dup
    //   70: invokespecial <init> : ()V
    //   73: astore_2
    //   74: aload_2
    //   75: ldc 90.0
    //   77: invokevirtual postRotate : (F)Z
    //   80: pop
    //   81: aload_1
    //   82: iconst_0
    //   83: iconst_0
    //   84: aload_1
    //   85: invokevirtual getWidth : ()I
    //   88: aload_1
    //   89: invokevirtual getHeight : ()I
    //   92: aload_2
    //   93: iconst_1
    //   94: invokestatic createBitmap : (Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   97: astore_2
    //   98: goto -> 106
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: aload_0
    //   107: getfield this$1 : Landroidx/print/PrintHelper$PrintUriAdapter;
    //   110: astore_1
    //   111: aload_1
    //   112: aload_2
    //   113: putfield mBitmap : Landroid/graphics/Bitmap;
    //   116: aload_2
    //   117: ifnull -> 171
    //   120: new android/print/PrintDocumentInfo$Builder
    //   123: dup
    //   124: aload_1
    //   125: getfield mJobName : Ljava/lang/String;
    //   128: invokespecial <init> : (Ljava/lang/String;)V
    //   131: iconst_1
    //   132: invokevirtual setContentType : (I)Landroid/print/PrintDocumentInfo$Builder;
    //   135: iconst_1
    //   136: invokevirtual setPageCount : (I)Landroid/print/PrintDocumentInfo$Builder;
    //   139: invokevirtual build : ()Landroid/print/PrintDocumentInfo;
    //   142: astore_1
    //   143: aload_0
    //   144: getfield val$newPrintAttributes : Landroid/print/PrintAttributes;
    //   147: aload_0
    //   148: getfield val$oldPrintAttributes : Landroid/print/PrintAttributes;
    //   151: invokevirtual equals : (Ljava/lang/Object;)Z
    //   154: istore #4
    //   156: aload_0
    //   157: getfield val$layoutResultCallback : Landroid/print/PrintDocumentAdapter$LayoutResultCallback;
    //   160: aload_1
    //   161: iconst_1
    //   162: iload #4
    //   164: ixor
    //   165: invokevirtual onLayoutFinished : (Landroid/print/PrintDocumentInfo;Z)V
    //   168: goto -> 179
    //   171: aload_0
    //   172: getfield val$layoutResultCallback : Landroid/print/PrintDocumentAdapter$LayoutResultCallback;
    //   175: aconst_null
    //   176: invokevirtual onLayoutFailed : (Ljava/lang/CharSequence;)V
    //   179: aload_0
    //   180: getfield this$1 : Landroidx/print/PrintHelper$PrintUriAdapter;
    //   183: aconst_null
    //   184: putfield mLoadBitmap : Landroid/os/AsyncTask;
    //   187: return
    // Exception table:
    //   from	to	target	type
    //   34	47	101	finally
    //   102	104	101	finally
  }
  
  protected void onPreExecute() {
    cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() {
          public void onCancel() {
            PrintHelper.PrintUriAdapter.this.cancelLoad();
            PrintHelper.PrintUriAdapter.null.this.cancel(false);
          }
        });
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\print\PrintHelper$PrintUriAdapter$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */