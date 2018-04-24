package dbrown;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 * Provides a drawing canvas for a Model.
 *
 * @author Charmi Desai
 * @version 2015-11-18
 */
@SuppressWarnings("serial")
public class Easel extends JComponent {

    /**
     * Repaints the easel whenever the model is updated.
     */
    private class ModelListener implements PropertyChangeListener {

	@Override
	public void propertyChange(final PropertyChangeEvent evt) {
	    Easel.this.repaint();
	}
    }

    private Model model = null;

    /**
     * The Easel needs direct access to the Model.
     *
     * @param newModel
     *            the Model to access.
     */
    public Easel(final Model model) {
	this.model = model;
	this.registerListeners();
    }

    /**
     * Randomly defines a shape based upon the current size of the easel. The
     * new shape is passed back to the model to be stored.
     *
     * @param t
     *            the type of shape to define.
     */
    public void defineShape(final String t) {
		final int x1 = (int) (Math.random() * this.getWidth());
		final int y1 = (int) (Math.random() * this.getHeight());
		final int x2 = (int) (Math.random() * this.getWidth());
		final int y2 = (int) (Math.random() * this.getHeight());
	
		if (t.equals("Rectangle")) {
			this.model.addShape(new Rectangle(x1, y1, x2, y2));
		} else if (t.equals("Line")) {
		    this.model.addShape(new Line2D.Double(x1, y1, x2, y2));
		} else if (t.equals("Circle")) {
		    this.model.addShape(new Circle(x1, y1, x2));
		} else if (t.equals("Polygon")){
			Random rand = new Random();
			int n = rand.nextInt((8-3)+1) + 3;
			int[] xpoints = new int[n];
			int[] ypoints = new int[n];
			
			for (int i = 0; i < n; i++) {
				final int x = (int) (Math.random() * this.getWidth());
				final int y = (int) (Math.random() * this.getHeight());
				xpoints[i] = x;
				ypoints[i] = y;
			}
			this.model.addShape(new Polygon(xpoints, ypoints, n));
		}
    }
    
    
    public void defineText(JTextField t) { 	
    	this.model.addtext(t.getText());
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    public void paintComponent(final Graphics g) {
		final Graphics2D g2d = (Graphics2D) g;
	
		// Get a snapshot of the list of shapes in the model. Draw each in turn.
		final Iterator<Shape> i = this.model.getShapesIterator();
		
		Random rand = new Random();
		
		while (i.hasNext()) {
			
			float a = rand.nextFloat();
			float b = rand.nextFloat();
			float c = rand.nextFloat();
			Color randColor = new Color(a, b, c);
			
			Shape s = i.next();
			g2d.setColor(randColor);
			g2d.fill(s);
		    g2d.draw(s);
		}
		
		final Iterator<String> s = this.model.getStringIterator();
		
		while (s.hasNext()) {
			final int x1 = (int) (Math.random() * this.getWidth());
			final int y1 = (int) (Math.random() * this.getHeight());
			g2d.drawString(s.next(), x1, y1);
		}
    }

    /**
     * Registers the model listener.
     */
    private void registerListeners() {
	this.model.addPropertyChangeListener(new ModelListener());
    }
}