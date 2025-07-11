package br.edu.ifsp.listasemana05_9;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botao = (Button) findViewById(R.id.botaoAbrir);

        AlertDialog.Builder adb = new AlertDialog.Builder(this);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.progress_bar_layout, null);

                texto = (TextView) dialogView.findViewById(R.id.texto);

                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setView(dialogView);
                AlertDialog alert = adb.create();
                alert.show();

                new Handler(Looper.getMainLooper()).postDelayed(alert::dismiss, 5000);

                new CountDownTimer( 6000, 1000){

                    @Override
                    public void onTick( long millis ){

                        int segundos = (int) (millis / 1000);
                        texto.setText(String.valueOf(segundos));

                    }

                    @Override
                    public void onFinish() {
                        alert.dismiss();
                    }
                }.start();
            }
        });
    }
}