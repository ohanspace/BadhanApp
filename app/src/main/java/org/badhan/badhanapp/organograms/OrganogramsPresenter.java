package org.badhan.badhanapp.organograms;

import org.badhan.badhanapp.UseCase;
import org.badhan.badhanapp.UseCaseHandler;
import org.badhan.badhanapp.organograms.domain.model.Organogram;
import org.badhan.badhanapp.organograms.domain.usecase.GetOrganograms;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class OrganogramsPresenter implements OrganogramsContract.Presenter {
    private final UseCaseHandler useCaseHandler;
    private final OrganogramsContract.View organogramsView;
    private final GetOrganograms getOrganograms;


    public OrganogramsPresenter(UseCaseHandler useCaseHandler,
                                OrganogramsContract.View organogramsView,
                                GetOrganograms getOrganograms){
        this.useCaseHandler = checkNotNull(useCaseHandler, "use case handler cant be null");
        this.organogramsView = checkNotNull(organogramsView, "organogramsView cant be null");
        this.getOrganograms = checkNotNull(getOrganograms, "getOrganograms cant be null");

        this.organogramsView.setPresenter(this);

    }
    @Override
    public void start() {
        loadOrganograms();
    }

    private void loadOrganograms() {
        GetOrganograms.RequestValues requestValues = new GetOrganograms.RequestValues();

        useCaseHandler.execute(getOrganograms, requestValues,
                new UseCase.UseCaseCallback<GetOrganograms.ResponseValue>() {
            @Override
            public void onSuccess(GetOrganograms.ResponseValue response) {
                List<Organogram> organograms = response.getOrganograms();
                organogramsView.showOrganograms(organograms);
            }

            @Override
            public void onError() {

            }
        });
    }


}
