package com.qooke.imglist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.qooke.imglist.model.Post;

public class photoActivity extends AppCompatActivity {

    ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        imgPhoto = findViewById(R.id.imgPhoto);

        Post post = (Post) getIntent().getSerializableExtra("post");

        Glide.with(photoActivity.this).load(post.url).into(imgPhoto);


    }
}