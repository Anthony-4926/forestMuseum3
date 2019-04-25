package com.forestmuseum;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.forestmuseum.question.Question_01Fragment;
import com.forestmuseum.question.Question_02Fragment;
import com.forestmuseum.question.Question_03Fragment;
import com.forestmuseum.question.Question_04Fragment;
import com.forestmuseum.question.Question_05Fragment;
import com.forestmuseum.question.Question_06Fragment;
import com.forestmuseum.question.Question_07Fragment;
import com.forestmuseum.question.Question_08Fragment;
import com.forestmuseum.question.Question_09Fragment;
import com.forestmuseum.question.Question_10Fragment;

public class QuestionActivity extends Activity {
    private int process = 0;
    private ProgressBar progressBar;
    public static int[] scores = new int[10];
    public static int[] userAnswer = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private Fragment[] questionFragements = new Fragment[]{
            new Question_01Fragment(), new Question_02Fragment(), new Question_03Fragment(),
            new Question_04Fragment(), new Question_05Fragment(), new Question_06Fragment(),
            new Question_07Fragment(), new Question_08Fragment(), new Question_09Fragment(),
            new Question_10Fragment()
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        for (int i = 0; i < userAnswer.length; i++) {
            userAnswer[i] = 0;
            scores[i] = 0;
        }
//        FragmentManager fm = getFragmentManager();   // 获取Fragment
//        FragmentTransaction ft = fm.beginTransaction(); // 开启一个事务
//        ft.replace(R.id.questions, questionFragements[0]);
//        ft.commit(); //提交事务

//        拿到进度条
        progressBar = findViewById(R.id.process_bar);
//        拿到上一题按钮
        Button pre = findViewById(R.id.pre_question);
        //        拿到下一题按钮
        final Button next = findViewById(R.id.next_question);


//        给上一题按钮添加监听
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();   // 获取Fragment
                FragmentTransaction ft = fm.beginTransaction(); // 开启一个事务
                process--;
                if (process < 0) {
                    process = 0;
                }
                next.setText("下一题");
                progressBar.setProgress(process);
                ft.replace(R.id.questions, questionFragements[process]);
                ft.commit(); //提交事务
            }
        });


//        给上一题按钮添加监听
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (process != 9) {
                    FragmentManager fm = getFragmentManager();   // 获取Fragment
                    FragmentTransaction ft = fm.beginTransaction(); // 开启一个事务
                    process++;
                    if (process > 9) {
                        process = 9;
                    }
                    progressBar.setProgress(process);
                    if (process == 9) {
                        ((Button) v).setText("提交");
                    }
                    ft.replace(R.id.questions, questionFragements[process]);
                    ft.commit(); //提交事务
                } else {
                    int s = 0;
                    for (int i = 0; i < scores.length; i++) {
                        s += scores[i];
                    }
                    Log.d("得分情况：", String.valueOf(s));
                    ImageView scoreImg = findViewById(R.id.score_img);
                    scoreImg.setImageResource(getpic(s));
                    LinearLayout linearLayout = findViewById(R.id.score_layout);
                    linearLayout.getLayoutParams().height = LinearLayout.LayoutParams.MATCH_PARENT;
                    linearLayout.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
//
                }

            }
        });

    }


    public static int getpic(int s) {
        int id = R.drawable.s0;
        switch (s) {
            case 1:
                id = R.drawable.s10;
                break;
            case 2:
                id = R.drawable.s20;
                break;
            case 3:
                id = R.drawable.s30;
                break;
            case 4:
                id = R.drawable.s40;
                break;
            case 5:
                id = R.drawable.s50;
                break;
            case 6:
                id = R.drawable.s60;
                break;
            case 7:
                id = R.drawable.s70;
                break;
            case 8:
                id = R.drawable.s80;
                break;
            case 9:
                id = R.drawable.s90;
                break;
            case 10:
                id = R.drawable.s100_;
                break;
        }
        return id;
    }
}
