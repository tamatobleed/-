package com.dr.sofeware.ui.math;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.dr.sofeware.R;

import com.dr.sofeware.databinding.FragmentMathQuestionPageBinding;
import com.jaredrummler.materialspinner.MaterialSpinner;

/**
 * @Description TODO
 * @systemUser admin
 * @Author DR.LHXY
 * @Date 11-08-2022 周二 22:06
 */
public class MathPageFragment extends Fragment {

    private FragmentMathQuestionPageBinding binding;

    private MathViewModel viewModel;

    private final int position;

    public MathPageFragment(int position,MathViewModel viewModel){
        this.position=position;
        this.viewModel=viewModel;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMathQuestionPageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        binding.tvQuestion.setText(viewModel.getQuestions().get(position));

        binding.edAnswer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                viewModel.uploadAnswer(position,s.toString());
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
