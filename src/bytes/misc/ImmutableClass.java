package bytes.misc;

import java.util.*;

public class ImmutableClass {

    public void start() {
        //Create an object
        Immutable obj1 = new Immutable(10, "dog", new Color("red"), Collections.singletonMap("dog", "red"), Collections.singletonList("pepsi"));
        System.out.println("Name: " + obj1.getName());
        obj1.getColdDrinks().stream().forEach(System.out::println);

        obj1.getColdDrinks().add("coke");
        obj1.getColdDrinks().stream().forEach(System.out::println);

        obj1.getColor().setColor("white");
        System.out.println("Color: " + obj1.getColor().getColor());
    }

}

//Make Class Final - Prevent extension
final class Immutable {

    //Final fields
    private final int age;
    private final String name;

    //With Map and List
    private final Map<String, String> colorCommentsMap;
    private final List<String> coldDrinks;

    //With custom class
    private final Color color;


    Immutable(int age, String name, Color color, Map<String, String> colorCommentsMap, List<String> coldDrinks) {
        this.age = age;
        this.name = name;

        //Do not set the provided map ref here - as it can be changed
        //Clone or create a new instance
        this.colorCommentsMap = new HashMap<>(colorCommentsMap);

        //Similarly for this list - do not set the provided ref here
        //Clone or create a new instance
        this.coldDrinks = new ArrayList<>(coldDrinks);

        //This is the custom class - again setting the provided ref can be used to modify the object
        //Instead clone/create this
        this.color = new Color(color.getColor());
    }

    //Only Getters - NO SETTERS
    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    //Do not return the instance as entries can be added and modify this object
    //Rather clone/create and return
    public Map<String, String> getColorCommentsMap() {
        return new HashMap<>(colorCommentsMap);
    }

    //Similarly for the List object
    //Clone or create and return
    public List<String> getColdDrinks() {
        return new ArrayList<>(coldDrinks);
    }

    //Similarly for the custom class
    //Clone/Create and return
    public Color getColor() {
        return new Color(color.getColor());
    }

}

class Color {

    private String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
