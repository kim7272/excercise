package week02;

import java.util.Scanner;

public class Controller {

    private Office office = new Office();

    Scanner scanner = new Scanner(System.in);


    public void readOffice(){

        System.out.println("How many meeting rooms you need?");
        int number = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i < number + 1; i++){
            System.out.println("Give me the name of the " + i + ". meeting room!");
            String name = scanner.nextLine();
            System.out.println("Give me the length of the " + i + ". meeting room!");
            int length = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Give me the width of the " + i + ". meeting room!");
            int width = scanner.nextInt();
            scanner.nextLine();
            MeetingRoom meetingRoom = new MeetingRoom(name, length, width);
            office.addMeetingRoom(meetingRoom);
        }

    }

    public void printMenu() {
        System.out.println("1. Tárgyalók sorrendben");
        System.out.println("2. Tárgyalók visszafele sorrendben");
        System.out.println("3. Minden második tárgyaló");
        System.out.println("4. Területek");
        System.out.println("5. Keresés pontos név alapján");
        System.out.println("6. Keresés névtöredék alapján");
        System.out.println("7. Keresés terület alapján");
    }

    public void runMenu() {

        System.out.println("Give me the menupoint!");
        int i = scanner.nextInt();
        scanner.nextLine();
        if (i == 1){
            office.printNames();
        }
        else if (i == 2){
            office.printNamesReverse();
        }
        else if (i == 3){
            office.printEventNames();
        }
        else if (i == 4){
            office.printAreas();
        }
        else if (i == 5){
            System.out.println("Give me the name of the meeting room!");
            String name = scanner.nextLine();
            office.printMeetingRoomsWithName(name);
        }
        else if (i == 6){
            System.out.println("Give me the part of the name of the meeting room!");
            String part = scanner.nextLine();
            office.printMeetingRoomsContains(part);
        }
        else if (i == 7){
            System.out.println("Give me the area!");
            int area = scanner.nextInt();
            scanner.nextLine();
            office.printAreasLargerThan(area);
        }


    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.readOffice();
        controller.printMenu();
        controller.runMenu();
    }
}
