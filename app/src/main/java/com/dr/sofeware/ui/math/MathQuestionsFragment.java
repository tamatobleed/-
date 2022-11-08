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
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.dr.sofeware.R;
import com.dr.sofeware.databinding.FragmentMathBinding;
import com.dr.sofeware.databinding.FragmentMathQuestionsBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jaredrummler.materialspinner.MaterialSpinner;

import org.jetbrains.annotations.NotNull;

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

    private FragmentMathQuestionsBinding binding;

    private QuestionsTabAdapter questionsTabAdapter;

    private MathViewModel viewModel;

    private ViewPager2 viewPager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(MathViewModel.class);
        binding = FragmentMathQuestionsBinding.inflate(inflater, container, false);
        viewPager = binding.viewpager;
        viewModel.createFormuls();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        questionsTabAdapter = new QuestionsTabAdapter(this);

        viewPager.setAdapter(questionsTabAdapter);
        TabLayout tabLayout = binding.tabLayout;

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText("OBJECT " + (position + 1))
        ).attach();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

