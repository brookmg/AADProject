package dev.brookmg.aadproject.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.brookmg.aadproject.databinding.ActivityProjectSubmissionBinding

class ProjectSubmissionActivity : AppCompatActivity() {

    private lateinit var projectSubmissionActivity: ActivityProjectSubmissionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        projectSubmissionActivity = ActivityProjectSubmissionBinding.inflate(layoutInflater)
        setContentView(projectSubmissionActivity.root)

        setSupportActionBar(projectSubmissionActivity.mainToolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}