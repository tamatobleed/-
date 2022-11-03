package com.dr.sofeware.ui.math;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dr.sofeware.databinding.FragmentMathBinding;


public class MathFragment extends Fragment {

    private FragmentMathBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MathViewModel dashboardViewModel =
                new ViewModelProvider(this).get(MathViewModel.class);

        binding = FragmentMathBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

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