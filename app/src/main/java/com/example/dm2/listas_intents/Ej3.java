package com.example.dm2.listas_intents;

import android.content.ClipData;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TabHost;

public class Ej3 extends AppCompatActivity {



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

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item, menu);

        mi=menu.findItem(R.id.action_other);
        return true;
    }
}
