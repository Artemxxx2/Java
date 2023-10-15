package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;

public class PathDataNode {
  public float[] mParams;
  
  public char mType;
  
  PathDataNode(char paramChar, float[] paramArrayOffloat) {
    this.mType = (char)paramChar;
    this.mParams = paramArrayOffloat;
  }
  
  PathDataNode(PathDataNode paramPathDataNode) {
    this.mType = (char)paramPathDataNode.mType;
    float[] arrayOfFloat = paramPathDataNode.mParams;
    this.mParams = PathParser.copyOfRange(arrayOfFloat, 0, arrayOfFloat.length);
  }
  
  private static void addCommand(Path paramPath, float[] paramArrayOffloat1, int paramChar1, int paramChar2, float[] paramArrayOffloat2) {
    int i;
    byte b;
    Path path = paramPath;
    float f1 = paramArrayOffloat1[0];
    float f2 = paramArrayOffloat1[1];
    float f3 = paramArrayOffloat1[2];
    float f4 = paramArrayOffloat1[3];
    float f5 = paramArrayOffloat1[4];
    float f6 = paramArrayOffloat1[5];
    switch (paramChar2) {
      default:
        b = 2;
        break;
      case 'Z':
      case 'z':
        paramPath.close();
        path.moveTo(f5, f6);
        f1 = f5;
        f3 = f1;
        f2 = f6;
        f4 = f2;
        b = 2;
        break;
      case 'Q':
      case 'S':
      case 'q':
      case 's':
        b = 4;
        break;
      case 'L':
      case 'M':
      case 'T':
      case 'l':
      case 'm':
      case 't':
        b = 2;
        break;
      case 'H':
      case 'V':
      case 'h':
      case 'v':
        b = 1;
        break;
      case 'C':
      case 'c':
        b = 6;
        break;
      case 'A':
      case 'a':
        b = 7;
        break;
    } 
    float f7 = f2;
    f2 = f5;
    int j = 0;
    int k = paramChar1;
    f5 = f6;
    f6 = f2;
    paramChar1 = j;
    f2 = f1;
    f1 = f7;
    while (i < paramArrayOffloat2.length) {
      int m;
      int n;
      float f8;
      int i1;
      float f9;
      int i2;
      boolean bool1;
      boolean bool2;
      f7 = 0.0F;
      switch (paramChar2) {
        case 'v':
          k = i + 0;
          path.rLineTo(0.0F, paramArrayOffloat2[k]);
          f1 += paramArrayOffloat2[k];
          break;
        case 't':
          if (k == 113 || k == 116 || k == 81 || k == 84) {
            f3 = f2 - f3;
            f4 = f1 - f4;
          } else {
            f4 = 0.0F;
            f3 = f7;
          } 
          k = i + 0;
          f7 = paramArrayOffloat2[k];
          j = i + 1;
          path.rQuadTo(f3, f4, f7, paramArrayOffloat2[j]);
          f7 = f2 + paramArrayOffloat2[k];
          f8 = f1 + paramArrayOffloat2[j];
          f4 += f1;
          f3 += f2;
          f1 = f8;
          f2 = f7;
          break;
        case 's':
          if (k == 99 || k == 115 || k == 67 || k == 83) {
            f4 = f1 - f4;
            f3 = f2 - f3;
          } else {
            f3 = 0.0F;
            f4 = 0.0F;
          } 
          m = i + 0;
          f8 = paramArrayOffloat2[m];
          i1 = i + 1;
          f7 = paramArrayOffloat2[i1];
          n = i + 2;
          f9 = paramArrayOffloat2[n];
          i2 = i + 3;
          paramPath.rCubicTo(f3, f4, f8, f7, f9, paramArrayOffloat2[i2]);
          f3 = paramArrayOffloat2[m];
          f4 = paramArrayOffloat2[i1];
          f7 = f2 + paramArrayOffloat2[n];
          f8 = f1 + paramArrayOffloat2[i2];
          f3 += f2;
          f4 += f1;
          f1 = f8;
          f2 = f7;
          break;
        case 'q':
          i1 = i + 0;
          f4 = paramArrayOffloat2[i1];
          n = i + 1;
          f3 = paramArrayOffloat2[n];
          i2 = i + 2;
          f7 = paramArrayOffloat2[i2];
          m = i + 3;
          path.rQuadTo(f4, f3, f7, paramArrayOffloat2[m]);
          f3 = paramArrayOffloat2[i1];
          f4 = paramArrayOffloat2[n];
          f7 = f2 + paramArrayOffloat2[i2];
          f8 = f1 + paramArrayOffloat2[m];
          f3 += f2;
          f4 += f1;
          f1 = f8;
          f2 = f7;
          break;
        case 'm':
          n = i + 0;
          f2 += paramArrayOffloat2[n];
          m = i + 1;
          f1 += paramArrayOffloat2[m];
          if (i > 0) {
            path.rLineTo(paramArrayOffloat2[n], paramArrayOffloat2[m]);
            break;
          } 
          path.rMoveTo(paramArrayOffloat2[n], paramArrayOffloat2[m]);
          f5 = f1;
          f6 = f2;
          break;
        case 'l':
          m = i + 0;
          f7 = paramArrayOffloat2[m];
          n = i + 1;
          path.rLineTo(f7, paramArrayOffloat2[n]);
          f2 += paramArrayOffloat2[m];
          f1 += paramArrayOffloat2[n];
          break;
        case 'h':
          n = i + 0;
          path.rLineTo(paramArrayOffloat2[n], 0.0F);
          f2 += paramArrayOffloat2[n];
          break;
        case 'c':
          f8 = paramArrayOffloat2[i + 0];
          f3 = paramArrayOffloat2[i + 1];
          m = i + 2;
          f9 = paramArrayOffloat2[m];
          n = i + 3;
          f7 = paramArrayOffloat2[n];
          i1 = i + 4;
          f4 = paramArrayOffloat2[i1];
          i2 = i + 5;
          paramPath.rCubicTo(f8, f3, f9, f7, f4, paramArrayOffloat2[i2]);
          f3 = paramArrayOffloat2[m];
          f4 = paramArrayOffloat2[n];
          f7 = f2 + paramArrayOffloat2[i1];
          f8 = f1 + paramArrayOffloat2[i2];
          f3 += f2;
          f4 += f1;
          f1 = f8;
          f2 = f7;
          break;
        case 'a':
          m = i + 5;
          f3 = paramArrayOffloat2[m];
          n = i + 6;
          f7 = paramArrayOffloat2[n];
          f9 = paramArrayOffloat2[i + 0];
          f4 = paramArrayOffloat2[i + 1];
          f8 = paramArrayOffloat2[i + 2];
          if (paramArrayOffloat2[i + 3] != 0.0F) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          if (paramArrayOffloat2[i + 4] != 0.0F) {
            bool2 = true;
          } else {
            bool2 = false;
          } 
          drawArc(paramPath, f2, f1, f3 + f2, f7 + f1, f9, f4, f8, bool1, bool2);
          f2 += paramArrayOffloat2[m];
          f1 += paramArrayOffloat2[n];
          f4 = f1;
          f3 = f2;
          path = paramPath;
          break;
        case 'V':
          n = i + 0;
          f1 = paramArrayOffloat2[n];
          path = paramPath;
          path.lineTo(f2, f1);
          f1 = paramArrayOffloat2[n];
          break;
        case 'T':
          f8 = f1;
          f7 = f2;
          m = i;
        case 'S':
          m = i;
          if (n == 99 || n == 115 || n == 67 || n == 83) {
            f1 = f1 * 2.0F - f4;
            f2 = f2 * 2.0F - f3;
          } 
          i2 = m + 0;
          f4 = paramArrayOffloat2[i2];
          i1 = m + 1;
          f7 = paramArrayOffloat2[i1];
          n = m + 2;
          f3 = paramArrayOffloat2[n];
          m += 3;
          paramPath.cubicTo(f2, f1, f4, f7, f3, paramArrayOffloat2[m]);
          f3 = paramArrayOffloat2[i2];
          f4 = paramArrayOffloat2[i1];
          f2 = paramArrayOffloat2[n];
          f1 = paramArrayOffloat2[m];
          break;
        case 'Q':
          n = i;
          i1 = n + 0;
          f1 = paramArrayOffloat2[i1];
          i2 = n + 1;
          f3 = paramArrayOffloat2[i2];
          m = n + 2;
          f2 = paramArrayOffloat2[m];
          n += 3;
          path.quadTo(f1, f3, f2, paramArrayOffloat2[n]);
          f3 = paramArrayOffloat2[i1];
          f4 = paramArrayOffloat2[i2];
          f2 = paramArrayOffloat2[m];
          f1 = paramArrayOffloat2[n];
          break;
        case 'M':
          n = i;
          m = n + 0;
          f2 = paramArrayOffloat2[m];
          i1 = n + 1;
          f1 = paramArrayOffloat2[i1];
          if (n > 0) {
            path.lineTo(paramArrayOffloat2[m], paramArrayOffloat2[i1]);
            break;
          } 
          path.moveTo(paramArrayOffloat2[m], paramArrayOffloat2[i1]);
          f5 = f1;
          f6 = f2;
          break;
        case 'L':
          n = i;
          m = n + 0;
          f1 = paramArrayOffloat2[m];
          path.lineTo(f1, paramArrayOffloat2[++n]);
          f2 = paramArrayOffloat2[m];
          f1 = paramArrayOffloat2[n];
          break;
        case 'H':
          n = i + 0;
          path.lineTo(paramArrayOffloat2[n], f1);
          f2 = paramArrayOffloat2[n];
          break;
        case 'C':
          n = i;
          f3 = paramArrayOffloat2[n + 0];
          f7 = paramArrayOffloat2[n + 1];
          i2 = n + 2;
          f4 = paramArrayOffloat2[i2];
          m = n + 3;
          f1 = paramArrayOffloat2[m];
          i1 = n + 4;
          f2 = paramArrayOffloat2[i1];
          n += 5;
          paramPath.cubicTo(f3, f7, f4, f1, f2, paramArrayOffloat2[n]);
          f2 = paramArrayOffloat2[i1];
          f1 = paramArrayOffloat2[n];
          f3 = paramArrayOffloat2[i2];
          f4 = paramArrayOffloat2[m];
          break;
        case 'A':
          n = i;
          i1 = n + 5;
          f4 = paramArrayOffloat2[i1];
          m = n + 6;
          f9 = paramArrayOffloat2[m];
          f8 = paramArrayOffloat2[n + 0];
          f3 = paramArrayOffloat2[n + 1];
          f7 = paramArrayOffloat2[n + 2];
          if (paramArrayOffloat2[n + 3] != 0.0F) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          if (paramArrayOffloat2[n + 4] != 0.0F) {
            bool2 = true;
          } else {
            bool2 = false;
          } 
          drawArc(paramPath, f2, f1, f4, f9, f8, f3, f7, bool1, bool2);
          f2 = paramArrayOffloat2[i1];
          f1 = paramArrayOffloat2[m];
          f4 = f1;
          f3 = f2;
          break;
      } 
      continue;
      i = paramChar1 + b;
      k = paramChar2;
    } 
    paramArrayOffloat1[0] = f2;
    paramArrayOffloat1[1] = f1;
    paramArrayOffloat1[2] = f3;
    paramArrayOffloat1[3] = f4;
    paramArrayOffloat1[4] = f6;
    paramArrayOffloat1[5] = f5;
  }
  
  private static void arcToBezier(Path paramPath, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9) {
    int i = (int)Math.ceil(Math.abs(paramDouble9 * 4.0D / Math.PI));
    double d1 = Math.cos(paramDouble7);
    double d2 = Math.sin(paramDouble7);
    double d3 = Math.cos(paramDouble8);
    double d4 = Math.sin(paramDouble8);
    paramDouble7 = -paramDouble3;
    double d5 = paramDouble7 * d1;
    double d6 = paramDouble4 * d2;
    double d7 = paramDouble7 * d2;
    double d8 = paramDouble4 * d1;
    paramDouble4 = i;
    Double.isNaN(paramDouble4);
    double d9 = paramDouble9 / paramDouble4;
    paramDouble7 = d4 * d7 + d3 * d8;
    paramDouble4 = d5 * d4 - d6 * d3;
    byte b = 0;
    d3 = paramDouble8;
    paramDouble9 = paramDouble6;
    paramDouble8 = paramDouble4;
    paramDouble4 = d7;
    d7 = d9;
    paramDouble6 = d2;
    while (true) {
      d9 = paramDouble3;
      if (b < i) {
        d4 = d3 + d7;
        double d10 = Math.sin(d4);
        double d11 = Math.cos(d4);
        d2 = paramDouble1 + d9 * d1 * d11 - d6 * d10;
        double d12 = paramDouble2 + d9 * paramDouble6 * d11 + d8 * d10;
        d9 = d5 * d10 - d6 * d11;
        d11 = d10 * paramDouble4 + d11 * d8;
        d3 = d4 - d3;
        d10 = Math.tan(d3 / 2.0D);
        d3 = Math.sin(d3) * (Math.sqrt(d10 * 3.0D * d10 + 4.0D) - 1.0D) / 3.0D;
        paramPath.rLineTo(0.0F, 0.0F);
        paramPath.cubicTo((float)(paramDouble5 + paramDouble8 * d3), (float)(paramDouble9 + paramDouble7 * d3), (float)(d2 - d3 * d9), (float)(d12 - d3 * d11), (float)d2, (float)d12);
        b++;
        paramDouble9 = d12;
        d3 = d4;
        paramDouble7 = d11;
        paramDouble8 = d9;
        paramDouble5 = d2;
        continue;
      } 
      break;
    } 
  }
  
