package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Committee {
    private static int counterCommittees;

    private int committeeNumber;
    private String examName;
                    // عدد المراقبين
    private int numOFInvigilator;
    String[] InvigilatorArrayList; // don't use normal String []InvigilatorArrays;
     // to make Invigilator name accept white space
                    // المشرف
    private String  committeeSupervisor;
    private String committeeDate;

    Committee(int committeeNumber,String examName, int numOFInvigilator,String[] InvigilatorArrayList,String committeeSupervisor,String committeeDate){
        this.committeeNumber=committeeNumber;
        this.examName=examName;
        this.numOFInvigilator=numOFInvigilator;
        this.committeeSupervisor=committeeSupervisor;
        this.InvigilatorArrayList=InvigilatorArrayList;
        this.committeeDate=committeeDate;
        counterCommittees++;
    }
    //never used
    Committee(){
        counterCommittees++;
    }

    public int getCommitteeNumber() {
        return committeeNumber;
    }

    public String[] getInvigilatorStrings() {
        return InvigilatorArrayList;
    }

    public String getExamName() {
        return examName;
    }

    public static int getNumberOfCommittees() {
        return counterCommittees;
    }

    public int getNumOFInvigilator() {
        return numOFInvigilator;
    }

    public String getCommitteeSupervisor() {
        return committeeSupervisor;
    }

    public String getCommitteeDate() {
        return committeeDate;
    }

    public void addCommittee(){
        int nOfComm;
        int commNumber;
        String examName;
        int numOFInvigilator;
        String  committeeSupervisor;
        String commDate;

        String []InvigilatorArrays;

        Scanner scan =new Scanner(System.in);
        scan.useDelimiter("\n"); // to ignore white space error

        System.out.print("number of committees: ");
        nOfComm =scan.nextInt();


        ArrayList<Committee> objectsArrayList = new ArrayList<>();

        // assign data to variable
        for (int i =0;i<nOfComm;i++){
            commNumber=i+1; //auto for now
            System.out.println("\t Committee "+commNumber);
            System.out.print("exam Name: ");
            examName =scan.next();
            System.out.print("Enter comm Date: ");
            commDate =scan.next();
            System.out.print("committeeSupervisor: ");
            committeeSupervisor =scan.next();
            System.out.print("number Of Invigilator: ");
            numOFInvigilator =scan.nextInt();

            int chose =1;
            System.out.print("1 To Chose Invigilator Randomly\n");
            System.out.print("2 To Free Write Invigilator Name\n");
            System.out.print("chose: ");
            chose=scan.nextInt();
            if (chose ==1){
                //arfa
                // import names from file to names array
                File f=new File("names.txt");
                ArrayList<String> arrlist = new ArrayList<String>();
                Scanner s =null;
                try {
                    s = new Scanner(new File("names.txt"));
                    s.useDelimiter("\n");
                    while (s.hasNext()) {
                        arrlist.add(s.next());
                    }
                }catch (FileNotFoundException e){
                    System.out.println("file not found !");
                }finally {
                    s.close();
                }

                String storage[] = new String[arrlist.size()];
                String x;
                for (int j = 0; j < numOFInvigilator; j++) {
                    x=arrlist.get(new Random().nextInt(arrlist.size()));
                    arrlist.remove(x);
                    storage[j]=x;
                }
                InvigilatorArrays=storage;//pass ref of random names array
                //end arfa
            }else if(chose ==2){
                InvigilatorArrays =new String[numOFInvigilator];
                for (int j = 1; j < numOFInvigilator+1; j++) { //j =1 to write in console Invigilator1 not Invigilator0
                    String s=scan.next();
                    InvigilatorArrays[j-1]=s;  // j-1 to get index 0
                }
            }
            else{
                System.out.println("Unvalid input");
                break;
            }

            //assign variable to objects
            objectsArrayList.add(new Committee(commNumber,examName,numOFInvigilator,InvigilatorArrays,committeeSupervisor,commDate));
        }

        // add committees in file
        File commFile =new File("committees.txt");
        try {
            FileWriter myWriter = new FileWriter(commFile,true);// true for append
            for (int i = 0; i < nOfComm; i++) {
                //commNumber+"  "+examName+"  "+commDate
                myWriter.write("committee "+ objectsArrayList.get(i).getCommitteeNumber()+"  "
                        +objectsArrayList.get(i).getExamName()+"  Date: "+objectsArrayList.get(i).getCommitteeDate()
                        +"\nInvigilator:\n");
                String[] InvigilatorBuf =objectsArrayList.get(i).getInvigilatorStrings();// assign by ref
                for (int j = 0; j <= objectsArrayList.get(i).getNumOFInvigilator()-1; j++) {
                    myWriter.write("\t"+(1+j)+"-"+ InvigilatorBuf[j]+"\n");
                }
                myWriter.write("Supervisor:\n\t."+objectsArrayList.get(i).getCommitteeSupervisor()+"\n");
                myWriter.write("\n");// Delimiter  of committees is \n

            }

            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void searchCommitteeInfo(File fName,char commotteeNumber){

        File f =new File(String.valueOf(fName));
        try (Scanner scan =new Scanner(f)){

            String committeeNum;

            while (scan.useDelimiter("committee ").hasNext()){
                committeeNum =scan.next();

                if (committeeNum.charAt(0) == commotteeNumber){
                    System.out.println("Committee "+scan.next());
                }
            }
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
}/*
File file = new File("committee.txt");
FileWriter fr = new FileWriter(file, true);
fr.write("data");
fr.close();*/