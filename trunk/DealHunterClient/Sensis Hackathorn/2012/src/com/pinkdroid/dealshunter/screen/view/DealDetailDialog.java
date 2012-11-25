package com.pinkdroid.dealshunter.screen.view;

import java.net.URLEncoder;

import com.pinkdroid.dealshunter.R;
import com.pinkdroid.dealshunter.controller.DealsHunterController;
import com.pinkdroid.dealshunter.model.Business;
import com.pinkdroid.dealshunter.model.Deal;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
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

		TextView deal_detail_screen_discount_description = (TextView) findViewById(R.id.deal_detail_screen_discount_description);
		deal_detail_screen_discount_description.setText(this.deal.getDiscountDescription());
		ImageView deal_detail_deal_image = (ImageView) findViewById(R.id.deal_detail_deal_image);
		
		Resources res = context.getResources();
		Business business = deal.getBusinessInfo();
		
		String deal_image = "deal_" + deal.getDealId();
		int resID = res.getIdentifier(deal_image, "drawable", context.getPackageName());
		Drawable drawable = res.getDrawable(resID);
		deal_detail_deal_image.setImageDrawable(drawable);
		
		TextView deal_detail_thumbup = (TextView) findViewById(R.id.deal_detail_thumbup);
		TextView deal_detail_thumbdown = (TextView) findViewById(R.id.deal_detail_thumbdown);
		deal_detail_thumbup.setText("" + deal.getFeedback().getThumbUpNo());
		deal_detail_thumbdown.setText("" + deal.getFeedback().getThumbDownNo());
		
		String mDrawableName = "business_icon_" + business.getLogoUrl();
		resID = res.getIdentifier(mDrawableName, "drawable", context.getPackageName());
		Drawable drawable1 = res.getDrawable(resID);
		ImageView businessLogo = (ImageView) findViewById(R.id.deal_listview_row_business_icon);
		businessLogo.setImageDrawable(drawable1);
		
		TextView businessNameTV = (TextView) findViewById(R.id.deal_listview_row_business_name);
		businessNameTV.setText(business.getBusinessName());
		
		if (business.isVerified()) {
			ImageView verifiedIcon = (ImageView) findViewById(R.id.deal_listview_row_verified_icon);
			verifiedIcon.setImageResource(R.drawable.verified);
		}
		
		TextView addressTV = (TextView) findViewById(R.id.deal_listview_row_business_address);
		addressTV.setText(business.getAddress().toString());
		
		TextView distanceTV = (TextView) findViewById(R.id.deal_detail_distance);
		distanceTV.setText(deal.getDistance() + "km away");
		
		long diff = deal.getEndTime().getTime() - System.currentTimeMillis();
		double diffIndays = diff / ((double) 24 * 60 * 60 * 1000);
		double diffInHours = (diffIndays - (int) diffIndays) * 24;
		String temp = "";
		if (((int) diffIndays) > 0) {
			temp += (int) diffIndays + "days";
		}
		if (((int) diffInHours) > 0) {
			if (!temp.equals("")) {
				temp += " " + (int) diffInHours + "hrs";
			} else {
				temp += (int) diffInHours + "hrs";
			}
		}
		TextView endTimeTV = (TextView) findViewById(R.id.deal_detail_end_time);
		endTimeTV.setText(temp + " left");
		
		TextView mapButton = (TextView) findViewById(R.id.deal_detail_mapview);
		mapButton.setFocusable(true);
		mapButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				double latitude_source = -37.818701;//York Butter Factory, Melbourne VIC 3000
				double longitude_source = 144.957571;
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
