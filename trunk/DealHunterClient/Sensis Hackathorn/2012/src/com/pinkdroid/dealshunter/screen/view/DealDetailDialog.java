package com.pinkdroid.dealshunter.screen.view;

import com.pinkdroid.dealshunter.R;
import com.pinkdroid.dealshunter.model.Deal;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;

public class DealDetailDialog extends Dialog{
	private Deal deal;
	private Context context;
	public static final int DIALOG_TYPE_DEAL_DETAIL = 0;
	public DealDetailDialog(Context context, Deal deal) {
		super(context);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.context=context;
		this.deal=deal;
		this.setContentView(R.layout.deal_detail_screen);
		this.setTitle("Deal details");
	}

}
