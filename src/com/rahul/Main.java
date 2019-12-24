package com.rahul;
import java.io.*;
import java.util.ArrayList;

public class Main {
    private static int taskid=1;
    private static int totaltasks=0;
    public static void main(String[] args) throws IOException {
        // write your code here
        TaskManager taskManager = new TaskManager();
        while (true) {
            System.out.println("------------------------------------------------------");
            System.out.println("1.Add\n2.IdandName\n3.Display\n4.Search\n5.Delete\n6.ListByStatus\n" +
                    "7.Update status\n8.TotalTasks\n9.Exit");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Your Choice");
            int choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1://add
                    //entering task name
                    System.out.println("enter name to add:");
                    String taskname = br.readLine();

                    //entering Description of task
                    System.out.println("enter description to add:");
                    String description = br.readLine();

                    //entering duedate
                    System.out.println("enter date to add:");
                    String date = br.readLine();

                    //entering status
                    System.out.println("enter status to add:");
                    Taskstatus status = Taskstatus.valueOf(br.readLine());

                    Task task = new Task(taskid++,taskname, description, date, status);
                    taskManager.add(task);
                    totaltasks++;
                    break;
                case 2://id and name
                    ArrayList<Task> list=taskManager.displayidandname();
                    for(Task str:list)
                        System.out.println(str.getTaskid()+" "+str.getTaskname());
                    break;
                case 3://displayall
                    ArrayList<Task> displaylist=taskManager.display();
                    for(Task str:displaylist)
                        System.out.println(str);
                    break;
                case 4://search
                    System.out.println("enter id to search");
                    int id = Integer.parseInt(br.readLine());
                    task=taskManager.search(id);
                    if(task==null)
                        System.out.println("taskid:"+id+" is not found");
                    else {
                        System.out.println("taskid:" + id + " is found");
                        System.out.println(task);
                    }
                    break;
                case 5://delete
                    System.out.println("enter id to delete");
                    int deleteid = Integer.parseInt(br.readLine());
                    taskManager.delete(deleteid);
                    System.out.println("taskid:"+deleteid+" is deleted");
                    totaltasks--;
                    break;
                case 6://listByStatus
                    System.out.println("enter status to search");
                    Taskstatus str=Taskstatus.valueOf(br.readLine());
                    ArrayList<Task> statuslist=taskManager.listByStatus(str);
                    for(Task i:statuslist){
                        if(i.getStatus().equals(str)){
                            System.out.println(i);
                        }
                        else
                            System.out.println("No Status found");
                    }
                    break;
                case 7://update status
                    System.out.println("enter id");
                    int taskid=Integer.parseInt(br.readLine());
                    System.out.println("enter new Status to update");
                    Taskstatus newStatus=Taskstatus.valueOf(br.readLine());
                    taskManager.updateStatus(taskid,newStatus);
                    break;
                case 8://total status
                    System.out.println("Total Tasks="+totaltasks);
                    break;
                case 9://exit
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}