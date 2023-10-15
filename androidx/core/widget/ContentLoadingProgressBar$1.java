package androidx.core.widget;

class null implements Runnable {
  public void run() {
    ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
    contentLoadingProgressBar.mPostedHide = false;
    contentLoadingProgressBar.mStartTime = -1L;
    contentLoadingProgressBar.setVisibility(8);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\widget\ContentLoadingProgressBar$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */