package org.apache.cordova.speech;

import android.os.Bundle;
import android.speech.RecognitionListener;
import android.util.Log;
import java.util.ArrayList;

class SpeechRecognitionListner implements RecognitionListener {
  public void onBeginningOfSpeech() {
    Log.d(SpeechRecognition.access$100(), "begin speech");
    SpeechRecognition.access$202(SpeechRecognition.this, true);
    SpeechRecognition.access$300(SpeechRecognition.this, "soundstart");
    SpeechRecognition.access$300(SpeechRecognition.this, "speechstart");
  }
  
  public void onBufferReceived(byte[] paramArrayOfbyte) {
    Log.d(SpeechRecognition.access$100(), "buffer received");
  }
  
  public void onEndOfSpeech() {
    Log.d(SpeechRecognition.access$100(), "end speech");
    if (SpeechRecognition.access$200(SpeechRecognition.this)) {
      SpeechRecognition.access$300(SpeechRecognition.this, "speechend");
      SpeechRecognition.access$300(SpeechRecognition.this, "soundend");
      SpeechRecognition.access$202(SpeechRecognition.this, false);
    } 
    if (SpeechRecognition.access$400(SpeechRecognition.this)) {
      SpeechRecognition.access$300(SpeechRecognition.this, "audioend");
      SpeechRecognition.access$402(SpeechRecognition.this, false);
    } 
  }
  
  public void onError(int paramInt) {
    SpeechRecognition speechRecognition;
    ArrayList arrayList;
    String str = SpeechRecognition.access$100();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("error ");
    stringBuilder.append(paramInt);
    Log.d(str, stringBuilder.toString());
    switch (paramInt) {
      default:
        speechRecognition = SpeechRecognition.this;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Error ");
        stringBuilder.append(paramInt);
        SpeechRecognition.access$500(speechRecognition, 4, stringBuilder.toString());
        break;
      case 9:
        Log.d(SpeechRecognition.access$100(), "ERROR_INSUFFICIENT_PERMISSIONS");
        SpeechRecognition.access$500(SpeechRecognition.this, 4, "Permission denied.");
        break;
      case 8:
        Log.d(SpeechRecognition.access$100(), "ERROR_RECOGNIZER_BUSY");
        SpeechRecognition.access$500(SpeechRecognition.this, 4, "Busy.");
        break;
      case 7:
        Log.d(SpeechRecognition.access$100(), "ERROR_NO_MATCH");
        Log.d(SpeechRecognition.access$100(), "SpeechRecognizer.ERROR_NO_MATCH");
        arrayList = new ArrayList();
        SpeechRecognition.access$600(SpeechRecognition.this, "nomatch", arrayList, new float[0], true);
        break;
      case 6:
        Log.d(SpeechRecognition.access$100(), "ERROR_SPEECH_TIMEOUT");
        SpeechRecognition.access$500(SpeechRecognition.this, 0, "Timeout.");
        break;
      case 5:
        Log.d(SpeechRecognition.access$100(), "ERROR_CLIENT");
        SpeechRecognition.access$500(SpeechRecognition.this, 4, "Client side error.");
        break;
      case 4:
        Log.d(SpeechRecognition.access$100(), "ERROR_SERVER");
        SpeechRecognition.access$500(SpeechRecognition.this, 4, "Server error.");
        break;
      case 3:
        Log.d(SpeechRecognition.access$100(), "ERROR_AUDIO");
        SpeechRecognition.access$500(SpeechRecognition.this, 2, "Audio recording error.");
        break;
      case 2:
        Log.d(SpeechRecognition.access$100(), "ERROR_NETWORK");
        SpeechRecognition.access$500(SpeechRecognition.this, 3, "Network communication error.");
        break;
      case 1:
        Log.d(SpeechRecognition.access$100(), "ERROR_NETWORK_TIMEOUT");
        SpeechRecognition.access$500(SpeechRecognition.this, 3, "Network timeout.");
        break;
    } 
    if (SpeechRecognition.access$200(SpeechRecognition.this)) {
      SpeechRecognition.access$300(SpeechRecognition.this, "speechend");
      SpeechRecognition.access$300(SpeechRecognition.this, "soundend");
      SpeechRecognition.access$202(SpeechRecognition.this, false);
    } 
    if (SpeechRecognition.access$400(SpeechRecognition.this)) {
      SpeechRecognition.access$300(SpeechRecognition.this, "audioend");
      SpeechRecognition.access$402(SpeechRecognition.this, false);
    } 
    if (SpeechRecognition.access$700(SpeechRecognition.this)) {
      SpeechRecognition.access$300(SpeechRecognition.this, "end");
      SpeechRecognition.access$702(SpeechRecognition.this, false);
    } 
  }
  
  public void onEvent(int paramInt, Bundle paramBundle) {
    Log.d(SpeechRecognition.access$100(), "event speech");
  }
  
  public void onPartialResults(Bundle paramBundle) {
    String str = SpeechRecognition.access$100();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onPartialResults ");
    stringBuilder.append(paramBundle);
    Log.d(str, stringBuilder.toString());
    ArrayList arrayList = paramBundle.getStringArrayList("results_recognition");
    float[] arrayOfFloat = paramBundle.getFloatArray("confidence_scores");
    if (arrayList.size() > 0)
      SpeechRecognition.access$600(SpeechRecognition.this, "result", arrayList, arrayOfFloat, false); 
  }
  
  public void onReadyForSpeech(Bundle paramBundle) {
    Log.d(SpeechRecognition.access$100(), "ready for speech");
    SpeechRecognition.access$702(SpeechRecognition.this, true);
    SpeechRecognition.access$300(SpeechRecognition.this, "start");
    SpeechRecognition.access$402(SpeechRecognition.this, true);
    SpeechRecognition.access$300(SpeechRecognition.this, "audiostart");
  }
  
  public void onResults(Bundle paramBundle) {
    String str = SpeechRecognition.access$100();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onResults ");
    stringBuilder.append(paramBundle);
    Log.d(str, stringBuilder.toString());
    if (SpeechRecognition.access$700(SpeechRecognition.this)) {
      ArrayList arrayList = paramBundle.getStringArrayList("results_recognition");
      float[] arrayOfFloat = paramBundle.getFloatArray("confidence_scores");
      if (arrayList.size() > 0) {
        SpeechRecognition.access$600(SpeechRecognition.this, "result", arrayList, arrayOfFloat, true);
      } else {
        SpeechRecognition.access$600(SpeechRecognition.this, "nomatch", arrayList, arrayOfFloat, true);
      } 
      SpeechRecognition.access$702(SpeechRecognition.this, false);
      SpeechRecognition.access$300(SpeechRecognition.this, "end");
    } else {
      Log.w(SpeechRecognition.access$100(), "ignore result when not started/or double result");
    } 
  }
  
  public void onRmsChanged(float paramFloat) {}
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\speech\SpeechRecognition$SpeechRecognitionListner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */