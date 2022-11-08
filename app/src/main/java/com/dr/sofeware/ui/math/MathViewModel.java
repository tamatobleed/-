package com.dr.sofeware.ui.math;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;

public class MathViewModel extends ViewModel {
//TODO:正整数
    private final MutableLiveData<String> mNum;
    private final MutableLiveData<String> mAvg;
    private final MutableLiveData<String> mMode;

    MathUtils mathUtils=new MathUtils();

    ArrayList<String> Formuls;

    public MathViewModel() {
        mNum = new MutableLiveData<>();
        mAvg = new MutableLiveData<>();
        mMode = new MutableLiveData<>();
    }

    public LiveData<String> getNum() {
        if (mNum.getValue() == null){
            mNum.setValue("0");
        }
        return mNum;
    }
    public LiveData<String> getAvg() {
        if (mNum.getValue() == null){
            mNum.setValue("0");
        }
        return mAvg;
    }
    public LiveData<String> getMode() {
        if (mNum.getValue() == null){
            mNum.setValue("0");
        }
        return mMode;
    }


    public void setNum(String num){
        mNum.setValue(num);
    }
    public void setAvg(String avg){
        mAvg.setValue(avg);
    }
    public void setMode(String mode){
        mMode.setValue(mode);
    }

}