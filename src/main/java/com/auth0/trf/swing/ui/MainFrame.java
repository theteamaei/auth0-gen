package com.auth0.trf.swing.ui;

import com.auth0.trf.util.AuthUtil;
import com.auth0.trf.util.CommonUtil;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame {
    JLabel status = new JLabel("Please don't exit the application while in progress. This will take a few minutes.");

    public MainFrame() {
        this.setTitle("Auth0 Account Generator");
        JPanel jPanel = new JPanel();
        JLabel title = new JLabel("This application will generate a folder containing accounts in your Desktop.");
        jPanel.add(title);

        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusBar.setBorder(
                new CompoundBorder(
                        new LineBorder(Color.DARK_GRAY),
                        new EmptyBorder(4, 4, 4, 4)));

        statusBar.add(status);

        JPanel jPanel2 = new JPanel();
        JButton generateButton = new JButton("Generate");
        generateButton.addActionListener(new GenerateFile());
        jPanel2.add(generateButton);


        this.add(BorderLayout.NORTH, jPanel);
        this.add(BorderLayout.CENTER, jPanel2);
        this.add(BorderLayout.SOUTH, status);
        this.pack();
    }

    private class GenerateFile implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                AuthUtil authUtil = new AuthUtil();
                authUtil.getOrganisationApplicationBoList();
//                status.setText("Initializing database connection...");
//                List<String> jsonQueries = authUtil.getAccountList();
//                status.setText("Generating account list...");
//                int result = CommonUtil.generateFiles(jsonQueries);
//                status.setText("Files generated: " + result);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
