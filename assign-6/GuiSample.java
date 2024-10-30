import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GuiSample implements ActionListener {
	JLabel lbl;
	JTextField fld;

	GuiSample() {
		/* Initial setup */
		JFrame frm = new JFrame("Square Calculation"); // Create new frame
		frm.setSize(500, 300); // Set frame's initial size
		frm.setLayout(new FlowLayout()); // Specify FlowLayout for Layout Manager
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminate when user closes application

		/* Create items */
		fld = new JTextField(5); // Create field with 5 width
		JButton btn = new JButton("Submit"); // Create push buttons
		btn.addActionListener(this); // Set action listners for buttons
		lbl = new JLabel(""); // Create text-based label

		/* Add items to content pane */
		frm.add(fld);
		frm.add(btn);
		frm.add(lbl);

		/* Display frame */
		frm.setVisible(true);
	}

	/* Button processing​ */
	public void actionPerformed(ActionEvent ae) {
		int num = 0;
		boolean invalidFlag = false;

		try {
			num = Integer.parseInt(fld.getText());
		} catch (NumberFormatException ex) {
			invalidFlag = true;
		}

		if (ae.getActionCommand().equals("Submit")) {
			if (invalidFlag) {
				lbl.setText("Error: Invalid number");
			} else {
				int sqr = num * num;
				lbl.setText("Square: " + sqr);
			}
		}
	}

	public static void main(String[] args) {
		new GuiSample();
	}
}