import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginForm extends JDialog {
    private JPanel loginPanel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton resetPassword;
    private JButton loginButton;
    private JLabel email;
    private JLabel password;
    private JButton signUpButton;

    public LoginForm() {

        setContentPane(loginPanel);
        setModal(true);
        getRootPane().setDefaultButton(loginButton);


        //LogIn
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Encryption encrypt = new Encryption();
                String email = null;
                String password = null;

                try {
                    email = encrypt.hashFunction(emailField.getText())  ;
                    password = encrypt.hashFunction(String.valueOf(passwordField.getPassword()));

                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                if (emailField.getText().isBlank() || passwordField.getPassword().length==0) {
                    JOptionPane.showMessageDialog(null, "Email or password field is empty");
                    return;
                }

                try {
                    Connection con = CinemaDB.getConnection();
                    PreparedStatement pst;
                    ResultSet rs;

                    pst = con.prepareStatement("SELECT * FROM Users WHERE Email='"+email +"' AND Password='"+password +"' ");
                    rs=pst.executeQuery();

                    if(rs.next()) {
                        JOptionPane.showMessageDialog(null,"Login successful");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"User does not exist, please re-enter details or create an account");
                    }

                    rs.close();
                    pst.close();
                    con.close();

                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });

        //SignUp
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               if (emailField.getText().isBlank() || passwordField.getPassword().length==0) {
                   JOptionPane.showMessageDialog(null, "Email or password field is empty");
                   return;
               }

               Regex regex = new Regex();

                if (!regex.emailValidation(emailField.getText())) {
                    JOptionPane.showMessageDialog(null, "Email is not valid, please re-enter email");
                    return;
                }


                Encryption encrypt = new Encryption();
                String email = null;
                String password = null;

                try {
                    email = encrypt.hashFunction(emailField.getText())  ;
                    password = encrypt.hashFunction(String.valueOf(passwordField.getPassword()));

                } catch (Exception exception) {
                    exception.printStackTrace();
                }



                //System.out.println(email);
                //System.out.println(password);
            }
        });

        resetPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = CinemaDB.getConnection();
                    PreparedStatement pst;




                    JOptionPane.showMessageDialog(null, "Password updated");

                } catch (SQLException exception) {
                    exception.printStackTrace();
                }


            }
        });
    }

}
