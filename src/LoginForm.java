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

                if (emailField.getText().isBlank() || passwordField.getPassword().length==0) {
                    JOptionPane.showMessageDialog(null, "Email or password field is empty");
                    return;
                }

                try {
                    Connection con = CinemaDB.getConnection();
                    PreparedStatement pst;
                    ResultSet rs;

                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    pst = con.prepareStatement("SELECT * FROM Users WHERE Email='"+emailField.getText() +"' AND Password='"+passwordField.getText() +"' ");
                    rs=pst.executeQuery();
                    if(rs.next()) {
                        JOptionPane.showMessageDialog(null,"Login successful");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"User does not exist, please re-enter details or create an account");
                    }

                } catch (SQLException | ClassNotFoundException exception) {
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

               String email =  emailField.getText();
               String password = String.valueOf(passwordField.getPassword());

                try {
                    Connection con = CinemaDB.getConnection();
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

                    PreparedStatement pst = con.prepareStatement("INSERT INTO Users(Email,Password) VALUES (?,?)");
                    pst.setString(1, email);
                    pst.setString(2, password);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Account Created");

                } catch (SQLException | ClassNotFoundException exception) {
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

                    pst = con.prepareStatement("UPDATE Users SET name = ?,email= ?, WHERE id = ?;");
                    //
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Password updated");

                } catch (SQLException exception) {
                    exception.printStackTrace();
                }


            }
        });
    }

}
