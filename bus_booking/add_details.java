package bus_booking;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
public class add_details extends JFrame{
	private JPanel contentPane;
    private JButton btnNewButton;
    String bus_cond, bus_driv,bus_own, bus_id;
    int route=10,nos;
    public add_details() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(450, 190, 1024, 800);
    setResizable(false);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblUsername = new JLabel("Bus Conductor: ");
    lblUsername.setBackground(Color.BLACK);
    lblUsername.setForeground(Color.BLACK);
    lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblUsername.setBounds(250, 166, 193, 52);
    contentPane.add(lblUsername);
    
    JTextField textField = new JTextField();
    textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
    textField.setBounds(481, 166, 381, 68);
    contentPane.add(textField);
    textField.setColumns(10);
    
    JLabel lblUsername2 = new JLabel("Bus ID : ");
    lblUsername2.setBackground(Color.BLACK);
    lblUsername2.setForeground(Color.BLACK);
    lblUsername2.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblUsername2.setBounds(250, 250, 193, 52);
    contentPane.add(lblUsername2);
    
    JTextField textField2 = new JTextField();
    textField2.setFont(new Font("Tahoma", Font.PLAIN, 20));
    textField2.setBounds(481, 250, 381, 68);
    contentPane.add(textField2);
    textField2.setColumns(10);
    
    JLabel lblUsername3 = new JLabel("Number of seats : ");
    lblUsername3.setBackground(Color.BLACK);
    lblUsername3.setForeground(Color.BLACK);
    lblUsername3.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblUsername3.setBounds(250, 334, 193, 52);
    contentPane.add(lblUsername3);
    
    JTextField textField3 = new JTextField();
    textField3.setFont(new Font("Tahoma", Font.PLAIN, 20));
    textField3.setBounds(481, 334, 381, 68);
    contentPane.add(textField3);
    textField3.setColumns(10);
    
    JLabel lblUsername4 = new JLabel("Bus Driver : ");
    lblUsername4.setBackground(Color.BLACK);
    lblUsername4.setForeground(Color.BLACK);
    lblUsername4.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblUsername4.setBounds(250, 428, 193, 52);
    contentPane.add(lblUsername4);
    
    JTextField textField4 = new JTextField();
    textField4.setFont(new Font("Tahoma", Font.PLAIN, 20));
    textField4.setBounds(481, 428, 381, 68);
    contentPane.add(textField4);
    textField4.setColumns(10);
    
    JLabel lblUsername5 = new JLabel("Bus Owner : ");
    lblUsername5.setBackground(Color.BLACK);
    lblUsername5.setForeground(Color.BLACK);
    lblUsername5.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblUsername5.setBounds(250, 512, 193, 52);
    contentPane.add(lblUsername5);
    
    JTextField textField5 = new JTextField();
    textField5.setFont(new Font("Tahoma", Font.PLAIN, 20));
    textField5.setBounds(481, 512, 381, 68);
    contentPane.add(textField5);
    textField5.setColumns(10);
 
    
    btnNewButton = new JButton("Submit");
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnNewButton.setBounds(800, 10, 100, 50);
    contentPane.add(btnNewButton);
    setVisible(true);
    btnNewButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
        	bus_cond=textField.getText();
        	nos = Integer.parseInt(textField3.getText());
        	bus_driv=textField4.getText();
        	bus_own=textField5.getText();
        	bus_id=textField2.getText();
        	bus obj1=new bus();
        	obj1.addBus(nos, bus_own, bus_driv, bus_cond, bus_id, route);
        	JOptionPane.showMessageDialog(btnNewButton, "New bus added");
        	dispose();
        	setVisible(true);

        }
        });

}
}
