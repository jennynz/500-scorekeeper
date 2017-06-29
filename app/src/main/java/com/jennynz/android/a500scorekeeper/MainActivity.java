package com.jennynz.android.a500scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int teamA = 0;
    int teamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void updateA(View view) {

        // Get input view
        TextView inputTextView = (TextView) findViewById(R.id.teamA_input);

        // Convert input score to int
        String inputString = inputTextView.getText().toString();
        int inputValue = Integer.parseInt(inputString);

        // Update score
        teamA = teamA + inputValue;

        // Get score view and update score
        TextView scoreTextView = (TextView) findViewById(R.id.teamA_score);
        scoreTextView.setText(Integer.toString(teamA));

        // Empty input field
        inputTextView.setText("");
    }

    public void updateB(View view) {

        // Get input view
        TextView inputTextView = (TextView) findViewById(R.id.teamB_input);

        // Convert input score to int
        String inputString = inputTextView.getText().toString();
        int inputValue = Integer.parseInt(inputString);

        // Update score
        teamB = teamB + inputValue;

        // Get score view and update score
        TextView scoreTextView = (TextView) findViewById(R.id.teamB_score);
        scoreTextView.setText(Integer.toString(teamB));

        // Empty input field
        inputTextView.setText("");
    }

    public void reset(View view) {
        teamA = 0;
        teamB = 0;
        TextView scoreTextViewA = (TextView) findViewById(R.id.teamA_score);
        scoreTextViewA.setText(Integer.toString(teamA));
        TextView scoreTextViewB = (TextView) findViewById(R.id.teamB_score);
        scoreTextViewB.setText(Integer.toString(teamB));
    }

}
