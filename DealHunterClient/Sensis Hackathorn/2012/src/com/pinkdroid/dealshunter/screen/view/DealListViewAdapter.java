package com.pinkdroid.dealshunter.screen.view;

import java.util.List;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pinkdroid.dealshunter.R;
import com.pinkdroid.dealshunter.model.Business;
import com.pinkdroid.dealshunter.model.Deal;
import com.pinkdroid.dealshunter.model.Deal.UserFeedback;

public class DealListViewAdapter extends BaseAdapter {
	private Context context;
	private List<Deal> dealList;

	public DealListViewAdapter(Context context, List<Deal> dealList) {
		this.context = context;
		this.dealList = dealList;
	}

	@Override
	public int getCount() {
		return dealList.size();
	}

	@Override
	public Object getItem(int pos) {
		return dealList.get(pos);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.deal_listview_row_layout, null);
		}
		bindDataToView(convertView, dealList.get(position));

		//Typeface avenir65m = Typeface.createFromAsset(context.getAssets(), "fonts/avenir65m.ttf");
		Typeface avenir95bl = Typeface.createFromAsset(context.getAssets(), "fonts/avenir95bl.ttf");
		//TextView deal_listview_row_business_name = (TextView) convertView.findViewById(R.id.deal_listview_row_business_name);
		//deal_listview_row_business_name.setTypeface(avenir65m);
		//TextView deal_listview_row_business_address = (TextView) convertView.findViewById(R.id.deal_listview_row_business_address);
		//deal_listview_row_business_address.setTypeface(avenir95bl);
		TextView deal_listview_row_description = (TextView) convertView.findViewById(R.id.deal_listview_row_description);
		deal_listview_row_description.setTypeface(avenir95bl);
		return convertView;
	}

	private void bindDataToView(View convertView, Deal deal) {
		if (deal != null) {
			TextView businessNameTV, distanceTV, addressTV, discountDescriptionTV, thumbUpTV, thumbDownTV, endTimeTV;
			ImageView businessLogo, verifiedIcon, dealImage;

			businessNameTV = (TextView) convertView.findViewById(R.id.deal_listview_row_business_name);
			distanceTV = (TextView) convertView.findViewById(R.id.deal_listview_row_distance);
			addressTV = (TextView) convertView.findViewById(R.id.deal_listview_row_business_address);
			discountDescriptionTV = (TextView) convertView.findViewById(R.id.deal_listview_row_description);
			thumbUpTV = (TextView) convertView.findViewById(R.id.deal_listview_row_thumbup);
			thumbDownTV = (TextView) convertView.findViewById(R.id.deal_listview_row_thumbdown);
			endTimeTV = (TextView) convertView.findViewById(R.id.deal_listview_row_endtime);

			businessLogo = (ImageView) convertView.findViewById(R.id.deal_listview_row_business_icon);
			verifiedIcon = (ImageView) convertView.findViewById(R.id.deal_listview_row_verified_icon);
			dealImage = (ImageView) convertView.findViewById(R.id.deal_listview_row_icon);

			Business business = deal.getBusinessInfo();
			businessNameTV.setText(business.getBusinessName());
			addressTV.setText(business.getAddress().toString());

			Resources res = context.getResources();
			String mDrawableName = "business_icon_" + business.getLogoUrl();
			int resID = res.getIdentifier(mDrawableName, "drawable", context.getPackageName());
			Drawable drawable = res.getDrawable(resID);
			businessLogo.setImageDrawable(drawable);

			discountDescriptionTV.setText(deal.getDiscountDescription());
			distanceTV.setText("2km away");

			UserFeedback feedback = deal.getFeedback();
			thumbUpTV.setText("" + feedback.getThumbUpNo());
			thumbDownTV.setText("" + feedback.getThumbDownNo());

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
			endTimeTV.setText(temp + " left");

			String thumbnail = "thumbnail_" + deal.getDealId();
			int thumbnail_resID = res.getIdentifier(thumbnail, "drawable", context.getPackageName());
			Drawable drawable1 = res.getDrawable(thumbnail_resID);
			dealImage.setImageDrawable(drawable1);
			if (business.isVerified()) {
				verifiedIcon.setImageResource(R.drawable.verified);
			}
		}
	}
}
