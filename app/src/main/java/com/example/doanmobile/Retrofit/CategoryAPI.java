package com.example.doanmobile.Retrofit;

import com.example.doanmobile.Model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryAPI {
    RetrofitService retrofitservice = new RetrofitService();
    CategoryAPI categoryAPI = retrofitservice.getRetrofit().create(CategoryAPI.class);
    @GET("/category")
    Call<List<Category>> GetAllCategories();
}
