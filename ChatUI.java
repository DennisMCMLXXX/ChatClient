import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Writer;

public class ChatUI {

	About about = new About();

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTextArea chatText;
	private JTextField entryText;
	private JButton aboutButton;

	public ChatUI(String title, Writer output) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				frameSettings(title);

				entryText.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent ae) {
						printLineMethod(output);
					}

				});

				aboutButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						About.aboutButtonPressed();
					}
				});

			}

		});

	}

	public void appendText(String message) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				chatText.setFont(new Font("Dialog", Font.BOLD, 12));
				chatText.append("THEY  :  " + message + "\n");
			}

		});
	}

	private void printLineMethod(Writer output) {
		String line = entryText.getText();
		try {
			output.write(line + "\n");
			output.flush();
			chatText.append("ME:  " + line + "\n");
			chatText.setFont(new Font("Dialog", Font.BOLD, 12));
			entryText.setText("");
		} catch (IOException e) {
			e.printStackTrace();
			chatText.append("Other party hung up :(");
		}
	}

	private void frameSettings(String title) {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		chatText = new JTextArea();
		chatText.setEditable(false);
		scrollPane = new JScrollPane(chatText);
		entryText = new JTextField();
		aboutButton = new JButton("About");

		frame.add(entryText, BorderLayout.NORTH);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.add(aboutButton, BorderLayout.SOUTH);

		frame.setBounds(20, 20, 600, 400);
		frame.setVisible(true);
	}
}
