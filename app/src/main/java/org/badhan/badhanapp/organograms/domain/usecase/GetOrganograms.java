package org.badhan.badhanapp.organograms.domain.usecase;

import org.badhan.badhanapp.UseCase;
import org.badhan.badhanapp.data.source.OrganogramsDataSource;
import org.badhan.badhanapp.data.source.OrganogramsRepository;
import org.badhan.badhanapp.organograms.domain.model.Organogram;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class GetOrganograms extends UseCase<GetOrganograms.RequestValues, GetOrganograms.ResponseValue> {

    private final OrganogramsRepository organogramsRepository;

    public GetOrganograms(OrganogramsRepository organogramsRepository){
        this.organogramsRepository = checkNotNull(organogramsRepository);
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        organogramsRepository.getOrganograms(new OrganogramsDataSource.LoadOrganogramsCallback() {
            @Override
            public void onSuccess(List<Organogram> organograms) {
                ResponseValue responseValue = new ResponseValue(organograms);
                getUseCaseCallback().onSuccess(responseValue);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    public static final class RequestValues implements UseCase.RequestValues{

    }

    public static final class ResponseValue implements UseCase.ResponseValue{
        private final List<Organogram> organograms;

        public ResponseValue(List<Organogram> organograms){
            this.organograms = checkNotNull(organograms);
        }

        public List<Organogram> getOrganograms(){
            return organograms;
        }
    }
}
