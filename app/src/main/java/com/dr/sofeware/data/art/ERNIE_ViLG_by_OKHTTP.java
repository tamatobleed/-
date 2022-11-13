package com.dr.sofeware.data.art;

import android.util.Log;

import com.dr.sofeware.ui.art.ArtNetworkBean;
import com.dr.sofeware.ui.art.TaskBean;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ERNIE_ViLG_by_OKHTTP {
    private static final String ak = "TOoeM9yhT6VsF0jxoiY2DGAuR5aGuiFu";
    private static final String sk = "RhV82hWsHXuqHggRhXr4ZTtZcrEQHCEu";
    private static final String url2 = "https://wenxin.baidu.com/younger/portal/api/rest/1.0/ernievilg/v1/getImg";

    private static final String PAINT_STYLE = "水彩画";
    private static String PAINT_TEXT = "水彩画，二次元";
    public static OkHttpClient client = new OkHttpClient();
    private static String token;
    private static String taskId;


    public static String create_state="";
    public static String imagineUri="";
    public static String response_body="";



    public void drawByERNIE_ViLG(String str) throws IOException, InterruptedException {
        PAINT_TEXT=str;
        initToken(ak, sk);
    }

    private  void initToken(String ak, String sk) throws IOException {
        String tokenUrl = "https://wenxin.baidu.com/younger/portal/api/oauth/token";

        OkHttpClient client = new OkHttpClient();
        FormBody formBody = new FormBody.Builder().
                add("grant_type", "client_credentials").
                add("client_id", ak).
                add("client_secret", sk)
                .build();
        Request request = new Request.Builder().
                url(tokenUrl).
                post(formBody).
                build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println("initToken++++++failure");
            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()){
                    token = response.body().string();
                    submitRequest(PAINT_TEXT, PAINT_STYLE);
                }
            }
        });
    }

    private void queryResult() throws IOException, InterruptedException {

        FormBody formBody2 = new FormBody.Builder()
                .add("access_token", token)
                .add("taskId", taskId)
                .build();
        Request request2 = new Request.Builder().url(url2).post(formBody2).build();
            Call call = client.newCall(request2);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    System.out.println("EqueryResult.........");
                }
                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    if (response.isSuccessful()) {
                        response_body=response.body().string();
                        System.out.println("EqueryResult........."+response_body);
                    }
                    if(response_body.contains("status\":1")){
                        Gson gson = new Gson();
                        ArtNetworkBean artNetworkBean = gson.fromJson(response_body, ArtNetworkBean.class);
                        System.out.println("EqueryResult........."+artNetworkBean.getData().getImg());
                        create_state="生成状态："+artNetworkBean.getMsg()+"  生成所需时间："+ artNetworkBean.getData().getWaiting();
                        imagineUri=artNetworkBean.getData().getImg();
                    }else{
                        try {
                            Thread.sleep(5000);
                            queryResult();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            });



    }

    private  void submitRequest(String text, String style) throws IOException {
        String url1 = "https://wenxin.baidu.com/younger/portal/api/rest/1.0/ernievilg/v1/txt2img";
        FormBody formBody1 = new FormBody.Builder().
                add("access_token", token)
                .add("text", text).
                add("style", style)
                .build();
        Request request1 = new Request.Builder().
                url(url1).post(formBody1).
                build();
        Call call = client.newCall(request1);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println("submitRequest++++++failure");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String str=  response.body().string();
                System.out.println("submitRequest++++++"+str);
                if (response.isSuccessful()&&str.contains("taskId")){

                    Gson gson = new Gson();
                    TaskBean taskBean = gson.fromJson(str, TaskBean.class);
                    taskId=Integer.toString(taskBean.getData().getTaskId());

                    try {
                        queryResult();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                };
            }
        });





    }




}
