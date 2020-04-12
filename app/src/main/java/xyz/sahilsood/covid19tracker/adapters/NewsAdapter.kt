package xyz.sahilsood.covid19tracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import xyz.sahilsood.covid19tracker.R
import xyz.sahilsood.covid19tracker.models.News

class NewsAdapter(mData: News?) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    var mData: List<News.Article> =
        mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        var news: News.Article? = mData[position]
        holder.itemNewsTitle.text = news?.title.toString()
        holder.itemNewsSource.text = news?.source?.name.toString()
        Picasso.get().load(news?.urlToImage.toString()).resize(300, 300).centerCrop()
            .into((holder.itemNewsImage));

    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var itemNewsImage: ImageView = itemView.findViewById<View>(R.id.iv_newsImg) as ImageView
        var itemNewsTitle: TextView = itemView.findViewById<View>(R.id.tv_article) as TextView
        var itemNewsSource: TextView = itemView.findViewById<View>(R.id.tv_source) as TextView

    }

    init {
        this.mData = mData?.articles!!
    }
}