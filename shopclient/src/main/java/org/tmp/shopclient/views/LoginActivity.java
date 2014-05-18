package org.tmp.shopclient.views;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import org.tmp.shopclient.R;

public class LoginActivity extends RoboActivity implements OnClickListener{
	
	@InjectView(R.id.et_account) EditText account ;
	@InjectView(R.id.et_password) EditText password ;
	@InjectView(R.id.cb_rememberPwd) CheckBox rememberPwd ;
	@InjectView(R.id.cb_autoLogin) CheckBox autoLogin ;
	@InjectView(R.id.btn_login) Button login ;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity_layout);
		ActionBar actionBar = this.getActionBar() ;
		actionBar.setTitle(getResources().getString(R.string.shopLogin));
		login.setOnClickListener(this);
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_login:
			Toast.makeText(LoginActivity.this, "login", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
	}

}
