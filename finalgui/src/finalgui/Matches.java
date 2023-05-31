/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalgui;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author SoFa
 */
public class Matches extends Ticket{
    
  String matchname;
  String matchdate;
  String matchtime;

              
               
  public static void addmatch(Matches match,ArrayList<Matches> listofmatches,File file )throws IOException{
              match.readfromfile( listofmatches,file);
              listofmatches.add(match);
              match.store(listofmatches,file); 
      
      
      
  }
  public static void store(ArrayList<Matches> listofmatches, File file) throws IOException{
        
        PrintWriter write=new PrintWriter(file);
        for(int i=0;i<listofmatches.size();i++){
        write.println(listofmatches.get(i).getMatchname());
        write.println(listofmatches.get(i).getMatchdate());
        write.println(listofmatches.get(i).getMatchtime());
        write.println(listofmatches.get(i).getSilverprice());
        write.println(listofmatches.get(i).getSilverseats());
        write.println(listofmatches.get(i).getGoldprice());
        write.println(listofmatches.get(i).getGoldseats());
        write.println(listofmatches.get(i).getPlatprice());
        write.println(listofmatches.get(i).getPlatseats());
        
       
       
        
        }
        write.close();
    }
   public static ArrayList readfromfile(ArrayList<Matches> listofmatches, File file)throws IOException{
       
       
       Scanner in=new Scanner(file);
     
        while(in.hasNext()){
            Matches match=new Matches();
            match.setMatchname(in.next());  
            match.setMatchdate(in.next());
            match.setMatchtime(in.next());
            match.setSilverprice(in.nextDouble());
            match.setSilverseats(in.nextInt());
            match.setGoldprice(in.nextDouble());
            match.setGoldseats(in.nextInt());
            match.setPlatprice(in.nextDouble());
            match.setPlatseats(in.nextInt());
            
            listofmatches.add(match);
          
        }
        
        return listofmatches;
        
    }
    public void displaymatches(File file) throws IOException{
               
         
        
    }
   
  
    public String getMatchname() {
        return matchname;
    }

    public void setMatchname(String matchname) {
        this.matchname = matchname;
    }

    public String getMatchdate() {
        return matchdate;
    }

    public void setMatchdate(String matchdate) {
        this.matchdate = matchdate;
    }

    public String getMatchtime() {
        return matchtime;
    }

    public void setMatchtime(String matchtime) {
        this.matchtime = matchtime;
    }

   
   
  
    
    
    
    
}

