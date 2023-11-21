package Observer;

import Singleton.DbConnectionSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    Map<String, List<String>> listeners = new HashMap<>();
    DbConnectionSingleton base;

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
        base = DbConnectionSingleton.getInstance();
    }

    public void subscribe(String eventType, String listener) {
        List<String> users = listeners.get(eventType);
        if(!users.contains(listener)){
            try {
                String query = "SELECT * FROM users WHERE username = ?";
                PreparedStatement preparedStatement1 = base.getConnection().prepareStatement(query);
                preparedStatement1.setString(1, listener);
                ResultSet user = preparedStatement1.executeQuery();
                while (user.next()){
                    if(!user.getString(2).isEmpty()){
                        String updateQuery = "UPDATE users SET subscribes = ? WHERE username = ?";
                        PreparedStatement preparedStatement = base.getConnection().prepareStatement(updateQuery);
                        preparedStatement.setString(2, user.getString("username"));
                        preparedStatement.setString(1, eventType);
                        preparedStatement.executeUpdate();
                    }
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void unsubscribe(String eventType, String listener) {
        List<String> users = listeners.get(eventType);
        if(users.contains(listener)){
            try (ResultSet user = base.getStatement().executeQuery("SELECT * FROM users where username = " + listener)) {
                PreparedStatement preparedStatement = null;
                preparedStatement = base.getConnection().prepareStatement("UPDATE users SET subscribes = ? WHERE username = " + user);
                preparedStatement.setString(1, null);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void notify(String res) throws SQLException {
        for(String eventType : listeners.keySet()){
            List<String> users = listeners.get(eventType);
            for (String listener : users) {
                ResultSet user = base.getStatement().executeQuery("SELECT * FROM users where users = " + listener);
                if(user.getString(5).equals("email")){
                    EmailNotificationListener event = new EmailNotificationListener(user.getString(6));
                    event.update(eventType, res);
                }
                else {
                    PhoneNotificationListener event = new PhoneNotificationListener(user.getString(6));
                    event.update(eventType, res);
                }
            }
        }

    }
}
