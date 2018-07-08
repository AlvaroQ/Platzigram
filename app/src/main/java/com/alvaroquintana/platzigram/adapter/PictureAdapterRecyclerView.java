package com.alvaroquintana.platzigram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alvaroquintana.platzigram.R;
import com.alvaroquintana.platzigram.activity.PictureDetailActivity;
import com.alvaroquintana.platzigram.model.Picture;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder> {

    private static final String WHITE_SPACE = " ";
    private ArrayList<Picture> pictures;
    private int resource;
    private Activity activity;


    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int cardview_picture, FragmentActivity activity) {
        this.pictures = pictures;
        this.resource = cardview_picture;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder holder, int position) {
        Picture picture = pictures.get(position);

        String textDias;
        if(picture.getTime() == 1)
            textDias = picture.getTime() + WHITE_SPACE + activity.getString(R.string.day);
        else
            textDias = picture.getTime() + WHITE_SPACE  + activity.getString(R.string.days);

        String textLikes = picture.getNumberLikes() + WHITE_SPACE + activity.getString(R.string.likes_card_singular);

        holder.usernameCard.setText(picture.getUsername());
        holder.timeCard.setText(textDias);
        holder.likedNumberCard.setText(textLikes);
        Picasso.get().load(picture.getPicture()).into(holder.pictureCard);

        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, PictureDetailActivity.class);
                activity.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder {

        private ImageView pictureCard;
        private TextView usernameCard;
        private TextView timeCard;
        private TextView likedNumberCard;

        public PictureViewHolder(View itemView) {
            super(itemView);

            pictureCard = (ImageView) itemView.findViewById(R.id.pictureCardImage);
            usernameCard = (TextView) itemView.findViewById(R.id.userNameCard);
            timeCard = (TextView) itemView.findViewById(R.id.daysCard);
            likedNumberCard = (TextView) itemView.findViewById(R.id.likeNumberCard);
        }
    }
}
