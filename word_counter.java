import javax.swing.*;
import java.awt.event.*;

public class word_counter extends JFrame implements ActionListener {

    private JTextArea textArea;
    private JButton countButton;
    private JLabel countLabel;

    public word_counter() {
        super("Word Counter");

        // Create text area and count button
        textArea = new JTextArea(10, 30);
        countButton = new JButton("Count");

        // Create count label with initial value of zero
        countLabel = new JLabel("Word count: 0 | Vowel count: 0 | Consonant count: 0");
        // Add components to frame
        JPanel panel = new JPanel();
        panel.add(new JScrollPane(textArea));
        panel.add(countButton);
        panel.add(countLabel);
        add(panel);

        // Register action listener for count button
        countButton.addActionListener(this);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Get text from text area
        String text = textArea.getText();

        // Split text into words
        String[] words = text.split("\\s+");

        // Count number of words, vowels, and consonants
        int wordCount = words.length;
        int vowelCount = 0;
        int consonantCount = 0;

        for (String word : words) {
            // Convert word to lowercase for easier comparison
            String lowercaseWord = word.toLowerCase();

            // Count vowels and consonants in each word
            for (int i = 0; i < lowercaseWord.length(); i++) {
                char c = lowercaseWord.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                        vowelCount++;
                    } else {
                        consonantCount++;
                    }
                }
            }
        }

        // Update count label
        countLabel.setText("Word count: " + wordCount + " | Vowel count: " + vowelCount + " | Consonant count: " + consonantCount);
    }

    public static void main(String[] args) {
        new word_counter();
    }
}