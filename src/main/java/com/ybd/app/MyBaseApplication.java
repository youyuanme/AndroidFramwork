package com.ybd.app;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MyBaseApplication extends Application {

	public List<Activity> list_activities;
	
	public static RequestQueue queue;

	@Override
	public void onCreate() {
		list_activities = new ArrayList<Activity>();

//		DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
//				.showImageForEmptyUri(R.drawable.ic_launcher)
//				.showImageOnFail(R.drawable.ic_launcher).cacheInMemory(true)
//				.cacheOnDisc(true).build();
//		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
//				getApplicationContext())
//				.defaultDisplayImageOptions(defaultOptions)
//				.discCacheSize(50 * 1024 * 1024).discCacheFileCount(100)
//				.writeDebugLogs().build();
//		ImageLoader.getInstance().init(config);
		
		queue = Volley.newRequestQueue(this);

		super.onCreate();
	}

}
