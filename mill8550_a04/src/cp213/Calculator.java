package cp213;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.Border;

 
public class Calculator extends JFrame {
 
	private static final long serialVersionUID = 1L;

    JButton zero = new JButton("0");
    JButton one = new JButton("1");
    JButton two = new JButton("2");
    JButton three = new JButton("3");
    JButton four = new JButton("4");
    JButton five = new JButton("5");
    JButton six = new JButton("6");
    JButton seven = new JButton("7");
    JButton eight = new JButton("8");
    JButton nine = new JButton("9");
    JButton plus = new JButton("+");
    JButton minus = new JButton("-");
    JButton times = new JButton("*");
    JButton divide = new JButton("/");
    JButton empty = new JButton(" ");
    JButton clear = new JButton("C");
    JButton equals = new JButton("=");
    String value;
    char operator;
    JTextField input = new JTextField(42);
    JTextField output = new JTextField(42);
 
    public static void main(String[] args) {
        // TODO code application logic here
    	Calculator calc = new Calculator();
        calc.setTitle("Calculator");
        calc.setSize(500,600);
        calc.setLocationRelativeTo(null);
                calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setVisible(true);
    }
 
    public Calculator() {
        
        JPanel buttonpanel = new JPanel();
        buttonpanel.setLayout(new GridLayout(4, 5));
        buttonpanel.add(seven);
        buttonpanel.add(eight);
        buttonpanel.add(nine);
        buttonpanel.add(divide);
        buttonpanel.add(clear);
        buttonpanel.add(four);
        buttonpanel.add(five);
        buttonpanel.add(six);
        buttonpanel.add(times);
        buttonpanel.add(empty = new JButton(""));
        buttonpanel.add(one);
        buttonpanel.add(two);
        buttonpanel.add(three);
        buttonpanel.add(minus);
        buttonpanel.add(empty = new JButton(""));
        buttonpanel.add(empty = new JButton(""));
        buttonpanel.add(zero);
        buttonpanel.add(empty = new JButton(""));
        buttonpanel.add(plus);
        buttonpanel.add(equals);
        
        buttonpanel.setBorder(BorderFactory.createLineBorder(Color.yellow));
        final Color light_grey = new Color(204,204,204);
        Font font = new Font("Courier", Font.BOLD,18);
        
        Border blackline;
        blackline = BorderFactory.createLineBorder(Color.black, 3);

        JPanel p2 = new JPanel();
        p2.add(output = new JTextField(42));
        output.setPreferredSize(new Dimension(20, 170));
        output.setBackground(light_grey);
        output.setBorder(blackline);
		output.setFont(font);
        output.setHorizontalAlignment(JTextField.CENTER);
        output.setEditable(false);
        
        
        JPanel p3 = new JPanel();
        p3.add(input = new JTextField(42));
        input.setPreferredSize(new Dimension(20, 175));
        input.setBackground(light_grey);
        input.setBorder(blackline);
        input.setFont(font);
        input.setHorizontalAlignment(JTextField.CENTER);
        input.setEditable(false);
        input.setEditable(false);
        
        
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3,0));
        p.add(p3, BorderLayout.PAGE_START);
        p.add(p2, BorderLayout.CENTER);
        p.add(buttonpanel, BorderLayout.PAGE_END);

        add(p);
        //input.setLineWrap(true);
        //input.setWrapStyleWord(true);
        input.setEditable(false);
 
        zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
            	String temp = input.getText();
                input.setText(temp + "0");
            }
        });
 
        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
            	String temp = input.getText();
                input.setText(temp + "1");
            }
        });
 
        two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
            	String temp = input.getText();
                input.setText(temp + "2");
            }
        });
 
        three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
            	String temp = input.getText();
                input.setText(temp + "3");
            }
        });
 
        four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
            	String temp = input.getText();
                input.setText(temp + "4");
            }
        });
 
        five.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
            	String temp = input.getText();
                input.setText(temp + "5");
            }
        });
 
        six.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
            	String temp = input.getText();
                input.setText(temp + "6");
            }
        });
 
        seven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
            	String temp = input.getText();
                input.setText(temp + "7");
            }
        });
 
        eight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
            	String temp = input.getText();
                input.setText(temp + "8");
            }
        });
 
        nine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
            	String temp = input.getText();
                input.setText(temp + "9");
            }
        });
 
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
            	String temp = input.getText();
                input.setText(temp + "+");
                operator = '+';
            }
        });
 
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
            	String temp = input.getText();
                input.setText(temp + "-");
                operator = '-';
            }
        });
 
        times.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
            	String temp = input.getText();
                input.setText(temp + "*");
                operator = '*';
            }
        });
 
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
            	String temp = input.getText();
                input.setText(temp + "/");
                operator = '/';
            }
        });
 
 
        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                String leftSide;
                String rightSide;
                String temp;
                double result;
                try {
                    leftSide = input.getText().substring(0, input.getText().indexOf(operator + ""));
                    rightSide = input.getText().substring(input.getText().indexOf(operator + "") + 1, input.getText().length());
                    switch (operator) {
                        case '+':
                        	temp = input.getText();
                            input.setText(temp + "=");
                            result = (((Double.parseDouble(leftSide)
                                    + Double.parseDouble(rightSide))));
                            output.setText(String.valueOf(result));
                            break;
                        case '-':
                         	temp = input.getText();
                            input.setText(temp + "=");
                            result = (((Double.parseDouble(leftSide)
                                    - Double.parseDouble(rightSide))));
                            output.setText(String.valueOf(result));
                            break;
                        case '/':
                           	temp = input.getText();
                            input.setText(temp + "=");
                            result = (((Double.parseDouble(leftSide)
                                    / Double.parseDouble(rightSide))));
                            output.setText(String.valueOf(result));
                            break;
                        case '*':
                           	temp = input.getText();
                            input.setText(temp + "=");
                            result = (((Double.parseDouble(leftSide)
                                    * Double.parseDouble(rightSide))));
                            output.setText(String.valueOf(result));
                            break;
 
                        default:
                        	output.setText(" No Result... ");
 
                            break;
                    }
                } catch (Exception e) {
                }
            }
        });
 
 
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                input.setText(null);
                output.setText(null);
            }
        });
    }
}  