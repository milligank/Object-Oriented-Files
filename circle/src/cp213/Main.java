package cp213;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//---------------------------------------------------------------
/**
 * @author David Brown
 * @version 2017-07-17
 */
public class Main {

    // ---------------------------------------------------------------
    /**
     * @param args
     *            Unused.
     */
    public static void main(final String[] args) {
	SwingUtilities.invokeLater(runJFrame);
    }

    // ---------------------------------------------------------------
    // Create a Runnable object to run in the Swing worker thread.
    static Runnable runJFrame = new Runnable() {

	@Override
	public void run() {
	    final JFrame frame = new JFrame("Spawn");
	    frame.setLocation(0, 0);
	    final SpawnView view = new SpawnView();
	    frame.setContentPane(view);
	    frame.setSize(SpawnView.SIZE);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocation(0, 0);
	    frame.setVisible(true);
	}
    };
}
