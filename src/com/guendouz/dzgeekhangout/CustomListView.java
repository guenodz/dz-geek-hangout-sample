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

import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * 
 * @author Mohamed Guendouz
 * 
 *         demonstration de l'utilisation des ListView avec un Adapter modifié
 * 
 */
public class CustomListView extends Activity {

	private ListView customListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_lis);

		customListView = (ListView) findViewById(R.id.customListView);

		MemberAdapter adapter = new MemberAdapter(this,
				Arrays.asList(getResources().getStringArray(R.array.personnes)));
		customListView.setAdapter(adapter);
	}

}
