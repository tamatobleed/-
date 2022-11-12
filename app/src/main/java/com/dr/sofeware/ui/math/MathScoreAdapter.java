package com.dr.sofeware.ui.math;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dr.sofeware.R;

import java.util.ArrayList;

/**
 * @Description TODO
 * @systemUser admin
 * @Author DR.LHXY
 * @Date 11-12-2022 周六 6:36
 */
public class MathScoreAdapter extends RecyclerView.Adapter<MathScoreAdapter.ViewHolder> {

    private ArrayList<String> formuls;
    private  ArrayList<String> answers;

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        public static class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView tv_math_score_formul,tv_math_score_answer;
            public ViewHolder(View view) {
                super(view);
                tv_math_score_formul = (TextView) view.findViewById(R.id.tv_math_score_formul);
                tv_math_score_answer = (TextView) view.findViewById(R.id.tv_math_score_answer);
            }

            public TextView getTvFormul() {
                return tv_math_score_formul;
            }
            public TextView getTvAnswer() {
                return tv_math_score_answer;
            }
        }


        public MathScoreAdapter(ArrayList<String> formuls,ArrayList<String> answers) {
            this.formuls=formuls;
            this.answers=answers;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_score, viewGroup, false);

            return new ViewHolder(view);
        }


        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {

                viewHolder.getTvFormul().setText(formuls.get(position));
                viewHolder.getTvAnswer().setText(answers.get(position));
        }


        @Override
        public int getItemCount() {
            return answers.size();
        }


}
