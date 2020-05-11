package com.benjamin.courierappui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.LogoViewHolder> {

    List<MainActivity.Icons> mIcons;


    RecyclerViewAdapter(List<MainActivity.Icons> mIcons) {
        this.mIcons = mIcons;
    }

    @NonNull
    @Override
    public LogoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.dashboard_recyclerview, viewGroup, false);
        LogoViewHolder logoViewHolder = new LogoViewHolder(view);
        return logoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LogoViewHolder logoViewHolder, int position) {
        logoViewHolder.mTextView.setText(mIcons.get(position).name);
        logoViewHolder.mImageView.setImageResource(mIcons.get(position).iconId);
        logoViewHolder.mCurrentPosition = position;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return mIcons.size();
    }

    public class LogoViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView mTextView;
        ImageView mImageView;
        public int mCurrentPosition;

        public LogoViewHolder(@NonNull final View itemView) {
            super(itemView);
            mCardView = itemView.findViewById(R.id.card_view);
            mTextView = itemView.findViewById(R.id.logo_title);
            mImageView = itemView.findViewById(R.id.logo_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if ((getAdapterPosition()) == 0) {
                        Toast.makeText(itemView.getContext(), "Create Shipping", Toast.LENGTH_SHORT).show();
                    } else if ((getAdapterPosition()) == 1) {
                        Toast.makeText(itemView.getContext(), "Schedule Pickup", Toast.LENGTH_SHORT).show();

                    } else if ((getAdapterPosition()) == 2) {
                        Toast.makeText(itemView.getContext(), "My Wallet", Toast.LENGTH_SHORT).show();

                    } else if ((getAdapterPosition()) == 3) {
                        Toast.makeText(itemView.getContext(), "Information", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }
}
