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
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * 
 * @author Mohamed Guendouz
 * 
 */
public class SimpleSetting extends Activity implements OnClickListener {

	private static final String NAME_PREF = "name";

	private EditText nameEdit;
	private Button btnChangeName;
	private SharedPreferences preferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_setting);

		preferences = PreferenceManager
				.getDefaultSharedPreferences(getApplicationContext());

		nameEdit = (EditText) findViewById(R.id.nameEdit);
		btnChangeName = (Button) findViewById(R.id.btnChangeName);
		btnChangeName.setOnClickListener(this);

		String oldName = preferences.getString(NAME_PREF, "");
		nameEdit.setText(oldName);

	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btnChangeName) {
			String newName = nameEdit.getText().toString();
			SharedPreferences.Editor editor = preferences.edit();
			editor.putString(NAME_PREF, newName);
			editor.commit();

		}

	}
}
