package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class HostCallbacks extends FragmentHostCallback<FragmentActivity> {
  public HostCallbacks() {
    super(paramFragmentActivity);
  }
  
  public void onAttachFragment(Fragment paramFragment) {
    FragmentActivity.this.onAttachFragment(paramFragment);
  }
  
  public void onDump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    FragmentActivity.this.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  @Nullable
  public View onFindViewById(int paramInt) {
    return FragmentActivity.this.findViewById(paramInt);
  }
  
  public FragmentActivity onGetHost() {
    return FragmentActivity.this;
  }
  
  public LayoutInflater onGetLayoutInflater() {
    return FragmentActivity.this.getLayoutInflater().cloneInContext((Context)FragmentActivity.this);
  }
  
  public int onGetWindowAnimations() {
    int i;
    Window window = FragmentActivity.this.getWindow();
    if (window == null) {
      i = 0;
    } else {
      i = (window.getAttributes()).windowAnimations;
    } 
    return i;
  }
  
  public boolean onHasView() {
    boolean bool;
    Window window = FragmentActivity.this.getWindow();
    if (window != null && window.peekDecorView() != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean onHasWindowAnimations() {
    boolean bool;
    if (FragmentActivity.this.getWindow() != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void onRequestPermissionsFromFragment(@NonNull Fragment paramFragment, @NonNull String[] paramArrayOfString, int paramInt) {
    FragmentActivity.this.requestPermissionsFromFragment(paramFragment, paramArrayOfString, paramInt);
  }
  
  public boolean onShouldSaveFragmentState(Fragment paramFragment) {
    return FragmentActivity.this.isFinishing() ^ true;
  }
  
  public boolean onShouldShowRequestPermissionRationale(@NonNull String paramString) {
    return ActivityCompat.shouldShowRequestPermissionRationale((Activity)FragmentActivity.this, paramString);
  }
  
  public void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt) {
    FragmentActivity.this.startActivityFromFragment(paramFragment, paramIntent, paramInt);
  }
  
  public void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, @Nullable Bundle paramBundle) {
    FragmentActivity.this.startActivityFromFragment(paramFragment, paramIntent, paramInt, paramBundle);
  }
  
  public void onStartIntentSenderFromFragment(Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle) throws IntentSender.SendIntentException {
    FragmentActivity.this.startIntentSenderFromFragment(paramFragment, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public void onSupportInvalidateOptionsMenu() {
    FragmentActivity.this.supportInvalidateOptionsMenu();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentActivity$HostCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */