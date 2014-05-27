package org.tmp.shopclient.ui.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.tmp.shopclient.R;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class FindPwdActivity2 extends RoboActivity implements View.OnClickListener {

    @InjectView(R.id.btn_change_cancel) private Button btnCancel;
    @InjectView(R.id.btn_change_ensure) private Button btnEnsure ;
    @InjectView(R.id.et_find_new_pwd) private EditText newPwd;
    @InjectView(R.id.et_find_re_new_pwd) private EditText reNewPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pwd_activity2);
        this.btnCancel.setOnClickListener(this);
        this.btnEnsure.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_change_cancel:
                finish();
                break;
            case R.id.btn_change_ensure:
                Intent intent = new Intent(FindPwdActivity2.this,LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
