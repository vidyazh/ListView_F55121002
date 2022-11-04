package com.example.listview_f55121002;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private HeroAdapter adapter;
    ListView listView;
    private ArrayList<Hero> heroes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new HeroAdapter(this);
        listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);


        prepare();
        addItem();

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> adapterView,
                                View view, int i, long id){
            if (i==0){
                startActivity(new Intent(MainActivity.this, descriptionabtme.class));
            }
        } 
    });
    }


    private void prepare() {
        dataName =
                getResources().getStringArray(R.array.data_name);
        dataDescription =
                getResources().getStringArray(R.array.data_description);
        dataPhoto =
                getResources().obtainTypedArray(R.array.data_photo);

    }

    private void addItem() {
        heroes = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Hero hero = new Hero();
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            heroes.add(hero);
        }
        adapter.setHeroes(heroes);
    }


}






