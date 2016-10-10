package com.ybd.app;

import java.util.List;

import android.widget.GridView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.ybd.app.interf.GetDataSuccessListener;

public abstract class BaseGridActivity<T> extends BaseActivity implements
		GetDataSuccessListener {

	protected PullToRefreshGridView mPullRefreshGridView;
	protected GridView mGridView;

	protected List<T> listData;

	protected MyBaseAdapter<T> adapter;

	protected int pageIndex = 1;

	public abstract PullToRefreshGridView initGridView();

	public abstract void refresh(int pageindex,
			GetDataSuccessListener getDataSuccessListener);

	public abstract MyBaseAdapter<T> getAdapter(List<T> list);

	@Override
	public void initViews() {
		mPullRefreshGridView = initGridView();
		mGridView = mPullRefreshGridView.getRefreshableView();
		mPullRefreshGridView
				.setOnRefreshListener(new OnRefreshListener2<GridView>() {

					@Override
					public void onPullDownToRefresh(
							PullToRefreshBase<GridView> refreshView) {
						pageIndex = 1;
						refresh(pageIndex, BaseGridActivity.this);
					}

					@Override
					public void onPullUpToRefresh(
							PullToRefreshBase<GridView> refreshView) {
						pageIndex = pageIndex + 1;
						refresh(pageIndex, BaseGridActivity.this);
					}
				});
	}

	@Override
	public void initData() {
		refresh(pageIndex, this);

	}

	@Override
	public void onGetDataSuccess(String tag, Object obj) {
		mPullRefreshGridView.onRefreshComplete();
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
			mGridView.setAdapter(adapter);
		} else {
			adapter.notifyDataSetChanged();
		}

	}

}
