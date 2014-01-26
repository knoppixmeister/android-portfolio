package com.example.portfolio;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.*;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends ActionBarActivity {
	protected boolean backPressed = false;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);

		setContentView(R.layout.main_2x);
		/*
		ActionBar actionBar = getSupportActionBar();

		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(false);

		Tab tab = actionBar.newTab()
		                   .setText("Portfolio")//R.string.artist
		                   .setTabListener(new TabListener<PortfolioListFragment>(this, "portfolio", PortfolioListFragment.class));
		actionBar.addTab(tab);

		tab = actionBar.newTab()
						.setText("Education")//R.string.album
						.setTabListener(new TabListener<EducationListFragment>(this, "education", EducationListFragment.class));
		actionBar.addTab(tab);

		tab = actionBar.newTab()
						.setText("Contacts")//R.string.album
						.setTabListener(new TabListener<ContactsFragment>(this, "education", ContactsFragment.class));
		actionBar.addTab(tab);
		*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("Refresh")
			.setIcon(R.drawable.ic_action_refresh);
			//.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		//menu.add("Settings");
		menu.add("Exit").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				System.exit(0);

				return false;
			}
		});

		return true;
	}

	public void onBackPressed() {
		if(!this.backPressed) {
			this.backPressed = true;

			Toast.makeText(getApplicationContext(), "To exit press back again!", Toast.LENGTH_SHORT).show();
		}
		else {
			super.onBackPressed();
		}
	}
}

class TabListener<T extends Fragment> implements ActionBar.TabListener {
	private Fragment mFragment;
	private final Activity mActivity;
	private final String mTag;
	private final Class<T> mClass;

	public TabListener(Activity activity, String tag, Class<T> clz) {
		mActivity = activity;
		mTag = tag;
		mClass = clz;
	}

    /* The following are each of the ActionBar.TabListener callbacks */
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // Check if the fragment is already initialized
    	if(mFragment == null) {
            // If not, instantiate and add it to the activity
            mFragment = Fragment.instantiate(mActivity, mClass.getName());
            ft.add(android.R.id.content, mFragment, mTag);
    	}
        else {
            // If it exists, simply attach it in order to show it
            ft.attach(mFragment);
        }
    }

    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        if (mFragment != null) {
            // Detach the fragment, because another one is being attached
            ft.detach(mFragment);
        }
    }

    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        // User selected the already selected tab. Usually do nothing.
    }
}
