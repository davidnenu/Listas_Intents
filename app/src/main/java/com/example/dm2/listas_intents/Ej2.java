package com.example.dm2.listas_intents;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;

public class Ej2 extends AppCompatActivity {

    ListView lstFavoritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej2);


        Favorito[] datos =
                new Favorito[0];
        datos = new Favorito[]{
                new Favorito("Reddit","http://www.reddit.com",R.drawable.reddit,"Foro Reddit"),
                new Favorito("Reddit","http://www.reddit.com",R.drawable.reddit,"Foro Reddit"),
                new Favorito("Reddit","http://www.reddit.com",R.drawable.reddit,"Foro Reddit"),
                new Favorito("Reddit","http://www.reddit.com",R.drawable.reddit,"Foro Reddit"),
        };
        AdaptadorFavoritos adaptador =
                new AdaptadorFavoritos(this, datos);
        lstFavoritos = (ListView)findViewById(R.id.lstFavoritos);
        lstFavoritos.setAdapter(adaptador);

        //Eventos
        lstFavoritos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id)
            {
                //Alternativa 1:
                String url =
                        ((Favorito)a.getItemAtPosition(position)).getUrl();
                //long opcion = a.getItemIdAtPosition(position);

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });



    }

    class AdaptadorFavoritos extends ArrayAdapter<Favorito> {
        private Favorito[] dat;
        public AdaptadorFavoritos(Context context, Favorito[] dat) {
            super(context, R.layout.listitem_favoritos, dat);
            this.dat = dat;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_favoritos, null);

            TextView lblNombre = (TextView) item.findViewById(R.id.lblNombre);
            lblNombre.setText(dat[position]/*super.getItem(position)*/.getNombre());

            ImageView icon=(ImageView) item.findViewById(R.id.iconWeb);
            icon.setImageResource(dat[position]/*super.getItem(position)*/.getIcono());


            TextView lblUrl =
                    (TextView) item.findViewById(R.id.lblUrl);
            lblUrl.setText(getItem(position).getUrl());

            TextView lblDescripcion =
                    (TextView) item.findViewById(R.id.lblDescripcion);
            lblDescripcion.setText(getItem(position)/*dat[position]*/.getDescripcion());
            return (item);
        }

    }



     class Favorito {
        private String nombre;
        private String url;
        private int icono;
        private String descripcion;
        public Favorito(String n, String u,int i,String d){
            nombre=n;
            url=u;
            icono=i;
            descripcion=d;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getIcono() {
            return icono;
        }

        public void setIcono(int icono) {
            this.icono = icono;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
    }

}
