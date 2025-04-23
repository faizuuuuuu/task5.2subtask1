package com.example.newsapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView recyclerTopStories, recyclerNews;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root_for = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerTopStories = root_for.findViewById(R.id.recyclerTopStories);
        recyclerNews = root_for.findViewById(R.id.recyclerNews);

        recyclerTopStories.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerNews.setLayoutManager(new GridLayoutManager(getContext(), 2));  // 2 columns

        // Sample data
        ArrayList<NewsModel> topList = new ArrayList<>();
        topList.add(new NewsModel("Top 1", R.drawable.placeholder,"Breaking highlights from around the globe."));
        topList.add(new NewsModel("Top 2", R.drawable.placeholder,"Breaking highlights from around the globe."));
        topList.add(new NewsModel("Top 3", R.drawable.placeholder,"Breaking highlights from around the globe."));

        ArrayList<NewsModel> newsList = new ArrayList<>();
        newsList.add(new NewsModel("9NEWS", R.drawable.placeholder, "Latest breaking news from 9NEWS."));
        newsList.add(new NewsModel("7NEWS", R.drawable.placeholder, "Top headlines from 7NEWS around the world."));
        newsList.add(new NewsModel("ABC NEWS", R.drawable.placeholder, "Independent journalism and current affairs."));
        newsList.add(new NewsModel("THE AGE", R.drawable.placeholder, "In-depth news from Melbourne's oldest newspaper."));

        recyclerTopStories.setAdapter(new TopStoryAdapter(getContext(), topList));

        // Handle clicks using the listener
        recyclerNews.setAdapter(new NewsAdapter(getContext(), newsList, model -> {
            Bundle bundle = new Bundle();
            bundle.putString("title", model.getTitle());
            bundle.putInt("image", model.getImage());
            bundle.putString("desc", model.getDescription());

            NewsDetailFragment fragment = new NewsDetailFragment();
            fragment.setArguments(bundle);

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .addToBackStack(null)
                    .commit();
        }));

        return root_for;
    }
}
