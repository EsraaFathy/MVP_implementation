package com.example.day2.activityone.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day2.activityone.presenter.ModelPresenter;
import com.example.day2.activityone.presenter.OnItemClickListener;
import com.example.day2.activityone.presenter.Presenter;
import com.example.day2.activitydetails.Details;
import com.example.day2.dataLayer.Model;
import com.example.day2.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View {

    Presenter presenter;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState== null)
            presenter = new ModelPresenter(this);
        recyclerView=findViewById(R.id.recyclerView);
        progressBar=findViewById(R.id.progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        Log.d("TAG", "onCreate: ");
        presenter.LoadData();

    }


    @Override
    public void upDataUI(List<Model> models) {
        Log.d("TAG", "upDataUI: ");
        adapter=new Adapter(models,(OnItemClickListener) presenter);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(android.view.View.INVISIBLE);


    }

    @Override
    public void showError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void navigate(int id) {
        Intent intent=new Intent(MainActivity.this, Details.class);
        intent.putExtra("ID",id);
        startActivity(intent);
    }

}