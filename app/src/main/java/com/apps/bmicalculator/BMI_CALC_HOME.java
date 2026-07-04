package com.apps.bmicalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BMI_CALC_HOME extends AppCompatActivity {
    Button btn_inc_w;
    TextView text_weight;
    Button btn_inc_h;
    Button btn_dec_h;
    Button btn_dec_w;
    TextView text_height;
    TextView text_your_mbi;
    Button calc_btn;
    TextView tv_normal;
    TextView tv_overweight;
    TextView tv_obese;
    TextView tv_underweight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmi_calc_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        btn_inc_w = findViewById(R.id.btn_inc_w);
        text_weight = findViewById(R.id.text_weight);
        btn_inc_h = findViewById(R.id.btn_inc_h);
        btn_dec_h = findViewById(R.id.btn_dec_h);
        btn_dec_w = findViewById(R.id.btn_dec_w);
        text_height = findViewById(R.id.text_height);
        text_your_mbi = findViewById(R.id.text_your_mbi);
        calc_btn = findViewById(R.id.calc_btn);
        tv_normal = findViewById(R.id.tv_normal);
        tv_obese = findViewById(R.id.tv_obese);
        tv_overweight = findViewById(R.id.tv_overweight);
        tv_underweight = findViewById(R.id.tv_underweight);


        btn_inc_w.setOnClickListener(v -> {
            float current_w = Float.parseFloat(text_weight.getText().toString());
            text_weight.setText(String.valueOf(current_w +1));
            });
        btn_dec_w.setOnClickListener(v -> {
            float current_w = Float.parseFloat(text_weight.getText().toString());
            text_weight.setText(String.valueOf(current_w - 1));
        });

        btn_inc_h.setOnClickListener(v -> {
            float current_h = Float.parseFloat(text_height.getText().toString());
            text_height.setText(String.valueOf(current_h + 1));
        });

        btn_dec_h.setOnClickListener(v -> {
            float current_h = Float.parseFloat(text_height.getText().toString());
            text_height.setText(String.valueOf(current_h - 1));
        });

        calc_btn.setOnClickListener(v -> {
            double weight = Double.parseDouble(text_weight.getText().toString());
            double height = Double.parseDouble(text_height.getText().toString()) / 100;
            double bmi = 0;
            tv_normal.setTextColor(Color.BLACK);
            tv_overweight.setTextColor(Color.BLACK);
            tv_obese.setTextColor(Color.BLACK);
            tv_underweight.setTextColor(Color.BLACK);
            if (height > 0) {
                bmi = weight / (height * height);
                text_your_mbi.setText(String.format("%.2f", bmi));

                if(bmi < 18.5){
                    text_your_mbi.setTextColor(Color.BLUE);
                    tv_underweight.setTextColor(Color.BLUE);
                }
                else if (bmi >29.5 ){
                    text_your_mbi.setTextColor(Color.RED);
                    tv_obese.setTextColor(Color.RED);
                }
                else if(bmi > 24.5 && bmi < 29.5){
                    text_your_mbi.setTextColor(Color.rgb(255,165,0));
                    tv_overweight.setTextColor(Color.rgb(255,165,0));

                }
                else{
                    text_your_mbi.setTextColor(Color.GREEN);
                    tv_normal.setTextColor(Color.GREEN);
                }

            }
        });

    }
}