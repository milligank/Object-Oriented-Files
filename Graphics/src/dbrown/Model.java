package dbrown;

import java.awt.Shape;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Stores a series of shapes to be added and removed by a graphical view.
 *
 * @author David B. Brown
 * @version 2015-11-18
 */
public class Model {
    /**
     * A list of <code>Shapes</code>.
     */
    private final ArrayList<Shape> shapes = new ArrayList<Shape>();
    private final ArrayList<String> text = new ArrayList<String>();

    /**
     * Allows views to listen to generic changes in the model.
     */
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    /**
     * Adds a new shape to the model.
     *
     * @param s
     *            the new shape to add to the list of shapes.
     */
    public void addShape(final Shape s) {
	this.shapes.add(s);
	this.pcs.firePropertyChange(null, true, false);
    }
    
    public void addtext(final String s) {
    	this.text.add(s);
    	this.pcs.firePropertyChange(null, true, false);
    }

    /**
     * Attaches listeners to the model.
     * 
     * @param listener
     *            The listener to attach to the model.
     */
    public void addPropertyChangeListener(
	    final PropertyChangeListener listener) {
	this.pcs.addPropertyChangeListener(listener);
    }

    /**
     * Returns an iterator for the model's list of shapes.
     *
     * @return the iterator for Shapes.
     */
    public Iterator<Shape> getShapesIterator() {
    	return this.shapes.iterator();
    }
    
    public Iterator<String> getStringIterator() {
    	return this.text.iterator();
    }
}