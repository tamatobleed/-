package com.dr.sofeware.ui.art;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.dr.sofeware.R;


public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder> {

    private final int NUM_PICTURE;
    private final Context mContext;
    private final String HORIZON_POS;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView iv_picture;


        public ViewHolder(View view) {
            super(view);
            iv_picture = (ImageView) view.findViewById(R.id.iv_origin_picture);
        }
        public ImageView getIvPicture() {
            return iv_picture;
        }
    }

    //TODO:改造为图片资源
    //TODO：改造为获得一个图片组
    public PictureAdapter(int NUM_PICTURE, Context context,String hORIZON_POS) {
        this.mContext=context;
        this.NUM_PICTURE = NUM_PICTURE;
        this.HORIZON_POS=hORIZON_POS;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_art_origin_picture, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        int temp=position+1;
        String str=HORIZON_POS+temp;
        int resId = mContext.getResources().getIdentifier(
                str, "drawable", mContext.getPackageName());//通过名字获取ID
        viewHolder.getIvPicture().setImageResource(resId);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return NUM_PICTURE;
    }


}
