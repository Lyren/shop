package org.tmp.shopclient.views;

import org.tmp.shopclient.R;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import roboguice.activity.RoboActivity;

public class OrderManagementActivity extends RoboActivity {

	private FragmentManager fragmentManager ;
	
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order_management_main_layout);
		ActionBar actionBar = this.getActionBar() ;
		actionBar.setTitle(getResources().getString(R.string.orderManagement));
		
	}
	

	
}
