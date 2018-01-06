package com.teamtreehouse.testingbase;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.LinearLayout;

import org.hamcrest.Description;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void editTextUpdatesTextView() throws Exception {
        // Arrange
        String givenString = "test123";
        onView(withId(R.id.editText)).perform(typeText(givenString));

        // Act
        onView(withId(R.id.editText)).perform(pressImeActionButton());

        // Assert
        onView(withId(R.id.textView)).check(matches(withText(givenString)));
    }

    @Test
    public void spinnerUpdatesBackgroundColor() throws Exception {
        // Arrange
        final int givenColor = Color.GREEN;
        String spinnerItemText = "Green";

        // Act
        onView(withId(R.id.colorSpinner)).perform(click());
//        onView(withText(spinnerItemText)).perform(click());
        // above wouldn't work if the spinner has 100 items and we need to click on the
        // 98th one because it isn't visible, which is why we should use onData instead of onView
        // onView only searches through the view hierarchy
        // onData searches through everything
        onData(allOf(is(instanceOf(String.class)), is(spinnerItemText))).perform(click());

        // Assert
        BoundedMatcher<View, LinearLayout> backgroundColorMatcher =
                new BoundedMatcher<View, LinearLayout>(LinearLayout.class) {
            @Override
            protected boolean matchesSafely(LinearLayout linearLayout) {
                int actualColor = ((ColorDrawable)linearLayout.getBackground()).getColor();
                return givenColor == actualColor;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("background color should equal: " + givenColor);
            }
        };
        onView(withId(R.id.linearLayout)).check(matches(backgroundColorMatcher));
    }

    @Test
    public void buttonLaunchesOtherActivity() throws Exception {
        // Arrange


        // Act


        // Assert

    }
}