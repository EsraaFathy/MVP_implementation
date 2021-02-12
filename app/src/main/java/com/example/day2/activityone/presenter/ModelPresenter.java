package com.example.day2.activityone.presenter;

import android.util.Log;

import com.example.day2.dataLayer.DataSource;
import com.example.day2.activityone.view.View;
import com.example.day2.dataLayer.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelPresenter implements Presenter,OnItemClickListener{
    View view;
    DataSource dataSourc;

    public ModelPresenter(View view) {
        this.view=view;
        Log.d("TAG","constracror");
        dataSourc=new DataSource();

    }

    public void LoadData(){
        Log.d("TAG", "LoadData: ");

        dataSourc.getData().enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                Log.d("TAG", "onResponse: ");
                    view.upDataUI(response.body());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                view.showError();
            }
        });
    }


    @Override
    public void onClickListener(int id) {
        view.navigate(id);
    }
}
