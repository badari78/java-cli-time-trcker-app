package io.javabrains;

import io.javabrains.data.Category;
import io.javabrains.data.Task;

public class TimeTracker {

    public static void main(String[] args){
        if (args.length < 2) {
            Logger.log("Error! Not enough arguments");
        }

        String command = args[0];

        switch (command) {
            case "start" :
                String taskName = args[1];
                String categoryName = args.length == 3 ? args[2] : null;
                Task task = new Task(taskName, new Category(categoryName));
        }
    }


}
