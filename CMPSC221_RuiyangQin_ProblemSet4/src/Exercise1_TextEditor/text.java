package Exercise1_TextEditor;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class text implements ActionListener {

    JFrame frame = new JFrame();
    MenuBar menuBar = new MenuBar();
    Menu menuFile = new Menu("File");
    MenuItem NewItem = new MenuItem("New");
    MenuItem OpenItem = new MenuItem("Open");
    MenuItem SaveItem = new MenuItem("Save");
    MenuItem ExitItem = new MenuItem("Exit");
    JTextArea textArea = new JTextArea();
    public static ArrayList<String> fileInfo = new ArrayList<>();
    JFileChooser fileChooser = new JFileChooser();
    JFileChooser saveAs = new JFileChooser();

    public text(){
        frame.setSize(500,700);
        frame.setTitle("Notepad");
        menuFile.add(NewItem);
        menuFile.addSeparator();
        menuFile.add(OpenItem);
        menuFile.addSeparator();
        menuFile.add(SaveItem);
        menuFile.addSeparator();
        menuFile.add(ExitItem);

        menuBar.add(menuFile);
        frame.setMenuBar(menuBar);
        frame.add(textArea);

        NewItem.addActionListener(this);
        OpenItem.addActionListener(this);
        SaveItem.addActionListener(this);
        ExitItem.addActionListener(this);
        frame.setVisible(Boolean.TRUE);
    }
    public static void main(String[] args){
        text frame = new text();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "New":
                NewItem.addActionListener(this);
                textArea.setText("");
                break;
            case "Open":
                fileChooser.showOpenDialog(frame);
                File file = fileChooser.getSelectedFile();
                try{
                    BufferedReader input = new BufferedReader(new FileReader(file));
                    String line = input.readLine();
                    while(line != null){
                        textArea.append(line+"\n");
                        line = input.readLine();
                    }
                }catch(IOException IE){
                }
                break;
            case "Save":
                saveAs.setApproveButtonText("Save");
                saveAs.showOpenDialog(frame);
                File filename = new File(saveAs.getSelectedFile()+".txt");
                try{
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
                    textArea.write(bufferedWriter);
                    bufferedWriter.close();
                }catch(IOException IE){

                }
                break;
            case "Exit":
                System.exit(0);
                break;
        }
    }
}
