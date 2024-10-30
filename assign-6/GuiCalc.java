// Develop a graphic window for taking inputs of admission counts thru fields "CSE" and "CSBS", and a "Submit" button. When the button is pressed, counts should be added and total should be displayed in the same window. You can submit these counts only once and cannot change the counts after submitting. Perform basic validations for the count fields.

// Ensure to write your program on the local machine, compile and run. Finally paste the program here and submit.

// If you get compilation errors, you need to obviously modify the program and re-submit. If you get "X11" runtime error, your program is eligible for testing and you should call the invigilators for manually testing your program. After the evaluation is completed, delete your files from the local machine.

// Hints: Here is a sample GUI program for computing square value.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GuiCalc implements ActionListener {
  JLabel lbl1, lbl2, lbl;
  JTextField fld1, fld2;
  JButton btn;

  GuiCalc() {
    /* Initial setup */
    JFrame frm = new JFrame("Admission Count"); // Create new frame
    frm.setSize(400, 200); // Set frame's initial size
    frm.setLayout(new GridLayout(4, 2)); // set grid layout
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminate when user closes application

    /* Create items */
    lbl1 = new JLabel("CSE Count:"); // create proper labels
    fld1 = new JTextField(5); // Create field with 5 width
    lbl2 = new JLabel("CSBS Count:"); // create proper labels
    fld2 = new JTextField(5); // Create field with 5 width
    btn = new JButton("Submit"); // Create push buttons
    btn.addActionListener(this); // Set action listners for buttons
    lbl = new JLabel("");

    /* Add items to content pane */
    frm.add(lbl1);
    frm.add(fld1);
    frm.add(lbl2);
    frm.add(fld2);
    frm.add(btn);
    frm.add(new JLabel()); // empty space
    frm.add(lbl);

    /* Display frame */
    frm.setVisible(true);
  }

  /* Button processing​ */
  public void actionPerformed(ActionEvent ae) {
    int cseCount = 0, csbsCount = 0;
    boolean invalidFlag = false;

    try {
      cseCount = Integer.parseInt(fld1.getText());
      csbsCount = Integer.parseInt(fld2.getText());
    } catch (NumberFormatException ex) {
      invalidFlag = true;
    }

    if (ae.getActionCommand().equals("Submit")) {
      if (cseCount < 0 || csbsCount < 0) {
        lbl.setText("Error: Value can't be negative");
      } else if (invalidFlag) {
        lbl.setText("Error: Invalid number");
      } else {
        // calculate the total count
        int totalCount = cseCount + csbsCount;
        lbl.setText("Total Students: " + totalCount);
      }

      // disable after one time submission
      fld1.setEnabled(false);
      fld2.setEnabled(false);
      btn.setEnabled(false);
    }
  }

  public static void main(String[] args) {
    new GuiCalc();
  }
}