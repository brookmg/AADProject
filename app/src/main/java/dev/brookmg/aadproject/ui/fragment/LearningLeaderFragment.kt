package dev.brookmg.aadproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import dev.brookmg.aadproject.App
import dev.brookmg.aadproject.databinding.FragmentRecyclerViewBinding
import dev.brookmg.aadproject.ui.adapter.LearningLeaderRecyclerAdapter
import dev.brookmg.aadproject.ui.adapter.SkillIQLeaderRecyclerAdapter

class LearningLeaderFragment : Fragment() {

    private lateinit var learningLeaderFragment: FragmentRecyclerViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        learningLeaderFragment = FragmentRecyclerViewBinding.inflate(layoutInflater, container, false)

        App.api.getLearnerLeaderList {
            val adapter = LearningLeaderRecyclerAdapter(it)
            learningLeaderFragment.mainRecylcerView.adapter = adapter
            learningLeaderFragment.mainRecylcerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        return learningLeaderFragment.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = LearningLeaderFragment()
    }
}