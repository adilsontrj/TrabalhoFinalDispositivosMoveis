package br.edu.ifsp.atividadesala;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaCadastro extends Activity {

    EditText edtId;
    EditText edtNome;
    EditText edtIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);


        edtId = (EditText) findViewById(R.id.edtID);
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtIdade = (EditText) findViewById(R.id.edtIdade);


        //"Salvar" o conteúdo

        Button salvar = (Button) findViewById(R.id.salvar);
        salvar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0){

                Pessoa p = new Pessoa();

                p.setId(Integer.parseInt(edtId.getText().toString()));
                p.setNome(edtNome.getText().toString());
                p.setIdade(Integer.parseInt(edtIdade.getText().toString()));

                Intent it = new Intent();
                it.putExtra( "id", p.getId());
                it.putExtra( "nome", p.getNome());
                it.putExtra("idade", p.getIdade());
                setResult(1, it);
                finish();

            }


        });


    }



}
