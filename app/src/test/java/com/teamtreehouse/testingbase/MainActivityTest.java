package com.teamtreehouse.testingbase;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.inputmethod.EditorInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

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
        int expectedColor = ((ColorDrawable)activity.linearLayout.getBackground()).getColor();
        assertEquals(givenColor, expectedColor);
    }
}