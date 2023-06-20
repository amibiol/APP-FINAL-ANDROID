package com.example.biblio_mb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class InfoActivity extends AppCompatActivity {

    private static final String VIDEO_SAMPLE = "video_app";
    private VideoView mVideoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        mVideoView = findViewById(R.id.videoView);

        MediaController mediaController = new MediaController(this);
        mVideoView.setMediaController(mediaController);
        mediaController.setAnchorView(mVideoView);
        mVideoView.setMediaController(mediaController);

        initializePlayer();



    }


    public void goToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToContacto(View view) {
        Intent intent = new Intent(this, ContactoActivity.class);
        startActivity(intent);
    }

    private Uri getMedia(String video_app) {
        return Uri.parse("android.resource://" + getPackageName() +
                "/raw/" + video_app);
    }

    private void initializePlayer() {
        Uri videoUri = getMedia(VIDEO_SAMPLE);
        mVideoView.setVideoURI(videoUri);
        mVideoView.start();


    }


}