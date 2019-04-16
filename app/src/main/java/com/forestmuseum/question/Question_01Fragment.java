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


public class Question_01Fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_01, null);
        return view;
    }
    /**
     * 获取答案
     */
    private RadioGroup radioGroup;
    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        radioGroup = getActivity().findViewById(R.id.question1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = radioGroup.getCheckedRadioButtonId();
                String anwser = ((RadioButton)getActivity().findViewById(id)).getText().toString();
                System.out.println(anwser);
                if ("B. 秘鲁".equals(anwser)){
                    QuestionActivity.scores[0]=1;
                }else{
                    QuestionActivity.scores[0]=0;
                }
            }
        });
    }





}
