package com.pinkdroid.dealshunter.screen.view;

import java.util.List;

import com.pinkdroid.dealshunter.R;
import com.pinkdroid.dealshunter.model.Deal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
		}
		return convertView;
	}

}
