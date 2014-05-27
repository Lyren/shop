package org.tmp.shopclient.ui.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.tmp.shopclient.R;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class OrderDetailActivity extends RoboActivity implements View.OnClickListener{

    @InjectView(R.id.lv_orders) private ListView lvOrder ;
    @InjectView(R.id.btn_o_d_finish) private Button btnFinish ;
    @InjectView(R.id.btn_o_d_cancel) private Button btnCancel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        this.btnCancel.setOnClickListener(this);
        this.btnFinish.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_o_d_finish:
                finish();
                break;
            case R.id.btn_o_d_cancel:
                finish();
                break;
            default:
                break;
        }
    }
}
