package com.qubaisy.androidiak;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class Tes3 extends AppCompatActivity {

    private AlertDialog.Builder alertDialogBuilder;
    RadioButton RB1, RB2, RB3;
    int tangkapNilai, nilai;
    TextView time;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes3);

        time = (TextView) findViewById(R.id.waktu);


       countDownTimer = new CountDownTimer(16 * 1000, 1000) {
            @Override
            public void onTick(long l) {
                time.setText("" + l / 1000);
            }

            @Override
            public void onFinish() {
                time.setText("Times Up!");

                Intent intent = new Intent(Tes3.this, Tes4.class);
                startActivity(intent);
            }
        }.start();

        alertDialogBuilder = new  AlertDialog.Builder(this);

        RB1 = (RadioButton) findViewById(R.id.radio1);
        RB2 = (RadioButton) findViewById(R.id.radio2);
        RB3 = (RadioButton) findViewById(R.id.radio3);

        Intent mIntent = getIntent();
        tangkapNilai = mIntent.getIntExtra("lempar2", 0);
        nilai = tangkapNilai;

        RB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilai = nilai + 3;
            }
        });
        RB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilai = nilai + 2;
            }
        });
        RB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilai = nilai + 1;
            }
        });

    }

    public void nextButton(View view) {

        Intent intent = new Intent(Tes3.this, Tes4.class);
        intent.putExtra("lempar3", nilai);
        startActivity(intent);

        if (countDownTimer != null){
            countDownTimer.cancel();
            countDownTimer = null;
        }

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

