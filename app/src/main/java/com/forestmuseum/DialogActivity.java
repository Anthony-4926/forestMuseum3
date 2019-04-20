package com.forestmuseum;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DialogActivity extends Activity {
    private EditText dialogFrame;
    private TextView sendMessage;
    private LinearLayout dialogScope;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        sendMessage = findViewById(R.id.send_message);
        dialogFrame = findViewById(R.id.dialog_frame);
        dialogScope = findViewById(R.id.dialog_scope);

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = dialogFrame.getText().toString();
                dialogFrame.setText("");
                if (message.length() == -1) {
                    Toast.makeText(DialogActivity.this, "内容不能为空哦", Toast.LENGTH_SHORT).show();
                } else {
//                    新建一行容器
                    LinearLayout linearLayout = new LinearLayout(DialogActivity.this);
                    linearLayout.setOrientation(LinearLayout.HORIZONTAL);
//                    linearLayout.setGravity(Gravity.CENTER_VERTICAL);
//                   填充左侧
                    TextView fill = new TextView(DialogActivity.this);

//                    设置消息
                    TextView textView = new TextView(DialogActivity.this);
                    textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    LinearLayout.LayoutParams layoutParamsText = (LinearLayout.LayoutParams) textView.getLayoutParams();
                    layoutParamsText.setMargins(0,50, 50, 50);
                    textView.setLayoutParams(layoutParamsText);
                    textView.setText(message);
                    textView.setTextSize(20);
                    DisplayMetrics metric = new DisplayMetrics();
                    getWindowManager().getDefaultDisplay().getMetrics(metric);
                    int width = metric.widthPixels;// 屏幕宽度（像素）
                    textView.setMaxWidth(width/6*4);
                    textView.setBackgroundColor(getResources().getColor(R.color.backcolor));
                    textView.setPadding(50,50,50,50);


//                    设置头像
                    ImageView head = new ImageView(DialogActivity.this);
                    head.setImageResource(R.drawable.head);
                    LinearLayout.LayoutParams paramsHead = new LinearLayout.LayoutParams(width/6,width/6);
                    head.setLayoutParams(paramsHead);
                    LinearLayout.LayoutParams layoutParamsHead = (LinearLayout.LayoutParams) head.getLayoutParams();
                    layoutParamsHead.setMargins(0,50,0,0);

//                    设置填充组件
                    LinearLayout.LayoutParams paramFill = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                    paramFill.weight = 1;


//                    加入到页面
                    linearLayout.addView(fill, paramFill);
                    linearLayout.addView(textView);
                    linearLayout.addView(head, paramsHead);
                    dialogScope.addView(linearLayout);

                }
            }
        });
    }
}
