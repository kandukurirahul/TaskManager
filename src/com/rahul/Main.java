package com.rahul;
import java.util.*;
import java.io.*;
enum Taskstatus{IN_PROGRESS,DONE,CREATED;}
public class Main {
//    public static int add(int a,int b)
//    {
//        return a+b;
//    }
    public static void main(String[] args) throws IOException {
        // write your code here
        ArrayList<Details> lst = new ArrayList<Details>();
        while (true) {
            System.out.println("1.Add\n2.Display\n3.Search\n4.Delete\n5.exit");
            //Scanner sc = new Scanner(System.in);
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Your Choice");
            int ch = Integer.parseInt(br.readLine());
            switch (ch) {
                case 1:
                    System.out.println("enter name to add:");
                    String name=br.readLine();
                    String des=br.readLine();
                    String dt=br.readLine();
                    Taskstatus status=Taskstatus.valueOf(br.readLine());
                    Details ob=new Details(name,des,dt,status);
                    add(ob,lst);
                    break;
                case 2:
                    display(lst);
                    break;
                case 3:
                    System.out.println("enter name to search");
                    String srch = br.readLine();
                    find(srch,lst);
                    break;
                case 4:
                    System.out.println("enter name to delete");
                    String del=br.readLine();
                    delete(del,lst);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
            }
        }

    }
    public static void add(Details obj,ArrayList<Details> lst)
    {
        lst.add(obj);
    }
    public static void display(ArrayList<Details> lst)
    {
        for(Details str:lst)
            System.out.println(str.taskname+" "+str.taskDesc+" "+str.duedate+" "+str.status);
    }
    public static void find(String name,ArrayList<Details> lst)
    {
        for(Details str:lst) {
            if (str.taskname.equals(name)) {
                System.out.println(str.taskname+" is found\n"+str.taskname + " " + str.taskDesc + " " + str.duedate+" "+str.status);
                //break;
            } else
                System.out.println(str.taskname +" is not found");
        }
    }
    public static void delete(String del,ArrayList<Details> lst) {
        for (Details str : lst) {
            if (str.taskname.equals(del)) {
                lst.remove(str);
                break;
            }
        }
    }
}
class Details {
    String taskname;
    String taskDesc;
    String duedate;
    Taskstatus status;

    Details(String tsk,String des,String td,Taskstatus status)
    {
        this.taskname=tsk;
        this.taskDesc=des;
        this.duedate=td;
        this.status=status;
    }
}