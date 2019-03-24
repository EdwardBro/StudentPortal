package com.example.studentportal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import android.view.LayoutInflater;
import android.view.View;

import java.util.List;

public class PortalAdapter extends RecyclerView.Adapter<PortalObjectViewHolder> {

    private List<Portal> myPortals;

    public PortalAdapter(List<Portal> myPortals) {
        this.myPortals = myPortals;
    }

    @NonNull
    @Override
    public PortalObjectViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_cell, viewGroup, false);
        // Return a new holder instance
        PortalObjectViewHolder viewHolder = new PortalObjectViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PortalObjectViewHolder viewHolder, int i) {
        Portal portal = myPortals.get(i);
        viewHolder.portalName.setText(portal.getMyPortalTitle());
    }

    @Override
    public int getItemCount() {
        return myPortals.size();
    }
}
