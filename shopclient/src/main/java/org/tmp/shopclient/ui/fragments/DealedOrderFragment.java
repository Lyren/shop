package org.tmp.shopclient.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.tmp.shopclient.R;

public class DealedOrderFragment extends Fragment {

    private static final String ARG_PARAM = "DealedOrderFragment";


    private String param;

    public static DealedOrderFragment newInstance(String param) {
        DealedOrderFragment fragment = new DealedOrderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);

        return fragment;
    }
    public DealedOrderFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            param = getArguments().getString(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dealed_order, container, false);
    }




}
