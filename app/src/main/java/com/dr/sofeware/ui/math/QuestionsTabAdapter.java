package com.dr.sofeware.ui.math;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * @Description TODO
 * @systemUser admin
 * @Author
 * @Date 11-08-2022 周二 21:54
 */
public class QuestionsTabAdapter extends FragmentStateAdapter {

    public QuestionsTabAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new MathPageFragment();
        Bundle args = new Bundle();
        args.putInt(MathPageFragment.ARG_OBJECT, position + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 100;
    }
}