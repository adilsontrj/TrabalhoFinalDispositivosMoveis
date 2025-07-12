package br.edu.ifsp.atividadesala;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    Bundle params = result.getData() != null ? result.getData().getExtras() : null;

                    Pessoa p = new Pessoa();

                    p.setId(params.getInt("id"));
                    p.setNome(params.getString("nome"));
                    p.setIdade(params.getInt("idade"));

                    Toast.makeText(getApplicationContext(),
                            "O id é: " + p.getId(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),
                            "O nome é: " + p.getNome(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),
                            "A idade é: " + p.getIdade(), Toast.LENGTH_SHORT).show();


                }



    });

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

        Button abrirTela = (Button) findViewById(R.id.abrir);
        abrirTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent it = new Intent(getApplicationContext(), TelaCadastro.class);
                mStartForResult .launch(it);

            }
        });




    }

}