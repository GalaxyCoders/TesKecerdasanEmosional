package com.qubaisy.androidiak;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static com.qubaisy.androidiak.R.id.username;

public class MenuAwal extends AppCompatActivity {

    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_awal);

        alertDialogBuilder = new  AlertDialog.Builder(this);

        String userName = getIntent().getStringExtra("username");

        TextView tv = (TextView) findViewById(R.id.TVusername);
        tv.setText(userName);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.info){

            Intent intent = new Intent(MenuAwal.this, AboutUs.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void mulai_tes(View view){

        Intent intent = new Intent(MenuAwal.this, Tes1.class);
        startActivity(intent);

    }

    public void cara_main (View view){

        Intent intent = new Intent(MenuAwal.this, CaraMain.class);
        startActivity(intent);

    }

    public void keluar(View view) {

        alertDialogBuilder.setTitle("Log Out Akun");
        alertDialogBuilder.setMessage("Apakah Anda yakin ingin logout dan kembali ke menu login?")
                .setCancelable(false).setPositiveButton("YA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(MenuAwal.this, MainActivity.class);
                startActivity(intent);
            }
        })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).create().show();
    }

    public void onBackPressed() {

        alertDialogBuilder.setTitle("Log Out Akun");
        alertDialogBuilder.setMessage("Apakah Anda yakin ingin logout dan kembali ke menu login?")
                .setCancelable(false).setPositiveButton("YA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(MenuAwal.this, MainActivity.class);
                startActivity(intent);
            }
        })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).create().show();
    }
}
