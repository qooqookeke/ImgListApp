package com.qooke.imglist.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.qooke.imglist.R;
import com.qooke.imglist.model.Post;
import com.qooke.imglist.photoActivity;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{
    Context context;
    ArrayList<Post> postArrayList;

    public PostAdapter(Context context, ArrayList<Post> postArrayList) {
        this.context = context;
        this.postArrayList = postArrayList;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_row, parent,false);
        return new PostAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = postArrayList.get(position);
        holder.txtTitle.setText(post.title);
        holder.txtId.setText(post.id+"");
        holder.txtAlbumid.setText(post.albumId+"");
        // 네트워크 이미지 불러오기
        Glide.with(context).load(post.thumbnailUrl).into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        ImageView imgPhoto;
        TextView txtId;
        TextView txtAlbumid;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            imgPhoto = itemView.findViewById(R.id.imgPhoto);
            txtId = itemView.findViewById(R.id.txtId);
            txtAlbumid = itemView.findViewById(R.id.txtAlbumid);

            imgPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = getAdapterPosition();

                    Post post = postArrayList.get(index);
                    Intent intent = new Intent(context, photoActivity.class);
                    intent.putExtra("post", post);
                    context.startActivity(intent);

                }
            });
        }
    }
}
