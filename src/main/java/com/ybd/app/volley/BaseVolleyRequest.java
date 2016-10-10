package com.ybd.app.volley;

import com.android.volley.toolbox.StringRequest;
import com.ybd.app.MyBaseApplication;

public class BaseVolleyRequest {

	

	public void getJsonString(StringRequest request) {
		MyBaseApplication.queue.add(request);
	}

}
