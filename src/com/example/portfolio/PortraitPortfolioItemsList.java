package com.example.portfolio;

import android.os.*;
import android.support.v7.app.*;
import android.util.Log;
import android.view.MenuItem;
import android.widget.GridView;

public class PortraitPortfolioItemsList extends ActionBarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.portrait_portfolio_items_list);

		ActionBar actionBar = getSupportActionBar();
		actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle("Android app. My Portfolio.");

		GridView gv = (GridView)findViewById(R.id.gridview2);
		gv.setAdapter(null);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem) {
		Log.e("LALA", menuItem.getItemId() == android.R.id.home ? "YYYY" : "NBNNNNN");

		if(menuItem.getItemId() == android.R.id.home) {
			super.onBackPressed();
		}

		return true;
		//super.onOptionsItemSelected(item);
	}

	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.portrait_portfolio_items_list, menu);
		return true;
	}
	*/
}
