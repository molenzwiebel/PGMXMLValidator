package nl.thijsmolendijk.PGMXMLValidator;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;

public class MainView extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6266639522391620389L;
    protected JTextArea textArea;
    protected JTextArea resultArea;
    protected JLabel label1;
    protected JLabel label2;
    protected Button submitButton;
    protected JTextArea lines;
	
	public MainView(PGMXMLValidator mainClass) {
		super(new GridBagLayout()); 
		label1 = new JLabel("XML");
		label1.setFont(new Font("Helvetica", Font.PLAIN, 14));
		label1.setLocation(2, 0);
		label2 = new JLabel("Results");
		label2.setFont(new Font("Helvetica", Font.PLAIN, 14));
		label2.setLocation(2, 0);
		
		submitButton = new Button("Validate!");
		submitButton.addActionListener(this);
		
        textArea = new JTextArea(5, 20);
        resultArea = new JTextArea(5, 20);
        textArea.setEditable(true);
        resultArea.setEditable(false);
        lines = new JTextArea("1");
		lines.setBackground(Color.LIGHT_GRAY);
		lines.setEditable(false);
        JScrollPane scrollPane1 = new JScrollPane(textArea);
        JScrollPane scrollPane2 = new JScrollPane(resultArea);
        
        textArea.getDocument().addDocumentListener(new DocumentListener(){
			public String getText(){
				int caretPosition = textArea.getDocument().getLength();
				Element root = textArea.getDocument().getDefaultRootElement();
				String text = "1" + System.getProperty("line.separator");
				for(int i = 2; i < root.getElementIndex( caretPosition ) + 2; i++){
					text += i + System.getProperty("line.separator");
				}
				return text;
			}
			@Override
			public void changedUpdate(DocumentEvent de) {
				lines.setText(getText());
			}
 
			@Override
			public void insertUpdate(DocumentEvent de) {
				lines.setText(getText());
			}
 
			@Override
			public void removeUpdate(DocumentEvent de) {
				lines.setText(getText());
			}
 
		});
        scrollPane1.setRowHeaderView(lines);
 
        GridBagConstraints cst = new GridBagConstraints();
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 0;
        cst.weightx = 1.0;
        cst.weighty = 0.0;
        add(label1, cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 1;
        cst.gridy = 0;
        cst.weightx = 1.0;
        cst.weighty = 0.0;
        add(label2, cst);
        
        cst.fill = GridBagConstraints.BOTH;
        cst.gridx = 0;
        cst.gridy = 1;
        cst.weightx = 1.0;
        cst.weighty = 1.0;
        add(scrollPane1, cst);

        cst.fill = GridBagConstraints.BOTH;
        cst.gridx = 1;
        cst.gridy = 1;
        cst.weightx = 1.0;
        cst.weighty = 1.0;
        add(scrollPane2, cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 2;
        cst.weightx = 1.0;
        cst.weighty = 0.0;
        add(submitButton, cst);
	}
	
	public static void createAndShowGUI(PGMXMLValidator mainClass) {
        //Create and set up the window.
        JFrame frame = new JFrame("PGM XML Validator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState( frame.getExtendedState()|JFrame.MAXIMIZED_BOTH );
 
        //Add contents to the window.
        frame.add(new MainView(mainClass));
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
	
	@Override
	public void actionPerformed(ActionEvent paramActionEvent) {
		resultArea.setText("Processing...\n");
		for (String str : PGMXMLValidator.validateXML(textArea.getText())) {
			resultArea.append(str);
			resultArea.append("\n");
		}
	}
}