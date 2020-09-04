package dev.brookmg.aadproject.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.brookmg.aadproject.ui.fragment.LearningLeaderFragment
import dev.brookmg.aadproject.ui.fragment.SkillIQLeaderFragment

class TabAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LearningLeaderFragment.newInstance()
            1 -> SkillIQLeaderFragment.newInstance()
            else -> LearningLeaderFragment.newInstance()
        }
    }
}