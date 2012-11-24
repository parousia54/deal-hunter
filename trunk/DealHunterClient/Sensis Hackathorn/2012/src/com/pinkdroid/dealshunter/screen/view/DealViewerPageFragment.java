package com.pinkdroid.dealshunter.screen.view;

import com.pinkdroid.dealshunter.R;
import com.pinkdroid.dealshunter.controller.DealsHunterController;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class DealViewerPageFragment extends Fragment {
	public static final int POPULAR_PAGE_ID = 0;
	public static final int MOST_RECENT_PAGE_ID = 1;
	public static final int NEAR_BY_PAGE_ID = 2;
	public static final int END_SOON_PAGE_ID = 3;
	private int pageId;

	public static Fragment getNewInstance(int pageId) {
		DealViewerPageFragment page = new DealViewerPageFragment(pageId);
		return page;
	}

	private DealViewerPageFragment(int pageId) {
		super();
		this.pageId = pageId;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		ViewGroup root = (ViewGroup) inflater.inflate(R.layout.deal_viewer_fragment_page_layout, null);
		ListView list = (ListView) root.findViewById(R.id.deals_listview);

		DealListViewAdapter adapter = new DealListViewAdapter(this.getActivity(), DealsHunterController.getInstance().getDealList());
		list.setAdapter(adapter);

		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
				getActivity().showDialog(DealDetailDialog.DIALOG_TYPE_DEAL_DETAIL);
			}
		});
		return root;
	}
}
