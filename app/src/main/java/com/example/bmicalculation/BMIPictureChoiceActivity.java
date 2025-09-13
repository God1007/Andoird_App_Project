package com.example.bmicalculation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class BMIPictureChoiceActivity extends AppCompatActivity {

    private Button childButton;
    private Button adultButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_picture_choice);

        // 初始化按钮
        childButton = findViewById(R.id.child_button);
        adultButton = findViewById(R.id.adult_button);

        // 设置儿童按钮点击监听器
        childButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到 ChildActivity
                Intent intent = new Intent(BMIPictureChoiceActivity.this, ChildActivity.class);
                startActivity(intent);

                // 可选：添加跳转动画
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        // 设置成人按钮点击监听器
        adultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到 AdultActivity
                Intent intent = new Intent(BMIPictureChoiceActivity.this, AdultActivity.class);
                startActivity(intent);

                // 可选：添加跳转动画
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }
}