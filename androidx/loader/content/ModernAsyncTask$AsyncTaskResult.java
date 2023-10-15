package androidx.loader.content;

class AsyncTaskResult<Data> {
  final Data[] mData;
  
  final ModernAsyncTask mTask;
  
  AsyncTaskResult(ModernAsyncTask paramModernAsyncTask, Data... paramVarArgs) {
    this.mTask = paramModernAsyncTask;
    this.mData = paramVarArgs;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\loader\content\ModernAsyncTask$AsyncTaskResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */