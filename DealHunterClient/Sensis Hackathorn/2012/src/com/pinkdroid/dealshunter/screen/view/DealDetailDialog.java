package com.pinkdroid.dealshunter.screen.view;

import java.net.URLEncoder;

import com.pinkdroid.dealshunter.R;
import com.pinkdroid.dealshunter.controller.DealsHunterController;
import com.pinkdroid.dealshunter.model.Deal;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class DealDetailDialog extends Dialog {
	private Deal deal;
	//private Context context;
	public static final int DIALOG_TYPE_DEAL_DETAIL = 0;

	public DealDetailDialog(Context context, final Deal deal) {
		super(context);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		//this.context = context;
		this.deal = deal;
		this.setContentView(R.layout.deal_detail_screen);
		this.setTitle("Deal details");

		TextView mapButton = (TextView) findViewById(R.id.deal_detail_mapview);
		mapButton.setFocusable(true);
		mapButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				double latitude_source = -37.81125;
				double longitude_source = 144.965601;
				if (DealsHunterController.userCurrGeoPoint != null) {
					latitude_source = DealsHunterController.userCurrGeoPoint.getLatitudeE6() / 10E6;
					longitude_source = DealsHunterController.userCurrGeoPoint.getLatitudeE6() / 10E6;
				}
				Intent intent;
				if (deal != null && deal.getBusinessInfo().getAddress() != null) {
					@SuppressWarnings("deprecation")
					String encodedBBaddress = URLEncoder.encode(deal.getBusinessInfo().getAddress().toString());
					intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr=" + latitude_source + "," + longitude_source + "&daddr=" + encodedBBaddress));
				} else {
					double latitude_dest = -37.86822;
					double longitude_dest = 144.99059;
					intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr=" + latitude_source + "," + longitude_source + "&daddr=" + latitude_dest + "," + longitude_dest));
				}
				getContext().startActivity(intent);
			}
		});
	}
}
