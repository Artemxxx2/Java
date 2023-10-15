package org.apache.cordova.speech;

import android.speech.SpeechRecognizer;

class null implements Runnable {
  public void run() {
    SpeechRecognition speechRecognition = SpeechRecognition.this;
    SpeechRecognition.access$002(speechRecognition, SpeechRecognizer.createSpeechRecognizer(speechRecognition.cordova.getActivity().getBaseContext()));
    SpeechRecognition.access$000(SpeechRecognition.this).setRecognitionListener(new SpeechRecognition.SpeechRecognitionListner(SpeechRecognition.this));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\speech\SpeechRecognition$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */