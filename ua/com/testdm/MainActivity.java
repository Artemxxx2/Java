package ua.com.testdm;

import android.os.Bundle;
import org.apache.cordova.CordovaActivity;

public class MainActivity extends CordovaActivity {
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if (paramBundle != null && paramBundle.getBoolean("cdvStartInBackground", false))
      moveTaskToBack(true); 
    loadUrl(this.launchUrl);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\\\ua\com\testdm\MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */