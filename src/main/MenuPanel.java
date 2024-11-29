package main;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private GamePanel gamePanel;

    public MenuPanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        setLayout(new GridBagLayout());
        setOpaque(false);

        JButton startButton = new JButton("Start Game");

        startButton.setFont(new Font("Arial", Font.BOLD, 24));
        startButton.setPreferredSize(new Dimension(200, 50));
        startButton.setBackground(new Color(0, 0, 0, 219)); // couleur du fond
        startButton.setForeground(Color.GRAY); // couleur du texte
//        startButton.setBorderPainted(false); // pas de bordure

        startButton.setFocusPainted(false); // Supprime le focus visuel
        startButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));


        startButton.addActionListener(e -> startGame());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(startButton, gbc);
    }


    private void startGame() {

        System.out.println("Bouton Start cliqué");
        System.out.println("Vous jouez avec les dimensions : " + ScreenConfig.screenWidth + "x" + ScreenConfig.screenHeight);

        // Masquer le menu
        this.setVisible(false);

        System.out.println("Passage en mode Normal");
        gamePanel.setGameSpeed(true); // pour activer le mode normal de vitesse de jeu

        gamePanel.startGame();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Couleur du menu
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(83, 83, 83, 131));
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
