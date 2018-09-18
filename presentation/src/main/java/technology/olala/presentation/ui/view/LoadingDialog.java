package technology.olala.presentation.ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import technology.olala.baseproject.R;

public class LoadingDialog extends Dialog {

    private final Handler mUI;
    private final Animation mLoadingAnimation;
    private final TextView mTvMessage;
    private final ImageView mIvLoading;
    private boolean mDetached;

    public LoadingDialog(Context context) {
        super(context, R.style.DialogTransparent);
        mUI = new Handler(Looper.getMainLooper());
        mLoadingAnimation = AnimationUtils.loadAnimation(context, R.anim.express_anim_progress);

        setContentView(R.layout.view_progress_dialog);
        mTvMessage = findViewById(R.id.opview_lab_title);
        mTvMessage.setVisibility(View.GONE);

        mIvLoading = findViewById(R.id.loading_image);

        mIvLoading.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        setOperationCancelable(false);
    }

    public void close() {
        try {
            this.dismiss();
        } catch (Exception e) {
            // not attach to window
            // fix based on http://stackoverflow.com/a/5102572/827110
        }
    }

    @Override
    protected void onStart() {
        mIvLoading.startAnimation(mLoadingAnimation);
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mIvLoading.clearAnimation();
    }

    public void setOperationCancelable(boolean cancel) {
        setCanceledOnTouchOutside(cancel);
        setCancelable(cancel);
    }

    public void setMessage(String msg) {
        if (TextUtils.isEmpty(msg)) {
            mTvMessage.setVisibility(View.GONE);
        } else {
            mTvMessage.setText(msg);
            mTvMessage.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void show() {
        mUI.removeCallbacks(DELAY_SHOW);
        mUI.post(DELAY_SHOW);
    }

    @Override
    public void dismiss() {
        mUI.removeCallbacks(DELAY_SHOW);
        if (isShowing() && !mDetached) {
            super.dismiss();
        }
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mDetached = true;
        mUI.removeCallbacksAndMessages(null);
    }

    private final Runnable DELAY_SHOW = new Runnable() {
        @Override
        public void run() {
            Context context = getContext();
            // avoid bad token
            if (context instanceof Activity && ((Activity) context).isFinishing()) {
                return;
            }

            LoadingDialog.super.show();
            mDetached = false;
        }
    };
}
