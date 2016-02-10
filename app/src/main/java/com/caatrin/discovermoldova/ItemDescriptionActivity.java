package com.caatrin.discovermoldova;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.caatrin.discovermoldova.fragments.ItemDescriptionFragment;

public class ItemDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);

        Bundle bundle = getIntent().getBundleExtra(ItemDescriptionFragment.ARG_BUNDLE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(bundle.getString(ItemDescriptionFragment.ARG_TITLE));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        if(bundle != null) {
            Fragment fragment = ItemDescriptionFragment.newInstance(bundle);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment,fragment)
                    .commit();
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
                return false;
        }
        return super.onOptionsItemSelected(item);
    }


}
