package org.apache.cordova.file;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;

class null implements Filesystem.ReadFileCallback {
  public void handleData(InputStream paramInputStream, String paramString) {
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      this();
      byte[] arrayOfByte = new byte[8192];
      while (true) {
        StringBuilder stringBuilder;
        int i = paramInputStream.read(arrayOfByte, 0, 8192);
        if (i <= 0) {
          PluginResult pluginResult;
          i = resultType;
          if (i != 1) {
            byte[] arrayOfByte1;
            switch (i) {
              default:
                arrayOfByte1 = Base64.encode(byteArrayOutputStream.toByteArray(), 2);
                stringBuilder = new StringBuilder();
                this();
                stringBuilder.append("data:");
                stringBuilder.append(paramString);
                stringBuilder.append(";base64,");
                paramString = new String();
                this(arrayOfByte1, "US-ASCII");
                stringBuilder.append(paramString);
                paramString = stringBuilder.toString();
                pluginResult = new PluginResult();
                this(PluginResult.Status.OK, paramString);
                break;
              case 7:
                pluginResult = new PluginResult(PluginResult.Status.OK, byteArrayOutputStream.toByteArray(), true);
                break;
              case 6:
                pluginResult = new PluginResult(PluginResult.Status.OK, byteArrayOutputStream.toByteArray());
                break;
            } 
          } else {
            pluginResult = new PluginResult(PluginResult.Status.OK, byteArrayOutputStream.toString(encoding));
          } 
          callbackContext.sendPluginResult(pluginResult);
          break;
        } 
        byteArrayOutputStream.write((byte[])stringBuilder, 0, i);
      } 
    } catch (IOException iOException) {
      LOG.d("FileUtils", iOException.getLocalizedMessage());
      callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION, FileUtils.NOT_READABLE_ERR));
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\FileUtils$26.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */