package com.dr.sofeware.ui.math;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.Objects;

public class MathViewModel extends ViewModel {
    private final MutableLiveData<String> mNum;
    private final MutableLiveData<String> mAvg;
    private final MutableLiveData<String> mMode;

    MathUtils mathUtils=new MathUtils();

    ArrayList<String> Formuls;

    public MathViewModel() {
        mNum = new MutableLiveData<>();
        mAvg = new MutableLiveData<>();
        mMode = new MutableLiveData<>();
        mNum.setValue("0");
        mAvg.setValue("0");
        mMode.setValue("0");
    }

    public LiveData<String> getNum() {
        return mNum;
    }
    public LiveData<String> getAvg() {
        return mAvg;
    }
    public LiveData<String> getMode() {
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

    public boolean createFormuls(){
        if(Objects.equals(mNum.getValue(), "0") || Objects.equals(mAvg.getValue(), "0")){
            return false;
        }else{
            Formuls=mathUtils.createFormuls(
                    Integer.getInteger(Objects.requireNonNull(mNum.getValue())),
                    Integer.getInteger(Objects.requireNonNull(mAvg.getValue())),
                    Integer.getInteger(Objects.requireNonNull(mMode.getValue())));
            return true;
        }
    }

}