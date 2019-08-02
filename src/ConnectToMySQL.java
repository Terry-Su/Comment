import java.sql.*;

public class ConnectToMySQL {
    public static void main(String[] args) {
        // # connect to mysql
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root","testsearch234");) {
            System.out.println("Database connected!");
            Statement statement = con.createStatement();
            statement.executeQuery("USE test1");
            ResultSet resultSet = statement.executeQuery("SELECT id from Student");
            while(resultSet.next())
                System.out.println(resultSet.getInt("id"));
            con.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}
