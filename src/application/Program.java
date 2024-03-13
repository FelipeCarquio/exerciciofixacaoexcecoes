package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room Number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (DD/MM/YYYY): ");
        Date checkin = df.parse(sc.next());
        System.out.print("Check-out date (DD/MM/YYYY): ");
        Date checkout = df.parse(sc.next());

        if (!checkout.after(checkin)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkin,checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkin = df.parse(sc.next());
            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkout = df.parse(sc.next());

            Date now = new Date();
            if (checkin.before(now) || checkout.before(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates.");
            } else if (!checkout.after(checkin)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else {
                reservation.updateDates(checkin, checkout);
                System.out.println("Reservation: " + reservation);
            }
        }
    }
}
