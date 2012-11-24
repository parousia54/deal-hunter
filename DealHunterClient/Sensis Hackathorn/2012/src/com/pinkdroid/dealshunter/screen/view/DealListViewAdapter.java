package com.pinkdroid.dealshunter.screen.view;

import java.util.List;

import com.pinkdroid.dealshunter.R;
import com.pinkdroid.dealshunter.model.Business;
import com.pinkdroid.dealshunter.model.Deal;
import com.pinkdroid.dealshunter.model.Deal.UserFeedback;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DealListViewAdapter extends BaseAdapter{
	private Context context;
	private List<Deal> dealList;
	public DealListViewAdapter(Context context, List<Deal> dealList){
		this.context = context;
		this.dealList = dealList;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	public Object getItem(int pos) {
		// TODO Auto-generated method stub
		return dealList.get(pos);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.deal_listview_row_layout, null);
			//bindDataToView(convertView, dealList.get(position));
		}
		return convertView;
	}
	
	private void bindDataToView(View convertView, Deal deal){
		if(deal!=null){
			//Todo:Download images to put into the Image View here (or can use it online)
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
			businessLogo.setImageURI(Uri.parse(business.getLogoUrl()));
			//Todo; download and set logo here
			
			discountDescriptionTV.setText(deal.getDiscountDescription());
			distanceTV.setText(String.valueOf(deal.getDistance())+"km away");
			
			UserFeedback feedback = deal.getFeedback();
			thumbUpTV.setText(feedback.getThumbUpNo());
			thumbDownTV.setText(feedback.getThumbDownNo());
			
			endTimeTV.setText(deal.getEndTime().toString());
			dealImage.setImageURI(Uri.parse(deal.getImageUrl()));
			verifiedIcon.setImageResource(R.drawable.verified);
		}
		
	}
}
