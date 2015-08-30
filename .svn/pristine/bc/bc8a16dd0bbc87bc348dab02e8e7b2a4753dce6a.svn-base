package com.hzf.fragment;

import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnLastItemVisibleListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.hzf.R;

public abstract class BaseListFragment extends BaseFragment {
	protected PullToRefreshListView listView;
	protected int indexPage = 1;
	protected int pageSize = 20;
	protected LayoutInflater layoutInflater;
	protected boolean canLoadMore = true;
	protected RelativeLayout layParent;
	protected LinearLayout listTopLay, listBottomLay;
	protected Button hzf_btnErrorRefresh;

	@Override
	protected int getLayout() {
		// TODO Auto-generated method stub
		return R.layout.hzf_listfragment_base;
	}

	@Override
	protected void inited() {
		// TODO Auto-generated method stub
		layoutInflater = LayoutInflater.from(getActivity());
		hzf_btnErrorRefresh = (Button) findViewById(R.id.hzf_btnErrorRefresh);
		listTopLay = (LinearLayout) findViewById(R.id.listTopLay);
		listBottomLay = (LinearLayout) findViewById(R.id.listBottomLay);
		layParent = (RelativeLayout) findViewById(R.id.layParent);
		listView = (PullToRefreshListView) findViewById(R.id.pull_refresh_list);
		listView.setMode(Mode.BOTH);
		listView.setAdapter(getAdapter());

		// Set a listener to be invoked when the list should be refreshed.
//		listView.setOnRefreshListener(new OnRefreshListener<ListView>() {
//			@Override
//			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
//				String label = DateUtils.formatDateTime(getActivity()
//						.getApplicationContext(), System.currentTimeMillis(),
//						DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE
//								| DateUtils.FORMAT_ABBREV_ALL);
//
//				// Update the LastUpdatedLabel
//				refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
//				// Do work to refresh the list here.
//				refresh();
//			}
//		});
		listView.setOnRefreshListener(new OnRefreshListener2<ListView>() {

			@Override
			public void onPullDownToRefresh(
					PullToRefreshBase<ListView> refreshView) {
				// TODO Auto-generated method stub
				String label = DateUtils.formatDateTime(getActivity()
						.getApplicationContext(), System.currentTimeMillis(),
						DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE
								| DateUtils.FORMAT_ABBREV_ALL);

				// Update the LastUpdatedLabel
				refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
				// Do work to refresh the list here.
				refresh();
			}

			@Override
			public void onPullUpToRefresh(
					PullToRefreshBase<ListView> refreshView) {
				// TODO Auto-generated method stub
				if (canLoadMore) {
					loadMore();
				}
			}
			
		});
		// Add an end-of-list listener
//		listView.setOnLastItemVisibleListener(new OnLastItemVisibleListener() {
//
//			@Override
//			public void onLastItemVisible() {
//				if (canLoadMore) {
//					loadMore();
//				}
//			}
//		});
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				// TODO Auto-generated method stub
				position = position
						- listView.getRefreshableView().getHeaderViewsCount();
				// FQT.showShort(getActivity(), "position=" + position);
				onListItemClick(parent, view, position, id);
			}
		});
		initedView();
		getData(indexPage, pageSize);
	}

	protected void startRefresh() {
		listView.onRefreshing(true);
	}

	protected void stopRefresh() {
		listView.postDelayed(new Runnable() {
			@Override
			public void run() {

				listView.onRefreshComplete();
			}
		}, 300);
	}

	private void refresh() {
		indexPage = 1;
		getData(indexPage, pageSize);
	}

	private void loadMore() {
		indexPage++;
		getData(indexPage, pageSize);
	}

	public abstract void initedView();

	public abstract void getData(int indexPage, int pageSize);

	public abstract BaseAdapter getAdapter();

	public abstract void onListItemClick(AdapterView<?> parent, View view,
			int position, long id);

}
