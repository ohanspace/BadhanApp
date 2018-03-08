package org.badhan.badhanapp.organograms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.badhan.badhanapp.R;
import org.badhan.badhanapp.organograms.domain.model.Organogram;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;


public class OrganogramsAdapter extends BaseAdapter {
    private List<Organogram> organograms;

    public OrganogramsAdapter(List<Organogram> organograms){
        setList(organograms);
    }

    private void setList(List<Organogram> organograms){
        this.organograms = checkNotNull(organograms);
    }

    public void replaceData(List<Organogram> organograms){
        setList(organograms);
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return organograms.size();
    }

    @Override
    public Organogram getItem(int i) {
        return organograms.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = view;
        if (rowView == null){
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            rowView = inflater.inflate(R.layout.organogram_item, viewGroup, false);
        }

        final Organogram organogram = getItem(i);

        TextView nameTV = rowView.findViewById(R.id.organogram_name);
        nameTV.setText(organogram.getName());

        return rowView;
    }
}
