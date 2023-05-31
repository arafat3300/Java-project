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
import java.util.ArrayList;
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


public class ViewerLoginform extends Scene {
    
     public ViewerLoginform(Parent parent, double d, double d1)
    {
        
        super(parent,d,d1);
        
         Pane hasaccount=new Pane();
      File file=new File("viewer.txt");
       ArrayList<Viewer> listofviewers= new ArrayList<Viewer>();
      
      Text uT=new Text(250,200,"Username");
     uT.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
     TextField uname1=new TextField();
     
    Text pT=new Text(255,273,"Password");
     pT.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
     TextField pass1=new TextField();
     Button Login=new Button("Login");
        Login.setFont(new Font(15));
     Login.setStyle("-fx-font-weight: bold");

     
     
     //Setting the Scene
     uname1.setLayoutX(230);
     uname1.setLayoutY(220);
     pass1.setLayoutX(230);
     pass1.setLayoutY(290);
     Login.setLayoutX(270);
     Login.setLayoutY(330);
     hasaccount.getChildren().addAll(uT,uname1,pT,pass1,Login);
     
     Login.setOnAction(t-> {
//         Pane og=new Pane();
//         OwnerForm o=new OwnerForm(og,600,800);
//        setRoot(og);
         
          Viewer viewer=new Viewer();
           try {
               Viewer s= viewer.login(uname1.getText(),pass1.getText(),listofviewers,file);
           } catch (FileNotFoundException ex) {
               Logger.getLogger(Finalgui.class.getName()).log(Level.SEVERE, null, ex);
           }


      
        });
     
     setRoot(hasaccount);
        
    }
    
    
}
