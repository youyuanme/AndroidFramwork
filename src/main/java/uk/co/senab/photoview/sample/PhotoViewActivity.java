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

import uk.co.senab.photoview.PhotoViewAttacher;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class PhotoViewActivity extends Activity {

	private ImageView mImageView;

	private PhotoViewAttacher mAttacher;

	String picurl;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.photo);
//		picurl = getIntent().getStringExtra("picurl");
//
//		mImageView = (ImageView) findViewById(R.id.iv_photo);
//
//		Bitmap bitmap = ImageLoader.getInstance().loadImageSync(picurl);
//		mImageView.setImageBitmap(bitmap);
//
//		// The MAGIC happens here!
//		mAttacher = new PhotoViewAttacher(mImageView);

	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// Need to call clean-up
		mAttacher.cleanup();
	}

}
