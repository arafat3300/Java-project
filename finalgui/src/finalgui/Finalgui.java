/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalgui;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontPosture;
/**
 *
 * @author SoFa
 */
public class Finalgui extends Application 
{
    
public void start(Stage primaryStage)
    { 
        //INtinalizing the pane and arraylists:
        
       Pane thelayout = new Pane();
        ArrayList<Viewer> listofviewers= new ArrayList<Viewer>();
        ArrayList<Matches> listofmatches=new ArrayList<Matches>();
        ArrayList<Matches> results=new ArrayList<Matches>();
    File file=new File("viewer.txt");
    File filee=new File("owner.txt");
    File fileee=new File("matches.txt");
      ImageView backdrop=new ImageView(new Image("C:\\Users\\aliar\\OneDrive\\Desktop\\background.png"));
      backdrop.setFitHeight(800);
      backdrop.setFitWidth(600);
    Scene mainsc=new Scene(thelayout,600,800);

    //controls 
    Text reg_text=new Text(150,90,"Welcome to the Stadium app");//welcominng text
    reg_text.setFont(Font.font("impact",FontWeight.BOLD,25));
    reg_text.setFill(Color.WHITE);
    
    
     Text name_text=new Text(242,168,"Name");
      name_text.setFill(Color.WHITE);
     name_text.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
     TextField name_textfield=new TextField();
     name_textfield.setLayoutX(210);//firstname textfield
     name_textfield.setLayoutY(180);
     
     
     
     Text Contact_text=new Text(235,230,"Contact");
      Contact_text.setFill(Color.WHITE);
     Contact_text.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
     TextField Contact_textfield=new TextField();
     Contact_textfield.setLayoutX(210);//lastname textfield
     Contact_textfield.setLayoutY(240);
     
        Text address_text=new Text(230,288,"Address");
         address_text.setFill(Color.WHITE);
     address_text.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
     TextField address_textfield=new TextField();
      address_textfield.setLayoutX(210);
     address_textfield.setLayoutY(300);
   
    Text username_text=new Text(230,347,"Username");
     username_text.setFill(Color.WHITE);
     username_text.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
     TextField username_textfield=new TextField();
       username_textfield.setLayoutX(210);//password textfield 
     username_textfield.setLayoutY(360);
     
       Text password_text=new Text(225,407,"Password");
        password_text.setFill(Color.WHITE);
     password_text.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
     TextField password_textfield=new TextField();
         password_textfield.setLayoutX(210); 
     password_textfield.setLayoutY(417);
     
      Text cpassword_text=new Text(208,465,"Confirm Password");
        cpassword_text.setFill(Color.WHITE);
     cpassword_text.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
     TextField cpassword_textfield=new TextField();
     cpassword_textfield.setLayoutX(210); 
     cpassword_textfield.setLayoutY(472);
     
      Text visa_text=new Text(223,520,"Visa Number");
     visa_text.setFill(Color.WHITE);
     visa_text.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
     TextField visa_textfield=new TextField();
     visa_textfield.setLayoutX(210);
     visa_textfield.setLayoutY(530);
     
     
     Button hasacc=new Button("Already have an Account");
     hasacc.setFont(new Font(15));
     hasacc.setStyle("-fx-font-weight: bold");
     Button Donereg=new Button("Create Account");
     Donereg.setFont(new Font(15));
     Donereg.setStyle("-fx-font-weight: bold");
     Button owneracc=new Button("Login As Owner");
     owneracc.setFont(new Font(15));
     owneracc.setStyle("-fx-font-weight: bold");
     
     
     //setting the buttons and labels

  
    
    
 

     hasacc.setLayoutX(180);//has an account button
     hasacc.setLayoutY(603);
     Donereg.setLayoutX(220);//done regestrartion
     Donereg.setLayoutY(563);
     owneracc.setLayoutX(215);//login as owner 
     owneracc.setLayoutY(643);
     thelayout.getChildren().addAll(backdrop,reg_text,name_text,name_textfield,Contact_text,Contact_textfield,address_text,address_textfield,username_text,username_textfield,password_text,password_textfield,cpassword_text,cpassword_textfield,visa_text,visa_textfield,hasacc,Donereg,owneracc);
     
     //Event Handling:
     
 Donereg.setOnAction(ev->
 {
   //validations:      
    try {
                  
         boolean valid=true;

 boolean identical2 = cpassword_textfield.getText().equals(password_textfield.getText());
 
 if(identical2==false)
     {
   
       Alert alertpass = new Alert(Alert.AlertType.WARNING);
       alertpass.setContentText("passwords aren't matching , try again");
       alertpass.show();
          
     }
 if(cpassword_textfield.getText().equals(password_textfield.getText())==true)
       {
           
           identical2 = true ;
       }
  
String name22 =  name_textfield.getText();
for(int i = 0 ; i < name22.length();i++)
{
 char ch = name22.charAt(i);
 int ascii = (int) ch ;
 if (ascii>=48 &&  ascii<=57)
 {
  Alert alertnum = new Alert(Alert.AlertType.WARNING);
       alertnum.setContentText("please enter characters only");
       alertnum.show();
       valid=false;
 }

}

//------------------------------------------------

if(valid&&identical2){
Viewer viewer=new Viewer();
viewer.setName(name_textfield.getText());
viewer.setContact(Contact_textfield.getText());
viewer.setAddress(address_textfield.getText());
viewer.setUsername(username_textfield.getText());
viewer.setVisa(visa_textfield.getText());
viewer.setPassword(password_textfield.getText());
viewer.signup(viewer,listofviewers,file);
valid=false;
}
           } catch (IOException ex) {
               Logger.getLogger(Finalgui.class.getName()).log(Level.SEVERE, null, ex);
           }
     
 });
     
     
     
     
     owneracc.setOnAction(e->
     {
     Pane own=new Pane();
           ImageView iiiv=new ImageView(new Image("C:\\Users\\aliar\\OneDrive\\Desktop\\background.png"));
      iiiv.setFitHeight(800);
      iiiv.setFitWidth(600);
      Text ut=new Text(250,200,"Username");
      ut.setFill(Color.WHITE);
     ut.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
     TextField uname=new TextField();
     
    Text pt=new Text(255,273,"Password");
          pt.setFill(Color.WHITE);
     pt.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
     TextField pass=new TextField();
     Button Login=new Button("Login");
        Login.setFont(new Font(15));
     Login.setStyle("-fx-font-weight: bold");
 
     
         Button back=new Button("<-");
     back.setFont(new Font(15));
     back.setStyle("-fx-font-weight: bold");
     back.setLayoutX(10);
     back.setLayoutY(10);
      
     back.setOnAction(ev->
     {
     
     primaryStage.setScene(mainsc);
     
     
     });
     
     //Setting the Scene 
   
     uname.setLayoutX(230);
     uname.setLayoutY(220);
     pass.setLayoutX(230);
     pass.setLayoutY(290);
     Login.setLayoutX(270);
     Login.setLayoutY(330);
     own.getChildren().addAll(iiiv,ut,uname,pt,pass,Login,back);
     
     Login.setOnAction(t->{
      Owner owner=new Owner();
      
         try {
             boolean z=owner.login(uname.getText(),pass.getText(),filee);
             if(!z){
                 
                 
                 Dialog<String> dialog = new Dialog<>();
                 dialog.setTitle("ERROR"); 
                 dialog.setContentText("Username or password is wrong");
                 ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
     
                 dialog.getDialogPane().getButtonTypes().add(type);
                 
                    Login.setOnAction(f -> {
                    dialog.show();
                    });
             }
             else{
                 
                 GridPane ownermenu=new GridPane();
                 ownermenuform ownn=new ownermenuform(ownermenu,600,800,primaryStage);
                 primaryStage.setScene(ownn);
             }
             
         } catch (FileNotFoundException ex) {
             Logger.getLogger(OwnerForm.class.getName()).log(Level.SEVERE, null, ex);
         }
        
     
     });
     
     Scene ownerloginform=new Scene(own,600,800);
     primaryStage.setScene(ownerloginform);
     
       
     });
 


    hasacc.setOnAction(e->
    {
    
          Pane hasaccount=new Pane();
      ImageView iiiv=new ImageView(new Image("C:\\Users\\aliar\\OneDrive\\Desktop\\background.png"));
      iiiv.setFitHeight(800);
      iiiv.setFitWidth(600);
      Text uT=new Text(250,200,"Username");
      uT.setFill(Color.WHITE);
     uT.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
     TextField uname1=new TextField();
     
    Text pT=new Text(255,273,"Password");
    pT.setFill(Color.WHITE);
     pT.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 20));
     TextField pass1=new TextField();
     Button Login=new Button("Login");
        Login.setFont(new Font(15));
     Login.setStyle("-fx-font-weight: bold");
    
      Button back=new Button("<-");
     back.setFont(new Font(15));
     back.setStyle("-fx-font-weight: bold");
     back.setLayoutX(10);
     back.setLayoutY(10);
      
     back.setOnAction(ev->
     {
     
     primaryStage.setScene(mainsc);
     
     
     });
    
     
     //Setting the Scene
     uname1.setLayoutX(230);
     uname1.setLayoutY(220);
     pass1.setLayoutX(230);
     pass1.setLayoutY(290);
     Login.setLayoutX(270);
     Login.setLayoutY(330);
     hasaccount.getChildren().addAll(iiiv,uT,uname1,pT,pass1,Login,back);
     
     
     //---------------------------------------------------------------------
     //Event handling 
     
     
     Login.setOnAction(t-> {
          Viewer viewer=new Viewer();
           try {
               
                   Viewer s= viewer.login(uname1.getText(),pass1.getText(),listofviewers,file);
               if(uname1.getText().equals(s.getUsername()) && pass1.getText().equals(s.getPassword())){
                   GridPane mm=new GridPane();
                   Viewermenu m=new Viewermenu(mm,600,800,primaryStage);
                   primaryStage.setScene(m);
                   
               }
               else{
                    Dialog<String> dialog = new Dialog<>();
                 dialog.setTitle("ERROR"); 
                 dialog.setContentText("Username or password is wrong");
                 ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
     
                 dialog.getDialogPane().getButtonTypes().add(type);
                 
                    Login.setOnAction(f -> {
                    dialog.show();
                    });
                    
               }
               
              
               
               
           } catch (FileNotFoundException ex) {
               Logger.getLogger(Finalgui.class.getName()).log(Level.SEVERE, null, ex);
           }  catch (IOException ex)
           {
                  Logger.getLogger(Finalgui.class.getName()).log(Level.SEVERE, null, ex);
              }


     
        });
     Scene viewerloginform=new Scene(hasaccount,600,800);
     primaryStage.setScene(viewerloginform);
  
    });
 
 Pane test=new Pane();
 Viewermenu vi=new Viewermenu(test,600,800,primaryStage);
 
  
  primaryStage.setTitle("Stadium Booking System "); 
  primaryStage.getIcons().add(new Image("C:\\Users\\aliar\\OneDrive\\Desktop\\finalicon.png"));
  primaryStage.setScene(mainsc);
  //setRoot(maingrid);
  primaryStage.show();
    }
    
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}