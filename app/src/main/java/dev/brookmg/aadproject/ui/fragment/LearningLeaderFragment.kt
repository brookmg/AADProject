package dev.brookmg.aadproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.brookmg.aadproject.databinding.FragmentRecyclerViewBinding

class LearningLeaderFragment : Fragment() {

    private lateinit var learningLeaderFragment: FragmentRecyclerViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        learningLeaderFragment = FragmentRecyclerViewBinding.inflate(layoutInflater, container, false)
        return learningLeaderFragment.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = LearningLeaderFragment()
    }
}