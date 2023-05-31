/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalgui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 *
 * @author SoFa
 */
public class Owner {
    String username;
    String password;
    int silversold;
    int goldsold;
    int platsold;
    
   public boolean remove(ArrayList<Matches>listofmatches,int noofmatch,File file) throws FileNotFoundException, IOException{
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
        if((noofmatch-1) <= listofmatches.size()){
            
             Matches match=new Matches();
            listofmatches.remove(noofmatch-1);
            match.store(listofmatches,file);
            
         return true;   
        }
        else{
            
            return false;
            
        }
       
     
     
   }
   public void sales(String tickettype,int amount,File file) throws FileNotFoundException{
        Scanner in=new Scanner(file);
        Owner o=new Owner();
        while(in.hasNext()){
            
            o.setUsername(in.next());
            o.setPassword(in.next());
            o.setSilversold(in.nextInt());
            o.setGoldsold(in.nextInt());
            o.setPlatsold(in.nextInt());
            
        }
        if(tickettype.equals("Silver")){
            o.setSsold(amount);
            
        }
        if(tickettype.equals("Gold")){
            o.setGsold(amount);
        }
        if(tickettype.equals("Platinum")){
            o.setPsold(amount);
            
        }
        
        
        PrintWriter write=new PrintWriter(file);
        
        write.println(o.getUsername());
        write.println(o.getPassword());
        write.println(o.getSilversold());
        write.println(o.getGoldsold());
        write.println(o.getPlatsold());
        write.close(); 
        
        
    }

    public boolean modify(ArrayList<Matches>listofmatches,int noofmatch,String tickettype ,int amount,File file) throws FileNotFoundException, IOException{
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
        
          if(tickettype.equals("Silver")){
            
            if(amount<=listofmatches.get(noofmatch-1).getSilverseats()){
                  Matches match=new Matches();
            listofmatches.get(noofmatch-1).setSseats(amount);
            match.store(listofmatches,file);
                return true;
            }
            else{
                return false;
            }
            
                  
        }
            
              
            
        
        
       if(tickettype.equals("Gold")){
            
            
                 if(amount<=listofmatches.get(noofmatch-1).getGoldseats()){
                  Matches match=new Matches();
            listofmatches.get(noofmatch-1).setGseats(amount);
            match.store(listofmatches,file);
                return true;
            }
            else{
                return false;
            }
                  
        }
       if(tickettype.equals("Platinum")){
            
            
                  if(amount<=listofmatches.get(noofmatch-1).getPlatseats()){
                  Matches match=new Matches();
            listofmatches.get(noofmatch-1).setPseats(amount);
            match.store(listofmatches,file);
                return true;
            }
            else{
                return false;
            }
                  
          }
        
        
        
        
    return false;
    
    
    }
    public boolean login(String u,String p,File file) throws FileNotFoundException{
        Scanner in=new Scanner(file);
        Owner owner=new Owner();
        while(in.hasNext()){
            owner.setUsername(in.next());
            owner.setPassword(in.next());
            owner.setSilversold(in.nextInt());
            owner.setGoldsold(in.nextInt());
            owner.setPlatsold(in.nextInt());
        }
        if(u.equals(owner.getUsername())&& p.equals(owner.getPassword())){
           
             
         return true;
    }
  
        else{
            return false;
        }
        
       
    }
     public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSilversold() {
        return silversold;
    }

    public void setSilversold(int silversold) {
        this.silversold = silversold;
    }

    public int getGoldsold() {
        return goldsold;
    }

    public void setGoldsold(int goldsold) {
        this.goldsold = goldsold;
    }

    public int getPlatsold() {
        return platsold;
    }

    public void setPlatsold(int platsold) {
        this.platsold = platsold;
    }
    
    public void setSsold(int amount) {
        silversold+=amount;
    }
 public void setGsold(int amount) {
        goldsold+=amount;
    }
    public void setPsold(int amount) {
        platsold+=amount;
    }
    
    
}

