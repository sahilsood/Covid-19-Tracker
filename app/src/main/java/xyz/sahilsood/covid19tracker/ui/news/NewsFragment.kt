package xyz.sahilsood.covid19tracker.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_news.*
import xyz.sahilsood.covid19tracker.R
import xyz.sahilsood.covid19tracker.adapters.NewsAdapter
import xyz.sahilsood.covid19tracker.models.News

class NewsFragment : Fragment() {

    private lateinit var notificationsViewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(NewsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_news, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        notificationsViewModel.newsLiveData?.observe(viewLifecycleOwner, Observer<News?> {
            var mAdapter: RecyclerView.Adapter<*>? = null
            var mlayoutManager: RecyclerView.LayoutManager? = null
            newsRecyclerView.setHasFixedSize(true)

            mlayoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            newsRecyclerView.layoutManager = mlayoutManager

            mAdapter = NewsAdapter(it)
            newsRecyclerView.adapter = mAdapter
        })
    }
}
