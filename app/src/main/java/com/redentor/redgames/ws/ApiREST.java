package com.redentor.redgames.ws;

import com.redentor.redgames.model.Equipe;
import com.redentor.redgames.model.GameDescription;
import com.redentor.redgames.model.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiREST {

    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @GET("photos")
    Call<List<Photo>> listPhotos();


    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @GET("days/{id}")
    Call<List<GameDescription>> listGameDescription(@Path("id") int idgame);

    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @GET("days/{id}")
    Call<List<Equipe>> listEquipe(@Path("id") int idgame);






}
