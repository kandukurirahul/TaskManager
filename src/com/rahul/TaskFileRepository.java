package com.rahul;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TaskFileRepository implements TaskRepository{
    private static final String TASKS_JSON_FILE="/home/rahulp/Desktop/workspace/java/tasks.json";
    private ObjectMapper objectMapper=new ObjectMapper();
    ArrayList<Task> tasks;
    File file=new File(TASKS_JSON_FILE);
    public TaskFileRepository(){
        tasks=readFromFile();
    }
    private void writeToFile(ArrayList<Task> tasks) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new FileWriter(TASKS_JSON_FILE),tasks);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private ArrayList<Task> readFromFile() {
        //final File file = new File(TASKS_JSON_FILE);
        if (file.exists()) {
            try {
                return objectMapper.readValue(file, TaskList.class);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public void add(Task task) {
        tasks.add(task);
        writeToFile(tasks);
    }

    @Override
    public ArrayList<Task> displayidandname() {
        return readFromFile();
    }

    @Override
    public ArrayList<Task> display() {
        return readFromFile();
    }

    @Override
    public Task search(int id) {
        for(Task str:tasks) {
            if (str.getTaskid()==id) {
                return str;
            }
        }
        return null;
    }

    @Override
    public void delete(int del) {
        for(Task task:tasks){
            if(task.getTaskid()==del){
                tasks.remove(task);
                writeToFile(tasks);
            }
        }
    }

    @Override
    public ArrayList<Task> listByStatus(Taskstatus status) {
        return readFromFile();
    }

    @Override
    public void updateStatus(int taskid, Taskstatus newStatus) {
        for(Task str:tasks){
            if(str.getTaskid()==taskid){
                str.setStatus(newStatus);
            }
        }

    }
}
