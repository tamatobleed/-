package com.dr.sofeware.ui.math;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dr.sofeware.R;
import com.dr.sofeware.databinding.FragmentMathBinding;
import com.jaredrummler.materialspinner.MaterialSpinner;


public class MathFragment extends Fragment {

    private FragmentMathBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MathViewModel dashboardViewModel =
                new ViewModelProvider(this).get(MathViewModel.class);

        binding = FragmentMathBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        MaterialSpinner spinner =  binding.spinner;
        spinner.setItems("加减运算", "乘除运算", "四则运算");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
            }
        });

        final TextView textView = binding.textMath;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}