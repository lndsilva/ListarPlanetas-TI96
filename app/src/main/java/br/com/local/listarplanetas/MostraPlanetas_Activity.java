package br.com.local.listarplanetas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MostraPlanetas_Activity extends AppCompatActivity {

    //declarando os objetos globais para receber o xml
    TextView txtPlanetas;
    ImageView imgPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostra_planetas_layout);

        txtPlanetas = findViewById(R.id.mtxtPlaneta);
        imgPlanetas = findViewById(R.id.mimgPlaneta);

        //Receber o valor de outra janela
        Intent intent = getIntent();

        //Recebendo os valores pela variável declarada na janela de origem
        String nPlaneta = intent.getStringExtra("nomePlaneta");
        int mPlaneta = intent.getIntExtra("imagemPlaneta",0);

        //Inserindo os valores nos componentes
        txtPlanetas.setText(nPlaneta);
        imgPlanetas.setImageResource(mPlaneta);
    }
}