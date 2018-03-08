package org.badhan.badhanapp.organograms;

import org.badhan.badhanapp.BasePresenter;
import org.badhan.badhanapp.BaseView;
import org.badhan.badhanapp.organograms.domain.model.Organogram;

import java.util.List;

public interface OrganogramsContract {

    interface Presenter extends BasePresenter{

    }
    interface View extends BaseView<Presenter>{
        void showOrganograms(List<Organogram> organograms);
    }

}
