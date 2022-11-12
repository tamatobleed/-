package com.dr.sofeware.ui.math;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.dr.sofeware.R;
import com.dr.sofeware.databinding.FragmentMathScoreBinding;


/**
 * @Description TODO
 * @systemUser admin
 * @Author DR.LHXY
 * @Date 11-08-2022 周二 16:35
 */
public class MathScoreFragment extends Fragment {

    private FragmentMathScoreBinding binding;

    private MathViewModel viewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(MathViewModel.class);
        binding = FragmentMathScoreBinding.inflate(inflater, container, false);
        binding.rvScore.setAdapter(new MathScoreAdapter(viewModel.getFormuls(),viewModel.getAnswers()));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
    }

    private void initView() {

        binding.tvScore.setText(viewModel.createScore());
        binding.buBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).
                        navigate(R.id.action_global_navigation_home);
            }
        });

        binding.buCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ivCup.setVisibility(View.INVISIBLE);
                binding.rvScore.setVisibility(View.VISIBLE);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
