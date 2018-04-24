package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// --------------------------------------------------------------------
@SuppressWarnings("serial")
public class testTextArea extends JFrame
implements WindowListener {
                // --------------------------------------------------------------------
                /** 
                * @param args
                */
                static final testTextArea frame = new testTextArea("Simple Text Editor");
                static final String newline = System.getProperty("line.separator");
                static final  String space = "    ";

                public static void main(String[] args) {

                        frame.setVisible(true);
                        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

                }   

                // --------------------------------------------------------------------  
                public static final String MONO = "Monospaced Font";
                public static final String PROP = "Proportional Font";

                public static Font mono = new Font("monospaced", Font.PLAIN, 16);
                public static Font prop = new Font("Serif", Font.PLAIN, 16);

                /** 
                * Defines the frame's text area.
                */
                private final JTextArea textArea = new JTextArea(80, 20);

                /** 
                * Places the text area inside a scroll bar pane.
                */
                private final JScrollPane textScroll = new JScrollPane(this.textArea);

                // --------------------------------------------------------------------
                /** 
                * The testTextArea constructor.
                * 
                * @param title
                *            The title to display on the frame.
                */
                public testTextArea(String title) {
                        this.setTitle(title);
                        // Define the file chooser filter.

                        this.layoutView();
                        this.registerListeners();
                }
                // --------------------------------------------------------------------
                /**
                * Lays out the contents of the frame.
                */
                private void layoutView() {
                        // Set a monospaced font for the text area.
                        this.textArea.setFont(testTextArea.mono);
                        // Wrap text on word boundaries within the text area.
                        this.textArea.setWrapStyleWord(true);
                        // Forbid the text area to wrap its contents.
                        this.textArea.setLineWrap(false);
                        // Add the scroll bar pane (and its included text area) to the frame.
                        this.getContentPane().add(this.textScroll);


                        // Set the size of the frame.
                        this.setSize(800, 400);

                        addWindowListener(this);
                        //        addWindowFocusListener(this);
                        //      addWindowStateListener(this);

                }
                /**
                 * Attaches listeners to the frames menu items.
                 */
                 private void registerListeners() {

                         this.textArea.addCaretListener(new CaretListener() {

                                 public void caretUpdate(CaretEvent ce)
                                 {
                                         int dot=ce.getDot();
                                         int mark=ce.getMark();
                                         System.out.println("dot ==="+dot);
                                         System.out.println("mark"
                                         + " ==="+mark);
                                         if(dot!=mark)
                                         {
                                                 //setTitle("Text selected is "+textArea.getSelectedText()+" [dot: "+dot+",mark: "+mark+"]");
                                                 String seltext = textArea.getSelectedText();
                                                 String text = textArea.getText();
                                                 StringBuilder strBuilder = new StringBuilder(textArea.getText());
                                                 int s = textArea.getSelectionStart();
                                                 int e = textArea.getSelectionEnd();
                                                 textArea.setForeground(Color.RED);

                                                 strBuilder.replace(s,e, "HH");

                                                 //textArea.setText(strBuilder.toString());
                                                 System.out.println("s ==="+s);

                                                 textArea.setCaretColor(Color.RED);
                                                 textArea.setFont(testTextArea.mono);


                                                 //textArea.setText(text);
                                                 textArea.setSelectedTextColor(Color.cyan);

                                         }
                                         else setTitle("Text not selected");
                                 }
                         });
                 }

                 //         addWindowListener(this);
                 //        addWindowFocusListener(this);
                 //        addWindowStateListener(this);

                 private void displayMessage(String msg) {
                         this.textArea.append(msg + "\n");
                         System.out.println(msg);
                 }
                 
                 public void windowClosing(WindowEvent e) {
                     displayMessage("WindowListener method called: windowClosing.");
                     
                     if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?", "Confirm exit.", JOptionPane.OK_OPTION, 0, new ImageIcon("")) != 0) {
                         return;
                     }
                     //System.exit(-1);
                     frame.dispose();
                    
                     
                     //A pause so user can see the message before
                     //the window actually closes.
                     /*ActionListener task = new ActionListener() {
                             boolean alreadyDisposed = false;
                             public void actionPerformed(ActionEvent e) {
                            	 	System.out.println("--------------");
                                     if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?", "Confirm exit.", JOptionPane.OK_OPTION, 0, new ImageIcon("")) != 0) {
                                             return;
                                     }
                                     System.exit(-1);
                                     if (frame.isDisplayable()) {
                                             alreadyDisposed = true;
                                             frame.dispose();

                                     }
                             }
                     };*/
                     //Timer timer = new Timer(500, task); //fire every half second
                     //timer.setInitialDelay(2000);        //first delay 2 seconds
                     //timer.setRepeats(false);
                     //timer.start();
             }

             public void windowClosed(WindowEvent e) {
                     //This will only be seen on standard output.
                     displayMessage("WindowListener method called: windowClosed.");
             }


             public void windowOpened(WindowEvent e) {
                     displayMessage("WindowListener method called: windowOpened.");
             }

             public void windowIconified(WindowEvent e) {
                     displayMessage("WindowListener method called: windowIconified.");
             }

             public void windowDeiconified(WindowEvent e) {
                     displayMessage("WindowListener method called: windowDeiconified.");
             }

             public void windowActivated(WindowEvent e) {
                     displayMessage("WindowListener method called: windowActivated.");
             }

             public void windowDeactivated(WindowEvent e) {
                     displayMessage("WindowListener method called: windowDeactivated.");
             }

}


                                                                                                                 