package org.tmp.shopclient.ui.views;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.tmp.shopclient.R;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class ShopMainActivity extends RoboActivity implements OnClickListener {

	@InjectView(R.id.btn_order_managemnet)
	private Button orderManagement;
	@InjectView(R.id.btn_dish_management)
	private Button dishManagement;
	@InjectView(R.id.btn_shop_info)
	private Button shopInfo;
	@InjectView(R.id.btn_sales_acount)
	private Button salesAcount;
	@InjectView(R.id.s_state)
	private Spinner shopState;

	private ArrayAdapter<CharSequence> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shop_main_activity_layout);
		ActionBar actionBar = this.getActionBar() ;
		actionBar.setTitle(getResources().getString(R.string.mainPage));
		this.orderManagement.setOnClickListener(this);
		this.dishManagement.setOnClickListener(this);
		this.shopInfo.setOnClickListener(this);
		this.salesAcount.setOnClickListener(this);
		initSpinner();
		
	}

	/**
	 * 初始化Spinner控件
	 */
	private void initSpinner(){
		adapter = ArrayAdapter.createFromResource(this, R.array.shopState,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		shopState.setAdapter(adapter);
		shopState
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int position, long arg3) {
						// TODO Auto-generated method stub
						Toast.makeText(ShopMainActivity.this,
								adapter.getItem(position).toString(),
								Toast.LENGTH_LONG).show();

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_order_managemnet:
            Intent intent = new Intent(ShopMainActivity.this,OrderManagementActivity.class);
            startActivity(intent);
			break;
		case R.id.btn_dish_management:

			break;
		case R.id.btn_shop_info:

			break;
		case R.id.btn_sales_acount:

			break;

		default:
			break;
		}
		Toast.makeText(this, ((Button)v).getText(),Toast.LENGTH_LONG ).show();
	}

}
