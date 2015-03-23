/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storem.exceptionControl;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Yaovi Elom Kwasi AKA REDE <ederelk@gmail.com>
 */
public class ExceptionControl {
    public static boolean  isIntegerTextField(JTextField myTextField){
        try{
            Integer.parseInt(myTextField.getText());
            return true;
        }catch(NumberFormatException e){
            if("For input string: \"\"".equals(e.getMessage())){
                return true;
            }
           return  false;
        }
    }
    public static boolean  isEmptyTextField(JTextField myTextField){
       if(myTextField.getText().replace("\'", "\\'").trim().isEmpty()){
           return true;
       }else
       return false;
    }
}
