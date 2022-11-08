package com.dr.sofeware.ui.art;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.dr.sofeware.databinding.FragmentArtBinding;

import java.util.ArrayList;
import java.util.List;

import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

public class ArtFragment extends Fragment {

    private static final int NUM_PICTURE = 5;

    private FragmentArtBinding binding;

    protected RecyclerView.LayoutManager mLayoutManager;

    private RecyclerView recyclerView_left;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ArtViewModel notificationsViewModel =
                new ViewModelProvider(this).get(ArtViewModel.class);

        binding = FragmentArtBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView_left = binding.recyclerLeft;
        recyclerView_left.setLayoutManager(mLayoutManager);

        //TODO:改造为图片资源,图片链接等
        PictureAdapter recyclerAdapter = new PictureAdapter(new ArrayList<String>());
        recyclerView_left.setAdapter(recyclerAdapter);

        ScrollingPagerIndicator recyclerIndicator = binding.indicator;
        recyclerIndicator.attachToRecyclerView(recyclerView_left);

        return root;
    }






    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}