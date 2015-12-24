 /*TouchType.java*/
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;//for setting the dimensions of a component
//import javax.swing.BorderFactory;//to set the borders
import java.awt.Insets;
//import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.*;//needed for the key constants
import javax.swing.JScrollPane;
//for the map
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;	
public class TouchType extends JFrame{
	//private JPanel mainPanel;//wrapping panel
	private String character;
	private int theChar;
	private JButton buttonToHighlight;//button to hightlight when the corresponding one is clicked
	private JPanel labelPanel;//panel for labels
	private JLabel label1;//first label
	private JLabel label2;//second label
	private JPanel keysPanel;//holding the keys
	private JButton newButton;
	//rows panels for keys. 5 rows.
	private JPanel row1;
	private JPanel row2;
	private JPanel row3;
	private JPanel row4;
	private JPanel row5;
	private JTextArea textArea;//text area
	private BorderLayout bLayout1;
	private BorderLayout bLayout2;
	private GridLayout keysPanelLayout;
	private GridLayout gridLayoutRow1;
	private GridLayout gridLayoutRow2;
	private GridLayout gridLayoutRow3;
	private GridLayout gridLayoutRow4;
	private GridLayout gridLayoutRow5;
	private Color originalColour;
	
	
	Map<Integer,JButton> mp = new HashMap<Integer,JButton>();//declaring a map object	
	
	public TouchType(){//constructor
		super("Typing application");	
		
		//creating JPanels
		labelPanel = new JPanel(); //panel for labels
		character = " ";
		keysPanel = new JPanel();//panel wrapper for key rows
		row1 = new JPanel();//panel for row1
		row2 = new JPanel();//panel for row2
		row3 = new JPanel();//panel for row3
		row4 = new JPanel();//panel for row4
		row5 = new JPanel();//panel for row5
		
		//creating a button and adding it to the appropriate JPanel
		row1.add(createButton(VK_DEAD_TILDE, "~"));		
		row1.add(createButton(VK_1, "1"));		
		row1.add(createButton(VK_2, "2"));
		row1.add(createButton(VK_3, "3"));		
		row1.add(createButton(VK_4, "4"));		
		row1.add(createButton(VK_5, "5"));
		row1.add(createButton(VK_6, "6"));
		row1.add(createButton(VK_7, "7"));		
		row1.add(createButton(VK_8, "8"));		
		row1.add(createButton(VK_9, "9"));		
		row1.add(createButton(VK_MINUS, "-"));		
		row1.add(createButton(VK_PLUS, "+"));		
		row1.add(createButton(VK_BACK_SPACE, "Backspace"));
		row2.add(createButton(VK_TAB, "Tab"));		
		row2.add(createButton(VK_Q, "q"));		
		row2.add(createButton(VK_W, "w"));
		row2.add(createButton(VK_E, "e"));		
		row2.add(createButton(VK_R, "r"));		
		row2.add(createButton(VK_T, "t"));		
		row2.add(createButton(VK_Y, "y"));		
		row2.add(createButton(VK_U, "u"));		
		row2.add(createButton(VK_I, "i"));		
		row2.add(createButton(VK_O, "o"));
		row2.add(createButton(VK_P, "p"));		
		row2.add(createButton(VK_OPEN_BRACKET, "["));		
		row2.add(createButton(VK_CLOSE_BRACKET, "]"));		
		row2.add(createButton(VK_BACK_SLASH, "\\"));		
		row3.add(createButton(VK_CAPS_LOCK, "Caps"));
		row3.add(createButton(VK_A, "a"));		
		row3.add(createButton(VK_S, "s"));		
		row3.add(createButton(VK_D, "d"));		
		row3.add(createButton(VK_F, "f"));		
		row3.add(createButton(VK_G, "g"));		
		row3.add(createButton(VK_H, "h"));		
		row3.add(createButton(VK_J, "j"));		
		row3.add(createButton(VK_K, "k"));		
		row3.add(createButton(VK_L, "l"));		
		row3.add(createButton(VK_SEMICOLON, ";"));		
		row3.add(createButton(VK_EQUALS, "="));		
		row3.add(createButton(VK_ENTER, "Enter"));		
		row4.add(createButton(VK_SHIFT, "Shift"));		
		row4.add(createButton(VK_Z, "z"));		
		row4.add(createButton(VK_X, "x"));		
		row4.add(createButton(VK_C, "c"));		
		row4.add(createButton(VK_V, "v"));		
		row4.add(createButton(VK_B, "b"));		
		row4.add(createButton(VK_N, "n"));		
		row4.add(createButton(VK_M, "m"));		
		row4.add(createButton(VK_COMMA, ","));		
		row4.add(createButton(VK_PERIOD, "."));		
		row4.add(createButton(VK_SLASH, "/"));		
		row4.add(createButton(VK_UP, "up"));		
		row5.add(createButton(VK_SPACE, ""));		
		row5.add(createButton(VK_LEFT, "Left"));		
		row5.add(createButton(VK_DOWN, "Bottom"));		
		row5.add(createButton(VK_RIGHT, "Right"));	
		
		//SORT OUT THE LAYOUTS
		//border layouts
		bLayout1 = new BorderLayout();//for JFrame
		bLayout2 = new BorderLayout();//for labelPanel
		keysPanelLayout = new GridLayout(5,1,5,5);//for keysPanel, adds gaps between components, so rows
		//creating gridLayout objects for rows
		gridLayoutRow1 = new GridLayout(1,14,5,5);//row, cols, hgap,vgap
		gridLayoutRow2 = new GridLayout(1,14,5,5);//add gaps between components, so buttons
		gridLayoutRow3 = new GridLayout(1,13,5,5);
		gridLayoutRow4 = new GridLayout(1,12,5,5);
		gridLayoutRow5 = new GridLayout(1,4,5,5);
		//creeating elements
		textArea = new JTextArea(10,15);
		label1 = new JLabel("Type some text using your keyboard. The keys you press will be highlighted and the text will be displayed");
		label2 = new JLabel("Note: clicking the button with your mouse will not perform any action");
		
		//set layouts
		setLayout(bLayout1);//set layout of JFrame
		keysPanel.setLayout(keysPanelLayout);//set layout of keysPanel
		labelPanel.setLayout(bLayout2);//layout of labelPanel
		row1.setLayout(gridLayoutRow1);//set layout of row1
		row2.setLayout(gridLayoutRow2);//set layout of row2
		row3.setLayout(gridLayoutRow3);//set layout of row3
		row4.setLayout(gridLayoutRow4);//set layout of row4
		row5.setLayout(gridLayoutRow5);//set layout of row5
		
		//add elements to their panels
		labelPanel.add(label1, BorderLayout.NORTH);//add label to labelPanel, top
		labelPanel.add(label2, BorderLayout.CENTER);//add label to labelPanel, middle
		
		keysPanel.add(row1);//add row to keysPanel
		keysPanel.add(row2);//add row to keysPanel
		keysPanel.add(row3);//add row to keysPanel
		keysPanel.add(row4);//add row to keysPanel
		keysPanel.add(row5);//add row to keysPanel
		add(labelPanel, BorderLayout.NORTH);//add labelPanel to JFrame, top
		add(new JScrollPane(textArea), BorderLayout.CENTER);//add textArea to the JFrame, middle		
		add(keysPanel, BorderLayout.SOUTH);//add the keysPanel wrapper to the JFrame, bottom
		textArea.setEnabled(false);//disable textarea
		textArea.setDisabledTextColor(Color.BLACK);
		textArea.setMargin(new Insets(15,5,15,5));//sets margins inside the element
		
		/* for (Map.Entry<Integer, JButton> entry : mp.entrySet())
		{
			//System.out.println("value is " + entry.getValue());
		} */
		
		Dimension backButtonSize = new Dimension(100,50);
		JButton backspaceBtn = mp.get(VK_BACK_SPACE);
		backspaceBtn.setPreferredSize( backButtonSize );
		
		KeyHandler handler = new KeyHandler();
		for(JButton currentButton:mp.values()){
			currentButton.addKeyListener(handler);
			originalColour = currentButton.getBackground();			
			//this works
			/* Dimension preferredSize = new Dimension(100,100);
			currentButton.setPreferredSize( preferredSize ); */
		}
		
		
	}//end of constructor
	
