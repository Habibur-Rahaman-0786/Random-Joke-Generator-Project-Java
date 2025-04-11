import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;

public class MainFrame extends JFrame {

    public void initialize() {
        // Title Label
        JLabel lbTitle = new JLabel("Random Joke Generator", SwingConstants.CENTER);
        lbTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lbTitle.setForeground(Color.WHITE);

        // Text Field to display jokes
        JTextField jokeField = new JTextField();
        jokeField.setFont(new Font("Arial", Font.PLAIN, 16));
        jokeField.setEditable(false);
        jokeField.setHorizontalAlignment(JTextField.CENTER);

        // Button to generate jokes
        JButton jokeButton = new JButton("Generate Joke");
        jokeButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Panel for the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(jokeButton);
        buttonPanel.setBackground(new Color(128, 128, 255));

        // Main Panel setup
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));
        mainPanel.add(lbTitle, BorderLayout.NORTH);
        mainPanel.add(jokeField, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // List of jokes
        String[] jokes = {
            "Why don’t scientists trust atoms? Because they make up everything!",
            "Why did the math book look sad? Because it had too many problems.",
            "Why don’t skeletons fight each other? They don’t have the guts.",
            "What do you call fake spaghetti? An impasta!",
            "Why couldn’t the bicycle stand up by itself? It was two tired.",
            "What did the ocean say to the beach? Nothing, it just waved."
        };

        // Button Action Listener
        jokeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int randomIndex = random.nextInt(jokes.length);
                jokeField.setText(jokes[randomIndex]);
            }
        });

        // Frame setup
        setTitle("Random Joke Generator");
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.initialize();
        });
    }
}
