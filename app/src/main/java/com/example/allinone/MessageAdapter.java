package com.example.allinone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> { // data adapter which adapt news for ViewHolder
    private LayoutInflater inflater;
    private List<Message> messages;

    MessageAdapter(Context context, List<Message> messages) {
        this.messages = messages;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.message_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MessageAdapter.ViewHolder holder, int position) {
        Message msg_obj = messages.get(position);
        //holder.imageNews.setImageResource(news_obj.getImage_url());  технические шоколадки
        holder.messageName.setText(msg_obj.getName());
        holder.messageMessage.setText(msg_obj.getName());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView messageName;
        final TextView messageMessage;
        ViewHolder(View view){
            super(view);
            messageName = (TextView) view.findViewById(R.id.messageName);
            messageMessage = (TextView) view.findViewById(R.id.messageMessage);
        }
    }
}
