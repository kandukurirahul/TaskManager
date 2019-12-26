package com.rahul;

class Task {
    private int taskid;
    private String taskname;
    private String taskDesc;
    private String duedate;
    private Taskstatus status;
    public Task(){

    }
    @Override
    public String toString() {
        return "Task{" +
                "taskid=" + taskid +
                ", taskname='" + taskname + '\'' +
                ", taskDesc='" + taskDesc + '\'' +
                ", duedate='" + duedate + '\'' +
                ", status=" + status +
                '}';
    }

    Task(int taskid,String task, String des, String td, Taskstatus status) {
        this.taskid=taskid;
        this.taskname = task;
        this.taskDesc = des;
        this.duedate = td;
        this.status = status;
    }
    public int getTaskid(){
        return taskid;
    }
    public void setTaskid(int taskid){
        this.taskid=taskid;
    }
    public Taskstatus getStatus() {
        return status;
    }

    public void setStatus(Taskstatus status) {
        this.status = status;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String tasknamename) {
        this.taskname = taskname;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }
}
