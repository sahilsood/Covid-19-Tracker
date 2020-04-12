package xyz.sahilsood.covid19tracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import xyz.sahilsood.covid19tracker.R
import xyz.sahilsood.covid19tracker.models.States

class StateAdapter(mData: States?) :
    RecyclerView.Adapter<StateAdapter.ViewHolder>() {
    var mData: List<States.StatesItem> =
        mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.state_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        var stateInfo: States.StatesItem? = mData[position]
        holder.itemStateInfoName.text = stateInfo?.state.toString()
        holder.itemStateInfoTotal.text = stateInfo?.positive.toString()
        holder.itemStateInfoRecov.text = if (stateInfo?.recovered.toString()
                .equals("0")
        ) "N/A" else stateInfo?.recovered.toString()
        holder.itemStateInfoDead.text = stateInfo?.death.toString()

    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var itemStateInfoRecov: TextView =
            itemView.findViewById<View>(R.id.stateRecovered) as TextView
        var itemStateInfoTotal: TextView =
            itemView.findViewById<View>(R.id.stateConfirmed) as TextView
        var itemStateInfoDead: TextView = itemView.findViewById<View>(R.id.stateDeath) as TextView
        var itemStateInfoName: TextView = itemView.findViewById<View>(R.id.stateName) as TextView

    }

    init {
        this.mData = mData!!
    }
}