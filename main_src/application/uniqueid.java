package application;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import application.que1.common;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window; 

public class uniqueid extends Application
{
@Override
public void start(Stage primaryStage)
{
	

	primaryStage.setTitle("Generate Unique Coupon Id's");
	
    Label name = new Label("Enter the number of id's to be generated");  


    TextField inputname = new TextField();  
    TextField result = new TextField();  

   /* result.setEditable(false);
    search.setEditable(false);
    delres.setEditable(false);
    modout.setEditable(false);
    showedge.setEditable(false);
    showfoundedge.setEditable(false);
    showdeledge.setEditable(false);
    error1.setEditable(false);*/
    
    Button add=new Button ("Generate id's");
    Button show=new Button("Show");
    Alert errors = new Alert(AlertType.NONE);
    TextArea textArea = new TextArea();
    

    GridPane r = new GridPane();
    r.setPadding(new Insets(15));
    r.setHgap(5);
    r.setVgap(5);
    r.setAlignment(Pos.CENTER);
    Scene scene = new Scene(r);
    r.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    
    r.addRow(0, name); 
    r.addRow(1, inputname);
    r.addRow(2, add);
    r.addRow(3, show);
    r.addRow(5, textArea);
    textArea.setEditable(false); 
    Window window = errors.getDialogPane().getScene().getWindow();
    window.setOnCloseRequest(e -> errors.hide());
   
    ArrayList<String> list = new ArrayList<>();
    add.setOnAction(e -> {
    	
    	//genkey obj = new genkey();
    	Random rand = new Random();
    	String chars = "abcxyzARM";
    	String ch= inputname.getText();
    	
    	try {
    		int n1 = Integer.parseInt(ch);
    		if(n1<0)
    			throw new IllegalArgumentException
    		      (String.format("should be a postive integer"));
    		}
    	catch(NumberFormatException e1) {
    		errors.setHeaderText("Invalid Input");
		    errors.setContentText(e1.getMessage());
		    errors.showAndWait();
    	}
    	catch(Exception e2)
    	{
    		errors.setHeaderText("Invalid Input");
		    errors.setContentText(e2.getMessage());
		    errors.showAndWait();
    	}
    	int n=Integer.parseInt(ch);
    	String res="";
    	for(int i=0;i<n;i++)
    	{
    	int rand_int=rand.nextInt(900)+100;
    	//obj.setrand_i(rand_int);
    	char c = chars.charAt(rand.nextInt(chars.length()));
    	char c2 = chars.charAt(rand.nextInt(chars.length()));
    	res=String.valueOf(rand_int)+c+String.valueOf(rand_int)+c2;
    	list.add(res);
    	}
    	
    	textArea.setText("");
    });
    
    show.setOnAction(e->{
    	List<String> listDistinct = list.stream().distinct().collect(Collectors.toList());
    	for(String num : listDistinct)
    	{
    		//System.out.println(num);
    		textArea.appendText(num);
    		textArea.appendText("\n");
    	}
    	list.clear();
    });
    
   primaryStage.setScene(scene);
     primaryStage.show();
}
	

public static void main(String[] args)
{
launch(args);
}
}