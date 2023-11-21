package User;

import Singleton.DbConnectionSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class User {
    private static User user;
    private String name;
    private  String surname;
    private String subscribes;
    private String method;
    private String info;
    private User(){}
    public static User createUserIns(){
        if(user == null){
            user = new User();
        }
        return user;
    }
    public void creatUser(String name, String surname, String subscribes, String method, String info) throws SQLException {
        this.name = name;
        this.surname = surname;
        this.subscribes = subscribes;
        this.method = method;
        this.info = info;
        addToDB();
    }
    private void addToDB() throws SQLException {
        DbConnectionSingleton base = DbConnectionSingleton.getInstance();
        int maxId = 0;
        try (ResultSet last_id = base.getStatement().executeQuery("SELECT max(id) FROM users")) {
            if (last_id.next()) {
                maxId = last_id.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedStatement = base.getConnection().prepareStatement("INSERT INTO users (id, username, surname, subscribes, user_method, method_info)" +
                " values (?,?,?,?,?,?)");
        preparedStatement.setInt(1, maxId + 1);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, surname);
        preparedStatement.setString(4, subscribes);
        preparedStatement.setString(5, method);
        preparedStatement.setString(6, info);
        preparedStatement.executeUpdate();
    }
}
