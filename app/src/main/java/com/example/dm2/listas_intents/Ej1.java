package com.example.dm2.listas_intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ej1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


        private Spinner spinner;
        ArrayList<String> a= new ArrayList<>();
    TextView t;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ej1);
            spinner = (Spinner) findViewById(R.id.spinner);
            ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                    R.array.valores_array, android.R.layout.simple_spinner_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
            t=(TextView)findViewById(R.id.info);
            a.add(0,"Superficie de España");
            a.add(1,"Superficie de EEUU");
            a.add(2,"Superficie de Australia");
            a.add(3,"Superficie de China");
            a.add(4,"Superficie de Japon");
            a.add(5,"Superficie de Rusia");
        }
        @Override
        public void onItemSelected(AdapterView<?> adapterView,
                                   View view, int position, long l) {
            TextView tvMensaje=(TextView) view;
            Toast.makeText(this, "Has seleccionado " + tvMensaje.getText()
                    + " en la posición " + (position+1), Toast.LENGTH_SHORT).show();
            t.setText(a.get(position));
        }
        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }

}
