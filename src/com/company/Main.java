 package com.company;
import java.io.*;
import java.util.*;

 public class Main {




     public static void main(String[] args) {



     }
}

    // arfa code

 /*   File f=new File("frist.txt");
    ArrayList<String> arrlist = new ArrayList<String>();
    Scanner s =null;
        try {
        s = new Scanner(new File("first.txt"));
        s.useDelimiter("[.]");
        int i = 0;
        while (s.hasNext()) {
            arrlist.add(s.next());
        }
    }catch (FileNotFoundException e){
        System.out.println("file not found !");
    }finally {
        s.close();
    }

    String y;
    String x;
    String z;
    String storage[] = new String[arrlist.size()];
    int comm;
    int count =0;
    Scanner r=new Scanner(System.in);
        System.out.println("Enter Day : ");
    String day= r.next();
        System.out.println("Enter number of committees : ");
    int n= r.nextInt();


    //System.out.println("committees : "+"First Observer "+" Second Observer "+" Admin");
        for (comm=1;comm<=n;comm++){
        x=arrlist.get(new Random().nextInt(arrlist.size()));
        arrlist.remove(x);
        y=arrlist.get(new Random().nextInt(arrlist.size()));
        arrlist.remove(y);
        z=arrlist.get(new Random().nextInt(arrlist.size()));
        arrlist.remove(z);
        storage[count++]=x;
        storage[count++]=y;
        storage[count++]=z;
        //System.out.println("Day : "+day+"\n\tcommitte "+comm+" : \n First Observer "+x+" - \n Second Observer "+y+" - \n  Admin "+z);
    }
    //System.out.println("\n");
    comm=1;
        try {
        FileWriter myWriter = new FileWriter("store frist.txt");
        myWriter.write( "Day : "+day+"\t Number Of Committees : "+n);
        for (int i=0;i<n*3;i++){
            myWriter.write( ("\n\tcommitte "+comm+storage[i]+storage[++i]+storage[++i]));
            comm++;
        }
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
*/