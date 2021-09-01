package com.example.restuapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.DishesViewHolder> {
    List<Dishes> allDishes=new ArrayList<Dishes>();
    Context context;

    public MenuAdapter(List<Dishes> allDishes,Context context) {
        this.allDishes = allDishes;
        this.context=context;
    }

    public static class DishesViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        public Dishes dishes;
        ConstraintLayout mainLayout;

        public DishesViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;
            mainLayout=itemView.findViewById(R.id.mainLayout);
        }
    }

    @NonNull
    @Override
    public DishesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_menu,parent,false);
        DishesViewHolder dishesViewHolder=new DishesViewHolder(view);
        return dishesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DishesViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.dishes=allDishes.get(position);
        TextView textname=holder.itemView.findViewById(R.id.dishesNameView);
        textname.setText(holder.dishes.dishesName);
        TextView textPrice=holder.itemView.findViewById(R.id.dishesPriceView);
        textPrice.setText(Integer.toString(holder.dishes.dishesPrice));
        TextView textIng=holder.itemView.findViewById(R.id.dishesIngView);
        textIng.setText(holder.dishes.dishesIng);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,DishesDetailes.class);
                intent.putExtra("dishesName",allDishes.get(position).getDishesName());
                intent.putExtra("dishesPrice",allDishes.get(position).getDishesPrice());
                intent.putExtra("dishesIng",allDishes.get(position).getDishesIng());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allDishes.size();
    }
}
