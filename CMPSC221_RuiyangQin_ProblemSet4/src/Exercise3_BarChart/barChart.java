package Exercise3_BarChart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class  barChart extends Frame implements ActionListener{

    Color[] colors = { Color.BLACK, Color.RED, Color.GRAY,
            Color.GREEN, Color.BLUE, Color.LIGHT_GRAY,
            Color.cyan, Color.darkGray, Color.ORANGE};
    public static ArrayList<String> dataArr = new ArrayList<>();
    JPanel titlePanel = new JPanel();
    barPanel barChartPanel = new barPanel();
    JPanel MainPanel = new JPanel();
    JLabel title = new JLabel();
    JLabel leftTitle = new JLabel();

    public barChart(){
        super("Bake Sale Demo");

        //leftTitle.setText("Population(millions)");
        try{
            BufferedImage bi = ImageIO.read(new File("file://C://Users//China//IdeaProjects//CMPSC221_RuiyangQin_ProblemSet4//src//Exercise3_BarChart//population.PNG"));
            Graphics2D g = (Graphics2D)bi.getGraphics();
            g.drawImage(bi,30,150,null);
            JLabel image = new JLabel((new ImageIcon(bi)));
            add(image);
            System.out.println("run");
        }catch(IOException e){
        }

        setResizable(false);
        setLayout(new BorderLayout());
        barChartPanel.setSize(450,300);
        titlePanel.setBackground(Color.white);
        titlePanel.setSize(450,30);
        title.setText("Population Comparison");
        titlePanel.add(title);
        MainPanel.add(titlePanel,BorderLayout.NORTH);
        MainPanel.add(barChartPanel,BorderLayout.SOUTH);
        add(leftTitle,BorderLayout.WEST);
        MainPanel.setBackground(Color.white);
        add(MainPanel);
        setSize(500, 330);
        setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args){
        System.out.print("Enter data(1) or Generate Chart(0)");
        Scanner input1 = new Scanner(System.in);
        int headnum = input1.nextInt();
        while(headnum != 0){
            System.out.println("Please enter your data:(population unit is million; for example:China 1300) ");
            Scanner input2 = new Scanner(System.in);
            String data = input2.nextLine();
            dataArr.add(data);
            System.out.print("Enter data(1) or Generate Chart(0)");
            Scanner input3 = new Scanner(System.in);
            int headnum1 = input3.nextInt();
            headnum = headnum1;
        }
        barChart b = new barChart();
    }

    public void paint(Graphics g){
        super.paint(g);
        /**
         * draw bar for the chart
         * Theoretically, the user will be able to enter infinite data. However, the chart will show very weird if the user does that.
         * For testing this part is working or not, enter no more 5 will be much enough.
         */
        int widthBar = (int)((300/dataArr.size()/2));
        double height;

        int sum = 0;
        for(int i = 0; i < dataArr.size(); i++){
            sum += (Double.parseDouble(dataArr.get(i).split(" ")[1]));
        }
        for(int i = 0; i < dataArr.size(); i++){
            double a = (Double.parseDouble(dataArr.get(i).split(" ")[1]));
            height = (a/230*15*2.3);//230*1500
            Random r = new Random();
            int n = r.nextInt(8);
            g.setColor(colors[n]);
            g.drawRect(80+i*widthBar*2,300-(int)height,widthBar,(int)height);
            g.fillRect(80+i*widthBar*2,300-(int)height,widthBar,(int)height);
            g.setColor(Color.black);
            g.drawString(dataArr.get(i).split(" ")[0],80+i*widthBar*2,310);
        }

        g.setColor(Color.black);
        g.drawLine(70,300,480,300);
        g.setColor(Color.black);
        g.drawLine(70,300,70,70);
        g.drawString(0+"",55,303);
        int x_axis = 1000;
        for(int i = 150; i < 240; i+=15){
            g.drawString(x_axis+"",35,303-i);
            x_axis += 100;
        }
        x_axis = 100;
        for(int i = 15; i < 150; i+=15){
            g.drawString(x_axis+"",42,303-i);
            x_axis += 100;
        }
        for(int i = 0; i < 240; i+=15){
            g.drawLine(65,300-i,75,300-i);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

class barPanel extends JPanel{
    @Override
    public void setBackground(Color bg) {
        super.setBackground(Color.white);
    }
}

