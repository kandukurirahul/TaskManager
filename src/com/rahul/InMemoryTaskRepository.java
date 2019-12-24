package com.rahul;

import java.util.ArrayList;

public class InMemoryTaskRepository implements TaskRepository {
    ArrayList<Task> list = new ArrayList<Task>();
    public void add(Task task)
    {
        list.add(task);
    }
    public ArrayList<Task> displayidandname(){
        return list;
    }
    public ArrayList<Task> display()
    {
        return list;
    }
    public Task search(int id)
    {
        for(Task str:list) {
            if (str.getTaskid()==id) {
                return str;
            }
        }
        return null;
    }
    public void delete(int del) {
        for (Task str : list) {
            if (str.getTaskid()==del) {
                list.remove(str);
                break;
            }
        }
    }
    public ArrayList<Task> listByStatus(Taskstatus status) {
        return list;
    }
    public void updateStatus(int taskid,Taskstatus newStatus){
        for(Task str:list){
            if(str.getTaskid()==taskid){
                str.setStatus(newStatus);
            }
        }
    }
}
