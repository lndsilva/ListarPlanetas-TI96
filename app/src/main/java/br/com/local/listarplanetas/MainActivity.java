package br.com.local.listarplanetas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Variavel global do componente listView
    ListView listView;

    //Simulando o carregamento de dados

    String nomePlanetas[] = {"Jupiter", "Lua", "Marte", "Mercurio",
            "Netuno", "Plutão", "Saturno", "Sol", "Terra", "Urano", "Venus"};

    int imgPlanetas[] = {R.drawable.jupiter, R.drawable.lua, R.drawable.marte,
            R.drawable.mercurio, R.drawable.netuno, R.drawable.plutao, R.drawable.saturno,
            R.drawable.sol, R.drawable.terra, R.drawable.urano, R.drawable.venus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.idListaPlanetas);

        //Instanciando a classe que contém o Adapter
        Adaptador adaptador = new Adaptador();

        //Montando a lista com o modelo
        listView.setAdapter(adaptador);

        //Criando o clique no item da lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               /*Toast.makeText(getApplicationContext(),
                        "Cliquei no planeta: " + nomePlanetas[position],
                        Toast.LENGTH_SHORT).show();*/

                //A forma de abrir a janela passando valores no momento

                Intent intent = new Intent(getApplicationContext(), MostraPlanetas_Activity.class);

                //Passar os valores da classe atual para a classe de destino

                intent.putExtra("nomePlaneta", nomePlanetas[position]);
                intent.putExtra("imagemPlaneta", imgPlanetas[position]);

                //abrir a janela
                startActivity(intent);


            }
        });
    }

    //Inner class para criar o adaptador
    public class Adaptador extends BaseAdapter {

        @Override
        public int getCount() {
            return imgPlanetas.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        //Inflar o modelo de layout para ser inserido na listView
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //Declarando os componentes do modelo
            TextView txtNomePlanetas;
            ImageView imagemPlanetas;

            View carregaView = getLayoutInflater().inflate(R.layout.modelo_planetas, null);

            txtNomePlanetas = carregaView.findViewById(R.id.txtNomePlaneta);
            imagemPlanetas = carregaView.findViewById(R.id.imgPlaneta);

            txtNomePlanetas.setText(nomePlanetas[position]);
            imagemPlanetas.setImageResource(imgPlanetas[position]);

            return carregaView;
        }
    }
}