package com.ybd.app;

import android.widget.ScrollView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.ybd.app.interf.GetDataSuccessListener;

public abstract class BaseScrollViewActivity extends BaseActivity implements
		GetDataSuccessListener {

	protected PullToRefreshScrollView mPullRefreshScrollView;

	public abstract PullToRefreshScrollView initScrollView();

	public abstract void refresh(GetDataSuccessListener getDataSuccessListener);

	public abstract void loadMoreData(int pageindex,
			GetDataSuccessListener getDataSuccessListener);

	public abstract void setDataToView(String tag, Object obj);

	public abstract void addItems(Object obj);

	protected int pageIndex = 1;

	@Override
	public void initViews() {
		mPullRefreshScrollView = initScrollView();
		mPullRefreshScrollView.setMode(Mode.BOTH);
		mPullRefreshScrollView
				.setOnRefreshListener(new OnRefreshListener2<ScrollView>() {

					@Override
					public void onPullDownToRefresh(
							PullToRefreshBase<ScrollView> refreshView) {
						pageIndex = 1;
						refresh(BaseScrollViewActivity.this);
					}

					@Override
					public void onPullUpToRefresh(
							PullToRefreshBase<ScrollView> refreshView) {
						++pageIndex;
						loadMoreData(pageIndex, BaseScrollViewActivity.this);
					}
				});

	}

	@Override
	public void initData() {
		refresh(this);
	}

	@Override
	public void onGetDataSuccess(String tag, Object obj) {
		mPullRefreshScrollView.onRefreshComplete();
		if (pageIndex == 1) {
			setDataToView(tag, obj);
		} else {
			addItems(obj);
		}

	}

}
