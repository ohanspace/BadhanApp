package org.badhan.badhanapp.data.source;

import org.badhan.badhanapp.organograms.domain.model.Organogram;

import java.util.List;

public interface OrganogramsDataSource {

    void getOrganograms(LoadOrganogramsCallback callback);

    interface LoadOrganogramsCallback{

        void onSuccess(List<Organogram> organograms);

        void onDataNotAvailable();
    }
}
