import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_GUI {

    //declare a frame for the window
    private JFrame frame;

    //declare user text field
    private JTextField userNameField;

    //declare password field
    private JPasswordField passwordField;

    //declare user label
    private JLabel userNameLbl;

    //declare password label
    private JLabel passwordLbl;

    //declare 'connect' button
    private JButton btnConnect;

    //constructor

    public Login_GUI() {
        initialize();
    }

    //the initialize method that builds the window
    private void initialize(){
        //creates the frame/window
        frame = new JFrame("Login");
        frame.setBounds(500, 500, 450, 300);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        //create user field
        userNameField = new JTextField();
        userNameField.setBounds(156,56,203,26);
        frame.getContentPane().add(userNameField);
        userNameField.setColumns(10);

        //create password field
        passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
        passwordField.setBounds(156,107,203,26);
        frame.getContentPane().add(passwordField);
        passwordField.setColumns(10);

        //create user label
        userNameLbl = new JLabel("Username ");
        userNameLbl.setBounds(57,61,87,16);
        frame.getContentPane().add(userNameLbl);

        //create password label
        passwordLbl = new JLabel("Password ");
        passwordLbl.setBounds(63,112,70,16);
        frame.getContentPane().add(passwordLbl);

        //create connect button
        btnConnect = new JButton("Connect");
        btnConnect.setBounds(148,172,117,29);
        frame.getContentPane().add(btnConnect);

        //create button action
        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DB_Statements stmts = new DB_Statements();
                try{
                    String username = userNameField.getText();
                    String password = new String(passwordField.getPassword());
                    if (stmts.checkLogin(username, password)){
                        JOptionPane.showMessageDialog(null, "User found \nAccess granted");
                        frame.setVisible(false);
                    }
                    else {JOptionPane.showMessageDialog(null, "User NOT found \nAccess denied");
                    }
                }
                catch(Exception e1){
                    JOptionPane.showMessageDialog(null, e1);
                }
            }
        });
        frame.setVisible(true);
    }


}
