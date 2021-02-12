package com.example.day2.activityone.view;

import com.example.day2.dataLayer.Model;

import java.util.List;

public interface View {
    void upDataUI(List<Model> models);
    void showError();
    void navigate(int id);
}
