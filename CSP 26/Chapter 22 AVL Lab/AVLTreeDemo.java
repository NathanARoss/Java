import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

/**
   The AVLFrame class builds the user interface and 
   supports user interaction.

    I modified this class to add additional commands to test drive
    the NathansAVLTree class.

    Modified by Nathan Ross
    Last modified 5-12-2018
*/

public class AVLTreeDemo extends JFrame
implements ActionListener
{
    // AVL Tree and a Displayable wrapper.
    private NathansAVLTree avlTree = new NathansAVLTree();
    private DisplayableBtree 
            displayAvlTree = new DisplayableBtree(avlTree);
    
    // User interface components.
    private JLabel cmdResultLabel;
    private JTextField cmdResultTextField;    
    private JLabel cmdLabel;
    private JTextField cmdTextField;
   
    public AVLTreeDemo()
    {
        setTitle("AVL Trees");
        
        // cmd text and cmd Result label in North Region.
        JPanel resultPanel = new JPanel(new GridLayout(2,1));
        cmdResultLabel = new JLabel("Command Result: ");
        cmdResultTextField = new JTextField();
        resultPanel.add(cmdResultLabel);
        resultPanel.add(cmdResultTextField);
        cmdResultTextField.setEditable(false);

        JPanel topPanel = new JPanel(new GridLayout(1,2));
        String commandList = "Command List:\n" +
                "add VALUE\n" +
                "clear\n" +
                "count-and-display HEIGHT\n" +
                "get-level-of VALUE\n" +
                "get-path-to VALUE";
        JTextArea commandListBox = new JTextArea(commandList);
        commandListBox.setEditable(false);

        topPanel.add(resultPanel);
        topPanel.add(commandListBox);

        add(topPanel, BorderLayout.NORTH);
        // Leave center for binary tree view.
        
        // cmd label and cmd text field in South Region.
        cmdLabel = new JLabel("Command: ");
        cmdTextField = new JTextField();
        JPanel cmdPanel = new JPanel(new GridLayout(1,2));
        cmdPanel.add(cmdLabel);
        cmdPanel.add(cmdTextField);
        cmdTextField.addActionListener(this);
        add(cmdPanel, BorderLayout.SOUTH);
        
        // Set up the frame.
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setVisible(true);

        //add initial values of tree
        for (int i = 0; i < 31; ++i) {
            avlTree.add(i);
        }

        add(displayAvlTree.getSwingView());
        pack();
        validate();
    }
    
    JPanel view = null;
    
    /**
       This method interprets user commands entered in the 
       command entry text field.
       @return evt The action event from the 
       command entry text field.
    */
    
    public void actionPerformed(ActionEvent evt)
    {
        String cmdStr = cmdTextField.getText();

        boolean treeChanged = false;

        Scanner sc = new Scanner(cmdStr);
        String cmd = sc.next();
        if (cmd.equals("add"))
        {
            int value = sc.nextInt();
            avlTree.add(value);
            treeChanged = true;
            cmdResultTextField.setText("value added");
        }

        else if (cmd.equals("clear")) {
            avlTree.clear();
            treeChanged = true;
            cmdResultTextField.setText("tree cleared");
        }

        else if (cmd.equals("count-and-display")) {
            ArrayList<Integer> list = avlTree.getValuesAtHeight(sc.nextInt());

            if (list == null) {
                cmdResultTextField.setText("invalid height");
            } else {
                String output = String.format("count: %d.  List: %s", list.size(), list);
                cmdResultTextField.setText(output);
            }
        }

        else if (cmd.equals("get-level-of")) {
            int level = avlTree.getLevelOfValue(sc.nextInt());

            if (level == -1) {
                cmdResultTextField.setText("item not found");
            } else {
                String output = String.format("value found at level %d", level);
                cmdResultTextField.setText(output);
            }
        }

        else if (cmd.equals("get-path-to")) {
            ArrayList<Integer> list = avlTree.getPathTo(sc.nextInt());

            if (list == null) {
                cmdResultTextField.setText("item not found");
            } else {
                String output = String.format("path to item: %s", list);
                cmdResultTextField.setText(output);
            }
        }

        else {
            cmdResultTextField.setText("command not recognized");
        }

        if (treeChanged) {
            if (view != null)
                remove(view);
            view = displayAvlTree.getSwingView();
            add(view);
            pack();
            validate();
        }
    } 
	 
    /**
       The main method creates an instance of the 
       AVLTreeDemo class which causes it to display
       its window.
   */
	 
    public static void main(String [ ] args)
    {
      AVLTreeDemo atd =  new AVLTreeDemo();
    }    
}