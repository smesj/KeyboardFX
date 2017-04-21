/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardfx;

import javafx.scene.control.Button;

/**
 *
 * @author smesj
 */
public class ButtonFX extends Button{
    
    char lower;
    char upper;
    int ascii;
    boolean shift;
    
    public ButtonFX(String in){
        super(in);
    }
    
}
