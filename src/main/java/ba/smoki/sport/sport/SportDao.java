package ba.smoki.sport.sport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SportDao {
    String URL = "jdbc:mysql://localhost:3306/players";
    String USER = "root";
    String PASSWORD = "root";

    public List<Sport> findAll() {
        String sqlSelect = """
                SELECT * FROM sports
                """;
        List<Sport> sports = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement ps = connection.prepareStatement(sqlSelect);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Sport sport = new Sport();
                sport.setId(rs.getLong("id"));
                sport.setName(rs.getString("name"));
                sport.setDescription(rs.getString("description"));
                sports.add(sport);
            }
        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }
        return sports;
    }

    public void save(Sport sport) {
        //INSERT INTO `players`.`sports` (`name`) VALUES ('Plesanje');
    }
}
