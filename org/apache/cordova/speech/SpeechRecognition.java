package org.apache.cordova.speech;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.util.Log;
import java.util.ArrayList;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PermissionHelper;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SpeechRecognition extends CordovaPlugin {
  public static final String ACTION_INIT = "init";
  
  public static final String ACTION_SPEECH_RECOGNIZE_ABORT = "abort";
  
  public static final String ACTION_SPEECH_RECOGNIZE_START = "start";
  
  public static final String ACTION_SPEECH_RECOGNIZE_STOP = "stop";
  
  private static final String LOG_TAG = "SpeechRecognition";
  
  public static final String NOT_PRESENT_MESSAGE = "Speech recognition is not present or enabled";
  
  private static int RECORD_AUDIO = 0;
  
  public static final String SERVICE_URI_LOCAL = "local";
  
  private static String[] permissions = new String[] { "android.permission.RECORD_AUDIO" };
  
  private boolean aborted = false;
  
  private boolean interimResults = false;
  
  private String lang;
  
  private boolean listening = false;
  
  private int maxAlternatives = 1;
  
  private SpeechRecognizer recognizer;
  
  private boolean recognizerPresent = false;
  
  private String serviceURI;
  
  private boolean speaking = false;
  
  private CallbackContext speechRecognizerCallbackContext;
  
  private boolean started = false;
  
  static {
    RECORD_AUDIO = 0;
  }
  
  private boolean DoInit() {
    this.recognizerPresent = SpeechRecognizer.isRecognitionAvailable(this.cordova.getActivity().getBaseContext());
    return this.recognizerPresent;
  }
  
  private void fireErrorEvent(int paramInt, String paramString) {
    String str = LOG_TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("fire error event: ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" - ");
    stringBuilder.append(paramString);
    Log.d(str, stringBuilder.toString());
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("type", "error");
      jSONObject.put("error", paramInt);
      jSONObject.put("message", paramString);
    } catch (JSONException jSONException) {}
    PluginResult pluginResult = new PluginResult(PluginResult.Status.ERROR, jSONObject);
    pluginResult.setKeepCallback(true);
    this.speechRecognizerCallbackContext.sendPluginResult(pluginResult);
  }
  
  private void fireEvent(String paramString) {
    String str = LOG_TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("fire event: ");
    stringBuilder.append(paramString);
    Log.d(str, stringBuilder.toString());
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("type", paramString);
    } catch (JSONException jSONException) {}
    PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, jSONObject);
    pluginResult.setKeepCallback(true);
    this.speechRecognizerCallbackContext.sendPluginResult(pluginResult);
  }
  
  private void fireRecognitionEvent(String paramString, ArrayList<String> paramArrayList, float[] paramArrayOffloat, boolean paramBoolean) {
    String str = LOG_TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("fire recognition event: ");
    stringBuilder.append(paramString);
    Log.d(str, stringBuilder.toString());
    JSONObject jSONObject = new JSONObject();
    JSONArray jSONArray2 = new JSONArray();
    JSONArray jSONArray1 = new JSONArray();
    byte b = 0;
    try {
      while (b < paramArrayList.size()) {
        JSONObject jSONObject1 = new JSONObject();
        this();
        jSONObject1.put("transcript", paramArrayList.get(b));
        jSONObject1.put("final", paramBoolean);
        if (paramArrayOffloat != null) {
          jSONObject1.put("confidence", paramArrayOffloat[b]);
        } else {
          jSONObject1.put("confidence", 0);
        } 
        jSONArray1.put(jSONObject1);
        b++;
      } 
      jSONArray2.put(jSONArray1);
      jSONObject.put("type", paramString);
      jSONObject.put("resultIndex", 0);
      jSONObject.put("emma", null);
      jSONObject.put("interpretation", null);
      jSONObject.put("results", jSONArray2);
    } catch (JSONException jSONException) {}
    PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, jSONObject);
    pluginResult.setKeepCallback(true);
    this.speechRecognizerCallbackContext.sendPluginResult(pluginResult);
  }
  
  private void promptForMic() {
    if (PermissionHelper.hasPermission(this, permissions[RECORD_AUDIO])) {
      startRecognition();
    } else {
      getMicPermission();
    } 
  }
  
  private void startRecognition() {
    final Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
    intent.putExtra("android.speech.extra.LANGUAGE", this.lang);
    intent.putExtra("android.speech.extra.PARTIAL_RESULTS", this.interimResults);
    intent.putExtra("android.speech.extra.MAX_RESULTS", this.maxAlternatives);
    if ("local".equals(this.serviceURI))
      intent.putExtra("android.speech.extra.PREFER_OFFLINE", true); 
    (new Handler(Looper.getMainLooper())).post(new Runnable() {
          public void run() {
            SpeechRecognition.this.recognizer.startListening(intent);
          }
        });
    PluginResult pluginResult = new PluginResult(PluginResult.Status.NO_RESULT);
    pluginResult.setKeepCallback(true);
    this.speechRecognizerCallbackContext.sendPluginResult(pluginResult);
  }
  
  private void stop(boolean paramBoolean) {
    this.aborted = paramBoolean;
    if (paramBoolean) {
      (new Handler(Looper.getMainLooper())).post(new Runnable() {
            public void run() {
              SpeechRecognition.this.recognizer.cancel();
            }
          });
    } else if (this.started) {
      (new Handler(Looper.getMainLooper())).post(new Runnable() {
            public void run() {
              SpeechRecognition.this.recognizer.stopListening();
            }
          });
    } 
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext) {
    String str = LOG_TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("action: ");
    stringBuilder.append(paramString);
    Log.d(str, stringBuilder.toString());
    if ("init".equals(paramString)) {
      if (DoInit()) {
        paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
        (new Handler(Looper.getMainLooper())).post(new Runnable() {
              public void run() {
                SpeechRecognition speechRecognition = SpeechRecognition.this;
                SpeechRecognition.access$002(speechRecognition, SpeechRecognizer.createSpeechRecognizer(speechRecognition.cordova.getActivity().getBaseContext()));
                SpeechRecognition.this.recognizer.setRecognitionListener(new SpeechRecognition.SpeechRecognitionListner());
              }
            });
      } else {
        paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, "Speech recognition is not present or enabled"));
      } 
    } else if ("start".equals(paramString)) {
      if (!this.recognizerPresent)
        paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, "Speech recognition is not present or enabled")); 
      this.lang = paramJSONArray.optString(0, "en");
      this.interimResults = paramJSONArray.optBoolean(1, false);
      this.maxAlternatives = paramJSONArray.optInt(2, 1);
      this.serviceURI = paramJSONArray.optString(3, "");
      this.speechRecognizerCallbackContext = paramCallbackContext;
      promptForMic();
    } else if ("stop".equals(paramString)) {
      stop(false);
    } else {
      if ("abort".equals(paramString)) {
        stop(true);
        return true;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Unknown action: ");
      stringBuilder1.append(paramString);
      stringBuilder1.toString();
      return false;
    } 
    return true;
  }
  
  protected void getMicPermission() {
    int i = RECORD_AUDIO;
    PermissionHelper.requestPermission(this, i, permissions[i]);
  }
  
  public void onRequestPermissionResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) throws JSONException {
    int i = paramArrayOfint.length;
    for (paramInt = 0; paramInt < i; paramInt++) {
      if (paramArrayOfint[paramInt] == -1) {
        fireErrorEvent(4, "Permission denied for microphone access.");
        fireEvent("end");
        return;
      } 
    } 
    promptForMic();
  }
  
  class SpeechRecognitionListner implements RecognitionListener {
    public void onBeginningOfSpeech() {
      Log.d(SpeechRecognition.LOG_TAG, "begin speech");
      SpeechRecognition.access$202(SpeechRecognition.this, true);
      SpeechRecognition.this.fireEvent("soundstart");
      SpeechRecognition.this.fireEvent("speechstart");
    }
    
    public void onBufferReceived(byte[] param1ArrayOfbyte) {
      Log.d(SpeechRecognition.LOG_TAG, "buffer received");
    }
    
    public void onEndOfSpeech() {
      Log.d(SpeechRecognition.LOG_TAG, "end speech");
      if (SpeechRecognition.this.speaking) {
        SpeechRecognition.this.fireEvent("speechend");
        SpeechRecognition.this.fireEvent("soundend");
        SpeechRecognition.access$202(SpeechRecognition.this, false);
      } 
      if (SpeechRecognition.this.listening) {
        SpeechRecognition.this.fireEvent("audioend");
        SpeechRecognition.access$402(SpeechRecognition.this, false);
      } 
    }
    
    public void onError(int param1Int) {
      SpeechRecognition speechRecognition;
      ArrayList arrayList;
      String str = SpeechRecognition.LOG_TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("error ");
      stringBuilder.append(param1Int);
      Log.d(str, stringBuilder.toString());
      switch (param1Int) {
        default:
          speechRecognition = SpeechRecognition.this;
          stringBuilder = new StringBuilder();
          stringBuilder.append("Error ");
          stringBuilder.append(param1Int);
          speechRecognition.fireErrorEvent(4, stringBuilder.toString());
          break;
        case 9:
          Log.d(SpeechRecognition.LOG_TAG, "ERROR_INSUFFICIENT_PERMISSIONS");
          SpeechRecognition.this.fireErrorEvent(4, "Permission denied.");
          break;
        case 8:
          Log.d(SpeechRecognition.LOG_TAG, "ERROR_RECOGNIZER_BUSY");
          SpeechRecognition.this.fireErrorEvent(4, "Busy.");
          break;
        case 7:
          Log.d(SpeechRecognition.LOG_TAG, "ERROR_NO_MATCH");
          Log.d(SpeechRecognition.LOG_TAG, "SpeechRecognizer.ERROR_NO_MATCH");
          arrayList = new ArrayList();
          SpeechRecognition.this.fireRecognitionEvent("nomatch", arrayList, new float[0], true);
          break;
        case 6:
          Log.d(SpeechRecognition.LOG_TAG, "ERROR_SPEECH_TIMEOUT");
          SpeechRecognition.this.fireErrorEvent(0, "Timeout.");
          break;
        case 5:
          Log.d(SpeechRecognition.LOG_TAG, "ERROR_CLIENT");
          SpeechRecognition.this.fireErrorEvent(4, "Client side error.");
          break;
        case 4:
          Log.d(SpeechRecognition.LOG_TAG, "ERROR_SERVER");
          SpeechRecognition.this.fireErrorEvent(4, "Server error.");
          break;
        case 3:
          Log.d(SpeechRecognition.LOG_TAG, "ERROR_AUDIO");
          SpeechRecognition.this.fireErrorEvent(2, "Audio recording error.");
          break;
        case 2:
          Log.d(SpeechRecognition.LOG_TAG, "ERROR_NETWORK");
          SpeechRecognition.this.fireErrorEvent(3, "Network communication error.");
          break;
        case 1:
          Log.d(SpeechRecognition.LOG_TAG, "ERROR_NETWORK_TIMEOUT");
          SpeechRecognition.this.fireErrorEvent(3, "Network timeout.");
          break;
      } 
      if (SpeechRecognition.this.speaking) {
        SpeechRecognition.this.fireEvent("speechend");
        SpeechRecognition.this.fireEvent("soundend");
        SpeechRecognition.access$202(SpeechRecognition.this, false);
      } 
      if (SpeechRecognition.this.listening) {
        SpeechRecognition.this.fireEvent("audioend");
        SpeechRecognition.access$402(SpeechRecognition.this, false);
      } 
      if (SpeechRecognition.this.started) {
        SpeechRecognition.this.fireEvent("end");
        SpeechRecognition.access$702(SpeechRecognition.this, false);
      } 
    }
    
    public void onEvent(int param1Int, Bundle param1Bundle) {
      Log.d(SpeechRecognition.LOG_TAG, "event speech");
    }
    
    public void onPartialResults(Bundle param1Bundle) {
      String str = SpeechRecognition.LOG_TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onPartialResults ");
      stringBuilder.append(param1Bundle);
      Log.d(str, stringBuilder.toString());
      ArrayList arrayList = param1Bundle.getStringArrayList("results_recognition");
      float[] arrayOfFloat = param1Bundle.getFloatArray("confidence_scores");
      if (arrayList.size() > 0)
        SpeechRecognition.this.fireRecognitionEvent("result", arrayList, arrayOfFloat, false); 
    }
    
    public void onReadyForSpeech(Bundle param1Bundle) {
      Log.d(SpeechRecognition.LOG_TAG, "ready for speech");
      SpeechRecognition.access$702(SpeechRecognition.this, true);
      SpeechRecognition.this.fireEvent("start");
      SpeechRecognition.access$402(SpeechRecognition.this, true);
      SpeechRecognition.this.fireEvent("audiostart");
    }
    
    public void onResults(Bundle param1Bundle) {
      String str = SpeechRecognition.LOG_TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onResults ");
      stringBuilder.append(param1Bundle);
      Log.d(str, stringBuilder.toString());
      if (SpeechRecognition.this.started) {
        ArrayList arrayList = param1Bundle.getStringArrayList("results_recognition");
        float[] arrayOfFloat = param1Bundle.getFloatArray("confidence_scores");
        if (arrayList.size() > 0) {
          SpeechRecognition.this.fireRecognitionEvent("result", arrayList, arrayOfFloat, true);
        } else {
          SpeechRecognition.this.fireRecognitionEvent("nomatch", arrayList, arrayOfFloat, true);
        } 
        SpeechRecognition.access$702(SpeechRecognition.this, false);
        SpeechRecognition.this.fireEvent("end");
      } else {
        Log.w(SpeechRecognition.LOG_TAG, "ignore result when not started/or double result");
      } 
    }
    
    public void onRmsChanged(float param1Float) {}
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\speech\SpeechRecognition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */