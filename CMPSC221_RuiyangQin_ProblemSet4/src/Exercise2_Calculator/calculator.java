package Exercise2_Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class calculator implements ActionListener{

    public static ArrayList<String> numberList = new ArrayList<>();
    JFrame frame = new JFrame();
    MenuBar menuBar = new MenuBar();
    Menu menuFile = new Menu("File");
    Menu menuHelp = new Menu("Help");
    MenuItem exit = new MenuItem("Exit");
    MenuItem info = new MenuItem("Information");
    JTextArea inputNumbers = new JTextArea();
    JPanel insideUpperPanel = new JPanel();
    JPanel insideUpperPanel1 = new JPanel();
    JPanel UpperPanel = new JPanel();
    JPanel LowerPanel = new JPanel();
    JPanel mainPanel = new JPanel();

    public calculator(){

        exit.addActionListener(this);
        info.addActionListener(this);

        frame.setSize(330,215);
        frame.setResizable(false);
        frame.setTitle("Java Swing Calculator");
        menuFile.add(exit);
        menuHelp.add(info);
        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));

        /**
         * Upper component
         */
        UpperPanel.setLayout(new BorderLayout());
        UpperPanel.add(insideUpperPanel,BorderLayout.EAST);
        insideUpperPanel.setBackground(Color.LIGHT_GRAY);
        UpperPanel.add(insideUpperPanel1,BorderLayout.WEST);
        insideUpperPanel1.setBackground(Color.LIGHT_GRAY);

        JButton backspace = new JButton("Backspace");
        insideUpperPanel1.add(backspace,BorderLayout.WEST);
        JButton CE = new JButton("CE");
        insideUpperPanel.add(CE);
        JButton C = new JButton("C");
        insideUpperPanel.add(C);
        backspace.setBackground(Color.LIGHT_GRAY);
        backspace.setForeground(Color.RED);
        CE.setBackground(Color.LIGHT_GRAY);
        CE.setForeground(Color.RED);
        C.setBackground(Color.LIGHT_GRAY);
        C.setForeground(Color.RED);

        /**
         * Lower component
         */
        LowerPanel.setLayout(new GridLayout(4,5));

        JButton button7 = new JButton("7");
        LowerPanel.add(button7);
        button7.setBackground(Color.LIGHT_GRAY);
        button7.setForeground(Color.BLUE);

        JButton button8 = new JButton("8");
        LowerPanel.add(button8);
        button8.setBackground(Color.LIGHT_GRAY);
        button8.setForeground(Color.BLUE);

        JButton button9 = new JButton("9");
        LowerPanel.add(button9);
        button9.setBackground(Color.LIGHT_GRAY);
        button9.setForeground(Color.BLUE);

        JButton buttonSlash = new JButton("/");
        LowerPanel.add(buttonSlash);
        buttonSlash.setBackground(Color.LIGHT_GRAY);
        buttonSlash.setForeground(Color.RED);

        JButton buttonSqrt = new JButton("Sqrt");
        LowerPanel.add(buttonSqrt);
        buttonSqrt.setBackground(Color.LIGHT_GRAY);
        buttonSqrt.setForeground(Color.RED);

        JButton button4 = new JButton("4");
        LowerPanel.add(button4);
        button4.setBackground(Color.LIGHT_GRAY);
        button4.setForeground(Color.BLUE);

        JButton button5 = new JButton("5");
        LowerPanel.add(button5);
        button5.setBackground(Color.LIGHT_GRAY);
        button5.setForeground(Color.BLUE);

        JButton button6 = new JButton("6");
        LowerPanel.add(button6);
        button6.setBackground(Color.LIGHT_GRAY);
        button6.setForeground(Color.BLUE);

        JButton buttonTimes = new JButton("*");
        LowerPanel.add(buttonTimes);
        buttonTimes.setBackground(Color.LIGHT_GRAY);
        buttonTimes.setForeground(Color.RED);

        JButton buttonOneDivX = new JButton("1/x");
        LowerPanel.add(buttonOneDivX);
        buttonOneDivX.setBackground(Color.LIGHT_GRAY);
        buttonOneDivX.setForeground(Color.RED);

        JButton button1 = new JButton("1");
        LowerPanel.add(button1);
        button1.setBackground(Color.LIGHT_GRAY);
        button1.setForeground(Color.BLUE);

        JButton button2 = new JButton("2");
        LowerPanel.add(button2);
        button2.setBackground(Color.LIGHT_GRAY);
        button2.setForeground(Color.BLUE);

        JButton button3 = new JButton("3");
        LowerPanel.add(button3);
        button3.setBackground(Color.LIGHT_GRAY);
        button3.setForeground(Color.BLUE);

        JButton buttonSubs = new JButton("-");
        LowerPanel.add(buttonSubs);
        buttonSubs.setBackground(Color.LIGHT_GRAY);
        buttonSubs.setForeground(Color.RED);

        JButton buttonPerc = new JButton("%");
        LowerPanel.add(buttonPerc);
        buttonPerc.setBackground(Color.LIGHT_GRAY);
        buttonPerc.setForeground(Color.RED);

        JButton button0 = new JButton("0");
        LowerPanel.add(button0);
        button0.setBackground(Color.LIGHT_GRAY);
        button0.setForeground(Color.BLUE);

        JButton buttonAddSubs = new JButton("+/-");
        LowerPanel.add(buttonAddSubs);
        buttonAddSubs.setBackground(Color.LIGHT_GRAY);
        buttonAddSubs.setForeground(Color.RED);

        JButton buttonPoint = new JButton(".");
        LowerPanel.add(buttonPoint);
        buttonPoint.setBackground(Color.LIGHT_GRAY);
        buttonPoint.setForeground(Color.RED);

        JButton buttonAdd = new JButton("+");
        LowerPanel.add(buttonAdd);
        buttonAdd.setBackground(Color.LIGHT_GRAY);
        buttonAdd.setForeground(Color.RED);

        JButton buttonEquals = new JButton("=");
        LowerPanel.add(buttonEquals);
        buttonEquals.setBackground(Color.LIGHT_GRAY);
        buttonEquals.setForeground(Color.RED);

        UpperPanel.setBackground(Color.LIGHT_GRAY);
        LowerPanel.setBackground(Color.lightGray);
        mainPanel.add(inputNumbers);
        mainPanel.add(UpperPanel);
        mainPanel.add(LowerPanel);
        frame.add(mainPanel);
        frame.setMenuBar(menuBar);

        frame.setVisible(Boolean.TRUE);

        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.append("0");
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.append("1");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.append("2");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inputNumbers.append("3");
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.append("4");
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.append("5");
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.append("6");
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.append("7");
            }
        });

        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.append("8");
            }
        });

        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.append("9");
            }
        });

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.append("+");
            }
        });

        buttonSubs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.append("-");
            }
        });

        buttonTimes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.append("*");
            }
        });

        buttonPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.append(".");
            }
        });

        buttonSlash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.append("/");
            }
        });

        backspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.setText(removeLastLetter(inputNumbers.getText()));
            }
        });

        CE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.setText(removeLastNumber(inputNumbers.getText()));
            }
        });

        C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.setText("");
            }
        });

        buttonSqrt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.setText(sqrtCalc(inputNumbers.getText()));
            }
        });

        buttonEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.setText(calculation(inputNumbers.getText())+"");
            }
        });

        buttonOneDivX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.append("1/");
            }
        });

        buttonPerc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.setText(percCalc(inputNumbers.getText()));
            }
        });

        buttonAddSubs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNumbers.setText(addSubs(inputNumbers.getText()));
            }
        });
    }

    public static void main(String[] args){
        calculator cal = new calculator();
    }

    public static String addSubs(String numbers){
        String lastWord = "";
        int count = 0;
        for(int i = numbers.length()-1; i >= 0; i--){
            if(!(numbers.charAt(i)+"").equals("+")
                    &&!(numbers.charAt(i)+"").equals("-")
                    &&!(numbers.charAt(i)+"").equals("*")
                    &&!(numbers.charAt(i)+"").equals("/")){
                lastWord += (numbers.charAt(i)+"");
                count++;
            }else{
                i = -1;
            }
        }
        int lengthPos = numbers.length() - 1;
        String newNumber = "";
        for(int i = 0; i < lengthPos - count; i++){
            newNumber += numbers.charAt(i)+"";
        }
        numbers = newNumber;
        String lastWordOrderly = "";
        for(int i = lastWord.length()-1; i >= 0; i--){
            lastWordOrderly += lastWord.charAt(i)+"";
        }
        lastWordOrderly = (Double.parseDouble(lastWordOrderly))*(-1)+"";
        if(Double.parseDouble(lastWordOrderly)>0){
            numbers += "+";
        }
        for(int i = 0; i < lastWordOrderly.length(); i++){
            numbers += lastWordOrderly.charAt(i)+"";
        }
        return numbers;
    }

    public static String percCalc(String numbers){
        String lastWord = "";
        int count = 0;
        for(int i = numbers.length()-1; i >= 0; i--){
            if(!(numbers.charAt(i)+"").equals("+")
                    &&!(numbers.charAt(i)+"").equals("-")
                    &&!(numbers.charAt(i)+"").equals("*")
                    &&!(numbers.charAt(i)+"").equals("/")){
                lastWord += (numbers.charAt(i)+"");
                count++;
            }else{
                i = -1;
            }
        }
        int lengthPos = numbers.length() - 1;
        String newNumber = "";
        for(int i = 0; i <= lengthPos - count; i++){
            newNumber += numbers.charAt(i)+"";
        }
        numbers = newNumber;
        String lastWordOrderly = "";
        for(int i = lastWord.length()-1; i >= 0; i--){
            lastWordOrderly += lastWord.charAt(i)+"";
        }
        lastWordOrderly = (Double.parseDouble(lastWordOrderly))*0.1+"";
        for(int i = 0; i < lastWordOrderly.length(); i++){
            numbers += lastWordOrderly.charAt(i)+"";
        }
        return numbers;
    }

    public static String sqrtCalc(String numbers){
        String lastWord = "";
        int count = 0;
        for(int i = numbers.length()-1; i >= 0; i--){
            if(!(numbers.charAt(i)+"").equals("+")
                    &&!(numbers.charAt(i)+"").equals("-")
                    &&!(numbers.charAt(i)+"").equals("*")
                    &&!(numbers.charAt(i)+"").equals("/")){
                lastWord += (numbers.charAt(i)+"");
                count++;
            }else{
                i = -1;
            }
        }
        int lengthPos = numbers.length() - 1;
        String newNumber = "";
        for(int i = 0; i <= lengthPos - count; i++){
            newNumber += numbers.charAt(i)+"";
        }
        numbers = newNumber;
        String lastWordOrderly = "";
        for(int i = lastWord.length()-1; i >= 0; i--){
            lastWordOrderly += lastWord.charAt(i)+"";
        }
        lastWordOrderly = Math.sqrt(Double.parseDouble(lastWordOrderly))+"";
        for(int i = 0; i < lastWordOrderly.length(); i++){
            numbers += lastWordOrderly.charAt(i)+"";
        }
        return numbers;
    }

    public static double calculation(String waitCalc){
        ArrayList<String> shortStorage = new ArrayList<>();
        for(int i = 0; i < waitCalc.length(); i++){
            if(!(waitCalc.charAt(i)+"").equals("+")
                    &&!(waitCalc.charAt(i)+"").equals("-")
                    &&!(waitCalc.charAt(i)+"").equals("*")
                    &&!(waitCalc.charAt(i)+"").equals("/")){
                shortStorage.add(waitCalc.charAt(i)+"");
            }else{
                String a = "";
                for(int ii = 0; ii< shortStorage.size();ii++){
                    a += shortStorage.get(ii);
                }
                numberList.add(a);
                //numberList.add(waitCalc.charAt(i)+"");
                shortStorage.clear();
                try{
                    numberList.add(waitCalc.charAt(i)+"");
                }catch(StringIndexOutOfBoundsException SE){
                    i += 100;
                }
            }
        }
        String a = "";
        for(int ii = 0; ii< shortStorage.size();ii++){
            a += shortStorage.get(ii);
        }
        numberList.add(a);
        //numberList.add(waitCalc.charAt(i)+"");
        shortStorage.clear();
        double outcome = Double.parseDouble(numberList.get(0));
        for(int i = 0; i < numberList.size(); i++){
            int count = 0;
            try{
                if(numberList.get(i).equals("*")){
                    count ++;
                    outcome = Double.parseDouble(numberList.get(i-1))*Double.parseDouble(numberList.get(i+1));
                }else if(numberList.get(i).equals("/")){
                    count ++;
                    outcome = Double.parseDouble(numberList.get(i-1))/Double.parseDouble(numberList.get(i+1));
                }
                if(count!=0){
                    numberList.remove(i +1);
                    numberList.remove(i);
                    numberList.remove(i-1);
                    numberList.add(i-1,outcome+"");
                }
            }catch(ArrayIndexOutOfBoundsException SE){
            }
        }
        for(int i = 0; i < numberList.size(); i++){
            if(numberList.get(i).equals("+")){
                outcome = outcome + Double.parseDouble(numberList.get(i+1));
            }else if(numberList.get(i).equals("-")){
                outcome = outcome - Double.parseDouble(numberList.get(i+1));
            }
        }
        numberList.clear();
        return outcome;
    }

    public static String removeLastNumber(String lnumber){
        String returnLnumber = "";
        for(int i = lnumber.length()-1; i >= 0; i--){
            if(!(lnumber.charAt(i)+"").equals("+")
                    &&!(lnumber.charAt(i)+"").equals("-")
                    &&!(lnumber.charAt(i)+"").equals("*")
                    &&!(lnumber.charAt(i)+"").equals("/")){
                lnumber = lnumber.replace(lnumber.charAt(i)+"","");

            }else{
                returnLnumber = lnumber;
                i = -1;
            }
        }
        return returnLnumber;
    }

    public static String removeLastLetter(String numbers){
        String newNumber = "";
        for(int i = 0; i < numbers.length()-1; i++){
            newNumber+=numbers.charAt(i);
        }
        return newNumber;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

         switch(actionEvent.getActionCommand()){
             case "Exit":
                 System.exit(0);
                 break;
             case "Inforamtion":
                 /**
                  * pop up frame, write it later
                  */
                 break;
         }
    }
}
