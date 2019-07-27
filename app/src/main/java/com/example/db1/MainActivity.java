package com.example.db1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.db1.adapters.AdapterGridView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Spinner spfiltros;
    GridView gridView;
    ListView listView;
    Toolbar toolbar;
    ImageButton imgButtonAdd;
    FrameLayout frameGrid, frameList;
    // adaptadores
    ArrayAdapter<String> adapterSpinner;
    String  arraySpinner[] = {"En Lista", "En Celdas"};
    ArrayList<String> nombres, telefonos, urls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spfiltros = (Spinner)findViewById(R.id.spinner_filtro_vista);
        gridView = (GridView)findViewById(R.id.grid);
        listView = (ListView)findViewById(R.id.list);
        imgButtonAdd = (ImageButton)findViewById(R.id.img_button);
        frameGrid =(FrameLayout)findViewById(R.id.frame_grid);
        frameList =(FrameLayout)findViewById(R.id.frame_list);
        toolbar = (Toolbar)findViewById(R.id.toolbarmain);
        setSupportActionBar(toolbar);
        // asignar adaptadores
        adapterSpinner = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arraySpinner);
        spfiltros.setAdapter(adapterSpinner);
        init();
        gridView.setAdapter(new AdapterGridView(this, nombres, telefonos, urls));
        spfiltros.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    frameGrid.setVisibility(View.GONE);
                    frameGrid.setEnabled(false);
                    frameList.setVisibility(View.VISIBLE);
                    frameList.setEnabled(true);
                }
                else if(position==1){
                    frameGrid.setVisibility(View.VISIBLE);
                    frameGrid.setEnabled(true);
                    frameList.setVisibility(View.GONE);
                    frameList.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void init()
    {
        frameGrid.setVisibility(View.GONE);
        frameGrid.setEnabled(false);
        frameList.setVisibility(View.VISIBLE);
        frameList.setEnabled(true);
        crearContactos();
    }
    public void cargarLista(){

    }
    public void cargarGrid(){

    }

    public void crearContactos(){
        nombres = new ArrayList<String>();
        telefonos = new ArrayList<String>();
        urls = new ArrayList<String>();

        nombres.add("Alberto");
        nombres.add("Edith");
        nombres.add("Sergio");
        nombres.add("Angel");

        telefonos.add("5512345678");
        telefonos.add("5578968697");
        telefonos.add("5598765432");
        telefonos.add("5582719346");

        urls.add("/img1");
        urls.add("/img2");
        urls.add("/img3");
        urls.add("/img4");
    }

}
