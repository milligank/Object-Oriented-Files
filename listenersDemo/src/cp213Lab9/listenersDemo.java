package cp213Lab9;

import javax.swing.*;

// --------------------------------------------------------------------
@SuppressWarnings("serial")
public class listenersDemo extends JFrame {
        // --------------------------------------------------------------------
        /** 
        * @param args
        */
        static final listenersDemo frame = new listenersDemo("Simple Text Editor");
       
        public static void main(String[] args) {
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }

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
        * The listenersDemo constructor.
        * 
        * @param title
        *            The title to display on the frame.
        */
        public listenersDemo(String title) {
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
                
                // Wrap text on word boundaries within the text area.
                this.textArea.setWrapStyleWord(true);
                // Forbid the text area to wrap its contents.
                this.textArea.setLineWrap(false);
                // Add the scroll bar pane (and its included text area) to the frame.
                this.getContentPane().add(this.textScroll);
                // Set the size of the frame.
                this.setSize(800, 400); 
              
        }
        /**
        * Attaches listeners to the frames menu items.
        */
        private void registerListeners() {
         

        }

}



                                                                                                                             