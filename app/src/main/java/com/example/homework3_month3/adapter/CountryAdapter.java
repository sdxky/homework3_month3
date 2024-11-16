package com.example.homework3_month3.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework3_month3.OnItemClick;
import com.example.homework3_month3.databinding.ItemCountryBinding;

import java.util.ArrayList;


public class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    private ArrayList<String> countryList;
    private OnItemClick onItemClick;

    public CountryAdapter(ArrayList<String> countryList, OnItemClick onClick) {
        this.countryList = countryList;
        this.onItemClick = onClick;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CountryViewHolder(ItemCountryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)) ;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.onBind(countryList.get(position));
        holder.itemView.setOnClickListener(v -> {
            onItemClick.onClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }
}
class CountryViewHolder extends RecyclerView.ViewHolder {
    private ItemCountryBinding binding;
    public CountryViewHolder(@NonNull ItemCountryBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
    public void onBind(String country){
        binding.tvCountry.setText(country);
    }
}