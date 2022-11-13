package com.dr.sofeware.ui.art;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.dr.sofeware.R;
import com.dr.sofeware.databinding.FragmentArtBinding;
import com.dr.sofeware.utils.MathMethod;

import java.util.ArrayList;
import java.util.List;

import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

public class ArtFragment extends Fragment {

    private static final int NUM_PICTURE = 5;
    private static final int PIVTURE_offset = 1;
    private static final String RV_HORIZO_LEFT = "left";
    private static final String RV_HORIZO_RIGHT = "right";
    private static final String PIVTURE_FRONT_NAME = "mix";

    private FragmentArtBinding binding;

    private Integer left_position=0;
    private Integer right_position=0;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentArtBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //TODO:改造为图片资源,图片链接等
        PictureAdapter rvLeftAdapter = new PictureAdapter(NUM_PICTURE,getActivity(),RV_HORIZO_LEFT);
        binding.recyclerLeft.setAdapter(rvLeftAdapter);

        PictureAdapter rvRightAdapter = new PictureAdapter(NUM_PICTURE,getActivity(),RV_HORIZO_RIGHT);
        binding.recyclerRight.setAdapter(rvRightAdapter);

        //ScrollingPagerIndicator recyclerIndicator = binding.indicator;
        //recyclerIndicator.attachToRecyclerView(binding.recyclerLeft);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
    }

    private void initView() {


        binding.recyclerLeft.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                View childViewUnder = binding.recyclerLeft.findChildViewUnder(scrollX, scrollY);
                if (childViewUnder != null) {
                    RecyclerView.ViewHolder childViewHolder = binding.recyclerLeft
                            .getChildViewHolder(childViewUnder);
                    if (childViewHolder != null) {
                        left_position= childViewHolder.getAdapterPosition()+PIVTURE_offset;
                    }
                }
            }
        });

        binding.recyclerRight.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                View childViewUnder = binding.recyclerRight.findChildViewUnder(scrollX, scrollY);
                if (childViewUnder != null) {
                    RecyclerView.ViewHolder childViewHolder = binding.recyclerRight
                            .getChildViewHolder(childViewUnder);
                    if (childViewHolder != null) {
                        right_position= childViewHolder.getAdapterPosition()+PIVTURE_offset;
                    }
                }
            }
        });


        binding.buArtCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=PIVTURE_FRONT_NAME+left_position+right_position;
                int resId = getActivity().getResources().getIdentifier(
                        str, "drawable", getActivity().getPackageName());//通过名字获取ID
                binding.ivCreatePicture.setImageResource(resId);
            }
        });

        binding.buNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).
                        navigate(R.id.action_navigation_art_to_navigation_art_network);
            }
        });



    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}