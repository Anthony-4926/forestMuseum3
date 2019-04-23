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


public class Question_10Fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_10_, null);
        radioGroup = getActivity().findViewById(R.id.question1);
//        System.out.println(QuestionActivity.userAnswer[9]);
        if(QuestionActivity.userAnswer[9] != 0){
            ((RadioButton)getActivity().findViewById(QuestionActivity.userAnswer[9])).setChecked(true);
        }
        return view;
    }

    /**
     * 获取答案
     */
    private RadioGroup radioGroup;
    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        radioGroup = getActivity().findViewById(R.id.question10);
        if(QuestionActivity.userAnswer[9] != 0){
            ((RadioButton)getActivity().findViewById(QuestionActivity.userAnswer[7])).setChecked(true);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = radioGroup.getCheckedRadioButtonId();

                QuestionActivity.userAnswer[9] = checkedId;
                String anwser = ((RadioButton) getActivity().findViewById(id)).getText().toString();
                System.out.println(anwser);
                if ("A. 雄".equals(anwser)){
                    QuestionActivity.scores[9]=1;
                }else{
                    QuestionActivity.scores[9]=0;
                }
            }
        });
    }
}
