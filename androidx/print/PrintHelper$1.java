package androidx.print;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.IOException;

class null extends AsyncTask<Void, Void, Throwable> {
  protected Throwable doInBackground(Void... paramVarArgs) {
    try {
      if (cancellationSignal.isCanceled())
        return null; 
      PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument();
      this(PrintHelper.this.mContext, pdfAttributes);
      Bitmap bitmap = PrintHelper.convertBitmapForColorMode(bitmap, pdfAttributes.getColorMode());
      boolean bool = cancellationSignal.isCanceled();
      if (bool)
        return null; 
      try {
        RectF rectF;
        PdfDocument.Page page = printedPdfDocument.startPage(1);
        if (PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT) {
          rectF = new RectF();
          this(page.getInfo().getContentRect());
        } else {
          PrintedPdfDocument printedPdfDocument1 = new PrintedPdfDocument();
          this(PrintHelper.this.mContext, attributes);
          PdfDocument.Page page1 = printedPdfDocument1.startPage(1);
          rectF = new RectF();
          this(page1.getInfo().getContentRect());
          printedPdfDocument1.finishPage(page1);
          printedPdfDocument1.close();
        } 
        Matrix matrix = PrintHelper.getMatrix(bitmap.getWidth(), bitmap.getHeight(), rectF, fittingMode);
        if (!PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT) {
          matrix.postTranslate(rectF.left, rectF.top);
          page.getCanvas().clipRect(rectF);
        } 
        page.getCanvas().drawBitmap(bitmap, matrix, null);
        printedPdfDocument.finishPage(page);
        bool = cancellationSignal.isCanceled();
        if (bool)
          return null; 
        FileOutputStream fileOutputStream = new FileOutputStream();
        this(fileDescriptor.getFileDescriptor());
        printedPdfDocument.writeTo(fileOutputStream);
        return null;
      } finally {
        printedPdfDocument.close();
        ParcelFileDescriptor parcelFileDescriptor = fileDescriptor;
        if (parcelFileDescriptor != null)
          try {
            fileDescriptor.close();
          } catch (IOException iOException) {} 
        if (bitmap != bitmap)
          bitmap.recycle(); 
      } 
    } catch (Throwable null) {
      return null;
    } 
  }
  
  protected void onPostExecute(Throwable paramThrowable) {
    if (cancellationSignal.isCanceled()) {
      writeResultCallback.onWriteCancelled();
    } else if (paramThrowable == null) {
      writeResultCallback.onWriteFinished(new PageRange[] { PageRange.ALL_PAGES });
    } else {
      Log.e("PrintHelper", "Error writing printed content", paramThrowable);
      writeResultCallback.onWriteFailed(null);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\print\PrintHelper$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */