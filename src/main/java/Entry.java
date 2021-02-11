// This class holds information about a single training session
//package com.stir.cscu9t4practical1;

import java.util.Calendar;
public class Entry {
  private String name;
  private Calendar dateAndTime;
  private float distance;
  private String uniqueIdentifier;
  private EnumExerciseType exerciseType;
  
  public Entry (EnumExerciseType exType, String n, int d, int m, int y, int h, int min, int s, float dist) {
    name = n;
    Calendar inst = Calendar.getInstance();
    inst.set(y,m-1,d,h,min,s);
    dateAndTime = inst;
    distance = dist;
    uniqueIdentifier = n + d + m + y;
    exerciseType = exType;
  } //constructor
  
  public String getName () {
    return name;
  } //getName
  
  public int getDay () {
    return dateAndTime.get(Calendar.DATE);
  } //getDay
  
  public int getMonth () {
    int month =  dateAndTime.get(Calendar.MONTH) + 1;
    return month;
  } //getMonth
  
  public int getYear () {
    return dateAndTime.get(Calendar.YEAR);
  } //getYear

  public int getHour () {
    return dateAndTime.get(Calendar.HOUR);
  } //getHour

  public int getMin () {
    return dateAndTime.get(Calendar.MINUTE);
  } //getMin

  public int getSec () {
    return dateAndTime.get(Calendar.SECOND);
  } //getSec

  public float getDistance () {
    return distance;
  } //getYear

  public String getEntry () {
   String result = getName()+" " + appropriatePastTenseExerciseVerb() + " " + getDistance() + " km in "
             +getHour()+":"+getMin()+":"+ getSec() + " on "
             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
   return result;
  } //getEntry

  private String appropriatePastTenseExerciseVerb()
  {
    String result;

    if (exerciseType == EnumExerciseType.Cycling)
    {
      result = "cycled";
    }
    else if (exerciseType == EnumExerciseType.Running)
    {
      result = "ran";
    }
    else
    {
      result = "swam";
    }

    return result;
  } //appropriateExerciseVerb


  public String getUniqueIdentifier() { return uniqueIdentifier; }  //getUniqueIdentifier

  public String getTempo ()
  {
    return "Not Implemented Yet!";
  } //getTempo


   
} // Entry