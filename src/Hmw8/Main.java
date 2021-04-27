package Hmw8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class TicTacToe extends JFrame {
    final int SIZE = 3;
    JPanel panel = new JPanel(new GridLayout(SIZE, SIZE));
    JButton[][] buttons = new JButton[SIZE][SIZE];
    public TicTacToe() {
        super("Крестики-нолики");
        setContentPane(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        panel.setOpaque(true);
        panel.setBackground(Color.DARK_GRAY);

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBackground(Color.GREEN);
                buttons[i][j].setFont(new Font("Шериф", Font.BOLD, (200 / SIZE)));
                buttons[i][j].setText("");
                panel.add(buttons[i][j]);
            }
        }

        buttons[0][0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (buttons[0][0].getText().equals("") && !checkWin() && !isFull()) {
                    buttons[0][0].setText("X");
                    buttons[0][0].setBackground(new Color(128, 111, 255));
                    if (!checkWin() && !isFull()) aiTurn();
                }
            }
        });
        buttons[0][1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (buttons[0][1].getText().equals("") && !checkWin() && !isFull()) {
                    buttons[0][1].setText("X");
                    buttons[0][1].setBackground(new Color(128, 111, 255));
                    if (!checkWin() && !isFull()) aiTurn();
                }
            }
        });
        buttons[0][2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (buttons[0][2].getText().equals("") && !checkWin() && !isFull()) {
                    buttons[0][2].setText("X");
                    buttons[0][2].setBackground(new Color(128, 111, 255));
                    if (!checkWin() && !isFull()) aiTurn();
                }
            }
        });
        buttons[1][0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (buttons[1][0].getText().equals("") && !checkWin() && !isFull()) {
                    buttons[1][0].setText("X");
                    buttons[1][0].setBackground(new Color(128, 111, 255));
                    if (!checkWin() && !isFull()) aiTurn();
                }
            }
        });
        buttons[1][1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (buttons[1][1].getText().equals("") && !checkWin() && !isFull()) {
                    buttons[1][1].setText("X");
                    buttons[1][1].setBackground(new Color(128, 111, 255));
                    if (!checkWin() && !isFull()) aiTurn();
                }
            }
        });
        buttons[1][2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (buttons[1][2].getText().equals("") && !checkWin() && !isFull()) {
                    buttons[1][2].setText("X");
                    buttons[1][2].setBackground(new Color(128, 111, 255));
                    if (!checkWin() && !isFull()) aiTurn();
                }
            }
        });
        buttons[2][0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (buttons[2][0].getText().equals("") && !checkWin() && !isFull()) {
                    buttons[2][0].setText("X");
                    buttons[2][0].setBackground(new Color(128, 111, 255));
                    if (!checkWin() && !isFull()) aiTurn();
                }
            }
        });
        buttons[2][1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (buttons[2][1].getText().equals("") && !checkWin() && !isFull()) {
                    buttons[2][1].setText("X");
                    buttons[2][1].setBackground(new Color(128, 111, 255));
                    if (!checkWin() && !isFull()) aiTurn();
                }
            }
        });
        buttons[2][2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (buttons[2][2].getText().equals("") && !checkWin() && !isFull()) {
                    buttons[2][2].setText("X");
                    buttons[2][2].setBackground(new Color(128, 111, 255));
                    if (!checkWin() && !isFull()) aiTurn();
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        //NIMBUS STYLE
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Нимбус".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {

            }
        }

        TicTacToe game = new TicTacToe();
    }

    public void startNew() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setBackground(Color.ORANGE);
            }
        }
    }

    boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (buttons[i][j].getText().equals("")) return false;
            }
        }

        int reply = JOptionPane.showConfirmDialog(null, "ПЕРЕЗАПУСТИТЬ игру?", "Поле заполнено", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            startNew();
        } else {
            System.exit(0);
        }

        return true;
    }

    void aiTurn() {
        Random r = new Random();
        int i = r.nextInt(SIZE);
        int j = r.nextInt(SIZE);
        while (!isCellValid(i, j)) {
            i = r.nextInt(SIZE);
            j = r.nextInt(SIZE);
        }
        buttons[i][j].setText("O");
        buttons[i][j].setBackground(new Color(255, 111, 120));
        checkWin();
    }

    boolean isCellValid(int i, int j) {
        if (buttons[i][j].getText().equals("")) {
            return true;
        }
        return false;
    }

    boolean checkWin() {
        int countXH = 0;
        int countOH = 0;
        int countXV = 0;
        int countOV = 0;
        int countXD = 0;
        int countOD = 0;
        int countXD2 = 0;
        int countOD2 = 0;
        for (int i = 0; i < SIZE; i++) {
            countXH = 0;
            countOH = 0;
            countXV = 0;
            countOV = 0;
            for (int j = 0; j < SIZE; j++) {
                if (buttons[i][j].getText().equals("X")) {
                    countXH += 1;
                    if (countXH == SIZE) {
                        //JOptionPane.showMessageDialog(null, "You Win");
                        int reply = JOptionPane.showConfirmDialog(null, "Вы выйграли! ПЕРЕЗАПУСТИТЬ игру?", "Игра окончена", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            startNew();
                        } else {
                            System.exit(0);
                        }
                        return true;
                    }
                }
                if (buttons[i][j].getText().equals("O")) {
                    countOH += 1;
                    if (countOH == SIZE) {
                        //JOptionPane.showMessageDialog(null, "AI Win");
                        int reply = JOptionPane.showConfirmDialog(null, "Вы проиграли! ПЕРЕЗАПУСТИТЬ игру?", "Игра окончена", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            startNew();
                        } else {
                            System.exit(0);
                        }
                        return true;
                    }
                }

                if (buttons[j][i].getText().equals("X")) {
                    countXV += 1;
                    if (countXV == SIZE) {
                        //JOptionPane.showMessageDialog(null, "You Win");
                        int reply = JOptionPane.showConfirmDialog(null, "Вы выйграли! ПЕРЕЗАПУСТИТЬ игру?", "Игра окончена", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            startNew();
                        } else {
                            System.exit(0);
                        }
                        return true;
                    }
                }
                if (buttons[j][i].getText().equals("O")) {
                    countOV += 1;
                    if (countOV == SIZE) {
                        //JOptionPane.showMessageDialog(null, "AI Win");
                        int reply = JOptionPane.showConfirmDialog(null, "Вы проиграли! ПЕРЕЗАПУСТИТЬ игру?", "Игра окончена", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            startNew();
                        } else {
                            System.exit(0);
                        }
                        return true;
                    }
                }
            }

            if (buttons[i][i].getText().equals("X")) {
                countXD += 1;
                if (countXD == SIZE) {
                    //JOptionPane.showMessageDialog(null, "You Win");
                    int reply = JOptionPane.showConfirmDialog(null, "Вы выйграли! ПЕРЕЗАПУСТИТЬ игру?", "Игра окончена", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        startNew();
                    } else {
                        System.exit(0);
                    }
                    return true;
                }
            }
            if (buttons[i][i].getText().equals("O")) {
                countOD += 1;
                if (countOD == SIZE) {
                    //JOptionPane.showMessageDialog(null, "AI Win");
                    int reply = JOptionPane.showConfirmDialog(null, "Вы проиграли! ПЕРЕЗАПУСТИТЬ игру?", "Игра окончена", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        startNew();
                    } else {
                        System.exit(0);
                    }
                    return true;
                }
            }

            if (buttons[i][SIZE - i - 1].getText().equals("X")) {
                countXD2 += 1;
                if (countXD2 == SIZE) {
                    //JOptionPane.showMessageDialog(null, "You Win");
                    int reply = JOptionPane.showConfirmDialog(null, "Вы выйграли! ПЕРЕЗАПУСТИТЬ игру?", "Игра окончена", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        startNew();
                    } else {
                        System.exit(0);
                    }
                    return true;
                }
            }
            if (buttons[i][SIZE - i - 1].getText().equals("O")) {
                countOD2 += 1;
                if (countOD2 == SIZE) {
                    //JOptionPane.showMessageDialog(null, "AI Win");
                    int reply = JOptionPane.showConfirmDialog(null, "Вы проиграли! ПЕРЕЗАПУСТИТЬ игру?", "Игра окончена", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        startNew();
                    } else {
                        System.exit(0);
                    }
                    return true;
                }
            }
        }

        return false;
    }


}
