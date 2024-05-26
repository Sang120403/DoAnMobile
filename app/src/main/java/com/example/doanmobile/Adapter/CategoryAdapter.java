package com.example.doanmobile.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.doanmobile.Model.Category;
import com.example.doanmobile.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHodelder> {

    List<Category> categories;
    Context context;

    public CategoryAdapter(List<Category> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHodelder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new MyViewHodelder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodelder holder, int position) {
        String id= String.valueOf(categories.get(position).getId());
        Category category = categories.get(position);
        holder.tencategory.setText(categories.get(position).getCategory_Name());
        Glide.with(context)
                .load(categories.get(position).getCategory_Image())
                .into(holder.hinhcategory);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent = new Intent(holder.itemView.getContext(), LoginActivity.class);
////                intent.putExtra("object", category);
////                holder.itemView.getContext().startActivity(intent);
////                Toast.makeText(context.getApplicationContext(), "Bạn đã chọn "+ category.getCategory_Name(), Toast.LENGTH_SHORT).show();
////                Log.e("0000", category.toString());
//                Intent intent = new Intent(context, ProductsActivity.class);
//                intent.putExtra("category", category);
//                holder.itemView.getContext().startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }


    public class MyViewHodelder extends RecyclerView.ViewHolder
    {
        TextView tencategory;
        ImageView hinhcategory;
        ConstraintLayout mainlayout;

        public MyViewHodelder(@NonNull View itemView) {
            super(itemView);
            tencategory = itemView.findViewById(R.id.categoryName);
            hinhcategory = itemView.findViewById(R.id.categoryPic);
            mainlayout = itemView.findViewById(R.id.constrainLayout);
        }
    }


}
