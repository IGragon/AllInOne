package com.example.allinone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.allinone.databinding.FragmentNewsBinding;
import com.vk.api.sdk.requests.VKRequest;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

    private FragmentNewsBinding fragmentNewsBinding;

    List<News> news = new ArrayList<>(); // list for news
    List<Message> messages = new ArrayList<>(); // list for messages

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentNewsBinding = FragmentNewsBinding.inflate(inflater, container, false);

        View view = fragmentNewsBinding.getRoot();


        create_some_news(); // create some unreal news
        RecyclerView.Adapter adapter = new NewsAdapter(getContext(), news);
        // устанавливаем для списка адаптер
        fragmentNewsBinding.newsRecyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        fragmentNewsBinding = null;
        super.onDestroyView();
    }

    private void create_some_news(){ // temp method to create news
        for (int i = 0; i < 5; ++i) {
            news.add(new News("1st item then some text aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
            news.add(new News("2nd item then some text aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
            news.add(new News("3rd item then some text aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
            news.add(new News("4th item then some text aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
            news.add(new News("5th item then some text aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
            messages.add(new Message("1Name Surname", "Something like last message"));
            messages.add(new Message("2Name Surname", "Something like last message"));
            messages.add(new Message("3Name Surname", "Something like last message"));
            messages.add(new Message("4Name Surname", "Something like last message"));
            messages.add(new Message("5Name Surname", "Something like last message"));
        }
    }
}
