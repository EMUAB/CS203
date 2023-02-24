import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGui {
    private JFrame frame;
    private JTextArea tArea;
    private StringBuilder visualCalc = new StringBuilder("");
    private String num2S = "";
    private int maxChar; // Doesn't need to be exact, just ensures that the equation never extends past the visual bounds (of the default size)
    private boolean fnCued = false;
    private double num1 = 0, num2 = 0;
    private int calcType = 0;

    public String getVisualCalcString() {
        return visualCalc.toString();
    }

    public void createAndAddButtons(JPanel panel) { // Adds all number and function buttons
        JButton[] bArr = new JButton[17];
        for (int i = 0; i <= 16; i++) {
            bArr[i] = new JButton();
            bArr[i].setText(Integer.toString(i));
            bArr[i].setActionCommand(Integer.toString(i));
            bArr[i].addActionListener(new ButtonListener());
            bArr[i].setFont(new Font("Default", Font.PLAIN, 16));
        }
        bArr[11].setText("+");
        bArr[11].setActionCommand("add");

        bArr[12].setText("-");
        bArr[12].setActionCommand("sub");

        bArr[13].setText("*");
        bArr[13].setActionCommand("mul");

        bArr[14].setText("/");
        bArr[14].setActionCommand("div");

        bArr[15].setText("√");
        bArr[15].setActionCommand("sqrt");

        bArr[16].setText("=");
        bArr[16].setActionCommand("equals");

        for (int j = 7; j >= 0; j++) {
            panel.add(bArr[j]);
            if (j == 9) {
                panel.add(bArr[11]);
                j -= 6;
            } else if (j == 6) {
                panel.add(bArr[12]);
                j -= 6;
            } else if (j == 3) {
                panel.add(bArr[13]);
                j -= 6;
            }
        }
        panel.add(new JPanel());
        panel.add(bArr[0]);
        panel.add(bArr[16]);
        panel.add(bArr[14]);
        for (int p = 0; p < 3; p++) {
            panel.add(new JPanel());
        }
        panel.add(bArr[15]);
    }

    public void createAndAddAllComponents() { //Adds the three main components to the frame
        JPanel bPanel = new JPanel();
        bPanel.setLayout(new GridLayout(5, 4));
        createAndAddButtons(bPanel);
        bPanel.setPreferredSize(new Dimension(350, 300));


        tArea = new JTextArea();
        tArea.setEditable(false);
        tArea.setAutoscrolls(true);
        tArea.setPreferredSize(new Dimension(350, 100));
        tArea.setFont(new Font("Default", Font.PLAIN, 25));
        tArea.setLineWrap(true);

        JScrollPane scroll = new JScrollPane(tArea);

        JButton clear = new JButton();
        clear.setPreferredSize(new Dimension(350, 50));
        clear.setText("CLEAR");
        clear.setActionCommand("clear");
        clear.addActionListener(new ButtonListener());
        clear.setAlignmentX(Component.CENTER_ALIGNMENT);

        frame.add(scroll);
        frame.add(bPanel);
        frame.add(clear);
    }

    public void createAndShowGui() { // Establishes frame and shows everything
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Calculator");
        frame.setPreferredSize(new Dimension(350, 425));
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        createAndAddAllComponents();

        frame.pack();
        frame.setVisible(true);
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1() {
        this.num1 = Double.parseDouble(getVisualCalcString());
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = Double.parseDouble(num2);
    }

    public int getCalcType() {
        return calcType;
    }

    /**
     *  Resets num1, num2, num2S, calcType, fnCued, and maxChar
     */
    public void reset() {
        num1 = 0;
        num2 = 0;
        num2S = "";
        calcType = 0;
        fnCued = false;
        maxChar = tArea.getDocument().getLength();
    }


    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (maxChar <= 55 && calcType != Calculation.SQUARE_ROOT) {
                // The clear and equals functions under normal conditions
                if ("clear".equals(e.getActionCommand())) {
                    visualCalc.setLength(0);
                    reset();
                } else if ("equals".equals(e.getActionCommand())) {
                    if (!fnCued && getNum2() == 0) {
                        visualCalc.setLength(0);
                        visualCalc.append(getNum1());
                        reset();
                    } else {
                        setNum2(num2S);
                        visualCalc.setLength(0);
                        visualCalc.append(Calculation.doFunction(getNum1(), getNum2(), getCalcType()));
                        reset();
                    }
                } else if (!fnCued) {
                    // Functions
                    if ("add".equals(e.getActionCommand())) {
                        setNum1();
                        visualCalc.append("+");
                        calcType = Calculation.ADDITION;
                        fnCued = true;
                    } else if ("sub".equals(e.getActionCommand())) {
                        setNum1();
                        visualCalc.append("-");
                        calcType = Calculation.SUBTRACTION;
                        fnCued = true;
                    } else if ("mul".equals(e.getActionCommand())) {
                        setNum1();
                        visualCalc.append("*");
                        calcType = Calculation.MULTIPLICATION;
                        fnCued = true;
                    } else if ("div".equals(e.getActionCommand())) {
                        setNum1();
                        visualCalc.append("/");
                        calcType = Calculation.DIVISION;
                        fnCued = true;
                    } else if ("sqrt".equals(e.getActionCommand())) {
                        setNum1();
                        visualCalc.insert(0, "√");
                        calcType = Calculation.SQUARE_ROOT;
                    } else {
                        // Allows adding numbers to line while a function hasn't been stated
                        for (int t = 0; t <= 9; t++) {
                            if (Integer.parseInt(e.getActionCommand()) == t) {
                                visualCalc.append(t);
                            }
                        }
                    }
                } else {
                    // Allows adding numbers to line while a function HAS been stated
                    for (int t = 0; t <= 9; t++) {
                        if (Integer.parseInt(e.getActionCommand()) == t) {
                            visualCalc.append(t);
                            num2S += t;
                        }
                    }
                }
                tArea.setText(getVisualCalcString());
                tArea.setCaretPosition(tArea.getDocument().getLength());
                maxChar++;
            } else if (calcType == Calculation.SQUARE_ROOT) {
                // Dealing with input for square root, as it only takes one number
                if ("clear".equals(e.getActionCommand())) {
                    visualCalc.setLength(0);
                    reset();
                } else if ("equals".equals(e.getActionCommand())) {
                    visualCalc.setLength(0);
                    visualCalc.append(Math.sqrt(getNum1()));
                    reset();
                }
                tArea.setText(getVisualCalcString());
                tArea.setCaretPosition(tArea.getDocument().getLength());
                maxChar++;
            }
        }
    }
}
