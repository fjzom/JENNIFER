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
import com.jennifer.model.User;

import java.util.ArrayList;

/**
 * Created by Alex on 15/01/2016.
 */
public class Fragment extends android.support.v4.app.Fragment {
    private static final String TAB_POSITION = "tab_position";

    public Fragment() {

    }

    public static Fragment newInstance(int tabPosition) {
        Fragment fragment = new Fragment();
        Bundle args = new Bundle();
        args.putInt(TAB_POSITION, tabPosition);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        int tabPosition = args.getInt(TAB_POSITION) + 1;

        ArrayList<User> items = new ArrayList<User>();
        for (int i = 0; i < 50; i++) {
            items.add(new User("User " + (i + 1) + " - Tab " + tabPosition,
                    getString(R.string.second_activity_text)));
        }

        View v =  inflater.inflate(R.layout.fragment_list_view, container, false);
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerAdapter(items));

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
//        recyclerView.setHasFixedSize(true);

        return v;
    }
}