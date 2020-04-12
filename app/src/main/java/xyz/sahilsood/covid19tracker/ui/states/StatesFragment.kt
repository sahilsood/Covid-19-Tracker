package xyz.sahilsood.covid19tracker.ui.states

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
import kotlinx.android.synthetic.main.fragment_states.*
import xyz.sahilsood.covid19tracker.R
import xyz.sahilsood.covid19tracker.adapters.StateAdapter
import xyz.sahilsood.covid19tracker.models.States

class StatesFragment : Fragment() {

    private lateinit var stateViewModel: StatesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        stateViewModel =
            ViewModelProviders.of(this).get(StatesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_states, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        stateViewModel.stateLiveData.observe(viewLifecycleOwner, Observer<States?> {
            it?.sortByDescending { it.total }
            var mAdapter: RecyclerView.Adapter<*>? = null
            var mlayoutManager: RecyclerView.LayoutManager? = null
            stateRecyclerView.setHasFixedSize(true)

            mlayoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            stateRecyclerView.layoutManager = mlayoutManager

            mAdapter = StateAdapter(it)
            stateRecyclerView.adapter = mAdapter
        })
    }
}
