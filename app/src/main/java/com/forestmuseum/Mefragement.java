package com.forestmuseum;

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
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RelativeLayout anwserQuestion = getActivity().findViewById(R.id.anwser_question);
        RelativeLayout save = getActivity().findViewById(R.id.save);
        RelativeLayout set = getActivity().findViewById(R.id.set);
        anwserQuestion.setOnClickListener(l2);
        save.setOnClickListener(l2);
        set.setOnClickListener(l2);
    }

    View.OnClickListener l2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            System.out.println("点我干哈");

        }
    };
}
