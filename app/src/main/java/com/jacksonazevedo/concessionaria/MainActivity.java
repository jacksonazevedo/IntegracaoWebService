package com.jacksonazevedo.concessionaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jacksonazevedo.concessionaria.model.Setor;
import com.jacksonazevedo.concessionaria.model.Veiculo;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView list1 = findViewById(R.id.list1);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Veiculo>> call = api.getVeiculo();

        call.enqueue(new Callback<List<Veiculo>>() {
            @Override
            public void onResponse(Call<List<Veiculo>> call, Response<List<Veiculo>> response) {
                List<Veiculo> veiculos = response.body();

                String[] VeiNomes = new String[veiculos.size()];

                for (int i = 0; i < veiculos.size(); i++) {
                    VeiNomes[i] = veiculos.get(i).getModelo();
                }
                list1.setAdapter(
                        new ArrayAdapter<String>(
                                getApplicationContext(),
                                android.R.layout.simple_list_item_1,
                                VeiNomes
                        )
                );
            }

            @Override
            public void onFailure(Call<List<Veiculo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
