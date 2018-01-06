package com.teamtreehouse.testingbase;

// This interface will have one method for every action we can take on our view
public interface MainActivityView {
    void changeTextViewText(String text);
    void changeBackgroundColor(int color);
    void launchOtherActivity(Class activity);
}
