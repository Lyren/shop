package org.tmp.shopclient.ui.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.tmp.shopclient.R;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class FindPwdActivity1 extends RoboActivity implements View.OnClickListener{

    @InjectView(R.id.et_find_phone_num) private EditText phoneNum ;
    @InjectView(R.id.et_find_check_num) private EditText checkNum ;
    @InjectView(R.id.btn_find_get_code) private Button btnGetCode ;
    @InjectView(R.id.btn_ensure) private Button btnEnsure ;
    @InjectView(R.id.btn_cancel) private Button btnCancel ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pwd_activity1);
        this.btnCancel.setOnClickListener(this);
        this.btnEnsure.setOnClickListener(this);
        this.btnGetCode.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_find_get_code:
                break;
            case R.id.btn_ensure:
                Intent intent = new Intent(FindPwdActivity1.this,FindPwdActivity2.class);
                startActivity(intent);
                break;
            case R.id.btn_cancel:
                finish();
                break;
        }
        Toast.makeText(FindPwdActivity1.this,((Button)view).getText().toString(),Toast.LENGTH_LONG).show();
    }
}
