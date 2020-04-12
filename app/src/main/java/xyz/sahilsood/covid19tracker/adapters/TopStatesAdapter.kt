package xyz.sahilsood.covid19tracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import xyz.sahilsood.covid19tracker.R
import xyz.sahilsood.covid19tracker.models.States

class TopStatesAdapter(mData: States?) :
    RecyclerView.Adapter<TopStatesAdapter.ViewHolder>() {
    var mData: List<States.StatesItem> =
        mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.top_state_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        var summary: States.StatesItem? = mData[position]
        holder.itemStateName.text = summary?.state
        holder.itemStateTotal.text = summary?.positive.toString()
        holder.itemStateRecov.text =
            if (summary?.recovered.toString() == "0") "N/A" else summary?.recovered.toString()
        holder.itemStateDead.text = summary?.death.toString()

    }

    override fun getItemCount(): Int {
        return 3
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var itemStateRecov: TextView = itemView.findViewById<View>(R.id.state_recov_no) as TextView
        var itemStateTotal: TextView = itemView.findViewById<View>(R.id.state_total_no) as TextView
        var itemStateDead: TextView = itemView.findViewById<View>(R.id.state_dead_no) as TextView
        var itemStateName: TextView = itemView.findViewById<View>(R.id.state_name) as TextView

    }

    init {
        this.mData = mData!!
    }
}