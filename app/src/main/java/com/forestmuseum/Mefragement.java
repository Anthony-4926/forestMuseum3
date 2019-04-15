package com.forestmuseum;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Mefragement extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, null);
        return view;
    }

    /**
     * 在回调时为fragment中的内容添加监听
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RelativeLayout anwserQuestion = getActivity().findViewById(R.id.anwser_question);
        RelativeLayout save = getActivity().findViewById(R.id.save);
        RelativeLayout set = getActivity().findViewById(R.id.set);
        anwserQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),QuestionActivity.class));
            }
        });
        save.setOnClickListener(l);
        set.setOnClickListener(l);
    }

    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            System.out.println("点我干啥");
        }
    };
}
