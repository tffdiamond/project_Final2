package prog2.finalgroup;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Resident extends JPanel {

    private final String[] columnHeader = {"Full Name", "Email", "Address", "Age", "Resident", "District", "Gender"};

    private MyProgramUtility programUtility;

    private DefaultTableModel tableModel;
    private JTable table;
    private List<Citizen> resident;
    private JButton back;
    private JPanel topPanel;
    private JPanel mainPanel;
    private JLabel label;
    private JScrollPane pane;

    public Resident(){
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 300));

        programUtility = new MyProgramUtility();

        back = new JButton("Back");
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                setVisible(false);

            }
        });

        try {
            resident = programUtility.numberOfResidents();
        } catch (Exception exception)
        {
            exception.printStackTrace();
        }

        int row = programUtility.listCounter(resident);
        int col = columnHeader.length;

        setUpTable(row, col);

        pane = new JScrollPane(table);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        topPanel = new JPanel(new GridBagLayout());

        label = new JLabel();
        label.setText("Total number of residents: " + row);

        constraints.gridx = 0;
        constraints.gridy = 0;
        topPanel.add(back, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        topPanel.add(label, constraints);

        add(topPanel, BorderLayout.NORTH);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(pane);
        add(mainPanel, BorderLayout.CENTER);


    }

    private void setUpTable(int row, int col) {
        String[][] rows = new String[row][col];
        String[] arr = new String[col];

        int i = 0;
        while (i < rows.length)
        {
            for (Citizen c : resident)
            {
                arr[0] = c.getFullName();
                arr[1] = c.getEmail();
                arr[2] = c.getAddress();
                arr[3] = String.valueOf(c.getAge());
                arr[4] = String.valueOf(c.isResident()?"Resident" : "Non-Resident");
                arr[5] = String.valueOf(c.getDistrict());
                arr[6] = String.valueOf(c.getGender());

                for (int j = 0; j < rows[i].length; j++) {
                    rows[i][j] = arr[j];
                }
                i++;

            }

        }

        tableModel = new DefaultTableModel(rows, columnHeader);
        table = new JTable(tableModel);
    }

    public JButton getBack() {
        return back;
    }

    public void setBack(JButton back) {
        this.back = back;
    }

}
