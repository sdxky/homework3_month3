package com.example.homework3_month3.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework3_month3.adapter.CityAdapter;
import com.example.homework3_month3.databinding.FragmentCityBinding;

import java.util.ArrayList;
import java.util.Objects;

public class CityFragment extends Fragment {
    private FragmentCityBinding binding;
    private ArrayList<String> cityList = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCityBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CityAdapter cityAdapter = new CityAdapter(cityList, position -> {
            // Действия при клике на город
        });

        assert getArguments() != null;
        String country = getArguments().getString("key2");
        assert country != null;

        loadCities(country);
        binding.rvCity.setAdapter(cityAdapter);
    }

    private void loadCities(String country) {
        if (Objects.equals(country, "Russia")) {
            cityList.add("Moscow");
            cityList.add("Saint Petersbur");
            cityList.add("Novosibirsk");
        } else if (Objects.equals(country, "Kyrgyzstan")) {
            cityList.add("Bishkek");
            cityList.add("Osh");
            cityList.add("Batken");
        } else if (Objects.equals(country, "China")) {
            cityList.add("Beijing");
            cityList.add("Shanghai");
            cityList.add("Guangzhou");
        } else if (Objects.equals(country, "Egypt")) {
            cityList.add("Cairo");
            cityList.add("Alexandria");
            cityList.add("Giza");
        } else if (Objects.equals(country, "Qatar")) {
            cityList.add("Doha");
            cityList.add("Al Rayyan");
            cityList.add("Lusail");
        } else if (Objects.equals(country, "Nigeria")) {
            cityList.add("Lagos");
            cityList.add("Kano");
            cityList.add("Ibadan");
        } else if (Objects.equals(country, "USA")) {
            cityList.add("New York City");
            cityList.add("Los Angeles");
            cityList.add("Chicago");
        } else if (Objects.equals(country, "Canada")) {
            cityList.add("New York City");
            cityList.add("Los Angeles");
            cityList.add("Chicago");
        } else if (Objects.equals(country, "Mexico")) {
            cityList.add("Toronto");
            cityList.add("Montreal");
            cityList.add("Calgary");
        } else if (Objects.equals(country, "Brazil")) {
            cityList.add("São Paulo");
            cityList.add("Rio de Janeiro");
            cityList.add("Brasília");
        } else if (Objects.equals(country, "Argentina")) {
            cityList.add("Buenos Aires");
            cityList.add("Córdoba");
            cityList.add("Rosario");
        } else if (Objects.equals(country, "Peru")) {
            cityList.add("Lima");
            cityList.add("Arequipa");
            cityList.add("Trujillo");
        } else if (Objects.equals(country, "Australia")) {
            cityList.add("Sydney");
            cityList.add("Melbourne");
            cityList.add("Brisbane");
        }
    }
}