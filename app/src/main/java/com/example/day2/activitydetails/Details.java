package com.example.day2.activitydetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.day2.dataLayer.Model;
import com.example.day2.R;

public class Details extends AppCompatActivity implements View {

    TextView idAPI,userId,title;
    CheckBox checkBox;
    Presenter presenter;
    ProgressBar progressBar;
    int id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        idAPI=findViewById(R.id.id);
        userId=findViewById(R.id.userId);
        title=findViewById(R.id.title);
        checkBox=findViewById(R.id.checkBox2);
        progressBar=findViewById(R.id.progressBar2);

        id= getIntent().getIntExtra("ID",0);
        if (savedInstanceState==null)
        presenter=new DetailsPresenter(this);
        if (id!=0)
            presenter.loadData(id);
    }


    @Override
    public void upDataUI(Model models) {
        idAPI.setText("id = "+models.getId().toString());
        userId.setText("user id = "+models.getUserId().toString());
        title.setText("title = "+models.getTitle().toString());
        checkBox.setChecked(models.getCompleted());
        progressBar.setVisibility(android.view.View.INVISIBLE);

    }

    @Override
    public void showError() {

    }
}