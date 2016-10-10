package com.ybd.app.volley;

import android.content.Context;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ybd.app.interf.GetDataSuccessListener;
import com.ybd.app.interf.SuccessListener;
import com.ybd.app.tools.ACache;

public abstract class VolleyGet extends BaseVolleyRequest {

	public Context context;
	public String url;

	public GetDataSuccessListener getDataSuccessListener;
	public SuccessListener successListener;

	ACache aCache;

	public VolleyGet(Context context, final String url) {
		this.context = context;
		this.url = url;

		aCache = ACache.get(context);

		
		getJsonString(new StringRequest(Method.GET, url,
				new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						System.out.println("url----->>>>" + url);
						System.out.println("json----->>>>" + response);
						pullJson(response);
						aCache.put(url, response);
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						pullJson(aCache.getAsString(url));
					}
				}));

	}

	public abstract void pullJson(String json);

	public void setOnGetDataSuccessListener(
			GetDataSuccessListener getDataSuccessListener) {
		this.getDataSuccessListener = getDataSuccessListener;
	}

	public void setOnSuccessListener(SuccessListener successListener) {
		this.successListener = successListener;
	}

}
