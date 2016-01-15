package task2.src.mentee.observers;

import task2.src.mentee.Subject;

/**
 * Created by TheFallen on 08.12.15.
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
