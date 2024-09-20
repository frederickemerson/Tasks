package se.edu.streamdemo;

import se.edu.streamdemo.data.Datamanager;
import se.edu.streamdemo.task.Deadline;
import se.edu.streamdemo.task.Task;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Task manager (using streams)");
        Datamanager dataManager = new Datamanager("./data/data.txt");
        ArrayList<Task> tasksData = dataManager.loadData();

        System.out.println("Printing all data ...");
        printAllData(tasksData);

        System.out.println("Printing deadlines ...");
        printDeadlines(tasksData);

        System.out.println("Total number of deadlines: " + countDeadlines(tasksData));

    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    public  static int countDeadlinesWithStreams(ArrayList<Task> tasks){
        return (int) tasks.stream().filter(t -> t instanceof Deadline).count();
    }

    public static void printAllData(ArrayList<Task> tasksData) {
        System.out.println("Printing all data with iteration");
        for (Task t : tasksData) {
            System.out.println(t);
        }
    }

    public static void printALlDataWithStreams(ArrayList<Task> tasks) {
        System.out.println("Printing all data with streams");
        tasks.stream().forEach(System.out::println);
    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                System.out.println(t);
            }
        }
    }

    public static void printDeadlineUsingStream(ArrayList<Task> tasks){
        tasks.stream().filter(t -> t instanceof Deadline).forEach(System.out::println));
    }

}
