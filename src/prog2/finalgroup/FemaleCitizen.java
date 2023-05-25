package prog2.finalgroup;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class FemaleCitizen extends JPanel {

    private final String[] columnHeader = {"Full Name", "Email", "Address", "Age", "Resident", "District", "Gender"};

    private MyProgramUtility programUtility;

    private DefaultTableModel tableModel;
    private JTable table;
    private List<Citizen> females;
    private JButton back;

    public FemaleCitizen(){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 300));

        back = new JButton("Back");
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                setVisible(false);

            }
        });

        programUtility = new MyProgramUtility();

        try {
            females = programUtility.femalePopulation();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        int row = programUtility.listCounter(females);
        int col = columnHeader.length;

        setUpTable(row, col);

        JScrollPane pane = new JScrollPane(table);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        JLabel label = new JLabel();
        label.setText("Female Citizen Population: " + row);

        constraints.gridx = 0;
        constraints.gridy = 0;
        topPanel.add(back, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        topPanel.add(label, constraints);

        add(topPanel, BorderLayout.NORTH);
        add(pane, BorderLayout.CENTER);

    }

    private void setUpTable(int row, int col) {
        String[][] rows = new String[row][col];
        String[] arr = new String[col];

        int i = 0;
        while (i < rows.length)
        {
            for (Citizen c : females) {
                arr[0] = c.getFullName();
                arr[1] = c.getEmail();
                arr[2] = c.getAddress();
                arr[3] = String.valueOf(c.getAge());
                arr[4] = String.valueOf(c.isResident());
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
        table.setEnabled(false);

    }

    public JButton getBack() {
        return back;
    }

    public void setBack(JButton back) {
        this.back = back;
    }
}
