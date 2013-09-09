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

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 
 * @author Mohamed Guendouz
 * 
 * 
 */
public class MemberAdapter extends BaseAdapter {

	private LayoutInflater inflater;
	private List<String> data;

	public MemberAdapter(Context context, List<String> data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int index) {
		// TODO Auto-generated method stub
		return data.get(index);
	}

	@Override
	public long getItemId(int id) {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public View getView(int position, View currentView, ViewGroup parent) {
		// TODO Auto-generated method stub

		View view;
		view = currentView;
		if (view == null)
			view = inflater.inflate(R.layout.row_item, parent, false);

		TextView nameView = (TextView) view.findViewById(R.id.mbName);
		ImageView mbImage = (ImageView) view.findViewById(R.id.mbPhoto);

		String name = data.get(position);
		nameView.setText(name);
		if (name.equals("Mohamed Guendouz"))
			mbImage.setImageResource(R.drawable.clumsy_smurf_icon);
		else if (name.equals("Kouceyla Hadji"))
			mbImage.setImageResource(R.drawable.brainy_smurf_icon);
		else if (name.equals("Hacen Dada"))
			mbImage.setImageResource(R.drawable.papa_smurf_icon);
		else if (name.equals("Yazid Cherifi"))
			mbImage.setImageResource(R.drawable.brainy_smurf_icon);
		else if (name.equals("Ilyes Kechidi"))
			mbImage.setImageResource(R.drawable.papa_smurf_icon);

		return view;
	}

}
