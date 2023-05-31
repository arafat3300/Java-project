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
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import static javafx.scene.text.Font.font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author SoFa
 */
public class ownermenuform extends Scene {  
    
    public ownermenuform(Parent parent, double d, double d1,Stage primaryStage) {
        super(parent, d, d1);
        
             Pane own=new Pane();
 ArrayList<Matches> listofmatches=new ArrayList<Matches>();
  File fileee=new File("matches.txt");
     //ADDING BUTTONS AND SETTING LAYOUT 
      ImageView backdrop=new ImageView(new Image("C:\\Users\\aliar\\OneDrive\\Desktop\\background.png"));
      backdrop.setFitHeight(800);
      backdrop.setFitWidth(600);
      
      
     Button addmatches_butt=new Button("Add Matches");
     addmatches_butt.setFont(new Font(15));
     addmatches_butt.setStyle("-fx-font-weight: bold");
     
    addmatches_butt.setLayoutX(200);
    addmatches_butt.setLayoutY(180);
    addmatches_butt.setPrefSize(200, 50);
    
     Button remove_match=new Button("Remove Matches");
    remove_match.setFont(new Font(15));
    remove_match.setStyle("-fx-font-weight: bold");
    
    remove_match.setLayoutX(200);
    remove_match.setLayoutY(250);
    remove_match.setPrefSize(200, 50);
    
    
    Button modify_button=new Button("Modify Matches");
    modify_button.setFont(new Font(15));
    modify_button.setStyle("-fx-font-weight: bold");
    
    modify_button.setLayoutX(200);
    modify_button.setLayoutY(320);
    modify_button.setPrefSize(200, 50);
    
    
    Button Viewsales=new Button("View Ticket Sales");
    Viewsales.setFont(new Font(15));
    Viewsales.setStyle("-fx-font-weight: bold");
    
    Viewsales.setLayoutX(200);
    Viewsales.setLayoutY(390);
    Viewsales.setPrefSize(200, 50);
    
    Button Display=new Button(" Display Matches");
    Display.setFont(new Font(15));
    Display.setStyle("-fx-font-weight: bold");
    
    Display.setLayoutX(200);
    Display.setLayoutY(450);
    Display.setPrefSize(200, 50);
    own.getChildren().addAll(backdrop,addmatches_butt,remove_match,modify_button,Viewsales,Display);
    
   //Event Handling :
    Viewsales.setOnAction(v->{
            try {
                GridPane sale=new GridPane();
                Salesform sales=new Salesform(sale,600,800,primaryStage);
                primaryStage.setScene(sales);
                primaryStage.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ownermenuform.class.getName()).log(Level.SEVERE, null, ex);
            }
   
   
   });
   
   
   Display.setOnAction(e->{
            try {
                GridPane display=new GridPane();
                Displayformowner o=new Displayformowner(display,600,800,primaryStage);
                primaryStage.setScene(o);
                primaryStage.show();
            } catch (IOException ex) {
                Logger.getLogger(ownermenuform.class.getName()).log(Level.SEVERE, null, ex);
            }
   
               
   });
   //---------------------------------------------------------------------------------
   //mofiy matches event handling 
   modify_button.setOnAction(m->
   {
   Pane mody=new Pane();
      ImageView iv=new ImageView(new Image("C:\\Users\\aliar\\OneDrive\\Desktop\\background.png"));
      iv.setFitHeight(800);
      iv.setFitWidth(600);
     Text match_no=new Text(178,180,"Match Number to Modify ");
      match_no.setFill(Color.WHITE);
     match_no.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
     TextField match_no_field=new TextField(); 
     match_no_field.setLayoutX(205);
     match_no_field.setLayoutY(190);
     
     
    Text tickettype=new Text(180,235,"Choose ticket to Modify ");
     tickettype.setFill(Color.WHITE);
    tickettype.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
     
     
     
     String Tickettype[]={"Silver","Gold","Platinum"};
     ComboBox Ticket_T=new ComboBox(FXCollections.observableArrayList(Tickettype));
     Ticket_T.setLayoutX(218);
     Ticket_T.setLayoutY(250);
     
     Text ticketprice=new Text(100,320,"Enter amount of Tickets you want to remove ");
     ticketprice.setFill(Color.WHITE);
     ticketprice.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
     TextField ticketSeatsfield=new TextField(); 
     ticketSeatsfield.setLayoutX(205);
     ticketSeatsfield.setLayoutY(330);
     
     Button add=new Button("Update ");
     add.setFont(new Font(15));
     add.setStyle("-fx-font-weight: bold");
     add.setLayoutX(240);
     add.setLayoutY(380);
      add.setPrefSize(80, 40);
   
     
     add.setOnAction(e->
     {
       try {
           Owner o=new Owner();
           int noofmatch=Integer.parseInt(match_no_field.getText());
           String type= Ticket_T.getValue().toString();
           int amount=Integer.parseInt(ticketSeatsfield.getText());
           
           boolean modifyy=o.modify(listofmatches, noofmatch, type, amount, fileee);
           if(modifyy){
           Dialog<String> dialog = new Dialog<>();
                    dialog.setTitle("Success");
                    dialog.setContentText("Match modified");
                     ButtonType typee = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
     
                 dialog.getDialogPane().getButtonTypes().add(typee);
                     dialog.show();
           }
           else{
                Dialog<String> dialog = new Dialog<>();
               dialog.setTitle("ERROR");
                    dialog.setContentText("Match may not exist");
                     ButtonType typee = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
     
                 dialog.getDialogPane().getButtonTypes().add(typee);
                     dialog.show();
               
               
           }
           
           
       } catch (IOException ex) {
           Logger.getLogger(ownermenuform.class.getName()).log(Level.SEVERE, null, ex);
       }
     
     
     });
     
     
     
     
     Button back=new Button("<-");
                back.setFont(new Font(15));
                back.setLayoutX(50);
                back.setLayoutY(10);
    
     mody.getChildren().addAll(iv,match_no,match_no_field,tickettype,Ticket_T,ticketprice,ticketSeatsfield,back,add);
     
     back.setOnAction(b->{
     setRoot(own);
     
     });
   
     setRoot(mody);
   
   });
   //--------------------------------------------------------------------------------------------------
   //Add matches event handling 
   addmatches_butt.setOnAction(e->
   {
   Pane add_match =new Pane();
   
   Text match_title=new Text(230,90,"Match Title");
   match_title.setFill(Color.WHITE);
   match_title.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
 
   TextField match_title_textfield=new TextField();
   match_title_textfield.setLayoutX(200);
   match_title_textfield.setLayoutY(100);
   
   
   
   Text Date_text=new Text(230,150,"Date");
      Date_text.setFill(Color.WHITE);

   Date_text.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
   TextField Date_textfield=new TextField();
   Date_textfield.setLayoutX(200);
   Date_textfield.setLayoutY(160);
   
   
   
   Text time_text=new Text(230,220,"Time");
      time_text.setFill(Color.WHITE);

   time_text.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
   TextField time_textfield=new TextField();
   time_textfield.setLayoutX(200);
   time_textfield.setLayoutY(230);
   
   Text silver_price_text=new Text(200,280,"Silver Ticket Price");
      silver_price_text.setFill(Color.WHITE);

   silver_price_text.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
   TextField silver_price_textfield=new TextField();
   silver_price_textfield.setLayoutX(200);
   silver_price_textfield.setLayoutY(300);
   
   Text silver_seats_text=new Text(230,350,"Silver Seats");
      silver_seats_text.setFill(Color.WHITE);

   silver_seats_text.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
   TextField silver_seats_textfield=new TextField();
   silver_seats_textfield.setLayoutX(200);
   silver_seats_textfield.setLayoutY(370);
   
   
   
   Text Gold_price_text=new Text(200,420,"Gold Ticket Price");
      Gold_price_text.setFill(Color.WHITE);
   Gold_price_text.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
   TextField Gold_price_textfield=new TextField();
   Gold_price_textfield.setLayoutX(200);
   Gold_price_textfield.setLayoutY(440);
    
   Text gold_seats_text=new Text(230,490,"Gold Seats ");
      gold_seats_text.setFill(Color.WHITE);

   gold_seats_text.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
   TextField gold_seats_textfield=new TextField();
   gold_seats_textfield.setLayoutX(200);
   gold_seats_textfield.setLayoutY(510);
   
   
   Text Platnium_price_text=new Text(190,560,"Platnium Ticket Price");
      Platnium_price_text.setFill(Color.BLACK);

   Platnium_price_text.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
   TextField Platnium_price_textfield=new TextField();
   Platnium_price_textfield.setLayoutX(200);
   Platnium_price_textfield.setLayoutY(580);
   
   
    Text plat_seats_text=new Text(220,630,"Platinum Seats ");
       plat_seats_text.setFill(Color.BLACK);

   plat_seats_text.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
   TextField plat_seats_textfield=new TextField();
   plat_seats_textfield.setLayoutX(200);
   plat_seats_textfield.setLayoutY(650); 
   
  Button back=new Button("<-");
  back.setFont(new Font(15));
  back.setLayoutX(50);
  back.setLayoutY(10);
  
  
  Button Addmatch=new Button("Add Match");
  Addmatch.setFont(new Font(15));
  Addmatch.setStyle("-fx-font-weight: bold");
  
  Addmatch.setLayoutX(230);
  Addmatch.setLayoutY(680);
  
      ImageView iiv=new ImageView(new Image("C:\\Users\\aliar\\OneDrive\\Desktop\\background.png"));
      iiv.setFitHeight(800);
      iiv.setFitWidth(600);
  add_match.getChildren().addAll(iiv,match_title,match_title_textfield,plat_seats_text,plat_seats_textfield,Date_text,Date_textfield,time_textfield,time_text,silver_price_text,silver_price_textfield,Gold_price_text,Gold_price_textfield,Platnium_price_text,gold_seats_text,gold_seats_textfield,Platnium_price_textfield,silver_seats_text,silver_seats_textfield,Addmatch,back);
   
  
            Addmatch.setOnAction(am->{
       try {
           Matches match=new Matches();
           
           
           match.setMatchname(match_title_textfield.getText());
           
           match.setMatchdate(Date_textfield.getText());
       
           match.setMatchtime(time_textfield.getText());
         
           match.setSilverprice(Double.parseDouble(silver_price_textfield.getText()));
         
           match.setSilverseats(Integer.parseInt( silver_seats_textfield.getText()));
          
           match.setGoldprice(Double.parseDouble(Gold_price_textfield.getText()));
          
           match.setGoldseats(Integer.parseInt(gold_seats_textfield.getText()));
           
           match.setPlatprice(Double.parseDouble(Platnium_price_textfield.getText()));
         
           match.setPlatseats(Integer.parseInt(plat_seats_textfield.getText()));
           
           match.addmatch(match,listofmatches,fileee);
           
           
                          Dialog<String> dialog = new Dialog<>();
                    dialog.setTitle("Success");
                    dialog.setContentText("Match Added");
                     ButtonType typee = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
     
                 dialog.getDialogPane().getButtonTypes().add(typee);
                     dialog.show();
           
       } catch (IOException ex) {
           Logger.getLogger(ownermenuform.class.getName()).log(Level.SEVERE, null, ex);
       }
            
            
           });
            
  

            back.setOnAction(ev->
             {
                 setRoot(own);     
             });
            
       setRoot(add_match);
   });
   //---------------------------------------------------------------------------------------
   //remove matches event handling 
   remove_match.setOnAction(r->
   {
   Pane mody=new Pane();
           ImageView iv1=new ImageView(new Image("C:\\Users\\aliar\\OneDrive\\Desktop\\background.png"));
      iv1.setFitHeight(800);
      iv1.setFitWidth(600);
     Text match_no=new Text(180,250,"Match Number to Remove ");
            match_no.setFill(Color.WHITE);
     match_no.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
     TextField match_no_field=new TextField(); 
     match_no_field.setLayoutX(200);
     match_no_field.setLayoutY(260);
     
    Button Rem=new Button("Remove Match");
    Rem.setFont(font(15));
    Rem.setStyle("-fx-font-weigth:Bold");
    Rem.setLayoutX(200);
    Rem.setLayoutY(290);
     Button back=new Button("<-");
  back.setFont(new Font(15));
  back.setLayoutX(50);
  back.setLayoutY(10);
     
    Rem.setOnAction(re->{
       try {
           Owner o=new Owner();
           int match=Integer.parseInt(match_no_field.getText());
           boolean removee=o.remove(listofmatches, match, fileee);
           if(!removee){
               Dialog<String> dialog = new Dialog<>();
                    dialog.setTitle("ERROR");
                    dialog.setContentText("Match may not exist");
                     ButtonType typee = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
     
                 dialog.getDialogPane().getButtonTypes().add(typee);
                     dialog.show();
               
           }
           else{
               Dialog<String> dialog = new Dialog<>();
                    dialog.setTitle("Success");
                    dialog.setContentText("Match removed");
                     ButtonType typee = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
     
                 dialog.getDialogPane().getButtonTypes().add(typee);
                     dialog.show();
               
               
           }
           
       } catch (IOException ex) {
           Logger.getLogger(ownermenuform.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    
    });
    
     
     
 mody.getChildren().addAll(iv1,match_no,match_no_field,Rem,back);
  back.setOnAction(ev->
             {
                 setRoot(own);     
             });
 
 
 setRoot(mody);
   
   });
   
    
  
      setRoot(own);
        
        
        
        
        
        
        
        
    }
    
   
    
}
