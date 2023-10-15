package androidx.asynclayoutinflater.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface OnInflateFinishedListener {
  void onInflateFinished(@NonNull View paramView, @LayoutRes int paramInt, @Nullable ViewGroup paramViewGroup);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\asynclayoutinflater\view\AsyncLayoutInflater$OnInflateFinishedListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */