import java.util.Observable;
import java.util.Observer;

/**
 * William Trent Holliday
 * 1/26/15
 */
public class BlogSubscriber implements Observer {

    public BlogSubscriber(String name){
        this.name = name;
    }

    @Override
    public void update(Observable observable, Object o) {
        System.out.printf("Notification for %s: New blog \"%s\" has been posted.\n", this.name, o);
    }

    private String name;
}