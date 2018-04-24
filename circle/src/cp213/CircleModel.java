package cp213;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

// -------------------------------------------------------------------------------
/**
 * Simple threaded circle. Changes size.
 * 
 * @author David Brown
 * @version 2017-07-17
 */
public class CircleModel implements Runnable {

    // Class constants.
    private static final int INCREMENT = 4;
    private static final int INITIAL_DELAY = 100;
    public static final int MAX_RADIUS = 100;
    public static final int MIN_RADIUS = 12;

    // Class attributes.
    private final Circle circle = new Circle();
    private int delay = CircleModel.INITIAL_DELAY;
    private boolean grow = true;
    // Allows views to listen to generic changes in the model.
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    // The suspend / resume flag.
    private boolean suspended = false;
    // The stop run() flag. 'volatile' means that it is not cached.
    private volatile boolean exit = false;

    /**
     * Attaches propery change listeners to the model.
     *
     * @param listener
     *            The property change listener to attach.
     */
    public void addPropertyChangeListener(
	    final PropertyChangeListener listener) {
	this.pcs.addPropertyChangeListener(listener);
    }

    /**
     * @return Returns the current value of <code>circle</code>.
     */
    public Circle getCircle() {
	return this.circle;
    }

    /**
     * @return Returns the current value of <code>suspended</code>.
     */
    public boolean getSuspended() {
	return this.suspended;
    }

    /**
     * Resizes the circle between MIN_RADIUS and MAX_RADIUS.
     */
    public void resizeCircle() {

	if (this.circle.getRadius() >= CircleModel.MAX_RADIUS) {
	    this.grow = false;
	} else if (this.circle.getRadius() <= CircleModel.MIN_RADIUS) {
	    this.grow = true;
	}
	if (this.grow) {
	    this.circle.incrementRadius(CircleModel.INCREMENT);
	} else {
	    this.circle.incrementRadius(-CircleModel.INCREMENT);
	}
	// Inform listeners the model is updated.
	this.pcs.firePropertyChange(null, null, null);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Runnable#run()
     *
     * Must define block as 'synchronized' in order to call <code>wait</code>
     */
    @Override
    public synchronized void run() {

	try {
	    while (!exit) {
		// Continue processing until the current thread is cancelled by
		// an interrupt.
		// Put the current thread to sleep for delay ms.
		Thread.sleep(this.delay);
		this.resizeCircle();

		if (this.suspended) {
		    this.wait();
		}
	    }
	} catch (final InterruptedException e) {
	    // Thread has been interrupted including during sleep or wait.
	    // Stops immediately in either case.
	    System.out.println("Interrupted!");
	} finally {
	    System.out.println("Stopped!");
	}
	return;
    }

    /**
     * Sets the update delay on the circle. Suspends the changes if the delay is
     * 0. Suspended can only be changed to false from outside the class.
     * 
     * @param delay
     *            The delay in ms.
     */
    public void setDelay(final int delay) {
	this.delay = delay;

	if (this.delay == 0) {
	    this.suspended = true;
	}
    }

    // -------------------------------------------------------------------------------
    /**
     * Sets the value of <code>suspend</code>
     *
     * @param suspended
     *            The new value for <code>suspend</code>
     */
    public void setSuspended(final boolean suspended) {
	this.suspended = suspended;
    }

    // -------------------------------------------------------------------------------
    /**
     * Stops the thread entirely.
     */
    public void stop() {
	this.exit = true;
    }
}
