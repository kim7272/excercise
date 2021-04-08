package week02;

import java.util.ArrayList;
import java.util.List;

public class Office {

    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom){
        meetingRooms.add(meetingRoom);
    }

    public void printNames(){
        for (MeetingRoom meetingRoom : meetingRooms){
            System.out.println(meetingRoom.getName());
        }
    }

    public void printNamesReverse(){
        for (int i = meetingRooms.size() -1; i >= 0; i--){
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printEventNames(){
        for (int i = 1; i < meetingRooms.size(); i = i+2){
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printAreas(){
        for (MeetingRoom meetingRoom : meetingRooms){
            System.out.println(meetingRoom.getArea() + " " + meetingRoom.getLength() + " " + meetingRoom.getWidth());
        }
    }

    public void printMeetingRoomsWithName(String name){
        for (MeetingRoom meetingRoom : meetingRooms){
            if (meetingRoom.getName().equals(name)) {
                System.out.println(meetingRoom.getLength());
                System.out.println(meetingRoom.getWidth());
                System.out.println(meetingRoom.getArea());
            }
        }
    }

    public void printMeetingRoomsContains(String part){
        for (MeetingRoom meetingRoom : meetingRooms){
            if (meetingRoom.getName().toLowerCase().contains(part.toLowerCase())) {
                System.out.println(meetingRoom.getLength());
                System.out.println(meetingRoom.getWidth());
                System.out.println(meetingRoom.getArea());
            }
        }
    }

    public void printAreasLargerThan(int area) {
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getArea() > area){
                System.out.println(meetingRoom.getName() + " " + meetingRoom.getArea() + " " + meetingRoom.getLength() + " " + meetingRoom.getWidth());
            }
        }
    }
}


