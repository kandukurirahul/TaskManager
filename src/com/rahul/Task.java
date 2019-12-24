package com.rahul;
enum Taskstatus{CREATED,IN_PROGRESS,DONE}
class Task {
    private String taskname;
    private String taskDesc;
    private String duedate;
    private Taskstatus status;

    @Override
    public String toString() {
        return "Task{" +
                "taskname='" + taskname + '\'' +
                ", taskDesc='" + taskDesc + '\'' +
                ", duedate='" + duedate + '\'' +
                ", status=" + status +
                '}';
    }

    Task(String tsk, String des, String td, Taskstatus status)
    {
        this.taskname=tsk;
        this.taskDesc=des;
        this.duedate=td;
        this.status=status;
    }
    public Taskstatus getStatus(){
        return status;
    }
    public void setStatus(Taskstatus status){
        this.status=status;
    }
    public String getTaskname(){
        return taskname;
    }
    public void setTaskname(String tasknamename){
        this.taskname=taskname;
    }
    public String getTaskDesc(){
        return taskDesc;
    }
    public void setTaskDesc(String taskDesc){
        this.taskDesc=taskDesc;
    }
    public String getDuedate(){
        return duedate;
    }
    public void setDuedate(String duedate){
        this.duedate=duedate;
    }
}
