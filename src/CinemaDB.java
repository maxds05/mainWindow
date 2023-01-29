import java.sql.*;

public class CinemaDB {


     private final String dbFilePath = "CinemaDatabase.accdb";
     private final String dbConnectionUrl = "jdbc:ucanaccess://" + dbFilePath;

     private Connection dbConnection = null;


     //private variables
     private static final String INSERT_USERS_SQL = "INSERT INTO login" + "  (name, email) VALUES " +
             " (?, ?, ?);";
     private static final String SELECT_USER_BY_ID = "SELECT id,name,email FROM users WHERE id =?";
     private static final String SELECT_ALL_USERS = "SELECT * FROM users";
     private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE id = ?;";
     private static final String UPDATE_USERS_SQL = "UPDATE users SET name = ?,email= ?, WHERE id = ?;";


     private Statement getSqlStatement() throws SQLException {

          if (dbConnection == null) {
               dbConnection = DriverManager.getConnection(dbConnectionUrl, "", ""); //connects to database
          }

          return dbConnection.createStatement();

     }

     public static Connection getConnection() throws SQLException {
          return DriverManager.getConnection("jdbc:ucanaccess://CinemaDatabase.accdb");
     }

     private boolean executeUpdateSql(String query) {
          try {
               Statement stmt = getSqlStatement();
               stmt.executeUpdate(query);
               stmt.close();
          } catch (SQLException e) {
               e.printStackTrace();
               return false;
          }

          return true;

     }

     public static void getFilms() {

          try {
               Class.forName("org.apache.derby.jdbc.ClientDriver");
          } catch (ClassNotFoundException e) {
               System.out.println("Class not found " + e);
          }
          try {
               Connection con = DriverManager.getConnection(
                       "jdbc:ucanaccess://CinemaDatabase.accdb", "username", "password");

               Statement stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery("SELECT * FROM Film");
               System.out.println("Film     Genre    Age Rating");

               while (rs.next()) {
                    String filmName = rs.getString("FilmName");
                    String genre = rs.getString("Genre");
                    int ageRating = rs.getInt("AgeRating");
                    System.out.println(filmName + "   " + genre + "    " + ageRating);
               }
          } catch (SQLException e) {
               System.out.println("SQL exception occurred" + e);
          }
     }


     public static void addUser() throws SQLException {

          //String sql = "INSERT INTO Login (Email, Password) VALUES " + "('maxdewarsmith@gmail.com', 'password')";


     }
}





