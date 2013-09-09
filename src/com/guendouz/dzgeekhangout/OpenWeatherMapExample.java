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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * 
 * @author Mohamed Guendouz
 * 
 */
public class OpenWeatherMapExample extends Activity implements OnClickListener {

	private static final String WEATHER_DATA_URL = "http://api.openweathermap.org/data/2.5/weather?q=Saida,dz";

	private Button btnGetWeatherInfo;
	private EditText weatherinfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_open_weather_map);

		btnGetWeatherInfo = (Button) findViewById(R.id.btnGetWeatherInfo);
		weatherinfo = (EditText) findViewById(R.id.weatherInfo);
		btnGetWeatherInfo.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btnGetWeatherInfo) {
			new OpenWeatherMapRequest().execute();

		}

	}

	class OpenWeatherMapRequest extends AsyncTask<Void, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(Void... params) {

			InputStream inputStream;
			BufferedReader reader;
			String jsonData = null;

			HttpClient client = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(WEATHER_DATA_URL);

			try {
				HttpResponse httpResponse = client.execute(httpGet);
				if (httpResponse.getStatusLine().getStatusCode() == 200) {
					inputStream = httpResponse.getEntity().getContent();
					reader = new BufferedReader(new InputStreamReader(
							inputStream));
					String line = "";
					StringBuilder builder = new StringBuilder();
					while ((line = reader.readLine()) != null)
						builder.append(line);

					jsonData = builder.toString();

				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return jsonData;
		}

		@Override
		protected void onPostExecute(String result) {
			if (result != null && !result.trim().equals("")) {
				try {
					JSONObject weatherData = new JSONObject(result);
					Iterator<String> keysIterator = weatherData.keys();
					StringBuilder builder = new StringBuilder();
					while (keysIterator.hasNext()) {
						String key = keysIterator.next();
						builder.append(key.toUpperCase()).append(" = ")
								.append(weatherData.get(key)).append("\n");
					}

					weatherinfo.setText(builder.toString());

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

}
