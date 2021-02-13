//package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry
{
    private String swimLocation;

    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String swimLocation)
    {
        super (EnumExerciseType.Swimming, n, d, m, y, h, min, s, dist);

        this.swimLocation = swimLocation;
    }   //Constructor

    public String getWhere ()
    {
        return swimLocation;
    } //getWhere

    @Override
    public String getEntry()
    {
        String result = getName() + " swam " + distance + "km " + swimLocation + " in "
                +getHour()+":"+getMin()+":"+ getSec()
                + " on " +getDay()+"/"+getMonth()+"/"+getYear() + ".\n";
        return result;
    } //getEntry


}
