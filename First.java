import java.util.ArrayList;
import java.util.List;

//1)
public class First {
    public static void main(String[] args) {
        Observer observer = new Observer("one");
        Observer observer2 = new Observer("two");
        observer.setState("new state");
        observer2.setState("hello");
    }
}

interface IObservable{
    void update();
}

class Observer implements IObservable{
    static List<Observer> observers = new ArrayList<>();
    String name;
    String state;

    public Observer(String name){
        this.name = name;
        observers.add(this);
    }

    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }

    void notifyAllObservers(){
        for (Observer observer: observers) {
            observer.update();
            
        }
    }

    public void update(){
        System.out.println(name + " change status: " + state);
    }
}
