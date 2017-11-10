package com.example.dm2.listas_intents;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

public class Ej3 extends AppCompatActivity {


    ListView lstContactos,lstContactos2;
    MenuItem mi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej3);


        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("LLAMADAS");
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("CHATS");
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("CONTACTOS");
        tabs.addTab(spec);

        tabs.setCurrentTab(0);
        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {


                if(s.equals("mitab1")) {
                    mi.setIcon(R.drawable.ic_phone);
                }
                else if(s.equals("mitab2")) {
                    mi.setIcon(R.drawable.ic_chat);
                }
                else if(s.equals("mitab3")) {
                    mi.setIcon(R.drawable.ic_contacts);
                }
                //Log.i("AndroidTabsDemo","Pulsada pestaña: "+s);
            }
        });
        Contacto[] datos;
        datos = new Contacto[]{
                new Contacto("Pepe","@gmail.com","900 000 000"),
                new Contacto("Pepe","@gmail.com","900 000 000"),
                new Contacto("Pepe","@gmail.com","900 000 000"),
                new Contacto("Pepe","@gmail.com","900 000 000"),
        };
        AdaptadorContactos adaptador =
                new AdaptadorContactos(this,datos);
        lstContactos = (ListView)findViewById(R.id.lstContactos);
        lstContactos.setAdapter(adaptador);

        AdaptadorContactos2 adaptador2 =
                new AdaptadorContactos2(this,datos);
        lstContactos2 = (ListView)findViewById(R.id.lstLlamadas);
        lstContactos2.setAdapter(adaptador2);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item, menu);

        mi=menu.findItem(R.id.action_other);
        return true;
    }

    class AdaptadorContactos extends ArrayAdapter<Contacto> {
        private Contacto[] dat;
        public AdaptadorContactos(Context context, Contacto[] dat) {
            super(context, R.layout.listitem_contactos, dat);
            this.dat = dat;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_contactos, null);

            TextView lblNombre = (TextView) item.findViewById(R.id.lblNombre);
            lblNombre.setText(dat[position]/*super.getItem(position)*/.getNombre());

            TextView lblMail = (TextView) item.findViewById(R.id.lblMail);
            lblNombre.setText(dat[position]/*super.getItem(position)*/.getMail());
            return (item);
        }

    }

    class AdaptadorContactos2 extends ArrayAdapter<Contacto> {
        private Contacto[] dat;
        public AdaptadorContactos2(Context context, Contacto[] dat) {
            super(context, R.layout.listitem_contactos, dat);
            this.dat = dat;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_contactos, null);

            TextView lblNombre = (TextView) item.findViewById(R.id.lblNombre);
            lblNombre.setText(dat[position]/*super.getItem(position)*/.getNombre());

            TextView lblTelefono = (TextView) item.findViewById(R.id.lblTelefono);
            lblNombre.setText(dat[position]/*super.getItem(position)*/.getTelefono());
            return (item);
        }

    }



    class Contacto {
        private String nombre;
        private String mail;
        private String telefono;
        public Contacto(String n, String u, String d){
            nombre=n;
            mail =u;
            telefono =d;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }


        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }
    }

}
