package co.id.bottomnavigationcustom;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class CustomVPNoPaging extends ViewPager {

    private boolean enabled;
    private View mCurrentView;

    public CustomVPNoPaging(Context context) {
        super(context);
    }

    public CustomVPNoPaging(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.enabled = true;
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        if (mCurrentView == null) {
//            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//            return;
//        }
//        int height = 0;
//        mCurrentView.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
//        int h = mCurrentView.getMeasuredHeight();
//        if (h > height) height = h;
//        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
//
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.enabled) {
            return super.onTouchEvent(event);
        }

        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.enabled) {
            return super.onInterceptTouchEvent(event);
        }

        return false;
    }

    public void setPagingEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean executeKeyEvent(KeyEvent event) {
        boolean handled = false;
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    handled = arrowScroll(FOCUS_LEFT);
                    break;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    handled = arrowScroll(FOCUS_RIGHT);
                    break;
                case KeyEvent.KEYCODE_TAB:
                    if (KeyEvent.metaStateHasModifiers(event.getMetaState(), KeyEvent.META_SHIFT_LEFT_ON)) {
                        handled = arrowScroll(FOCUS_FORWARD);
                    } else if (KeyEvent.metaStateHasModifiers(event.getMetaState(), KeyEvent.META_SHIFT_LEFT_ON)) {
                        handled = arrowScroll(FOCUS_BACKWARD);
                    }
                    break;
            }
        }
        return handled;
    }

//    public void measureCurrentView(View currentView) {
//        mCurrentView = currentView;
//        requestLayout();
//    }
//
//    public int measureFragment(View view) {
//        if (view == null)
//            return 0;
//
//        view.measure(0, 0);
//        return view.getMeasuredHeight();
//    }

}
