package com.example.hands_porject;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class EventCalculation {

    private static final int EVEN_PERIOD = 4;
    private int baseEvent = 2020;
    private final String RELAX_DAY_1 = "THURSDAY";
    private final String RELAX_DAY_2 = "FRIDAY";
    private final String RELAX_DAY_3 = "SATURDAY";

    public boolean isEventYear(int year) {
        int reminder = baseEvent % EVEN_PERIOD;
        return year % EVEN_PERIOD == reminder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void countTotalEvent(int startYear, int endYear) {
        int countTotal = 0;
        int countRelaxEvent = 0;
        int temp = startYear;
        while (temp <= endYear) {
            if (isEventYear(temp)) {
                countTotal++;
                if (isRelaxEvent(temp)) {
                    countRelaxEvent++;
                }
            }
            temp++;
        }

        System.out.println("Total event: " + countTotal);
        Log.d("TTT", "Total relax start: " + countRelaxEvent);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean isRelaxEvent(int year) {
        LocalDate localDate = LocalDate.of(year, 07, 25);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        String dayName = dayOfWeek.toString();
        if (dayName == null || dayName.isEmpty()) {
            return false;
        }
        if (dayName.toUpperCase().equals(RELAX_DAY_1)
                || dayName.toUpperCase().equals(RELAX_DAY_2)
                || dayName.toUpperCase().equals(RELAX_DAY_3)) {
            return true;
        } else {
            return false;
        }
    }

}
