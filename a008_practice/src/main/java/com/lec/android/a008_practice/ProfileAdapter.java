package com.lec.android.a008_practice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder>{
    List<Profile> items = new ArrayList<Profile>();

    static ProfileAdapter adapter;

    public ProfileAdapter() {this.adapter = this;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inf = LayoutInflater.from(parent.getContext());
        View itemView = inf.inflate(R.layout.item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Profile item = items.get(position);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvAge, tvAddr;
        ImageButton btnDelItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvAddr = itemView.findViewById(R.id.tvAddr);

            btnDelItem = itemView.findViewById(R.id.btnDelItem);

            btnDelItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter.removeItem(getAdapterPosition());
                    adapter.notifyDataSetChanged();
                }
            });
        }

    } // end ViewHolder

    public void addItem(Profile item) {items.add(item);}
    public void addItem(int position, Profile item) {items.add(position, item);}
    public void setItems(ArrayList<Profile> items) {this.items = items;}
    public Profile getItem(int position) {return items.get(position);}
    public void setItem(int position, Profile item) {items.set(position, item);}
    public void removeItem(int position){items.remove(position);}

} // end Adapter