	//private class for event handling
	private class KeyHandler implements KeyListener{
		public void keyPressed(KeyEvent event){
			theChar = event.getKeyCode();
			
			//character += String.format("%s", KeyEvent.getKeyText(event.getKeyCode()));//get the constant
			
			/* switch(theChar){
				case VK_SPACE:
					character += " ";
					break;
				case VK_BACK_SPACE:
				case VK_TAB:
				case VK_CAPS_LOCK:
				case VK_ENTER:
				case VK_SHIFT:
				case VK_UP:
				case VK_LEFT:
				case VK_DOWN:
				case VK_RIGHT:
					character += "";
					break;
				default:
					character += String.format("%s", KeyEvent.getKeyText(event.getKeyCode()));//get the constant
			} */
			
			//character = String.format("%s", (event.getKeyCode()));//get the constant
			//KeyEvent.isFocusable(true);
			
			buttonToHighlight = mp.get(theChar);
			
			buttonToHighlight.setBackground(Color.GREEN);
			
			/* JButton buttonSizeTochange = mp.get(VK_BACK_SPACE);
			buttonSizeTochange.setMinimumSize(new Dimension(100,100) ); */
			
			//textArea.setText(character);
		}
		public void keyReleased(KeyEvent event){
			//buttonToHighlight = mp.get(theChar);
			int theCharTemp = event.getKeyCode();
			JButton JButtonTemp = mp.get(theCharTemp);
			JButtonTemp.setBackground(originalColour);
		}
		public void keyTyped(KeyEvent event){
			character += String.format("%s", event.getKeyChar());
			//String temp = KeyEvent.getModifiersText(event.getModifiers)
			/* switch(theChar){
				case VK_SPACE:
					character += " ";
					break;
				case VK_BACK_SPACE:				
				case VK_ENTER:				
					character += "";
					break;
				default:
					character += String.format("%s", KeyEvent.getKeyText(theChar));//get the constant
			} */
			textArea.setText(character);
		}
	}
	
	//creates a button and adds it to the Map
	private JButton createButton(int keyCode, String name){
		newButton = new JButton(name);
		mp.put(keyCode, newButton);
		return newButton;
	}
}//end of TouchType class


/*
JFrame							//borderLayout
    JPanel labelPanel			//borderLayout NORTH
        JLabel	NORTH
        Jlabel  CENTER
    JTextArea					//directly added to JFrame, CENTER
    JPanel keysPanel			//GridLayout 
		JPanel row1				//GridLayout            
			key	
			key	
			key	
        JPanel row2				//GridLayout            
			key	
			key	
			key	
		JPanel row3				//GridLayout            
			key	
			key	
			key	
		...

*/
