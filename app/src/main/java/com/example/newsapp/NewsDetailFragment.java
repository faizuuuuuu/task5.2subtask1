package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsDetailFragment extends Fragment {

    ImageView imageViewDetail;
    TextView textViewTitle, textViewDesc; // NEW
    RecyclerView recyclerRelated;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);

        imageViewDetail = view.findViewById(R.id.imageViewDetail);
        textViewTitle = view.findViewById(R.id.textViewTitle);
        textViewDesc = view.findViewById(R.id.textViewDesc); // NEW
        recyclerRelated = view.findViewById(R.id.recyclerRelated);

        // Receive data from bundle
        Bundle bundle = getArguments();
        if (bundle != null) {
            String title = bundle.getString("title", "No Title");
            int imageRes = bundle.getInt("image", R.drawable.placeholder);
            String desc = bundle.getString("desc", "No description available.");

            textViewTitle.setText(title);
            imageViewDetail.setImageResource(imageRes);
            textViewDesc.setText(desc); // Set description
        }

        // Related news dummy data
        ArrayList<NewsModel> relatedList = new ArrayList<>();
        relatedList.add(new NewsModel("Related 1", R.drawable.placeholder, "Something related"));
        relatedList.add(new NewsModel("Related 2", R.drawable.placeholder, "Another related item"));
        relatedList.add(new NewsModel("Related 3", R.drawable.placeholder, "More related content"));

        recyclerRelated.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerRelated.setAdapter(new NewsAdapter(getContext(), relatedList, model -> {
            // Optional: handle click for related news
        }));

        return view;
    }
}
