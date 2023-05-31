/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalgui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author SoFa
 */
public class Viewermenu extends Scene{
    
     public Viewermenu(Parent parent, double d, double d1,Stage primaryStage)
    {
        super(parent, d, d1);
        Pane viewmenu=new Pane();
         
          File file=new File("viewer.txt");
        File filee=new File("owner.txt");
         File fileee=new File("matches.txt");
        ImageView vback=new ImageView(new Image("C:\\Users\\aliar\\OneDrive\\Desktop\\ticket.png"));
        vback.setFitHeight(800);
        vback.setFitWidth(600);
     
     
        
     Button purshase_ticket = new Button("Purshase Ticket");
     purshase_ticket.setFont(new Font(15));
     purshase_ticket.setStyle("-fx-font-weight: bold");
     purshase_ticket.setPrefSize(200, 50);
     purshase_ticket.setLayoutX(200);
     purshase_ticket.setLayoutY(190);     
     
     Button Display_matches=new Button("Display Matches");
     Display_matches.setFont(new Font(15));
     Display_matches.setStyle("-fx-font-weight: bold");
     Display_matches.setPrefSize(200, 50);
     Display_matches.setLayoutX(200);
     Display_matches.setLayoutY(250);
        
    //Event handling :
    Display_matches.setOnAction(ds->{
            try {
                GridPane display=new GridPane();
                displayform o=new displayform(display,600,800,primaryStage);
              primaryStage.setScene(o);
              primaryStage.show();
            } catch (IOException ex) {
                Logger.getLogger(Viewermenu.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    
    
    
    });
    
    
   purshase_ticket.setOnAction(ev->
   {
    Button back=new Button("<-");
    back.setOnAction(e->{setRoot(viewmenu);});
    Pane buy=new Pane();
         ImageView vback2=new ImageView(new Image("C:\\Users\\aliar\\OneDrive\\Desktop\\ticket.png"));
        vback.setFitHeight(800);
        vback.setFitWidth(600);

   Text matchno_text=new Text(230,150," Match Number");
    matchno_text.setFill(Color.BLACK);
   matchno_text.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
 
   TextField matchno_textfield=new TextField();
   matchno_textfield.setLayoutX(230);
   matchno_textfield.setLayoutY(170);
   
     Text amount=new Text(230,290,"Amount of tickets");
   amount.setFill(Color.BLACK);
   amount.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
   
   TextField amountt=new TextField ();
    amountt.setLayoutX(230);
    amountt.setLayoutY(300);
    
  Text tickettype_text=new Text(240,220,"Ticket Type");
   tickettype_text.setFill(Color.BLACK);
   tickettype_text.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
                                 
   String  Tickettypes[]={"Silver","Gold","Platinum"};  
   ComboBox ticket_type=new ComboBox(FXCollections.observableArrayList(Tickettypes));
//   TextField ticket_type=new TextField();
   ticket_type.setLayoutX(250);
   ticket_type.setLayoutY(240);
   
    Text visa=new Text(230,350,"Visa or Master card");
   visa.setFill(Color.BLACK);
   visa.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
   
   TextField visaa=new TextField ();
    visaa.setLayoutX(230);
    visaa.setLayoutY(360);
    
    
     Text pas=new Text(230,410,"Password");
   pas.setFill(Color.BLACK);
   pas.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
   
   TextField pass=new TextField ();
    pass.setLayoutX(230);
    pass.setLayoutY(420);
   
   
   Button pay=new Button("Pay");
     pay.setFont(new Font(15));
     pay.setStyle("-fx-font-weight: bold");
     pay.setLayoutX(250);
     pay.setLayoutY(490);
     pay.setPrefSize(100,50);
     
     pay.setOnAction(py->{
        try {
            
            
           
            try {
                Viewer viewer=new Viewer();
                ArrayList<Viewer> listofviewers=new ArrayList<>(); 
                ArrayList<Matches> listofmatches=new ArrayList<>();
                
                
                boolean s= viewer.pay(visaa.getText(),pass.getText(),listofviewers,file);
                if(!s){
                    
                     Dialog<String> dialog = new Dialog<>();
                    dialog.setTitle("ERROR");
                    dialog.setContentText("payment unsuccessful");
                     ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
     
                 dialog.getDialogPane().getButtonTypes().add(type);
                     dialog.show();
                    
                   
                    
                }else{
                   
                    int matchno= Integer.parseInt(matchno_textfield.getText());
                   String type= ticket_type.getValue().toString();
                   int am=Integer.parseInt(amountt.getText());
                    Viewer v=new Viewer();
                    
                    
                   boolean b= v.purchaseticket(listofmatches, matchno, type, am, fileee);
                    if(b){
                    Dialog<String> dialog = new Dialog<>();
                    dialog.setTitle("Success");
                    dialog.setContentText("payment success");
                     ButtonType typee = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
     
                 dialog.getDialogPane().getButtonTypes().add(typee);
                    dialog.show();
                }
                    
                    
                    else{
                         Dialog<String> dialog = new Dialog<>();
                    dialog.setTitle("ERROR");
                    dialog.setContentText("Seats doesnt exist");
                     ButtonType typee = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
     
                 dialog.getDialogPane().getButtonTypes().add(typee);
                    dialog.show();
                        
                    }
               }
                
                
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Viewermenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            

        } catch (IOException ex) {
            Logger.getLogger(Viewermenu.class.getName()).log(Level.SEVERE, null, ex);
        }
               
     
     
     });
     
     
     

 buy.getChildren().addAll(vback2,back,matchno_text,matchno_textfield,ticket_type,pay,tickettype_text,amount,amountt,pas,pass,visa,visaa);
   
   setRoot(buy);

   
   });
      viewmenu.getChildren().addAll(vback,purshase_ticket,Display_matches);
      setRoot(viewmenu);
    }
    
}
