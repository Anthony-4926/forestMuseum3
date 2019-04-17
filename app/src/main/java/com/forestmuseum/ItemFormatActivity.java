package com.forestmuseum;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemFormatActivity extends Activity {

    private boolean isPlaying=false ;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_format);

//        标题
        TextView titleTextView = findViewById(R.id.content_title);
        titleTextView.setText(getIntent().getStringExtra("title"));
//                图片
        ImageView imageView = findViewById(R.id.content_img);
        imageView.setImageResource(getIntent().getIntExtra("id", 0));
//        文字
        TextView contentTextView = findViewById(R.id.content_text);
        contentTextView.setText("     "+getIntent().getStringExtra("content"));
//        音频
        mediaPlayer = MediaPlayer.create(this, getIntent().getIntExtra("sound", 0));
        ImageView sound = findViewById(R.id.content_sound);
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPlaying = !isPlaying;
                if(isPlaying){
                    mediaPlayer.start();
                }else{
                    mediaPlayer.pause();
                }
            }
        });
    }
}
