package com.example.neesrine.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Neesrine on 15/04/2020.
 */

public class EarthquakeAdapter extends ArrayAdapter <Earthquake>{

    public EarthquakeAdapter(@NonNull EarthquakeActivity context, @NonNull ArrayList<Earthquake> objects) {
        super(context,0,objects);


    }

    @NonNull
    @Override
    public View getView(int position,  @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

    if(listItemView==null)
        {

            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_liste, parent, false);
        }




                // Get the {@link Word} object located at this position in the list
                Earthquake currentEartQ = getItem(position);
    //long positonL= currentEartQ.

        TextView TVPuis;
        TVPuis = (TextView) listItemView.findViewById( R.id.idPuissance );

        //        TVPuis.setText( new DecimalFormat("#.00").format(currentEartQ.getPuissance()));
        TVPuis.setText( currentEartQ.getPuissance());

        TextView TvDres =
                TvDres =listItemView.findViewById( R.id.idAdresse);

        TvDres.setText( currentEartQ.getPosition() );

        TextView TvDate =
                TvDate = (TextView) listItemView.findViewById( R.id.idDate );


        TvDate.setText(currentEartQ.getDate() );

        return  listItemView;
    }
}
