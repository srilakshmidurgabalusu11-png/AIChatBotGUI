import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AIChatBotGUI extends JFrame implements ActionListener {

    JTextArea chatArea;
    JTextField inputField;
    JButton sendButton;

    public AIChatBotGUI() {

        setTitle("AI ChatBot");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();
        sendButton = new JButton("Send");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        sendButton.addActionListener(this);
        inputField.addActionListener(this);

        setVisible(true);

        chatArea.append("Bot: Hello! I am your AI ChatBot.\n");
    }

    public void actionPerformed(ActionEvent e) {

        String userInput = inputField.getText().trim();

        if(userInput.isEmpty()) {
            return;
        }

        chatArea.append("You: " + userInput + "\n");

        String response = getResponse(userInput);

        chatArea.append("Bot: " + response + "\n\n");

        inputField.setText("");
    }

    private String getResponse(String input) {

        input = input.toLowerCase();

        if(input.contains("hello") || input.contains("hi")) {
            return "Hello! How can I help you?";
        }

        else if(input.contains("how are you")) {
            return "I'm doing great!";
        }

        else if(input.contains("your name")) {
            return "I am a Java Swing AI ChatBot.";
        }

        else if(input.contains("java")) {
            return "Java is an Object-Oriented Programming language.";
        }

        else if(input.contains("oop")) {
            return "OOP stands for Object-Oriented Programming.";
        }

        else if(input.contains("project")) {
            return "Projects improve your coding skills.";
        }

        else if(input.contains("internship")) {
            return "Internships provide real-world experience.";
        }

        else if(input.contains("bye")) {
            return "Goodbye! Have a nice day.";
        }

        else {
            return "Sorry, I don't understand that.";
        }
    }

    public static void main(String[] args) {
        new AIChatBotGUI();
    }
}