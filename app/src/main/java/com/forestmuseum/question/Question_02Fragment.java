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


public class Question_02Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_02_, null);
        return view;
    }

    /**
     * 获取答案
     */
    private RadioGroup radioGroup;
    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        radioGroup = getActivity().findViewById(R.id.question2);


//        System.out.println(QuestionActivity.userAnswer[1]);
//        if(QuestionActivity.userAnswer[1] != 0){
//            ((RadioButton)getActivity().findViewById(QuestionActivity.userAnswer[1])).setChecked(true);
//
//        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = radioGroup.getCheckedRadioButtonId();
                QuestionActivity.userAnswer[1] = checkedId;

                String anwser = ((RadioButton)getActivity().findViewById(id)).getText().toString();
                System.out.println(anwser);
                if ("C. 蓑羽鹤".equals(anwser)){
                    QuestionActivity.scores[1]=1;
                }else{
                    QuestionActivity.scores[1]=0;
                }
            }
        });
    }
}
