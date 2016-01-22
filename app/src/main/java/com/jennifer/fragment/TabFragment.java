package com.jennifer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jennifer.R;
import com.jennifer.adapter.RecyclerAdapter;
import com.jennifer.model.Ranking;

import java.util.ArrayList;

/**
 * Created by Alex on 15/01/2016.
 */
public class TabFragment extends android.support.v4.app.Fragment {
    private static final String TAB_POSITION = "tab_position";

    public TabFragment() {

    }

    public static TabFragment newInstance(int tabPosition) {
        TabFragment tabFragment = new TabFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_POSITION, tabPosition);
        tabFragment.setArguments(args);
        return tabFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        int tabPosition = args.getInt(TAB_POSITION) + 1;

        ArrayList<Ranking> items = new ArrayList<Ranking>();
        for (int i = 0; i < 50; i++) {
            items.add(new Ranking("titulo " + (i + 1), R.mipmap.ic_launcher));
        }

        View v =  inflater.inflate(R.layout.fragment_list_view, container, false);
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerAdapter(items));

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        return v;
    }
}