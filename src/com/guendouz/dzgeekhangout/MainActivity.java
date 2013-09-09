/*
 * Copyright 2013 Mohamed Guendouz.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.guendouz.dzgeekhangout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 
 * @author Mohamed Guendouz
 * 
 *         Activity principale
 * 
 */
public class MainActivity extends Activity implements OnItemClickListener {

	
	private ListView sampleListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		sampleListView = (ListView) findViewById(R.id.sampleListView);

		sampleListView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, getResources()
						.getStringArray(R.array.samples)));
		sampleListView.setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position,
			long id) {
		Intent intent = null;
		switch (position) {
		case 0:
			intent = new Intent(this, SimpleListView.class);
			break;
		case 1:
			intent = new Intent(this, CustomListView.class);
			break;
		case 2:
			intent = new Intent(this, SimpleSetting.class);
			break;
		case 3:
			intent = new Intent(this, SimpleHttpRequest.class);
			break;
		case 4:
			intent = new Intent(this, OpenWeatherMapExample.class);
			break;

		default:
			break;
		}

		startActivity(intent);

	}

}
