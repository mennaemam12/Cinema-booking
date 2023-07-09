/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AddHallForm extends Scene {
    Admin admin = new Admin();
    Label avail=new Label();
    Label AddHall = new Label();
    Label hallName = new Label();
    TextField tfhallName = new TextField();
    Label Rows = new Label();
    TextField tfRows = new TextField();
    Label Columns = new Label();
    TextField tfColumns = new TextField();
    Label silverRows = new Label();
    TextField tfsilverRows = new TextField();
    Label goldRows = new Label();
    TextField tfgoldRows = new TextField();
    Label platinumRows = new Label();
    TextField tfplatinumRows = new TextField();
    Label hName=new Label();
    Label lhName=new Label();
    Label hRows=new Label();
    Label lhRows=new Label();
    Label hColumns=new Label();
    Label lhColumns=new Label();
    Label sR=new Label();
    Label lsR=new Label();
    Label gR=new Label();
    Label lgR=new Label();
    Label pR=new Label();
    Label lpR=new Label();
    Button done = new Button();
    Button reset = new Button();
    Button left = new Button();
    Button right = new Button();
    Label msg = new Label();
    Button display=new Button("Display");
    Button bck;
    Alert alert=new Alert(AlertType.ERROR);

    Alert hallAlert = new Alert(Alert.AlertType.ERROR);
    GridPane hPane = new GridPane();
    GridPane pane = new GridPane();
    GridPane availPane=new GridPane();
    StackPane dPane;
    GridPane matrix;
    HBox hBox=new HBox();
    HBox n=new HBox(hName,lhName);
    HBox r=new HBox(hRows,lhRows);
    HBox c=new HBox(hColumns,lhColumns);
    HBox g=new HBox(gR,lgR);
    HBox p=new HBox(pR,lpR);
    
    int index;

    public AddHallForm(Parent parent, double d, double d1) {
        super(parent, d, d1);

        AddHall.setText("Add Hall Info");
        AddHall.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
        AddHall.setTranslateX(130);
        AddHall.setTranslateY(-10);

        hallName.setText("Hall name:");
        hallName.setFont(Font.font("Times New Roman", 18));

        Rows.setText("Rows:");
        Rows.setFont(Font.font("Times New Roman", 18));

        Columns.setText("Columns: ");
        Columns.setFont(Font.font("Times New Roman", 18));

        silverRows.setText("Silver Rows: ");
        silverRows.setFont(Font.font("Times New Roman", 18));

        goldRows.setText("Gold Rows: ");
        goldRows.setFont(Font.font("Times New Roman", 18));

        platinumRows.setText("Platinum Rows: ");
        platinumRows.setFont(Font.font("Times New Roman", 18));

        done.setText("Add");
        done.setFont(Font.font("Times New Roman", 20));
        done.setOnAction(new DoneHandler());
        done.setCursor(Cursor.HAND);

        reset.setText("Reset");
        reset.setFont(Font.font("Times New Roman", 20));
        reset.setOnAction(new ResetHandler());
        reset.setCursor(Cursor.HAND);
        
        done.setStyle(" -fx-background-color: #d63d62; -fx-background-radius: 10px; -fx-text-fill: #ffffff;");
        AdminForm.setEffect(done);
        reset.setStyle(" -fx-background-color:#f08f1e; -fx-background-radius: 10px; -fx-text-fill: #ffffff;");
        AdminForm.setEffect(reset);
        
        display.setFont(Font.font("Times New Roman", 20));
        display.setOnAction(new ResetHandler());
        display.setCursor(Cursor.HAND);
        display.setStyle(" -fx-background-color: #6e1c5b; -fx-background-radius: 10px; -fx-text-fill: #ffffff;");
        AdminForm.setEffect(display);
        display.setTranslateX(60);
        display.setTranslateY(30);
        display.setOnAction(new DisplayHandler());

        msg.setFont(Font.font("Times New Roman", 15));
        
        HBox name=new HBox(hallName,tfhallName);
        HBox rows=new HBox(Rows,tfRows);
        HBox columns=new HBox(Columns,tfColumns);
        HBox sRows=new HBox(silverRows,tfsilverRows);
        HBox gRows=new HBox(goldRows,tfgoldRows);
        HBox pRows=new HBox(platinumRows,tfplatinumRows);
        HBox buttons=new HBox(reset,done);
        
        name.setSpacing(54);
        rows.setSpacing(88);
        columns.setSpacing(59);
        sRows.setSpacing(36);
        gRows.setSpacing(43);
        pRows.setSpacing(15);
        buttons.setSpacing(60);
        
        name.setTranslateX(55);
        rows.setTranslateX(55);
        columns.setTranslateX(55);
        sRows.setTranslateX(55);
        gRows.setTranslateX(55);
        pRows.setTranslateX(55);
        buttons.setTranslateX(90);
        buttons.setTranslateY(10);

        hPane.add(AddHall, 0, 0);
        hPane.add(name, 0, 1);
        hPane.add(rows, 0, 2);
        hPane.add(columns, 0, 3);
        hPane.add(sRows, 0, 4);
        hPane.add(gRows, 0, 5);
        hPane.add(pRows, 0, 6);
        hPane.add(buttons, 0, 7);
        hPane.add(msg, 0, 7);
        
        
        msg.setTranslateX(120);
        msg.setTranslateY(50);
        
        hPane.setStyle("-fx-background-color: #FFFFFF;");
        hPane.setBorder(Border.stroke(Color.GREY));
        hPane.setPadding(new Insets(20));
        hPane.setMinWidth(500);
        hPane.setMaxWidth(500);
        hPane.setTranslateY(10);
        hPane.setTranslateX(-5);
        hPane.setPadding(new Insets(50));
        hPane.setHgap(20);
        hPane.setVgap(30);
        
        availPane.setPadding(new Insets(10));
        availPane.setVgap(20);
        availPane.setStyle("-fx-background-color: #FFFFFF;");
        availPane.setBorder(Border.stroke(Color.GREY));
        availPane.setMinWidth(250);
        availPane.setMaxWidth(250);
        availPane.setTranslateY(10);
        availPane.setTranslateX(-5);
        availPane.setAlignment(Pos.CENTER);
        
        hName.setText("Name:");
        hName.setFont(Font.font("Times New Roman",FontWeight.BOLD,16));
        
        hRows.setText("Rows:");
        hRows.setFont(Font.font("Times New Roman",FontWeight.BOLD,16));
        
        hColumns.setText("Columns:");
        hColumns.setFont(Font.font("Times New Roman",FontWeight.BOLD,16));
        
        sR.setText("Silver Rows:");
        sR.setFont(Font.font("Times New Roman",FontWeight.BOLD,16));
        
        gR.setText("Gold Rows:");
        gR.setFont(Font.font("Times New Roman",FontWeight.BOLD,16));
        
        pR.setText("Platinum Rows:");
        pR.setFont(Font.font("Times New Roman",FontWeight.BOLD,16));
        
        avail.setFont(Font.font("Times New Roman",FontWeight.BOLD,25));
        avail.setAlignment(Pos.CENTER);
        
        lhName.setFont(Font.font("Times New Roman",16));
        lhRows.setFont(Font.font("Times New Roman",16));
        lhColumns.setFont(Font.font("Times New Roman",16));
        lsR.setFont(Font.font("Times New Roman",16));
        lgR.setFont(Font.font("Times New Roman",16));
        lpR.setFont(Font.font("Times New Roman",16));

        n.setSpacing(67);
        r.setSpacing(70);
        c.setSpacing(45);
        g.setSpacing(33);
        p.setSpacing(5);
        
        n.setTranslateX(45);
        r.setTranslateX(45);
        c.setTranslateX(45);
        g.setTranslateX(45);
        p.setTranslateX(45);
        
        Circle ci=new Circle(2.5);
        right.setText(">");
        right.setFont(Font.font("Times New Roman",FontWeight.BOLD,14));
        right.setTextFill(Color.WHITE);
        left.setText("<");
        left.setFont(Font.font("Times New Roman",FontWeight.BOLD,14));
        left.setTextFill(Color.WHITE);
        right.setShape(ci);
        left.setShape(ci);
        left.setStyle("-fx-background-color:#6e1c5b;");
        right.setStyle("-fx-background-color:#6e1c5b;");
        AdminForm.setEffect(left);
        AdminForm.setEffect(right);
        left.setCursor(Cursor.HAND);
        right.setCursor(Cursor.HAND);
        left.setOnAction(new leftHandler());
        right.setOnAction(new rightHandler());
        left.setTranslateX(-3);
        right.setTranslateX(3);
        
        hBox.setSpacing(20);
        HBox silver=new HBox(sR,lsR);
        silver.setSpacing(25);

        hBox.getChildren().addAll(left,silver,right);
        
         if(!User.halls.isEmpty()){  
            avail.setTranslateX(60);
            avail.setTranslateY(-30);
            avail.setText("Available\n   Halls");
            index=0;
            lhName.setText(User.halls.get(index).hallName);
            lhRows.setText(Integer.toString(User.halls.get(index).rows));
            lhColumns.setText(Integer.toString(User.halls.get(index).columns));
            lsR.setText(Integer.toString(User.halls.get(index).silverRows));
            lgR.setText(Integer.toString(User.halls.get(index).goldRows));
            lpR.setText(Integer.toString(User.halls.get(index).platinumRows));
            
                
            if(User.halls.size()==1){
               left.setVisible(false);
               right.setVisible(false);
            }
            
            availPane.add(avail, 0, 0);
            availPane.add(n, 0, 1);
            availPane.add(r, 0, 2);
            availPane.add(c, 0, 3);
            availPane.add(hBox, 0, 4);
            availPane.add(g, 0, 5);
            availPane.add(p, 0, 6);
            availPane.add(display, 0,7 );
           
       
       }
       else{
           avail.setText("      No\nAvailable\n    Halls");
           availPane.add(avail, 0, 0);
       }
        
        
        pane.add(hPane, 0, 0);
        pane.add(availPane, 1, 0);
        
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(15);
        Image bg=new Image("C:/Users/concept/OneDrive/Desktop/Cinema Booking System/bg.jpg");
        pane.setBackground(new Background(new BackgroundImage(bg,BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,
                   new BackgroundSize(800,600,false,false,true,false))));
        pane.setMinWidth(800);
        pane.setMaxWidth(800);
        HBox box=new HBox(AdminForm.pane,pane);
        setRoot(box);

    }

    class DoneHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent arg0) {
            Hall hall=new Hall();
            msg.setTextFill(Color.RED);
            if (tfhallName.getText().isEmpty() || tfRows.getText().isEmpty() || tfColumns.getText().isEmpty()
                            || tfsilverRows.getText().isEmpty() || tfgoldRows.getText().isEmpty()
                            || tfplatinumRows.getText().isEmpty()) {
                    msg.setText("All Fields Required");
            } else {
                boolean allValid=true;
               
               try{ 
                hall.hallName=tfhallName.getText();
                hall.rows = Integer.parseInt(tfRows.getText());
                hall.columns = Integer.parseInt(tfColumns.getText());
                hall.silverRows = Integer.parseInt(tfsilverRows.getText());
                hall.goldRows = Integer.parseInt(tfgoldRows.getText());
                hall.platinumRows = Integer.parseInt(tfplatinumRows.getText());
               }catch(NumberFormatException x){
                   allValid=false;
                   msg.setText("Integers are required");
               }
               
                  for(int i=0;i<User.halls.size();i++){
                    if(User.halls.get(i).hallName.equals(tfhallName.getText())){
                        allValid=false;
                        alert.setHeaderText("");
                        alert.setContentText("Specified Hall Name is Already Available");
                        alert.showAndWait();
                    }
                }
                  
               if(allValid){

                if (hall.silverRows + hall.goldRows +hall.platinumRows != hall.rows) {
                        hallAlert.setTitle("ERROR");
                        hallAlert.setHeaderText(null);
                        hallAlert.setContentText("Rows Entered Mismatch The Hall Space");
                        hallAlert.showAndWait();
                        tfsilverRows.setText("");
                        tfgoldRows.setText("");
                        tfplatinumRows.setText("");
                } else {
                        admin.addHall(hall, msg);
                        avail.setTranslateX(60);
                        avail.setTranslateY(-30);
                        avail.setText("Available\n   Halls");
                        index=User.halls.size()-1;
                        lhName.setText(User.halls.get(index).hallName);
                        lhRows.setText(Integer.toString(User.halls.get(index).rows));
                        lhColumns.setText(Integer.toString(User.halls.get(index).columns));
                        lsR.setText(Integer.toString(User.halls.get(index).silverRows));
                        lgR.setText(Integer.toString(User.halls.get(index).goldRows));
                        lpR.setText(Integer.toString(User.halls.get(index).platinumRows));
                        
                        if(User.halls.size()==1){
                            left.setVisible(false);
                            right.setVisible(false); 
                            availPane.add(n, 0, 1);
                            availPane.add(r, 0, 2);
                            availPane.add(c, 0, 3);
                            availPane.add(hBox, 0, 4);
                            availPane.add(g, 0, 5);
                            availPane.add(p, 0, 6);
                            availPane.add(display, 0,7 ); 
                        }
                        else
                        {
                           left.setVisible(true);
                           right.setVisible(true); 
                        }
                        
                }

               }
            }

        }

    }

	class ResetHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
	            tfhallName.setText(null);
                    tfRows.setText(null);
                    tfColumns.setText(null);
                    tfsilverRows.setText(null);
                    tfgoldRows.setText(null);
                    tfplatinumRows.setText(null);
                    msg.setText(null);
		}
	}
        
        class leftHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
            if(index==0)
                index=User.halls.size()-1;
            else
                index--;
            lhName.setText(User.halls.get(index).hallName);
            lhRows.setText(Integer.toString(User.halls.get(index).rows));
            lhColumns.setText(Integer.toString(User.halls.get(index).columns));
            lsR.setText(Integer.toString(User.halls.get(index).silverRows));
            lgR.setText(Integer.toString(User.halls.get(index).goldRows));
            lpR.setText(Integer.toString(User.halls.get(index).platinumRows));
           
            if(hPane.isVisible()==false){
                DisplayHandler displayHandler=new DisplayHandler();
                ActionEvent e=new ActionEvent();
                displayHandler.handle(e);
            }
            
        }
         
     }
     
     class rightHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
            if(index==User.halls.size()-1)
                index=0;
            else
                index++;
            lhName.setText(User.halls.get(index).hallName);
            lhRows.setText(Integer.toString(User.halls.get(index).rows));
            lhColumns.setText(Integer.toString(User.halls.get(index).columns));
            lsR.setText(Integer.toString(User.halls.get(index).silverRows));
            lgR.setText(Integer.toString(User.halls.get(index).goldRows));
            lpR.setText(Integer.toString(User.halls.get(index).platinumRows));
            
            if(hPane.isVisible()==false){
                DisplayHandler displayHandler=new DisplayHandler();
                ActionEvent e=new ActionEvent();
                displayHandler.handle(e);
            }
        }
         
     }
     
     class DisplayHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
            hPane.setVisible(false);
             dPane=new StackPane();
             matrix=new GridPane();
            dPane.setStyle("-fx-background-color: #FFFFFF;");
            dPane.setBorder(Border.stroke(Color.GREY));
            dPane.setPadding(new Insets(20));
            dPane.setMinWidth(500);
            dPane.setMaxWidth(500);
            dPane.setTranslateY(10);
            dPane.setTranslateX(-5);
            dPane.setPadding(new Insets(50));
            dPane.setAlignment(Pos.CENTER);
            
            matrix.setMinWidth(500);
            matrix.setMaxWidth(500);
            matrix.setAlignment(Pos.CENTER);
            matrix.setHgap(10);
            matrix.setVgap(10);
            matrix.setTranslateY(10);
            matrix.setTranslateX(-5);
            matrix.setMaxHeight(450);
            
             bck=new Button();
            Image b=new Image("C:/Users/concept/OneDrive/Desktop/Cinema Booking System/back.png");
            ImageView vb=new ImageView(b);
            vb.setPreserveRatio(true);
            vb.setFitWidth(40);
            bck.setGraphic(vb);
            Circle circle=new Circle();
            bck.setShape(circle);
            bck.setTranslateY(-35);
            bck.setTranslateX(10);
            bck.setCursor(Cursor.HAND);
            AdminForm.setEffect(bck);
            bck.setOnAction(new BackHandler());
            
            
            Label[][]seats=new Label[User.halls.get(index).rows][User.halls.get(index).columns];
            for(int i=0;i<User.halls.get(index).rows;i++){
                for(int j=0;j<User.halls.get(index).columns;j++){
                    seats[i][j]=new Label();
                }
            }
            Image silver=new Image("C:/Users/concept/OneDrive/Desktop/Cinema Booking System/silver.png");
            Image gold=new Image("C:/Users/concept/OneDrive/Desktop/Cinema Booking System/gold.png");
            Image platinum=new Image("C:/Users/concept/OneDrive/Desktop/Cinema Booking System/plat.png");
            Image img;
            
            ImageView vs=new ImageView(silver);
            ImageView vg=new ImageView(gold);
            ImageView vp=new ImageView(platinum);
            
            vs.setPreserveRatio(true);
            vs.setFitHeight(20);
            vg.setPreserveRatio(true);
            vg.setFitHeight(20);
            vp.setPreserveRatio(true);
            vp.setFitHeight(20);
            
            Label s=new Label();
            Label g=new Label();
            Label p=new Label();
            Label ls=new Label("Silver seats");
            Label lg=new Label("Gold seats");
            Label lp=new Label("Platinum seats");
            
            s.setGraphic(vs);
            g.setGraphic(vg);
            p.setGraphic(vp);
            
            HBox hs=new HBox(s,ls);
            HBox hg=new HBox(g,lg);
            HBox hp=new HBox(p,lp);
            HBox decSeats=new HBox(bck,hs,hg,hp);
            
            hs.setSpacing(10);
            hg.setSpacing(10);
            hp.setSpacing(10);
            decSeats.setSpacing(30);
            
            dPane.getChildren().add(decSeats);
            decSeats.setTranslateY(-20);
            decSeats.setTranslateX(-40);
            decSeats.setMinWidth(450);
            decSeats.setMaxWidth(450);
                
            Label screen=new Label();
            screen.setStyle("-fx-background-color: #777777;");
            screen.setMinWidth(340);
            screen.setMaxWidth(340);
            screen.setMinHeight(50);
            screen.setMaxHeight(50);
            screen.setTranslateY(220);
            screen.setText("Screen");
            screen.setTextFill(Color.WHITE);
            screen.setAlignment(Pos.CENTER);
            screen.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
            dPane.getChildren().add(screen);
            
            for(int i=0;i<User.halls.get(index).rows;i++)
            {
                if(i<User.halls.get(index).silverRows)
                    img=silver;
                else if(i<User.halls.get(index).silverRows+User.halls.get(index).goldRows)
                    img=gold;
                else
                    img=platinum;
                
                for(int j=0;j<User.halls.get(index).columns;j++)
                {
                    ImageView view=new ImageView(img);
                    view.setPreserveRatio(true);
                    view.setFitHeight(50);
                    seats[i][j].setGraphic(view);
                    matrix.add(seats[i][j], j, i);
                }
            }
            
            pane.add(dPane, 0, 0);
            pane.add(matrix, 0, 0);
        }
     }
      
     class BackHandler implements EventHandler<ActionEvent>
     {

        @Override
        public void handle(ActionEvent t) {
           GridPane pane = new GridPane();
           AddHallForm form = new AddHallForm(pane, 1000, 600);
           CinemaProject.stage.setTitle("Add Hall");
           CinemaProject.stage.setScene(form);
        }
         
     }

}
