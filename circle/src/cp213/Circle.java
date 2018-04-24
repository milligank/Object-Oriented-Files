package cp213;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * Creates a circle based upon the <code>Ellipse2D.Double</code> class.
 *
 * @author David Brown
 * @version 2017-07-17
 */
@SuppressWarnings("serial")
public class Circle extends Ellipse2D.Double {

    private Point2D.Double center = new Point2D.Double();
    private double radius = 0;

    /**
     * Default constructor. Creates a circle of radius 0 at 0,0.
     */
    public Circle() {
	super();
    }

    /**
     * Defines a circle given a center point and a radius.
     * 
     * @param center
     *            The center point of the circle.
     * @param radius
     *            The radius of the circle.
     */
    public Circle(final Point2D.Double center, final double radius) {
	this.center = center;
	this.radius = radius;
	this.setValues();
    }

    /**
     * Gets the center point of the circle.
     * 
     * @return The centre point.
     */
    public Point2D.Double getCenter() {
	return this.center;
    }

    /**
     * Gets the radius of the circle.
     * 
     * @return The radius.
     */
    public double getRadius() {
	return this.radius;
    }

    /**
     * Moves the center by incrementing x and y.
     * 
     * @param x
     *            The x value to shift the center.
     * @param y
     *            The y value to shift the center.
     */
    public void incrementCenter(double x, double y) {
	this.center.x += x;
	this.center.y += y;
	this.setValues();
	return;
    }

    /**
     * Increments the radius.
     * 
     * @param increment
     *            The amount to increment the radius by.
     */
    public void incrementRadius(final double increment) {
	this.radius += increment;
	this.setValues();
	return;
    }

    /**
     * Sets a new center for the circle.
     * 
     * @param center
     *            The new center point.
     */
    public void setCenter(final Point2D.Double center) {
	this.center = center;
	this.setValues();
	return;
    }

    /**
     * Sets a new radius for the circle.
     * 
     * @param radius
     *            The new radius.
     */
    public void setRadius(final double radius) {
	this.radius = radius;
	this.setValues();
	return;
    }

    /**
     * Adjusts the circle by translating it to an Ellipse frame. In the Ellipse,
     * (x,y) is the upper-left corner of the frame, and width and height are the
     * width and height of the frame.
     */
    private void setValues() {
	this.x = this.center.x - this.radius;
	this.y = this.center.y - this.radius;
	this.height = this.radius * 2;
	this.width = this.radius * 2;
	return;
    }
}