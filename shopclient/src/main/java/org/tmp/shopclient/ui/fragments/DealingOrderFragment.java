package org.tmp.shopclient.ui.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.ResponseHandlerInterface;

import org.tmp.shopclient.R;
import org.tmp.shopclient.http.HttpConnection;
import org.tmp.shopclient.ui.adapter.OrderAdapter;
import org.tmp.shopclient.pulltorefresh.extras.SoundPullEventListener;
import org.tmp.shopclient.pulltorefresh.library.PullToRefreshBase;
import org.tmp.shopclient.pulltorefresh.library.PullToRefreshListView;
import org.tmp.shopclient.ui.views.OrderDetailActivity;
import org.tmp.shopclient.utils.Constant;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DealingOrderFragment extends Fragment {

    private PullToRefreshListView mPullRefreshListView;
    private OrderAdapter adapter;
    private ArrayList<Map<String, Object>> infoList;

    private HttpConnection httpConnection = HttpConnection.getInstance();
    private static MainHandler handler ;
    public DealingOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dealing_order, container, false);
        handler = new MainHandler(this);

        mPullRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_list);

        mPullRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        // Set a listener to be invoked when the list should be refreshed.
        mPullRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                String label = DateUtils.formatDateTime(getActivity().getApplicationContext(), System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

                // Update the LastUpdatedLabel
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);

                // Do work to refresh the list here.
                //new GetDataTask().execute();
                ResponseHandlerInterface response = httpConnection.getResponseHandler();
                httpConnection.executeSample(getActivity(),handler,"http://www.baidu.com",null,response);
            }
        });
        // Add an end-of-list listener
        mPullRefreshListView.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {

            @Override
            public void onLastItemVisible() {

                //new GetDataTask().execute();
            }
        });
        ListView actualListView = mPullRefreshListView.getRefreshableView();
        //set setOnItemClickListener
        mPullRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Map<String,Object> selectedItem = infoList.get(position);
                Intent intent = new Intent(getActivity(), OrderDetailActivity.class);
                intent.putExtra("data",(String)selectedItem.get("time"));
                startActivity(intent);
            }
        });
        // Need to use the Actual ListView when registering for Context Menu
        registerForContextMenu(actualListView);

        initData();
        adapter = new OrderAdapter(getActivity(), infoList, R.layout.item_dealed_order, new String[]{"address", "price", "phone", "date", "time"}, new int[]{R.id.tv_order_address, R.id.tv_order_price, R.id.tv_order_phone, R.id.tv_order_date, R.id.tv_order_time,R.id.btn_order_finish});

        /**
         * Add Sound Event Listener
         */
        SoundPullEventListener<ListView> soundListener = new SoundPullEventListener<ListView>(getActivity());
        soundListener.addSoundEvent(PullToRefreshBase.State.PULL_TO_REFRESH, R.raw.pull_event);
        soundListener.addSoundEvent(PullToRefreshBase.State.RESET, R.raw.reset_sound);
        soundListener.addSoundEvent(PullToRefreshBase.State.REFRESHING, R.raw.refreshing_sound);
        mPullRefreshListView.setOnPullEventListener(soundListener);

        // You can also just use setListAdapter(mAdapter) or
        // mPullRefreshListView.setAdapter(mAdapter)
        actualListView.setAdapter(adapter);
        return view;
    }

    private void initData() {
        infoList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("address", "大连理工大学软件学院  小三炮"+i );
            map.put("price", "￥20" +i);
            map.put("phone", "18888888888" +i);
            map.put("date", "2014/5/5" +i);
            map.put("time", "17:00 下单" +i);
            infoList.add(map);
        }
    }
    private static  class MainHandler extends Handler {
        private WeakReference<DealingOrderFragment> mOut ;
        public MainHandler(DealingOrderFragment f){
            mOut = new WeakReference<DealingOrderFragment>(f);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == Constant.SUCCESS){
                String result = (String) msg.obj;
                System.out.println(result);
                Toast.makeText(mOut.get().getActivity(), result, Toast.LENGTH_LONG).show();
            }else if (msg.what == Constant.FAILED){
                Toast.makeText(mOut.get().getActivity(), "get data failed", Toast.LENGTH_LONG).show();
            }else {

            }
            // Call onRefreshComplete when the list has been refreshed.
            mOut.get().mPullRefreshListView.onRefreshComplete();
        }
    }

}
