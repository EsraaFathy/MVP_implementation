package com.example.day2.activitydetails;


import com.example.day2.dataLayer.DataSource;
import com.example.day2.dataLayer.Model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsPresenter implements Presenter{
    View view;
    DataSource dataSource;

    public DetailsPresenter(View view) {
        this.view = view;
        dataSource=new DataSource();
    }

    @Override
    public void loadData(int id) {

        dataSource.getDataModel(id).enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                view.upDataUI(response.body());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                view.showError();
            }
        });
    }
}
