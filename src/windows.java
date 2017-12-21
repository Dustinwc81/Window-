import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class windows extends JFrame
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					windows frame = new windows();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public windows()
	{
		setIconImage(new ImageIcon(getClass().getResource("/window.png")).getImage()); // set desktop icon
		setResizable(false);
		setFont(new Font("Dialog", Font.PLAIN, 19));
		setTitle("Radius Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon company = new ImageIcon("IMG/cropped-logo.png");


		JLabel lblRadius = new JLabel("Radius");
		lblRadius.setHorizontalAlignment(SwingConstants.CENTER);
		lblRadius.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRadius.setBounds(12, 124, 175, 59);
		contentPane.add(lblRadius);

		JLabel lblWidth = new JLabel("Width");
		lblWidth.setHorizontalAlignment(SwingConstants.CENTER);
		lblWidth.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWidth.setBounds(12, 196, 175, 59);
		contentPane.add(lblWidth);

		JLabel lblRise = new JLabel("Rise");
		lblRise.setHorizontalAlignment(SwingConstants.CENTER);
		lblRise.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRise.setBounds(0, 344, 187, 59);
		contentPane.add(lblRise);

		JLabel lblLengthOfArc = new JLabel("Length of Arc");
		lblLengthOfArc.setHorizontalAlignment(SwingConstants.CENTER);
		lblLengthOfArc.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLengthOfArc.setBounds(12, 416, 175, 59);
		contentPane.add(lblLengthOfArc);

		JFormattedTextField formattedTextFieldRadius = new JFormattedTextField();
		formattedTextFieldRadius.setToolTipText("Enter the Radius, ex:  71.25");
		formattedTextFieldRadius.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldRadius.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formattedTextFieldRadius.setBounds(186, 124, 202, 59);
		contentPane.add(formattedTextFieldRadius);

		JFormattedTextField formattedTextFieldWidth = new JFormattedTextField();
		formattedTextFieldWidth.setToolTipText("Enter the Width, ex: 35.3");
		formattedTextFieldWidth.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldWidth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formattedTextFieldWidth.setBounds(186, 196, 202, 59);
		contentPane.add(formattedTextFieldWidth);

		JFormattedTextField formattedTextFieldRise = new JFormattedTextField();
		formattedTextFieldRise.setFont(new Font("Tahoma", Font.BOLD, 20));
		formattedTextFieldRise.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldRise.setBounds(186, 344, 202, 59);
		contentPane.add(formattedTextFieldRise);

		JFormattedTextField formattedTextFieldLoA = new JFormattedTextField();
		formattedTextFieldLoA.setFont(new Font("Tahoma", Font.BOLD, 20));
		formattedTextFieldLoA.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldLoA.setBounds(186, 416, 202, 59);
		contentPane.add(formattedTextFieldLoA);

		JButton btnNewButton = new JButton("Calculate:  Rise and Length of Arc");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setToolTipText("After you enter Radius and Width, CLICK to Calculate Rise and Lenght of Arc");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double radius;
				double width;
				double degreeBend; 
				double arcLength; 
				double rise; 
				double roundArcLength;


				radius = Double.parseDouble(formattedTextFieldRadius.getText());
				width = Double.parseDouble(formattedTextFieldWidth.getText());
				degreeBend = (Math.asin((width/radius)/2)) * 2 * 57.2958;
				//				System.out.println(degreeBend);
				arcLength = (degreeBend * radius * .017453);
				rise = (Math.round((Math.tan((degreeBend / 57.2958) / 4) * width) / 2) * 10_000d) / 10_000d ;

				roundArcLength = Math.round(arcLength * 10000d) / 10000d;


				formattedTextFieldRise.setText(Double.toString(rise));
				formattedTextFieldLoA.setText(Double.toString(roundArcLength));

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(35, 264, 353, 67);
		contentPane.add(btnNewButton);

		JLabel lblNewLabelImage = new JLabel("");
		lblNewLabelImage.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/cropped-logo.png")).getImage();
		lblNewLabelImage.setIcon(new ImageIcon(img));
		lblNewLabelImage.setBounds(400, 23, 256, 100);
		contentPane.add(lblNewLabelImage);

		JLabel lblHeight = new JLabel("Height");
		lblHeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeight.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHeight.setBounds(655, 196, 175, 59);
		contentPane.add(lblHeight);

		JLabel lblJambHeight = new JLabel("Jamb Height");
		lblJambHeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblJambHeight.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblJambHeight.setBounds(655, 268, 175, 59);
		contentPane.add(lblJambHeight);

		JLabel lblWidth_1 = new JLabel("Width");
		lblWidth_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblWidth_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWidth_1.setBounds(655, 124, 175, 59);
		contentPane.add(lblWidth_1);

		JLabel lblRise_1 = new JLabel("Rise");
		lblRise_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRise_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRise_1.setBounds(655, 340, 175, 59);
		contentPane.add(lblRise_1);

		JFormattedTextField formattedTextFieldHeight2 = new JFormattedTextField();
		formattedTextFieldHeight2.setForeground(Color.LIGHT_GRAY);
		formattedTextFieldHeight2.setToolTipText("Not Required");
		formattedTextFieldHeight2.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldHeight2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formattedTextFieldHeight2.setBounds(830, 196, 202, 59);
		contentPane.add(formattedTextFieldHeight2);

		JFormattedTextField formattedTextFieldJambHeight2 = new JFormattedTextField();
		formattedTextFieldJambHeight2.setForeground(Color.LIGHT_GRAY);
		formattedTextFieldJambHeight2.setToolTipText("Not Required");
		formattedTextFieldJambHeight2.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldJambHeight2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formattedTextFieldJambHeight2.setBounds(830, 268, 202, 59);
		contentPane.add(formattedTextFieldJambHeight2);

		JFormattedTextField formattedTextFieldRise2 = new JFormattedTextField();
		formattedTextFieldRise2.setToolTipText("Enter the Rise, ex:  71.25");
		formattedTextFieldRise2.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldRise2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formattedTextFieldRise2.setBounds(830, 344, 202, 59);
		contentPane.add(formattedTextFieldRise2);

		JFormattedTextField formattedTextFieldRadius2 = new JFormattedTextField();
		formattedTextFieldRadius2.setToolTipText("");
		formattedTextFieldRadius2.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldRadius2.setFont(new Font("Tahoma", Font.BOLD, 20));
		formattedTextFieldRadius2.setBounds(830, 492, 202, 59);
		contentPane.add(formattedTextFieldRadius2);

		JFormattedTextField formattedTextFieldLengthOfArc2 = new JFormattedTextField();
		formattedTextFieldLengthOfArc2.setToolTipText("");
		formattedTextFieldLengthOfArc2.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldLengthOfArc2.setFont(new Font("Tahoma", Font.BOLD, 20));
		formattedTextFieldLengthOfArc2.setBounds(834, 564, 202, 59);
		contentPane.add(formattedTextFieldLengthOfArc2);

		JFormattedTextField formattedTextFieldWidth2 = new JFormattedTextField();
		formattedTextFieldWidth2.setToolTipText("Enter the Width, ex:  71.25");
		formattedTextFieldWidth2.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldWidth2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formattedTextFieldWidth2.setBounds(830, 124, 202, 59);
		contentPane.add(formattedTextFieldWidth2);

		JButton btnRadiusAndLength = new JButton("Calculate: Radius and Length of Arc");
		btnRadiusAndLength.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				double rise;
				double width;
				double radius;
				double degreeOfBend;
				double arcLength;
				double roundArcLength;

				rise = Double.parseDouble(formattedTextFieldRise2.getText());
				width = Double.parseDouble(formattedTextFieldWidth2.getText());

				radius = ((width * width) + (4 * (rise * rise))) / (8 * rise);
				degreeOfBend = (Math.asin((width/radius)/2)) * 2 * 57.2958;
				arcLength = (degreeOfBend * radius * .017453);
				roundArcLength = Math.round(arcLength * 10000d) / 10000d;



				formattedTextFieldRadius2.setText(Double.toString(radius));
				formattedTextFieldLengthOfArc2.setText(Double.toString(roundArcLength));


			}
		});
		btnRadiusAndLength.setToolTipText("After you enter Rise and Width, CLICK to Calculate Radius and Length of Arc");
		btnRadiusAndLength.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRadiusAndLength.setBackground(Color.LIGHT_GRAY);
		btnRadiusAndLength.setBounds(679, 412, 353, 67);
		contentPane.add(btnRadiusAndLength);

		JLabel Radius2 = new JLabel("Radius");
		Radius2.setHorizontalAlignment(SwingConstants.CENTER);
		Radius2.setFont(new Font("Tahoma", Font.BOLD, 20));
		Radius2.setBounds(655, 492, 175, 59);
		contentPane.add(Radius2);

		JLabel lblLengthOfArc_1 = new JLabel("Length of Arc");
		lblLengthOfArc_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLengthOfArc_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLengthOfArc_1.setBounds(655, 564, 175, 59);
		contentPane.add(lblLengthOfArc_1);

		JLabel labelDoorImage = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/doorjam.png")).getImage();
		labelDoorImage.setIcon(new ImageIcon(img2));
		labelDoorImage.setBounds(400, 115, 267, 436);
		contentPane.add(labelDoorImage);
		
		JLabel lblRiseLength = new JLabel("Rise & Length of Arc");
		lblRiseLength.setForeground(Color.RED);
		lblRiseLength.setBackground(Color.BLACK);
		lblRiseLength.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRiseLength.setHorizontalAlignment(SwingConstants.CENTER);
		lblRiseLength.setBounds(35, 52, 353, 59);
		contentPane.add(lblRiseLength);
		
		JLabel lblRadiusLength = new JLabel("Radius & Length of Arc");
		lblRadiusLength.setHorizontalAlignment(SwingConstants.CENTER);
		lblRadiusLength.setForeground(Color.RED);
		lblRadiusLength.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRadiusLength.setBackground(Color.BLACK);
		lblRadiusLength.setBounds(679, 52, 353, 59);
		contentPane.add(lblRadiusLength);
		
		JButton clear = new JButton("Clear All Fields");
		clear.setToolTipText("This button will clear and reset all fields");
		clear.setBackground(Color.LIGHT_GRAY);
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				formattedTextFieldWidth.setText(" ");
				formattedTextFieldRadius.setText(" ");
				formattedTextFieldRise.setText(" ");
				formattedTextFieldLoA.setText(" ");
				formattedTextFieldRise2.setText(" ");
				formattedTextFieldWidth2.setText(" ");
				formattedTextFieldHeight2.setText(" ");
				formattedTextFieldJambHeight2.setText(" ");
				formattedTextFieldRadius2.setText(" ");
				formattedTextFieldLengthOfArc2.setText(" ");
				
			}
		});
		clear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		clear.setBounds(400, 576, 266, 59);
		contentPane.add(clear);
		
	}
}
