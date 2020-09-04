package dev.brookmg.aadproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import dev.brookmg.aadproject.App
import dev.brookmg.aadproject.databinding.FragmentRecyclerViewBinding
import dev.brookmg.aadproject.ui.adapter.SkillIQLeaderRecyclerAdapter

class SkillIQLeaderFragment : Fragment() {

    private lateinit var skillIQLeaderFragment: FragmentRecyclerViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        skillIQLeaderFragment = FragmentRecyclerViewBinding.inflate(layoutInflater, container, false)

        App.api.getSkillIQLeaderList {
            val adapter = SkillIQLeaderRecyclerAdapter(it)
            skillIQLeaderFragment.mainRecylcerView.adapter = adapter
            skillIQLeaderFragment.mainRecylcerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        return skillIQLeaderFragment.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = SkillIQLeaderFragment()
    }
}