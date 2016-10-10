package com.ybd.app.viewpager;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

public class ViewPagerAdapter extends PagerAdapter {

	List<View> views;

	public ViewPagerAdapter(List<View> views) {
		super();
		this.views = views;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		((ViewPager)container).addView(views.get(position), 0);
		return views.get(position);
	}

	@Override
	public int getCount() {
		
		return views.size();
		
	}

	@Override
	public void destroyItem(View arg0, int arg1, Object arg2) {
		((ViewPager) arg0).removeView(views.get(arg1));
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		 return arg0 == (arg1);
	}

}
