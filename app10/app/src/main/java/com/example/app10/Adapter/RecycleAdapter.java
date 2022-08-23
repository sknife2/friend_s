package com.example.app10.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app10.R;
import com.example.app10.ViewHolder.Dynamic.RecycleViewHolder;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleViewHolder> {
    private final Context context;

    public RecycleAdapter(Context applicationContext) {
        this.context = applicationContext;
    }

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecycleViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder recycleViewHolder, int position) {
        recycleViewHolder.getUsername();
        recycleViewHolder.getRelease_time();
        recycleViewHolder.getHead_icon().setImageResource(R.drawable.head_icon);
        recycleViewHolder.getMore_icon().setImageResource(R.drawable.more9);
        recycleViewHolder.getDynamic_text();
        recycleViewHolder.getLike_icon().setImageResource(R.drawable.like9);
        recycleViewHolder.getComment_icon().setImageResource(R.drawable.comment9);
        recycleViewHolder.getComment_icon().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        recycleViewHolder.getTransmit_icon().setImageResource(R.drawable.transmit9);
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
