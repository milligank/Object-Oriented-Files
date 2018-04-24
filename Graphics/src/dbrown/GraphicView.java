package dbrown;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A graphical view of a Model. Contains and Easel and provides buttons for
 * adding shapes to the Model.
 *
 * @author David Brown
 * @version 2015-11-18
 */
@SuppressWarnings("serial")
public class GraphicView extends JPanel {

    /**
     * Informs the Easel of what type of shape to generate.
     */
    private class ShapeListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
		    final String type = ((JButton) e.getSource()).getText();
		    GraphicView.this.easel.defineShape(type);
		}
    }
    
    private class TextListener implements ActionListener {
    
    	public void actionPerformed(final ActionEvent e) {
    		GraphicView.this.easel.defineText(text);
    	}
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {
		final Model model = new Model();
		final GraphicView view = new GraphicView(model);
	
		final JFrame f = new JFrame("Draw Test");
		f.setContentPane(view);
		f.setSize(1000, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
    }

    private final JButton circle = new JButton("Circle");

    private final Easel easel;

    private final JButton line = new JButton("Line");

    private Model model = null;

    private final JButton rectangle = new JButton("Rectangle");
    
    private final JButton polygon = new JButton("Polygon");
    
    private final JTextField text = new JTextField();

    /**
     * Lays out the view and registers the button listeners.
     *
     * @param newModel
     *            the model to view.
     */
    public GraphicView(final Model model) {
		this.model = model;
		this.easel = new Easel(this.model);
		this.layoutView();
		this.registerListeners();
    }

    /**
     * Lays out the graphic components.
     */
    private void layoutView() {
		final JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 1));
		buttonPanel.add(this.line);
		buttonPanel.add(this.circle);
		buttonPanel.add(this.rectangle);
		buttonPanel.add(this.polygon);
		buttonPanel.add(this.text);
	
		this.setLayout(new BorderLayout());
		this.add(buttonPanel, BorderLayout.WEST);
		this.add(this.easel, BorderLayout.CENTER);
    }

    /**
     * Registers the button listeners.
     */
    private void registerListeners() {
		this.line.addActionListener(new ShapeListener());
		this.circle.addActionListener(new ShapeListener());
		this.rectangle.addActionListener(new ShapeListener());
		this.polygon.addActionListener(new ShapeListener());
		this.text.addActionListener(new TextListener());
    }

}