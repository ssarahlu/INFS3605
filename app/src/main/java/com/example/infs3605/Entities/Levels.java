package com.example.infs3605.Entities;

public class Levels {
    private static int level;
    private static String animal;

    public static int getLevel(int stars){

        if (stars < 5){
            level = 1;
        } else {
            level = (int) (stars/5) + 1;
        }
        return level ;

    }

    public static String getAnimal(int level){

        switch (level){
            case 1:
                animal = "Joey";
                break;
            case 2:
                animal = "Grub";
                break;
            case 3:
                animal = "Wombat";
                break;
            case 4:
                animal = "Stingray";
                break;
            case 5:
                animal = "Turtle";
                break;
            case 6:
                animal = "Shark";
                break;
            default:
                animal = "Apex predator";
                break;

        }

        return animal;


    }


}
