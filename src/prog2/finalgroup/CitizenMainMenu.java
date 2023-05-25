package prog2.finalgroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CitizenMainMenu extends JFrame {
    private final String mainPanelID = "id_main";
    private final String citizenSearchID = "id_citizenSearch";
    private final String seniorCitizenID = "id_seniorCitizen";
    private final String residentID = "id_resident";
    private final String nonResidentID = "id_nonResident";

    private final String maleCitizenID = "id_maleCitizen";
    private final String femaleCitizenID = "id_femaleCitizen";
    private CitizenSearch citizenSearchPanel;
    private SeniorCitizen seniorCitizenPanel;
    private Resident residentPanel;
    private NonResident nonResidentPanel;
    private MaleCitizen maleCitizenPanel;
    private FemaleCitizen femaleCitizenPanel;
    private JPanel cardPanel;
    private JPanel mainMenu;

    public CitizenMainMenu() {
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        cardPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        initClassPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);

        JButton button1 = createButton("Citizen Search");
        JButton button2 = createButton("Senior Citizens");
        JButton button3 = createButton("Residents");
        JButton button4 = createButton("Non-Residents");
        JButton button5 = createButton("Male Citizens");
        JButton button6 = createButton("Female Citizens");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                changeScreen(citizenSearchID);

            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                changeScreen(seniorCitizenID);

            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                changeScreen(residentID);

            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                changeScreen(nonResidentID);

            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                changeScreen(maleCitizenID);

            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                changeScreen(femaleCitizenID);

            }
        });

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        mainMenu = new JPanel();
        mainMenu.setLayout(gridBagLayout);
        mainMenu.setBackground(Color.cyan);
        mainMenu.setPreferredSize(new Dimension(600, 300));
        mainMenu.add(button1);
        mainMenu.add(button2);
        mainMenu.add(button3);
        mainMenu.add(button4);
        mainMenu.add(button5);
        mainMenu.add(button6);

        setUpFrame();

        // show the main menu
        ((CardLayout) cardPanel.getLayout()).show(cardPanel,mainPanelID);
        add(cardPanel);
    }

    private void initClassPanel() {
        citizenSearchPanel = new CitizenSearch();
        citizenSearchPanel.getBack().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                changeScreen(mainPanelID);

            }
        });

        seniorCitizenPanel = new SeniorCitizen();
        seniorCitizenPanel.getBack().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                changeScreen(mainPanelID);

            }
        });

        residentPanel = new Resident();
        residentPanel.getBack().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                changeScreen(mainPanelID);

            }
        });

        nonResidentPanel = new NonResident();
        nonResidentPanel.getBack().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                changeScreen(mainPanelID);

            }
        });

        maleCitizenPanel = new MaleCitizen();
        maleCitizenPanel.getBack().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                changeScreen(mainPanelID);

            }
        });

        femaleCitizenPanel = new FemaleCitizen();
        femaleCitizenPanel.getBack().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                changeScreen(mainPanelID);

            }
        });

    }

    private void changeScreen(String screen) {
        ((CardLayout) cardPanel.getLayout()).show(cardPanel, screen);
    }

    private void setUpFrame() {
        cardPanel.add(mainPanelID, mainMenu);
        cardPanel.add(citizenSearchID, citizenSearchPanel);
        cardPanel.add(seniorCitizenID, seniorCitizenPanel);
        cardPanel.add(residentID, residentPanel);
        cardPanel.add(nonResidentID, nonResidentPanel);
        cardPanel.add(maleCitizenID, maleCitizenPanel);
        cardPanel.add(femaleCitizenID, femaleCitizenPanel);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(120, 50));
        button.setFont(new Font("Arial", Font.PLAIN, 8));
        button.setFocusPainted(false);
        return button;
    }

    private void setupLayout() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CitizenMainMenu();
            }
        });
    }
}
