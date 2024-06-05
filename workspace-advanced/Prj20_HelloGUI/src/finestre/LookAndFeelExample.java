package finestre;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class LookAndFeelExample extends JFrame  {
  public LookAndFeelExample() {
    super("LookAndFeelExample");
    getContentPane().setLayout(new GridLayout(0, 1));
    ButtonGroup group = new ButtonGroup();
    ActionListener buttonListener = new ButtonListener();
    getContentPane().add(new JLabel("Scegli un Look & Feel"));
    
    UIManager.LookAndFeelInfo[] lookAndFeelList = UIManager.getInstalledLookAndFeels();
    for ( int i = 0; i < lookAndFeelList.length; i++) {
      JRadioButton b = new JRadioButton(lookAndFeelList[i].getClassName());
      b.addActionListener(buttonListener);
      group.add(b);
      getContentPane().add(b);
    }
    pack();
  }
  public void changeLookAndFeel(String s) {
    try {
      UIManager.setLookAndFeel(s);
      SwingUtilities.updateComponentTreeUI(this);
    }
    catch (Exception ex) {}
  }
  class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JRadioButton b = (JRadioButton)e.getSource();
      changeLookAndFeel(b.getText());
    }
  }
  
  public static void main(String argv[]) {
    LookAndFeelExample e = new LookAndFeelExample();
    e.setVisible(true);
  }
}
