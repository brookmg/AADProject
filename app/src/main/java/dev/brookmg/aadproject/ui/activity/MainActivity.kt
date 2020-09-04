package dev.brookmg.aadproject.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import dev.brookmg.aadproject.R
import dev.brookmg.aadproject.databinding.ActivityMainBinding
import dev.brookmg.aadproject.ui.adapter.TabAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivity: ActivityMainBinding
    private lateinit var tabAdapter: TabAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivity.root)

        tabAdapter = TabAdapter(supportFragmentManager, lifecycle)
        mainActivity.mainViewpager.adapter = tabAdapter
        mainActivity.mainViewpager.offscreenPageLimit = 3

        mainActivity.submitButton.setOnClickListener {
            startActivity(Intent(this, ProjectSubmissionActivity::class.java))
        }

        TabLayoutMediator(mainActivity.tabLayout, mainActivity.mainViewpager) {
            tab, position ->
                when (position) {
                    0 -> tab.text = getString(R.string.learning_leaders)
                    1 -> tab.text = getString(R.string.skill_iq_leaders)
                }
        }.attach()

    }
}