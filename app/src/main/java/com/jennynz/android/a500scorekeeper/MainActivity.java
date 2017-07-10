package com.jennynz.android.a500scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.text.TextUtils.isEmpty;

// Add to About page:
// Playing card icons by Carin Marzaro from the Noun Project

public class MainActivity extends AppCompatActivity {

    int teamA = 0;
    int teamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Catch "DONE" action buttons on numeric inputs
        EditText editTextA = (EditText) findViewById(R.id.teamA_input);
        editTextA.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    updateScore("A");
                    return true;
                }
                return false;
            }
        });

        EditText editTextB = (EditText) findViewById(R.id.teamB_input);
        editTextB.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    updateScore("B");
                    return true;
                }
                return false;
            }
        });
    }

    // Options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.reset:
                reset();
                return true;
            case R.id.help:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void incrementA(View view) {
        updateScore("A");
    }

    public void incrementB(View view) {
        updateScore("B");
    }

    private void reset() {
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

        // Check that no one's won yet
        if ((teamA > 500) || (teamB > 50gt s0)) {
            Toast.makeText(
                    getApplicationContext(),
                    "Looks like the game's already over... Click the options menu to reset.",
                    Toast.LENGTH_SHORT
            ).show();
            inputTextView.setText("");
            return;
        }

        // Convert input string to integer
        int inputValue = Integer.parseInt(inputString);

        // Validate that the input is less than or equal to the maximum possible score (520)
        if (inputValue > 520) {
            Toast.makeText(
                    getApplicationContext(),
                    "Woah, that's a lot of points!",
                    Toast.LENGTH_SHORT
            ).show();
            inputTextView.setText("");
            return;
        }

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
