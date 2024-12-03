/**
 * This class represents a note pattern
 *
 * @author Tyler Hua
 */
public class Note {
    /**
     * The current stream
     */
    private String stream;

    /**
     * The keybindings
     */
    private String d1, d2, k1, k2;

    /**
     * The length of the stream
     */
    private int length;

    /**
     * The number of lives
     */
    private int lives;


    /**
     * Instantiates a Note object with default values.
     */
    public Note() {
        stream = "";
        d1 = ",";
        d2 = ".";
        k1 = "[";
        k2 = "]";
        length = 5;
        setLives("hard");
    }

    /**
     * Instantiates a Note object with an inputted length and mode.
     *
     * @param len Length of the stream
     * @param mode Mode of the simulation
     */
    public Note(int len, String mode) {
        stream = "";
        d1 = ",";
        d2 = ".";
        k1 = "[";
        k2 = "]";
        length = len;
        setLives(mode);
    }

    /**
     * Sets new keybindings.
     *
     * @param d1 New d1
     * @param d2 New d2
     * @param k1 New k1
     * @param k2 New k2
     */
    public void setKeys(String d1, String d2, String k1, String k2) {
        this.d1 = d1;
        this.d2 = d2;
        this.k1 = k1;
        this.k2 = k2;
        System.out.println("New keys (ddkk): " + d1 + " " + d2 + " " + k1 + " " + k2);
    }

    /**
     * Sets the length to a new value.
     *
     * @param newLength The new length
     */
    public void setLength(int newLength) {
        length = newLength;
    }

    /**
     * Sets the lives based on the mode.
     *
     * @param mode The mode of the simulation
     */
    public void setLives(String mode) {
        if (mode.equals("easy")) {
            lives = 3;
        } else if (mode.equals("hard")) {
            lives = 1;
        }
    }

    /**
     * Sets the lives to a new value.
     *
     * @param lives The new amount of lives
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * Creates a new pattern in stream
     */
    public void newStream() {
        stream = "";
        for (int i = 0; i < length; i++) {
            stream += (int) (Math.random() * 2);
        }
    }

    /**
     * Returns the stream converted into red and blue circles.
     *
     * @return The stream converted into red and blue circles
     */
    public String display() {
        String display = stream;
        display = display.replace("0", "\uD83D\uDD34");
        display = display.replace("1", "\uD83D\uDD35");
        return display;
    }

    /**
     *  Checks if the converted userStream is equal to stream and if there are any lives remaining.
     *
     * @param userStream The stream inputted during the simulation
     * @return True if userStream is equal to stream or lives is greater than one, false otherwise
     */
    public boolean check(String userStream) {
        userStream = userStream.replace(d1, "0");
        userStream = userStream.replace(d2, "0");
        userStream = userStream.replace(k1, "1");
        userStream = userStream.replace(k2, "1");
        boolean correct = userStream.equals(stream);
        if (!correct && lives > 1) {
            lives--;
            System.out.println("-1 life, Lives remaining: " + lives);
            return true;
        } else {
            return correct;
        }
    }
}
