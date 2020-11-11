package com.filhoairlon.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view){

        //Recuperando valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoAlcool.getText().toString();

        Boolean resultado = validarCampos(precoAlcool, precoGasolina);

        if(resultado){

            Double precoAl = Double.parseDouble(precoAlcool);
            Double precoGa = Double.parseDouble(precoGasolina);
            Double result = precoAl / precoGa;
            if( result >= 0.7) {
                textResultado.setText("Melhor utilizar gasolina");
            }else {
                textResultado.setText("Melhor utilizar álcool");
            }
        }else{
            textResultado.setText("Preencha os preços primeiro");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina) {
        Boolean resultado = true;

        if(pAlcool == null || pAlcool.equals("")){
            resultado = false;
        }else if(pGasolina == null || pGasolina.equals("")){
            resultado = false;
        }

        return resultado;
    }
}