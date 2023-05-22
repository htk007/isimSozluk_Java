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

public class UsageAdapter extends RecyclerView.Adapter<UsageAdapter.UsageViewHolder> {
private Context context;
private List<Usage> usageList;

    public UsageAdapter(Context context, List<Usage> usageList) {
        this.context = context;
        this.usageList = usageList;
    }

    public void setUsageList(List<Usage> usageList){
        this.usageList = usageList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UsageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_name, parent, false);
        return new UsageAdapter.UsageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UsageViewHolder holder, int position) {
        Usage name = usageList.get(position);
        holder.nameTextView.setText(name.getUsageFull());
    }

    @Override
    public int getItemCount() {
        return usageList.size();
    }


    public static class UsageViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;

        public UsageViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
        }
    }
}
