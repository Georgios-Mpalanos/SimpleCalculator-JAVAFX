package my.app.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class PrimaryController {

	@FXML private TextArea textArea = new TextArea();
	
	private int calcValue = 0;
	private String screenText = "";
	private int firstOperand;
	private int secondOperand;
	private boolean first = true;
	private	String operation;
	
	public void updateText(ActionEvent e) {
		textArea.setEditable(false);
		
		String eventSource = e.getSource()+"";
		int buttonNum = Integer.parseInt(eventSource.substring(eventSource.length()-2,eventSource.length()-1));
		
		switch(buttonNum) {
			case 1:
				screenText += "1";
				break;
			case 2:
				screenText += "2";
				break;
			case 3:
				screenText += "3";
				break;
			case 4:
				screenText += "4";
				break;
			case 5:
				screenText += "5";
				break;
			case 6:
				screenText += "6";
				break;
			case 7:
				screenText += "7";
				break;
			case 8:
				screenText += "8";
				break;
			case 9:
				screenText += "9";
				break;
			default:
				screenText += "0";
				break;
		}
		System.out.println(screenText);
		
		if(calcValue < 0) {
			textArea.setText(screenText.substring(1)+"-");
		}else {
			textArea.setText(screenText);
		}
		
		if(first == true) {
			firstOperand = Integer.parseInt(screenText);
			//System.out.println("IM HERE");
		}else {
			secondOperand = Integer.parseInt(screenText);
		}
		
	}
	
	
	
	public void add(ActionEvent e) {
		textArea.setText("");
		screenText = "";
		
		first = false;
		operation = "add";	
	}
	
	public void subtract(ActionEvent e) {
		textArea.setText("");
		screenText = "";
		
		first = false;
		operation = "subtract";
	}
	
	public void calculate(ActionEvent e) {
		if(operation.equals("add")) {
			calcValue = firstOperand + secondOperand;
		}else {
			calcValue = firstOperand - secondOperand;
		}
		
		//System.out.println("First Op: " + firstOperand);
		//System.out.println("Second Op: " + secondOperand);
		
		screenText = calcValue + "";
		
		if(calcValue < 0) {
			textArea.setText(screenText.substring(1)+"-");
		}else {
			textArea.setText(calcValue+"");
		}
		
		first = true;
		
		firstOperand = calcValue;
		secondOperand = 0;
	}
}
