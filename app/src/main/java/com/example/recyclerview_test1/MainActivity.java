package com.example.recyclerview_test1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<IconListModel> iconListArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Attach our adapter to our recycler view
        //1. get our recyclerView
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        //2.create an adapter after you setup your models
        //MUST after setup your iconList
        setupIconList();

        Icon_RecyclerViewAdapter adapter = new Icon_RecyclerViewAdapter(this, iconListArray);
        //3.attach to our recycler view
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    //Storing Instances of our model class
    private void setupIconList(){
        String[] iconNames = getResources().getStringArray(R.array.icon_full_name);
        String[] iconNumbers = getResources().getStringArray(R.array.icon_number);
        String[] iconShorts = getResources().getStringArray(R.array.icon_short_name);
        int[] iconImages = {R.drawable.ic_baseline_ac_unit_24, R.drawable.ic_baseline_airport_shuttle_24, R.drawable.ic_baseline_all_inclusive_24, R.drawable.ic_baseline_apartment_24, R.drawable.ic_baseline_baby_changing_station_24, R.drawable.ic_baseline_backpack_24, R.drawable.ic_baseline_balcony_24, R.drawable.ic_baseline_bathtub_24, R.drawable.ic_baseline_beach_access_24, R.drawable.ic_baseline_bento_24, R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground};

        for (int i = 0; i<iconNames.length; i++){
            iconListArray.add(new IconListModel(iconNames[i], iconNumbers[i], iconShorts[i],iconImages[i]));
        }
    }
}