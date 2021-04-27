package br.com.local.listarplanetas;

import androidx.appcompat.app.AppCompatActivity;

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
    ListView listView;

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

        Adaptador adaptador = new Adaptador();

        listView.setAdapter(adaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Cliquei no planeta: " + nomePlanetas[position],
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

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

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            TextView txtNomePlanetas;
            ImageView imagemPlanetas;

            View v = getLayoutInflater().inflate(R.layout.modelo_planetas, null);

            txtNomePlanetas = v.findViewById(R.id.txtNomePlaneta);
            imagemPlanetas = v.findViewById(R.id.imgPlaneta);

            txtNomePlanetas.setText(nomePlanetas[position]);
            imagemPlanetas.setImageResource(imgPlanetas[position]);

            return v;
        }
    }
}