package com.teamtreehouse.testingbase;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void editTextUpdatesTextView() throws Exception {
        // Arrange
        String givenString = "test123";

        // Act


        // Assert

    }

    @Test
    public void spinnerUpdatesBackgroundColor() throws Exception {
        // Arrange


        // Act


        // Assert

    }

    @Test
    public void buttonLaunchesOtherActivity() throws Exception {
        // Arrange


        // Act


        // Assert

    }
}