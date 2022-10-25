
package calculater;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField answer;
    String op ="";
    long number1;
    long number2;
    public void Number (ActionEvent ae){
        String no = ((Button)ae.getSource()).getText();
        answer.setText(answer.getText()+no);
    }

    public void Operation (ActionEvent ae){
    
        String operation = ((Button)ae.getSource()).getText();
        if (!operation.equals("=")){      
            if(!op.equals("")){
                return;
            }
            op = operation;
            number1 = Long.parseLong(answer.getText());
            answer.setText("");
        }else {       
            if(op.equals("")){
                return;
            }
            number2 = Long.parseLong(answer.getText());
            calculate(number1, number2, op);
            op="";
        }
    }  
    public void calculate (long n1, long n2, String op){
    
        switch (op){
        
            case "+" : answer.setText(n1 + n2 + "");break;
            case "-" : answer.setText(n1 - n2 + "");break;
            case "*" : answer.setText(n1 * n2 + "");break;
            case "/" : 
                if (n2 == 0){
                answer.setText("0");break;
                }
                answer.setText(n1/n2+ "");break;  
        }
        
    }
    public void clear(ActionEvent e)
    {
        answer.setText("");
    }
 
    @FXML
    void getNumber(ActionEvent event) {
        String number=((Button)event.getSource()).getText();
        answer.setText(answer.getText()+number);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
