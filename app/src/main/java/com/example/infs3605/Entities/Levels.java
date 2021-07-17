package com.example.infs3605.Entities;
import com.example.infs3605.R;

public class Levels {
    private static int level;
    private static String animal;
    private static int avatar;

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
                animal = "Grub";
                break;
            case 2:
                animal = "Wombat";
                break;
            case 3:
                animal = "Joey";
                break;
            case 4:
                animal = "Turtle";
                break;
            case 5:
                animal = "Cockatoo";
                break;
            case 6:
                animal = "Frog";
                break;
            case 7:
                animal = "Platypus";
                break;
            case 8:
                animal = "Snake";
                break;
            case 9:
                animal = "Stingray";
                break;
            case 10:
                animal = "Shark";
                break;
            default:
                animal = "Apex predator";
                break;

        }

        return animal;


    }

    public static int getAvatar(int level){

        switch (level){
            case 1:
                avatar = R.drawable.grub;
                break;
            case 2:
                avatar = R.drawable.wombat;
                break;
            case 3:
                avatar = R.drawable.joey;
                break;
            case 4:
                avatar = R.drawable.turtle;
                break;
            case 5:
                avatar = R.drawable.cockatoo;
                break;
            case 6:
                avatar = R.drawable.frog;
                break;
            case 7:
                avatar = R.drawable.platypus;
                break;
            case 8:
                avatar = R.drawable.snake;
                break;
            case 9:
                avatar = R.drawable.stingray;
                break;
            case 10:
                avatar = R.drawable.shark;
                break;
            default:
                avatar = R.drawable.apex;
                break;

        }

        return avatar;


    }


}