/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalgui;

/**
 *
 * @author SoFa
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class OwnerForm extends Scene
{
    
    public OwnerForm(Parent parent, double d, double d1)
    {
     super(parent, d, d1);
     
     Pane own=new Pane();
      File filee=new File("owner.txt");
      Text ut=new Text(250,200,"Username");
     ut.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
     TextField uname=new TextField();
     
    Text pt=new Text(255,273,"Password");
     pt.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
     TextField pass=new TextField();
     Button Login=new Button("Login");
        Login.setFont(new Font(15));
     Login.setStyle("-fx-font-weight: bold");
 
     
     
     //Setting the Scene
     uname.setLayoutX(230);
     uname.setLayoutY(220);
     pass.setLayoutX(230);
     pass.setLayoutY(290);
     Login.setLayoutX(270);
     Login.setLayoutY(330);
     own.getChildren().addAll(ut,uname,pt,pass,Login);
     
     Login.setOnAction(e->{
      Owner owner=new Owner();
      
         try {
             boolean z=owner.login(uname.getText(),pass.getText(),filee);
             if(!z){System.out.println("Login Unsuccessful");}
             else{
                 System.out.println("Login success");
             }
             
         } catch (FileNotFoundException ex) {
             Logger.getLogger(OwnerForm.class.getName()).log(Level.SEVERE, null, ex);
         }
        
     
     });
     
     
     
      setRoot(own);
    }
    
}
