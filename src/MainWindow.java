import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class MainWindow {
    public JButton logInSignUpButton;
    public JButton FilmsButton;
    public JPanel mainPanel;
    private JButton info;
    private JButton membershipButton;
    private JLabel homePage;

    public MainWindow() {

        //View films button
        FilmsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CinemaDB db = new CinemaDB();

                db.getFilms();
            }
        });

        //Info button
        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Address: 2 Park Hall Road, Reigate, UK");
                System.out.println("Postcode: RH2 9LH");
                System.out.println("Telephone: 01233 555642");
                System.out.println("Parking: Please use the Multi Storey car park on Park Hall Road");
                System.out.println();
                System.out.println("Screens with disabled access:");
                System.out.println("Screen 1 & Screen 4");
            }
        });

        //Membership button
        membershipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Join us today to unlock all the incredible benefits on offer to our members!");


                //first login

                //You are currently not/a member

                //if not a member
                Scanner scanner = new Scanner(System.in);
                System.out.println("Would you like to become a member today?: ");
                //if yes, direct to member registration method
                //if no, return to options page


                //if already a member
                //display unique membership code
                //option to cancel membership

            }
        });

        logInSignUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginForm loginForm = new LoginForm();
                loginForm.pack();
                loginForm.show();
            }
        });
    }
}
