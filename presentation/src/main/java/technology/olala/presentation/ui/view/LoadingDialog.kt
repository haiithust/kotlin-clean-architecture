package technology.olala.presentation.ui.view

import android.app.Dialog
import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import technology.olala.baseproject.R

class LoadingDialog(context: Context) : Dialog(context, R.style.DialogTransparent) {
    private val animation: Animation = AnimationUtils.loadAnimation(context, R.anim.anim_progress)
    private val ivLoading: ImageView

    override fun onStart() {
        super.onStart()
        ivLoading.startAnimation(animation)
    }

    override fun onStop() {
        ivLoading.clearAnimation()
        super.onStop()
    }

    init {
        setContentView(R.layout.view_progress_dialog)
        ivLoading = findViewById(R.id.iv_loading)
        setCanceledOnTouchOutside(false)
        setCancelable(false)
    }
}