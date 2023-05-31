/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalgui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author SoFa
 */
public class Viewer {
     String name;
    String contact;
    String address;
    String username;
    String Visa;
   protected String password;
    double balance=0;
    
    
    
    

    
    public boolean purchaseticket(ArrayList<Matches> listofmatches,int noofmatch,String tickettype,int amount ,File file) throws FileNotFoundException, IOException{
       
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

    
    
    
    
     public static void signup(Viewer viewer,ArrayList<Viewer> listofviewers ,File file) throws FileNotFoundException, IOException{
         viewer.readfromfilee(listofviewers ,file);
              listofviewers.add(viewer);
              viewer.storee(listofviewers,file);  
         
        
        
    } 
     public boolean pay(String visa,String password,ArrayList<Viewer>listofviewers,File file) throws FileNotFoundException{
         Scanner in=new Scanner(file);
        
        while(in.hasNext()){
         Viewer viewer=new Viewer();
         viewer.setName(in.next());
         viewer.setContact(in.next());
         viewer.setAddress(in.next());
         viewer.setBalance(in.nextDouble());
         viewer.setUsername(in.next());
         viewer.setVisa(in.next());
         viewer.setPassword(in.next());
         listofviewers.add(viewer);
        }
         for(int i=0;i<listofviewers.size();i++){
            if(visa.equals(listofviewers.get(i).getVisa())&& password.equals(listofviewers.get(i).getPassword())){
               
                return true;
            }        
         }
         return false;
     }
   
    public static Viewer login(String username,String password,ArrayList<Viewer>listofviewers,File file) throws FileNotFoundException{
        Scanner in=new Scanner(file);
        
        while(in.hasNext()){
         Viewer viewer=new Viewer();
         viewer.setName(in.next());
         viewer.setContact(in.next());
         viewer.setAddress(in.next());
         viewer.setBalance(in.nextDouble());
         viewer.setUsername(in.next());
         viewer.setVisa(in.next());
         viewer.setPassword(in.next());
         listofviewers.add(viewer);
        }
        Viewer ret=new Viewer();
        
        for(int i=0;i<listofviewers.size();i++){
            if(username.equals(listofviewers.get(i).getUsername())&& password.equals(listofviewers.get(i).getPassword())){
               // System.out.println("Login succesful");
                return listofviewers.get(i);
            }                
        }
      //  System.out.println("User not found");
        return ret;
        
    }
     
    
    public static void storee(ArrayList<Viewer> listofviewers, File file) throws IOException{
        
        PrintWriter write=new PrintWriter(file);
        for(int i=0;i<listofviewers.size();i++){
        write.println(listofviewers.get(i).getName());
        write.println(listofviewers.get(i).getContact());
        write.println(listofviewers.get(i).getAddress());
        write.println(listofviewers.get(i).getBalance());
        write.println(listofviewers.get(i).getUsername());
        write.println(listofviewers.get(i).getVisa());
        write.println(listofviewers.get(i).getPassword());
       
       
        
        }
        write.close();
    }
   
    
    public static ArrayList readfromfilee(ArrayList<Viewer> listofviewers , File file)throws IOException{
       Scanner in=new Scanner(file);
      
        while(in.hasNext()){
            Viewer viewer=new Viewer();
            viewer.setName(in.next());
            viewer.setContact(in.next());
            viewer.setAddress(in.next());
            viewer.setBalance(in.nextDouble());
            viewer.setUsername(in.next());
            viewer.setVisa(in.next());
            viewer.setPassword(in.next());
            
            listofviewers.add(viewer);
            
        }
        
        return listofviewers;
        
    }
    public double balance(double amount){
        balance+=amount;
        return balance;
    }
    
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVisa() {
        return Visa;
    }

    public void setVisa(String Visa) {
        this.Visa = Visa;
    }
    
    
    
}
