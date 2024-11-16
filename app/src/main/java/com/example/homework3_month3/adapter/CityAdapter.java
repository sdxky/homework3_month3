package com.example.homework3_month3.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework3_month3.OnItemClick;
import com.example.homework3_month3.databinding.ItemCityBinding;

import java.util.ArrayList;

public class CityAdapter extends RecyclerView.Adapter<CityViewHolder> {

    private ArrayList<String> cityList;
    private OnItemClick onItemClick;

    public CityAdapter(ArrayList<String> cityList, OnItemClick onItemClick) {
        this.cityList = cityList;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CityViewHolder(ItemCityBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        holder.onBind(cityList.get(position));
        holder.itemView.setOnClickListener(v -> onItemClick.onClick(position));
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }
}

class CityViewHolder extends RecyclerView.ViewHolder {

    private ItemCityBinding binding;

    public CityViewHolder(@NonNull ItemCityBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(String city) {
        binding.tvCity.setText(city);
    }
}