package com.teamtreehouse.testingbase;

import android.view.inputmethod.EditorInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    MainActivity activity;

    @Before
    public void setUp() throws Exception {
//        activity = new MainActivity();
//        activity.onCreate(null);
    }

    @Test
    public void editTextUpdatesTextView() throws Exception {
//        // Arrange
//        String givenString = "test123";
//        activity.editText.setText(givenString);
//
//        // Act
//        activity.editText.onEditorAction(EditorInfo.IME_ACTION_DONE);
//
//        // Assert
//        String actualString = activity.textView.getText().toString();
//        assertEquals(givenString, actualString);
    }
}