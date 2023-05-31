/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalgui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author aliar
 */
public class Salesform extends Scene{
    
    public Salesform(Parent parent, double d, double d1,Stage primaryStage) throws FileNotFoundException {
        super(parent, d, d1);
        
        VBox pane=new VBox();
        File filee=new File("owner.txt");
        Scanner in=new Scanner(filee);
        Owner o=new Owner();
        while(in.hasNext()){
            
            o.setUsername(in.next());
            o.setPassword(in.next());
            o.setSilversold(in.nextInt());
            o.setGoldsold(in.nextInt());
            o.setPlatsold(in.nextInt());
            
        }
        
        
                  Label Silversold=new Label("Silver tickets sold "+o.getSilversold() );
                  Label Goldsold=new Label("Gold tickets sold "+ o.getGoldsold());           
                  Label Platsold=new Label("plat tickets sold "+ o.getPlatsold());
                  
                  
                   Button back=new Button("<-");
                back.setFont(new Font(15));
                back.setLayoutX(50);
                back.setLayoutY(10);
                
                pane.getChildren().addAll(Silversold,Goldsold,Platsold,back);
                
                 back.setOnAction(ev->
                {
                    
                   GridPane mm=new GridPane();
                   ownermenuform m=new ownermenuform(mm,600,800,primaryStage);
                   primaryStage.setScene(m);

                });
                 pane.setAlignment(Pos.CENTER);
                 
       setRoot(pane);
        
        
    }
    
    
}
