package com.example.neesrine.myapplication;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by Neesrine on 15/04/2020.
 */

public class Earthquake {
 Scanner SC =new Scanner(System.in);
    /*Float**/ String Puissance;
    String Position;
        String date ;
    public Earthquake()
    {
        setEarthquake();
    }

    private void setEarthquake() {
        this.Puissance= SC.toString()/*nextFloat()*/;
        this.Position  = SC.toString();
        this.date=SC.toString();

    }
    public Earthquake getEarthquake()
    {
       return (this);
    }
    public Earthquake(/*Float*/String Puissance , String Position , String date)
        {
            this.Puissance=Puissance;
            this.Position =Position;
            this.date=date;
        }


    public void Earthquake(/*Float*/String Puissance , String Position , String date)
    {
        this.Puissance=Puissance;
        this.Position =Position;
        this.date=date;
    }
    public String getPuissance()
    {
        return this.Puissance ;
    }
    public String getPosition()
    {
      return this.Position ;
      }
    public String getDate()
    {
     return  this.date;
    }
    public Long getDecimal ()
    {
        return Long.valueOf( 0 )/*etPuissance()*/;
    }
    public Date getDATE ()
    {
        return (Date)getDATE();
    }
}
