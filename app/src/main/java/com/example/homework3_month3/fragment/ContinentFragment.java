package com.example.homework3_month3.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.homework3_month3.OnItemClick;
import com.example.homework3_month3.R;
import com.example.homework3_month3.adapter.ContinentAdapter;
import com.example.homework3_month3.databinding.FragmentContinentBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContinentFragment extends Fragment implements OnItemClick {

    private FragmentContinentBinding binding;
    private ContinentAdapter continentAdapter;


    private ArrayList<String> countryList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContinentBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        continentAdapter = new ContinentAdapter(countryList, this);
        binding.rvContinent.setAdapter(continentAdapter);

        loadData();
    }

    private void loadData() {
        countryList.add("Eurasia");
        countryList.add("Africa");
        countryList.add("North America");
        countryList.add("South America");
        countryList.add("Australia");
    }


    @Override
    public void onClick(int position) {
        Bundle bundle = new Bundle();
        String continent = countryList.get(position);
        bundle.putString("key1", continent);
        CountryFragment secondFragment = new CountryFragment();
        secondFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, secondFragment).addToBackStack(null).commit();
    }
}