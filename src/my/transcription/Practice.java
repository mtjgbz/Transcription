/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.swing.Timer;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.Highlighter;

/**
 *
 * @author Mike, Erica, Noah and Casey
 */
public class Practice extends javax.swing.JFrame {
    private static String path;
    int start1;
    int end1;
    int start2;
    int end2;
    int start3;
    int end3;
    int start4;
    int end4;
    int wordCount;
    int numTags;
    int clicks;
    int attempt;
    boolean correct1 = false, correct2 = false, correct3 = false, correct4 = false;
    
    String user;
    Integer lesson;
    String subLesson;
    ArrayList<File> audio = new ArrayList<>();
    
    String blank1;
    String blank2;
    String blank3;
    String blank4;

    Clip clip;
    Timer timer;

    Enclitics enc = new Enclitics();
    Nasalizations nas;
    ToneTable tone;
    NamaTable na;
    private boolean NaMaOpen = false;

    private ActiveBE backend;

    int page = 1;

    private ArrayList<String> textList = new ArrayList<>();
    //Integer timesVar = 9029000;
    private ArrayList<ArrayList<String>> phraseList;
    private ArrayList<String> words = new ArrayList<>();
    ArrayList<ArrayList<String>> wordsList = new ArrayList<>();
    ArrayList<Integer> timesList = new ArrayList<>();
    ArrayList<Timer> timersList = new ArrayList<>();
    ArrayList<Clip> clips = new ArrayList<>();
    ArrayList<Integer> startTags = new ArrayList<>();
    ArrayList<Integer> endTags = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> answers = new ArrayList<>();
    ArrayList<Boolean> btnStatus = new ArrayList<>();
    ArrayList<Integer> attempts = new ArrayList<>();
    ArrayList<ArrayList<Integer>> saveStart = new ArrayList<>(); 
    ArrayList<ArrayList<Integer>> saveEnd = new ArrayList<>();
    ArrayList<ArrayList<Boolean>> correct = new ArrayList<>();

