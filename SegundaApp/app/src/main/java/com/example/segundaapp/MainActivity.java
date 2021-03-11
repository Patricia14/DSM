package com.example.segundaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    TextView tv1;
    int contar1 =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=(TextView) findViewById(R.id.tv1);


    }

    public void cierre (View view){
            contar1++;
        tv1.setText(Integer.toString(contar1));
        String V1 = tv1.getText().toString();

        for (int i=0; i>9; i++){
            tv1.setText(contar1);
        }
        if (contar1==10){
            contar1=0;
        }
    }

}