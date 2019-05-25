package com.qubaisy.androidiak;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Tes1 extends AppCompatActivity {

    CheckBox cb1, cb2, cb3;
    int nilai = 0;
    private AlertDialog.Builder alertDialogBuilder;
    CountDownTimer countDownTimer;
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes1);

        time = (TextView) findViewById(R.id.waktu);

                 countDownTimer = new CountDownTimer(16 * 1000, 1000) {
                    @Override
                    public void onTick(long l) {
                        time.setText("" + l / 1000);
                    }

                    @Override
                    public void onFinish() {
                        time.setText("Times Up!");

                        Intent intent = new Intent(Tes1.this, Tes2.class);
                        startActivity(intent);
                    }
                }.start();

        alertDialogBuilder = new AlertDialog.Builder(this);

        cb1 = (CheckBox) findViewById(R.id.checkbox1);
        cb2 = (CheckBox) findViewById(R.id.checkbox2);
        cb3 = (CheckBox) findViewById(R.id.checkbox3);

    }

    public void nextButton(View view) {
        boolean checkbox1 = cb1.isChecked();
        boolean checkbox2 = cb2.isChecked();
        boolean checkbox3 = cb3.isChecked();

        int tambah = hitungNilaiCheckBox(checkbox1, checkbox2, checkbox3);

        Intent intent = new Intent(Tes1.this, Tes2.class);
        intent.putExtra("lempar1", tambah);
        startActivity(intent);

        if (countDownTimer != null){
            countDownTimer.cancel();
            countDownTimer = null;
        }
    }


    private int hitungNilaiCheckBox(boolean checkbox1, boolean checkbox2, boolean checkbox3) {
        if (checkbox1) {
            nilai = nilai + 3;
        }
        if (checkbox2) {
            nilai = nilai + 2;
        }
        if (checkbox3) {
            nilai = nilai + 1;
        }

        return nilai;
    }

    public void onBackPressed() {

        alertDialogBuilder.setTitle("Tidak diperbolehkan");
        alertDialogBuilder.setMessage("Anda sedang di dalam tes")
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).create().show();
    }
}

