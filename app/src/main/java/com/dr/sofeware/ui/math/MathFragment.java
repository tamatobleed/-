package com.dr.sofeware.ui.math;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.dr.sofeware.R;
import com.dr.sofeware.databinding.FragmentMathBinding;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.Objects;

//TODO：MATH
// 1，导航图添加转跳至做题界面 ✓，viewModel传输数据✓；
// 2，做题界面tablayout的运行 ；
// 3，做题界面交卷，显示结算界面 ✓；
// 4，结算界面点击查看题目按钮，转调至题目查看界面；
// 5，题目查看界面点击返回按钮，返回初始页面

//TODO：ART
// 1.将图片资源存储在APP中
// 问题不大，可以直接放在资源文件
// 2.根据用户两个滚动器选择的图片数组的序号，确定对应的生成图片；
// 写一下函数 Integer micPicture*(Integer position1,Integer position2)
// 难的不在于函数，而在于与图片资源的组织协调。几号图片加几号图片，等于几号图片
// 3.在控件Interview上显示对应图片
// 可以忽略，不要求其他人完成


//TODO：提高
// 使用Glide/Fresco/Picasso加载生成图片，使用android-gif-drawable开源库运行git图资源
// 图像联网生成，使用DWCorePhoto_Android开源库提供放大查看功能
// 完善首页设计
// 自动回复模块



public class MathFragment extends Fragment  {

    private FragmentMathBinding binding;

    private MathViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(MathViewModel.class);
        binding = FragmentMathBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        MaterialSpinner spinner =  binding.spinner;
        spinner.setItems("加减运算", "乘除运算", "四则运算");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
            }
        });

        binding.edNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                viewModel.setNum(s.toString());
            }
        });

        binding.edAvg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                viewModel.setAvg(s.toString());
            }
        });

        binding.spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                viewModel.setMode(String.valueOf(position));
            }
        });

        binding.mathBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Objects.equals(binding.edNum.getText().toString(), "0") &&
                        !Objects.equals(binding.edNum.getText().toString(), "")&&
                        !Objects.equals(binding.edAvg.getText().toString(), "")&&
                        !Objects.equals(binding.edAvg.getText().toString(), "")){
                    Navigation.findNavController(v).
                            navigate(R.id.action_navigation_math_to_mathQuestionsFragment);
                }

            }
        });

        binding.imageivBackHome.setOnClickListener(new View.OnClickListener() {
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

