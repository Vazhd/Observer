import java.util.ArrayList;
import java.util.List;

//2)
public class Second {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();

        Weather weather = new Weather();
        weather.subscribe(person1);
        weather.subscribe(person2);

        weather.serWeather("sunny");
    }
}
class Weather{
    private String currentWeather;
    private List<Person> people = new ArrayList();

    public void subscribe(Person person){
        this.people.add(person);
    }
    public void unsubscribe(Person person){
        this.people.remove(person);
    }
    public void serWeather(String weather){
        this.currentWeather = weather;
        for (Person person:this.people) {
            person.update(this.currentWeather);
            
        }
    }

}

class Person implements IWeatherListener{
    @Override
    public void update(String weather) {
        System.out.println("Today is " +weather);
    }
}

interface IWeatherListener{
    void update(String weather);
}