    private Highlighter.HighlightPainter redPainter;
    private Highlighter.HighlightPainter greenPainter;
    private Highlighter.HighlightPainter cyanPainter;

    ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent event) {

            clip.stop();
            clip.setMicrosecondPosition(timesList.get(page-1));
            playButton1.setForeground(new java.awt.Color(0, 153, 51));
            playButton1.setText("Play");
        }
    };

    /**
     * Creates new form Practice
     *
     * @param user
     */
    public Practice(String user, Integer lesson, String subLesson) {
        this.setTitle("Mixtec Transcription: Práctica");
        initComponents();
        playButton1.setForeground(new java.awt.Color(0, 153, 51));
        this.user = user;
        this.lesson = lesson;
        this.subLesson = subLesson;
        jUserMenu.setText(user);
        jTextPane1.setText("text1");
        prevButton.setText("Previous");
        prevButton.setEnabled(false);
        timer = new Timer(4428, listener);

        backend = new ActiveBE(false);
        backend.newPractice(user, lesson, subLesson);
        initTextFields();
        initAudio();
        
        jScrollPane1.setViewportView(jTextPane1);
        setupDoc();
        numTags = 0;
        jTextPane1.setLineWrap(true);
        setupTones();
        nas = new Nasalizations(path);
        tone = new ToneTable(path);
        attempt = 3;
        attemptCountLabel.setText("You have " + attempt + " attempts left.");

        for(int i = 0; i < 20; i++) {
            btnStatus.add(true);
            answers.add(new ArrayList<ArrayList<String>>());
            attempts.add(3);
            saveStart.add(new ArrayList<Integer>());
            saveEnd.add(new ArrayList<Integer>());
            correct.add(new ArrayList<Boolean>());
            for(int j = 0; j < 4; j++) {
                correct.get(i).add(false);
                saveStart.get(i).add(j);
                saveEnd.get(i).add(j);
                
                answers.get(i).add(new ArrayList<String>());
                for(int k = 0; k < 3; k++) {
                    answers.get(i).get(j).add(" ");
                }
            }
        }
    }
    
    private void setupTones() {
        try {
            Statement stmt = User.setupDB(this, getClass().getResource("TAA.db").toString());
            
            String newQuery1 = "SELECT FileList FROM LESSONS WHERE Lesson = 0;";
            ResultSet rsExp = stmt.executeQuery(newQuery1);
            path = (rsExp.getString("FileList"));
            stmt.execute(newQuery1);

            User.closeDB(stmt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initAudio() {
        clip = backend.makeClip(page);
        timer = timersList.get(page-1);
    }

    private void setupDoc() {
        AbstractDocument doc = (AbstractDocument) jTextPane1.getDocument();

        doc.setDocumentFilter(new DocumentFilter() {
            public void replace(DocumentFilter.FilterBypass fb, int offs, int length,
                    String str, AttributeSet a) throws BadLocationException {

                String text = fb.getDocument().getText(0,
                        fb.getDocument().getLength());
                text += str;
                if (offs >= start1 && offs <= end1) {
                    end1 += str.length();
                    end1 -= length;
                    end2 += str.length();
                    end2 -= length;
                    start2 += str.length();
                    start2 -= length;
                    end3 += str.length();
                    end3 -= length;
                    start3 += str.length();
                    start3 -= length;
                    end4 += str.length();
                    end4 -= length;
                    start4 += str.length();
                    start4 -= length;

                    super.replace(fb, offs, length, str, a);
                } else if (offs >= start2 && offs <= end2) {
                    end2 += str.length();
                    end2 -= length;
                    end3 += str.length();
                    end3 -= length;
                    start3 += str.length();
                    start3 -= length;
                    end4 += str.length();
                    end4 -= length;
                    start4 += str.length();
                    start4 -= length;

                    super.replace(fb, offs, length, str, a);
                } else if (offs >= start3 && offs <= end3) {
                    end3 += str.length();
                    end3 -= length;
                    end4 += str.length();
                    end4 -= length;
                    start4 += str.length();
                    start4 -= length;

                    super.replace(fb, offs, length, str, a);
                } else if (offs >= start4 && offs <= end4) {
                    end4 += str.length();
                    end4 -= length;

                    super.replace(fb, offs, length, str, a);
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
            }

            public void remove(DocumentFilter.FilterBypass fb, int offs, int length) throws BadLocationException {
                if ((offs >= start1 && offs < end1)) {
                    end1--;
                    start2--;
                    end2--;
                    start3--;
                    end3--;
                    start4--;
                    end4--;

                    super.remove(fb, offs, length);
                } else if (offs >= start2 && offs < end2) {
                    end2--;
                    end3--;
                    start3--;
                    start4--;
                    end4--;

                    super.remove(fb, offs, length);
                } else if (offs >= start3 && offs < end3) {
                    end3--;
                    start4--;
                    end4--;

                    super.remove(fb, offs, length);
                } else if (offs >= start4 && offs < end4) {
                    end4--;

                    super.remove(fb, offs, length);
                }
            }

            public void insertString(DocumentFilter.FilterBypass fb, int offs, String str,
                    AttributeSet a) throws BadLocationException {

                String text = fb.getDocument().getText(0,
                        fb.getDocument().getLength());
                text += str;
                if (offs >= start1 && offs <= end1) {
                    end1 += str.length();
                    start2 += str.length();
                    end2 += str.length();
                    start3 += str.length();
                    end3 += str.length();
                    start4 += str.length();
                    end4 += str.length();

                    super.insertString(fb, offs, str, a);
                } else if (offs >= start2 && offs <= end2) {
                    end2 += str.length();
                    start3 += str.length();
                    end3 += str.length();
                    start4 += str.length();
                    end4 += str.length();

                    super.insertString(fb, offs, str, a);
                } else if (offs >= start3 && offs <= end3) {
                    end3 += str.length();
                    start4 += str.length();
                    end4 += str.length();

                    super.insertString(fb, offs, str, a);
                } else if (offs >= start4 && offs <= end4) {
                    end4 += str.length();

                    super.insertString(fb, offs, str, a);
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
    }

    public void highlightAll(String input) throws BadLocationException {
        Highlighter highlighter = null;
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN);

        highlighter = jTextPane1.getHighlighter();
        jTextPane1.setHighlighter(highlighter);
        
        for (int j = 0; j < numTags; j++) {
            int start = startTags.get(j);
            int end = endTags.get(j);
            try {
                highlighter.addHighlight(start, end + 1, painter);

            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }

    }
    
    private void getAnswers() throws BadLocationException {
        Document doc = jTextPane1.getDocument();

        blank1 = doc.getText(start1, end1 - start1);
        blank2 = doc.getText(start2, end2 - start2);
        blank3 = doc.getText(start3, end3 - start3);
        blank4 = doc.getText(start4, end4 - start4);

        blank1 = blank1.replaceAll(" ", "");
        blank2 = blank2.replaceAll(" ", "");
        blank3 = blank3.replaceAll(" ", "");
        blank4 = blank4.replaceAll(" ", "");
    }
    
    private void saveState(int attempt, int start, int end, int wCount, int pg, String word, boolean crct) {
        attempts.set(pg-1, attempt);
        saveStart.get(pg-1).set(wCount-1, start);
        saveEnd.get(pg-1).set(wCount-1, end);
        correct.get(pg-1).set(wCount-1, crct);
        
        backend.newAttempt(attempt, word, crct);
        backend.calculateScore();
    }
   
    private void checkAnswers() throws BadLocationException {
        getAnswers();
        
        if (wordCount == 4) {
            boolean right1 = highlightWord(blank1, words.get(0), start1, end1);
            boolean right2 = highlightWord(blank2, words.get(1), start2, end2);
            boolean right3 = highlightWord(blank3, words.get(2), start3, end3);
            boolean right4 = highlightWord(blank4, words.get(3), start4, end4);
            if(right1) {
                disableDocFilter1();
            }
            if(right2) {
                disableDocFilter2();
            }
            if(right3) {
                disableDocFilter3();
            }
            if(right4) {
                disableDocFilter4();
            }
            answers.get(page-1).get(wordCount-1).add(blank1);
            answers.get(page-1).get(wordCount-1).add(blank2);
            answers.get(page-1).get(wordCount-1).add(blank3);
            answers.get(page-1).get(wordCount-1).add(blank4);
            
            backend.addUserAnswer(blank1, backend.getQuestionNum(words.get(0)));
            backend.addUserAnswer(blank2, backend.getQuestionNum(words.get(1)));
            backend.addUserAnswer(blank3, backend.getQuestionNum(words.get(2)));
            backend.addUserAnswer(blank4, backend.getQuestionNum(words.get(3)));
        }
        else if (wordCount == 3) {
            boolean right1 = highlightWord(blank1, words.get(0), start1, end1);
            boolean right2 = highlightWord(blank2, words.get(1), start2, end2);
            boolean right3 = highlightWord(blank3, words.get(2), start3, end3);
            if(right1) {
                disableDocFilter1();
            }
            if(right2) {
                disableDocFilter2();
            }
            if(right3) {
                disableDocFilter3();
            }
            answers.get(page-1).get(wordCount-1).add(blank1);
            answers.get(page-1).get(wordCount-1).add(blank2);
            answers.get(page-1).get(wordCount-1).add(blank3);
            
            backend.addUserAnswer(blank1, backend.getQuestionNum(words.get(0)));
            backend.addUserAnswer(blank2, backend.getQuestionNum(words.get(1)));
            backend.addUserAnswer(blank3, backend.getQuestionNum(words.get(2)));
        }
        else if (wordCount == 2) {
            boolean right1 = highlightWord(blank1, words.get(0), start1, end1);
            boolean right2 = highlightWord(blank2, words.get(1), start2, end2);
            if(right1) {
                disableDocFilter1();
            }
            if(right2) {
                disableDocFilter2();
            }
            answers.get(page-1).get(wordCount-1).add(blank1);
            answers.get(page-1).get(wordCount-1).add(blank2);
            
            backend.addUserAnswer(blank1, backend.getQuestionNum(words.get(0)));
            backend.addUserAnswer(blank2, backend.getQuestionNum(words.get(1)));
        }
        else if (wordCount == 1) {
            boolean right  = highlightWord(blank1, words.get(0), start1, end1);
            if(right) {
                disableDocFilter1();
            }
            answers.get(page-1).get(wordCount-1).add(blank1);
            
            backend.addUserAnswer(blank1, backend.getQuestionNum(words.get(0)));
            
            saveState(attempt, start1, end1, wordCount, page, words.get(0), correct1);
        }
    }
    
    private void disableDocFilter1() {
        correct1 = true;
        start1 = 0;
        end1 = 0;
    }
    
    private void disableDocFilter2() {
        correct2 = true;
        start2 = 0;
        end2 = 0;
    }
    
    private void disableDocFilter3() {
        correct3 = true;
        start3 = 0;
        end3 = 0;
    }
    
    private void disableDocFilter4() {
        correct4 = true;
        start4 = 0;
        end4 = 0;
    }
    
    private boolean highlightWord(String ans, String word, int start, int end) {
        
        Highlighter highlighter = jTextPane1.getHighlighter();
        jTextPane1.setHighlighter(highlighter);
        
        redPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.PINK);
        greenPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
        
        try {
            if(!(ans.equals(word))) {
                highlighter.addHighlight(start-1, end+1, redPainter);
                //return false;
            }  
            else {
                highlighter.addHighlight(start-1, end+1, greenPainter);
                return true;
            }
        }catch (BadLocationException ex) {
                Logger.getLogger(Practice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    private void findWrongAnswers() {
        if(wordCount == 1 && correct1 == false) {
            displayCorrectAnswers(start1, end1, words.get(0));
        }
        else if(wordCount == 2) {
            if(correct1 == false) {
                displayCorrectAnswers(start1, end1, words.get(0));
            }
            if(correct2 == false) {
                displayCorrectAnswers(start2, end2, words.get(1));
            }
        }
        else if(wordCount == 3) {
            if(correct1 == false) {
                displayCorrectAnswers(start1, end1, words.get(0));
            }
            if(correct2 == false) {
                displayCorrectAnswers(start2, end2, words.get(1));
            }
            if(correct3 == false) {
                displayCorrectAnswers(start3, end3, words.get(2));
            }
        }
        else if(wordCount == 4) {
            if(correct1 == false) {
                displayCorrectAnswers(start1, end1, words.get(0));
            }
            if(correct2 == false) {
                displayCorrectAnswers(start2, end2, words.get(1));
            }
            if(correct3 == false) {
                displayCorrectAnswers(start3, end3, words.get(2));
            }
            if(correct4 == false) {
                displayCorrectAnswers(start4, end4, words.get(3));
            }
        }
    }
    
    private void displayCorrectAnswers(int redStart, int blueStart, String word) {
        Document doc = jTextPane1.getDocument();
        
        cyanPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN);
        redPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.PINK);
        
        Highlighter highlighter = jTextPane1.getHighlighter();
        jTextPane1.setHighlighter(highlighter);
        try {
            doc.insertString(blueStart, " " + word, null);
            highlighter.addHighlight(redStart, blueStart, redPainter);
            highlighter.addHighlight(blueStart, blueStart+word.length()+1, cyanPainter);
        } catch (BadLocationException ex) {
            Logger.getLogger(Practice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    private void findStartEnd(String input) {
        numTags = 0;
        boolean s1 = false;
        boolean e1 = false;
        boolean s2 = false;
        boolean e2 = false;
        boolean s3 = false;
        boolean e3 = false;
        boolean s4 = false;
        boolean e4 = false;

        char[] statement = input.toCharArray();
        char c;
        for (int i = 0; i < statement.length; i++) {
            c = statement[i];
            if (wordCount == 4) {
                if (c == '[' && s1 == false && statement[i+1] == ' ') {
                    start1 = i + 1;
                    s1 = true;
                    numTags++;
                    startTags.add(i);
                    continue;
                }
                if (c == ']' && e1 == false && statement[i-1] == ' ') {
                    end1 = i;
                    e1 = true;
                    endTags.add(i);
                    continue;
                }
                if (c == '[' && s2 == false && statement[i+1] == ' ') {
                    start2 = i + 1;
                    s2 = true;
                    numTags++;
                    startTags.add(i);
                    continue;
                }
                if (c == ']' && e2 == false && statement[i-1] == ' ') {
                    end2 = i;
                    e2 = true;
                    endTags.add(i);
                    continue;
                }
                if (c == '[' && s3 == false && statement[i+1] == ' ') {
                    start3 = i + 1;
                    s3 = true;
                    numTags++;
                    startTags.add(i);
                    continue;
                }
                if (c == ']' && e3 == false && statement[i-1] == ' ') {
                    end3 = i;
                    e3 = true;
                    endTags.add(i);
                    continue;
                }
                if (c == ']' && s4 == false && statement[i+1] == ' ') {
                    start4 = i;
                    s4 = true;
                    numTags++;
                    startTags.add(i);
                    continue;
                }
                if (c == ']' && e4 == false && statement[i-1] == ' ') {
                    end4 = i;
                    e4 = true;
                    endTags.add(i);
                    continue;
                }
            } else if (wordCount == 3) {
                if (c == '[' && s1 == false && statement[i+1] == ' ') {
                    start1 = i + 1;
                    s1 = true;
                    numTags++;
                    startTags.add(i);
                    continue;
                }
                if (c == ']' && e1 == false && statement[i-1] == ' ') {
                    end1 = i;
                    e1 = true;
                    endTags.add(i);
                    continue;
                }
                if (c == '[' && s2 == false && statement[i+1] == ' ') {
                    start2 = i + 1;
                    s2 = true;
                    numTags++;
                    startTags.add(i);
                    continue;
                }
                if (c == ']' && e2 == false && statement[i-1] == ' ') {
                    end2 = i;
                    e2 = true;
                    endTags.add(i);
                    continue;
                }
                if (c == '[' && s3 == false && statement[i+1] == ' ') {
                    start3 = i + 1;
                    s3 = true;
                    numTags++;
                    startTags.add(i);
                    continue;
                }
                if (c == ']' && e3 == false && statement[i-1] == ' ') {
                    end3 = i;
                    e3 = true;
                    endTags.add(i);
                    continue;
                }
                start4 = 0;
                end4 = 0;
            } else if (wordCount == 2) {
                if (c == '[' && s1 == false && statement[i+1] == ' ') {
                    start1 = i + 1;
                    s1 = true;
                    numTags++;
                    startTags.add(i);
                    continue;
                }
                if (c == ']' && e1 == false && statement[i-1] == ' ') {
                    end1 = i;
                    e1 = true;
                    endTags.add(i);
                    continue;
                }
                if (c == '[' && s2 == false && statement[i+1] == ' ') {
                    start2 = i + 1;
                    s2 = true;
                    numTags++;
                    startTags.add(i);
                    continue;
                }
                if (c == ']' && e2 == false && statement[i-1] == ' ') {
                    end2 = i;
                    e2 = true;
                    endTags.add(i);
                    continue;
                }
                start3 = 0;
                start4 = 0;
                end3 = 0;
                end4 = 0;
            } else if (wordCount == 1) {
                if (c == '[' && s1 == false && statement[i+1] == ' ') {
                    start1 = i + 1;
                    s1 = true;
                    numTags++;
                    startTags.add(i);
                    continue;
                }
                if (c == ']' && e1 == false && statement[i-1] == ' ') {
                    end1 = i;
                    e1 = true;
                    endTags.add(i);
                    continue;
                }
                start2 = 0;
                start3 = 0;
                start4 = 0;
                end2 = 0;
                end3 = 0;
                end4 = 0;
            }
        }
    }

    public void initTextFields() {
        backend = new ActiveBE(false);
        phraseList = new ArrayList<ArrayList<String>>();
        String current;
        for (int i = 0; i < 20; i++) {
            String file = backend.findFile(lesson, subLesson);
            ArrayList<String> phrase = backend.findPhrase(file);
            
            if (phrase == null || phrase.get(1) == null) {
                i--;
                continue;
            }
            boolean contains = false;

            if (contains == true) {
                i--;
            } else {
                phraseList.add(phrase);
                textList.add(phrase.get(1));
            }

            //Put clip and time info here - how are we getting the time information?
            //use getClips to return the clip names and files
            Float startTime = Float.parseFloat(phrase.get(0));
            int startNum = (int) (startTime * 1000000);

            timesList.add(startNum);

            Float endTime = Float.parseFloat(phrase.get(2));
            int endNum = (int) (endTime * 1000);
            startNum = (int) (startTime * 1000);
            int length = endNum - startNum;

            timersList.add(new Timer(length, listener));
        }
       
        audio = backend.getClips();

        showText();
    }
    
    private void showText() {
        if(!startTags.isEmpty() && !endTags.isEmpty()) {
            startTags.clear();
            endTags.clear();
            words.clear();
        }
        
        String current = textList.get(page-1);

        backend.findWords(current, words);
        if (words.size() >= 4) {
            wordCount = 4;
        } else if (words.size() == 3) {
            wordCount = 3;
        } else if (words.size() == 2) {
            wordCount = 2;
        } else if (words.size() == 1) {
            wordCount = 1;
        }
        wordsList.add(words);
        
        current = backend.setBlanks(current, words);
        findStartEnd(current);
        jTextPane1.setText(current);
        jTextPane1.setCaretPosition(start1 + ((end1 - start1) / 2));

        try {
            highlightAll(current);
        } catch (BadLocationException ex) {
            Logger.getLogger(Practice.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (String w : wordsList.get(page-1)) {
            System.out.println("Word: " + w);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submitButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        prevButton = new javax.swing.JButton();
        playButton1 = new javax.swing.JButton();
        jPageLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        attemptCountLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jHomeMenu = new javax.swing.JMenu();
        jEncMenu = new javax.swing.JMenu();
        jNasMenu = new javax.swing.JMenu();
        jToneTableMenu = new javax.swing.JMenu();
        jNaMaMenu = new javax.swing.JMenu();
        jUserMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(700, 410));
        setMinimumSize(new java.awt.Dimension(700, 410));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 410));

        submitButton.setBackground(new java.awt.Color(255, 255, 255));
        submitButton.setText("Check Answers");
        submitButton.setMaximumSize(new java.awt.Dimension(97, 30));
        submitButton.setMinimumSize(new java.awt.Dimension(97, 30));
        submitButton.setPreferredSize(new java.awt.Dimension(97, 30));
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        nextButton.setBackground(new java.awt.Color(255, 255, 255));
        nextButton.setText("Next");
        nextButton.setMaximumSize(new java.awt.Dimension(97, 30));
        nextButton.setMinimumSize(new java.awt.Dimension(97, 30));
        nextButton.setPreferredSize(new java.awt.Dimension(97, 30));
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        prevButton.setBackground(new java.awt.Color(255, 255, 255));
        prevButton.setText("Previous");
        prevButton.setMaximumSize(new java.awt.Dimension(97, 30));
        prevButton.setMinimumSize(new java.awt.Dimension(97, 30));
        prevButton.setPreferredSize(new java.awt.Dimension(97, 30));
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        playButton1.setBackground(new java.awt.Color(255, 255, 255));
        playButton1.setText("Play");
        playButton1.setMaximumSize(new java.awt.Dimension(97, 29));
        playButton1.setMinimumSize(new java.awt.Dimension(97, 29));
        playButton1.setPreferredSize(new java.awt.Dimension(97, 29));
        playButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButton1ActionPerformed(evt);
            }
        });

        jPageLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jPageLabel.setForeground(new java.awt.Color(204, 204, 204));
        jPageLabel.setText("Page 1/20");

        jTextPane1.setColumns(20);
        jTextPane1.setRows(5);
        jScrollPane1.setViewportView(jTextPane1);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/transcription/blue.png"))); // NOI18N

        attemptCountLabel.setText("jLabel2");

        jHomeMenu.setText("Home");
        jHomeMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jHomeMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(jHomeMenu);

        jEncMenu.setActionCommand("Enclitics");
        jEncMenu.setLabel("Enclitics");
        jEncMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEncMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(jEncMenu);

        jNasMenu.setText("Nasalization");
        jNasMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNasMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(jNasMenu);

        jToneTableMenu.setText("Tone Table");
        jToneTableMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToneTableMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(jToneTableMenu);

        jNaMaMenu.setText("NaMa");
        jNaMaMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNaMaMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(jNaMaMenu);

        jUserMenu.setText("User");

        jMenuItem1.setText("Log out");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseReleased(evt);
            }
        });
        jUserMenu.add(jMenuItem1);

        jMenuBar1.add(jUserMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 588, Short.MAX_VALUE)
                .addComponent(jPageLabel)
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(playButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(attemptCountLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(playButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(attemptCountLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jPageLabel)
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        clicks++;
        attempt--;
        attemptCountLabel.setText("You have " + attempt + " attempts left.");   
        
        String phrase = jTextPane1.getText();
        findStartEnd(phrase);
        setupDoc();
        try {
            checkAnswers();
        } catch (BadLocationException ex) {
            Logger.getLogger(Practice.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (clicks == 3) {
            submitButton.setEnabled(false); 
            btnStatus.set(page-1, false);
            findWrongAnswers();
        }
        
    }

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        Document doc = jTextPane1.getDocument();
        page--;
        clip.stop();
        clip.close();
        timer.stop();
        jPageLabel.setText("Page " + page + "/20");
        backend.closeAudio(); 
        clip = backend.makeClip(page);
        if (page == 1) {
            prevButton.setText("Current");
            prevButton.setEnabled(false);
        } else if (page == 19) {
            nextButton.setEnabled(true);
            nextButton.setText("Next");
        }
        playButton1.setForeground(new java.awt.Color(0, 153, 51));
        playButton1.setText("Play");
        backend.closeAudio();
        submitButton.setEnabled(btnStatus.get(page-1));
        attemptCountLabel.setText("You have " + attempts.get(page-1) + " attempts left."); 
        try {
            int start = saveStart.get(page - 1).get(wordCount - 1);
            int end = saveEnd.get(page - 1).get(wordCount - 1);
            System.out.println(answers);
            String answer = answers.get(page - 1).get(wordCount - 1).get(attempts.get(page - 1));
            String word = wordsList.get(page - 1).get(wordCount - 1);
            doc.insertString(start, answer, null);
            if(correct.get(page-1).get(wordCount-1) == false) {
                displayCorrectAnswers(start, end, word);
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(Practice.class.getName()).log(Level.SEVERE, null, ex);
        }
        initAudio();
        showText();
        jTextPane1.setText(text);
    }//GEN-LAST:event_prevButtonActionPerformed

    private void jHomeMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeMenuMouseClicked
        enc.dispose();
        if (NaMaOpen) {
            na.dispose();
        }
        tone.dispose();
        nas.dispose();
        new Home(user).setVisible(true);
        backend.closeAudio();
        dispose();
    }//GEN-LAST:event_jHomeMenuMouseClicked

    private void jEncMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEncMenuMouseClicked
        if (!enc.isShowing()) {
            enc.setVisible(true);
        } else {
            enc.toFront();
        }
    }//GEN-LAST:event_jEncMenuMouseClicked

    private void jNasMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNasMenuMouseClicked
        if (!nas.isShowing()) {
            nas.setVisible(true);
        } else {
            nas.toFront();
        }
    }//GEN-LAST:event_jNasMenuMouseClicked

    private void jToneTableMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToneTableMenuMouseClicked
        if (!tone.isShowing()) {
            tone.setVisible(true);
        } else {
            tone.toFront();
        }
    }//GEN-LAST:event_jToneTableMenuMouseClicked

    private void jMenuItem1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseReleased
        new SignIn().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1MouseReleased

    private void playButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButton1ActionPerformed
        clip.stop();
        timer.stop();
        playButton1.setText("Play");
        playButton1.setForeground(new java.awt.Color(0, 153, 51));
        if (!clip.isRunning()) {
            clip.setMicrosecondPosition(timesList.get(page-1));
            clip.start();
            timer.start();
            playButton1.setForeground(new java.awt.Color(255, 51, 51));
            playButton1.setText("Stop");
        } else {
            clip.stop();
            timer.stop();
            playButton1.setForeground(new java.awt.Color(0, 153, 51));
            playButton1.setText("Play");
        }
    }//GEN-LAST:event_playButton1ActionPerformed
    String text = " ";
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        page++;
        clip.stop();
        clip.close();
        timer.stop();
        jPageLabel.setText("Page " + page + "/20");
        backend.closeAudio();
        clip = backend.makeClip(page);
        if (page == 20) {
            nextButton.setText("Current");
            nextButton.setEnabled(false);
        } else if (page == 2) {
            prevButton.setEnabled(true);
            prevButton.setText("Previous");
        }
        playButton1.setForeground(new java.awt.Color(0, 153, 51));
        playButton1.setText("Play");
        backend.closeAudio();
        initAudio();
        submitButton.setEnabled(btnStatus.get(page-1));
        clicks = 0;
        attempt = 3;
        attemptCountLabel.setText("You have " + attempts.get(page-1) + " attempts left.");
        showText();
        text = jTextPane1.getText();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void jNaMaMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNaMaMenuMouseClicked
        if (!NaMaOpen) {
            na = new NamaTable();
            NaMaOpen=true;
        }
        if (!na.isShowing()) {
            na.setVisible(true);
        } else {
            na.toFront();
        }
    }//GEN-LAST:event_jNaMaMenuMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Practice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Practice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Practice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Practice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Practice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attemptCountLabel;
    private javax.swing.JMenu jEncMenu;
    private javax.swing.JMenu jHomeMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jNaMaMenu;
    private javax.swing.JMenu jNasMenu;
    private javax.swing.JLabel jPageLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextPane1;
    private javax.swing.JMenu jToneTableMenu;
    private javax.swing.JMenu jUserMenu;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton playButton1;
    private javax.swing.JButton prevButton;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
