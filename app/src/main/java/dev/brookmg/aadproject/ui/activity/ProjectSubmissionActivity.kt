package dev.brookmg.aadproject.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.doOnTextChanged
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout
import dev.brookmg.aadproject.App
import dev.brookmg.aadproject.R
import dev.brookmg.aadproject.databinding.ActivityProjectSubmissionBinding
import dev.brookmg.aadproject.databinding.AreYouSureDialogBinding
import dev.brookmg.aadproject.databinding.FailedDialogBinding
import dev.brookmg.aadproject.databinding.SuccessDialogBinding

class ProjectSubmissionActivity : AppCompatActivity() {

    private lateinit var projectSubmissionActivity: ActivityProjectSubmissionBinding

    private fun addErrorRemoverOnTextChanged(vararg textInputLayouts: TextInputLayout) {
        for (textInputLayout in textInputLayouts) {
            textInputLayout.editText?.doOnTextChanged {
                _, _, _, _ -> textInputLayout.error = ""
            }
        }
    }

    private fun checkEditTextEmpty(vararg textInputLayouts: TextInputLayout) : Boolean{
        for (textInputLayout in textInputLayouts) {
            if (textInputLayout.editText?.text.toString().isBlank()) {
                textInputLayout.error = "This can't be empty"
                return false
            }
        }

        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AADProject)
        projectSubmissionActivity = ActivityProjectSubmissionBinding.inflate(layoutInflater)
        setContentView(projectSubmissionActivity.root)

        setSupportActionBar(projectSubmissionActivity.mainToolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        addErrorRemoverOnTextChanged(
            projectSubmissionActivity.firstName,
            projectSubmissionActivity.lastName,
            projectSubmissionActivity.email,
            projectSubmissionActivity.githubLink
        )

        projectSubmissionActivity.submitButton.setOnClickListener {

            // Check if everything is filled
            if (!checkEditTextEmpty(
                projectSubmissionActivity.firstName,
                projectSubmissionActivity.lastName,
                projectSubmissionActivity.email,
                projectSubmissionActivity.githubLink
            )) return@setOnClickListener

            val areYouSureDialog = AreYouSureDialogBinding.inflate(layoutInflater)

            val successDialog = MaterialAlertDialogBuilder(this)
                .setView(SuccessDialogBinding.inflate(layoutInflater).root)
                .create()

            val failedDialog = MaterialAlertDialogBuilder(this)
                .setView(FailedDialogBinding.inflate(layoutInflater).root)
                .create()

            lateinit var  materialAlertDialog : AlertDialog

            areYouSureDialog.button.setOnClickListener {
                materialAlertDialog.dismiss()
                App.api.sendFormResponse(
                    firstName = projectSubmissionActivity.firstName.editText?.text.toString(),
                    lastName = projectSubmissionActivity.lastName.editText?.text.toString(),
                    email = projectSubmissionActivity.email.editText?.text.toString(),
                    githubProjectLink = projectSubmissionActivity.githubLink.editText?.text.toString()
                ) {
                    if (it.second.isNotBlank()) failedDialog.show()
                    else successDialog.show()
                }
            }

            areYouSureDialog.exitButton.setOnClickListener { materialAlertDialog.dismiss() }

            materialAlertDialog = MaterialAlertDialogBuilder(this)
                .setView(areYouSureDialog.root)
                .show()
        }

    }
}