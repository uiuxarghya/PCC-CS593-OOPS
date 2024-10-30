import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiReverseNum implements ActionListener {
  JLabel lbl;
  JTextField fld;
  JButton btn;

  GuiReverseNum() {
    JFrame frm = new JFrame("Reverse Number");
    frm.setSize(300, 200);
    frm.setLayout(new GridLayout(3, 3));
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    fld = new JTextField(5);
    btn = new JButton("Submit");
    btn.addActionListener(this);
    lbl = new JLabel("");

    frm.add(fld);
    frm.add(btn);
    frm.add(lbl);

    frm.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {
    int num = 0;
    boolean invalidFlag = false;

    try {
      num = Integer.parseInt(fld.getText());
    } catch (NumberFormatException ex) {
      invalidFlag = true;
    }

    if (ae.getActionCommand().equals("Submit")) {
      if (num < 0) {
        lbl.setText("Error: Value can't be negative");
        lbl.setForeground(Color.RED);
      } else if (invalidFlag) {
        lbl.setText("Error: Invalid number");
      } else {
        int rev = 0;
        while (num != 0) {
          int d = num % 10;
          rev = rev * 10 + d;
          num = num / 10;
        }
        lbl.setText("Reversed Number: " + rev);
      }

      fld.setEnabled(false);
      btn.setEnabled(false);

    }

  }

  public static void main(String[] args) {
    new GuiReverseNum();
  }
}