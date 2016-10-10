package com.ybd.app;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.ybd.app.interf.GetDataSuccessListener;

import android.view.View;
import android.widget.ScrollView;

public abstract class BaseScrollViewFragment extends BaseFragment implements
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
	public void initViews(View view) {
		mPullRefreshScrollView = initScrollView();
		mPullRefreshScrollView.setMode(Mode.BOTH);
		mPullRefreshScrollView
				.setOnRefreshListener(new OnRefreshListener2<ScrollView>() {

					@Override
					public void onPullDownToRefresh(
							PullToRefreshBase<ScrollView> refreshView) {
						pageIndex = 1;
						refresh(BaseScrollViewFragment.this);
					}

					@Override
					public void onPullUpToRefresh(
							PullToRefreshBase<ScrollView> refreshView) {
						++pageIndex;
						loadMoreData(pageIndex, BaseScrollViewFragment.this);
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
