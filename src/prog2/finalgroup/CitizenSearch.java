package prog2.finalgroup;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class CitizenSearch extends JPanel {
    private JTable table;
    private JTextField searchField;
    private JLabel searchLabel;
    private JComboBox<String> sortComboBox;
    private JButton editButton;
    private JButton back;
    private JScrollPane scrollPane;

    private DefaultTableModel tableModel;
    private Vector<String> columnNames;
    private Vector<Vector<String>> data;

    public CitizenSearch() {
        initializeComponents();
        setupLayout();
        loadCSVData();
    }

    private void initializeComponents() {
        table = new JTable();
        searchField = new JTextField();
        searchLabel = new JLabel("Search:");
        sortComboBox = new JComboBox<>();
        editButton = new JButton("Edit");
        scrollPane = new JScrollPane(table);
        back = new JButton("Back");


        columnNames = new Vector<>(Arrays.asList("Last Name","First Name", "Email", "Address", "Age", "Resident", "District", "Gender"));

        tableModel = new DefaultTableModel(data, columnNames);
        table.setModel(tableModel);

        sortComboBox.addItem("Last Name");
        sortComboBox.addItem("First Name");
        sortComboBox.addItem("Email");
        sortComboBox.addItem("Address");
        sortComboBox.addItem("Age");
        sortComboBox.addItem("Resident");
        sortComboBox.addItem("District");
        sortComboBox.addItem("Gender");

        searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchTable(searchField.getText());
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    private void setupLayout() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(240, 240, 240));

//        JLabel welcomeLabel = new JLabel("Welcome, User");
//        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        welcomeLabel.setForeground(new Color(44, 62, 80));

        searchLabel.setForeground(new Color(44, 62, 80));
        searchField.setBackground(new Color(236, 240, 241));
        sortComboBox.setBackground(new Color(236, 240, 241));
        editButton.setBackground(new Color(52, 152, 219));
        editButton.setForeground(Color.WHITE);

        topPanel.add(back, BorderLayout.NORTH);
        topPanel.add(searchLabel, BorderLayout.WEST);
        topPanel.add(searchField, BorderLayout.CENTER);
        topPanel.add(sortComboBox, BorderLayout.EAST);
        topPanel.add(editButton, BorderLayout.SOUTH);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(240, 240, 240));

        JLabel descriptionLabel = new JLabel("This program displays citizen information.");
        descriptionLabel.setForeground(new Color(44, 62, 80));
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        bottomPanel.add(descriptionLabel, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void loadCSVData() {
        data = new Vector<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("res/data.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(",");
                Vector<String> row = new Vector<>(Arrays.asList(rowData));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        tableModel.setDataVector(data, columnNames);

    }

    private void searchTable(String searchTerm) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(sorter);

        List<RowFilter<Object, Object>> filters = new ArrayList<>();

        for (int i = 0; i < columnNames.size(); i++) {
            filters.add(RowFilter.regexFilter("(?i)" + searchTerm, i));
        }

        sorter.setRowFilter(RowFilter.orFilter(filters));
    }

    public JButton getBack() {
        return back;
    }

    public void setBack(JButton back) {
        this.back = back;
    }

}
