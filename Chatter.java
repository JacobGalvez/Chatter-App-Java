/*
Name: Jacob Galvez
Date: 10/27/2021
Class: CS 3354.003
Professor Rick King

This is the GUI portion of the group chat simulator.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font.*;
import java.awt.Color.*;

public class Chatter { // Chatter GUI class
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel userPrompt = new JLabel("Message");
    JLabel username;
    JButton sendButton = new JButton("Send");
    JTextField userMessage = new JTextField(30);
    public JTextArea chatbox = new JTextArea(19, 40);
    public JScrollPane scrollbar;

    public Chatter(Client c) { //constructor for GUI

        // format the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Chatty - " + c.name);
        frame.setLayout(new BorderLayout());

        // format label that says "Message"
        userPrompt.setForeground(Color.WHITE);
        userPrompt.setFont(new Font("Comic Sans MS", Font.BOLD, 13));

        // userMessage formatting
        userMessage.setText(" ");
        userMessage.setBackground(Color.DARK_GRAY);
        userMessage.setForeground(Color.WHITE);
        userMessage.setCaretColor(Color.WHITE);

        // sendButton Formatting
        sendButton.setBackground(Color.BLUE);
        sendButton.setForeground(Color.WHITE);
        sendButton.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        sendButton.setPreferredSize(new Dimension(65, 25));

        //chatbox formatting
        scrollbar = new JScrollPane(chatbox);
        chatbox.setBackground(Color.DARK_GRAY);
        chatbox.setForeground(Color.WHITE);
        chatbox.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        chatbox.setEditable(false);

        //username formatting
        username = new JLabel(c.name);
        username.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        username.setForeground(Color.WHITE);

        // panel3 TOP/NORTH PANEL
        panel3.add(username);
        panel3.setBackground(Color.BLACK);

        // panel1 CENTER PANEL
        panel1.add(scrollbar);
        panel1.setBackground(Color.BLACK);

        // panel2 BOTTOM/SOUTH PANEL
        panel2.add(userPrompt);
        panel2.add(userMessage);
        panel2.add(sendButton);
        panel2.setBackground(Color.BLACK);

        //frame formatting... add panels
        frame.add(panel1, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.add(panel3, BorderLayout.NORTH);

        //when user presses "Enter" key, the chat in the TextField is sent to the group.
        frame.getRootPane().setDefaultButton(sendButton); // allows the user to press Enter instead of
                                                                    // clicking on button everytime

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.send(userMessage.getText());
                userMessage.setText(" ");

                Server.getHostServer().update();
            }
        });

        frame.setSize(490, 490);
        frame.setVisible(true);

    }

    //helps send chat to client to server
    public void writeChat(String w)
    {
        chatbox.append(w);
        chatbox.setCaretPosition(chatbox.getDocument().getLength());
    }
}