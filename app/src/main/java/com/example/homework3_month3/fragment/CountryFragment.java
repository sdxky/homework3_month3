package com.example.homework3_month3.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework3_month3.OnItemClick;
import com.example.homework3_month3.R;
import com.example.homework3_month3.adapter.CountryAdapter;
import com.example.homework3_month3.databinding.FragmentCountryBinding;

import java.util.ArrayList;
import java.util.Objects;


public class CountryFragment extends Fragment implements OnItemClick {
    private FragmentCountryBinding binding;
    private ArrayList<String> countryList = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCountryBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CountryAdapter countryAdapter = new CountryAdapter(countryList, this);
        assert getArguments() != null;
        String continent = getArguments().getString("key1");
        assert continent != null;
        position(continent);
        binding.rvCountry.setAdapter(countryAdapter);

    }
    private void position(String continent) {
        if (Objects.equals(continent, "Eurasia")) {
            countryList.add("Russia");
            countryList.add("Kyrgyzstan");
            countryList.add("China");
        } else if (Objects.equals(continent, "Africa")) {
            countryList.add("Egypt");
            countryList.add("Qatar");
            countryList.add("Nigeria");
        } else if (Objects.equals(continent, "North America")) {
            countryList.add("USA");
            countryList.add("Canada");
            countryList.add("Mexico");
        } else if (Objects.equals(continent, "South America")) {
            countryList.add("Brazil");
            countryList.add("Argentina");
            countryList.add("Peru");
        } else if (Objects.equals(continent, "Australia")) {
            countryList.add("Australia");
        }
    }

    @Override
    public void onClick(int position) {
        Bundle bundle = new Bundle();
        String country = countryList.get(position);
        bundle.putString("key2", country);
        CityFragment cityFragment = new CityFragment();
        cityFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, cityFragment)
                .addToBackStack(null)
                .commit();
    }
}