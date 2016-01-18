package com.jennifer.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jennifer.R;
import com.jennifer.controller.SecondActivity;
import com.jennifer.model.User;

import java.util.List;

/**
 * Created by echessa on 7/24/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<User> mItems;

    public RecyclerAdapter(List<User> items) {
        mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        User item = mItems.get(i);

        // Data Set
        viewHolder.mTextView.setText(item.getEmail());
        viewHolder.mDescView.setText(item.getDescription());


        viewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                context.startActivity(new Intent(context, SecondActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTextView;
        private final TextView mDescView;
        private final CardView cv;

        ViewHolder(View v) {
            super(v);
            cv = (CardView)itemView.findViewById(R.id.cv);
            mTextView = (TextView)v.findViewById(R.id.email_item);
            mDescView = (TextView)v.findViewById(R.id.description_item);
        }
    }

}
