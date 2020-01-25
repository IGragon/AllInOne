package com.example.allinone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.allinone.databinding.FragmentMessagesBinding;

import java.util.ArrayList;
import java.util.List;

public class MessagesFragment extends Fragment {
    private FragmentMessagesBinding fragmentMessagesBinding;

    List<Message> messages = new ArrayList<>(); // list for messages

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentMessagesBinding = fragmentMessagesBinding.inflate(inflater, container, false);

        View view = fragmentMessagesBinding.getRoot();


        create_some_messages(); // create some unreal messages
        RecyclerView.Adapter adapter = new MessageAdapter(getContext(), messages);
        // устанавливаем для списка адаптер
        fragmentMessagesBinding.newsRecyclerView.setAdapter(adapter);

        return view;
    }

    private void create_some_messages(){ // temp method to create messages
        for (int i = 0; i < 5; ++i) {
            messages.add(new Message("1Name Surname", "Something like last message"));
            messages.add(new Message("2Name Surname", "Something like last message"));
            messages.add(new Message("3Name Surname", "Something like last message"));
            messages.add(new Message("4Name Surname", "Something like last message"));
            messages.add(new Message("5Name Surname", "Something like last message"));
        }
    }
}
