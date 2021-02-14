//package com.stir.cscu9t4practical1;

public class InputChecker
{
    private String isNameSafe(String nameToCheck)
    {
        String result = "";

        if (!checkStringIsntEmpty(nameToCheck))
        {
            result = "Please check that you have put a valid entry in the Name field.\n";
        }

        return result;
    }//isNameSafe

    private String isDaySafe(String dayToCheck)
    {
        String result = "";

        if (!isIntSafe(dayToCheck, 1, 31))
        {
            result = "Please check that you have put a valid entry in the Day field.\n";
        }

        return result;
    }   //isDaySafe

    private String isMonthSafe(String monthToCheck)
    {
        String result = "";

        if (!isIntSafe(monthToCheck, 1, 12))
        {
            result = "Please check that you have put a valid entry in the Month field.\n";
        }

        return result;
    }

    private String isYearSafe(String yearToCheck)
    {
        String result = "";

        if (!isIntSafe(yearToCheck, 1, 99999))
        {
            result = "Please check that you have put a valid entry in the Year field.\n";
        }

        return result;
    }

    private String isHourSafe(String hourToCheck)
    {
        String result = "";

        if (!isIntSafe(hourToCheck, 0, 23))
        {
            result = "Please check that you have put a valid entry in the Hour field.\n";
        }

        return result;
    }

    private String isMinuteSafe(String minuteToCheck)
    {
        String result = "";

        if (!isIntSafe(minuteToCheck, 0, 59))
        {
            result = "Please check that you have put a valid entry in the Minute field.\n";
        }

        return result;
    }

    private String isSecondSafe(String secondToCheck)
    {
        String result = "";

        if (!isIntSafe(secondToCheck, 0, 59))
        {
            result = "Please check that you have put a valid entry in the Seconds field.\n";
        }

        return result;
    }

    private String isDistanceSafe(String distanceToCheck)
    {
        String result = "";

        if (!isStringAFloat(distanceToCheck))
        {
            result = "Please check that you have put a valid entry in the Distance field.\n";
        }

        return result;
    }

    private String isCyclingSurfaceTypeSafe(String surfaceToCheck)
    {
        String result = "";

        if (!checkStringIsntEmpty(surfaceToCheck))
        {
            result = "Please check that you have put a valid entry in the Surface Type field.\n";
        }

        return result;
    }

    private String isCyclingRouteDifficultySafe(String routeToCheck)
    {
        String result = "";

        if (!checkStringIsntEmpty(routeToCheck))
        {
            result = "Please check that you have put a valid entry in the Route Difficulty field.\n";
        }

        return result;
    }

    private String isSprintingRepetitionsSafe(String repsToCheck)
    {
        String result = "";

        if (!isIntSafe(repsToCheck, 1, 99999))
        {
            result = "Please check that you have put a valid entry in the Repetitions field.\n";
        }

        return result;
    }

    private String isSprintingRecoverySafe(String recoveryToCheck)
    {
        String result = "";

        if (!isIntSafe(recoveryToCheck, 1, 99999))
        {
            result = "Please check that you have put a valid entry in the Recovery field.\n";
        }

        return result;
    }

    private String isSwimmingLocationSafe(String swimmingLocationToCheck)
    {
        String result = "";

        if (!checkStringIsntEmpty(swimmingLocationToCheck))
        {
            result = "Please check that you have put a valid entry in the Location field.\n";
        }

        return result;
    }

    public String isDateInputSafe(String day, String month, String year)
    {
        String result = "";

        result += isDaySafe(day);

        result += isMonthSafe(month);

        result += isYearSafe(year);

        return result;
    }   //isDateInputSafe

    public String isNameAndDateInputSafe(String name, String day, String month, String year)
    {
        String result = "";

        result += isDateInputSafe(day, month, year);

        result += isNameSafe(name);

        return result;
    }

    public String isInputSafe(EnumExerciseType exerciseType, String name, String day, String month, String year, String hours, String minutes, String seconds, String distance, String cyclingSurfaceType, String cyclingRouteDifficulty, String sprintingRepetitions, String sprintingRecovery, String swimmingLocation)
    {
        String result = "";

        result += isNameSafe(name);

        result += isDateInputSafe(day, month, year);

        result += isHourSafe(hours);

        result += isMinuteSafe(minutes);

        result += isSecondSafe(seconds);

        result += isDistanceSafe(distance);

        if (exerciseType.equals(EnumExerciseType.Cycling))
        {
            result += isCyclingRouteDifficultySafe(cyclingRouteDifficulty);

            result += isCyclingSurfaceTypeSafe(cyclingSurfaceType);
        }
        else if (exerciseType.equals(EnumExerciseType.Running))
        {
            result += isSprintingRepetitionsSafe(sprintingRepetitions);

            result += isSprintingRecoverySafe(sprintingRecovery);
        }
        else
        {
            result += isSwimmingLocationSafe(swimmingLocation);
        }

        return result;
    }   //isInputSafe

    private boolean isIntSafe(String intToCheck, int minIntValue, int maxIntValue)
    {
        boolean result;
        int intValue;

        result = isStringAnInt(intToCheck);

        if(result)
        {
            intValue = Integer.parseInt(intToCheck);

            if (intValue > maxIntValue || intValue < minIntValue)
            {
                result = false;
            }
        }

        return result;
    }//isIntSafe

    private boolean isStringAnInt(String isThisAnInt)
    {
        boolean result = checkStringIsntEmpty(isThisAnInt);

        try
        {
            float attemptedInt = Integer.parseInt(isThisAnInt);
        }
        catch (NumberFormatException numberFormatException)
        {
            result = false;
        }

        return result;
    }   //isStringAnInt

    private boolean isStringAFloat(String isThisAFloat)
    {
        boolean result = checkStringIsntEmpty(isThisAFloat);

        try
        {
            float attemptedFloat = Float.parseFloat(isThisAFloat);
        }
        catch (NumberFormatException numberFormatException)
        {
            result = false;
        }

        return result;
    }   //isStringAFloat

    private boolean checkStringIsntEmpty(String stringToCheck)
    {
        boolean result = true;

        if (stringToCheck.equals(""))
        {
            result = false;
        }

        return result;
    }   //checkStringIsntEmpty
}
