package org.badhan.badhanapp.organograms;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.badhan.badhanapp.Injection;
import org.badhan.badhanapp.R;
import org.badhan.badhanapp.util.ActivityUtils;

public class OrganogramsActivity extends AppCompatActivity {

    private OrganogramsPresenter organogramsPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organograms_activity);

        //attach fragment to the contentFrame
        OrganogramsFragment organogramsFragment =
                (OrganogramsFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (organogramsFragment == null){
            //create the fragment
            organogramsFragment = OrganogramsFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), organogramsFragment, R.id.contentFrame);
        }

        //create the presenter
        organogramsPresenter = new OrganogramsPresenter(
                Injection.provideUseCaseHandler(),
                organogramsFragment,
                Injection.provideGetOrganograms()
        );



    }
}
