/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalgui;

/**
 *
 * @author SoFa
 */
public abstract class Ticket {
    
     double silverprice ;
double goldprice;
double platprice;

int silverseats;
int goldseats;
int platseats;
 public double getSilverprice() {
        return silverprice;
    }

    public void setSilverprice(double silverprice) {
        this.silverprice = silverprice;
    }

    public double getGoldprice() {
        return goldprice;
    }

    public void setGoldprice(double goldprice) {
        this.goldprice = goldprice;
    }

    public double getPlatprice() {
        return platprice;
    }

    public void setPlatprice(double platprice) {
        this.platprice = platprice;
    }

    public int getSilverseats() {
        return silverseats;
    }

    public void setSilverseats(int silverseats) {
        this.silverseats = silverseats;
    }

    public int getGoldseats() {
        return goldseats;
    }

    public void setGoldseats(int goldseats) {
        this.goldseats = goldseats;
    }

    public int getPlatseats() {
        return platseats;
    }

    public void setPlatseats(int platseats) {
        this.platseats = platseats;
    }
  public void setSseats(int amount) {
        silverseats-=amount;
    }
 public void setGseats(int amount) {
        goldseats-=amount;
    }
    public void setPseats(int amount) {
        platseats-=amount;
    }
     
}


