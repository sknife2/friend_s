package com.example.app10.ViewHolder.Dynamic;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app10.R;
public class RecycleViewHolder extends RecyclerView.ViewHolder {
    TextView username;
    TextView release_time;
    ImageButton head_icon;
    ImageButton more_icon;
    TextView dynamic_text;
    ImageButton like_icon, comment_icon, transmit_icon;

    public RecycleViewHolder(@NonNull View itemView) {
        super(itemView);
        username = itemView.findViewById(R.id.username);
        release_time = itemView.findViewById(R.id.release_time);
        username = itemView.findViewById(R.id.username);
        head_icon = itemView.findViewById(R.id.head_icon);
        more_icon = itemView.findViewById(R.id.more_icon);
        dynamic_text = itemView.findViewById(R.id.dynamic_text);
        like_icon = itemView.findViewById(R.id.like_icon);
        comment_icon = itemView.findViewById(R.id.comment_icon);
        transmit_icon = itemView.findViewById(R.id.transmit_icon);
    }

    public TextView getUsername() {
        return username;
    }

    public void setUsername(TextView username) {
        this.username = username;
    }

    public TextView getRelease_time() {
        return release_time;
    }

    public void setRelease_time(TextView release_time) {
        this.release_time = release_time;
    }

    public ImageButton getHead_icon() {
        return head_icon;
    }

    public void setHead_icon(ImageButton head_icon) {
        this.head_icon = head_icon;
    }

    public ImageButton getMore_icon() {
        return more_icon;
    }

    public void setMore_icon(ImageButton more_icon) {
        this.more_icon = more_icon;
    }

    public TextView getDynamic_text() {
        return dynamic_text;
    }

    public void setDynamic_text(TextView dynamic_text) {
        this.dynamic_text = dynamic_text;
    }

    public ImageButton getLike_icon() {
        return like_icon;
    }

    public void setLike_icon(ImageButton like_icon) {
        this.like_icon = like_icon;
    }

    public ImageButton getComment_icon() {
        return comment_icon;
    }

    public void setComment_icon(ImageButton comment_icon) {
        this.comment_icon = comment_icon;
    }

    public ImageButton getTransmit_icon() {
        return transmit_icon;
    }

    public void setTransmit_icon(ImageButton transmit_icon) {
        this.transmit_icon = transmit_icon;
    }
}
