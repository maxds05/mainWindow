import java.sql.*;

public class CinemaDB {


     private static final String dbFilePath = System.getProperty("user.dir") + "\\src\\CinemaDatabase.accdb";


     //private variables
     private static final String INSERT_USERS_SQL = "INSERT INTO login" + "  (name, email) VALUES " +
             " (?, ?, ?);";
     private static final String SELECT_USER_BY_ID = "SELECT id,name,email FROM users WHERE id =?";
     private static final String SELECT_ALL_USERS = "SELECT * FROM users";
     private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE id = ?;";
     private static final String UPDATE_USERS_SQL = "UPDATE users SET name = ?,email= ?, WHERE id = ?;";


     public static Connection getConnection() throws SQLException {
          return DriverManager.getConnection("jdbc:ucanaccess://" + dbFilePath);
     }

     private boolean executeUpdateSql(String query) {
          try {
               Connection connection = DriverManager.getConnection("jdbc:ucanaccess://" + dbFilePath);
               Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
               stmt.executeUpdate(query);
               stmt.close();
               connection.close();
          } catch (SQLException e) {
               e.printStackTrace();
               return false;
          }
          return true;
     }

     public static void getFilms() {
          try {
               Connection connection = DriverManager.getConnection("jdbc:ucanaccess://" + dbFilePath);

               Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
               ResultSet rs = stmt.executeQuery("SELECT * FROM Film");
               System.out.println("Film     Genre    Age Rating");

               while (rs.next()) {
                    String filmName = rs.getString("FilmName");
                    String genre = rs.getString("Genre");
                    int ageRating = rs.getInt("AgeRating");
                    System.out.println(filmName + "   " + genre + "    " + ageRating);
               }
               rs.close();
               stmt.close();
               connection.close();
          } catch (SQLException e) {
               System.out.println("SQL exception occurred" + e);
          }
     }

}





