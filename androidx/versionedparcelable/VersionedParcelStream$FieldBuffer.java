package androidx.versionedparcelable;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class FieldBuffer {
  final DataOutputStream mDataStream = new DataOutputStream(this.mOutput);
  
  private final int mFieldId;
  
  final ByteArrayOutputStream mOutput = new ByteArrayOutputStream();
  
  private final DataOutputStream mTarget;
  
  FieldBuffer(int paramInt, DataOutputStream paramDataOutputStream) {
    this.mFieldId = paramInt;
    this.mTarget = paramDataOutputStream;
  }
  
  void flushField() throws IOException {
    int k;
    this.mDataStream.flush();
    int i = this.mOutput.size();
    int j = this.mFieldId;
    if (i >= 65535) {
      k = 65535;
    } else {
      k = i;
    } 
    this.mTarget.writeInt(j << 16 | k);
    if (i >= 65535)
      this.mTarget.writeInt(i); 
    this.mOutput.writeTo(this.mTarget);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\versionedparcelable\VersionedParcelStream$FieldBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */