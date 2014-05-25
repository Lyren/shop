package org.tmp.shopclient.ui.views;

import android.app.Activity;
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
    @InjectView(R.id.btn_find_get_code) private EditText btnGetCode ;
    @InjectView(R.id.btn_ensure) private EditText btnEnsure ;
    @InjectView(R.id.btn_cancel) private EditText btnCancel ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pwd_activity1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.find_pwd_activity1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_find_get_code:
                break;
            case R.id.btn_ensure:
                break;
            case R.id.btn_cancel:
                break;
        }
        Toast.makeText(FindPwdActivity1.this,((Button)view).getText().toString(),Toast.LENGTH_LONG).show();
    }
}
