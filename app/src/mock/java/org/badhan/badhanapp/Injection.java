package org.badhan.badhanapp;

import org.badhan.badhanapp.data.source.OrganogramsRepository;
import org.badhan.badhanapp.organograms.domain.usecase.GetOrganograms;

public class Injection{

    public static OrganogramsRepository provideOrganogramsRepository(){
        return OrganogramsRepository.getInstance();
    }


    public static GetOrganograms provideGetOrganograms(){
        return new GetOrganograms(OrganogramsRepository.getInstance());
    }

    public static UseCaseHandler provideUseCaseHandler(){
        return UseCaseHandler.getInstance();
    }
}

