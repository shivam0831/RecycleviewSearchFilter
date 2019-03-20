package com.example.recycleviewsearchfilter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> implements Filterable {
    Context c;
    ArrayList<Model> players,filterList;
    CustomFilter filter;
    public MyAdapter(Context ctx,ArrayList<Model> players)
    {
        this.c=ctx;
        this.players=players;
        this.filterList=players;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,null);
        MyHolder holder = new MyHolder(v);
        return holder;
    }
    //DATA BOUND TO VIEWS
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        //BIND DATA
        holder.nameTxt.setText(players.get(position).getName());
        holder.img.setImageResource(players.get(position).getImg());

        Animation animation = AnimationUtils.loadAnimation(c, android.R.anim.slide_in_left);
        holder.itemView.startAnimation(animation);

        //IMPLEMENT CLICK LISTENER
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {

                if (players.get(pos).getName().equals("Home")){
                    Toast.makeText(c, "Home...", Toast.LENGTH_SHORT).show();
                }
                else if (players.get(pos).getName().equals("Contacts")){
                    Toast.makeText(c, "Contacts...", Toast.LENGTH_SHORT).show();
                }
                else if (players.get(pos).getName().equals("Images")){
                    Toast.makeText(c, "Images...", Toast.LENGTH_SHORT).show();
                }
                else if (players.get(pos).getName().equals("Videos")){
                    Toast.makeText(c, "Videos...", Toast.LENGTH_SHORT).show();
                }
                else if (players.get(pos).getName().equals("Mails")){
                    Toast.makeText(c, "Mails...", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    //GET TOTAL NUM OF PLAYERS
    @Override
    public int getItemCount() {
        return players.size();
    }
    //RETURN FILTER OBJ
    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new CustomFilter(filterList,this);
        }
        return filter;
    }
}
