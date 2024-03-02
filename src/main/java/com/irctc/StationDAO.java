/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.irctc;

/**
 *
 * @author santh
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StationDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/STATIONS";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "912001@Bca**";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    ResultSet resultSet = null;
     PreparedStatement statement = null;
      Connection connection = null;
  
    public List<String> getStationNames() throws SQLException {
        List<String> stationNames = new ArrayList<>();

        try {
            Class.forName(JDBC_DRIVER);
            try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 Statement st = con.createStatement()) {
                String query = "SELECT station_name, station_code FROM SBC_MAS ";
                ResultSet rs = st.executeQuery(query);

                while (rs.next()) {
                    String stationName = rs.getString("station_name");
                    String stationCode = rs.getString("station_code");
                  
                    stationNames.add(stationName);
                   
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately in a real application
        }finally {
            // Close resources in reverse order
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return stationNames;
    }
    
     
   public  Station getStationPriority(String stationName) throws SQLException {
// Initialize station here
     
   Station station = new Station();
     
       
       
    try {
            Class.forName(JDBC_DRIVER);
       connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Use parameterized query to prevent SQL injection
            String sql = "SELECT id, station_name, priority FROM SBC_MAS WHERE station_name = ?";
        statement = connection.prepareStatement(sql);
            statement.setString(1, stationName);
 resultSet = statement.executeQuery();

            if (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("station_name");
//                int priority = resultSet.getInt("priority");

               station.setId(resultSet.getInt("id"));
               station.setStationName(resultSet.getString("station_name"));
               station.setPriority(resultSet.getInt("priority"));
            } else {
                System.out.println("Station not found: " + stationName);
            }
        } catch (ClassNotFoundException e) {
            // Handle JDBC driver class not found
            e.printStackTrace();
        } finally {
            // Close resources in reverse order
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    return station;
    }

   
    

 
public List<Train> fetchTrainsFromTimetable(int fid, String timetable,String travelDate) {
    List<Train> trains = new ArrayList<>();
    long currentTimeMillis=0;
    try {
        Time time = getDepatureTime(fid, timetable);
         LocalTime currentTime = LocalTime.now();
            LocalDate currentDate = LocalDate.now();
    // Add departure time to current time


        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT DepartureTime FROM " + timetable);
             ResultSet resultSet = statement.executeQuery()) {
 while (resultSet.next()) {
              LocalDate parsedDate = LocalDate.parse(travelDate);
               if (parsedDate.equals(currentDate)) {
                Time databaseDepartureTime = resultSet.getTime("DepartureTime");
                
                LocalTime dbtime= databaseDepartureTime.toLocalTime();
                // Modify comparison if desired (consider potential logic impact)
                if (currentTime.isBefore(dbtime)) {
                
                    List<Train> trainsFromTimetable = getTrainList(databaseDepartureTime, timetable);
                    
                    trains.addAll(trainsFromTimetable);
                     System.out.println( dbtime +" "+ currentTime );
                }
                else{
                   System.out.println( "No Intermidiate Trains" );
                }
               }
               if (!parsedDate.equals(currentDate)){
                    Time databaseDepartureTime = resultSet.getTime("DepartureTime");
                    List<Train> trainsFromTimetable = getTrainList(databaseDepartureTime, timetable);
                    
                    trains.addAll(trainsFromTimetable);
                     
               }
               
               
               
            }
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle exceptions appropriately in a real application
    }
  return trains;
}
  
 

public Time getDepatureTime(int fid,String timetable) throws SQLException
{     Time depaturetime=null;
      String query=null;
      String cname=null;
      if (timetable.equals("bangaloretimetable")){
        query="select B from sbc_mas where id=?";
        cname="B";
      }
      
       if (timetable.equals("chennaitimetable")){
          query="select C from sbc_mas where id = ?";
          cname="C";
      }
    
    if(query!=null){
          try{ Class.forName(JDBC_DRIVER);
 try (   
Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
         PreparedStatement statement = connection.prepareStatement(query)) {
        
          statement.setInt(1, fid);
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
               
                    depaturetime = resultSet.getTime(cname);
                   
                
                
                 
               }
}
    }
         }catch(Exception e){ 
             System.out.println(e);
         System.out.println("the error in the getdepaturetimr method");}
          
  
     }
     System.out.println("hi d"+depaturetime);
      return depaturetime;
}

 public List<Train> getTrainList(Time departureTime, String timetable) throws SQLException {
    List<Train> trains = new ArrayList<>();
    String query = "SELECT * FROM " + timetable + " WHERE DepartureTime = ?";

    try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
         PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setTime(1, departureTime);

        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Train train = new Train();
                train.setTrainName(resultSet.getString("TrainName"));
                train.setTrainNumber(resultSet.getInt("TrainNumber"));
                train.setDepartureStation(resultSet.getString("DepartureStation"));
                train.setDepartureTime(resultSet.getTime("DepartureTime"));
                train.setArrivalStation(resultSet.getString("ArrivalStation"));
                train.setArrivalTime(resultSet.getTime("ArrivalTime"));

                trains.add(train);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle exceptions appropriately in a real application
    }

    return trains;
}
 public static boolean storeTicketDetails(int trainId, String trainName, String departureStation, String arrivalStation, String departureTime, int adultTickets, int childTickets, String ticketType, String tDate ,String username) {
        try (
            // Establishing a connection
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Create a PreparedStatement to execute SQL
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Ticket (trainId, trainName, departureStation, arrivalStation, departureTime, adultTickets, childTickets, ticketType,travelDate,username) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?,?)");
        ) {
            // Set parameters for PreparedStatement
            preparedStatement.setInt(1, trainId);
            preparedStatement.setString(2, trainName);
            preparedStatement.setString(3, departureStation);
            preparedStatement.setString(4, arrivalStation);
            preparedStatement.setString(5, departureTime);
            preparedStatement.setInt(6, adultTickets);
            preparedStatement.setInt(7, childTickets);
            preparedStatement.setString(8, ticketType);
            preparedStatement.setString(9, tDate);
            preparedStatement.setString(10,username);
      

            // Execute SQL query
            int rowsAffected = preparedStatement.executeUpdate();

            // If rowsAffected > 0, insertion was successful
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exceptions
            return false;
        }
    }

      public List<Ticket> fetchTicketDetailsFromDB(String username) {
    List<Ticket> ticketList = new ArrayList<>();

    try {
        Class.forName(JDBC_DRIVER);
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Ticket WHERE username = ?")) {

            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Ticket ticket = new Ticket();
                    ticket.setTicketId(resultSet.getInt("ticketId"));
                    ticket.setTrainId(resultSet.getInt("trainId"));
                    ticket.setTrainName(resultSet.getString("trainName"));
                    ticket.setDepartureStation(resultSet.getString("departureStation"));
                    ticket.setArrivalStation(resultSet.getString("arrivalStation"));
                    ticket.setDepartureTime(resultSet.getString("departureTime"));
                    ticket.setAdultTickets(resultSet.getInt("adultTickets"));
                    ticket.setChildTickets(resultSet.getInt("childTickets"));
                    ticket.setTicketType(resultSet.getString("ticketType"));
                    ticket.setTravelDate(resultSet.getString("travelDate"));

                    ticketList.add(ticket);
                }
            }
        }
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace(); // Handle or log the exception as needed
    }

    System.out.println(ticketList);
    return ticketList;
}

}


