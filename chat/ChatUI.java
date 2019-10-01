package chat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Writer;

import javax.swing.*;

public class ChatUI {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTextArea chatText;
	private JTextField entryText;

	public ChatUI(String title, Writer output) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				frame = new JFrame(title);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				chatText = new JTextArea();
				chatText.setEditable(false);
				scrollPane = new JScrollPane(chatText);
				entryText = new JTextField();
                JButton aboutButton = new JButton("About");

				entryText.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent ae) {
						String line = entryText.getText();
						try {
							output.write(line + "\n");
							output.flush();
							chatText.append("ME:  " + line + "\n");
							chatText.setFont(new Font("Dialog", Font.BOLD,12));
							entryText.setText("");
						} catch (IOException e) {
							e.printStackTrace();
							chatText.append("Other party hung up :(");
						}
					}

				});

                frame.add(entryText, BorderLayout.NORTH);
                frame.add(scrollPane, BorderLayout.CENTER);
				frame.add(aboutButton, BorderLayout.SOUTH);

				frame.setBounds(20, 20, 600, 400);
				frame.setVisible(true);
			}
		});

	}

	public void appendText(String message) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				chatText.setFont(new Font("Dialog", Font.BOLD, 12));
				chatText.append("THEY  :  " + message +"\n");
			}

	});
	}
}
