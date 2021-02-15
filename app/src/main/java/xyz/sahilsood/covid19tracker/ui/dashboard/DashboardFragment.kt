package xyz.sahilsood.covid19tracker.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import xyz.sahilsood.covid19tracker.R
import xyz.sahilsood.covid19tracker.adapters.TopStatesAdapter
import xyz.sahilsood.covid19tracker.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment() {

    private lateinit var homeViewModel: DashboardViewModel
    private lateinit var binding: FragmentDashboardBinding
    private lateinit var mAdapter: RecyclerView.Adapter<*>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)?.supportActionBar?.hide()
        homeViewModel.stateLiveData.observe(viewLifecycleOwner, Observer { states ->
            states?.sortByDescending { it.total }

            binding.mrecyclerView.setHasFixedSize(true)

            binding.mrecyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            mAdapter = TopStatesAdapter(states)
            binding.mrecyclerView.adapter = mAdapter
        })

        homeViewModel.summaryLiveData.observe(viewLifecycleOwner, Observer {
            binding.summary = it

            it?.countries?.forEach { eachValue ->
                if (eachValue.country == "United States of America") {
                    binding.country = eachValue
                }
            }
        })
    }
}
