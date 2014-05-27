package org.tmp.shopclient.ui.views;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.tmp.shopclient.R;

public class LoginActivity extends RoboActivity implements OnClickListener{
	
	@InjectView(R.id.et_account) EditText account ;
	@InjectView(R.id.et_password) EditText password ;
	@InjectView(R.id.cb_rememberPwd) CheckBox rememberPwd ;
	@InjectView(R.id.cb_autoLogin) CheckBox autoLogin ;
	@InjectView(R.id.btn_login) Button login ;
    @InjectView(R.id.btn_forgetPwd)
    TextView forgetPwd ;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity_layout);
		login.setOnClickListener(this);
        this.forgetPwd.setOnClickListener(this);
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
            Intent intent = new Intent(LoginActivity.this,ShopMainActivity.class);
            startActivity(intent);
			break;
            case R.id.btn_forgetPwd:
                Intent forgetPwdintent = new Intent(LoginActivity.this,FindPwdActivity1.class);
                startActivity(forgetPwdintent);
                break;
		default:
			break;
		}
	}

}
