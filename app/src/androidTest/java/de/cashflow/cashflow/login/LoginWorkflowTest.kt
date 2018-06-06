package de.cashflow.cashflow.login

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import de.cashflow.cashflow.R
import de.cashflow.cashflow.login.activity.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginWorkflowTest {

    val activityTestRule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java)
        @Rule
        get

    @Test
    fun testLoginWithExistingUser() {
        onView(withId(R.id.usernameInputField)).perform(typeText("jUnG3"))
        onView(withId(R.id.passwordInputField)).perform(typeText("1111"))
        onView(withId(R.id.registerButton)).perform(click())
    }
}