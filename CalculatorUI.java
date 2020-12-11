import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CalculatorUI implements ActionListener{
  private String number1 = "";
  private String number2 = "";
  private boolean firstEntered = false;
  private char operation;
  private ArrayList<JButton> buttonArray;
  private JFrame frame;
  private JPanel panel;
  private JLabel viewerField;
  //Add getters amd setters for all of these

  public CalculatorUI() {
    frame = new JFrame();
    panel = new JPanel(new GridBagLayout());
    viewerField = new JLabel();
    frame.setSize(250, 500);
    frame.setResizable(false);
    panel.setPreferredSize(new Dimension(250,500));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(panel);
    frame.pack();
  }

  public static void main(String[] args) {

    //Makes frame use components default
    CalculatorUI calculatorGUI = new CalculatorUI();
    calculatorGUI.setButtonArray(calculatorGUI.createButtons());

    //Populate JFrame with buttons (1-9), operations

    calculatorGUI.addAndFormatButtons(calculatorGUI.getButtonArray(), calculatorGUI.getViewerField());

    calculatorGUI.getFrame().setVisible(true);

    //Add logic for entering in numbers


  }

  private void updateViewer(char enteredNum) {
    String operations = "*/+-";

    if (number1.length() >= 6) {
      firstEntered = true;
    }

    //up to 6 numbers for num1 and num2
    //if more, don't accept
    //When hit function key, wipe screen and display funtion
    //When num2 display number
    //Output rounded answer
    if (!firstEntered && operations.indexOf(enteredNum) < 0 && number1.length() < 6) {
        number1 = number1 + String.valueOf(enteredNum);
        System.out.println(number1);
        viewerField.setText(number1);
    } else if (operations.indexOf(enteredNum) > -1) {
      operation = enteredNum;
      firstEntered = true;
      viewerField.setText(String.valueOf(operation));
    } else if (firstEntered && operations.indexOf(enteredNum) < 0 && number2.length() < 6) {
      number2 = number2 + String.valueOf(enteredNum);
      viewerField.setText(number2);
    }
    //Check if operation was number or operation
      //Check to make sure logic valid
    //Append number to text field
    //
  }

  private void calculateAnswer() {
    double doubleNum1;
    double doubleNum2;
    double answer;

    doubleNum1 = Double.valueOf(this.getNumber1());
    doubleNum2 = Double.valueOf(getNumber2());

    switch(operation) {
      case '+':
        answer = doubleNum1 + doubleNum2;
        viewerField.setText(String.valueOf(answer));
        break;
      case '-':
        answer = doubleNum1 - doubleNum2;
        viewerField.setText(String.valueOf(answer));
        break;
      case '*':
        answer = doubleNum1 * doubleNum2;
        viewerField.setText(String.valueOf(answer));
        break;
      case '/':
        answer = doubleNum1 / doubleNum2;
        viewerField.setText(String.valueOf(answer));
        break;
      default:
        System.out.println("No operation set");
    }
  }

  private void addAndFormatButtons(ArrayList<JButton> buttonArray, JLabel viewerField){
    GridBagConstraints c = new GridBagConstraints();


    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridwidth = 3;
    c.gridy = 0;
    this.getPanel().add(viewerField, c);


    int xGrid = 0;
    int yGrid = 1;
    for(JButton button : buttonArray) {

      c.weightx = 0.5;
      c.gridx = xGrid;
      c.gridy = yGrid;
      c.gridwidth = 1;
      this.getPanel().add(button, c);
      xGrid++;
      if (xGrid > 2) {
        xGrid = 0;
        yGrid++;
      }
    }

  }

  private void clearCalculator(){
    setNumber1("");
    setNumber2("");

    setFirstEntered(false);

    viewerField.setText("");

  }


  private ArrayList<JButton> createButtons(){
    ArrayList<JButton> createdButtons = new ArrayList<JButton>();

    JButton button1 = new JButton("1");
    button1.addActionListener( new AbstractAction("1") {
      @Override
      public void actionPerformed( ActionEvent e) {
        //button for 1
        updateViewer('1');
      }
    });
    createdButtons.add(button1);

    JButton button2 = new JButton("2");
    button2.addActionListener(new AbstractAction("2") {
      @Override
      public void actionPerformed( ActionEvent e) {
        //button for 2
        updateViewer('2');
      }
    });
    createdButtons.add(button2);

    JButton button3 = new JButton("3");
    button3.addActionListener(new AbstractAction("3") {
      @Override
      public void actionPerformed( ActionEvent e) {
        //button for 3
        updateViewer('3');
      }
    });
    createdButtons.add(button3);

    JButton button4 = new JButton("4");
    button4.addActionListener(new AbstractAction("4") {
      @Override
      public void actionPerformed( ActionEvent e) {
        //button for 4
        updateViewer('4');
      }
    });
    createdButtons.add(button4);

    JButton button5 = new JButton("5");
    button5.addActionListener(new AbstractAction("5") {
      @Override
      public void actionPerformed( ActionEvent e) {
        //button for 5
        updateViewer('5');
      }
    });
    createdButtons.add(button5);

    JButton button6 = new JButton("6");
    button6.addActionListener(new AbstractAction("6") {
      @Override
      public void actionPerformed( ActionEvent e) {
        //button for 6
        updateViewer('6');
      }
    });

    createdButtons.add(button6);

    JButton button7 = new JButton("7");
    button7.addActionListener(new AbstractAction("7") {
      @Override
      public void actionPerformed( ActionEvent e) {
        //button for 7
        updateViewer('7');
      }
    });
    createdButtons.add(button7);

    JButton button8 = new JButton("8");
    button8.addActionListener(new AbstractAction("8") {
      @Override
      public void actionPerformed( ActionEvent e) {
        //button for 8
        updateViewer('8');
      }
    });
    createdButtons.add(button8);

    JButton button9 = new JButton("9");
    button9.addActionListener(new AbstractAction("9") {
      @Override
      public void actionPerformed( ActionEvent e) {
        //button for 9
        updateViewer('9');
      }
    });
    createdButtons.add(button9);

    JButton button0 = new JButton("0");
    button0.addActionListener(new AbstractAction("0") {
      @Override
      public void actionPerformed( ActionEvent e) {
        //button for 0
        updateViewer('0');
      }
    });
    createdButtons.add(button0);

    JButton addButton = new JButton("+");
    addButton.addActionListener(new AbstractAction("+") {
      @Override
      public void actionPerformed( ActionEvent e) {
        //button for +
        updateViewer('+');
      }
    });
    createdButtons.add(addButton);

    JButton subtractButton = new JButton("-");
    subtractButton.addActionListener(new AbstractAction("-") {
      @Override
      public void actionPerformed( ActionEvent e) {
        //button for -
        updateViewer('-');
      }
    });
    createdButtons.add(subtractButton);

    JButton multiplyButton = new JButton("*");
    multiplyButton.addActionListener(new AbstractAction("*") {
      @Override
      public void actionPerformed( ActionEvent e) {
        //button for *
        updateViewer('*');
      }
    });
    createdButtons.add(multiplyButton);

    JButton divideButton = new JButton("/");
    divideButton.addActionListener(new AbstractAction("/") {
      @Override
      public void actionPerformed( ActionEvent e) {
        //button for /
        updateViewer('/');
      }
    });
    createdButtons.add(divideButton);

    JButton enterButton = new JButton("Enter");
    enterButton.addActionListener(new AbstractAction("Enter") {
      @Override
      public void actionPerformed( ActionEvent e) {
        //button for 2
        calculateAnswer();
      }
    });
    createdButtons.add(enterButton);

    JButton clearButton = new JButton("Clear");
    clearButton.addActionListener(new AbstractAction("Clear") {
      @Override
      public void actionPerformed( ActionEvent e) {
        //button for 2
        clearCalculator();
      }
    });
    createdButtons.add(clearButton);

    return createdButtons;
  }

  public void actionPerformed(ActionEvent e) {
    System.out.println(e);
  }

  public String getNumber1() {
    return this.number1;
  }

  public void setNumber1(String number) {
    this.number1 = number;
  }

  public String getNumber2() {
    return this.number2;
  }

  public void setNumber2(String number) {
    this.number2 = number;
  }

  public char getOperation() {
    return this.operation;
  }

  public void setOperation(char operation) {
    this.operation = operation;
  }

  public ArrayList getButtonArray() {
    return this.buttonArray;
  }

  public void setButtonArray(ArrayList<JButton> buttonArray){
    this.buttonArray = buttonArray;
  }

  public JFrame getFrame(){
    return this.frame;
  }

  public JPanel getPanel() {
    return this.panel;
  }

  public JLabel getViewerField(){
    return this.viewerField;
  }

  public boolean getFirstEntered() {
    return this.firstEntered;
  }

  public void setFirstEntered(boolean firstEntered){
    this.firstEntered = firstEntered;
  }
}
