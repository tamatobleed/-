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
import com.dr.sofeware.databinding.FragmentMathBinding;
import com.dr.sofeware.databinding.FragmentMathQuestionPageBinding;
import com.jaredrummler.materialspinner.MaterialSpinner;

/**
 * @Description TODO
 * @systemUser admin
 * @Author DR.LHXY
 * @Date 11-08-2022 周二 22:06
 */

//TODO:上传答案时
public class MathPageFragment extends Fragment {
    public static final String ARG_OBJECT = "object";

    private FragmentMathQuestionPageBinding binding;

    private MathViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(MathViewModel.class);
        binding = FragmentMathQuestionPageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
        Bundle args = getArguments();
        ((TextView) view.findViewById(android.R.id.text1))
                .setText(Integer.toString(args.getInt(ARG_OBJECT)));
    }

    private void initView() {
        binding.edAnswer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
