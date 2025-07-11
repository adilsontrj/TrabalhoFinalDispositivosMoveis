package br.edu.ifsp.listasemana05_3e4;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.edtSpinner);
        TextView selecao = (TextView) findViewById(R.id.selecao);

        ImageView img = (ImageView) findViewById(R.id.fotoFruta);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String item = adapterView.getItemAtPosition(position).toString();
                selecao.setText(item);

                switch (item){

                    case "Banana":

                        img.setImageResource(R.drawable.banana);

                        break;

                    case "Maçã":

                        img.setImageResource(R.drawable.maca);

                        break;

                    case "Kiwi":

                        img.setImageResource(R.drawable.kiwi);

                        break;

                    case "Limão":

                        img.setImageResource(R.drawable.limao);

                        break;

                    case "Laranja":

                        img.setImageResource(R.drawable.laranja);

                        break;

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Banana");
        arrayList.add("Maçã");
        arrayList.add("Kiwi");
        arrayList.add("Limão");
        arrayList.add("Laranja");
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>( this, android.R.layout.simple_spinner_item, arrayList);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);

    }
}