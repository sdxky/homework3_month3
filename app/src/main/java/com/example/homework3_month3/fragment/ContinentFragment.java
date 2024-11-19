package com.example.homework3_month3.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.homework3_month3.R;
import com.example.homework3_month3.databinding.FragmentContinentBinding;
import com.example.homework3_month3.adapter.ContinentAdapter;
import java.util.Arrays;
import java.util.List;

public class ContinentFragment extends Fragment {

    private FragmentContinentBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentContinentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ContinentAdapter continentAdapter = new ContinentAdapter(continent -> {
            CountryFragment countryFragment = new CountryFragment();
            Bundle bundle = new Bundle();
            bundle.putString("Continent", continent);
            countryFragment.setArguments(bundle);

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, countryFragment)
                    .addToBackStack(null)
                    .commit();
        });

        binding.rvContinent.setAdapter(continentAdapter);

        List<String> continents = Arrays.asList("Africa", "Eurasia", "North America", "South America", "Australia", "Antarctica");
        continentAdapter.submitList(continents);
    }
}