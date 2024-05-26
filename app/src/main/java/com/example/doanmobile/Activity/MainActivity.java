package com.example.doanmobile.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.doanmobile.Adapter.CategoryAdapter;
import com.example.doanmobile.Model.Category;
import com.example.doanmobile.R;
import com.example.doanmobile.Retrofit.CategoryAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewCategoryList;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Activity onCreate");

        loadCategories(); // Đã thay đổi tên phương thức để tuân thủ theo quy tắc đặt tên

    }

    private void loadCategories() { // Đã thay đổi tên phương thức để tuân thủ theo quy tắc đặt tên
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.view1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);
        CategoryAPI.categoryAPI.GetAllCategories().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful()) {
                    List<Category> categoriesList = response.body();
                    // In ra log của danh sách nhận được
                    if (categoriesList != null) {
                        for (Category category : categoriesList) {
                            Log.d("CategoryList", "Category: " + category.toString());
                        }
                        // Tiếp tục xử lý dữ liệu nhận được
                        adapter = new CategoryAdapter(categoriesList, MainActivity.this);
                        recyclerViewCategoryList.setAdapter(adapter);
                    } else {
                        Log.e("LoadCategories", "Category list is null");
                    }
                } else {
                    Log.e("LoadCategories", "Response not successful. Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.e("LoadCategories", "Failed to fetch categories: " + t.getMessage());
                t.printStackTrace(); // In ra stack trace để xem lỗi cụ thể
            }
        });
    }
}
