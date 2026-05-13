package com.example.gopath;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ObjectInputStream;
import java.util.List;

public class RecyclerTrailAdapter  extends RecyclerView.Adapter<RecyclerTrailAdapter.TrailViewHolder> {
    private List<Trail> trails;
    public RecyclerTrailAdapter(List<Trail> trails){
        this.trails = trails;
    }
    @NonNull
    @Override
    public TrailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View TrailView= LayoutInflater.from(parent.getContext()).inflate(R.layout.trail_item, parent,  false);
        return new TrailViewHolder(TrailView);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailViewHolder holder, int position) {

        Trail trail = trails.get(position);
        holder.nameTV.setText(trail.getName());
        holder. regionTV.setText(trail.getRegion ());
        holder. timeTV.setText(trail.getTime());
        holder. distanceTV.setText(trail.getDistance ());
        holder. ratingTV.setText(trail.getRating ());
        if (trail.isFamilyFriendly()) {
            holder.familyFriendlyBtn.setVisibility(View.VISIBLE);
        } else {
            holder.familyFriendlyBtn.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return trails.size();
    }

    public class TrailViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTV;
        public TextView regionTV;
        public TextView timeTV;
        public TextView distanceTV;
        public TextView ratingTV;

        public ImageButton familyFriendlyBtn;
        public ImageView trailIV;






        @SuppressLint("WrongViewCast")
        public TrailViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id. trail_name
            );
            regionTV = itemView.findViewById(R.id.trail_region
            );
            timeTV = itemView.findViewById(R.id. trail_time
            );
            distanceTV = itemView.findViewById(R.id. trail_distance
            );
            ratingTV = itemView.findViewById(R.id. trail_rating
            );
            trailIV = itemView.findViewById(R.id. trail_image

            );
            familyFriendlyBtn = itemView.findViewById(R.id.IsFamilyFriendly

            );


        }
    }
}

