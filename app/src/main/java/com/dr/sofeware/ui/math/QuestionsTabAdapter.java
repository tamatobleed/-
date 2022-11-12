package com.dr.sofeware.ui.math;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

/**
 * @Description TODO
 * @systemUser admin
 * @Author
 * @Date 11-08-2022 周二 21:54
 */
public class QuestionsTabAdapter extends FragmentStateAdapter {

    private final MathViewModel viewModel;

    public QuestionsTabAdapter(Fragment fragment, MathViewModel viewModel) {
        super(fragment);
        this.viewModel=viewModel;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new MathPageFragment(position,viewModel);
    }

    @Override
    public int getItemCount() {
        return viewModel.getFormuls().size();
    }


}