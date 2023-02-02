import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("MAIN MENU");
        MainWindow mainWindow = new MainWindow();
        frame.setContentPane(mainWindow.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        CinemaDB db = new CinemaDB();
        db.getFilms();



        logIn();
        bookFilm();
        orderFood();
        startMembership();
        cancelMembership();
        displayInfo();
        filmsShown();




    }

    private static void orderFood() {
    }

    private static void bookFilm() {
    }

    private static void filmsShown() {
    }

    private static void displayInfo() {
    }

    private static void cancelMembership() {
    }

    private static void startMembership() {
    }

    private static void logIn() {
    }





}
