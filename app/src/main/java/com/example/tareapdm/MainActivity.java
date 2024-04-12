package com.example.tareapdm;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText txt1, txt2;;
    TextView lblres;
    float n1, n2, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //creamos las escuchas
        txt1 = (EditText) findViewById(R.id.v1et1);
        txt2 = (EditText) findViewById(R.id.v1et2);
        lblres = (TextView) findViewById(R.id.v1tvres);
        //3 forma de botones
    }
    public void borrar(){
        txt1.setText("");
        txt2.setText("");
        txt1.requestFocus();
    }
    public int validar(){
        int b=0;
        if(!txt1.getText().toString().isEmpty() && !txt2.getText().toString().isEmpty())
        {
            n1 = Float.parseFloat(txt1.getText().toString());
            n2 = Float.parseFloat(txt2.getText().toString());
            b=1;
            borrar();
        }
        else if(txt1.getText().toString().isEmpty()){
            Toast.makeText(this, "falta el 1 numero", Toast.LENGTH_SHORT).show();
            txt1.requestFocus();
        }else {
            Toast.makeText(this, "falta el 2 numero", Toast.LENGTH_SHORT).show();
            txt2.requestFocus();
        }
        return b;
    }

    public void onClick(View v) {
        if(validar()==1)
        {
            if(v.getId()==R.id.v1btnsuma){
                res = n1+n2;
                lblres.setText(n1 + " + " + n2 + " = " + res);
            }else if(v.getId()==R.id.v1btnresta){
                res = n1-n2;
                lblres.setText(n1 + " - " + n2 + " = " + res);
            }else if(v.getId()==R.id.v1btnmulti){
                res = n1*n2;
                lblres.setText(n1 + " * " + n2 + " = " + res);
            }else if(v.getId()==R.id.v1btndivi){
                if(n2!=0){
                    res = n1/n2;
                    lblres.setText(n1 + " / " + n2 + " = " + res);
                }
                else
                    Toast.makeText(this, "no se puede dividir por 0", Toast.LENGTH_SHORT).show();
            } else if (v.getId()==R.id.v1btnMod) {
                res = n1%n2;
                lblres.setText("El modulo de "+ n1 +" " + n2 + " es: "+ res);
            }
        }
    }





}