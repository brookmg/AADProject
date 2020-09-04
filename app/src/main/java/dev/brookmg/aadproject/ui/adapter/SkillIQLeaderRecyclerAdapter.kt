package dev.brookmg.aadproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import dev.brookmg.aadproject.databinding.RecyclerItemBinding
import dev.brookmg.aadproject.model.LearningLeaderItem
import dev.brookmg.aadproject.model.SkillIQItem

class SkillIQLeaderRecyclerAdapter(
    private val skillIQLeadersList: List<SkillIQItem>
) : RecyclerView.Adapter<SkillIQLeaderRecyclerAdapter.ViewHolder>(){

    class ViewHolder(
        private val recyclerItemBinding: RecyclerItemBinding
    ) : RecyclerView.ViewHolder(recyclerItemBinding.root) {

        fun bind(skillIQLeader: SkillIQItem) {
            recyclerItemBinding.leaderName.text = skillIQLeader.name
            recyclerItemBinding.mainImageView.load(skillIQLeader.badgeUrl)
            recyclerItemBinding.leaderDetail.text = String.format("%d Skill IQ Score, %s", skillIQLeader.score, skillIQLeader.country)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(skillIQLeadersList[position])

    override fun getItemCount(): Int = skillIQLeadersList.size


}