package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room Number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (DD/MM/YYYY): ");
            Date checkin = df.parse(sc.next());
            System.out.print("Check-out date (DD/MM/YYYY): ");
            Date checkout = df.parse(sc.next());

            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkin = df.parse(sc.next());
            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkout = df.parse(sc.next());

            reservation.updateDates(checkin, checkout);
            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException e) {
            System.out.println("Invalid date format");
        }
        catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error.");
        }
    }
}

