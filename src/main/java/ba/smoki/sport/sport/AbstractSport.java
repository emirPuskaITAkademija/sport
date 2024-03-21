package ba.smoki.sport.sport;

import ba.smoki.sport.db.ConnectionParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract sealed class AbstractSport permits Sport{
    public void save() throws SQLException{
        //INSERT INTO `players`.`sports` (`name`) VALUES ('Plesanje');
        try (Connection connection = DriverManager.getConnection(
                ConnectionParam.URL.get(),
                ConnectionParam.USER.get(),
                ConnectionParam.PASSWORD.get())) {
            String sqlInsert = """
                    INSERT INTO sports (name, description) VALUES (?, ?)
                    """;
            PreparedStatement ps = connection.prepareStatement(sqlInsert);
            ps.setString(1, getThis().getName());
            ps.setString(2, getThis().getDescription());
            boolean uspjeh = ps.execute();
            System.out.println(!uspjeh?"USPJEH":"NEUSPJEH");
        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
            throw new SQLException(exception);
        }
    }

    public Sport getThis(){
        return (Sport) this;
    }
}
