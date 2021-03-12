package com.example.desafio1ejer3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Nom1, Ape1, Tiempo1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nom1 = findViewById(R.id.Nombre1);
        Ape1 = findViewById(R.id.Apellido1);
        Tiempo1 = findViewById(R.id.Horas1);
    }

    public void Ingresar(View in){
        Intent calculos = new Intent(this, Salarios.class);
        double HorasMens1 = Double.valueOf(Tiempo1.getText().toString());
        double SalBas1 = 0, SalBas2 = 0, SalBas3 = 0;
        double ISSS1, AFP1, RENTA1;
        double ISSS2, AFP2, RENTA2;
        double ISSS3, AFP3, RENTA3;
        String BonoNull="";

        if (Nom1.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Rellene todos los campos de nombre por favor", Toast.LENGTH_LONG).show();
        }
        if (Ape1.getText().toString().trim().isEmpty() ){
            Toast.makeText(this, "Rellene todos los campos de apellido por favor", Toast.LENGTH_LONG).show();
        }
        if (Tiempo1.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Rellene todos los campos de horas mensuales trabajadas por favor", Toast.LENGTH_LONG).show();
        }
        if (HorasMens1<0){
            Toast.makeText(this, "Los campos Horas trabajadas no pueden ser negativos", Toast.LENGTH_LONG).show();
        }
        if (HorasMens1<=160){
            SalBas1 = HorasMens1*9.75;
        }
        if (HorasMens1>160){
            SalBas1 = 160*9.75 +(HorasMens1-160)*11.50;
        }
        ISSS1= SalBas1*0.0525; ISSS2 = SalBas2*0.0525; ISSS3 = SalBas3*0.0525;
        AFP1 = SalBas1*0.0688; AFP2 = SalBas2*0.0688; AFP3 = SalBas3*0.0688;
        RENTA1 = SalBas1*0.1; RENTA2 = SalBas2*0.1; RENTA3 = SalBas3*0.1;
        double SalF1 = SalBas1 - ISSS1 - AFP1 - RENTA1;
        double SalF2 = SalBas2 - ISSS2 - AFP2 - RENTA2;
        double SalF3 = SalBas3 - ISSS3 - AFP3 - RENTA3;

        String NombreC1= Nom1 + " " + Ape1;
        calculos.putExtra("NomCom1", NombreC1);
        calculos.putExtra("isss1", ISSS1);
        calculos.putExtra("isss2", ISSS2);
        calculos.putExtra("isss3", ISSS3);
        calculos.putExtra("afp1", AFP1);
        calculos.putExtra("afp2", AFP2);
        calculos.putExtra("afp3", AFP3);
        calculos.putExtra("renta1", RENTA1);
        calculos.putExtra("renta2", RENTA2);
        calculos.putExtra("renta3", RENTA3);
        calculos.putExtra("fluido1", SalF1);
        calculos.putExtra("fluido2", SalF2);
        calculos.putExtra("fluido3", SalF3);
        calculos.putExtra("NoBono", BonoNull);

        startActivity(calculos);
    }
}