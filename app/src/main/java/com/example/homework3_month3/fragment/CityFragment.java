package com.example.homework3_month3.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.homework3_month3.R;
import com.example.homework3_month3.databinding.FragmentCityBinding;
import com.example.homework3_month3.adapter.CityAdapter;
import java.util.Arrays;
import java.util.List;

public class CityFragment extends Fragment {

    private FragmentCityBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCityBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String country = getArguments() != null ? getArguments().getString("Country") : "Unknown";

        CityAdapter cityAdapter = new CityAdapter(city -> {
            CityDetailFragment cityDetailFragment = new CityDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("City", city);
            cityDetailFragment.setArguments(bundle);

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, cityDetailFragment)
                    .addToBackStack(null)
                    .commit();
        });

        binding.rvCity.setAdapter(cityAdapter);

        List<String> cities = getCitiesByCountry(country);
        cityAdapter.submitList(cities);
    }

    private List<String> getCitiesByCountry(String country) {
        switch (country) {
            case "Nigeria":
                return Arrays.asList("Lagos", "Abuja");
            case "China":
                return Arrays.asList("Beijing", "Shanghai");
            case "Germany":
                return Arrays.asList("Berlin", "Munich");
            // Добавить города
            default:
                return Arrays.asList();
        }
    }
}