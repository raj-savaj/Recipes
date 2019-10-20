package com.recipes.srd.recipes.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.recipes.srd.recipes.Api.API;
import com.recipes.srd.recipes.Api.Okhttp;
import com.recipes.srd.recipes.Api.SessionManager;
import com.recipes.srd.recipes.R;
import com.recipes.srd.recipes.db.Recipe;
import com.recipes.srd.recipes.subdishes;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;


public class proadepter extends RecyclerView.Adapter<proadepter.ProgramingViewHolder> {

    List<Recipe> recipes;
    SessionManager sessionManager;

    public proadepter(List<Recipe> recipes) {
        this.recipes=recipes;
    }

    @Override
    public ProgramingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout, parent, false);
        sessionManager=new SessionManager(view.getContext());
        return new ProgramingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProgramingViewHolder holder, int position) {
        final Recipe recipe=recipes.get(position);
        holder.textView.setText(recipe.getName());
        if(Okhttp.isInternetAvailable(holder.v.getContext())){
            Picasso.with(holder.v.getContext())
                    .load(API.IMG_URL+recipe.getImage().replaceAll(" ", "%20"))
                    .into(holder.imageView);
        }
        else {
            Picasso.with(holder.v.getContext())
                    .load(API.IMG_URL+recipe.getImage().replaceAll(" ", "%20"))
                    .networkPolicy(NetworkPolicy.OFFLINE)
                    .into(holder.imageView);
        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(holder.v.getContext(),subdishes.class);
                i.putExtra("mid",recipe.getId());
                sessionManager.setRecipes(recipe);
                holder.v.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class ProgramingViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        View v;
        public ProgramingViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgicon);
            textView = itemView.findViewById(R.id.texttitle);
            v = itemView;

        }
    }
}
