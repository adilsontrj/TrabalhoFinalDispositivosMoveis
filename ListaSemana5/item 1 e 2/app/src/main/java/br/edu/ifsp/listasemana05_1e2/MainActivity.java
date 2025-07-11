package br.edu.ifsp.listasemana05_1e2;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

import br.edu.ifsp.listasemana05_1e2.modelo.Data;

public class MainActivity extends AppCompatActivity {

    private Button botao;

    private TextView data;



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

        botao = (Button) findViewById(R.id.abrir);

        data = (TextView) findViewById(R.id.data);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                abrirCalendario();

            }
        });


    }

    private void abrirCalendario(){

        DatePickerDialog dialogo = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker , int year, int month, int dayOfMonth) {

                data.setText(String.valueOf(dayOfMonth) + '/' +
                        String.valueOf(month + 1) + '/' +
                        String.valueOf(year));

                Data dataSalva = new Data();
                dataSalva.setDia(dayOfMonth);
                dataSalva.setMes(month);
                dataSalva.setAno(year);


            }
        }, 2025, 3, 15);

        dialogo.show();


    }

}