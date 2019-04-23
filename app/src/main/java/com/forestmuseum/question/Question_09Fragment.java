package com.forestmuseum.question;



import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import android.widget.RadioGroup;

import com.forestmuseum.QuestionActivity;
import com.forestmuseum.R;


public class Question_09Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_09_, null);
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
        radioGroup = getActivity().findViewById(R.id.question9);
        if(QuestionActivity.userAnswer[8] != 0){
            ((RadioButton)getActivity().findViewById(QuestionActivity.userAnswer[8])).setChecked(true);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = radioGroup.getCheckedRadioButtonId();

                QuestionActivity.userAnswer[8] = checkedId;
                String anwser = ((RadioButton)getActivity().findViewById(id)).getText().toString();
                System.out.println(anwser);
                if ("A. 川".equals(anwser)){
                    QuestionActivity.scores[8]=1;
                }else{
                    QuestionActivity.scores[8]=0;
                }
            }
        });
    }
}
