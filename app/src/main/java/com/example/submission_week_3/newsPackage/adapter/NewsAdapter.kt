package com.example.submission_week_3.newsPackage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submission_week_3.R
import com.example.submission_week_3.newsPackage.model.News
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(var data: ArrayList<News>?) :RecyclerView.Adapter<NewsAdapter.NewsHolder>() {
    class NewsHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val judul = itemView.judul_berita
        val img = itemView.BeritaImg
        val tanggal = itemView.tanggal
        val author = itemView.author
        val desc = itemView.desc
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)

        val holder = NewsHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.judul.text = data?.get(position)?.title
        holder.author.text = data?.get(position)?.author
        holder.tanggal.text = data?.get(position)?.publishedAt
        holder.desc.text = data?.get(position)?.description

        Glide.with(holder.itemView.context)
            .load(data?.get(position)?.urlToImage)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(holder.img)
    }

    override fun getItemCount(): Int {
        return data?.size?: 0
    }

}