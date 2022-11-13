package com.dr.sofeware.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.dr.sofeware.R;
import com.dr.sofeware.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Random;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private int question_now=0;
    private int prom=1;

    private final String[] questions={"不是狐，不是狗，前面架铡刀，后面拖扫帚",
            "一种肉食动物","许多童话里的大反派","狼","有位小姑娘，身穿黄衣裳。谁要欺负她，她就戳一枪",
            "是一种群居动物","以勤劳著称","蜜蜂","角黍头，梅花脚，屁股挂把批示刀，坐着反比立着高",
            "是人类的好朋友","高兴时会摇尾巴","狗","年纪并不大，胡子一大把，不论遇见谁，总爱喊妈妈",
            "有一部以它为主角的动画片","十二生肖中有它","羊","坐也是行，立也是行，行也是行，卧也是行",
            "住在水里","没手也没脚","鱼"};



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        Random random = new Random();
        question_now = random.nextInt(4);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int temp=question_now*4;
        binding.tvQuestion.setText(questions[temp]);

        binding.ivPrompt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),questions[temp+prom],Toast.LENGTH_SHORT).show();
                prom++;
                if(prom==4)prom=1;
            }
        });

        binding.buCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),questions[temp+3],Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}