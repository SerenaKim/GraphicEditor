package SubPanel;

import Frame.MainFrame;
import Information.Information;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorPanel extends JPanel {

    private JButton moreColorButton;
    private JPanel choosePanel;


    public ColorPanel() {
        this.setLayout(new BorderLayout());

        choosePanel = new JPanel();

        GridLayout colorLayout = new GridLayout(7, 6);
        choosePanel.setLayout(colorLayout);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
               int colornumber = 255 / 5 * (j % 6);
                JButton temp = new JButton();
                Color tempColor = null;
                switch (i) {
                    case 0:
                        tempColor = new Color(colornumber, colornumber, colornumber, 255);
                        break;
                    case 1:
                        tempColor = new Color(255, colornumber, 0, 255);
                        break;
                    case 2:
                        tempColor = new Color(255, 0, colornumber, 255);
                        break;
                    case 3:
                        tempColor = new Color(colornumber, 255, 0, 255);
                        break;
                    case 4:
                        tempColor = new Color(0, 255, colornumber, 255);
                        break;
                    case 5:
                        tempColor = new Color(0, colornumber, 255, 255);
                        break;
                    case 6:
                        tempColor = new Color(colornumber, colornumber, 255, 255);
                        break;
                }

                temp.setBorderPainted(false);

                temp.setBackground(tempColor);
                temp.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton current = (JButton) e.getSource();
                        Color curColor = current.getBackground();
                        Information.setCurrentColor
                                (curColor.getRed(), curColor.getGreen(), curColor.getBlue(), curColor.getAlpha());
                        MainFrame.getInstance().setBottomLabel(curColor);

                    }

                });
                choosePanel.add(temp);
            }
        }


        this.add(choosePanel, BorderLayout.CENTER);
        moreColorButton = new JButton("More Color");
        moreColorButton.setBackground(Color.WHITE);
        moreColorButton.setFont(new Font("More Color", Font.BOLD, 20));
        moreColorButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                MainFrame.getInstance().callColorFrame();

            }
        });
        this.add(moreColorButton, BorderLayout.SOUTH);


    }


}