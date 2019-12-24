package com.rahul;

import java.util.ArrayList;

public class TaskM {
    static void add(Task t, ArrayList<Task> lst)
    {
        lst.add(t);
    }
    static void display(ArrayList<Task> lst)
    {
        for(Task str:lst)
            System.out.println(str);
    }
    static void find(String name,ArrayList<Task> lst)
    {
        for(Task str:lst) {
            if (str.getTaskname().equals(name)) {
                System.out.println(str);
                //break;
            } else
                System.out.println(str+" is not found");
        }
    }
    static void delete(String del,ArrayList<Task> lst) {
        for (Task str : lst) {
            if (str.getTaskname().equals(del)) {
                lst.remove(str);
                break;
            }
        }
    }
    public void listByStatus(Taskstatus status,ArrayList<Task> lst) {
        for(Task i:lst){
            if(i.getStatus().equals(i)){
                System.out.println(i);
            }
        }
    }
}

