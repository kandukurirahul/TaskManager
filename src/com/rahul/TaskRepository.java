package com.rahul;

import java.util.ArrayList;

public interface TaskRepository {
    public void add(Task task);
    public ArrayList<Task> displayidandname();
    public ArrayList<Task> display();
    public Task search(int id);
    public void delete(int del);
    public ArrayList<Task> listByStatus(Taskstatus status);
    public void updateStatus(int taskid,Taskstatus newStatus);
}
