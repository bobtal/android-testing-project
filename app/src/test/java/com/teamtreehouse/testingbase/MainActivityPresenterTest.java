package com.teamtreehouse.testingbase;

import android.graphics.Color;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {

    MainActivityPresenter presenter;

    @Mock
    MainActivityView view;

    // without Mockito
//    class MockedView implements MainActivityView {
//        String textViewText;
//
//        @Override
//        public void changeTextViewText(String text) {
//            textViewText = text;
//        }
//
//        @Override
//        public void changeBackgroundColor(int color) {
//
//        }
//
//        @Override
//        public void launchOtherActivity(Class activity) {
//
//        }
//    }

    @Before
    public void setUp() throws Exception {
//        view = new MockedView(); without Mockito
        presenter = new MainActivityPresenter(view);
    }

    @Test
    public void editTextUpdated() throws Exception {
        // Arrange
        String givenString = "test123";

        // Act
        presenter.editTextUpdated(givenString);

        // Assert
//        assertEquals(givenString, ((MockedView)view).textViewText); without Mockito
        Mockito.verify(view).changeTextViewText(givenString);
    }

    @Test
    public void colorSelected() throws Exception {
        // Arrange
        int index = 2;
        int givenColor = Color.GREEN;

        // Act
        presenter.colorSelected(index);

        // Assert
        Mockito.verify(view).changeBackgroundColor(givenColor);
    }

    @Test
    public void launchOtherActivityButtonClicked() throws Exception {
        // Arrange
        Class clazz = OtherActivity.class;

        // Act
        presenter.launchOtherActivityButtonClicked(clazz);

        // Assert
        Mockito.verify(view).launchOtherActivity(clazz);
    }

}