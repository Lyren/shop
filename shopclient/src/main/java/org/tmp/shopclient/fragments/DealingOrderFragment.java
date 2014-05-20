package org.tmp.shopclient.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.tmp.shopclient.R;
import org.tmp.shopclient.adapter.OrderAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import roboguice.inject.InjectView;


public class DealingOrderFragment extends Fragment {

    private ListView lvDealingOrder;

    private ArrayList<Map<String, Object>> infoList;
    private OrderAdapter adapter;

    public DealingOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dealing_order, container, false);
        this.lvDealingOrder = (ListView) view.findViewById(R.id.lv_dealing_order);
        initListview();
        return view;
    }

    private void initListview() {
        infoList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("address", "address" + i);
            map.put("price", "price" + i);
            map.put("phone", "phone" + i);
            map.put("date", "date" + i);
            map.put("time", "time" + i);
            infoList.add(map);
        }
        adapter = new OrderAdapter(getActivity(), infoList, R.layout.item_dealed_order, new String[]{"address", "price", "phone", "date", "time"}, new int[]{R.id.tv_order_address, R.id.tv_order_price, R.id.tv_order_phone, R.id.tv_order_date, R.id.tv_order_time,R.id.btn_order_finish});
        lvDealingOrder.setAdapter(adapter);
        //设置焦点响应问题    同时要将 item 中的焦点 focusable 设置为 false
        lvDealingOrder.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        lvDealingOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), infoList.get(i).get("address").toString(), Toast.LENGTH_LONG).show();
            }
        });

    }


}
