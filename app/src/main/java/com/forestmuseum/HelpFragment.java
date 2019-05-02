package com.forestmuseum;

import android.app.Fragment;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class HelpFragment extends Fragment {
    MediaPlayer mediaPlayer;

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_help, null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


//        寻求帮助
        LinearLayout help = getActivity().findViewById(R.id.help_text);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DialogActivity.class));
            }
        });

//      展品破损
        ImageView exhi_break = getActivity().findViewById(R.id.exhi_break);
        exhi_break.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DialogActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("isExhiBreak", 1);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


//        监听紧急救助
        ImageView emer_help = getActivity().findViewById(R.id.emer_help);
        emer_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.alarm);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int k = 10;
                        while (k > 0) {
                            mediaPlayer.start();
                            try {
                                Thread.sleep(2000);
                                k--;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                }).start();
            }
        });

    }


}
