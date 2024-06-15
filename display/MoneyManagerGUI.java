package display;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import application.Report;

public class MoneyManagerGUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = -2094783707714500564L;

    private JFrame popupFrame;
    private JPanel displayPanel;
    private JPanel buttonPanel;
    private JButton expenseButton;
    private JButton editButton;
    private JButton loadButton;
    private JButton settingsButton;

    // private JComboBox reportsList;


    private ArrayList<Report> reports; // TODO potentially change this to a map?


    public MoneyManagerGUI() {
        this(new Report(0));
    }


    public MoneyManagerGUI(Report toDisplay) {

        addComponents();
        reports = new ArrayList<Report>();
        reports.add(toDisplay);
        this.setVisible(true);


    }

    private boolean addReport(Report toAdd) {
        boolean added = false;

        if (toAdd != null) {
            reports.add(toAdd);
        }

        return added;
    }


    private Report getReport(int id) {

        boolean retrieved = false;
        Report toGet = null;

        Iterator<Report> repIt = reports.iterator();

        while (repIt.hasNext() && !retrieved) {
            toGet = repIt.next();
            if (toGet.getID() == id)
                retrieved = true;
        }

        return toGet;
    }


    private void addComponents() {
        this.setTitle("Money Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 500);
        this.setLayout(new BorderLayout(50, 150));

        popupFrame = new JFrame();
        popupFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        popupFrame.setSize(new Dimension(200, 100));
        popupFrame.setVisible(false);

        displayPanel = new JPanel();
        buttonPanel = new JPanel();

        expenseButton = new JButton("Add Expense");
        expenseButton.addActionListener(this);
        editButton = new JButton("Edit Report(s)");
        editButton.addActionListener(this);
        // TODO add/remove 's' based on # of reports
        loadButton = new JButton("Load Report");
        loadButton.addActionListener(this);
        settingsButton = new JButton("Settings");
        settingsButton.addActionListener(this);

        buttonPanel.add(expenseButton);
        buttonPanel.add(editButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(settingsButton);


        displayPanel.add(new JTextField("Filler")); // TODO need to populate w/pie chart or graph or some sort

        this.add(displayPanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);
    }

    private void setPopup(String title) {
        popupFrame.removeAll();
        popupFrame.setTitle(title);
        popupFrame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == expenseButton) {

            JPanel expensePanel = new JPanel();
            BoxLayout expenseLayout = new BoxLayout(expensePanel, BoxLayout.Y_AXIS);
            expensePanel.setLayout(expenseLayout);
            JTextField name = new JTextField(8);
            JFormattedTextField price = new JFormattedTextField(DecimalFormat.getInstance());

            expensePanel.add(new JLabel("Name:"));
            expensePanel.add(name);
            expensePanel.add(new JLabel("Price:"));
            expensePanel.add(price);
            //expensePanel.add(Box.createHorizontalStrut(15)); // test
            // TODO add dropdown list for category and text/calendar drop field for date.

            int result = JOptionPane.showConfirmDialog(null, expensePanel, "Enter name and price",
                    JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_CANCEL_OPTION) {
                //Expense temp = new Expense(name.getText(), Double.parseDouble(price.getText()), );
            }


        } else if (obj == editButton) {
            setPopup("Edit");


        } else if (obj == loadButton) {
            if (reports.size() > 1) {
                int index = 0;
                String[] options = new String[reports.size()];
                for (Report current : reports) {
                    options[index] = Integer.toString(current.getID());
                }

                JOptionPane.showInputDialog(this, options);
            }

            // TODO if size is just one, pull up the same as the edit list but with add/delete buttons


        } else if (obj == settingsButton) {
            setPopup("Settings");
        }

    }
}
