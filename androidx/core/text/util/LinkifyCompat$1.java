package androidx.core.text.util;

import java.util.Comparator;

final class null implements Comparator<LinkifyCompat.LinkSpec> {
  public int compare(LinkifyCompat.LinkSpec paramLinkSpec1, LinkifyCompat.LinkSpec paramLinkSpec2) {
    return (paramLinkSpec1.start < paramLinkSpec2.start) ? -1 : ((paramLinkSpec1.start > paramLinkSpec2.start) ? 1 : ((paramLinkSpec1.end < paramLinkSpec2.end) ? 1 : ((paramLinkSpec1.end > paramLinkSpec2.end) ? -1 : 0)));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\tex\\util\LinkifyCompat$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */