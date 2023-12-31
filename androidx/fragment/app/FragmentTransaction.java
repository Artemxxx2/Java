package androidx.fragment.app;

import android.view.View;
import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

public abstract class FragmentTransaction {
  public static final int TRANSIT_ENTER_MASK = 4096;
  
  public static final int TRANSIT_EXIT_MASK = 8192;
  
  public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
  
  public static final int TRANSIT_FRAGMENT_FADE = 4099;
  
  public static final int TRANSIT_FRAGMENT_OPEN = 4097;
  
  public static final int TRANSIT_NONE = 0;
  
  public static final int TRANSIT_UNSET = -1;
  
  @NonNull
  public abstract FragmentTransaction add(@IdRes int paramInt, @NonNull Fragment paramFragment);
  
  @NonNull
  public abstract FragmentTransaction add(@IdRes int paramInt, @NonNull Fragment paramFragment, @Nullable String paramString);
  
  @NonNull
  public abstract FragmentTransaction add(@NonNull Fragment paramFragment, @Nullable String paramString);
  
  @NonNull
  public abstract FragmentTransaction addSharedElement(@NonNull View paramView, @NonNull String paramString);
  
  @NonNull
  public abstract FragmentTransaction addToBackStack(@Nullable String paramString);
  
  @NonNull
  public abstract FragmentTransaction attach(@NonNull Fragment paramFragment);
  
  public abstract int commit();
  
  public abstract int commitAllowingStateLoss();
  
  public abstract void commitNow();
  
  public abstract void commitNowAllowingStateLoss();
  
  @NonNull
  public abstract FragmentTransaction detach(@NonNull Fragment paramFragment);
  
  @NonNull
  public abstract FragmentTransaction disallowAddToBackStack();
  
  @NonNull
  public abstract FragmentTransaction hide(@NonNull Fragment paramFragment);
  
  public abstract boolean isAddToBackStackAllowed();
  
  public abstract boolean isEmpty();
  
  @NonNull
  public abstract FragmentTransaction remove(@NonNull Fragment paramFragment);
  
  @NonNull
  public abstract FragmentTransaction replace(@IdRes int paramInt, @NonNull Fragment paramFragment);
  
  @NonNull
  public abstract FragmentTransaction replace(@IdRes int paramInt, @NonNull Fragment paramFragment, @Nullable String paramString);
  
  @NonNull
  public abstract FragmentTransaction runOnCommit(@NonNull Runnable paramRunnable);
  
  @Deprecated
  public abstract FragmentTransaction setAllowOptimization(boolean paramBoolean);
  
  @NonNull
  public abstract FragmentTransaction setBreadCrumbShortTitle(@StringRes int paramInt);
  
  @NonNull
  public abstract FragmentTransaction setBreadCrumbShortTitle(@Nullable CharSequence paramCharSequence);
  
  @NonNull
  public abstract FragmentTransaction setBreadCrumbTitle(@StringRes int paramInt);
  
  @NonNull
  public abstract FragmentTransaction setBreadCrumbTitle(@Nullable CharSequence paramCharSequence);
  
  @NonNull
  public abstract FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int paramInt1, @AnimRes @AnimatorRes int paramInt2);
  
  @NonNull
  public abstract FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int paramInt1, @AnimRes @AnimatorRes int paramInt2, @AnimRes @AnimatorRes int paramInt3, @AnimRes @AnimatorRes int paramInt4);
  
  @NonNull
  public abstract FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment paramFragment);
  
  @NonNull
  public abstract FragmentTransaction setReorderingAllowed(boolean paramBoolean);
  
  @NonNull
  public abstract FragmentTransaction setTransition(int paramInt);
  
  @NonNull
  public abstract FragmentTransaction setTransitionStyle(@StyleRes int paramInt);
  
  @NonNull
  public abstract FragmentTransaction show(@NonNull Fragment paramFragment);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentTransaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */