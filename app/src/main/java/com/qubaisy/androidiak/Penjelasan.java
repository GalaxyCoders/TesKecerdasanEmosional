package com.qubaisy.androidiak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Penjelasan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjelasan);
    }

    public void menuawal (View view){
        Intent intent = new Intent(this, MenuAwal.class);
        startActivity(intent);
    }
}
