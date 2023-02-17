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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class Controller extends JFrame {

    private JTextField txtFrom;
    private JTextField txtTo;
    private JTextField function;
    static Canvas canvas;
    private boolean haveDraw = false;

    public Controller() {
        DrawFrame df = new DrawFrame();
        df.setVisible(true);
        JButton btnDrawGraph = df.getjButton1();
        JButton btnSave = df.getjButton3();
        JButton btnExit = df.getjButton2();
        txtFrom = df.getjTextField1();
        txtTo = df.getjTextField2();
        function = df.getjTextField3();
//        canvas = new MyCanvas();
        canvas = new MyCanvas();
        df.add(canvas);
        canvas.setSize(505, 505);
        canvas.setLocation(50, 100);
        Graphics g = canvas.getGraphics();
        btnDrawGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Graphics g = canvas.getGraphics();
                canvas.paint(g);
                drawshape(g);
            }
        });
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveCanvas(canvas);
            }
        });
        df.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
//                saveCanvas(canvas);
                System.exit(0);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveCanvas(canvas);
                System.exit(0);
            }
        });
    }

    public void drawshape(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        String fun = function.getText();
        ArrayList<String> list = infixToPostfix(fun);
        ArrayList<BigDecimal> lista = new ArrayList<>();
        ArrayList<BigDecimal> listb = new ArrayList<>();
        String space = "0.01";
        String scale = "50";
        int Scalse = 0;
        int count = 0;
        for (BigDecimal i = new BigDecimal(txtFrom.getText());
                i.compareTo(new BigDecimal(txtTo.getText())) < 0;
                i = i.add(new BigDecimal(space))) {
            lista.add(i);

            BigDecimal sofi = fx(list, i).multiply(new BigDecimal(scale));
            BigDecimal soi = i.multiply(new BigDecimal(scale));
            BigDecimal sofi1 = fx(list, i.add(new BigDecimal(space))).multiply(new BigDecimal(scale));
            BigDecimal soi1 = i.add(new BigDecimal(space)).multiply(new BigDecimal(scale));

            sofi = sofi.setScale(Scalse, BigDecimal.ROUND_DOWN);
            soi = soi.setScale(Scalse, BigDecimal.ROUND_DOWN);
            sofi1 = sofi1.setScale(Scalse, BigDecimal.ROUND_DOWN);
            soi1 = soi1.setScale(Scalse, BigDecimal.ROUND_DOWN);

            int x1 = Integer.valueOf(soi + "") + 250;
            int x2 = Integer.valueOf(soi1 + "") + 250;
            int y1 = 250 - Integer.valueOf(sofi + "");
            int y2 = 250 - Integer.valueOf(sofi1 + "");
            g2.setColor(Color.red);

            g2.drawLine(x1, y1, x2, y2);
            System.out.println("x1= " + x1 + "y1= " + y1);
            System.out.println("x2= " + x2 + "y2= " + y2);
            count++;
        }
        System.out.println("count= " + count);
        haveDraw = true;
    }

    static ArrayList<String> infixToPostfix(String fun) {
        // initializing empty list for result 
        ArrayList<String> list = new ArrayList<>();
        // initializing String for check operand
        String operand = "^[x0-9]$";
        // initializing empty stack 
        Stack<String> stack = new Stack<>();
        String exp = CoverFunction(fun);
        //Inspect each element of function 
        for (int i = 0; i < exp.length(); ++i) {
            //pick element at index i
            String c = exp.substring(i, i + 1);
            // If the scanned element is an operand
            if (Pattern.matches(operand, c)) {
                //continue check to get all operand
                for (int j = i; j < exp.length() - 1; j++) {
                    String c1;
                    c1 = exp.substring(j + 1, j + 2);
                    if (Pattern.matches(operand, c1)) {
                        i++;
                        c += c1;
                    } else {
                        break;
                    }
                }//add it to output.
                list.add(c);
            } // If element is an '(', push it to the stack. 
            else if (c.equals("(")) {
                stack.push(c);
            } // If element is an ')',output from the stack to list
            // until an '(' is appear. 
            else if (c.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    list.add(stack.pop());
                }
                //throw away "("
                stack.pop();
            } // an operator is encountered 
            else {
                //whenever stack have element and top of stack is not "("
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    //whenever (level top of stack)>(level operator) output from the stack to list    
                    if (Prec(c) <= Prec(stack.peek())) {
                        list.add(stack.pop());
                    } else {
                        break;
                    }
                }
                //add operator in to stack
                stack.push(c);
            }
        }
        //output all the operators from the stack to list 
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    static int Prec(String ch) {
        switch (ch) {
            case "+":
            case "-":
                return 1;

            case "*":
            case "/":
                return 2;

            case "^":
                return 3;
        }
        return -1;
    }

    static BigDecimal fx(ArrayList<String> list, BigDecimal x) {
        ArrayList<String> list1 = new ArrayList<>();
        Double result = 0.0, a, b;
        for (String s : list) {
            list1.add(s);
        }
        boolean check = false;
        for (String o : list1) {
            if (o.equals("x")) {
                list1.set(list1.indexOf(o), String.valueOf(x));
            }
        }
        while (list1.size() >= 3) {
            for (int i = 2; i < list1.size(); i++) {
                switch (list1.get(i)) {
                    case "+": {
                        a = Double.parseDouble(list1.get(i - 2));
                        b = Double.parseDouble(list1.get(i - 1));
                        result = a + b;
                        check = true;
                        break;
                    }
                    case "-": {
                        a = Double.parseDouble(list1.get(i - 2));
                        b = Double.parseDouble(list1.get(i - 1));
                        result = a - b;
                        check = true;
                        break;
                    }
                    case "*": {
                        a = Double.parseDouble(list1.get(i - 2));
                        b = Double.parseDouble(list1.get(i - 1));
                        result = a * b;
                        check = true;
                        break;
                    }
                    case "/": {
                        a = Double.parseDouble(list1.get(i - 2));
                        b = Double.parseDouble(list1.get(i - 1));
                        if (b == 0) {
                            JOptionPane.showMessageDialog(null, "can't div 0");
                            System.out.println("b=0");
                            break;
                        }
                        result = a / b;
                        check = true;
                        break;
                    }
                    case "^": {
                        a = Double.parseDouble(list1.get(i - 2));
                        b = Double.parseDouble(list1.get(i - 1));
                        result = Math.pow(a, b);
                        check = true;
                        break;
                    }
                    default: {
                        break;
                    }
                }
                if (check) {
                    list1.set(i - 2, String.valueOf(result));
                    list1.remove(i);
                    list1.remove(i - 1);
                    i = 1;
                    check = false;
                }
            }
        }
        BigDecimal re = new BigDecimal(result);
        return re;
    }

    public static String CoverFunction(String fun) {
        String exp = fun;
        for (int i = 0; i < exp.length(); i++) {
            String head = exp.substring(0, i);
            String mid = exp.substring(i, i + 1);
            String last = exp.substring(i + 1);
            if (mid.equals("x")) {
                if (!head.isEmpty() && Character.isDigit(head.charAt(head.length() - 1))) {
                    head = head + "*";
                }
                if (!head.isEmpty() && head.charAt(head.length() - 1) == ')') {
                    head = head + "*";
                }
                if (!last.isEmpty() && Character.isDigit(last.charAt(0))) {
                    last = "*" + last;
                }
                if (!last.isEmpty() && last.charAt(0) == '(') {
                    last = "*" + last;
                }
            }
            exp = head + mid + last;
        }
        return exp;
    }
      public static String CoverFunction2(String fun) {
        String exp = fun;
        for (int i = 0; i < exp.length(); i++) {
            String head = exp.substring(0, i);
            String mid = exp.substring(i, i + 1);
            String last = exp.substring(i + 1);
            if (mid.equals("x")) {
                if (!head.isEmpty() && Character.isDigit(head.charAt(head.length() - 1))) {
                    head = head + "*";
                }
                if (!head.isEmpty() && head.charAt(head.length() - 1) == ')') {
                    head = head + "*";
                }
                if (!last.isEmpty() && Character.isDigit(last.charAt(0))) {
                    last = "*" + last;
                }
                if (!last.isEmpty() && last.charAt(0) == '(') {
                    last = "*" + last;
                }
            }
            exp = head + mid + last;
        }
        return exp;
    }
    public void saveCanvas(Canvas canvas) {
        BufferedImage image = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.clearRect(0, 0, this.getWidth(), this.getHeight());
        canvas.paint(g2);
        if (haveDraw) {
            drawshape(g2);
        }
        // user in put link to save image
//        String sourc = "C:\\Users\\Admin\\Desktop\\";
//        File apath;
//        String newSourc;
//        newSourc = JOptionPane.showInputDialog(null, "your image will save at:", sourc + "canvas.png");
//        if (newSourc != null) {
//            apath = new File(newSourc);
//        } else {
//            return;
//        }
      
        try {
            File apath = new File("image.jpg");
            //save image at location "apath"
            ImageIO.write(image, "png", apath);
            JOptionPane.showMessageDialog(null, "Image save at:\n" + apath.getAbsolutePath());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
  //check link is exit??
//        while (!apath.exists() || apath.isDirectory()) {
//            if (apath.isDirectory()) {
//                apath = new File(apath.getAbsolutePath() + "canvas.png");
//                continue;
//            }
//            newSourc = JOptionPane.showInputDialog(null, "file path is not invalid:", sourc + "canvas.png");
//            if (newSourc == null) {
//                return;
//            }
//            apath = new File(newSourc);
//
//        }
//        if (JOptionPane.showConfirmDialog(null, "overwrite this file", "alert", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
//            return;
//        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //        if (apath.exists()) {
//            // Kiểm tra 'apath' có phải là một thư mục hay không?
//            System.out.println("Directory? " + apath.isDirectory());
//            // Kiểm tra 'apath' là một đường dẫn ẩn hay không?
//            System.out.println("Hidden? " + apath.isHidden());
//            // Tên đơn giản.
//            System.out.println("Simple Name: " + apath.getName());
//            // Đường dẫn tuyêt đối.
//            System.out.println("Absolute Path: " + apath.getAbsolutePath());
//        }    
    }

}
