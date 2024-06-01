import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

public class Flashcards {
    private static final Map<String, String> KATAKANA_MAP = new HashMap<String, String>() {{
        put("ア", "a");
        put("イ", "i");
        put("ウ", "u");
        put("エ", "e");
        put("オ", "o");
        put("カ", "ka");
        put("キ", "ki");
        put("ク", "ku");
        put("ケ", "ke");
        put("コ", "ko");
        put("サ", "sa");
        put("シ", "shi");
        put("ス", "su");
        put("セ", "se");
        put("ソ", "so");
        put("ナ", "na");
        put("ニ", "ni");
        put("ヌ", "nu");
        put("ネ", "ne");
        put("ノ", "no");
        put("タ", "ta");
        put("チ", "chi");
        put("ツ", "tsu");
        put("テ", "te");
        put("ト", "to");
        put("ハ", "ha");
        put("ヒ", "hi");
        put("フ", "hu");
        put("ヘ", "he");
        put("ホ", "ho");
        put("マ", "ma");
        put("ミ", "mi");
        put("ム", "mu");
        put("メ", "me");
        put("モ", "mo");
        put("ヤ", "ya");
        put("ユ", "yu");
        put("ヨ", "yo");
        put("ラ", "ra");
        put("リ", "ri");
        put("ル", "ru");
        put("レ", "re");
        put("ロ", "ro");
        // Add the rest of the Katakana characters here...
    }};

    private static final Map<String, String> HIRAGANA_MAP = new HashMap<String, String>() {{
        put("あ", "a");
        put("い", "i");
        put("う", "u");
        put("え", "e");
        put("お", "o");
        put("か", "ka");
        put("き", "ki");
        put("く", "ku");
        put("け", "ke");
        put("こ", "ko");
        put("さ", "sa");
        put("し", "shi");
        put("す", "su");
        put("せ", "se");
        put("そ", "so");
        put("た", "ta");
        put("ち", "chi");
        put("つ", "tsu");
        put("て", "te");
        put("と", "to");
        put("な", "na");
        put("に", "ni");
        put("ぬ", "nu");
        put("ね", "ne");
        put("の", "no");
        put("は", "ha");
        put("ひ", "hi");
        put("ふ", "hu");
        put("へ", "he");
        put("ほ", "ho");
        put("ま", "ma");
        put("み", "mi");
        put("む", "mu");
        put("め", "me");
        put("も", "mo");
        put("や", "ya");
        put("ゆ", "yu");
        put("よ", "yo");
        put("ら", "ra");
        put("り", "ri");
        put("る", "ru");
        put("れ", "re");
        put("ろ", "ro");
        // Add the rest of the Hiragana characters here...
    }};


    public static void main(String[] args) {
        String[] katakanaKeys = KATAKANA_MAP.keySet().toArray(new String[0]);
        String[] hiraganaKeys = HIRAGANA_MAP.keySet().toArray(new String[0]);
        String randomKey;
        String randomMap;
        boolean willRun;
        int correct = 0;
        int incorrect = 0;

        do{
            willRun = true;
            if (ThreadLocalRandom.current().nextBoolean()) {
                randomKey = katakanaKeys[ThreadLocalRandom.current().nextInt(katakanaKeys.length)];
                randomMap = "Katakana";
            } else {
                randomKey = hiraganaKeys[ThreadLocalRandom.current().nextInt(hiraganaKeys.length)];
                randomMap = "Hiragana";
            }
    
            String userInput = JOptionPane.showInputDialog("What is the English representation of this " + randomMap + " character: " + randomKey
                + "\nCorrect: " + correct + ", Incorrect: " + incorrect + "\n\nType 'x' to quit the program.");

            if (userInput.equals("x") || userInput.equals("X")) {
                willRun = false;
                break;
            }
            else if (randomMap.equals("Katakana")) {
                if (KATAKANA_MAP.get(randomKey).equals(userInput)) {
                    JOptionPane.showMessageDialog(null, "Correct!");
                    correct++;
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect, the correct answer is: " + KATAKANA_MAP.get(randomKey));
                    incorrect++;
                }
            } 
            else {
                if (HIRAGANA_MAP.get(randomKey).equals(userInput)) {
                    JOptionPane.showMessageDialog(null, "Correct!");
                    correct++;
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect, the correct answer is: " + HIRAGANA_MAP.get(randomKey));
                    incorrect++;
                }
            }
        }while(willRun);
        
        JOptionPane.showMessageDialog(null, "Good job! You got " + correct + " correct and " + incorrect + " incorrect.");
    }
}
