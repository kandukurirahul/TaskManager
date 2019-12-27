package com.rahul;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DatabaseRepository implements TaskRepository{
    // Loads the mysql driver
    Connection con;
    public DatabaseRepository(){
        ConnectionEstablishment();
    }
    public void ConnectionEstablishment() {
        //Class.forName("com.mysql.jdbc.Driver");
        // Connects to mysql service through a connection url and credentials
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","testuser","password");
//            Statement stmt = con.createStatement();
//            String str="select * from testdb.task";
//            ResultSet rs = stmt.executeQuery("select * from <table>");
//            while(rs.next())
//                System.out.println(rs.getString(1));
//            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

// Mainly used for retrieval queries

    }

    @Override
    public void add(Task task) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd");
        String date=simpleDateFormat.format(task.getDueDate());
        try {
            Statement stmt = con.createStatement();
            String q="insert into task values("+task.getTaskId()+",'"+task.getTaskName()+"','"+task.getTaskDesc()+"','"+date
                    +"','"+task.getStatus()+"')";
            System.out.println(q);
            stmt.executeUpdate(q);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        String q="insert into task values("+task.getTaskId()+",\""+task.getTaskName()+"\",\""+task.getTaskDesc()+"\",\""+date
//                    +"\",\""+task.getStatus()+"\")";
    }
    @Override
    public ArrayList<Task> displayIdandName() {
        ConnectionEstablishment();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select taskid,name from task");
            while(rs.next())
                printIdName(rs);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Task>();
    }

    @Override
    public ArrayList<Task> display() {
        ConnectionEstablishment();
        try {
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from task");
            while(rs.next())
                printAll(rs);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Task>();
    }

    @Override
    public Task search(int id) {
        ConnectionEstablishment();
        try {
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from task where taskid="+id);
            if(rs.next()){
                Task task=new Task();
                task.setTaskId(rs.getInt(1));
                task.setTaskName(rs.getString(2));
                task.setTaskDesc(rs.getString(3));
                task.setDueDate(rs.getDate(4));
                task.setStatus(Taskstatus.valueOf(rs.getString(5)));
                con.close();
                return task;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean delete(int del) {
        int totalBefore=totalTask();
        int totalAfterDelete=totalTask();

        ConnectionEstablishment();
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("delete from task where taskid="+del);
            totalAfterDelete=totalAfterDelete-1;
            con.close();
            if(totalBefore==totalAfterDelete+1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<Task> listByStatus(Taskstatus status) {
        ConnectionEstablishment();
        ArrayList<Task> tasks=new ArrayList<Task>();
        try {
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from task where status='"+status+"'");
            while(rs.next()){
                Task task=new Task();
                task.setTaskId(rs.getInt(1));
                task.setTaskName(rs.getString(2));
                task.setTaskDesc(rs.getString(3));
                task.setDueDate(rs.getDate(4));
                task.setStatus(Taskstatus.valueOf(rs.getString(5)));
                tasks.add(task);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    public void updateStatus(int taskid, Taskstatus newStatus) {
        ConnectionEstablishment();
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("update task set status='"+newStatus+"' where taskid="+taskid);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int totalTask() {
        int total=0;
        ConnectionEstablishment();
        try {
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select count(*) from task");
            if(rs.next())
                total=rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public ArrayList<Task> getPendingTask() {
        ConnectionEstablishment();
        ArrayList<Task> tasks=new ArrayList<Task>();
        try {
            Statement stmt= con.createStatement();
            String status="DONE";
            ResultSet rs=stmt.executeQuery("select * from task where not status='"+status+"' order by dueDate ASC");
            while(rs.next()){
                Task task=new Task();
                task.setTaskId(rs.getInt(1));
                task.setTaskName(rs.getString(2));
                task.setTaskDesc(rs.getString(3));
                task.setDueDate(rs.getDate(4));
                task.setStatus(Taskstatus.valueOf(rs.getString(5)));
                tasks.add(task);
            }
            con.close();
            return tasks;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Task> getTodayTask() {
        ConnectionEstablishment();
        ArrayList<Task> currentTask=new ArrayList<>();
        try {
            Statement stmt=con.createStatement();
            java.util.Date date=new java.util.Date();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd");
            String today=simpleDateFormat.format(date);
            ResultSet rs=stmt.executeQuery("select * from task where duedate='"+today+"'");
            while(rs.next()){
                Task task=new Task();
                task.setTaskId(rs.getInt(1));
                task.setTaskName(rs.getString(2));
                task.setTaskDesc(rs.getString(3));
                task.setDueDate(rs.getDate(4));
                task.setStatus(Taskstatus.valueOf(rs.getString(5)));
                currentTask.add(task);
            }
            con.close();
            return currentTask;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void printIdName(ResultSet rs){
        try {
            System.out.println(" TaskId="+rs.getInt(1)+
                    "\n TaskName:"+rs.getString(2)+"\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void printAll(ResultSet rs){
        try {
            System.out.println(" TaskId="+rs.getInt(1)+
                    "\n TaskName:"+rs.getString(2)+
                    "\n TaskDescription:"+rs.getString(3)+
                    "\n Task DueDate:"+dateToString(rs.getDate(4),"dd/MM/yyyy")+
                    "\n Task Status:"+rs.getString(5)+"\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String dateToString(Date date,String format){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }
}