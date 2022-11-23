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

import com.dr.sofeware.databinding.FragmentMathQuestionsBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jaredrummler.materialspinner.MaterialSpinner;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/**
 * @Description TODO
 * @systemUser admin
 * @Author DR.LKXY
 * @Date 11-08-2022 周二 9:49
 */


//TODO:
// 2.viewmodel数据导入adapter

public class MathQuestionsFragment extends Fragment {

    private static final int tab_show_use=1;

    private FragmentMathQuestionsBinding binding;

    private MathViewModel viewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(MathViewModel.class);
        binding = FragmentMathQuestionsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        //填充数据
        QuestionsTabAdapter questionsTabAdapter = new QuestionsTabAdapter(this, viewModel);
        binding.viewpager.setAdapter(questionsTabAdapter);

        TabLayoutMediator mediator = new TabLayoutMediator(binding.tabLayout, binding.viewpager,
                new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                int a=position+tab_show_use;
                tab.setText(a+"");
            }
        });
        mediator.attach();


        binding.imageivBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).
                        navigate(R.id.action_global_navigation_home);
            }
        });

        //TODO：交卷按钮
        binding.mathUploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).
                        navigate(R.id.action_mathQuestionsFragment_to_mathScoreFragment);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

