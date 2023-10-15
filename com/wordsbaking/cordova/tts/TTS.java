package com.wordsbaking.cordova.tts;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.speech.tts.Voice;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TTS extends CordovaPlugin implements TextToSpeech.OnInitListener {
  public static final String ERR_ERROR_INITIALIZING = "ERR_ERROR_INITIALIZING";
  
  public static final String ERR_INVALID_OPTIONS = "ERR_INVALID_OPTIONS";
  
  public static final String ERR_NOT_INITIALIZED = "ERR_NOT_INITIALIZED";
  
  public static final String ERR_UNKNOWN = "ERR_UNKNOWN";
  
  Context context = null;
  
  TextToSpeech tts = null;
  
  boolean ttsInitialized = false;
  
  private void callInstallTtsActivity(JSONArray paramJSONArray, CallbackContext paramCallbackContext) throws JSONException, NullPointerException {
    PackageManager packageManager = this.context.getPackageManager();
    Intent intent = new Intent();
    intent.setAction("android.speech.tts.engine.INSTALL_TTS_DATA");
    if (packageManager.resolveActivity(intent, 65536) != null) {
      intent.setFlags(268435456);
      this.context.startActivity(intent);
    } 
  }
  
  private void checkLanguage(JSONArray paramJSONArray, CallbackContext paramCallbackContext) throws JSONException, NullPointerException {
    String str2;
    String str1 = "";
    if (Build.VERSION.SDK_INT >= 21) {
      Locale locale;
      Set set = this.tts.getAvailableLanguages();
      String str = str1;
      if (set != null) {
        Iterator<Locale> iterator = set.iterator();
        while (true) {
          str = str1;
          if (iterator.hasNext()) {
            locale = iterator.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str1);
            stringBuilder.append(",");
            stringBuilder.append(locale);
            str1 = stringBuilder.toString();
            continue;
          } 
          break;
        } 
      } 
      if (locale != "") {
        str2 = locale.substring(1);
      } else {
        this.tts.setEngineByPackageName("com.google.android.tts");
      } 
    } else {
      str2 = "uk_UA";
    } 
    paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, str2));
  }
  
  private void getVoices(JSONArray paramJSONArray, CallbackContext paramCallbackContext) throws JSONException, NullPointerException {
    Set set = this.tts.getVoices();
    paramJSONArray = new JSONArray();
    for (Voice voice : set) {
      JSONObject jSONObject = new JSONObject();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Voice: ");
      stringBuilder.append(voice.getName());
      Log.v("TTS", stringBuilder.toString());
      jSONObject.put("name", voice.getName());
      jSONObject.put("identifier", voice.getName());
      jSONObject.put("language", voice.getLocale());
      paramJSONArray.put(jSONObject);
    } 
    paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, paramJSONArray));
  }
  
  private void speak(JSONArray paramJSONArray, CallbackContext paramCallbackContext) throws JSONException, NullPointerException {
    String str1;
    String str3;
    boolean bool3;
    double d2;
    boolean bool1 = false;
    boolean bool2 = false;
    JSONObject jSONObject = paramJSONArray.getJSONObject(0);
    if (jSONObject == null) {
      paramCallbackContext.error("ERR_INVALID_OPTIONS");
      return;
    } 
    if (jSONObject.isNull("text")) {
      paramCallbackContext.error("ERR_INVALID_OPTIONS");
      return;
    } 
    String str2 = jSONObject.getString("text");
    if (jSONObject.isNull("identifier")) {
      Log.v("TTS", "No voice identifier");
    } else {
      str3 = jSONObject.getString("identifier");
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("got identifier: ");
      stringBuilder1.append(str3);
      Log.v("TTS", stringBuilder1.toString());
    } 
    if (jSONObject.isNull("locale")) {
      str1 = Locale.getDefault().toLanguageTag();
    } else {
      str1 = jSONObject.getString("locale");
    } 
    if (!jSONObject.isNull("cancel")) {
      bool3 = jSONObject.getBoolean("cancel");
    } else {
      bool3 = false;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("cancel is set to ");
    stringBuilder.append(bool3);
    stringBuilder.append("(");
    if (bool3) {
      str3 = "TextToSpeech.QUEUE_FLUSH";
    } else {
      str3 = "TextToSpeech.QUEUE_ADD";
    } 
    stringBuilder.append(str3);
    stringBuilder.append(")");
    Log.v("TTS", stringBuilder.toString());
    boolean bool = jSONObject.isNull("rate");
    double d1 = 1.0D;
    if (bool) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("No rate provided, so rate is set to ");
      stringBuilder1.append(1.0D);
      Log.v("TTS", stringBuilder1.toString());
      d2 = 1.0D;
    } else {
      d2 = jSONObject.getDouble("rate");
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("rate is set to ");
      stringBuilder1.append(d2);
      Log.v("TTS", stringBuilder1.toString());
    } 
    if (jSONObject.isNull("pitch")) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("No pitch provided, so pitch set to ");
      stringBuilder1.append(1.0D);
      Log.v("TTS", stringBuilder1.toString());
    } else {
      d1 = jSONObject.getDouble("pitch");
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Pitch set to ");
      stringBuilder1.append(d1);
      Log.v("TTS", stringBuilder1.toString());
    } 
    if (this.tts == null) {
      paramCallbackContext.error("ERR_ERROR_INITIALIZING");
      return;
    } 
    if (!this.ttsInitialized) {
      paramCallbackContext.error("ERR_NOT_INITIALIZED");
      return;
    } 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("utteranceId", paramCallbackContext.getCallbackId());
    String[] arrayOfString = str1.split("-");
    this.tts.setLanguage(new Locale(arrayOfString[0], arrayOfString[1]));
    this.tts.setSpeechRate((float)d2);
    this.tts.setPitch((float)d1);
    if (Build.VERSION.SDK_INT >= 21) {
      TextToSpeech textToSpeech = this.tts;
      if (!bool3)
        bool2 = true; 
      textToSpeech.speak(str2, bool2, null, paramCallbackContext.getCallbackId());
    } else {
      TextToSpeech textToSpeech = this.tts;
      if (bool3) {
        bool2 = bool1;
      } else {
        bool2 = true;
      } 
      textToSpeech.speak(str2, bool2, hashMap);
    } 
  }
  
  private void stop(JSONArray paramJSONArray, CallbackContext paramCallbackContext) throws JSONException, NullPointerException {
    this.tts.stop();
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext) throws JSONException {
    if (paramString.equals("speak")) {
      speak(paramJSONArray, paramCallbackContext);
    } else if (paramString.equals("stop")) {
      stop(paramJSONArray, paramCallbackContext);
    } else if (paramString.equals("checkLanguage")) {
      checkLanguage(paramJSONArray, paramCallbackContext);
    } else if (paramString.equals("getVoices")) {
      getVoices(paramJSONArray, paramCallbackContext);
    } else {
      if (paramString.equals("openInstallTts")) {
        callInstallTtsActivity(paramJSONArray, paramCallbackContext);
        return true;
      } 
      return false;
    } 
    return true;
  }
  
  public void initialize(CordovaInterface paramCordovaInterface, final CordovaWebView webView) {
    this.context = paramCordovaInterface.getActivity().getApplicationContext();
    this.tts = new TextToSpeech(paramCordovaInterface.getActivity().getApplicationContext(), this, "com.google.android.tts");
    this.tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
          public void onDone(String param1String) {
            if (!param1String.equals(""))
              (new CallbackContext(param1String, webView)).success(); 
          }
          
          public void onError(String param1String) {
            if (!param1String.equals(""))
              (new CallbackContext(param1String, webView)).error("ERR_UNKNOWN"); 
          }
          
          public void onStart(String param1String) {}
        });
  }
  
  public void onInit(int paramInt) {
    System.out.println("TTS: tts STARTED");
    if (paramInt != 0) {
      this.tts = null;
      System.out.println("TTS: NO SUCCESS");
    } else {
      (new HashMap<String, String>()).put("utteranceId", "");
      this.tts.setLanguage(new Locale("en", "US"));
      if (Build.VERSION.SDK_INT >= 21) {
        this.tts.speak("", 0, null, null);
      } else {
        this.tts.speak("", 0, null);
      } 
      System.out.println("TTS: SUCCESS");
      this.ttsInitialized = true;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\wordsbaking\cordova\tts\TTS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */