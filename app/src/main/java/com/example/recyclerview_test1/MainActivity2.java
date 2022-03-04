package com.example.recyclerview_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //get data from MainActivity
        int image = getIntent().getIntExtra("IMAGE",0);

        ImageView Icon_Image = findViewById(R.id.imageViewNew);
        Icon_Image.setImageResource(image);
    }
}