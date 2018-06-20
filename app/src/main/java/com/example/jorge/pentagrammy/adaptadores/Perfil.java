package com.example.jorge.pentagrammy.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jorge.pentagrammy.R;
import com.example.jorge.pentagrammy.modelo.PerfilInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by jorge on 3/02/18.
 */

public class Perfil extends RecyclerView.Adapter<Perfil.adaViewHolder> {

    private Activity activity;
    private ArrayList<PerfilInfo> perfilDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public Perfil(ArrayList<PerfilInfo> myDataset, Activity activity) {
        this.perfilDataset = myDataset;
        this.activity = activity;
    }

    public static class adaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvMeGusta;

        public adaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvMeGusta = (TextView) itemView.findViewById(R.id.tvMeGusta);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public Perfil.adaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View vw = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);
        adaViewHolder vh = new adaViewHolder(vw);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final adaViewHolder vHolder, int position) {
        // - get element from your dataset at this position

        final PerfilInfo perfilInfo = perfilDataset.get(position);
        Picasso.with(activity)
                .load(perfilInfo.getUrlFoto())
                .placeholder(R.drawable.img3)
                .into(vHolder.imgFoto);
        //vHolder.imgFoto.setImageResource(perfilInfo.getFoto());
        vHolder.tvMeGusta.setText(Integer.toString(perfilInfo.getMeGusta()));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return perfilDataset.size();
    }
}
