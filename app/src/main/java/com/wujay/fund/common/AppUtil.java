package com.wujay.fund.common;

import android.content.Context;
import android.view.WindowManager;

public class AppUtil {

	/**
	 * 获取屏幕分辨率
	 * @param context
	 * @return
	 */
	public static int[] getScreenDispaly(Context context) {
		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		int width = windowManager.getDefaultDisplay().getWidth();// 手机屏幕的宽度
		int height = windowManager.getDefaultDisplay().getHeight();// 手机屏幕的高度
		int result[] = { width, height };
		return result;
	}

}
