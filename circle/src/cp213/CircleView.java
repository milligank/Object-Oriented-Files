package cp213;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

import javax.swing.JPanel;

/**
 * Creates a panel to hold an animated circle.
 * 
 * @author David Brown
 * @version 2017-07-17
 */
@SuppressWarnings("serial")
public class CircleView extends JPanel {

    // ---------------------------------------------------------------
    /**
     * Repaints the circle model.
     */
    private class DisplayListener implements PropertyChangeListener {

	@Override
	public void propertyChange(final PropertyChangeEvent arg0) {
	    CircleView.this.repaint();
	}
    }

    // ---------------------------------------------------------------
    // Attributes.
    private Color color1 = Color.RED;
    private CircleModel model = null;
    private double scale = 1.0;
    

    /**
     * Constructor.
     * 
     * @param model
     *            The circle model to display.
     */
    public CircleView(final CircleModel model) {
    	
	this.model = model;
	this.registerListeners();
    }

    @Override
    public void paintComponent(final Graphics g) {
	final Graphics2D g2d = (Graphics2D) g;
	
		g2d.setColor(this.color1);
		g2d.clearRect(0, 0, this.getWidth(), this.getHeight());

	this.setScale();
	final AffineTransform at = new AffineTransform();
	at.translate(this.getWidth() / 2.0, this.getHeight() / 2.0);
	at.scale(this.scale, this.scale);
	g2d.setTransform(at);

	g2d.fill(this.model.getCircle());
	return;
    }

    /**
     * Register the panel listeners.
     */
    private void registerListeners() {
	this.model.addPropertyChangeListener(new DisplayListener());
    }

    /**
     * Sets the circle fill color.
     *
     * @param color
     *            The new fill color.
     */
    public void setColor(final Color color) {
	this.color1 = color;
    }

    /**
     * Calculate the circle to window scaling. Only one scaling is required to
     * preserve the 'circularity' of the circle.
     */
    private void setScale() {
	this.scale = Math.min(this.getWidth() / (CircleModel.MAX_RADIUS * 2.0),
		this.getHeight() / (CircleModel.MAX_RADIUS * 2.0));
    }

}