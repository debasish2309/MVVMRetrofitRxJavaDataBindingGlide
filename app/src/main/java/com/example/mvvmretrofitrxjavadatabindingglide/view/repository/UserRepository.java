package com.example.mvvmretrofitrxjavadatabindingglide.view.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmretrofitrxjavadatabindingglide.view.model.DataClass;
import com.example.mvvmretrofitrxjavadatabindingglide.view.rest.ApiClient;
import com.example.mvvmretrofitrxjavadatabindingglide.view.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private static UserRepository userRepository;

    public static UserRepository getInstance(){
        if(userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    private ApiInterface apiInterface;

    public UserRepository() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public MutableLiveData<List<DataClass>> getComments(String postId){
        final MutableLiveData<List<DataClass>> commentData = new MutableLiveData<>();
        apiInterface.getComments(postId).enqueue(new Callback<List<DataClass>>() {
            @Override
            public void onResponse(Call<List<DataClass>> call, Response<List<DataClass>> response) {
                commentData.setValue(response.body());
                Log.d("!!!responsebody",response.body().toString());
            }

            @Override
            public void onFailure(Call<List<DataClass>> call, Throwable t) {
                Log.e("!!!",t.getMessage());
                commentData.setValue(null);
            }
        });
        return commentData;
    }
}
