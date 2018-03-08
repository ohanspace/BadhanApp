package org.badhan.badhanapp.organograms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.badhan.badhanapp.R;
import org.badhan.badhanapp.organograms.domain.model.Organogram;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class OrganogramsFragment extends Fragment implements OrganogramsContract.View {
    private OrganogramsContract.Presenter presenter;
    private OrganogramsAdapter listAdapter;


    public OrganogramsFragment(){
        //requires empty constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Organogram> organograms = new ArrayList<Organogram>(0);
        listAdapter = new OrganogramsAdapter(organograms);
    }

    @Override
    public void setPresenter(OrganogramsContract.Presenter presenter) {
        this.presenter = checkNotNull(presenter);
    }

    public static OrganogramsFragment newInstance() {
        return new OrganogramsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.organograms_fragment, container, false);

        ListView listView = root.findViewById(R.id.organograms_list);
        listView.setAdapter(listAdapter);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void showOrganograms(List<Organogram> organograms) {
        listAdapter.replaceData(organograms);
    }
}
