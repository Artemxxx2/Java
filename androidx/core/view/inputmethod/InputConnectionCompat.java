package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class InputConnectionCompat {
  private static final String COMMIT_CONTENT_ACTION = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
  
  private static final String COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
  
  private static final String COMMIT_CONTENT_CONTENT_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
  
  private static final String COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
  
  private static final String COMMIT_CONTENT_DESCRIPTION_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
  
  private static final String COMMIT_CONTENT_FLAGS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
  
  private static final String COMMIT_CONTENT_FLAGS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
  
  private static final String COMMIT_CONTENT_INTEROP_ACTION = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
  
  private static final String COMMIT_CONTENT_LINK_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
  
  private static final String COMMIT_CONTENT_LINK_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
  
  private static final String COMMIT_CONTENT_OPTS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
  
  private static final String COMMIT_CONTENT_OPTS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
  
  private static final String COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
  
  private static final String COMMIT_CONTENT_RESULT_RECEIVER_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
  
  public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;
  
  public static boolean commitContent(@NonNull InputConnection paramInputConnection, @NonNull EditorInfo paramEditorInfo, @NonNull InputContentInfoCompat paramInputContentInfoCompat, int paramInt, @Nullable Bundle paramBundle) {
    String str;
    ClipDescription clipDescription = paramInputContentInfoCompat.getDescription();
    String[] arrayOfString = EditorInfoCompat.getContentMimeTypes(paramEditorInfo);
    int i = arrayOfString.length;
    boolean bool = false;
    byte b = 0;
    while (true) {
      if (b < i) {
        if (clipDescription.hasMimeType(arrayOfString[b])) {
          b = 1;
          break;
        } 
        b++;
        continue;
      } 
      b = 0;
      break;
    } 
    if (b == 0)
      return false; 
    if (Build.VERSION.SDK_INT >= 25)
      return paramInputConnection.commitContent((InputContentInfo)paramInputContentInfoCompat.unwrap(), paramInt, paramBundle); 
    b = bool;
    switch (EditorInfoCompat.getProtocol(paramEditorInfo)) {
      default:
        return false;
      case 2:
        b = 1;
        break;
      case 3:
      case 4:
        break;
    } 
    Bundle bundle = new Bundle();
    if (b != 0) {
      str = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    } else {
      str = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    } 
    bundle.putParcelable(str, (Parcelable)paramInputContentInfoCompat.getContentUri());
    if (b != 0) {
      str = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    } else {
      str = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    } 
    bundle.putParcelable(str, (Parcelable)paramInputContentInfoCompat.getDescription());
    if (b != 0) {
      str = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    } else {
      str = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    } 
    bundle.putParcelable(str, (Parcelable)paramInputContentInfoCompat.getLinkUri());
    if (b != 0) {
      str = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    } else {
      str = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    } 
    bundle.putInt(str, paramInt);
    if (b != 0) {
      str = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    } else {
      str = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    } 
    bundle.putParcelable(str, (Parcelable)paramBundle);
    if (b != 0) {
      str = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    } else {
      str = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    } 
    return paramInputConnection.performPrivateCommand(str, bundle);
  }
  
  @NonNull
  public static InputConnection createWrapper(@NonNull InputConnection paramInputConnection, @NonNull EditorInfo paramEditorInfo, @NonNull final OnCommitContentListener listener) {
    if (paramInputConnection != null) {
      if (paramEditorInfo != null) {
        if (listener != null)
          return (InputConnection)((Build.VERSION.SDK_INT >= 25) ? new InputConnectionWrapper(paramInputConnection, false) {
              public boolean commitContent(InputContentInfo param1InputContentInfo, int param1Int, Bundle param1Bundle) {
                return listener.onCommitContent(InputContentInfoCompat.wrap(param1InputContentInfo), param1Int, param1Bundle) ? true : super.commitContent(param1InputContentInfo, param1Int, param1Bundle);
              }
            } : (((EditorInfoCompat.getContentMimeTypes(paramEditorInfo)).length == 0) ? paramInputConnection : new InputConnectionWrapper(paramInputConnection, false) {
              public boolean performPrivateCommand(String param1String, Bundle param1Bundle) {
                return InputConnectionCompat.handlePerformPrivateCommand(param1String, param1Bundle, listener) ? true : super.performPrivateCommand(param1String, param1Bundle);
              }
            })); 
        throw new IllegalArgumentException("onCommitContentListener must be non-null");
      } 
      throw new IllegalArgumentException("editorInfo must be non-null");
    } 
    throw new IllegalArgumentException("inputConnection must be non-null");
  }
  
  static boolean handlePerformPrivateCommand(@Nullable String paramString, @NonNull Bundle paramBundle, @NonNull OnCommitContentListener paramOnCommitContentListener) {
    boolean bool2;
    boolean bool1 = false;
    if (paramBundle == null)
      return false; 
    if (TextUtils.equals("androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", paramString)) {
      bool2 = false;
    } else if (TextUtils.equals("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", paramString)) {
      bool2 = true;
    } else {
      return false;
    } 
    if (bool2) {
      paramString = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    } else {
      paramString = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    } 
    try {
      ResultReceiver resultReceiver = (ResultReceiver)paramBundle.getParcelable(paramString);
      if (bool2) {
        paramString = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
      } else {
        paramString = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
      } 
    } finally {
      paramString = null;
    } 
    if (paramBundle != null)
      paramBundle.send(0, null); 
    throw paramString;
  }
  
  public static interface OnCommitContentListener {
    boolean onCommitContent(InputContentInfoCompat param1InputContentInfoCompat, int param1Int, Bundle param1Bundle);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\inputmethod\InputConnectionCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */