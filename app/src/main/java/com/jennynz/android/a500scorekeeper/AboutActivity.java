package com.jennynz.android.a500scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView udacityLinkTextView =(TextView)findViewById(R.id.udacity_link);
        udacityLinkTextView.setClickable(true);
        udacityLinkTextView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='https://www.udacity.com/course/android-basics-user-input--ud836'>Udacity Android Basics: User Input</a>";
        udacityLinkTextView.setText(Html.fromHtml(text));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
