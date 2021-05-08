package sv.edu.udb.guia12appcontentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class agregarStudent extends AppCompatActivity {

    private EditText et1,et2,et3;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_student);

        et1=(EditText)findViewById(R.id.edt1);
        et2=(EditText)findViewById(R.id.edt2);
        et3=(EditText)findViewById(R.id.edt3);
        btn=(Button)findViewById(R.id.btnAgregar);

    }

    public void alta(View v) {
        DatabaseHelper admin = new DatabaseHelper(this,"students", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String carnet = et1.getText().toString();
        String nombre = et2.getText().toString();
        String apellido = et3.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("carnet", carnet);
        registro.put("nombre", nombre);
        registro.put("apellido", apellido);

        try {
            Intent i = new Intent(getBaseContext(), MainActivity.class);
            bd.insert("students", null, registro);
            bd.close();
            et1.setText("");
            et2.setText("");
            et3.setText("");
            startActivity(i);
            Toast.makeText(this, "Se agregaron los datos de la persona",Toast.LENGTH_SHORT).show();
        } catch (SQLiteException e) {
            Toast.makeText(this, "ERROR!! No se cargaron los datos" + e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }

}