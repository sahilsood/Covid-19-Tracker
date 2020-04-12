package xyz.sahilsood.covid19tracker.ui.dashboard

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
import kotlinx.android.synthetic.main.fragment_dashboard.*
import xyz.sahilsood.covid19tracker.R
import xyz.sahilsood.covid19tracker.adapters.TopStatesAdapter
import xyz.sahilsood.covid19tracker.models.States
import xyz.sahilsood.covid19tracker.models.Summary


class DashboardFragment : Fragment() {

    private lateinit var homeViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        homeViewModel.stateLiveData.observe(viewLifecycleOwner, Observer<States?> {
            it?.sortByDescending { it.total }
            var mAdapter: RecyclerView.Adapter<*>? = null
            var mlayoutManager: RecyclerView.LayoutManager? = null
            mrecyclerView.setHasFixedSize(true)

            mlayoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            mrecyclerView.layoutManager = mlayoutManager

            mAdapter = TopStatesAdapter(it)
            mrecyclerView.adapter = mAdapter
        })

        homeViewModel.summaryLiveData.observe(viewLifecycleOwner, Observer<Summary?> {
            tv_infectedW.text = it?.global?.totalConfirmed.toString()
            tv_deathW.text = it?.global?.totalDeaths.toString()
            tv_recoveredW.text = it?.global?.totalRecovered.toString()
            newInfectedW.text = " +" + it?.global?.newConfirmed.toString()
            newRecoveredW.text = " +" + it?.global?.newRecovered.toString()
            newDeathW.text = " +" + it?.global?.newDeaths.toString()

            it?.countries?.forEach { eachValue ->
                if (eachValue.country == "United States of America") {
                    tv_infectedUS.text = eachValue.totalConfirmed.toString()
                    tv_deathUS.text = eachValue.totalDeaths.toString()
                    tv_recoveredUS.text = eachValue.totalRecovered.toString()
                    newRecovered.text = " +" + eachValue.newRecovered.toString()
                    newInfectedUS.text = " +" + eachValue.newConfirmed.toString()
                    newDeathUS.text = " +" + eachValue.newDeaths.toString()
                }
            }


        })
    }
}
