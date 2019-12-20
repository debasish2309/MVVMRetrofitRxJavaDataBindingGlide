package com.example.mvvmretrofitrxjavadatabindingglide.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmretrofitrxjavadatabindingglide.view.model.DataClass;
import com.example.mvvmretrofitrxjavadatabindingglide.view.repository.UserRepository;

import java.util.List;

public class CommentsViewModel extends ViewModel {

    private MutableLiveData<List<DataClass>> mutableLiveData;

    private UserRepository userRepository;

    public void init(String postId){
        if(mutableLiveData != null){
            return;
        }
        userRepository = UserRepository.getInstance();
        mutableLiveData = userRepository.getComments(postId);
    }

    public LiveData<List<DataClass>> getCommentsRepository(){
        return mutableLiveData;
    }
}
