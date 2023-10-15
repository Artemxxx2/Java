package org.apache.cordova;

class JsMessage {
  final String jsPayloadOrCallbackId;
  
  final PluginResult pluginResult;
  
  JsMessage(String paramString) {
    if (paramString != null) {
      this.jsPayloadOrCallbackId = paramString;
      this.pluginResult = null;
      return;
    } 
    throw new NullPointerException();
  }
  
  JsMessage(PluginResult paramPluginResult, String paramString) {
    if (paramString != null && paramPluginResult != null) {
      this.jsPayloadOrCallbackId = paramString;
      this.pluginResult = paramPluginResult;
      return;
    } 
    throw new NullPointerException();
  }
  
  static int calculateEncodedLengthHelper(PluginResult paramPluginResult) {
    int i = paramPluginResult.getMessageType();
    if (i != 1) {
      byte b;
      switch (i) {
        default:
          return paramPluginResult.getMessage().length();
        case 8:
          b = 0;
          i = 1;
          while (b < paramPluginResult.getMultipartMessagesSize()) {
            int j = calculateEncodedLengthHelper(paramPluginResult.getMultipartMessage(b));
            i += String.valueOf(j).length() + 1 + j;
            b++;
          } 
          return i;
        case 7:
          return paramPluginResult.getMessage().length() + 1;
        case 6:
          return paramPluginResult.getMessage().length() + 1;
        case 4:
        case 5:
          return 1;
        case 3:
          break;
      } 
      return paramPluginResult.getMessage().length() + 1;
    } 
    return paramPluginResult.getStrMessage().length() + 1;
  }
  
  static void encodeAsMessageHelper(StringBuilder paramStringBuilder, PluginResult paramPluginResult) {
    int i = paramPluginResult.getMessageType();
    if (i != 1) {
      byte b = 0;
      switch (i) {
        default:
          paramStringBuilder.append(paramPluginResult.getMessage());
          return;
        case 8:
          paramStringBuilder.append('M');
          while (b < paramPluginResult.getMultipartMessagesSize()) {
            PluginResult pluginResult = paramPluginResult.getMultipartMessage(b);
            paramStringBuilder.append(String.valueOf(calculateEncodedLengthHelper(pluginResult)));
            paramStringBuilder.append(' ');
            encodeAsMessageHelper(paramStringBuilder, pluginResult);
            b++;
          } 
          return;
        case 7:
          paramStringBuilder.append('S');
          paramStringBuilder.append(paramPluginResult.getMessage());
          return;
        case 6:
          paramStringBuilder.append('A');
          paramStringBuilder.append(paramPluginResult.getMessage());
          return;
        case 5:
          paramStringBuilder.append('N');
          return;
        case 4:
          paramStringBuilder.append(paramPluginResult.getMessage().charAt(0));
          return;
        case 3:
          break;
      } 
      paramStringBuilder.append('n');
      paramStringBuilder.append(paramPluginResult.getMessage());
    } else {
      paramStringBuilder.append('s');
      paramStringBuilder.append(paramPluginResult.getStrMessage());
    } 
  }
  
  void buildJsMessage(StringBuilder paramStringBuilder) {
    int i;
    byte b;
    switch (this.pluginResult.getMessageType()) {
      default:
        paramStringBuilder.append(this.pluginResult.getMessage());
        return;
      case 8:
        i = this.pluginResult.getMultipartMessagesSize();
        for (b = 0; b < i; b++) {
          (new JsMessage(this.pluginResult.getMultipartMessage(b), this.jsPayloadOrCallbackId)).buildJsMessage(paramStringBuilder);
          if (b < i - 1)
            paramStringBuilder.append(","); 
        } 
        return;
      case 7:
        paramStringBuilder.append("atob('");
        paramStringBuilder.append(this.pluginResult.getMessage());
        paramStringBuilder.append("')");
        return;
      case 6:
        paramStringBuilder.append("cordova.require('cordova/base64').toArrayBuffer('");
        paramStringBuilder.append(this.pluginResult.getMessage());
        paramStringBuilder.append("')");
        return;
      case 5:
        break;
    } 
    paramStringBuilder.append("null");
  }
  
  int calculateEncodedLength() {
    PluginResult pluginResult = this.pluginResult;
    return (pluginResult == null) ? (this.jsPayloadOrCallbackId.length() + 1) : (String.valueOf(pluginResult.getStatus()).length() + 2 + 1 + this.jsPayloadOrCallbackId.length() + 1 + calculateEncodedLengthHelper(this.pluginResult));
  }
  
  void encodeAsJsMessage(StringBuilder paramStringBuilder) {
    PluginResult pluginResult = this.pluginResult;
    if (pluginResult == null) {
      paramStringBuilder.append(this.jsPayloadOrCallbackId);
    } else {
      boolean bool;
      int i = pluginResult.getStatus();
      if (i == PluginResult.Status.OK.ordinal() || i == PluginResult.Status.NO_RESULT.ordinal()) {
        bool = true;
      } else {
        bool = false;
      } 
      paramStringBuilder.append("cordova.callbackFromNative('");
      paramStringBuilder.append(this.jsPayloadOrCallbackId);
      paramStringBuilder.append("',");
      paramStringBuilder.append(bool);
      paramStringBuilder.append(",");
      paramStringBuilder.append(i);
      paramStringBuilder.append(",[");
      buildJsMessage(paramStringBuilder);
      paramStringBuilder.append("],");
      paramStringBuilder.append(this.pluginResult.getKeepCallback());
      paramStringBuilder.append(");");
    } 
  }
  
  void encodeAsMessage(StringBuilder paramStringBuilder) {
    int k;
    PluginResult pluginResult = this.pluginResult;
    if (pluginResult == null) {
      paramStringBuilder.append('J');
      paramStringBuilder.append(this.jsPayloadOrCallbackId);
      return;
    } 
    int i = pluginResult.getStatus();
    int j = PluginResult.Status.NO_RESULT.ordinal();
    boolean bool = true;
    if (i == j) {
      j = 1;
    } else {
      j = 0;
    } 
    if (i != PluginResult.Status.OK.ordinal())
      bool = false; 
    boolean bool1 = this.pluginResult.getKeepCallback();
    if (j != 0 || bool) {
      j = 83;
      k = j;
    } else {
      j = 70;
      k = j;
    } 
    paramStringBuilder.append(k);
    if (bool1) {
      j = 49;
      k = j;
    } else {
      j = 48;
      k = j;
    } 
    paramStringBuilder.append(k);
    paramStringBuilder.append(i);
    paramStringBuilder.append(' ');
    paramStringBuilder.append(this.jsPayloadOrCallbackId);
    paramStringBuilder.append(' ');
    encodeAsMessageHelper(paramStringBuilder, this.pluginResult);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\NativeToJsMessageQueue$JsMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */