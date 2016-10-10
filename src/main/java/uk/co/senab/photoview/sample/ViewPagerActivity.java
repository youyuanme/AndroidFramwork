/*******************************************************************************
 * Copyright 2011, 2012 Chris Banes.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package uk.co.senab.photoview.sample;

import uk.co.senab.photoview.PhotoView;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

import com.nostra13.universalimageloader.core.ImageLoader;

public class ViewPagerActivity extends Activity {

	private ViewPager mViewPager;

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
//		Intent in = getIntent();
//		list = (List<ProductPic>) in.getExtras().get("list");
//		int position = in.getIntExtra("position", 0);

		mViewPager = new HackyViewPager(this);
		setContentView(mViewPager);

//		mViewPager.setAdapter(new SamplePagerAdapter());
//		mViewPager.setCurrentItem(position);
	}

//	class SamplePagerAdapter extends PagerAdapter {
//
//		@Override
//		public int getCount() {
//			return list.size();
//		}
//
//		@Override
//		public View instantiateItem(ViewGroup container, int position) {
//			PhotoView photoView = new PhotoView(container.getContext());
//			Bitmap bitmap = ImageLoader.getInstance().loadImageSync(
//					Constants.IP_PIC+list.get(position).getPicUrl());
//			photoView.setImageBitmap(bitmap);
//
//			// Now just add PhotoView to ViewPager and return it
//			container.addView(photoView, LayoutParams.MATCH_PARENT,
//					LayoutParams.MATCH_PARENT);
//
//			return photoView;
//		}
//
//		@Override
//		public void destroyItem(ViewGroup container, int position, Object object) {
//			container.removeView((View) object);
//		}
//
//		@Override
//		public boolean isViewFromObject(View view, Object object) {
//			return view == object;
//		}
//
//	}

}
