package org.tmp.shopclient.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Map;


public class OrderAdapter extends BaseAdapter{

    private class ViewHolder{
        TextView address ;
        TextView price ;
        TextView phone;
        TextView date ;
        TextView time ;
        Button btnFinish ;
    }
    private ArrayList<Map<String,Object>> mList ;
    private int mResource ;
    private LayoutInflater inflater;
    private Context context ;
    private String[] keys;
    private int[] viewId ;
    private ViewHolder holder ;

    public OrderAdapter(Context c,ArrayList<Map<String,Object>> list,int resource,String[] from ,int[] to){
        mList = list ;
        mResource = resource ;
        context = c ;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        keys = new String[from.length];
        viewId = new int[to.length];
        System.arraycopy(from,0,keys,0,from.length);
        System.arraycopy(to,0,viewId,0,to.length);
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view != null){
            holder = (ViewHolder) view.getTag();
        }else {
            view = inflater.inflate(mResource,null);
            holder = new ViewHolder();
            holder.address = (TextView) view.findViewById(viewId[0]);
            holder.price = (TextView) view.findViewById(viewId[1]);
            holder.phone = (TextView) view.findViewById(viewId[2]);
            holder.date = (TextView) view.findViewById(viewId[3]);
            holder.time = (TextView) view.findViewById(viewId[4]);
            holder.btnFinish = (Button) view.findViewById(viewId[5]);
            view.setTag(holder);
        }
        Map<String,Object> itemInfo = mList.get(position);
        if (itemInfo != null){
            String addr  = (String) itemInfo.get(keys[0]);
            String price  = (String) itemInfo.get(keys[1]);
            String phone  = (String) itemInfo.get(keys[2]);
            String date  = (String) itemInfo.get(keys[3]);
            String time  = (String) itemInfo.get(keys[4]);

            holder.address.setText(addr);
            holder.price.setText(price);
            holder.phone.setText(phone);
            holder.date.setText(date);
            holder.time.setText(time);
            holder.btnFinish.setOnClickListener(new LvBtnListener(position));
        }
        return view;
    }
    class LvBtnListener implements View.OnClickListener{

        private int position ;
        LvBtnListener(int i){
            position = i ;
        }
        @Override
        public void onClick(View view) {
            Toast.makeText(context,""+position,Toast.LENGTH_LONG).show();
        }
    }
}
