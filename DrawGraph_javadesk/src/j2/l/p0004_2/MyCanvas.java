/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2.l.p0004_2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Admin
 */
public class MyCanvas extends Canvas {

    public MyCanvas() {
    }

    public void paint(Graphics g) {
        int SizeOfMarker = 10;
        int from = -5;
        int to = 5;
        int Drawwidth = this.getWidth() - 5;
        int Drawheight = this.getHeight() - 5;
        int span = 25;
        int space = span * 2;
        int numberSize = 14;
        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground(Color.WHITE);
        g2.clearRect(0, 0, this.getWidth(), this.getHeight());
//        draw Vertical span
        for (int i = span; i < Drawheight; i += span) {
            g2.setColor(Color.lightGray);
            g2.drawLine(i, 0, i, Drawheight);
        }
//        draw horizontal span
        for (int i = span; i < Drawheight; i += span) {
            g2.setColor(Color.lightGray);
            g2.drawLine(0, i, Drawwidth, i);
        }
//        draw boder,axis
        g.setColor(Color.BLACK);
//        topboder
        g2.drawLine(0, 0, Drawwidth, 0);
//        left bober
        g2.drawLine(0, 0, 0, Drawwidth);
//        right boder
        g2.drawLine(Drawheight, 0, Drawheight, Drawwidth);
//        bot boder
        g2.drawLine(0, Drawwidth, Drawheight, Drawwidth);
//        Vertical
        g2.drawLine(Drawwidth / 2, 0, Drawwidth / 2, Drawheight);
//         horizontal
        g2.drawLine(0, Drawheight / 2, Drawwidth, Drawheight / 2);
//        draw Vertical number,Marker 
        Font font = new Font("Arial", Font.BOLD, numberSize);
        g.setFont(font);
        for (int i = from + 1; i < to; i++) {
            if (i != 0) {           //number            center  + size of marker,(absolute value of from+ inverted of i)*space 
                g2.drawString(String.valueOf(i), (Drawwidth / 2) + SizeOfMarker, (Math.abs(from) - i) * space + numberSize / 2);
            }
            g2.drawLine((Drawwidth / 2) - SizeOfMarker / 2, (Math.abs(from) - i) * space, 
                        (Drawwidth / 2) + SizeOfMarker / 2, (Math.abs(from) - i) * space);
        }
//        draw horizontal number,Marker        
        for (int i = from + 1; i < to; i++) {
            if (i != 0) {
                g2.drawString(String.valueOf(i), (Math.abs(from) + i) * space,(Drawheight / 2) - SizeOfMarker );
            }
            g2.drawLine((Math.abs(from) + i) * space,  (Drawwidth / 2) - SizeOfMarker / 2,
                         (Math.abs(from) + i) * space, (Drawwidth / 2) + SizeOfMarker / 2);
        }
        g2.setColor(Color.BLACK);

    }
    
    
}
