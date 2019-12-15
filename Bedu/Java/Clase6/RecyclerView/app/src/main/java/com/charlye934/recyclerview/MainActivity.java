package com.charlye934.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Cuadros> listaCuadros;
    RecyclerView recyclerViewCuadros;

    String nombre[] = {"Carlos", "Adalberto", "Oscar", "Cesar", "Andrea", "Guadalupe", "Patricia", "Carmen", "Alberto"};
    int imagenes[] = {R.drawable.cuadro1, R.drawable.cuadro2, R.drawable.cuadro3, R.drawable.cuadro4, R.drawable.cuadro5, R.drawable.cuadro6, R.drawable.cuadro7, R.drawable.cuadro8, R.drawable.cuadro9};
    int fotos[] = {R.drawable.per1,R.drawable.per2,R.drawable.per3,R.drawable.per4,R.drawable.per5,R.drawable.per6,R.drawable.per7,R.drawable.per8,R.drawable.per9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaCuadros = new ArrayList<>();
        recyclerViewCuadros = (RecyclerView) findViewById(R.id.myRecycler);
        recyclerViewCuadros.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < nombre.length; i++)
            listaCuadros.add(new Cuadros(nombre[i], Descripcion(i), imagenes[i],fotos[i]));

        AdapatadorCuadros adapter = new AdapatadorCuadros(listaCuadros);
        recyclerViewCuadros.setAdapter(adapter);
    }

    public String Descripcion(int posicion) {
        switch (posicion) {
            case 0:
                return "Es tan corto el amor y es tan largo el olvido.\n" + "\n" + "— Pablo Neruda";
            case 1:
                return "El que tiene imaginación, con qué facilidad saca de la nada un mundo.\n \n -Gustavo Adolfo Bécquer.";
            case 2:
                return "No basta con saber, se debe también aplicar. No es suficiente querer, se debe también hacer. \n\n -Goethe.";
            case 3:
                return "Puede que lo que hacemos no traiga siempre la felicidad, pero si no hacemos nada, no habrá felicidad.\n\n-Albert Camus.";
            case 4:
                return "Acá hay tres clases de gente: las que se matan trabajando, las que deberían trabajar y las que tendrían que matarse.\n\n -Mario Benedetti.";
            case 5:
                return "Todo fracaso es el condimento que da sabor al éxito.\n\n-Truman Capote";
            case 6:
                return "Acepta los riesgos, toda la vida no es sino una oportunidad. El hombre que llega más lejos es, generalmente, el que quiere y se atreve a serlo.\n\n-Dale Carnegie.";
            case 7:
                return "Daría todo lo que sé, por la mitad de lo que ignoro.\n\n-René Descartes";
            case 8:
                return "Si crees totalmente en ti mismo, no habrá nada que esté fuera de tus posibilidades.\n\n-Wayne W. Dyer.";
            default:
                return "";
        }
    }
}
