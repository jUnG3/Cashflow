package de.cashflow.cashflow.login

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.RootMatchers.withDecorView
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import de.cashflow.cashflow.R
import de.cashflow.cashflow.login.activity.LoginActivity
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginWorkflowTest {

    @Rule @JvmField
    val activityTestRule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun testUserRegistration() {
        onView(withId(R.id.usernameInputField)).perform(typeText("jUnG3"))
        onView(withId(R.id.passwordInputField)).perform(typeText("1111")).perform(closeSoftKeyboard())
        onView(withId(R.id.registerButton)).perform(click())
        onView(withText(R.string.label_account_created)).inRoot(withDecorView(not(activityTestRule.activity.window.decorView))).check(matches(isDisplayed()))
    }

    @Test
    fun testWrongCredentials() {
        onView(withId(R.id.usernameInputField)).perform(typeText("jUnG3"))
        onView(withId(R.id.passwordInputField)).perform(clearText(), typeText("2222")).perform(closeSoftKeyboard())
        onView(withId(R.id.loginButton)).perform(click())
        onView(withText(R.string.label_wrong_credentials)).inRoot(withDecorView(not(activityTestRule.activity.window.decorView))).check(matches(isDisplayed()))
    }
}