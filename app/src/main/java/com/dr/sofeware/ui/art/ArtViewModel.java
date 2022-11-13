package com.dr.sofeware.ui.art;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dr.sofeware.data.art.ERNIE_ViLG_by_OKHTTP;

import java.io.IOException;

public class ArtViewModel extends ViewModel {

    private MutableLiveData<String> mImagineUrl;
    private MutableLiveData<String> create_state;
    private ERNIE_ViLG_by_OKHTTP ernie;

    public ArtViewModel() {
        mImagineUrl=new MutableLiveData<String>();
        mImagineUrl.setValue("0");
        create_state=new MutableLiveData<String>();
        create_state.setValue("0");
        ernie=new ERNIE_ViLG_by_OKHTTP();
    }

    public LiveData<String> getImagineUrl() {
        return mImagineUrl;
    }
    public LiveData<String> getCreateState() {return create_state;}

    public void startNewWork(String description) throws IOException, InterruptedException {
        ernie.drawByERNIE_ViLG(description);
        while(true){
            create_state.setValue(ERNIE_ViLG_by_OKHTTP.create_state);
            if(ERNIE_ViLG_by_OKHTTP.create_state.contains("success")){
                mImagineUrl.setValue(ERNIE_ViLG_by_OKHTTP.imagineUri);
                break;
            }
        }
    }
}