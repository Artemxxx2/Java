package androidx.core.provider;

import java.util.ArrayList;

final class null implements SelfDestructiveThread.ReplyCallback<FontsContractCompat.TypefaceResult> {
  public void onReply(FontsContractCompat.TypefaceResult paramTypefaceResult) {
    synchronized (FontsContractCompat.sLock) {
      ArrayList<SelfDestructiveThread.ReplyCallback<FontsContractCompat.TypefaceResult>> arrayList = (ArrayList)FontsContractCompat.sPendingReplies.get(id);
      if (arrayList == null)
        return; 
      FontsContractCompat.sPendingReplies.remove(id);
      for (byte b = 0; b < arrayList.size(); b++)
        ((SelfDestructiveThread.ReplyCallback<FontsContractCompat.TypefaceResult>)arrayList.get(b)).onReply(paramTypefaceResult); 
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\provider\FontsContractCompat$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */