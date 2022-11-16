package cis.entity;

import cis.Controller;
import cis.util.CisUtility;

/**
 * Represents a kid that wants presents
 *
 * @author bjmac
 * @since 2-Dec-2020
 * @modified by marianna hollanda
 * @since 20201207 
 * Added a validation user input to name, age and behaviorRating. 
 * The user will be continually prompted until valid. 
 * Added a logic to keep the name Rudolph off the lists.
 * Added a logic that the kid should not be added to a list if they are already on a list.
 */
public class Kid {

    private String name = "";
    private int age;
    private int behaviourRating; //1-Very naughty 10-Very nice

    public void getInformation(String listNaughty, String listNice) {

        name = CisUtility.getInputString("Name (Must be at least length of two)");

        while (name.length() < 2) {
            name = CisUtility.getInputString("Invalid. The name must be at least length of two.");
        }

        while (name.equals("Rudolph")) {
            name = CisUtility.getInputString("Invalid. The name Rudolph can not be added to a list.");
        }
        
        while (listNaughty.contains(name) || listNice.contains(name)){
            name = CisUtility.getInputString("Invalid. The name is already on a list.");
        }
        

        age = CisUtility.getInputInt("Age (must be below 16)");

        while (age > 16) {
            age = CisUtility.getInputInt("Age (must be below 16)");
        }

        behaviourRating = CisUtility.getInputInt("How nice was the kid this year? (1-10 where 1==very naughty 10==very nice)");

        while (behaviourRating < 1 || behaviourRating > 10) {
            behaviourRating = CisUtility.getInputInt("Invalid. How nice was the kid this year? (1-10 where 1==very naughty 10==very nice)");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBehaviourRating() {
        return behaviourRating;
    }

    public void setBehaviourRating(int behaviourRating) {
        this.behaviourRating = behaviourRating;
    }

    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return System.lineSeparator() + "--- Kid Details ---" + System.lineSeparator()
                + "- Name: " + name + System.lineSeparator()
                + "- Age: " + age + System.lineSeparator()
                + "- Behaviour Rating: " + behaviourRating + System.lineSeparator()
                + "--------------------" + System.lineSeparator() + System.lineSeparator();
    }

}
