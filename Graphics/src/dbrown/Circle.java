package dbrown;

import java.awt.geom.Ellipse2D;

/**
 * Creates a circle based upon the <code>Ellipse2D.Double</code> class.
 *
 * @author <a href="http://www.apl.jhu.edu/~hall/java/Java2D-Tutorial.html">
 *         Marty Hall </a>
 *
 * @author David Brown
 * @version 2015-11-18
 */
@SuppressWarnings("serial")
class Circle extends Ellipse2D.Double {

    public Circle(final double centerX, final double centerY,
	    final double radius) {
	// Call the Ellipse constructure with major and minor axes the same
	// size.
	super(centerX - radius, centerY - radius, 2.0 * radius, 2.0 * radius);
    }
}