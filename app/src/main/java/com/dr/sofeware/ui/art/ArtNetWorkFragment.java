package com.dr.sofeware.ui.art;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;


import com.bumptech.glide.Glide;

import com.dr.sofeware.R;
import com.dr.sofeware.databinding.FragmentArtNetworkBinding;


import java.io.IOException;

/**
 * @Description TODO
 * @systemUser admin
 * @Author DR.LHXY
 * @Date 11-13-2022 周日 15:50
 */
public class ArtNetWorkFragment extends Fragment {

    private FragmentArtNetworkBinding binding;
    private ArtViewModel artViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        artViewModel = new ViewModelProvider(requireActivity()).get(ArtViewModel.class);
        binding = FragmentArtNetworkBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
    }

    private void initView() {



        artViewModel.getImagineUrl().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Glide.with(getActivity())
                        .load(s)//图片url
                        .placeholder(R.drawable.cup)  //占位符,在加载图片完成之前显示的图片
                        .error(R.drawable.cup) //加载失败时显示的图片
                        .fitCenter() //当图片长宽大于ImageView时,缩放图片
                        .fallback(R.drawable.cup) //图片url为Null时显示的图片
                        .into(binding.ivCreatePicture); // 放入到ImageView中
            }
        });

        binding.buArtCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"开始生成，平均耗时1分钟",Toast.LENGTH_LONG).show();
                try {
                    artViewModel.startNewWork(binding.edDescription.getText().toString());
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        binding.ivBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).
                        navigate(R.id.action_global_navigation_home);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}
