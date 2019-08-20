import java.io.IOException;
import java.sql.*;

import static java.lang.Thread.sleep;

/**
 * Stations: name
 * Tracks: station1,station2
 * Trains: ID, name
 * Train Schedule:start station, end station, start time, end time, sequence
 */
public class RailRoads {
    public static void main(String[] args){
        try {
            SQLCommand command =  new SQLCommand();
            Runtime.getRuntime().exec("cmd /c start \"\" serverStarter.bat");
            sleep(1000);
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/RailRoadDB?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    "localboy", "localpass");
            Statement stmt = conn.createStatement();
            ResultSet rset = command.selectAll(stmt,"stations");
            while(rset.next()){
                System.out.println(rset.getString("name"));
            }
            command.insert(stmt,"Stations","('Chicago')");
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }
}
