import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingForm extends JDialog {
    JPanel bookingPanel;
    JComboBox screenBox;
    JComboBox typeBox;
    JComboBox dayBox;
    JComboBox timeBox;
    JComboBox filmBox;



    public BookingForm() {

        setContentPane(bookingPanel);
        setModal(true);


        String type[] = {"Adult","Child","Elderly"};
        String screen[] = {"1","2","3","4"};
        String films[] = {};
        String day[] = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        String time[] = {};



        Seat leftSide1[][] = new Seat[4][4];
        Seat midSide1[][] = new Seat[4][4];
        Seat rightSide1[][] = new Seat[4][4];

        Seat leftSide2[][] = new Seat[4][4];
        Seat midSide2[][] = new Seat[4][4];
        Seat rightSide2[][] = new Seat[4][4];

        Seat leftSide3[][] = new Seat[4][4];
        Seat midSide3[][] = new Seat[4][4];
        Seat rightSide3[][] = new Seat[4][4];

    }






}
