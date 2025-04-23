package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TopStoryAdapter extends RecyclerView.Adapter<TopStoryAdapter.ViewHolder> {

    Context ctx_for;
    List<NewsModel> list_for;

    public TopStoryAdapter(Context ctx_for, List<NewsModel> list_for) {
        this.ctx_for = ctx_for;
        this.list_for = list_for;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx_for).inflate(R.layout.item_top_story, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder holder, int pos) {
        holder.image.setImageResource(list_for.get(pos).getImage());
        holder.title.setText(list_for.get(pos).getTitle());
    }

    public int getItemCount() {
        return list_for.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageViewTop);
            title = itemView.findViewById(R.id.textViewTop);
        }
    }
}
