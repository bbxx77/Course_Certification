package Observer;

import java.sql.SQLException;

public class Editor {
    public EventManager events;

    public Editor() {
        this.events = new EventManager("Developer", "Designer");
    }

    public void addRes(String res) throws SQLException {
        events.notify(res);
    }
}
