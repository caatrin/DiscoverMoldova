package com.caatrin.discovermoldova;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.caatrin.discovermoldova.fragments.EventsUpcomingDetailsFragment;

public class EventsUpcomingDetailsActivity extends AppCompatActivity {

    public static final String ARG_TITLE = "title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);


        String key = getIntent().getStringExtra(EventsUpcomingDetailsFragment.ARG_KEY);
        String title = getIntent().getStringExtra(ARG_TITLE);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        if (key != null) {
            Bundle bundle = new Bundle();
            bundle.putString(EventsUpcomingDetailsFragment.ARG_KEY, key);
            Fragment fragment = EventsUpcomingDetailsFragment.newInstance(bundle);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment,fragment)
                    .commit();
        } else {
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return false;
        }
        return super.onOptionsItemSelected(item);
    }

}
