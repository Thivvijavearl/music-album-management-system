/*package albummanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import albummanagement.model.album;

public class albumDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/album?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "lialh4h2o";

    private static final String INSERT_albumS_SQL = "INSERT INTO albums" + "  (album, artist, languages) VALUES " + " (?, ?, ?);";

    private static final String SELECT_album_BY_ID = "select id, album, artist, languages from albums where id =?";
    private static final String SELECT_ALL_albumS = "select * from albums";
    private static final String DELETE_albumS_SQL = "delete from albums where id = ?;";
    private static final String UPDATE_albumS_SQL = "update albums set album = ?, artist = ?, languages = ? where id = ?;";

    public albumDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertalbum(album album) throws SQLException {
        System.out.println(INSERT_albumS_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_albumS_SQL)) {
            preparedStatement.setString(1, album.getalbum());
            preparedStatement.setString(2, album.getArtist());
            preparedStatement.setString(3, album.getlanguages());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public album selectalbum(int id) {
        album album = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_album_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("album");
                String artist = rs.getString("artist");
                String languages = rs.getString("languages");
                album = new album(id, name, artist, languages);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return album;
    }

    public List<album> selectAllalbums() {
        List<album> albums = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_albumS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("album");
                String artist = rs.getString("artist");
                String languages = rs.getString("languages");
                albums.add(new album(id, name, artist, languages));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return albums;
    }

    public boolean deletealbum(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_albumS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updatealbum(album album) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_albumS_SQL);) {
            statement.setString(1, album.getalbum());
            statement.setString(2, album.getArtist());
            statement.setString(3, album.getlanguages());
            statement.setInt(4, album.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}*/

package albummanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import albummanagement.model.album;

public class albumDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/album?useSSL=false";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "lialh4h2o";

    private static final String INSERT_album_SQL = "INSERT INTO album (album, artist, languages) VALUES (?, ?, ?)";
    private static final String SELECT_album_BY_ID = "SELECT id, album, artist, languages FROM album WHERE id = ?";
    private static final String SELECT_ALL_albumS = "SELECT * FROM album";
    private static final String DELETE_album_SQL = "DELETE FROM album WHERE id = ?";
    private static final String UPDATE_album_SQL = "UPDATE album SET album = ?, artist = ?, languages = ? WHERE id = ?";

    public albumDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            // Handle or log the exception
        }
        return connection;
    }

    public void insertalbum(album album) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_album_SQL)) {
            preparedStatement.setString(1, album.getAlbum());
            preparedStatement.setString(2, album.getArtist());
            preparedStatement.setString(3, album.getLanguages());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Handle or log the exception
        }
    }

    public album selectalbum(int id) {
        album Album = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_album_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String album = rs.getString("album");
                String artist = rs.getString("artist");
                String languages = rs.getString("languages");
                Album = new album(id, album, artist, languages);
            }
        } catch (SQLException e) {
            // Handle or log the exception
        }
        return Album;
    }

    public List<album> selectAllalbums() {
        List<album> albums = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_albumS);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String album = rs.getString("album");
                String artist = rs.getString("artist");
                String languages = rs.getString("languages");
                albums.add(new album(id, album, artist, languages));
            }
        } catch (SQLException e) {
            // Handle or log the exception
        }
        return albums;
    }

    public boolean deleteAlbum(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_album_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            // Handle or log the exception
        }
        return rowDeleted;
    }

    public boolean updateAlbum(album album) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_album_SQL)) {
            statement.setString(1, album.getAlbum());
            statement.setString(2, album.getArtist());
            statement.setString(3, album.getLanguages());
            statement.setInt(4, album.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            // Handle or log the exception
        }
        return rowUpdated;
    }
}
