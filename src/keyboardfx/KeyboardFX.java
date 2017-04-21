/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardfx;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author smesj
 */
public class KeyboardFX extends Application {
    
    boolean shift = false;
    TextField textfield = new TextField();
    String text = "";
    StringBuilder sb = new StringBuilder(text);
    ArrayList<ButtonFX> buttons = new ArrayList();
    
    @Override
    public void start(Stage primaryStage) {

        String sym1 = "!#$%^&*(){}[]";
        char[] sym1c = sym1.toCharArray();
        String sym2 = "@<>,./|\\+=-_?";
        char[] sym2c = sym2.toCharArray();
        String num = "1234567890";
        char[] nums = num.toCharArray();
        String str1 = "qwertyuiop"; 
        char[] keys1 = str1.toCharArray();
        String str2 = "asdfghjkl";
        char[] keys2 = str2.toCharArray();
        String str3 = "zxcvbnm";
        char[] keys3 = str3.toCharArray();
        
        HBox sym1b = new HBox();
        sym1b.setAlignment(Pos.CENTER);
        HBox sym2b = new HBox();
        sym2b.setAlignment(Pos.CENTER);
        HBox numB = new HBox();
        numB.setAlignment(Pos.CENTER);
        HBox box1 = new HBox();
        box1.setAlignment(Pos.CENTER);
        HBox box2 = new HBox();
        box2.setAlignment(Pos.CENTER);
        HBox box3 = new HBox();
        box3.setAlignment(Pos.CENTER);
        HBox spaceb = new HBox();
        spaceb.setAlignment(Pos.CENTER);
        HBox textb = new HBox();
        textb.setAlignment(Pos.CENTER);
        
 //line 1       
        for (int i=0; i<sym1c.length; i++){
            ButtonFX but = new ButtonFX(String.valueOf(sym1c[i]));
            sym1b.getChildren().add(but); 
            
            but.lower = sym1c[i];
            but.ascii = (int)sym1c[i];
            
            but.setOnAction(new EventHandler<ActionEvent>() {
                @Override 
                public void handle(ActionEvent e) {
                    text = text + but.lower;
                    textfield.setText(text);
                }
            });
        }
 // line 2      
        for (int i=0; i<sym2c.length; i++){
            ButtonFX but = new ButtonFX(String.valueOf(sym2c[i]));
            sym2b.getChildren().add(but); 
            
            but.lower = sym2c[i];
            but.ascii = (int)sym2c[i];
            
            but.setOnAction(new EventHandler<ActionEvent>() {
                @Override 
                public void handle(ActionEvent e) {
                    text = text + but.lower;
                    textfield.setText(text);
                }
            });
        }
//line 3       
        for (int i=0; i<nums.length; i++){
            ButtonFX but = new ButtonFX(String.valueOf(nums[i]));
            numB.getChildren().add(but); 
            
            but.lower = nums[i];
            but.ascii = (int)nums[i];
            
            but.setOnAction(new EventHandler<ActionEvent>() {
                @Override 
                public void handle(ActionEvent e) {
                    text = text + but.lower;
                    textfield.setText(text);
                }
            });
        }
//line 4
        for (int i=0; i<keys1.length; i++){
            ButtonFX but = new ButtonFX(String.valueOf(keys1[i]));
            box1.getChildren().add(but);
            buttons.add(but);
            
            
            but.lower = keys1[i];
            but.ascii = (int)keys1[i];
            but.upper = (char)(but.ascii-32);
            
            but.setOnAction(new EventHandler<ActionEvent>() {
                @Override 
                public void handle(ActionEvent e) {
                    if (shift){
                        text = text + but.upper;
                        textfield.setText(text);
                    }
                    else{
                        text = text + but.lower;
                        textfield.setText(text);
                    }
                }
            });
        }
//line 5
        for (int i=0; i<keys2.length; i++){
            ButtonFX but = new ButtonFX(String.valueOf(keys2[i]));
            box2.getChildren().add(but);
            buttons.add(but);
            
            but.lower = keys2[i];
            but.ascii = (int)keys2[i];
            but.upper = (char)(but.ascii-32);
            
            but.setOnAction(new EventHandler<ActionEvent>() {
                @Override 
                public void handle(ActionEvent e) {
                    if (shift){
                        text = text + but.upper;
                        textfield.setText(text);
                    }
                    else{
                        text = text + but.lower;
                        textfield.setText(text);
                    }
                }
            });
        }
        Button del = new Button("Delete");
        del.setOnAction(new EventHandler<ActionEvent>() {
                @Override 
                public void handle(ActionEvent e) {
                    if (text.length() > 0){
                        String temp = text;
                        String left = temp.substring(0,text.length()-1);
                        text = left;
                        textfield.setText(text);
                    }
                }
            });
        box2.getChildren().add(del);
//line 6
        Button shift1 = new Button("Shift");
        shift1.setOnAction(new EventHandler<ActionEvent>() {
                @Override 
                public void handle(ActionEvent e) {
                    if (shift){
                        shift = false;
                        for (int i=0; i < buttons.size(); i++){
                            ButtonFX temp = buttons.get(i);
                            temp.setText(String.valueOf(temp.lower));
                        }
                    }
                    else{
                        shift = true;
                        for (int i=0; i < buttons.size(); i++){
                            ButtonFX temp = buttons.get(i);
                            temp.setText(String.valueOf(temp.upper));
                        }
                    } 
                }
            });
        box3.getChildren().add(shift1);
        
        for (int i=0; i<keys3.length; i++){
            ButtonFX but = new ButtonFX(String.valueOf(keys3[i]));
            box3.getChildren().add(but);
            buttons.add(but);
            
            but.lower = keys3[i];
            but.ascii = (int)keys3[i];
            but.upper = (char)(but.ascii-32);
            
            but.setOnAction(new EventHandler<ActionEvent>() {
                @Override 
                public void handle(ActionEvent e) {
                    if (shift){
                        text = text + but.upper;
                        textfield.setText(text);
                    }
                    else{
                        text = text + but.lower;
                        textfield.setText(text);
                    }
                }
            });            
        }
        Button shift2 = new Button("Shift");
        shift2.setOnAction(new EventHandler<ActionEvent>() {
                @Override 
                public void handle(ActionEvent e) {
                    if (shift){
                        shift = false;
                        for (int i=0; i < buttons.size(); i++){
                            ButtonFX temp = buttons.get(i);
                            temp.setText(String.valueOf(temp.lower));
                        }
                    }
                    else{
                        shift = true;
                        for (int i=0; i < buttons.size(); i++){
                            ButtonFX temp = buttons.get(i);
                            temp.setText(String.valueOf(temp.upper));
                        }
                    } 
                }
            });
        box3.getChildren().add(shift2);
        
//line 7
        Button space = new Button();
        space.setOnAction(new EventHandler<ActionEvent>() {
                @Override 
                public void handle(ActionEvent e) {
                    text = text + " ";
                    textfield.setText(text);
                }
            });
        spaceb.getChildren().add(space);
        space.setMinWidth(200);
// line 8
        textfield.setMinWidth(300);
        textb.getChildren().add(textfield);
        
//assemble elements    
        VBox root = new VBox();
        root.getChildren().addAll(sym1b,sym2b,numB,box1,box2,box3,spaceb,textb);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("KeyboardFX");
        primaryStage.setScene(scene);
        primaryStage.show();    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
