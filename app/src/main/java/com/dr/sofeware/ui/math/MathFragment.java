package com.dr.sofeware.ui.math;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.dr.sofeware.R;
import com.dr.sofeware.databinding.FragmentMathBinding;
import com.dr.sofeware.utils.MathMethod;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.Objects;

//TODO：MATH
// 1，导航图添加转跳至做题界面 ✓，viewModel传输数据✓；
// 2，做题界面tablayout的运行 ✓；
// 3，做题界面交卷，显示结算界面 ✓；
// 4，结算界面点击查看题目按钮，转调至题目查看界面；✓
// 5，题目查看界面点击返回按钮，返回初始页面；✓

//TODO：附加
// APP加载页 ✓


//TODO：ART
// 0.获得png图片资源，5*5=25，共计35张，从emojimix里选择有趣的；✓
// 1.将图片资源存储在APP中 ；✓
// 1.1 构建art的fragment，使得双滚轮可以正常使用；✓
// 问题不大，可以直接放在资源文件drawable；✓
// 2.根据用户两个滚动器选择的图片数组的序号，确定对应的生成图片地址；；✓
// 函数 String micPicture(int position_left,int position_right)；✓




//TODO：提高
// 1.图像联网生成;50✓
// 1.1底部栏图标；✓
// 使用okhttp下载图片的实现类；✓
// 1.2viewmodel的mvvm模型完善
// 2.完善首页设计
// ui设计，添加做题历史之类的
// 3.自动回复模块

// 新的ui页面
// 使用Glide/Fresco/Picasso加载生成图片。



public class MathFragment extends Fragment  {

    private FragmentMathBinding binding;

    private MathViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(MathViewModel.class);
        binding = FragmentMathBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
    }

    private void initView() {

        binding.spinner.setItems("加减运算", "乘除运算", "四则运算");
        binding.spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                viewModel.setMode(String.valueOf(position));
            }
        });



        binding.mathBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.edNum.getText().length()>0 && binding.edAvg.getText().length()>0){
                    if(MathMethod.isInteger(binding.edNum.getText().toString())
                            && MathMethod.isInteger(binding.edAvg.getText().toString())
                    ){
                        viewModel.setNum(binding.edNum.getText().toString());
                        viewModel.setAvg(binding.edAvg.getText().toString());
                        viewModel.createFormuls();
                        Navigation.findNavController(v).
                                navigate(R.id.action_navigation_math_to_mathQuestionsFragment);
                    }else{
                        Toast.makeText(getActivity(), "参数格式错误，生成算式失败", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "参数填写不全", Toast.LENGTH_SHORT).show();
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

