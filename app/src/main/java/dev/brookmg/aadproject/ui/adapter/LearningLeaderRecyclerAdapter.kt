package dev.brookmg.aadproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import dev.brookmg.aadproject.databinding.RecyclerItemBinding
import dev.brookmg.aadproject.model.LearningLeaderItem

class LearningLeaderRecyclerAdapter(
    private val learningLeadersList: List<LearningLeaderItem>
) : RecyclerView.Adapter<LearningLeaderRecyclerAdapter.ViewHolder>(){

    class ViewHolder(
        private val recyclerItemBinding: RecyclerItemBinding
    ) : RecyclerView.ViewHolder(recyclerItemBinding.root) {

        fun bind(learningLeaderItem: LearningLeaderItem) {
            recyclerItemBinding.leaderName.text = learningLeaderItem.name
            recyclerItemBinding.mainImageView.load(learningLeaderItem.badgeUrl)
            recyclerItemBinding.leaderDetail.text = String.format("%d Watched hours, %s", learningLeaderItem.hours, learningLeaderItem.country)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(learningLeadersList[position])

    override fun getItemCount(): Int = learningLeadersList.size


}