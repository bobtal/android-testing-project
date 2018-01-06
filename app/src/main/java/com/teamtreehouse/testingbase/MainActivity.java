package com.teamtreehouse.testingbase;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainActivityView {
    LinearLayout linearLayout;
    EditText editText;
    TextView textView;
    Spinner colorSpinner;
    Button launchActivityButton;

    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this);

        // Initialize views
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        colorSpinner = (Spinner) findViewById(R.id.colorSpinner);
        launchActivityButton = (Button) findViewById(R.id.launchActivityButton);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        // Setup Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.colors_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(adapter);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView tv, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String text = tv.getText().toString();
//                    textView.setText(text);
                    presenter.editTextUpdated(text);
                }
                return false;
            }
        });

        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int index, long id) {
//                switch (index) {
//                    case 0:
//                        linearLayout.setBackgroundColor(Color.WHITE);
//                        break;
//                    case 1:
//                        linearLayout.setBackgroundColor(Color.MAGENTA);
//                        break;
//                    case 2:
//                        linearLayout.setBackgroundColor(Color.GREEN);
//                        break;
//                    case 3:
//                        linearLayout.setBackgroundColor(Color.CYAN);
//                        break;
//                }
                presenter.colorSelected(index);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        launchActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, OtherActivity.class);
//                startActivity(intent);
                presenter.launchOtherActivityButtonClicked(OtherActivity.class);
            }
        });
    }

    @Override
    public void changeTextViewText(String text) {
        textView.setText(text);
    }

    @Override
    public void changeBackgroundColor(int color) {
        linearLayout.setBackgroundColor(color);
    }

    @Override
    public void launchOtherActivity(Class activity) {
        Intent intent = new Intent(MainActivity.this, activity);
        startActivity(intent);
    }
}
