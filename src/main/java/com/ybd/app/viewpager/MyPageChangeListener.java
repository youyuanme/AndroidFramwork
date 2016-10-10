package com.ybd.app.viewpager;

import android.support.v4.view.ViewPager.OnPageChangeListener;

public class MyPageChangeListener implements OnPageChangeListener {

	PageSelectedListener pageSelectedListener;
	PageScrolledListener pageScrolledListener;

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		if (pageScrolledListener != null) {
			pageScrolledListener.scrolled(arg0, arg1, arg2);
		}

	}

	@Override
	public void onPageSelected(int arg0) {
		if (pageSelectedListener != null) {
			pageSelectedListener.selected(arg0);
		}
	}

	public void setOnPageSelectedListener(
			PageSelectedListener pageSelectedListener) {
		this.pageSelectedListener = pageSelectedListener;
	}
	
	public void setOnPageScrolledListener(
			PageScrolledListener pageScrolledListener) {
		this.pageScrolledListener = pageScrolledListener;
	}

	public interface PageSelectedListener {
		void selected(int index);
	}
	
	public interface PageScrolledListener {
		void scrolled(int arg0, float arg1, int arg2);
	}

}
