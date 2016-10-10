package com.ybd.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import com.ybd.app.interf.IsNetConnectedListener;
import com.ybd.app.interf.IsUserLoginListener;
import com.ybd.app.tools.PreferenceHelper;
import com.ybd.app.tools.Tools;

public abstract class BaseActivity extends FragmentActivity {

	MyBaseApplication myApp;
	
	public abstract void onCreateThisActivity();

	public abstract void initViews();

	public abstract void initData();

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		myApp = (MyBaseApplication) getApplication();
		myApp.list_activities.add(this);
	
		onCreateThisActivity();
		
		initViews();
		
		initData();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		myApp.list_activities.remove(this);
	}

	/**
	 * 是否联网
	 * 
	 * @param isNetConnectedListener
	 */
	protected void isNetUseful(IsNetConnectedListener isNetConnectedListener) {
		boolean connected = Tools.isConnected(this);
		if (connected) {
			isNetConnectedListener.isConnected("yes");
		} else {
			isNetConnectedListener.isConnected("no");
		}
	}

	/**
	 * 用户是否登录
	 * 
	 * @param isUserLoginListener
	 */
	protected void isUserLogin(IsUserLoginListener isUserLoginListener) {
		String userid = PreferenceHelper.readString(this, "userinfo", "userid",
				"");
		isUserLoginListener.userLogin(userid);
	}

}
