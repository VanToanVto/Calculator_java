/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gui.PuzzleGUI;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Admin
 */
public class PuzzleController {

    private PuzzleGUI pg;
    private int size = 0;
    private JButton[][] matrix;
    private int count = 0;
    private JButton btnNGame;
    private Timer timer;
    private boolean isPlaying;
    private int time = 0;
    private boolean first = true;

    public PuzzleController() {
        pg = new PuzzleGUI();
        pg.setVisible(true);
        pg.setLocationRelativeTo(null);
        pg.setResizable(false);
        btnNGame = pg.getBtnNGame();
        newGame();
    }

    public void newGame() {
        addButton();
        btnNGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (isPlaying) {
                    timer.stop();
                    int confirm = JOptionPane.showConfirmDialog(null, "Do you must"
                            + " be want to make new game?", "New Game", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        count = 0;
                        pg.getLblMove().setText("0");
                        getTimer();
                        addButton();
                        isPlaying = true;
                    } else {
                        timer.start();
                        pg.getCboSize().setSelectedIndex(size-3);
                    }
                } else {
                    count = 0;
                    pg.getLblMove().setText("0");
                    getTimer();
                    addButton();
                    isPlaying = true;
                }
            }
        });
    }

    public void getTimer() {
        pg.getLblTime().setText("0 sec");
        timer = new Timer(1000, new ActionListener() {
            int second = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                second++;
                pg.getLblTime().setText(second + " sec");
            }
        });
        timer.start();
    }

    public void addButton() {
        //Neu choi lan dau hoac thang game truoc lay mac dinh size = 3
        if (first) {
            isPlaying = true;
            size=3;
            getTimer();
            count = 0;
            pg.getLblMove().setText("0");
            first = false;
        } else {
            //lay size 
            String value = pg.getCboSize().getSelectedItem() + "";
            String[] arr = value.split("x");
            size = Integer.parseInt(arr[0]);
//            size = pg.getCboSize().getSelectedIndex()+3;
        }
        pg.getPanel().removeAll();
        //set GridLayout cho panel theo hang, cot, khoang cach ngang doc
        pg.getPanel().setLayout(new GridLayout(size, size, 10, 10));
        //set size panel thanh hinh vuong theo kich thuoc
        pg.getPanel().setPreferredSize(new Dimension(60 * size, 60 * size));
        matrix = new JButton[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JButton button = new JButton(i * size + j + 1 + "");
                //1   2   3
                //4   5   6
                //7   8   9
                matrix[i][j] = button;
                //add button vao panel
                pg.getPanel().add(button);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (checkMove(button)) {
                            moveButton(button);
                            if (checkWin()) {
                                isPlaying = false;
                                JOptionPane.showMessageDialog(null, "You won!");
                                int confirm = JOptionPane.showConfirmDialog(null, "Do you want to start"
                                        + " new game?", "New Game", JOptionPane.YES_NO_OPTION);
                                timer.stop();
                                if (confirm == JOptionPane.YES_OPTION) {
                                    first = true;
                                    addButton();
                                } else{
                                    for (int i = 0; i < size; i++) {
                                        for (int j = 0; j < size; j++) {
                                            matrix[i][j].setEnabled(false);
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }
        //set button cuoi cung la button rong
        matrix[size - 1][size - 1].setText("");
        mixButton();
        //thu gon giao dien lai
        pg.pack();
    }

    public Point getPositionEmpty() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //lay vi tri button rong
                if (matrix[i][j].getText().isEmpty()) {
                    return new Point(i, j);//tra ve vi tri button rong theo point
                }
            }
        }
        return null;
    }

    public void mixButton() {
        //xao tron vi tri cac button random
        for (int k = 0; k < 1000; k++) {
            ArrayList arr = new ArrayList();
            arr.clear();
            arr.add("0");
            arr.add("1");
            arr.add("2");
            arr.add("3");           
            Point p = getPositionEmpty();//lay toa do rong            
            int i = p.x;
            int j = p.y;
            if (i==0) {
                arr.remove("0");
            }
            if (i==size-1) {
                arr.remove("1");
            }
            if (j==0) {
                arr.remove("2");
            }
            if (j==size-1) {
                arr.remove("3");
            }
            Random r = new Random();
            int size=arr.size();
            String index =(String)arr.get(r.nextInt(arr.size()));
            int index1= Integer.parseInt(index);
            String txt = "";
            switch (index1) {
                case 0: //move up
                    //if empty button in up most, stop move up
                        txt = matrix[i - 1][j].getText();
                        matrix[i][j].setText(txt);
                        matrix[i - 1][j].setText("");   
                    break;
                case 1: //move down
                    //if empty button in down most, stop move down
                        txt = matrix[i + 1][j].getText();
                        matrix[i][j].setText(txt);
                        matrix[i + 1][j].setText("");
                    
                    break;
                case 2: //move left
                    //if empty button in left most, stop move left
                       txt = matrix[i][j - 1].getText();
                        matrix[i][j].setText(txt);
                        matrix[i][j - 1].setText(""); 
                    break;
                case 3: //move right
                    //if empty button in right most, stop move right
                        txt = matrix[i][j + 1].getText();
                        matrix[i][j].setText(txt);
                        matrix[i][j + 1].setText("");                  
                    break;
            }
        }
    }

    public boolean checkMove(JButton btn) {
        //Lay button rong la p
        Point p = getPositionEmpty();
        //chay tu dau den cuoi matrix button. neu diem nao co text = btn thi tra ve toa do
        int i1 = 0;
        int j1 = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (btn.getText().equals(matrix[i][j].getText())) {
                    i1 = i;
                    j1 = j;
                    break;
                }
            }
        }
        //Neu button cung hang x voi button rong va 2 button cach nhau 1 don vi
        //Tri tuyet doi cua y giua 2 button = 1
        if (p.x == i1 && (Math.abs(p.y - j1) == 1)) {
            return true;
        }
        //Neu button cung hang y voi button rong va 2 button cach nhau 1 don vi
        //Tri tuyet doi cua x giua 2 button = 1
        if (p.y == j1 && (Math.abs(p.x - i1) == 1)) {
            return true;
        }
        return false;
    }

    public void moveButton(JButton btn) {
        Point p = getPositionEmpty();
        String text = btn.getText();
        matrix[p.x][p.y].setText(text);
        btn.setText("");
        count++;
        pg.getLblMove().setText(String.valueOf(count));
    }

    public boolean checkWin() {
        if (matrix[size - 1][size - 1].getText().equals("")) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size - 1; j++) {
                    //Neu duyet tat ca button thanh cong thi return true
                    if (i == size - 1 && j == size - 1) {
                        return true;
                    }
                    //Duyet button co text ko dung return false
                    if (!matrix[i][j].getText().equals(i * size + j + 1 + "")) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    // list 0123
    // tren 0 phai 1 duoi 2 trai 3
    // th1 col=0  random -0 
    // col= size-1 random-2
    // row =0 random -3
    // row =size -1 random -1
    //list 
}
