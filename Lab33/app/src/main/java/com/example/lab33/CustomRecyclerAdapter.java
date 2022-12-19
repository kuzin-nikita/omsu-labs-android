package com.example.lab33;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder> {
    private List<String> names;

    public CustomRecyclerAdapter(List<String> names){
        this.names = names;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.getTextViewLarge().setText(names.get(position));
        holder.getTextViewSmall().setText("кот");
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private View itemView;
        private TextView textViewLarge;
        private TextView textViewSmall;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewLarge = itemView.findViewById(R.id.textViewLarge);
            textViewSmall = itemView.findViewById(R.id.textViewSmall);
        }

        public TextView getTextViewLarge(){
            return textViewLarge;
        }

        public TextView getTextViewSmall(){
            return textViewSmall;
        }
    }
}
