package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context ctx_for;
    private List<NewsModel> list_for;
    private OnNewsClickListener listener;

    public NewsAdapter(Context ctx_for, List<NewsModel> list_for, OnNewsClickListener listener) {
        this.ctx_for = ctx_for;
        this.list_for = list_for;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent_for, int viewType_for) {
        View view_for = LayoutInflater.from(ctx_for).inflate(R.layout.item_news, parent_for, false);
        return new ViewHolder(view_for);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder_for, int pos_for) {
        NewsModel item_for = list_for.get(pos_for);
        holder_for.title.setText(item_for.getTitle());
        holder_for.image.setImageResource(item_for.getImage());
        holder_for.description.setText(item_for.getDescription()); // NEW

        holder_for.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onNewsClick(item_for);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_for.size();
    }

    public interface OnNewsClickListener {
        void onNewsClick(NewsModel model);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, description; // NEW

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageViewNews);
            title = itemView.findViewById(R.id.textViewNews);
            description = itemView.findViewById(R.id.textViewDesc); // NEW
        }
    }
}
