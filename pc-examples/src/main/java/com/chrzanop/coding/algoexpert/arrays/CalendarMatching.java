package com.chrzanop.coding.algoexpert.arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CalendarMatching {


    public boolean arraysEqual(List<StringMeeting> arr1, List<StringMeeting> arr2) {
        if (arr1.size() != arr2.size()) return false;

        for (int i = 0; i < arr1.size(); i++) {
            if (!arr1.get(i).start.equals(arr2.get(i).start)
                    || !arr1.get(i).end.equals(arr2.get(i).end)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void TestCase1() {
        List<StringMeeting> calendar1 = new ArrayList<StringMeeting>();
        calendar1.add(new StringMeeting("9:00", "10:30"));
        calendar1.add(new StringMeeting("12:00", "13:00"));
        calendar1.add(new StringMeeting("16:00", "18:00"));

        StringMeeting dailyBounds1 = new StringMeeting("9:00", "20:00");

        List<StringMeeting> calendar2 = new ArrayList<StringMeeting>();
        calendar2.add(new StringMeeting("10:00", "11:30"));
        calendar2.add(new StringMeeting("12:30", "14:30"));
        calendar2.add(new StringMeeting("14:30", "15:00"));
        calendar2.add(new StringMeeting("16:00", "17:00"));

        StringMeeting dailyBounds2 = new StringMeeting("10:00", "18:30");

        int meetingDuration = 30;

        List<StringMeeting> expected = new ArrayList<StringMeeting>();
        expected.add(new StringMeeting("11:30", "12:00"));
        expected.add(new StringMeeting("15:00", "16:00"));
        expected.add(new StringMeeting("18:00", "18:30"));

        List<StringMeeting> actual =
                calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration);
        assertTrue(arraysEqual(expected, actual));
    }


    // O(c1+c2) time | O(c1+c2) space where c1 lenght of calendar 1 and c2 lenght of calendar 2
    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {

        // update calendars
        List<Meeting> calendar1Minutes = updateCalendar(calendar1, dailyBounds1);
        List<Meeting> calendar2Minutes = updateCalendar(calendar2, dailyBounds2);
        // merge calendars
        List<Meeting> mergedCalendar = mergeCalendars(calendar1Minutes, calendar2Minutes);
        // flatten
        List<Meeting> flattened = flattenCalendar(mergedCalendar);
        // find available spots matching meeting duration
        List<StringMeeting> availableSpots = getMatchingAvailabilities(flattened, meetingDuration);

        return availableSpots;
    }


    private static List<StringMeeting> getMatchingAvailabilities(List<Meeting> calendar, int meetingDuration) {
        List<Meeting> availableSpots = new ArrayList<>();
        for (int i = 1; i < calendar.size(); i++) {
            int start = calendar.get(i - 1).end;
            int end = calendar.get(i).start;
            int availabilityDuration = end - start;
            if (availabilityDuration >= meetingDuration) {
                availableSpots.add(new Meeting(start, end));
            }
        }
        List<StringMeeting> matchingAvailabilitiesInHours = new ArrayList<>();
        for (int i = 0; i < availableSpots.size(); i++) {
            matchingAvailabilitiesInHours.add(
                    new StringMeeting(
                            minutesToTime(availableSpots.get(i).start),
                            minutesToTime(availableSpots.get(i).end)
                    )
            );

        }
        return matchingAvailabilitiesInHours;
    }

    private static List<Meeting> mergeCalendars(List<Meeting> calendar1, List<Meeting> calendar2) {
        List<Meeting> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < calendar1.size() && j < calendar2.size()) {
            Meeting meeting1 = calendar1.get(i);
            Meeting meeting2 = calendar2.get(j);
            if (meeting1.start < meeting2.start) {
                merged.add(meeting1);
                i++;
            } else {
                merged.add(meeting2);
                j++;
            }
        }
        while (i < calendar1.size()) {
            merged.add(calendar1.get(i++));
        }
        while (j < calendar2.size()) {
            merged.add(calendar2.get(j++));
        }
        return merged;
    }


    private static List<Meeting> flattenCalendar(List<Meeting> calendar) {
        List<Meeting> flattened = new ArrayList<>();
        flattened.add(calendar.get(0));
        for (int i = 1; i < calendar.size(); i++) {
            Meeting currentMeeting = calendar.get(i);
            Meeting previousMeeting = flattened.get(flattened.size() - 1);
            if (previousMeeting.end >= currentMeeting.start) {
                Meeting newPreviousMeeting =
                        new Meeting(previousMeeting.start, Math.max(previousMeeting.end, currentMeeting.end));
                flattened.set(flattened.size() - 1, newPreviousMeeting);
            } else {
                flattened.add(currentMeeting);
            }
        }
        return flattened;
    }


    private static List<Meeting> updateCalendar(List<StringMeeting> calendar, StringMeeting dailyBounds) {
        List<StringMeeting> updatedCalendar = new ArrayList<StringMeeting>();
        updatedCalendar.add(new StringMeeting("0:00", dailyBounds.start));
        updatedCalendar.addAll(calendar);
        updatedCalendar.add(new StringMeeting(dailyBounds.end, "23:59"));
        List<Meeting> calendarInMinutes = new ArrayList<>();
        for (StringMeeting cal : updatedCalendar) {
            calendarInMinutes.add(
                    new Meeting(
                            timeToMinutes(cal.start),
                            timeToMinutes(cal.end)
                    ));
        }
        return calendarInMinutes;
    }

    private static int timeToMinutes(String time) {
        int delimiter = time.indexOf(":");
        int hours = Integer.parseInt(time.substring(0, delimiter));
        int minutes = Integer.parseInt(time.substring(delimiter + 1, time.length()));
        return hours * 60 + minutes;

    }

    private static String minutesToTime(int minutes) {
        int hours = minutes / 60;
        int mins = minutes % 60;
        String hourString = Integer.toString(hours);
        String minutesString = mins < 10 ? "0" + Integer.toString(mins) : Integer.toString(mins);
        return hourString + ":" + minutesString;
    }


    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Meeting {
        public int start;
        public int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
