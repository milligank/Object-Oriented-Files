package cp213;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

// -------------------------------------------------------------------------------
/**
 * Spawns circle frames when the "Spawn" button is pushed.
 * 
 * @author David Brown
 * @version 2017-07-17
 */
@SuppressWarnings("serial")
public class SpawnView extends JPanel {

    // ---------------------------------------------------------------
    /**
     * Spawns a new circle frame. Each circle frame is given a unique number
     * based upon the static <code>count</code> attribute.
     */
    private class SpawnListener implements ActionListener {

	@Override
	public void actionPerformed(final ActionEvent evt) {
	    final CircleModel model = new CircleModel();
	    final CircleFrame frame = new CircleFrame(model);
	    frame.setSize(SpawnView.SIZE);
	    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	    // Update the location of the next circle frame.
	    SpawnView.this.nextLocation();
	    frame.setLocation(SpawnView.this.location);
	    frame.setVisible(true);
	    // Execute the model with a thread from the thread pool.
	    SpawnView.this.threadPool.execute(model);
	}
    }

    // ---------------------------------------------------------------
    // Define the size and location of the circle frames.
    public static final int HEIGHT = 300;
    public static final int WIDTH = 300;
    public static final Dimension SIZE = new Dimension(SpawnView.WIDTH,
	    SpawnView.HEIGHT);

    // Attributes
    private final Point location = new Point(0, 0);
    // Attributes to handle screen placement.
    private final Dimension screenSize = Toolkit.getDefaultToolkit()
	    .getScreenSize();
    // Spawns new circle frames.
    private final JButton spawnButton = new JButton("Spawn");
    // Provides an unbounded pool of execution threads.
    // private final ExecutorService threadPool = Executors.newCachedThreadPool();
    // Or: limit number of available threads.
    // private final ExecutorService threadPool =
    // private final ExecutorService threadPool =
    // Executors.newFixedThreadPool(4);
    private final ExecutorService threadPool = Executors.newFixedThreadPool(4);
    //	when this is fixed to 4 threads in the pool, only four circles will spawn
    //	but the CircleFrame spawn >4 times
    //	when I close one CircleModel another CircleModel spawns in another CircleFrame

    // -------------------------------------------------------------------------------
    /**
     * Constructor.
     */
    public SpawnView() {
	this.layoutView();
	this.registerListeners();
    }

    /**
     * Lays out the panel components.
     */
    private void layoutView() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		final JLabel instructLabel = new JLabel("Spawn a Circle");
		instructLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		instructLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
		this.add(instructLabel);
		this.spawnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.spawnButton.setAlignmentY(Component.CENTER_ALIGNMENT);
		this.add(this.spawnButton);
		
    }

    /**
     * Determines the location of the next circle frame. Lays out frames from
     * left-to-right, top-to-bottom.
     */
    private void nextLocation() {
	int x = this.location.x + SpawnView.WIDTH;
	int y = this.location.y;

	if (x + SpawnView.WIDTH > this.screenSize.width) {
	    x = 0;
	    y += SpawnView.HEIGHT;
	}
	this.location.setLocation(x, y);
    }

    /**
     * Registers all listeners with the appropriate inner listener classes.
     */
    private void registerListeners() {
	this.spawnButton.addActionListener(new SpawnListener());

    }

    // -------------------------------------------------------------------------------
}
