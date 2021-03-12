package com.example.desafio1ejer3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Salarios extends AppCompatActivity {
    private TextView  Emp1;
    private TextView Salario1;
    private TextView Seguro1;
    private TextView Afp1;
    private TextView Renta1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salarios);
        Mostrar();
    }

    public void Mostrar(){
        Bundle extras = getIntent().getExtras();

        double Disss1 = extras.getDouble("isss1");
        double Dafp1 = extras.getDouble("afp1");
        double Dren1 = extras.getDouble("renta1");
        double Sflu1 = extras.getDouble("fluido1");



        Salario1 = findViewById(R.id.SalEmp1);
        Salario1.setText("Salario: $" + Sflu1);

        Seguro1 = findViewById(R.id.DesSeg1);
        Seguro1.setText("ISSS: " + Disss1);

        Afp1 = findViewById(R.id.DesAfp1);
        Afp1.setText("AFP: " + Dafp1);

        Renta1 = findViewById(R.id.DesRen1);
        Renta1.setText("Renta: " + Dren1);


    }

    public void Atras(View in){
        Intent antes = new Intent(this, MainActivity.class);
        startActivity(antes);
    }
}