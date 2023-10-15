package androidx.versionedparcelable;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

class null extends ObjectInputStream {
  null(InputStream paramInputStream) {
    super(paramInputStream);
  }
  
  protected Class<?> resolveClass(ObjectStreamClass paramObjectStreamClass) throws IOException, ClassNotFoundException {
    Class<?> clazz = Class.forName(paramObjectStreamClass.getName(), false, getClass().getClassLoader());
    return (clazz != null) ? clazz : super.resolveClass(paramObjectStreamClass);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\versionedparcelable\VersionedParcel$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */