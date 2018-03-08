package org.badhan.badhanapp.data.source;

import org.badhan.badhanapp.UseCaseHandler;
import org.badhan.badhanapp.organograms.domain.model.Organogram;

import java.util.ArrayList;
import java.util.List;

public class OrganogramsRepository implements OrganogramsDataSource {

    private static OrganogramsRepository INSTANCE = null;

    private OrganogramsRepository(){

    }

    public static OrganogramsRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new OrganogramsRepository();
        }

        return INSTANCE;
    }


    @Override
    public void getOrganograms(LoadOrganogramsCallback callback) {
        List<Organogram> organograms =  new ArrayList<Organogram>();
        organograms.add(new Organogram("buet", "BUET zone"));
        organograms.add(new Organogram("du", "DU zone"));
        organograms.add(new Organogram("eden", "eden zone"));
        callback.onSuccess(organograms);
    }


}
