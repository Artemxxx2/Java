package org.apache.cordova.file;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PermissionHelper;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FileUtils extends CordovaPlugin {
  public static int ABORT_ERR = 3;
  
  public static final int ACTION_GET_DIRECTORY = 2;
  
  public static final int ACTION_GET_FILE = 0;
  
  public static final int ACTION_WRITE = 1;
  
  public static int ENCODING_ERR = 5;
  
  public static int INVALID_MODIFICATION_ERR = 9;
  
  public static int INVALID_STATE_ERR = 7;
  
  private static final String LOG_TAG = "FileUtils";
  
  public static int NOT_FOUND_ERR = 1;
  
  public static int NOT_READABLE_ERR = 4;
  
  public static int NO_MODIFICATION_ALLOWED_ERR = 6;
  
  public static int PATH_EXISTS_ERR = 12;
  
  public static int QUOTA_EXCEEDED_ERR = 10;
  
  public static final int READ = 4;
  
  public static int SECURITY_ERR = 2;
  
  public static int SYNTAX_ERR = 8;
  
  public static int TYPE_MISMATCH_ERR = 11;
  
  public static int UNKNOWN_ERR = 1000;
  
  public static final int WRITE = 3;
  
  private static FileUtils filePlugin;
  
  private boolean configured = false;
  
  private ArrayList<Filesystem> filesystems;
  
  private PendingRequests pendingRequests;
  
  private String[] permissions = new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" };
  
  private Filesystem filesystemForName(String paramString) {
    for (Filesystem filesystem : this.filesystems) {
      if (filesystem != null && filesystem.name != null && filesystem.name.equals(paramString))
        return filesystem; 
    } 
    return null;
  }
  
  private Filesystem filesystemForURL(LocalFilesystemURL paramLocalFilesystemURL) {
    return (paramLocalFilesystemURL == null) ? null : filesystemForName(paramLocalFilesystemURL.fsName);
  }
  
  @Deprecated
  public static JSONObject getEntry(File paramFile) throws JSONException {
    return (getFilePlugin() != null) ? getFilePlugin().getEntryForFile(paramFile) : null;
  }
  
  private JSONObject getFile(String paramString1, String paramString2, JSONObject paramJSONObject, boolean paramBoolean) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException {
    try {
      LocalFilesystemURL localFilesystemURL = LocalFilesystemURL.parse(paramString1);
      Filesystem filesystem = filesystemForURL(localFilesystemURL);
      if (filesystem != null)
        return filesystem.getFileForLocalURL(localFilesystemURL, paramString2, paramJSONObject, paramBoolean); 
      MalformedURLException malformedURLException = new MalformedURLException();
      this("No installed handlers for this URL");
      throw malformedURLException;
    } catch (IllegalArgumentException illegalArgumentException) {
      MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
      malformedURLException.initCause(illegalArgumentException);
      throw malformedURLException;
    } 
  }
  
  private JSONObject getFileMetadata(String paramString) throws FileNotFoundException, JSONException, MalformedURLException {
    try {
      LocalFilesystemURL localFilesystemURL = LocalFilesystemURL.parse(paramString);
      Filesystem filesystem = filesystemForURL(localFilesystemURL);
      if (filesystem != null)
        return filesystem.getFileMetadataForLocalURL(localFilesystemURL); 
      MalformedURLException malformedURLException = new MalformedURLException();
      this("No installed handlers for this URL");
      throw malformedURLException;
    } catch (IllegalArgumentException illegalArgumentException) {
      MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
      malformedURLException.initCause(illegalArgumentException);
      throw malformedURLException;
    } 
  }
  
  public static FileUtils getFilePlugin() {
    return filePlugin;
  }
  
  private JSONObject getParent(String paramString) throws JSONException, IOException {
    try {
      LocalFilesystemURL localFilesystemURL = LocalFilesystemURL.parse(paramString);
      Filesystem filesystem = filesystemForURL(localFilesystemURL);
      if (filesystem != null)
        return filesystem.getParentForLocalURL(localFilesystemURL); 
      MalformedURLException malformedURLException = new MalformedURLException();
      this("No installed handlers for this URL");
      throw malformedURLException;
    } catch (IllegalArgumentException illegalArgumentException) {
      MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
      malformedURLException.initCause(illegalArgumentException);
      throw malformedURLException;
    } 
  }
  
  private void getReadPermission(String paramString, int paramInt, CallbackContext paramCallbackContext) {
    PermissionHelper.requestPermission(this, this.pendingRequests.createRequest(paramString, paramInt, paramCallbackContext), "android.permission.READ_EXTERNAL_STORAGE");
  }
  
  private void getWritePermission(String paramString, int paramInt, CallbackContext paramCallbackContext) {
    PermissionHelper.requestPermission(this, this.pendingRequests.createRequest(paramString, paramInt, paramCallbackContext), "android.permission.WRITE_EXTERNAL_STORAGE");
  }
  
  private boolean hasReadPermission() {
    return PermissionHelper.hasPermission(this, "android.permission.READ_EXTERNAL_STORAGE");
  }
  
  private boolean hasWritePermission() {
    return PermissionHelper.hasPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
  }
  
  private boolean needPermission(String paramString, int paramInt) throws JSONException {
    JSONObject jSONObject = requestAllPaths();
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add(jSONObject.getString("applicationDirectory"));
    arrayList.add(jSONObject.getString("applicationStorageDirectory"));
    if (jSONObject.has("externalApplicationStorageDirectory"))
      arrayList.add(jSONObject.getString("externalApplicationStorageDirectory")); 
    if (paramInt == 4 && hasReadPermission())
      return false; 
    if (paramInt == 3 && hasWritePermission())
      return false; 
    Iterator<String> iterator = arrayList.iterator();
    while (iterator.hasNext()) {
      if (paramString.startsWith(iterator.next()))
        return false; 
    } 
    return true;
  }
  
  private JSONArray readEntries(String paramString) throws FileNotFoundException, JSONException, MalformedURLException {
    try {
      LocalFilesystemURL localFilesystemURL = LocalFilesystemURL.parse(paramString);
      Filesystem filesystem = filesystemForURL(localFilesystemURL);
      if (filesystem != null)
        return filesystem.readEntriesAtLocalURL(localFilesystemURL); 
      MalformedURLException malformedURLException = new MalformedURLException();
      this("No installed handlers for this URL");
      throw malformedURLException;
    } catch (IllegalArgumentException illegalArgumentException) {
      MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
      malformedURLException.initCause(illegalArgumentException);
      throw malformedURLException;
    } 
  }
  
  private boolean remove(String paramString) throws NoModificationAllowedException, InvalidModificationException, MalformedURLException {
    try {
      LocalFilesystemURL localFilesystemURL = LocalFilesystemURL.parse(paramString);
      if (!"".equals(localFilesystemURL.path) && !"/".equals(localFilesystemURL.path)) {
        Filesystem filesystem = filesystemForURL(localFilesystemURL);
        if (filesystem != null)
          return filesystem.removeFileAtLocalURL(localFilesystemURL); 
        MalformedURLException malformedURLException = new MalformedURLException();
        this("No installed handlers for this URL");
        throw malformedURLException;
      } 
      NoModificationAllowedException noModificationAllowedException = new NoModificationAllowedException();
      this("You can't delete the root directory");
      throw noModificationAllowedException;
    } catch (IllegalArgumentException illegalArgumentException) {
      MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
      malformedURLException.initCause(illegalArgumentException);
      throw malformedURLException;
    } 
  }
  
  private boolean removeRecursively(String paramString) throws FileExistsException, NoModificationAllowedException, MalformedURLException {
    try {
      LocalFilesystemURL localFilesystemURL = LocalFilesystemURL.parse(paramString);
      if (!"".equals(localFilesystemURL.path) && !"/".equals(localFilesystemURL.path)) {
        Filesystem filesystem = filesystemForURL(localFilesystemURL);
        if (filesystem != null)
          return filesystem.recursiveRemoveFileAtLocalURL(localFilesystemURL); 
        MalformedURLException malformedURLException = new MalformedURLException();
        this("No installed handlers for this URL");
        throw malformedURLException;
      } 
      NoModificationAllowedException noModificationAllowedException = new NoModificationAllowedException();
      this("You can't delete the root directory");
      throw noModificationAllowedException;
    } catch (IllegalArgumentException illegalArgumentException) {
      MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
      malformedURLException.initCause(illegalArgumentException);
      throw malformedURLException;
    } 
  }
  
  private JSONArray requestAllFileSystems() throws IOException, JSONException {
    JSONArray jSONArray = new JSONArray();
    Iterator<Filesystem> iterator = this.filesystems.iterator();
    while (iterator.hasNext())
      jSONArray.put(((Filesystem)iterator.next()).getRootEntry()); 
    return jSONArray;
  }
  
  private JSONObject requestAllPaths() throws JSONException {
    Activity activity = this.cordova.getActivity();
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("applicationDirectory", "file:///android_asset/");
    jSONObject.put("applicationStorageDirectory", toDirUrl(activity.getFilesDir().getParentFile()));
    jSONObject.put("dataDirectory", toDirUrl(activity.getFilesDir()));
    jSONObject.put("cacheDirectory", toDirUrl(activity.getCacheDir()));
    if (Environment.getExternalStorageState().equals("mounted"))
      try {
        jSONObject.put("externalApplicationStorageDirectory", toDirUrl(activity.getExternalFilesDir(null).getParentFile()));
        jSONObject.put("externalDataDirectory", toDirUrl(activity.getExternalFilesDir(null)));
        jSONObject.put("externalCacheDirectory", toDirUrl(activity.getExternalCacheDir()));
        jSONObject.put("externalRootDirectory", toDirUrl(Environment.getExternalStorageDirectory()));
      } catch (NullPointerException nullPointerException) {
        LOG.d("FileUtils", "Unable to access these paths, most liklely due to USB storage");
      }  
    return jSONObject;
  }
  
  private void requestFileSystem(int paramInt, long paramLong, CallbackContext paramCallbackContext) throws JSONException {
    try {
      Filesystem filesystem = this.filesystems.get(paramInt);
    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
      arrayIndexOutOfBoundsException = null;
    } 
    if (arrayIndexOutOfBoundsException == null) {
      paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, NOT_FOUND_ERR));
    } else {
      long l = 0L;
      if (paramLong > 0L)
        l = arrayIndexOutOfBoundsException.getFreeSpaceInBytes(); 
      if (l < paramLong) {
        paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, QUOTA_EXCEEDED_ERR));
      } else {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", ((Filesystem)arrayIndexOutOfBoundsException).name);
        jSONObject.put("root", arrayIndexOutOfBoundsException.getRootEntry());
        paramCallbackContext.success(jSONObject);
      } 
    } 
  }
  
  private JSONObject resolveLocalFileSystemURI(String paramString) throws IOException, JSONException {
    if (paramString != null) {
      Uri uri = Uri.parse(paramString);
      boolean bool = false;
      LocalFilesystemURL localFilesystemURL2 = LocalFilesystemURL.parse(uri);
      LocalFilesystemURL localFilesystemURL1 = localFilesystemURL2;
      if (localFilesystemURL2 == null) {
        localFilesystemURL1 = resolveNativeUri(uri);
        bool = true;
      } 
      try {
        Filesystem filesystem = filesystemForURL(localFilesystemURL1);
        if (filesystem != null) {
          if (filesystem.exists(localFilesystemURL1)) {
            localFilesystemURL2 = localFilesystemURL1;
            if (!bool)
              localFilesystemURL2 = filesystem.toLocalUri(filesystem.toNativeUri(localFilesystemURL1)); 
            return filesystem.getEntryForLocalURL(localFilesystemURL2);
          } 
          throw new FileNotFoundException();
        } 
        MalformedURLException malformedURLException = new MalformedURLException();
        this("No installed handlers for this URL");
        throw malformedURLException;
      } catch (IllegalArgumentException illegalArgumentException) {
        MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
        malformedURLException.initCause(illegalArgumentException);
        throw malformedURLException;
      } 
    } 
    throw new MalformedURLException("Unrecognized filesystem URL");
  }
  
  private void threadhelper(final FileOp f, final String rawArgs, final CallbackContext callbackContext) {
    this.cordova.getThreadPool().execute(new Runnable() {
          public void run() {
            try {
              JSONArray jSONArray = new JSONArray();
              this(rawArgs);
              f.run(jSONArray);
            } catch (Exception exception) {
              boolean bool = exception instanceof EncodingException;
              if (bool) {
                callbackContext.error(FileUtils.ENCODING_ERR);
              } else if (exception instanceof FileNotFoundException) {
                callbackContext.error(FileUtils.NOT_FOUND_ERR);
              } else if (exception instanceof FileExistsException) {
                callbackContext.error(FileUtils.PATH_EXISTS_ERR);
              } else if (exception instanceof NoModificationAllowedException) {
                callbackContext.error(FileUtils.NO_MODIFICATION_ALLOWED_ERR);
              } else if (exception instanceof InvalidModificationException) {
                callbackContext.error(FileUtils.INVALID_MODIFICATION_ERR);
              } else if (exception instanceof MalformedURLException) {
                callbackContext.error(FileUtils.ENCODING_ERR);
              } else if (exception instanceof IOException) {
                callbackContext.error(FileUtils.INVALID_MODIFICATION_ERR);
              } else if (bool) {
                callbackContext.error(FileUtils.ENCODING_ERR);
              } else if (exception instanceof TypeMismatchException) {
                callbackContext.error(FileUtils.TYPE_MISMATCH_ERR);
              } else if (exception instanceof JSONException) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
              } else if (exception instanceof SecurityException) {
                callbackContext.error(FileUtils.SECURITY_ERR);
              } else {
                exception.printStackTrace();
                callbackContext.error(FileUtils.UNKNOWN_ERR);
              } 
            } 
          }
        });
  }
  
  private static String toDirUrl(File paramFile) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Uri.fromFile(paramFile).toString());
    stringBuilder.append('/');
    return stringBuilder.toString();
  }
  
  private JSONObject transferTo(String paramString1, String paramString2, String paramString3, boolean paramBoolean) throws JSONException, NoModificationAllowedException, IOException, InvalidModificationException, EncodingException, FileExistsException {
    if (paramString1 != null && paramString2 != null) {
      LocalFilesystemURL localFilesystemURL1 = LocalFilesystemURL.parse(paramString1);
      LocalFilesystemURL localFilesystemURL2 = LocalFilesystemURL.parse(paramString2);
      Filesystem filesystem1 = filesystemForURL(localFilesystemURL1);
      Filesystem filesystem2 = filesystemForURL(localFilesystemURL2);
      if (paramString3 == null || !paramString3.contains(":"))
        return filesystem2.copyFileToURL(localFilesystemURL2, paramString3, filesystem1, localFilesystemURL1, paramBoolean); 
      throw new EncodingException("Bad file name");
    } 
    throw new FileNotFoundException();
  }
  
  private long truncateFile(String paramString, long paramLong) throws FileNotFoundException, IOException, NoModificationAllowedException {
    try {
      LocalFilesystemURL localFilesystemURL = LocalFilesystemURL.parse(paramString);
      Filesystem filesystem = filesystemForURL(localFilesystemURL);
      if (filesystem != null)
        return filesystem.truncateFileAtURL(localFilesystemURL, paramLong); 
      MalformedURLException malformedURLException = new MalformedURLException();
      this("No installed handlers for this URL");
      throw malformedURLException;
    } catch (IllegalArgumentException illegalArgumentException) {
      MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
      malformedURLException.initCause(illegalArgumentException);
      throw malformedURLException;
    } 
  }
  
  public boolean execute(String paramString1, final String rawArgs, final CallbackContext callbackContext) {
    if (!this.configured) {
      callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, "File plugin is not configured. Please see the README.md file for details on how to update config.xml"));
      return true;
    } 
    if (paramString1.equals("testSaveLocationExists")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) {
              boolean bool = DirectoryManager.testSaveLocationExists();
              callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, bool));
            }
          }rawArgs, callbackContext);
    } else if (paramString1.equals("getFreeDiskSpace")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) {
              long l = DirectoryManager.getFreeExternalStorageSpace();
              callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, (float)l));
            }
          }rawArgs, callbackContext);
    } else if (paramString1.equals("testFileExists")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws JSONException {
              boolean bool = DirectoryManager.testFileExists(param1JSONArray.getString(0));
              callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, bool));
            }
          }rawArgs, callbackContext);
    } else if (paramString1.equals("testDirectoryExists")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws JSONException {
              boolean bool = DirectoryManager.testFileExists(param1JSONArray.getString(0));
              callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, bool));
            }
          }rawArgs, callbackContext);
    } else if (paramString1.equals("readAsText")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws JSONException, MalformedURLException {
              String str2 = param1JSONArray.getString(1);
              int i = param1JSONArray.getInt(2);
              int j = param1JSONArray.getInt(3);
              String str1 = param1JSONArray.getString(0);
              FileUtils.this.readFileAs(str1, i, j, callbackContext, str2, 1);
            }
          }rawArgs, callbackContext);
    } else if (paramString1.equals("readAsDataURL")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws JSONException, MalformedURLException {
              int i = param1JSONArray.getInt(1);
              int j = param1JSONArray.getInt(2);
              String str = param1JSONArray.getString(0);
              FileUtils.this.readFileAs(str, i, j, callbackContext, (String)null, -1);
            }
          }rawArgs, callbackContext);
    } else if (paramString1.equals("readAsArrayBuffer")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws JSONException, MalformedURLException {
              int i = param1JSONArray.getInt(1);
              int j = param1JSONArray.getInt(2);
              String str = param1JSONArray.getString(0);
              FileUtils.this.readFileAs(str, i, j, callbackContext, (String)null, 6);
            }
          }rawArgs, callbackContext);
    } else if (paramString1.equals("readAsBinaryString")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws JSONException, MalformedURLException {
              int i = param1JSONArray.getInt(1);
              int j = param1JSONArray.getInt(2);
              String str = param1JSONArray.getString(0);
              FileUtils.this.readFileAs(str, i, j, callbackContext, (String)null, 7);
            }
          }rawArgs, callbackContext);
    } else if (paramString1.equals("write")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws JSONException, FileNotFoundException, IOException, NoModificationAllowedException {
              String str1 = param1JSONArray.getString(0);
              String str2 = FileUtils.this.resolveLocalFileSystemURI(str1).getString("nativeURL");
              String str3 = param1JSONArray.getString(1);
              int i = param1JSONArray.getInt(2);
              boolean bool = param1JSONArray.getBoolean(3);
              if (FileUtils.this.needPermission(str2, 3)) {
                FileUtils.this.getWritePermission(rawArgs, 1, callbackContext);
              } else {
                long l = FileUtils.this.write(str1, str3, i, Boolean.valueOf(bool).booleanValue());
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, (float)l));
              } 
            }
          }rawArgs, callbackContext);
    } else if (paramString1.equals("truncate")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws JSONException, FileNotFoundException, IOException, NoModificationAllowedException {
              String str = param1JSONArray.getString(0);
              int i = param1JSONArray.getInt(1);
              long l = FileUtils.this.truncateFile(str, i);
              callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, (float)l));
            }
          }rawArgs, callbackContext);
    } else if (paramString1.equals("requestAllFileSystems")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws IOException, JSONException {
              callbackContext.success(FileUtils.this.requestAllFileSystems());
            }
          },  rawArgs, callbackContext);
    } else if (paramString1.equals("requestAllPaths")) {
      this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
              try {
                callbackContext.success(FileUtils.this.requestAllPaths());
              } catch (JSONException jSONException) {
                jSONException.printStackTrace();
              } 
            }
          });
    } else if (paramString1.equals("requestFileSystem")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws JSONException {
              int i = param1JSONArray.getInt(0);
              long l = param1JSONArray.optLong(1);
              FileUtils.this.requestFileSystem(i, l, callbackContext);
            }
          }rawArgs, callbackContext);
    } else if (paramString1.equals("resolveLocalFileSystemURI")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws IOException, JSONException {
              String str = param1JSONArray.getString(0);
              JSONObject jSONObject = FileUtils.this.resolveLocalFileSystemURI(str);
              callbackContext.success(jSONObject);
            }
          },  rawArgs, callbackContext);
    } else if (paramString1.equals("getFileMetadata")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws FileNotFoundException, JSONException, MalformedURLException {
              String str = param1JSONArray.getString(0);
              JSONObject jSONObject = FileUtils.this.getFileMetadata(str);
              callbackContext.success(jSONObject);
            }
          },  rawArgs, callbackContext);
    } else if (paramString1.equals("getParent")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws JSONException, IOException {
              String str = param1JSONArray.getString(0);
              JSONObject jSONObject = FileUtils.this.getParent(str);
              callbackContext.success(jSONObject);
            }
          },  rawArgs, callbackContext);
    } else if (paramString1.equals("getDirectory")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException {
              boolean bool = false;
              String str1 = param1JSONArray.getString(0);
              String str2 = param1JSONArray.getString(1);
              String str3 = FileUtils.this.resolveLocalFileSystemURI(str1).getString("nativeURL");
              if (!param1JSONArray.isNull(2))
                bool = param1JSONArray.getJSONObject(2).optBoolean("create", false); 
              if (bool && FileUtils.this.needPermission(str3, 3)) {
                FileUtils.this.getWritePermission(rawArgs, 2, callbackContext);
              } else if (!bool && FileUtils.this.needPermission(str3, 4)) {
                FileUtils.this.getReadPermission(rawArgs, 2, callbackContext);
              } else {
                JSONObject jSONObject = FileUtils.this.getFile(str1, str2, param1JSONArray.optJSONObject(2), true);
                callbackContext.success(jSONObject);
              } 
            }
          }rawArgs, callbackContext);
    } else if (paramString1.equals("getFile")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException {
              boolean bool;
              String str1 = param1JSONArray.getString(0);
              String str2 = param1JSONArray.getString(1);
              String str3 = FileUtils.this.resolveLocalFileSystemURI(str1).getString("nativeURL");
              if (param1JSONArray.isNull(2)) {
                bool = false;
              } else {
                bool = param1JSONArray.getJSONObject(2).optBoolean("create", false);
              } 
              if (bool && FileUtils.this.needPermission(str3, 3)) {
                FileUtils.this.getWritePermission(rawArgs, 0, callbackContext);
              } else if (!bool && FileUtils.this.needPermission(str3, 4)) {
                FileUtils.this.getReadPermission(rawArgs, 0, callbackContext);
              } else {
                JSONObject jSONObject = FileUtils.this.getFile(str1, str2, param1JSONArray.optJSONObject(2), false);
                callbackContext.success(jSONObject);
              } 
            }
          }rawArgs, callbackContext);
    } else if (paramString1.equals("remove")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws JSONException, NoModificationAllowedException, InvalidModificationException, MalformedURLException {
              String str = param1JSONArray.getString(0);
              if (FileUtils.this.remove(str)) {
                callbackContext.success();
              } else {
                callbackContext.error(FileUtils.NO_MODIFICATION_ALLOWED_ERR);
              } 
            }
          },  rawArgs, callbackContext);
    } else if (paramString1.equals("removeRecursively")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws JSONException, FileExistsException, MalformedURLException, NoModificationAllowedException {
              String str = param1JSONArray.getString(0);
              if (FileUtils.this.removeRecursively(str)) {
                callbackContext.success();
              } else {
                callbackContext.error(FileUtils.NO_MODIFICATION_ALLOWED_ERR);
              } 
            }
          },  rawArgs, callbackContext);
    } else if (paramString1.equals("moveTo")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws JSONException, NoModificationAllowedException, IOException, InvalidModificationException, EncodingException, FileExistsException {
              String str2 = param1JSONArray.getString(0);
              String str3 = param1JSONArray.getString(1);
              String str1 = param1JSONArray.getString(2);
              JSONObject jSONObject = FileUtils.this.transferTo(str2, str3, str1, true);
              callbackContext.success(jSONObject);
            }
          }rawArgs, callbackContext);
    } else if (paramString1.equals("copyTo")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws JSONException, NoModificationAllowedException, IOException, InvalidModificationException, EncodingException, FileExistsException {
              String str2 = param1JSONArray.getString(0);
              String str3 = param1JSONArray.getString(1);
              String str1 = param1JSONArray.getString(2);
              JSONObject jSONObject = FileUtils.this.transferTo(str2, str3, str1, false);
              callbackContext.success(jSONObject);
            }
          }rawArgs, callbackContext);
    } else if (paramString1.equals("readEntries")) {
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws FileNotFoundException, JSONException, MalformedURLException {
              String str = param1JSONArray.getString(0);
              JSONArray jSONArray = FileUtils.this.readEntries(str);
              callbackContext.success(jSONArray);
            }
          },  rawArgs, callbackContext);
    } else {
      if (paramString1.equals("_getLocalFilesystemPath")) {
        threadhelper(new FileOp() {
              public void run(JSONArray param1JSONArray) throws FileNotFoundException, JSONException, MalformedURLException {
                String str = param1JSONArray.getString(0);
                str = FileUtils.this.filesystemPathForURL(str);
                callbackContext.success(str);
              }
            },  rawArgs, callbackContext);
        return true;
      } 
      return false;
    } 
    return true;
  }
  
  public String filesystemPathForURL(String paramString) throws MalformedURLException {
    try {
      LocalFilesystemURL localFilesystemURL = LocalFilesystemURL.parse(paramString);
      Filesystem filesystem = filesystemForURL(localFilesystemURL);
      if (filesystem != null)
        return filesystem.filesystemPathForURL(localFilesystemURL); 
      MalformedURLException malformedURLException = new MalformedURLException();
      this("No installed handlers for this URL");
      throw malformedURLException;
    } catch (IllegalArgumentException illegalArgumentException) {
      MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
      malformedURLException.initCause(illegalArgumentException);
      throw malformedURLException;
    } 
  }
  
  public LocalFilesystemURL filesystemURLforLocalPath(String paramString) {
    Iterator<Filesystem> iterator = this.filesystems.iterator();
    LocalFilesystemURL localFilesystemURL = null;
    int i = 0;
    while (iterator.hasNext()) {
      LocalFilesystemURL localFilesystemURL1 = ((Filesystem)iterator.next()).URLforFilesystemPath(paramString);
      if (localFilesystemURL1 != null && (localFilesystemURL == null || localFilesystemURL1.path.length() < i)) {
        i = localFilesystemURL1.path.length();
        localFilesystemURL = localFilesystemURL1;
      } 
    } 
    return localFilesystemURL;
  }
  
  protected HashMap<String, String> getAvailableFileSystems(Activity paramActivity) {
    Context context = paramActivity.getApplicationContext();
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("files", context.getFilesDir().getAbsolutePath());
    hashMap.put("documents", (new File(context.getFilesDir(), "Documents")).getAbsolutePath());
    hashMap.put("cache", context.getCacheDir().getAbsolutePath());
    hashMap.put("root", "/");
    if (Environment.getExternalStorageState().equals("mounted"))
      try {
        hashMap.put("files-external", context.getExternalFilesDir(null).getAbsolutePath());
        hashMap.put("sdcard", Environment.getExternalStorageDirectory().getAbsolutePath());
        hashMap.put("cache-external", context.getExternalCacheDir().getAbsolutePath());
      } catch (NullPointerException nullPointerException) {
        LOG.d("FileUtils", "External storage unavailable, check to see if USB Mass Storage Mode is on");
      }  
    return (HashMap)hashMap;
  }
  
  public JSONObject getEntryForFile(File paramFile) throws JSONException {
    Iterator<Filesystem> iterator = this.filesystems.iterator();
    while (iterator.hasNext()) {
      JSONObject jSONObject = ((Filesystem)iterator.next()).makeEntryForFile(paramFile);
      if (jSONObject != null)
        return jSONObject; 
    } 
    return null;
  }
  
  protected String[] getExtraFileSystemsPreference(Activity paramActivity) {
    return this.preferences.getString("androidextrafilesystems", "files,files-external,documents,sdcard,cache,cache-external,assets,root").split(",");
  }
  
  public void initialize(CordovaInterface paramCordovaInterface, CordovaWebView paramCordovaWebView) {
    super.initialize(paramCordovaInterface, paramCordovaWebView);
    this.filesystems = new ArrayList<Filesystem>();
    this.pendingRequests = new PendingRequests();
    Activity activity = paramCordovaInterface.getActivity();
    String str2 = activity.getPackageName();
    String str1 = this.preferences.getString("androidpersistentfilelocation", "internal");
    String str3 = activity.getCacheDir().getAbsolutePath();
    if ("internal".equalsIgnoreCase(str1)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(activity.getFilesDir().getAbsolutePath());
      stringBuilder.append("/files/");
      str1 = stringBuilder.toString();
      this.configured = true;
    } else if ("compatibility".equalsIgnoreCase(str1)) {
      if (Environment.getExternalStorageState().equals("mounted")) {
        str1 = Environment.getExternalStorageDirectory().getAbsolutePath();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        stringBuilder.append("/Android/data/");
        stringBuilder.append(str2);
        stringBuilder.append("/cache/");
        str3 = stringBuilder.toString();
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/data/data/");
        stringBuilder.append(str2);
        String str = stringBuilder.toString();
      } 
      this.configured = true;
    } else {
      str1 = null;
    } 
    if (this.configured) {
      File file2 = new File(str3);
      File file1 = new File(str1);
      file2.mkdirs();
      file1.mkdirs();
      registerFilesystem(new LocalFilesystem("temporary", paramCordovaWebView.getContext(), paramCordovaWebView.getResourceApi(), file2));
      registerFilesystem(new LocalFilesystem("persistent", paramCordovaWebView.getContext(), paramCordovaWebView.getResourceApi(), file1));
      registerFilesystem(new ContentFilesystem(paramCordovaWebView.getContext(), paramCordovaWebView.getResourceApi()));
      registerFilesystem(new AssetFilesystem(paramCordovaWebView.getContext().getAssets(), paramCordovaWebView.getResourceApi()));
      registerExtraFileSystems(getExtraFileSystemsPreference(activity), getAvailableFileSystems(activity));
      if (filePlugin == null)
        filePlugin = this; 
    } else {
      LOG.e("FileUtils", "File plugin configuration error: Please set AndroidPersistentFileLocation in config.xml to one of \"internal\" (for new applications) or \"compatibility\" (for compatibility with previous versions)");
      activity.finish();
    } 
  }
  
  public void onRequestPermissionResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) throws JSONException {
    final PendingRequests.Request req = this.pendingRequests.getAndRemove(paramInt);
    if (request != null) {
      int i = paramArrayOfint.length;
      for (paramInt = 0; paramInt < i; paramInt++) {
        if (paramArrayOfint[paramInt] == -1) {
          request.getCallbackContext().sendPluginResult(new PluginResult(PluginResult.Status.ERROR, SECURITY_ERR));
          return;
        } 
      } 
      switch (request.getAction()) {
        default:
          return;
        case 2:
          threadhelper(new FileOp() {
                public void run(JSONArray param1JSONArray) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException {
                  String str1 = param1JSONArray.getString(0);
                  String str2 = param1JSONArray.getString(1);
                  JSONObject jSONObject = FileUtils.this.getFile(str1, str2, param1JSONArray.optJSONObject(2), true);
                  req.getCallbackContext().success(jSONObject);
                }
              }request.getRawArgs(), request.getCallbackContext());
        case 1:
          threadhelper(new FileOp() {
                public void run(JSONArray param1JSONArray) throws JSONException, FileNotFoundException, IOException, NoModificationAllowedException {
                  String str1 = param1JSONArray.getString(0);
                  String str2 = param1JSONArray.getString(1);
                  int i = param1JSONArray.getInt(2);
                  boolean bool = param1JSONArray.getBoolean(3);
                  long l = FileUtils.this.write(str1, str2, i, Boolean.valueOf(bool).booleanValue());
                  req.getCallbackContext().sendPluginResult(new PluginResult(PluginResult.Status.OK, (float)l));
                }
              }request.getRawArgs(), request.getCallbackContext());
        case 0:
          break;
      } 
      threadhelper(new FileOp() {
            public void run(JSONArray param1JSONArray) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException {
              String str1 = param1JSONArray.getString(0);
              String str2 = param1JSONArray.getString(1);
              JSONObject jSONObject = FileUtils.this.getFile(str1, str2, param1JSONArray.optJSONObject(2), false);
              req.getCallbackContext().success(jSONObject);
            }
          }request.getRawArgs(), request.getCallbackContext());
    } 
    LOG.d("FileUtils", "Received permission callback for unknown request code");
  }
  
  public void readFileAs(String paramString1, int paramInt1, int paramInt2, CallbackContext paramCallbackContext, String paramString2, int paramInt3) throws MalformedURLException {
    try {
      LocalFilesystemURL localFilesystemURL = LocalFilesystemURL.parse(paramString1);
      Filesystem filesystem = filesystemForURL(localFilesystemURL);
      if (filesystem != null) {
        long l1 = paramInt1;
        long l2 = paramInt2;
        Filesystem.ReadFileCallback readFileCallback = new Filesystem.ReadFileCallback() {
            public void handleData(InputStream param1InputStream, String param1String) {
              try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                this();
                byte[] arrayOfByte = new byte[8192];
                while (true) {
                  StringBuilder stringBuilder;
                  int i = param1InputStream.read(arrayOfByte, 0, 8192);
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
                          stringBuilder.append(param1String);
                          stringBuilder.append(";base64,");
                          param1String = new String();
                          this(arrayOfByte1, "US-ASCII");
                          stringBuilder.append(param1String);
                          param1String = stringBuilder.toString();
                          pluginResult = new PluginResult();
                          this(PluginResult.Status.OK, param1String);
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
          };
        super(this, paramInt3, paramString2, paramCallbackContext);
        filesystem.readFileAtURL(localFilesystemURL, l1, l2, readFileCallback);
      } else {
        MalformedURLException malformedURLException = new MalformedURLException();
        this("No installed handlers for this URL");
        throw malformedURLException;
      } 
      return;
    } catch (IllegalArgumentException illegalArgumentException) {
      MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
      malformedURLException.initCause(illegalArgumentException);
      throw malformedURLException;
    } catch (FileNotFoundException fileNotFoundException) {
      illegalArgumentException.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION, NOT_FOUND_ERR));
      return;
    } catch (IOException iOException) {
      LOG.d("FileUtils", iOException.getLocalizedMessage());
      illegalArgumentException.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION, NOT_READABLE_ERR));
      return;
    } 
  }
  
  protected void registerExtraFileSystems(String[] paramArrayOfString, HashMap<String, String> paramHashMap) {
    HashSet<String> hashSet = new HashSet();
    int i = paramArrayOfString.length;
    for (byte b = 0; b < i; b++) {
      String str = paramArrayOfString[b];
      if (!hashSet.contains(str)) {
        String str1 = paramHashMap.get(str);
        if (str1 != null) {
          File file = new File(str1);
          if (file.mkdirs() || file.isDirectory()) {
            registerFilesystem(new LocalFilesystem(str, this.webView.getContext(), this.webView.getResourceApi(), file));
            hashSet.add(str);
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to create root dir for filesystem \"");
            stringBuilder.append(str);
            stringBuilder.append("\", skipping");
            LOG.d("FileUtils", stringBuilder.toString());
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Unrecognized extra filesystem identifier: ");
          stringBuilder.append(str);
          LOG.d("FileUtils", stringBuilder.toString());
        } 
      } 
    } 
  }
  
  public void registerFilesystem(Filesystem paramFilesystem) {
    if (paramFilesystem != null && filesystemForName(paramFilesystem.name) == null)
      this.filesystems.add(paramFilesystem); 
  }
  
  public Uri remapUri(Uri paramUri) {
    if (!"cdvfile".equals(paramUri.getScheme()))
      return null; 
    try {
      LocalFilesystemURL localFilesystemURL = LocalFilesystemURL.parse(paramUri);
      Filesystem filesystem = filesystemForURL(localFilesystemURL);
      if (filesystem == null)
        return null; 
      if (filesystem.filesystemPathForURL(localFilesystemURL) != null) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("file://");
        stringBuilder.append(filesystem.filesystemPathForURL(localFilesystemURL));
        return Uri.parse(stringBuilder.toString());
      } 
      return null;
    } catch (IllegalArgumentException illegalArgumentException) {
      return null;
    } 
  }
  
  public LocalFilesystemURL resolveNativeUri(Uri paramUri) {
    Iterator<Filesystem> iterator = this.filesystems.iterator();
    LocalFilesystemURL localFilesystemURL = null;
    while (iterator.hasNext()) {
      LocalFilesystemURL localFilesystemURL1 = ((Filesystem)iterator.next()).toLocalUri(paramUri);
      if (localFilesystemURL1 != null && (localFilesystemURL == null || localFilesystemURL1.uri.toString().length() < localFilesystemURL.toString().length()))
        localFilesystemURL = localFilesystemURL1; 
    } 
    return localFilesystemURL;
  }
  
  public long write(String paramString1, String paramString2, int paramInt, boolean paramBoolean) throws FileNotFoundException, IOException, NoModificationAllowedException {
    try {
      LocalFilesystemURL localFilesystemURL = LocalFilesystemURL.parse(paramString1);
      Filesystem filesystem = filesystemForURL(localFilesystemURL);
      if (filesystem != null) {
        long l = filesystem.writeToFileAtURL(localFilesystemURL, paramString2, paramInt, paramBoolean);
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append(paramString1);
        stringBuilder.append(": ");
        stringBuilder.append(l);
        LOG.d("TEST", stringBuilder.toString());
        return l;
      } 
      MalformedURLException malformedURLException = new MalformedURLException();
      this("No installed handlers for this URL");
      throw malformedURLException;
    } catch (IllegalArgumentException illegalArgumentException) {
      MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
      malformedURLException.initCause(illegalArgumentException);
      throw malformedURLException;
    } 
  }
  
  private static interface FileOp {
    void run(JSONArray param1JSONArray) throws Exception;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */