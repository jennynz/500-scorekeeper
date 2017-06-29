package com.jennynz.android.a500scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity {

    int teamA = 0;
    int teamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void incrementA(View view) {
        updateScore("A");
    }

    public void incrementB(View view) {
        updateScore("B");
    }

    public void reset(View view) {
        teamA = 0;
        teamB = 0;
        TextView scoreTextViewA = (TextView) findViewById(R.id.teamA_score);
        scoreTextViewA.setText(Integer.toString(teamA));
        TextView scoreTextViewB = (TextView) findViewById(R.id.teamB_score);
        scoreTextViewB.setText(Integer.toString(teamB));
    }

    private void updateScore(String team) {
        int inputId;
        int scoreId;

        if (team.equals("A")) {
            inputId = R.id.teamA_input;
            scoreId = R.id.teamA_score;
        } else {
            inputId = R.id.teamB_input;
            scoreId = R.id.teamB_score;
        }

        // Get input view
        TextView inputTextView = (TextView) findViewById(inputId);

        // Convert input text to string
        String inputString = inputTextView.getText().toString();

        // Validate that input is not empty
        if (isEmpty(inputString)) {
            return;
        }

        // Convert input string to integer
        int inputValue = Integer.parseInt(inputString);

        // Update score
        if (team.equals("A")) {
            teamA = teamA + inputValue;
        } else {
            teamB = teamB + inputValue;
        }

        // Get score view and update score
        TextView scoreTextView = (TextView) findViewById(scoreId);
        if (team.equals("A")) {
            scoreTextView.setText(Integer.toString(teamA));
        } else {
            scoreTextView.setText(Integer.toString(teamB));
        }

        // Empty input field
        inputTextView.setText("");
    }

}
