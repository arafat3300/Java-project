/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalgui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
public class Displayformowner extends Scene {
    
    public Displayformowner(Parent parent, double d, double d1,Stage primaryStage) throws IOException {
        super(parent, d, d1);
        ScrollPane p=new ScrollPane();
        VBox pane=new VBox();
        StackPane forimage=new StackPane();
        File fileee=new File("matches.txt");
        ArrayList<Matches> results=new ArrayList<Matches>();
        ArrayList<Matches> listofmatches=new ArrayList<Matches>();
                   Matches match=new Matches();
                   results= match.readfromfile(listofmatches , fileee);
          ImageView iiiv=new ImageView(new Image("C:\\Users\\aliar\\OneDrive\\Desktop\\Screenshot (22).png"));
      iiiv.setFitHeight(800);
      iiiv.setFitWidth(600);
  
                    
                for(int i=0;i<results.size();i++){
                    String n=Integer.toString(i);
                    
                    Text Maatchno=new Text("("+n+")");
                 Maatchno.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 15));
                     Maatchno.setFill(Color.WHITE);
                     
                     
                    Text matchtitle1=new Text(results.get(i).getMatchname() +"     "+results.get(i).getMatchdate()+"     "+results.get(i).getMatchtime());
                     matchtitle1.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 15));
                     matchtitle1.setFill(Color.WHITE);
                     
                     
                   Text tickets1=new Text("silver seats left     "+results.get(i).getSilverseats()+"          gold seats left "+results.get(i).getGoldseats()+"            plat seats left "+results.get(i).getPlatseats());
                     tickets1.setFill(Color.WHITE);
                   
                   tickets1.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 15));
                   // Label tickets=new Label("silver seats left     "+results.get(i).getSilverseats()+"          gold seats left "+results.get(i).getGoldseats()+"            plat seats left "+results.get(i).getPlatseats());
                   
                    Text price=new Text("silver tickets price "+results.get(i).getSilverprice()+"  gold tickets price "+results.get(i).getGoldprice()+"  platinum tickets price "+results.get(i).getPlatprice());
                         price.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 15));
                         price.setFill(Color.WHITE);
                   
                  
                   Text space=new Text("------------------------------------------------------------------------");
                 space.setFont(Font.font("Aharoni", FontWeight.BOLD, FontPosture.ITALIC, 15));
                     space.setFill(Color.WHITE);
                    pane.getChildren().addAll(Maatchno,matchtitle1,tickets1,price,space);
                }
        
                
                 Button back=new Button("Back");
                back.setPrefSize(100, 50);
                back.setFont(new Font(20));
                back.setStyle("-fx-font-weigth:Bold");
                back.setLayoutX(50);
                back.setLayoutY(10);
                 
                
                back.setOnAction(ev->
                {
                    
                   GridPane mm=new GridPane();
                   ownermenuform m=new ownermenuform(mm,600,800,primaryStage);
                   primaryStage.setScene(m);

                });
                   
   
                pane.getChildren().add(back);
         forimage.getChildren().addAll(iiiv,pane);
         pane.setAlignment(Pos.CENTER);
       p.setContent(forimage);
         setRoot(p);
    }
}
