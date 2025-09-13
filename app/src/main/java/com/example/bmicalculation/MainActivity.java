package com.example.bmicalculation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // 声明视图变量
    private EditText vHeight, vWeight;
    private Button submitButton;
    private SharedPreferences sharedPreferences;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 设置布局文件

        // SharedPreferences initialization
        sharedPreferences = getSharedPreferences("BMI_Data", MODE_PRIVATE);

        // 初始化视图组件
        vHeight = findViewById(R.id.heightET);
        vWeight = findViewById(R.id.weightET);
        submitButton = findViewById(R.id.reportBtn);

        // 加载保存的数据
        loadSavedData();

        // 设置按钮点击监听器
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void loadSavedData() {
        String savedHeight = sharedPreferences.getString("height", "");
        String savedWeight = sharedPreferences.getString("weight", "");

        vHeight.setText(savedHeight);
        vWeight.setText(savedWeight);
    }

    // BMI计算方法
    private void calculateBMI() {
        // 获取输入的身高和体重
        String heightStr = vHeight.getText().toString();
        String weightStr = vWeight.getText().toString();

        // 验证输入是否为空
        if (heightStr.isEmpty() || weightStr.isEmpty()) {
            Toast.makeText(this, "Please enter both height and weight", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            // 保存数据到SharedPreferences
            saveData(heightStr, weightStr);

            // 创建Intent跳转到ReportActivity
            Intent intent = new Intent(MainActivity.this, ReportActivity.class);
            intent.putExtra("height", heightStr);
            intent.putExtra("weight", weightStr);
            startActivity(intent);

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // 保存数据到SharedPreferences
    private void saveData(String height, String weight) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("height", height);
        editor.putString("weight", weight);
        editor.apply(); // 或者使用 editor.commit()
    }
}