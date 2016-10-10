package com.ybd.app;

import java.util.List;

import android.content.Context;
import android.widget.BaseAdapter;

public abstract class MyBaseAdapter<T> extends BaseAdapter {
	protected Context context;
	protected List<T> data;
	protected Object object;

	public MyBaseAdapter(Context context, List<T> data) {
		this.context = context;
		this.data = data;
	}

	public MyBaseAdapter(Context context, List<T> data, Object object) {
		this.context = context;
		this.data = data;
		this.object = object;
	}

	@Override
	public int getCount() {
		return data != null ? data.size() : 0;
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

}
