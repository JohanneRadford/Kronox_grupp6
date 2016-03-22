package se.mah.k3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class TestFonts extends JFrame {

	private JPanel contentPane;
	private JTextField txtTestarMed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFonts frame = new TestFonts();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestFonts() {
		FontMethods.setStyle();  //Kalla på denna här så byts fonterna till de ni vill ha kolla i FontMethods filen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTestarMed = new JTextField();
		txtTestarMed.setText("Testar med \u00C5\u00C4\u00D6\u00E5\u00E4\u00F6");
		txtTestarMed.setBounds(12, 13, 246, 55);
		contentPane.add(txtTestarMed);
		txtTestarMed.setColumns(10);
		//If I want a special font and size on a label or a button
		InputStream is = null;
		Font font = null;
		is = TestFonts.class.getResourceAsStream("/fonts/MountainsofChristmas-Bold.ttf");
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JButton btnNewButton = new JButton("Knapptext");
		btnNewButton.setFont(font.deriveFont(Font.TRUETYPE_FONT, 25)); //Set the font
		btnNewButton.setBounds(190, 41, 176, 74);
		contentPane.add(btnNewButton);
		
		JTextArea txtrLiteMerText = new JTextArea();
		txtrLiteMerText.setLineWrap(true);
		txtrLiteMerText.setText(" and as you now know there is a difference between knowThis is a textarea with some important text ing the path and walking the path.");
		txtrLiteMerText.setRows(5);
		txtrLiteMerText.setBounds(12, 118, 354, 122);
		contentPane.add(txtrLiteMerText);
	}
}