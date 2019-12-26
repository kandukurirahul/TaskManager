package com.rahul;

import java.util.ArrayList;

public class TaskManager {
    TaskRepository repository=new TaskFileRepository();
    public void add(Task task){
        repository.add(task);
    }
    public ArrayList<Task> displayidandname(){
        return repository.displayidandname();
    }
    public ArrayList<Task> display(){
        return repository.display();
    }
    public Task search(int id){
        return repository.search(id);
    }
    public void delete(int del){
        repository.delete(del);
    }
    public ArrayList<Task> listByStatus(Taskstatus status){
        return repository.listByStatus(status);
    }
    public void updateStatus(int taskid,Taskstatus newStatus){
        repository.updateStatus(taskid,newStatus);
    }
}

