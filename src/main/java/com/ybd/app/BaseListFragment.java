package com.ybd.app;

import java.util.List;

import android.text.format.DateUtils;
import android.view.View;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.ybd.app.interf.GetDataSuccessListener;


public abstract class BaseListFragment<T> extends BaseFragment implements GetDataSuccessListener {
	
	protected PullToRefreshListView mPullRefreshListView;

	protected List<T> listData;

	protected MyBaseAdapter<T> adapter;

	protected int pageIndex = 1;

	public abstract PullToRefreshListView initListView();

	public abstract void refresh(int pageindex,
			GetDataSuccessListener getDataSuccessListener);

	public abstract MyBaseAdapter<T> getAdapter(List<T> list);

	@Override
	public void initViews(View view) {
		mPullRefreshListView = initListView();
		mPullRefreshListView.setMode(Mode.BOTH);
		
		mPullRefreshListView
		.setOnRefreshListener(new OnRefreshListener2<ListView>() {

			@Override
			public void onPullDownToRefresh(
					PullToRefreshBase<ListView> refreshView) {
				String label = DateUtils.formatDateTime(
						getActivity(),
						System.currentTimeMillis(),
						DateUtils.FORMAT_SHOW_TIME
								| DateUtils.FORMAT_SHOW_DATE
								| DateUtils.FORMAT_ABBREV_ALL);

				// Update the LastUpdatedLabel
				refreshView.getLoadingLayoutProxy()
						.setLastUpdatedLabel(label);

				pageIndex = 1;
				refresh(pageIndex, BaseListFragment.this);
				
			}

			@Override
			public void onPullUpToRefresh(
					PullToRefreshBase<ListView> refreshView) {
				pageIndex = pageIndex + 1;
				refresh(pageIndex, BaseListFragment.this);
			}
		});

	}

	@Override
	public void initData() {
		refresh(pageIndex, BaseListFragment.this);

	}
	
	
	@Override
	public void onGetDataSuccess(String tag, Object obj) {
		mPullRefreshListView.onRefreshComplete();
		List<T> dataThisTime = (List<T>) obj;
		if ("1".equals(tag)) {
			listData = dataThisTime;
		} else {
			if (dataThisTime != null) {
				listData.addAll(dataThisTime);
			}
		}

		if ("1".equals(tag)) {
			adapter = getAdapter(listData);
			mPullRefreshListView.setAdapter(adapter);
		} else {
			adapter.notifyDataSetChanged();
		}

	}

}
