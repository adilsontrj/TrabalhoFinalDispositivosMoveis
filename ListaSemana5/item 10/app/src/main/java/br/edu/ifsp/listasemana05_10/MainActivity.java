package br.edu.ifsp.listasemana05_10;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private ProgressBar barra;

    int progresso = 0;

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

        botao = (Button) findViewById(R.id.botao);
        barra = (ProgressBar) findViewById(R.id.progressBar);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                abrirProgressBar();

            }
        });


    }

    public void abrirProgressBar(){

        botao.setVisibility(View.INVISIBLE);

        barra.setVisibility(View.VISIBLE);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if( progresso <= 100 ){

                    barra.setProgress(progresso);
                    progresso += 10;

                    handler.postDelayed(this, 500);

                } else {

                    botao.setVisibility(View.VISIBLE);

                    barra.setVisibility(View.INVISIBLE);

                    progresso = 0;

                }

            }
        }, 500 );

    }

}