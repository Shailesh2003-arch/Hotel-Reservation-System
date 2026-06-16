import java.sql.*;
import java.util.Scanner;

import com.mysql.cj.jdbc.ConnectionGroup;

public class HotelReservationSystem {

    /*
     * Decalring private static variable for credential such as - Database URL,
     * Database Username and Database Password.
     * 
     * We declare it as 'static' because we don't want to make it's object everytime
     * we are accessing any
     * data member or call any member-function of this specific class.
     * 
     * Always remember, You must use the same Instance in every member function
     * which doesn't operate on the state of an object, so to reduce the load on the
     * entire application.
     * 
     */

    // These are the 3 required variables for our project...

    private static final String url = "jdbc:mysql://127.0.0.1:3306/HOTEL_RESERVATION";
    private static final String username = "root";
    private static final String password = "Shaill@1234";

    public static void main(String[] args) {

        // Load the driver first...
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println(con);
            Statement stmt = con.createStatement();
            while (true) {
                System.out.println();
                System.out.println("Welcome to Hotel Reservation System");
                System.out.println("1. Reserve a room");
                System.out.println("2. View Reservation");
                System.out.println("3. Get Room Number");
                System.out.println("4. Update Reservations");
                System.out.println("5. Delete Reservations");
                Scanner sc = new Scanner(System.in);
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        reserveRoom(con, sc, stmt);
                        break;
                    case 2:
                        viewReservation(con, stmt);
                        break;
                    case 3:
                        // getRoomNumber(con, sc, stmt);
                        break;
                    case 4:
                        // updateReservation(con, sc, stmt);
                        break;
                    case 5:
                        // deleteReservation(con, sc, stmt);
                        break;
                    case 0:
                        // exit();
                        sc.close();
                    default:
                        System.out.println("Invalid Choice! Try again");
                }
            }

        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            // } catch (InterruptedException e) {
            // throw new RuntimeException(e);
        }
    }

    private static void reserveRoom(Connection con, Scanner sc, Statement stmt) {
        try {
            System.out.print("Enter guest Name: ");
            String guestName = sc.next();
            System.out.print("Enter room number: ");
            int roomNumber = sc.nextInt();
            System.out.println("Enter contact number: ");
            String contact_number = sc.next();

            String query = "INSERT INTO RESERVATION (guest_name, room_number, contact_number)" + "VALUES (' "
                    + guestName + " ', " + roomNumber + ",'" + contact_number + "')";

            int rowsAffected = stmt.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println();
                System.out.println("Reservation Successful!...");
            } else {
                System.out.println("Reservation Failed!.");
            }

        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println("Failed reserving room: " + e.getMessage());
            System.out.println("Try reserving another room");
        }
    }

    private static void viewReservation(Connection con, Statement stmt) {
        String query = "Select reservation_id, guest_name, room_number, contact_number, reservation_date FROM reservation";
        try {

            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Current Reservations:");
            System.out.println(
                    "+-----------------+------------+----------------+------------------+-------------------+");
            System.out
                    .println(
                            "| Reservation ID  | Guest      | Room Number    | Contact Number    |  Reservation Date");
            System.out.println(
                    "+-----------------+------------+----------------+------------------+-------------------+");
            while (rs.next()) {
                int reservationId = rs.getInt("reservation_id");
                String guestName = rs.getString("guest_name");
                int roomNumber = rs.getInt("room_number");
                String contactNumber = rs.getString("contact_number");
                String reservationDate = rs.getString("reservation_date");

                System.out.printf("|%-15d  |%-6s  | %-14d | %-20s |%8s  |\n", reservationId,
                        guestName,
                        roomNumber, contactNumber,
                        reservationDate);
                System.out.println(
                        "+-----------------+------------+----------------+------------------+-------------------+");
            }
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println("Failed retrieving reserved room data!...");
            System.out.println(e.getMessage());
        }
    }
}
