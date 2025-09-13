package com.example.bmicalculation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class ReportActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        // 获取传递过来的数据
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            double height = Double.parseDouble(bundle.getString("height")) / 100;
            double weight = Double.parseDouble(bundle.getString("weight"));
            double bmi = weight / (height * height);

            DecimalFormat nf = new DecimalFormat("0.00");
            TextView result = findViewById(R.id.report_result);
            result.setText("Your BMI value is " + nf.format(bmi));

            // 给出健康建议
            ImageView image = findViewById(R.id.report_image);
            TextView advice = findViewById(R.id.report_advice);

            if (bmi > 25) {
                image.setImageResource(R.drawable.bot_fat);
                advice.setText("You should be on diet!");
            } else if (bmi < 18.5) {
                image.setImageResource(R.drawable.bot_thin);
                advice.setText("You need more calories!");
            } else {
                image.setImageResource(R.drawable.bot_fit);
                advice.setText("You look great!");
            }
        }
    }
}