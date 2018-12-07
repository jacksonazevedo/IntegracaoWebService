package com.jacksonazevedo.concessionaria;

import com.jacksonazevedo.concessionaria.model.Setor;
import com.jacksonazevedo.concessionaria.model.Veiculo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "http://jacksonazevedo.xyz/backend/";

    @GET("setor")
    Call<List<Setor>> getSetor();

    @GET("Veiculo")
    Call<List<Veiculo>> getVeiculo();


}
