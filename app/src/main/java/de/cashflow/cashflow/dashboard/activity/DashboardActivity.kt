package de.cashflow.cashflow.dashboard.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import de.cashflow.cashflow.R
import de.cashflow.cashflow.login.activity.LoginActivity
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        text.text = intent.getStringExtra(LoginActivity.USERNAME)
    }
}
