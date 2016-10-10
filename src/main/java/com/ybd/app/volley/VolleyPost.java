package com.ybd.app.volley;

import java.util.Map;

import android.content.Context;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ybd.app.interf.GetDataSuccessListener;
import com.ybd.app.interf.SuccessListener;
import com.ybd.app.tools.ACache;

public abstract class VolleyPost extends BaseVolleyRequest {

	public Context context;
	public String url;
	public Map<String, String> map;

	public GetDataSuccessListener getDataSuccessListener;
	public SuccessListener successListener;

	ACache aCache;
	protected String pageIndex;

	public VolleyPost(final Context context, final String url,
			final Map<String, String> map) {
		this.context = context;
		this.url = url;
		this.map = map;

		pageIndex = getPageIndex();

		aCache = ACache.get(context);

		getJsonString(new StringRequest(Method.POST, url,
				new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						System.out.println("map.toString()----->>>>"
								+ map.toString());
						System.out.println("url----->>>>" + url);
						System.out.println("json----->>>>" + response);
						pullJson(response);
						aCache.put(url + (pageIndex == null ? "" : pageIndex),
								response);
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						pullJson(aCache.getAsString(url
								+ (pageIndex == null ? "" : pageIndex)));
					}
				}) {

			@Override
			protected Map<String, String> getParams() {
				return map;
			}
		});
	}

	public abstract void pullJson(String json);

	public abstract String getPageIndex();

	public void setOnGetDataSuccessListener(
			GetDataSuccessListener getDataSuccessListener) {
		this.getDataSuccessListener = getDataSuccessListener;
	}

	public void setOnSuccessListener(SuccessListener successListener) {
		this.successListener = successListener;
	}

}
