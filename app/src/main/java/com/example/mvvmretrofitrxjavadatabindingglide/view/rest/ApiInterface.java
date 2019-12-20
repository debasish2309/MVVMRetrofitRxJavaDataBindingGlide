package com.example.mvvmretrofitrxjavadatabindingglide.view.rest;

import com.example.mvvmretrofitrxjavadatabindingglide.view.model.DataClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("comments")
    Call<List<DataClass>> getComments(@Query("postId") String postId);

}
