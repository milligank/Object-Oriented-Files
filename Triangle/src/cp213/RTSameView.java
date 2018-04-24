package cp213;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class RTSameView extends JPanel{
	
	// ---------------------------------------------------------------
		/**
		 * An inner class that uses an ActionListener to access the buttons. It sets the
		 * model values when the button is pressed.
		 */
		private class buttonListener implements ActionListener {
			/**
			 * Determines whether values are incremented (+) or decremented (-).
			 */
			private int direction = 0;

			public buttonListener(final int direction) {
				this.direction = direction;
			}

			@Override
			public void actionPerformed(final ActionEvent evt) {
				RTSameView.this.model.setBase(RTSameView.this.model.getBase() + this.direction);
				RTSameView.this.model.setHeight(RTSameView.this.model.getHeight() + this.direction);
				RTSameView.this.hypo.setText(RTSameView.f.format(RTSameView.this.model.getHypotenuse()));
			}
		}

		// -------------------------------------------------------------------------------
		/**
		 * An inner class the updates the base and hypotenuse labels whenever the
		 * model's base attribute is updated.
		 */
		private class listener implements PropertyChangeListener {

			@Override
			public void propertyChange(final PropertyChangeEvent evt) {
				if (RTSameView.this.model.getBase() == RTSameView.this.model.getHeight()) {
					RTSameView.this.base_height.setText(RTSameView.f.format(RTSameView.this.model.getBase()));
				}else {
					RTSameView.this.base_height.setText("");
				}
				RTSameView.this.hypo.setText(RTSameView.f.format(RTSameView.this.model.getHypotenuse()));
			}
		}
		
		private class equalButtonListener implements ActionListener {

			public equalButtonListener() {
			}

			@Override
			public void actionPerformed(final ActionEvent evt) {
				final double average = (RTSameView.this.model.getBase() + RTSameView.this.model.getHeight())/2.0;
				RTSameView.this.model.setBase(average);
				RTSameView.this.model.setHeight(average);
				RTSameView.this.hypo.setText(RTSameView.f.format(RTSameView.this.model.getHypotenuse()));
			}
		}
		

		// -------------------------------------------------------------------------------
		/**
		 * The formatter for displaying numeric output.
		 */
		static final DecimalFormat f = new DecimalFormat("###.##");
		/**
		 * Displays the model's base value.
		 */
		private final JLabel base_height = new JLabel(" ");
		/**
		 * Decrements base by 1.
		 */
		private final JButton down = new JButton("-");
		/**
		 * Increments base by 1.
		 */
		private final JButton up = new JButton("+");
		/**
		 * Displays the model's hypotenuse value.
		 */
		private final JLabel hypo = new JLabel(" ");
		/**
		 * The right triangle model.
		 */
		private final RTModel model;
		
		private final JButton equal = new JButton("==");
		
		

		// ---------------------------------------------------------------
		/**
		 * The view constructor.
		 *
		 * @param newModel
		 *            The right triangle model.
		 */
		public RTSameView(final RTModel newModel) {
			this.model = newModel;
			this.layoutView();
			this.registerListeners();
			// Initialize the view labels.
			this.hypo.setText(RTSameView.f.format(this.model.getHypotenuse()));
		}

		// ---------------------------------------------------------------
		/**
		 * Uses the GridLayout to place the labels and buttons.
		 */
		private void layoutView() {
			this.setLayout(new GridLayout(3, 4));
			this.add(this.up);
			this.add(this.down);
			this.add(this.equal);
			this.add(new JLabel("Base/Height: "));
			this.base_height.setHorizontalAlignment(SwingConstants.RIGHT);
			this.add(this.base_height);
			this.add(new JLabel());
			this.add(new JLabel("Hypotenuse: "));
			this.hypo.setHorizontalAlignment(SwingConstants.RIGHT);
			this.add(this.hypo);
		}

		// ---------------------------------------------------------------
		/**
		 * Assigns listeners to the view widgets and the model.
		 */
		private void registerListeners() {
			// Add widget listeners.
			this.up.addActionListener(new buttonListener(1));
			this.down.addActionListener(new buttonListener(-1));
			this.equal.addActionListener(new equalButtonListener());
			// Add model listeners.
			this.model.addPropertyChangeListener(RTModel.BASE_CHANGE, new listener());
			this.model.addPropertyChangeListener(RTModel.HEIGHT_CHANGE, new listener());
		}

		// ---------------------------------------------------------------
}