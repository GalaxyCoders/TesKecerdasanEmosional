package com.qubaisy.androidiak;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    TextView hasil,jelas;
    private AlertDialog.Builder alertDialogBuilder;
    int tangkap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        alertDialogBuilder = new  AlertDialog.Builder(this);

        hasil = (TextView) findViewById(R.id.score);
        jelas = (TextView) findViewById(R.id.penjelasan);

        Intent mIntent = getIntent();
        tangkap = mIntent.getIntExtra("lemparbonus", 0);
        hasil.setText("Nilai Anda : " + tangkap);

        if (tangkap <= 19){
            jelas.setText("Emosi Anda tidak mudah menjadi tenang. Untuk menyatakan sebuah maksud baik, Anda berlindung dibalik tanggapan yang “tepat”, sering memaksakan diri untuk bersikap patuh dan lembut. Bila Anda tidak dapat menghadapi emosi dengan jujur, akui saja bahwa emosi itu memang ada, walaupun sebenarnya Anda hanya dapat menirukan tanggapan yang tepat bukan mengubahnya untuk\n" +
                    "dapat digunakan secara konstruktif. Menekan emosi dapat menimbulkan penyakit mental dan fisik. Pendirian yang dipegang teguh secara emosional tidak benar dan sering bersifat dogmatisme moralistis.");
        }else if (tangkap <= 27){
            jelas.setText("Usaha keras Anda untuk menguasai emosi patut dipuji tetapi sering salah dinilai dan tidak simpatik. Anda mempertahankan diri sendiri dari emosi yang “tidak layak” dengan menirukan tanggapan yang tepat, tetapi Anda cenderung memberikan ruang “bebas” dalam kepala Anda untuk beberapa pemikiran orang lain dan hal-hal yang lebih baik dipertimbangkan, dipahami, dan diserahkan pada “bank data” emosional untuk digunakan pada kesempatan berikutnya. Cobalah membiarkan dan mengekspresikan emosi Anda. Bahkan untuk emosi yang tampaknya tidak layak (marah, takut, merasa lemah, depresi, dan sebagainya) masuk kedalam konteks yang tidak merugikan seperti ketika mendengarkan musik atau menonton film. Jajaki dan akui emosi itu. Semuanya adalah bagian dari perisai kebijaksanaan diri Anda.");
        }else if (tangkap >= 28){
            jelas.setText("Anda tidak mempunyai masalah dalam menerima dan menguasai emosi Anda. Anda mampu menggunakan emosi anda pada saat yang tepat sambil mengendalikan impuls yang merusak. Anda merasa nyaman dengan tanggapan alami Anda, dimana tanggapan itu berfungsi sesuai dengan tujuannya. Anda mengetahui dengan jelas bagaimana cara menyalurkan konsekuensi fisiologis yang bermanfaat agar memberikan pengaruh paling baik bagi lingkungan di sekitar Anda.");
        }
    }

    public void menu (View view){
        Intent intent = new Intent(this, MenuAwal.class);
        startActivity(intent);
    }

    public void penjelasan (View v){
        Intent intent = new Intent(this, Penjelasan.class);
        startActivity(intent);
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
