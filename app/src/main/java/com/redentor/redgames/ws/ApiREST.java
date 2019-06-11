package com.redentor.redgames.ws;

import com.google.gson.JsonObject;
import com.redentor.redgames.model.Equipe;
import com.redentor.redgames.model.Event;
import com.redentor.redgames.model.GameDescription;
import com.redentor.redgames.model.Note;
import com.redentor.redgames.model.Photo;
import com.redentor.redgames.model.Rank;
import com.redentor.redgames.model.TeamsVotations;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
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
    @GET("teams")
    Call<List<Equipe>> listEquipe();




    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @GET("ranking")
    Call<List<Rank>> listRank();


    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @GET("events")
    Call<List<Event>> listEvent();

    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @GET("events/{id}")
    Call<List<TeamsVotations>> listTeamVotations(@Path("id") int idevent);


    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
        })


    @POST("events/{id}/{team_id}")
            Call<Note> note(@Path("id") int idevent, @Path("team_id") int idteam, @Body Note note);














    //ranking
    //events









}
