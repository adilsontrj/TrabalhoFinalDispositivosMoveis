package br.edu.ifsp.listasemana05_5;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Aplicativo");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        int id = item.getItemId();

        if ( id == R.id.home){

            Toast.makeText(this, "Botão Home pressionado!",
                    Toast.LENGTH_SHORT).show();

        } else if ( id == R.id.login){

            Toast.makeText(this,"Botão Login pressionado!",
                    Toast.LENGTH_SHORT).show();


        } else if ( id == R.id.voltar){

            Toast.makeText(this, "Botão Voltar Pressionado",
                    Toast.LENGTH_SHORT).show();

        }

        return super.onOptionsItemSelected(item);

    }

}