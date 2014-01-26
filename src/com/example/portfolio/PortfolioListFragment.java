package com.example.portfolio;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class PortfolioListFragment extends Fragment {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.portfolio_list, container, false);

		GridView gv = (GridView)view.findViewById(R.id.gridview);

		gv.setAdapter(new MyGridAdapter(getActivity()));
		gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Log.e(getActivity().getPackageName(), "POS: "+position);

				
			}
		});

		return view;
	}
}

class MyGridAdapter extends BaseAdapter {
	private LayoutInflater li;
	private Context context;

	public MyGridAdapter(Context context) {
		this.context = context;

		this.li = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);		
	}

	public int getCount() {
		return 50;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int id) {
		return id;
	}

	public View getView(int arg0, View view, ViewGroup viewGroup) {
		View v;

		if(view == null) {
			v = this.li.inflate(R.layout.portfolio_item, viewGroup, false);

			ImageView im = (ImageView)v.findViewById(R.id.imageView1);
			im.setImageResource(R.drawable.rihanna);

			return v;
		}
		else return view;
	}
}
