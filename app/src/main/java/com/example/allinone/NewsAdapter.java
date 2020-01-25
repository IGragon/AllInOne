package com.example.allinone;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> { // data adapter which adapt news for ViewHolder
    private LayoutInflater inflater;
    private List<News> news;

    NewsAdapter(Context context, List<News> news) {
        this.news = news;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.news_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, int position) {
        News news_obj = news.get(position);
        //holder.imageNews.setImageResource(news_obj.getImage_url());  технические шоколадки
        holder.textNews.setText(news_obj.getText());
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textNews;
        ViewHolder(View view){
            super(view);
            textNews = (TextView) view.findViewById(R.id.textNews);
        }
    }
}
