package androidx.core.widget;

class null implements Runnable {
  public void run() {
    ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
    contentLoadingProgressBar.mPostedShow = false;
    if (!contentLoadingProgressBar.mDismissed) {
      ContentLoadingProgressBar.this.mStartTime = System.currentTimeMillis();
      ContentLoadingProgressBar.this.setVisibility(0);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\widget\ContentLoadingProgressBar$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */