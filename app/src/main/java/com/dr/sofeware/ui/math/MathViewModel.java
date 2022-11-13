package com.dr.sofeware.ui.math;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.dr.sofeware.utils.MathMethod;

import java.util.ArrayList;

public class MathViewModel extends ViewModel {

    private  MutableLiveData<String> mNum;
    private  MutableLiveData<String> mAvg;
    private  MutableLiveData<String> mMode;

    private  ArrayList<String> formuls;
    private  ArrayList<String> questions;
    private  ArrayList<String> answers;

    private MathMethod mathMethod=new MathMethod();

    public MathViewModel() {
        mNum = new MutableLiveData<String>();
        mAvg = new MutableLiveData<String>();
        mMode = new MutableLiveData<String>();
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

    public ArrayList<String> getFormuls() {
        return formuls;
    }
    public ArrayList<String> getQuestions() {
        return questions;
    }
    public ArrayList<String> getAnswers() {return answers;}

    public void setNum(String num){
        mNum.setValue(num);
    }
    public void setAvg(String avg){
        mAvg.setValue(avg);
    }
    public void setMode(String mode){mMode.setValue(mode);}

    public void createFormuls(){
            formuls= mathMethod.createFormuls(
                    Integer.parseInt(mNum.getValue()),
                    Integer.parseInt(mAvg.getValue()),
                    Integer.parseInt(mMode.getValue()));
            questions=mathMethod.createQuestions(formuls);
            answers=new ArrayList<String>(formuls.size());
        for (int i = 0; i < formuls.size(); i++) {
            answers.add("无回答");
        }

    }

    public String createScore(){
        return mathMethod.checkAnswers(formuls,answers);
    }

    public void uploadAnswer(int position,String answer){
        answers.set(position,answer);
    }

}