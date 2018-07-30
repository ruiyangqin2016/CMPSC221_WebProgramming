package Exercise4_Triangle;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AppletViewer extends JFrame implements ActionListener{

    ArrayList<ArrayList<Point>> smallTri = new ArrayList<>();
    JTextField order = new JTextField();
    JLabel enter = new JLabel();
    JPanel operationPanel = new JPanel();
    JTextArea hint = new JTextArea();
    JPanel lowerPanel = new JPanel();
    JButton repaintButton = new JButton();
    private static int count = 0;

    /**
     * Outer triangle coordination
     */
    static Point one = new Point(60,600),
                 two = new Point(350,60),
                 three = new Point(640,600);

    public AppletViewer(){
        super.setTitle("Applet Viewer: SierpinskiTriangle.class");
        operationPanel.setSize(500,30);
        lowerPanel.setLayout(new BoxLayout(lowerPanel,BoxLayout.Y_AXIS));
        order.setColumns(8);
        enter.setText("Enter an order: ");
        operationPanel.setLayout(new FlowLayout());
        operationPanel.add(enter);
        operationPanel.add(order);
        operationPanel.add(repaintButton);
        repaintButton.setText("repaint");
        hint.setText("                                                Please enter your order no larger than 15, Thank you and Have fun!");
        lowerPanel.add(operationPanel);
        lowerPanel.add(hint);
        setLayout(new BorderLayout());
        setSize(700,680);
        add(lowerPanel,BorderLayout.SOUTH);
        setResizable(false);
        setVisible(true);

        repaintButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                count = Integer.parseInt(order.getText());
                if(count>=0){
                    smallTri.clear();
                    setCoord(count-1,one,two,three);
                    repaint();
                }
            }
        });
    }
    public static Point midPoint(Point one1, Point two2){
        Point a = new Point((one1.x+two2.x)/2,(one1.y+two2.y)/2);
        return a;
    }

    public void setCoord(int num,Point one1, Point two2, Point three3){
        Point left, down, right;
        if(num >=0){
            ArrayList<Point> a = new ArrayList<>();
            Point aa = midPoint(one1,two2);
            Point bb = midPoint(two2,three3);
            Point cc = midPoint(one1,three3);
            a.add(aa);
            a.add(bb);
            a.add(cc);
            smallTri.add(a);
            setCoord(num-1,one1,aa,cc);
            setCoord(num-1,aa,two2,bb);
            setCoord(num-1,cc,bb,three3);
        }
    }

    public void paint(Graphics g){
        super.paint(g);
        g.drawString("Applet",20,50);
        g.drawLine(one.x,one.y,two.x,two.y);
        g.drawLine(one.x,one.y,three.x,three.y);
        g.drawLine(two.x,two.y,three.x,three.y);
        g.setColor(Color.black);
        for(int i = 0; i < smallTri.size(); i ++){
            Point a = smallTri.get(i).get(0);
            Point b = smallTri.get(i).get(1);
            Point c = smallTri.get(i).get(2);
            g.drawLine(a.x,a.y,b.x,b.y);
            g.drawLine(a.x,a.y,c.x,c.y);
            g.drawLine(b.x,b.y,c.x,c.y);
        }
    }

    public static void main(String[] args){

        AppletViewer b = new AppletViewer();
        b.setCoord(count-1,one,two,three);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaintButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                count = Integer.parseInt(order.getText());
                repaint();
            }
        });

    }
}
