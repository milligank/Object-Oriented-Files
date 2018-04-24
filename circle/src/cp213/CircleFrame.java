package cp213;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Frame to display circle model and its view.
 * 
 * @author David Brown
 * @version 2017-07-17
 */
@SuppressWarnings("serial")
public class CircleFrame extends JFrame {

    // ---------------------------------------------------------------
    /**
     * Inner class that adds color change functionality to buttons.
     */
    private class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(final ActionEvent e) {
	    final JButton button = (JButton) e.getSource();
	    final Color color = button.getBackground();
	    CircleFrame.this.circlePanel.setColor(color);
	}
    }

    // ---------------------------------------------------------------
    /**
     * Inner class that allows use to alter circle display delay.
     */
    private class SliderListener implements ChangeListener {

	@Override
	public void stateChanged(final ChangeEvent arg0) {

	    if (!CircleFrame.this.slider.getValueIsAdjusting()) {
		// Update the delay when the slider stops moving.
		final int delay = CircleFrame.this.slider.getValue();
		model.setDelay(delay);

	    if (delay == 0) {
	    	try {
				model.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }else if (delay > 0 && model.getSuspended()) {
		    // Restart the model if it is currently suspended.
		    synchronized (model) {
			// Continue execution of this view only after the model
			// acknowledges the notify.
			model.setSuspended(false);
			model.notify();
		    }
		}
	    }
	}
    }

    // ---------------------------------------------------------------
    /**
     * Inner class that kills the model's thread when the window is closed.
     */
    private class DisposeListener extends WindowAdapter {

	@Override
	public void windowClosing(final WindowEvent e) {
	    // Cancel the currently running thread.
	    model.stop();
	}
    }

    // ---------------------------------------------------------------
    // Class constants
    static final int DELAY_INIT = 200;
    static final int DELAY_MAX = 400;
    static final int DELAY_MIN = 0;

    // Class attributes.
    private final JButton blueButton = new JButton(" ");
    private final JPanel buttonPanel = new JPanel();
    private CircleView circlePanel = null;
    private CircleModel model = null;
    private final JButton greenButton = new JButton(" ");
    private final JPanel mainPanel = new JPanel();

    private final JButton redButton = new JButton(" ");
    private final JSlider slider = new JSlider(JSlider.HORIZONTAL,
	    CircleFrame.DELAY_MIN, CircleFrame.DELAY_MAX,
	    CircleFrame.DELAY_INIT);
    private final JButton orangeButton  = new JButton(" ");

    /**
     * Constructor.
     * 
     * @param model
     *            The circle model to display.
     */
    public CircleFrame(CircleModel model) {
	this.model = model;
	this.setTitle("Circle");
	circlePanel = new CircleView(model);
	this.setLayout();
	this.registerListeners();
    }

    /**
     * Registers the slider and button listeners.
     */
    private void registerListeners() {
	this.slider.addChangeListener(new SliderListener());
	this.blueButton.addActionListener(new ButtonListener());
	this.greenButton.addActionListener(new ButtonListener());
	this.redButton.addActionListener(new ButtonListener());
	this.orangeButton.addActionListener(new ButtonListener());
	this.addWindowListener(new DisposeListener());
	return;
    }

    /**
     * Defines the frame layout.
     */
    private void setLayout() {
	this.mainPanel.setLayout(new BorderLayout());

	this.slider.setMajorTickSpacing(DELAY_MAX / 4);
	this.slider.setMinorTickSpacing(DELAY_MAX / 16);
	this.slider.setPaintTicks(true);
	this.slider.setPaintLabels(true);
	this.blueButton.setBackground(Color.BLUE);
	this.greenButton.setBackground(Color.GREEN);
	this.redButton.setBackground(Color.RED);
	this.orangeButton.setBackground(Color.ORANGE);

	this.buttonPanel
		.setLayout(new BoxLayout(this.buttonPanel, BoxLayout.Y_AXIS));
	this.buttonPanel.add(this.redButton);
	this.buttonPanel.add(this.greenButton);
	this.buttonPanel.add(this.blueButton);
	this.buttonPanel.add(this.orangeButton);

	this.mainPanel.add(this.slider, BorderLayout.SOUTH);
	this.mainPanel.add(this.circlePanel, BorderLayout.CENTER);
	this.mainPanel.add(this.buttonPanel, BorderLayout.EAST);

	this.setContentPane(this.mainPanel);
    }

}
