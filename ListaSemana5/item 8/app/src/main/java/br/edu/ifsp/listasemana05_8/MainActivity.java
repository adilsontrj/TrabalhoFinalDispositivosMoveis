package br.edu.ifsp.listasemana05_8;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private Spinner spinner;

    private LinearLayout main;


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

        AlertDialog.Builder adb = new AlertDialog.Builder( MainActivity.this);

        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText( MainActivity.this,
                        "Clicou em ok!", Toast.LENGTH_LONG).show();

            }
        });

        adb.setNegativeButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText( MainActivity.this,
                        "Clicou em Fechar!", Toast.LENGTH_LONG).show();

            }
        });

        adb.create();

        main = findViewById(R.id.main);



        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int position, long id) {

                String item = adapterView.getItemAtPosition(position).toString();

                int colorResId = 0;

                switch (item){

                    case "Azul":

                        adb.setMessage("A nova cor é azul!");
                        adb.show();

                        colorResId = R.color.blue;


                        break;

                    case "Vermelho":

                        adb.setMessage("A nova cor é vermelho!");
                        adb.show();

                        colorResId = R.color.red;

                        break;

                    case "Verde":

                        adb.setMessage("A nova cor é verde!");
                        adb.show();

                        colorResId = R.color.green;

                        break;
                }

                int color = ContextCompat.getColor( MainActivity.this, colorResId);

                main.setBackgroundColor(color);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Azul");
        arrayList.add("Vermelho");
        arrayList.add("Verde");

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>( this, android.R.layout.simple_spinner_item, arrayList);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);



    }

    public void abrir(View v){



    }

}