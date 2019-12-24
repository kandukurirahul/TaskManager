package com.rahul;
import java.util.*;
import java.io.*;

public class Main {
    //    public static int add(int a,int b)
//    {
//        return a+b;
//    }
    public static void main(String[] args) throws IOException {
        // write your code here
        ArrayList<Task> lst = new ArrayList<Task>();
        while (true) {
            System.out.println("1.Add\n2.Display\n3.Search\n4.Delete\n5.exit");
            //Scanner sc = new Scanner(System.in);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            TaskM tm = new TaskM();
            System.out.println("Enter Your Choice");
            int ch = Integer.parseInt(br.readLine());
            switch (ch) {
                case 1:
                    System.out.println("enter name to add:");
                    String name = br.readLine();
                    String des = br.readLine();
                    String dt = br.readLine();
                    Taskstatus status = Taskstatus.valueOf(br.readLine());
                    Task t = new Task(name, des, dt, status);
                    tm.add(t, lst);
                    break;
                case 2:
                    tm.display(lst);
                    break;
                case 3:
                    System.out.println("enter name to search");
                    String srch = br.readLine();
                    tm.find(srch, lst);
                    break;
                case 4:
                    System.out.println("enter name to delete");
                    String del = br.readLine();
                    tm.delete(del, lst);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
            }
        }

    }
}
