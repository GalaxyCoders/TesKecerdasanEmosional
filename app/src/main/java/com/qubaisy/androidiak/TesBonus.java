package com.qubaisy.androidiak;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TesBonus extends AppCompatActivity {

    private AlertDialog.Builder alertDialogBuilder;
    int tangkapLagi, nilai;
    EditText editText;
    TextView time;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes_bonus);

        time = (TextView) findViewById(R.id.waktu);


       countDownTimer = new CountDownTimer(16 * 1000, 1000) {
            @Override
            public void onTick(long l) {
                time.setText("" + l / 1000);
            }

            @Override
            public void onFinish() {
                time.setText("Times Up!");

                Intent intent = new Intent(TesBonus.this, Score.class);
                startActivity(intent);
            }
        }.start();

        Intent mIntent = getIntent();
        tangkapLagi = mIntent.getIntExtra("lempar10", 0);
        nilai = tangkapLagi;

        editText = (EditText) findViewById(R.id.jawaban);
    }

    public void nextButton (View view){
        String jawaban = editText.getText().toString();

        if (jawaban.equals("Muhammad Qubaisy Andiyantama")){
            nilai = nilai + 1;
            Intent intent = new Intent(getApplicationContext(), Score.class);
            intent.putExtra("lemparbonus", nilai);
            startActivity(intent);

            if (countDownTimer != null){
                countDownTimer.cancel();
                countDownTimer = null;
            }
        }else if(jawaban.isEmpty()){
            editText.setError("Isi jawaban terlebih dahulu");

        }else if (!jawaban.equals("Muhammad Qubaisy Andiyantama")){
            nilai = nilai + 0;

            Intent intent = new Intent(TesBonus.this, Score.class);
            intent.putExtra("lemparbonus", nilai);
            startActivity(intent);

            if (countDownTimer != null){
                countDownTimer.cancel();
                countDownTimer = null;
            }
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
