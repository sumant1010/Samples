package com.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;

/*
 * Problem Statement Using any preferred language 
 * create a method which will read the strArr parameter 
 * being passed which will represent a full day 
 * and will be filled with events that span from time X to time Y in the day.
 * The format of each event will be hh:mm AM/PM- hh:mm AM/PM. 
 * For example, strArr may be ["10:00 AM-12:30 PM","02:00 PM-02:45 PM","09:10 AM-09:50 AM"]. 
 * Your program will have to output the longest amount of free time available 
 * between the start of your first event and the end of your last event in the format: hh:mm. 
 * The start event should be the earliest event in the day 
 * and the latest event should be the latest event in the day. 
 * The output for the previous input would therefore be 01:30 
 * (with the earliest event in the day starting at 09:10 AM and the latest event ending at 02:45 PM). 
 * The input will contain at least 3 events and the events may be out of order.  
 *  
 */

public class FreeTimeFinderUpdated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] eventTimes = new String[args.length];
		
		eventTimes = args[0].split(",");
		Event[] events = new Event[eventTimes.length];
		
		/* Format for finding time for 24 hour clock */
		SimpleDateFormat date12Format = new SimpleDateFormat("hh:mm a");
	    SimpleDateFormat date24Format = new SimpleDateFormat("HH:mm");
	    
	    //System.out.println(date24Format.format(date12Format.parse(time)));
		for(int i=0;i<eventTimes.length;i++) {
			
			String startTime = eventTimes[i].split("-")[0];
			String endTime = eventTimes[i].split("-")[1];
			
			//System.out.println("Start Time: "+eventTimes[i].split("-")[0]);
			//System.out.println("End Time: "+eventTimes[i].split("-")[1]);
			try {
			
			//System.out.println("Start Time 24 Hour: "+date24Format.format(date12Format.parse(startTime)));
			//System.out.println("End Time 24 Hour: "+date24Format.format(date12Format.parse(endTime)));
			
			/* Time conversions & Hours and Minutes separations */
			int startHour = Integer.parseInt(date24Format.format(date12Format.parse(startTime)).toString().split(":")[0].toString());
			int startMin = Integer.parseInt(date24Format.format(date12Format.parse(startTime)).toString().split(":")[1].toString());
			int endHour = Integer.parseInt(date24Format.format(date12Format.parse(endTime)).toString().split(":")[0].toString());
			int endMin = Integer.parseInt(date24Format.format(date12Format.parse(endTime)).toString().split(":")[1].toString());
			
			//System.out.println("Diff 24 Hour: "+(endHour-startHour) + ":" + (endMin - startMin));
			
			/* Using Event Class for keeping required times in minutes */
			events[i] = new Event();
			events[i].startTimeinMins = startHour * 60 + startMin;
			events[i].endTimeinMins = endHour * 60 + endMin;
			events[i].eventTimeinMins = events[i].endTimeinMins - events[i].startTimeinMins;
			
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		int[] eventStartTimes = new int[events.length];
		int[] eventEndTimes = new int[events.length];
		int totalTimeOccupiedInMins = 0;
		for (int j=0;j<events.length;j++) {
			eventStartTimes[j] = events[j].startTimeinMins;
			eventEndTimes[j] = events[j].endTimeinMins;
			totalTimeOccupiedInMins += events[j].eventTimeinMins;
		}
		
		/* This is to sort events based on Start Time */
		Arrays.sort(events, new Comparator<Event>() {
	        @Override
	        public int compare(Event e1, Event e2) {
	            return e1.compareTo(e2);
	        }
	    });
		
		/* This is to compare times and find the longest available free time */
		int longestFreeTimeInMins = 0;	
		for(int k=0;k<events.length-2;k++) {
			if((events[k+1].startTimeinMins - events[k].endTimeinMins) > (events[k+2].startTimeinMins - events[k+1].endTimeinMins)){
				longestFreeTimeInMins = (events[k+1].startTimeinMins - events[k].endTimeinMins);
			}
			else {
				longestFreeTimeInMins = (events[k+2].startTimeinMins - events[k+1].endTimeinMins);
			}
		}
		System.out.println("Longest Free Time: " + (longestFreeTimeInMins)/60 + ":" + (longestFreeTimeInMins)%60);
	}

}

/* Event class makes use of comparable interface for comparison */
class Event implements Comparable<Event> {
	public int startTimeinMins = 0;
	public int endTimeinMins = 0;	
	public int eventTimeinMins = 0;
	
	@Override
	public int compareTo(Event e) {
		return this.startTimeinMins - e.startTimeinMins;
	}
}

/* 
 * For Execution in Eclipse, I have set Arguments in Run Configuration as:
 * "10:00 AM-12:30 PM","02:00 PM-02:45 PM","09:10 AM-09:50 AM"
 * 
 * Good Luck!
 * */