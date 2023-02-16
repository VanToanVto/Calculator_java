/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2.l.p0022;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class CalculatorController {

    BigDecimal firstvalue = new BigDecimal("0");
    BigDecimal secondvalue = new BigDecimal("0");
    BigDecimal memory = new BigDecimal("0");
    private int operator = -1;
    private boolean resetStatusNewInput = false;
    
    Calculator calculator = new Calculator();
    JButton btn0 = calculator.getBtn0();
    JButton btn1 = calculator.getBtn1();
    JButton btn2 = calculator.getBtn2();
    JButton btn3 = calculator.getBtn3();
    JButton btn4 = calculator.getBtn4();
    JButton btn5 = calculator.getBtn5();
    JButton btn6 = calculator.getBtn6();
    JButton btn7 = calculator.getBtn7();
    JButton btn8 = calculator.getBtn8();
    JButton btn9 = calculator.getBtn9();
    JButton btnAdd = calculator.getBtnAdd();
    JButton btnSub = calculator.getBtnSub();
    JButton btnDiv = calculator.getBtnDiv();
    JButton btnMul = calculator.getBtnMul();
    JButton btnMC = calculator.getBtnMC();
    JButton btnMR = calculator.getBtnMR();
    JButton btnMadd = calculator.getBtnMadd();
    JButton btnMsub = calculator.getBtnMsub();
    JButton btnDot = calculator.getBtndot();
    JButton btnResult = calculator.getBtnResult();
    JButton btnChange = calculator.getBtnChange();
    JButton btnSquare = calculator.getBtnSquare();
    JButton btnPercent = calculator.getBtnPercent();
    JButton btn1x = calculator.getBtn1x();
    JLabel lblClear = calculator.getLblClear();
    JTextField txtResult = calculator.getTxtResult();

    public CalculatorController() {
        calculator.setVisible(true);
        txtResult.setText("0");
        calculator.getTxtResult().setEditable(false);
        calculator.setLocationRelativeTo(null);
        calculator.setResizable(false);
        calculator.pack();
        
        lblClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calculator.getTxtResult().setText("0");
                firstvalue = new BigDecimal("0");
                secondvalue = new BigDecimal("0");
                resetStatusNewInput = true;
                operator =-1;
            }
        });
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Press(btn0);
            }
        });
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Press(btn1);
            }
        });
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Press(btn2);            }
        });
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Press(btn3);
            }
        });
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Press(btn4);
            }
        });
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Press(btn5);
            }
        });
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Press(btn6);
            }
        });
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Press(btn7);
            }
        });
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Press(btn8);
            }
        });
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Press(btn9);
            }
        });
        btnDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculate();
                setOperator(4);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculate();
                setOperator(1);
            }
        });
        btnSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculate();
                setOperator(2);
            }
        });
        btnMul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculate();
                setOperator(3);
            }
        });
        btnResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (!calculator.getTxtResult().getText().equalsIgnoreCase("Error")) {
                    calculate();
                    //reset operator after calculate to use new operator
                    operator=-1;
                }else{
                    calculator.getTxtResult().setText(firstvalue.toPlainString());
                }
                resetStatusNewInput=true;
            }
        });
        
        btnDot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    String screen = calculator.getTxtResult().getText();
                    //check if current value of input number is 0
                    if (resetStatusNewInput) {
                        calculator.getTxtResult().setText("0.");
                        resetStatusNewInput = false;
                   }
                    else{
                        //check if screen already has '.' then not apend '.' more
                        if (!screen.contains(".")) {
                            calculator.getTxtResult().setText(screen+".");
                        }else{
                            calculator.getTxtResult().setText(screen);
                        }
                    }
            }
        }); 
        
        btnMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                  //reset meory to 0
                  memory = new BigDecimal("0");
            }
        });

        btnMadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //add number on screen to memory
                BigDecimal value = new BigDecimal(calculator.getTxtResult().getText());
                memory = memory.add(value);
                resetStatusNewInput = true;
            }
        });

        btnMR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //show memory to screen  
                calculator.getTxtResult().setText(memory+"");
            }
        });

        btnMsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //square number on screen to memory
                BigDecimal value = new BigDecimal(calculator.getTxtResult().getText());
                memory = memory.subtract(value);
                resetStatusNewInput = true;
            }
        });

        btnSquare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BigDecimal value = getValue();
                //check if value on screen is >= 0 then action button sqrt, else set error
                if (value.doubleValue()>=0) {
                    double s = Math.sqrt(value.doubleValue());
                    firstvalue= new BigDecimal(s+"");
                    calculator.getTxtResult().setText(firstvalue.setScale(10, RoundingMode.CEILING).stripTrailingZeros().toPlainString());
                    operator = -1;
                }else{
                    calculator.getTxtResult().setText("Error");
                }
                resetStatusNewInput = true;
            }
        });

        btnPercent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BigDecimal temp = getValue();
                //divide 100 to get percent of screen number
                firstvalue = new BigDecimal(temp.divide(new BigDecimal("100"))+"");
                calculator.getTxtResult().setText(firstvalue+"");
                //reset operator if before we use operator
                operator = -1;
                resetStatusNewInput = true;
            }
        });

        btn1x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BigDecimal value = getValue();
                //check value on screen if equal 0 then set error
                if (value.doubleValue()==0) {
                    calculator.getTxtResult().setText("Error");
                }else{
                    BigDecimal result = new BigDecimal("1").divide(value,10,RoundingMode.HALF_EVEN).stripTrailingZeros();
                    firstvalue = new BigDecimal(result.toPlainString());
                    calculator.getTxtResult().setText(firstvalue+"");
                    operator = -1;
                }
                resetStatusNewInput = true;
            }
        });

        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BigDecimal value = getValue();
                //negate screen value
                Double result = -value.doubleValue();
                firstvalue = new BigDecimal(result+"");
                calculator.getTxtResult().setText(firstvalue.setScale(10, RoundingMode.CEILING).stripTrailingZeros().toPlainString());
                operator = -1;
                resetStatusNewInput = true;
            }
        });
    }    

    public void setOperator(int operator) {
        this.operator = operator;
    }
    
    public void Press(JButton btn){
        BigDecimal temp = new BigDecimal("0");
        String value = btn.getText();
        if (resetStatusNewInput) {
            calculator.getTxtResult().setText("0");
            resetStatusNewInput=false;
        }
        temp = new BigDecimal(calculator.getTxtResult().getText()+value);
        calculator.getTxtResult().setText(temp+"");
    }
    
    public BigDecimal getValue(){
        BigDecimal temp = new BigDecimal("0");
        String value = calculator.getTxtResult().getText();
        //if on screen is not a number then getValue() return to first number has saved before
        //else getValue() wil return number on sreen
        try {
            temp = new BigDecimal(value);
        } catch (Exception e) {
            return firstvalue;
        }
        return temp;
    }
    
    public void calculate(){
        if (!resetStatusNewInput) {
            if (operator==-1) {
                firstvalue =getValue();
            }else{
                secondvalue = getValue();
                switch(operator){
                    case 1:
                        firstvalue = firstvalue.add(secondvalue).setScale(10, RoundingMode.CEILING).stripTrailingZeros();
                        break;
                    case 2:
                        firstvalue = firstvalue.subtract(secondvalue).setScale(10, RoundingMode.CEILING).stripTrailingZeros();
                        break;
                    case 3:
                        firstvalue = firstvalue.multiply(secondvalue).setScale(10, RoundingMode.CEILING).stripTrailingZeros();
                        break;
                    case 4:
                        //check operator '/' for 0
                        if (secondvalue.doubleValue()==0) {
                            calculator.getTxtResult().setText("Error");
                            resetStatusNewInput = true;
                            return;
                        }else{
                            firstvalue = firstvalue.divide(secondvalue,10,RoundingMode.HALF_EVEN).stripTrailingZeros();
                            break;
                        }
                }
            }
            calculator.getTxtResult().setText(firstvalue.toPlainString());
            resetStatusNewInput = true;
        }
    }
}
