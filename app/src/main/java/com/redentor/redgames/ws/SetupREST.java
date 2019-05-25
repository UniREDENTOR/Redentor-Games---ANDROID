package com.redentor.redgames.ws;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SetupREST {

    public static final ApiREST apiREST;


    static {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();











        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://henriquetatagiba.localhost.run/api/")
            .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

         apiREST = retrofit.create(ApiREST.class);


    }




}
