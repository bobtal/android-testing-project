package com.teamtreehouse.testingbase;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.inputmethod.EditorInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    MainActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void editTextUpdatesTextView() throws Exception {
        // Arrange
        String givenString = "test123";
        activity.editText.setText(givenString);

        // Act
        activity.editText.onEditorAction(EditorInfo.IME_ACTION_DONE);

        // Assert
        String actualString = activity.textView.getText().toString();
        assertEquals(givenString, actualString);
    }

    @Test
    public void spinnerUpdatesBackgroundColor() throws Exception {
        // Arrange
        int index = 2;
        int givenColor = Color.GREEN;

        // Act
        activity.colorSpinner.setSelection(index);

        // Assert
        int actualColor = ((ColorDrawable)activity.linearLayout.getBackground()).getColor();
        assertEquals(givenColor, actualColor);
    }

    @Test
    public void buttonLaunchesOtherActivity() throws Exception {
        // Arrange
        Class clazz = OtherActivity.class;
        Intent expectedIntent = new Intent(activity, clazz);

        // Act
        activity.launchActivityButton.callOnClick();

        // Assert
        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
//        assertEquals(expectedIntent, actualIntent);
//      above assertion doesn't pass due to extra space in the expected intent, so not equal

        assertTrue(expectedIntent.filterEquals(actualIntent));
        // This assertion passes, cause using the filterEquals method of the Intent class
        // lets us ignore the small differences and instead tells us if the two intents are
        // equivalent from a functional standpoint
    }
}