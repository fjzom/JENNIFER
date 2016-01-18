package com.jennifer.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jennifer.R;
import com.jennifer.controller.SecondActivity;
import com.jennifer.model.Ranking;
import com.jennifer.model.User;

import java.util.List;

/**
 * Created by echessa on 7/24/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Ranking> mItems;

    public RecyclerAdapter(List<Ranking> items) {
        mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Ranking item = mItems.get(i);

        // Data Set
        viewHolder.mImage.setImageResource(item.getImagen());
        viewHolder.mTitle.setText(item.getTitulo());



        viewHolder.mImage.setOnClickListener(new View.OnClickListener() {
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

        private final ImageView mImage;
        private final TextView mTitle;

        ViewHolder(View v) {
            super(v);
            mImage = (ImageView)v.findViewById(R.id.list_row_image);
            mTitle = (TextView)v.findViewById(R.id.list_row_title);
        }
    }

}
