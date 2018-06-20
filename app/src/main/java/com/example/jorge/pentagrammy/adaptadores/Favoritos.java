package com.example.jorge.pentagrammy.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jorge.pentagrammy.R;
import com.example.jorge.pentagrammy.modelo.PetInfo;

import java.util.ArrayList;

/**
 * Created by jorge on 3/02/18.
 */

public class Favoritos extends RecyclerView.Adapter<Favoritos.adaViewHolder>{
    private Activity activity;
    private ArrayList<PetInfo> mDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public Favoritos(ArrayList<PetInfo> myDataset, Activity activity) {
        this.mDataset = myDataset;
        this.activity = activity;
    }

    public static class adaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvMeGusta;

        public adaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvMeGusta = (TextView) itemView.findViewById(R.id.tvMeGusta);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public Favoritos.adaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View vw = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_favoritos, parent, false);
        adaViewHolder vh = new adaViewHolder(vw);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final adaViewHolder vHolder, int position) {
        // - get element from your dataset at this position

        final PetInfo petinfo = mDataset.get(position);
        vHolder.imgFoto.setImageResource(petinfo.getFoto());
        vHolder.tvNombreCV.setText(petinfo.getNombre());
        vHolder.tvMeGusta.setText(Integer.toString(petinfo.getLikes()));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
