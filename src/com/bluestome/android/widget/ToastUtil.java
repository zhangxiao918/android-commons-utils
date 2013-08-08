
package com.bluestome.android.widget;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.bluestome.android.utils.R;

public class ToastUtil {

    private ToastUtil() {

    }

    private static Toast mToast = null;

    /**
     * @param context 应用上下文
     * @param textColor 字体颜色
     * @param title 内容
     * @param duration 时长
     */
    public static void resultNotify(Context context, int textColor, String title, int duration) {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
        mToast = new Toast(context);
        TextView view = new TextView(context);
        view.setBackgroundResource(R.drawable.trans_bg);
        view.setText(title);
        view.setGravity(Gravity.CENTER);
        view.setTextColor(textColor);
        mToast.setView(view);
        mToast.setDuration(duration);
        mToast.show();
    }

    public static void resultNotify(Context context, String title, int duration) {
        resultNotify(context, Color.WHITE, title, duration);
    }

    public static void resultNotify(Context context, int textColor, String title) {
        resultNotify(context, textColor, title, Toast.LENGTH_LONG);
    }

    public static void resultNotify(Context context, String title) {
        resultNotify(context, title, Toast.LENGTH_LONG);
    }
}
