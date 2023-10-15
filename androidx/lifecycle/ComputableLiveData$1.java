package androidx.lifecycle;

class null extends LiveData<T> {
  protected void onActive() {
    ComputableLiveData.this.mExecutor.execute(ComputableLiveData.this.mRefreshRunnable);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\lifecycle\ComputableLiveData$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */