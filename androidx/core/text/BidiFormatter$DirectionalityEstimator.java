package androidx.core.text;

class DirectionalityEstimator {
  private static final byte[] DIR_TYPE_CACHE = new byte[1792];
  
  private static final int DIR_TYPE_CACHE_SIZE = 1792;
  
  private int charIndex;
  
  private final boolean isHtml;
  
  private char lastChar;
  
  private final int length;
  
  private final CharSequence text;
  
  static {
    for (byte b = 0; b < '܀'; b++)
      DIR_TYPE_CACHE[b] = Character.getDirectionality(b); 
  }
  
  DirectionalityEstimator(CharSequence paramCharSequence, boolean paramBoolean) {
    this.text = paramCharSequence;
    this.isHtml = paramBoolean;
    this.length = paramCharSequence.length();
  }
  
  private static byte getCachedDirectionality(char paramChar) {
    byte b;
    if (paramChar < '܀') {
      byte b1 = DIR_TYPE_CACHE[paramChar];
      b = b1;
    } else {
      byte b1 = Character.getDirectionality(paramChar);
      b = b1;
    } 
    return b;
  }
  
  private byte skipEntityBackward() {
    int i = this.charIndex;
    while (true) {
      int j = this.charIndex;
      if (j > 0) {
        CharSequence charSequence = this.text;
        this.charIndex = --j;
        this.lastChar = charSequence.charAt(j);
        j = this.lastChar;
        if (j == 38)
          return 12; 
        if (j == 59)
          break; 
        continue;
      } 
      break;
    } 
    this.charIndex = i;
    this.lastChar = (char)';';
    return 13;
  }
  
  private byte skipEntityForward() {
    while (true) {
      int i = this.charIndex;
      if (i < this.length) {
        CharSequence charSequence = this.text;
        this.charIndex = i + 1;
        i = charSequence.charAt(i);
        this.lastChar = (char)i;
        if (i != 59)
          continue; 
      } 
      break;
    } 
    return 12;
  }
  
  private byte skipTagBackward() {
    int i = this.charIndex;
    label21: while (true) {
      int j = this.charIndex;
      if (j > 0) {
        CharSequence charSequence = this.text;
        this.charIndex = --j;
        this.lastChar = charSequence.charAt(j);
        j = this.lastChar;
        if (j == 60)
          return 12; 
        if (j == 62)
          break; 
        if (j == 34 || j == 39) {
          j = this.lastChar;
          while (true) {
            int k = this.charIndex;
            if (k > 0) {
              charSequence = this.text;
              this.charIndex = --k;
              k = charSequence.charAt(k);
              this.lastChar = (char)k;
              if (k != j)
                continue; 
              continue label21;
            } 
            continue label21;
          } 
        } 
        continue;
      } 
      break;
    } 
    this.charIndex = i;
    this.lastChar = (char)'>';
    return 13;
  }
  
  private byte skipTagForward() {
    int i = this.charIndex;
    label19: while (true) {
      int j = this.charIndex;
      if (j < this.length) {
        CharSequence charSequence = this.text;
        this.charIndex = j + 1;
        this.lastChar = charSequence.charAt(j);
        j = this.lastChar;
        if (j == 62)
          return 12; 
        if (j == 34 || j == 39) {
          j = this.lastChar;
          while (true) {
            int k = this.charIndex;
            if (k < this.length) {
              charSequence = this.text;
              this.charIndex = k + 1;
              k = charSequence.charAt(k);
              this.lastChar = (char)k;
              if (k != j)
                continue; 
              continue label19;
            } 
            continue label19;
          } 
          break;
        } 
        continue;
      } 
      this.charIndex = i;
      this.lastChar = (char)'<';
      return 13;
    } 
  }
  
  byte dirTypeBackward() {
    this.lastChar = this.text.charAt(this.charIndex - 1);
    if (Character.isLowSurrogate(this.lastChar)) {
      int i = Character.codePointBefore(this.text, this.charIndex);
      this.charIndex -= Character.charCount(i);
      return Character.getDirectionality(i);
    } 
    this.charIndex--;
    byte b = getCachedDirectionality(this.lastChar);
    byte b1 = b;
    if (this.isHtml) {
      char c = this.lastChar;
      if (c == '>') {
        b = skipTagBackward();
        b1 = b;
      } else {
        b1 = b;
        if (c == ';') {
          b = skipEntityBackward();
          b1 = b;
        } 
      } 
    } 
    return b1;
  }
  
  byte dirTypeForward() {
    this.lastChar = this.text.charAt(this.charIndex);
    if (Character.isHighSurrogate(this.lastChar)) {
      int i = Character.codePointAt(this.text, this.charIndex);
      this.charIndex += Character.charCount(i);
      return Character.getDirectionality(i);
    } 
    this.charIndex++;
    byte b = getCachedDirectionality(this.lastChar);
    byte b1 = b;
    if (this.isHtml) {
      char c = this.lastChar;
      if (c == '<') {
        b = skipTagForward();
        b1 = b;
      } else {
        b1 = b;
        if (c == '&') {
          b = skipEntityForward();
          b1 = b;
        } 
      } 
    } 
    return b1;
  }
  
  int getEntryDir() {
    this.charIndex = 0;
    byte b1 = 0;
    byte b = 0;
    byte b2 = 0;
    while (this.charIndex < this.length && !b1) {
      byte b3 = dirTypeForward();
      if (b3 != 9) {
        switch (b3) {
          default:
            switch (b3) {
              default:
                break;
              case 18:
                b2--;
                b = 0;
                continue;
              case 16:
              case 17:
                b2++;
                b = 1;
                continue;
              case 14:
              case 15:
                break;
            } 
            b2++;
            b = -1;
            continue;
          case 1:
          case 2:
            if (b2 == 0)
              return 1; 
            break;
          case 0:
            if (b2 == 0)
              return -1; 
            break;
        } 
        b1 = b2;
      } 
    } 
    if (b1 == 0)
      return 0; 
    if (b != 0)
      return b; 
    while (this.charIndex > 0) {
      switch (dirTypeBackward()) {
        default:
          continue;
        case 18:
          b2++;
          continue;
        case 16:
        case 17:
          if (b1 == b2)
            return 1; 
          b2--;
          continue;
        case 14:
        case 15:
          break;
      } 
      if (b1 == b2)
        return -1; 
      b2--;
    } 
    return 0;
  }
  
  int getExitDir() {
    this.charIndex = this.length;
    byte b1 = 0;
    byte b2 = 0;
    while (this.charIndex > 0) {
      byte b = dirTypeBackward();
      if (b != 9) {
        switch (b) {
          default:
            switch (b) {
              default:
                if (!b1)
                  break; 
                continue;
              case 18:
                b2++;
                continue;
              case 16:
              case 17:
                if (b1 == b2)
                  return 1; 
                b2--;
                continue;
              case 14:
              case 15:
                break;
            } 
            if (b1 == b2)
              return -1; 
            b2--;
            continue;
          case 1:
          case 2:
            if (b2 == 0)
              return 1; 
            if (b1 == 0)
              break; 
            continue;
          case 0:
            if (b2 == 0)
              return -1; 
            if (b1 == 0)
              break; 
            continue;
        } 
        b1 = b2;
      } 
    } 
    return 0;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\text\BidiFormatter$DirectionalityEstimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */