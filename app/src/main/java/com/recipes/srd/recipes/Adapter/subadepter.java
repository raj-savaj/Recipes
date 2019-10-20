package com.recipes.srd.recipes.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.recipes.srd.recipes.Api.API;
import com.recipes.srd.recipes.Api.Okhttp;
import com.recipes.srd.recipes.Api.SessionManager;
import com.recipes.srd.recipes.R;
import com.recipes.srd.recipes.RecipeView;
import com.recipes.srd.recipes.db.Submenu;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

public class subadepter extends RecyclerView.Adapter<subadepter.ProgramingViewHolder> {

    List<Submenu> subMenus;
    SessionManager sessionManager;
    public subadepter(List<Submenu> subMenus) {
       this.subMenus=subMenus;
    }

    @Override
    public subadepter.ProgramingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.subd, parent, false);
        sessionManager=new SessionManager(view.getContext());
        return new subadepter.ProgramingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final subadepter.ProgramingViewHolder holder, int position) {
       final Submenu sub=subMenus.get(position);
        holder.textView.setText(sub.getName());
        if(Okhttp.isInternetAvailable(holder.v.getContext())){
            Picasso.with(holder.v.getContext())
                    .load(API.IMG_URL+sub.getImage().replaceAll(" ", "%20"))
                    .into(holder.imageView);
        }
        else {
            Picasso.with(holder.v.getContext())
                    .load(API.IMG_URL+sub.getImage().replaceAll(" ", "%20"))
                    .networkPolicy(NetworkPolicy.OFFLINE)
                    .into(holder.imageView);
        }

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),RecipeView.class);
                sessionManager.setSubmenu(sub);
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return subMenus.size();
    }

    public class ProgramingViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        View v;

        public ProgramingViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgi);
            textView = itemView.findViewById(R.id.eat);
            v = itemView;

        }
    }
}
