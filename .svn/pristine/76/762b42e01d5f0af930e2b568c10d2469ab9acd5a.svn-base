package com.hzf.widget;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.hzf.R;

/**
 * 
 * LoadingDialog.java
 * 
 * @author zongfa_he
 * @version
 * @since 2014-7-15 下午7:41:05
 * @description 加载中view
 */
public class LoadingDialog extends Dialog {
	TextView loading_content;

	/**
	 * @param context
	 */
	public LoadingDialog(Context context) {
		super(context, R.style.loadingdialog);
		init();
	}

	private void init() {
		this.setContentView(R.layout.custom_dialog);
		this.setCanceledOnTouchOutside(false);
		this.setCancelable(false);
		loading_content = (TextView) findViewById(R.id.dialog_text);

	}

	/**
	 * loading dialog
	 * 
	 * @param string
	 * @author yuquan.Zhu
	 * @CreateDate 2014-3-5
	 */
	public void setLoadingText(String string) {
		loading_content.setText(string);
	}

}
