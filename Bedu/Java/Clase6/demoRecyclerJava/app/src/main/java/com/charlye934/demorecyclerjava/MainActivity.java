package com.charlye934.demorecyclerjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> lista;
    RecyclerView myReciclyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myReciclyer = (RecyclerView)findViewById(R.id.miRecycler);
        myReciclyer.setLayoutManager(new LinearLayoutManager(this));

        lista = new ArrayList<>();

        for(int i=0; i<60;i++){
            lista.add("Item numero: " + (i+1));
        }

        MyAdapter adaptador = new MyAdapter(lista);
        myReciclyer.setAdapter(adaptador);
    }
}
