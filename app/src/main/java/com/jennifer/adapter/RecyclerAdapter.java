package com.jennifer.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
        viewHolder.logImage.setImageResource(item.getImagen());

        viewHolder.doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                context.startActivity(new Intent(context, SecondActivity.class));
            }
        });

        viewHolder.cancelBtn.setOnClickListener(new View.OnClickListener() {
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

        private final ImageView logImage;
        private final ImageView doneBtn;
        private final ImageView cancelBtn;

        ViewHolder(View v) {
            super(v);
            logImage = (ImageView)v.findViewById(R.id.log_image);
            doneBtn = (ImageView)v.findViewById(R.id.done);
            cancelBtn = (ImageView)v.findViewById(R.id.cancel);
        }
    }

}
