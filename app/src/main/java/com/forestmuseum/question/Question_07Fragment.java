package com.forestmuseum.question;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.RadioButton;

import android.widget.RadioGroup;

import com.forestmuseum.QuestionActivity;
import com.forestmuseum.R;


public class Question_07Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_07_, null);
        radioGroup = getActivity().findViewById(R.id.question1);
//        System.out.println(QuestionActivity.userAnswer[0]);

        return view;
    }

    /**
     * 获取答案
     */
    private RadioGroup radioGroup;
    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        radioGroup = getActivity().findViewById(R.id.question7);
        if(QuestionActivity.userAnswer[6] != 0){
            ((RadioButton)getActivity().findViewById(QuestionActivity.userAnswer[6])).setChecked(true);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = radioGroup.getCheckedRadioButtonId();

                QuestionActivity.userAnswer[6] = checkedId;
                String anwser = ((RadioButton)getActivity().findViewById(id)).getText().toString();
                System.out.println(anwser);
                if ("B. 错".equals(anwser)) {
                    QuestionActivity.scores[6] = 1;
                } else {
                    QuestionActivity.scores[6] = 0;
                }
            }
        });
    }
}
