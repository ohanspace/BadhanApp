package org.badhan.badhanapp.OrganogramDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.badhan.badhanapp.R;

public class OrganogramDetailActivity extends AppCompatActivity {
    public static final String EXTRA_ORGANOGRAM_ID = "ORGANOGRAM_ID";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.organogram_detail_activity);
    }
}
