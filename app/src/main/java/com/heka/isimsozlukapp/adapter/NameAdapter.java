package com.heka.isimsozlukapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.heka.isimsozlukapp.R;
import com.heka.isimsozlukapp.model.Name;
import com.heka.isimsozlukapp.model.Usage;

import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {

    private Context context;
    private List<Name> nameList;


    public NameAdapter(Context context, List<Name> nameList) {
        this.context = context;
        this.nameList = nameList;
    }

    public void setNameList(List<Name> names) {
        nameList = names;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_name, parent, false);
        return new NameViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        Name name = nameList.get(position);
        holder.nameTextView.setText(name.getName());
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public static class NameViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
        }
    }
}