  private static void drawArc(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, boolean paramBoolean1, boolean paramBoolean2) {
    double d1 = Math.toRadians(paramFloat7);
    double d2 = Math.cos(d1);
    double d3 = Math.sin(d1);
    double d4 = paramFloat1;
    Double.isNaN(d4);
    double d5 = paramFloat2;
    Double.isNaN(d5);
    double d6 = paramFloat5;
    Double.isNaN(d6);
    double d7 = (d4 * d2 + d5 * d3) / d6;
    double d8 = -paramFloat1;
    Double.isNaN(d8);
    Double.isNaN(d5);
    double d9 = paramFloat6;
    Double.isNaN(d9);
    double d10 = (d8 * d3 + d5 * d2) / d9;
    double d11 = paramFloat3;
    Double.isNaN(d11);
    d8 = paramFloat4;
    Double.isNaN(d8);
    Double.isNaN(d6);
    double d12 = (d11 * d2 + d8 * d3) / d6;
    d11 = -paramFloat3;
    Double.isNaN(d11);
    Double.isNaN(d8);
    Double.isNaN(d9);
    double d13 = (d11 * d3 + d8 * d2) / d9;
    double d14 = d7 - d12;
    double d15 = d10 - d13;
    d11 = (d7 + d12) / 2.0D;
    d8 = (d10 + d13) / 2.0D;
    double d16 = d14 * d14 + d15 * d15;
    if (d16 == 0.0D) {
      Log.w("PathParser", " Points are coincident");
      return;
    } 
    double d17 = 1.0D / d16 - 0.25D;
    if (d17 < 0.0D) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Points are too far apart ");
      stringBuilder.append(d16);
      Log.w("PathParser", stringBuilder.toString());
      float f = (float)(Math.sqrt(d16) / 1.99999D);
      drawArc(paramPath, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5 * f, paramFloat6 * f, paramFloat7, paramBoolean1, paramBoolean2);
      return;
    } 
    d17 = Math.sqrt(d17);
    d14 *= d17;
    d15 = d17 * d15;
    if (paramBoolean1 == paramBoolean2) {
      d11 -= d15;
      d8 += d14;
    } else {
      d11 += d15;
      d8 -= d14;
    } 
    d15 = Math.atan2(d10 - d8, d7 - d11);
    d10 = Math.atan2(d13 - d8, d12 - d11) - d15;
    if (d10 >= 0.0D) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    } 
    d7 = d10;
    if (paramBoolean2 != paramBoolean1)
      if (d10 > 0.0D) {
        d7 = d10 - 6.283185307179586D;
      } else {
        d7 = d10 + 6.283185307179586D;
      }  
    Double.isNaN(d6);
    d11 *= d6;
    Double.isNaN(d9);
    d8 *= d9;
    arcToBezier(paramPath, d11 * d2 - d8 * d3, d11 * d3 + d8 * d2, d6, d9, d4, d5, d1, d15, d7);
  }
  
  public static void nodesToPath(PathDataNode[] paramArrayOfPathDataNode, Path paramPath) {
    float[] arrayOfFloat = new float[6];
    char c1 = 'm';
    byte b = 0;
    char c2;
    for (c2 = c1; b < paramArrayOfPathDataNode.length; c2 = c1) {
      addCommand(paramPath, arrayOfFloat, c2, (paramArrayOfPathDataNode[b]).mType, (paramArrayOfPathDataNode[b]).mParams);
      c1 = (paramArrayOfPathDataNode[b]).mType;
      b++;
    } 
  }
  
  public void interpolatePathDataNode(PathDataNode paramPathDataNode1, PathDataNode paramPathDataNode2, float paramFloat) {
    this.mType = (char)paramPathDataNode1.mType;
    byte b = 0;
    while (true) {
      float[] arrayOfFloat = paramPathDataNode1.mParams;
      if (b < arrayOfFloat.length) {
        this.mParams[b] = arrayOfFloat[b] * (1.0F - paramFloat) + paramPathDataNode2.mParams[b] * paramFloat;
        b++;
        continue;
      } 
      break;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\graphics\PathParser$PathDataNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */