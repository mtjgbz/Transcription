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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
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
    
    String user;
    Integer lesson;
    String subLesson;
    

    Clip clip;
    Timer timer;

    Enclitics enc = new Enclitics();
    Nasalizations nas = new Nasalizations();
    ToneTable tone = new ToneTable();
    NamaTable na;
    int NaMaCount = 0;
    
    private ActiveBE backend;
    
    int page = 1;
    
    private ArrayList<String> textList = new ArrayList<>();
    Integer timesVar = 9029000;
    private ArrayList<ArrayList<String>> phraseList;
    private ArrayList<String> wordsList = new ArrayList<>();
    ArrayList<Integer> timesList = new ArrayList<>();
    ArrayList<Timer> timersList = new ArrayList<>();
    ArrayList<File> clips = new ArrayList<>();
    ArrayList<Integer> startTags = new ArrayList<>();
    ArrayList<Integer> endTags = new ArrayList<>();
    private ArrayList<String> answers = new ArrayList<>();
    
    private Highlighter.HighlightPainter redPainter;
    private Highlighter.HighlightPainter greenPainter;

    
    ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            
            clip.stop();
            clip.setMicrosecondPosition(timesVar);
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
        this.setTitle("Mixtec Transcription: Practice");
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
        initAudio(); 
        initTextFields();
        
        jScrollPane1.setViewportView(jTextPane1);
        setupDoc();
        numTags = 0;
        jTextPane1.setLineWrap(true);
    }
    
    private void initAudio(){
        clip = backend.makeClip(page);
        //timer = ;
    }
    
    private void setupDoc(){
       AbstractDocument doc = (AbstractDocument) jTextPane1.getDocument();
        
       doc.setDocumentFilter(new DocumentFilter() {
            public void replace(DocumentFilter.FilterBypass fb, int offs, int length,
                    String str, AttributeSet a) throws BadLocationException {

                String text = fb.getDocument().getText(0,
                        fb.getDocument().getLength());
                text += str;
                if (offs >= start1 && offs<=end1) {
                    end1+=str.length();
                    end1-=length;
                    end2+=str.length();
                    end2-=length;
                    start2+=str.length();
                    start2-=length;
                    end3+=str.length();
                    end3-=length;
                    start3+=str.length();
                    start3-=length;
                    end4+=str.length();
                    end4-=length;
                    start4+=str.length();
                    start4-=length;
                    
                    super.replace(fb, offs, length, str, a);
                }else if(offs >= start2 && offs<=end2){
                    end2+=str.length();
                    end2-=length;
                    end3+=str.length();
                    end3-=length;
                    start3+=str.length();
                    start3-=length;
                    end4+=str.length();
                    end4-=length;
                    start4+=str.length();
                    start4-=length;
                    
                    super.replace(fb, offs, length, str, a);
                } else if(offs >=start3 && offs<=end3){
                    end3+=str.length();
                    end3-=length;
                    end4+=str.length();
                    end4-=length;
                    start4+=str.length();
                    start4-=length;
                    
                    super.replace(fb, offs, length, str, a);
                } else if(offs >= start4 && offs<=end4) {
                    end4+=str.length();
                    end4-=length;
                    
                    super.replace(fb, offs, length, str, a);
                }else {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
            
            public void remove(DocumentFilter.FilterBypass fb, int offs, int length)throws BadLocationException{
                if((offs>=start1 && offs<end1)){
                    end1--;
                    start2--;
                    end2--;
                    start3--;
                    end3--;
                    start4--;
                    end4--;
                    
                    super.remove(fb, offs, length);
                }else if(offs>=start2 && offs<end2){
                    end2--;
                    end3--;
                    start3--;
                    start4--;
                    end4--;
                    
                    super.remove(fb, offs, length);
                }else if(offs>=start3 && offs<end3){
                    end3--;
                    start4--;
                    end4--;
                    
                    super.remove(fb, offs, length);
                }
                else if(offs>=start4 && offs<end4){
                    end4--;
                    
                    super.remove(fb, offs, length);
                }
            }

            public void insertString(DocumentFilter.FilterBypass fb, int offs, String str,
                    AttributeSet a) throws BadLocationException {

                String text = fb.getDocument().getText(0,
                        fb.getDocument().getLength());
                text += str;
                if (offs >= start1&& offs<=end1) {
                    end1+=str.length();
                    start2+=str.length();
                    end2+=str.length();
                    start3+=str.length();
                    end3+=str.length();
                    start4+=str.length();
                    end4+=str.length();
                            
                    super.insertString(fb, offs, str, a);
                } else if(offs >= start2 && offs<=end2){
                    end2+=str.length();
                    start3+=str.length();
                    end3+=str.length();
                    start4+=str.length();
                    end4+=str.length();
                    
                    super.insertString(fb, offs, str, a);
                } else if(offs >= start3 && offs<=end3) {
                    end3+=str.length();
                    start4+=str.length();
                    end4+=str.length();
                    
                    super.insertString(fb, offs, str, a);
                }else if(offs >= start4 && offs<=end4) {
                    end4+=str.length();
                    
                    super.insertString(fb, offs, str, a);
                }
                else {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
    }
    
    public void highlightAll(String input) throws BadLocationException {
        //String text = "tan3 u1bi1 ku4u4 na1 kan4 tu4u13 ran4, tan3 i3kan4 ndu4ku4=na2, ya1kan3";
        //jTextArea1.setText(text);
        //startEnd = tags;
        Highlighter highlighter = null;
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN);
        
        //String temp = input;
        //int num = 0;
        
            //if(i == 0) {
                highlighter = jTextPane1.getHighlighter();
                jTextPane1.setHighlighter(highlighter);
            //}
//            if(i == 1) {
//                highlighter = jTextArea2.getHighlighter();
//                jTextArea2.setHighlighter(highlighter);
//            }
//            if(i == 2) {
//                highlighter = jTextArea3.getHighlighter();
//                jTextArea3.setHighlighter(highlighter);
//            }
//            if(i == 3) {
//                highlighter = jTextArea4.getHighlighter();
//                jTextArea4.setHighlighter(highlighter);
//            }
            
            for(int j = 0; j < numTags; j+=2) {
                //temp = phrases.get(i);
                //num = tags.get(j);
                
                int start = startTags.get(j);
                int end = endTags.get(j);
                //System.out.println("Start: " + start);
                //while(start >= 0) {                    
                    
                    char[] chars = input.toCharArray();
                    if(start != 0 && Character.isWhitespace(chars[start-1])){
                        try{
                            //System.out.println("length: " + word.length());
                            //int end = start + word.length();
                            //System.out.println("End: " + end);
                            //System.out.println("printing chars");
//                            for(int i = start; i <= end; i++) {
//                                
//                                System.out.print(chars[i]);
//                            }
                            highlighter.addHighlight(start, end+1, painter);
                            //if(i == 0) {
                            //System.out.println("length of chars: " + chars.length);
                             //   jTextPane1.setCaretPosition(end);
                            //}
//                            if(i == 1) {
//                                jTextArea2.setCaretPosition(end);
//                            }
//                            if(i == 2) {
//                                jTextArea3.setCaretPosition(end);
//                            }
//                            if(i == 3) {
//                                jTextArea4.setCaretPosition(end);
//                            }
                        }catch(BadLocationException e){
                            e.printStackTrace();
                        }
                        //start = temp.indexOf(word, start+word.length());
                    }
                    else {
                        //start = temp.indexOf(word, start+word.length());
                    }
                    
                //}
               
           
            }
 
    }
    
    private void checkAnswers() throws BadLocationException {
        Document doc = jTextPane1.getDocument();
        
        String b1 = doc.getText(start1, end1-start1);
        String b2 = doc.getText(start2, end2-start2);
        String b3 = doc.getText(start3, end3-start3);
        String b4 = doc.getText(start4, end4-start4);
        
        b1 = b1.replaceAll(" ", "");
        b2 = b2.replaceAll(" ", "");
        b3 = b3.replaceAll(" ", "");
        b4 = b4.replaceAll(" ", "");
        
        answers.add(b1);
        answers.add(b2);
        answers.add(b3);
        answers.add(b4);
        
        for(String a : answers) {
            System.out.println("ansArray: |" + a + "|");
        }
        
        redPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
        greenPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
        
        Highlighter highlighter = jTextPane1.getHighlighter();
        jTextPane1.setHighlighter(highlighter);
        try {
            if(wordCount == 4) {
                if(!(b1.equals(wordsList.get(0)))) {
                    System.out.println("b1 not equal");
                    System.out.println("b1: " + "|" + b1 + "|" + " word: " + "|" + wordsList.get(0) + "|");
                    highlighter.addHighlight(start1, end1, redPainter);
                }
                else {
                    System.out.println("b1 equal");
                    highlighter.addHighlight(start1, end1, greenPainter);
                }
                if(!(b2.equals(wordsList.get(1)))) {
                    System.out.println("b2 not equal");
                    System.out.println("b2: " + "|" + b2 + "|" + " word: " + "|" + wordsList.get(1) + "|");
                    highlighter.addHighlight(start2, end2, redPainter);
                }
                else {
                    System.out.println("b2 equal");
                    highlighter.addHighlight(start2, end2, greenPainter);
                }
                if(!(b3.equals(wordsList.get(2)))) {
                    System.out.println("b3 not equal");
                    System.out.println("b3: " + "|" + b3 + "|" + " word: " + "|" + wordsList.get(2) + "|");
                    highlighter.addHighlight(start3, end3, redPainter);
                }
                else {
                    System.out.println("b3 equal");
                    highlighter.addHighlight(start3, end3, greenPainter);
                }
                if(!(b4.equals(wordsList.get(3)))) {
                    System.out.println("b3 not equal");
                    System.out.println("b3: " + "|" + b4 + "|" + " word: " + "|" + wordsList.get(3) + "|");
                    highlighter.addHighlight(start4, end4, redPainter);
                }
                else {
                    System.out.println("b4 equal");
                    highlighter.addHighlight(start4, end4, greenPainter);
                }
            }
            else if(wordCount == 3) {
                if(!(b1.equals(wordsList.get(0)))) {
                    System.out.println("b1 not equal");
                    System.out.println("b1: " + "|" + b1 + "|" + " word: " + "|" + wordsList.get(0) + "|");
                    highlighter.addHighlight(start1, end1, redPainter);
                }
                else {
                    System.out.println("b1 equal");
                    highlighter.addHighlight(start1, end1, greenPainter);
                }
                if(!(b2.equals(wordsList.get(1)))) {
                    System.out.println("b2 not equal");
                    System.out.println("b2: " + "|" + b2 + "|" + " word: " + "|" + wordsList.get(1) + "|");
                    highlighter.addHighlight(start2, end2, redPainter);
                }
                else {
                    System.out.println("b2 equal");
                    highlighter.addHighlight(start2, end2, greenPainter);
                }
                if(!(b3.equals(wordsList.get(2)))) {
                    System.out.println("b3 not equal");
                    System.out.println("b3: " + "|" + b3 + "|" + " word: " + "|" + wordsList.get(2) + "|");
                    highlighter.addHighlight(start3, end3, redPainter);
                }
                else {
                    System.out.println("b3 equal");
                    highlighter.addHighlight(start3, end3, greenPainter);
                }
            }
            else if(wordCount == 2) {
                if(!(b1.equals(wordsList.get(0)))) {
                    System.out.println("b1 not equal");
                    System.out.println("b1: " + "|" + b1 + "|" + " word: " + "|" + wordsList.get(0) + "|");
                    highlighter.addHighlight(start1, end1, redPainter);
                }
                else {
                    System.out.println("b1 equal");
                    highlighter.addHighlight(start1, end1, greenPainter);
                }
                if(!(b2.equals(wordsList.get(1)))) {
                    System.out.println("b2 not equal");
                    System.out.println("b2: " + "|" + b2 + "|" + " word: " + "|" + wordsList.get(1) + "|");
                    highlighter.addHighlight(start2, end2, redPainter);
                }
                else {
                    System.out.println("b2 equal");
                    highlighter.addHighlight(start2, end2, greenPainter);
                }
            }
            else if(wordCount == 1) {
                if(!(b1.equals(wordsList.get(0)))) {
                    System.out.println("b1 not equal");
                    System.out.println("b1: " + "|" + b1 + "|" + " word: " + "|" + wordsList.get(0) + "|");
                    highlighter.addHighlight(start1, end1, redPainter);
                }
                else {
                    System.out.println("b1 equal");
                    highlighter.addHighlight(start1, end1, greenPainter);
                }
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(Practice.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(clicks == 3) {
            submitButton.setEnabled(false);
        }

    }
    
    private void findStartEnd(String input) {
        System.out.println("input1: " + input);
        boolean s1 = false;
        boolean e1 = false;
        boolean s2 = false;
        boolean e2 = false;
        boolean s3 = false;
        boolean e3 = false; 
        boolean s4 = false;
        boolean e4 = false;
        
        char[] statement = input.toCharArray();
        //int temp = 0;
        //int t = 0;
        char c; 
        //while(temp != 5){
            for(int i = 0; i < statement.length; i++) {
                c = statement[i];
                if(wordCount == 4) {
                    if(c == '[' && s1 == false) {
                        start1 = i+1;
                        //tracker = i;
                        s1 = true;
                        numTags++;
                        startTags.add(i);
                        System.out.println("s1: " + i);
                        continue;
                    }
                    if(c == ']' && e1 == false) {
                        end1 = i;
                        //tracker = i;
                        e1 = true;
                        numTags++;
                        endTags.add(i);
                        System.out.println("e1: " + i);
                        continue;
                    }
                    if(c == '[' && s2 == false) {
                        start2 = i+1;
                        //tracker = i;
                        s2 = true;
                        numTags++;
                        startTags.add(i);
                        System.out.println("s2: " + i);
                        continue;
                    }
                    if(c == ']' && e2 == false) {
                        end2 = i;
                        //tracker = i;
                        e2 = true;
                        numTags++;
                        endTags.add(i);
                        System.out.println("e2: " + i);
                        continue;
                    }
                    if(c == '[' && s3 == false) {
                        start3 = i+1;
                        //tracker = i;
                        s3 = true;
                        numTags++;
                        startTags.add(i);
                        System.out.println("s3: " + i);
                        continue;
                    }
                    if(c == ']' && e3 == false) {
                        end3 = i;
                        //tracker = i;
                        e3 = true;
                        numTags++;
                        endTags.add(i);
                        System.out.println("e3: " + i);
                        continue;
                    }
                    if(c == ']' && s4 == false) {
                        start4 = i;
                        //tracker = i;
                        s4 = true;
                        numTags++;
                        startTags.add(i);
                        System.out.println("s4: " + i);
                        continue;
                    }
                    if(c == ']' && e4 == false) {
                        end4 = i;
                        //tracker = i;
                        e4 = true;
                        numTags++;
                        endTags.add(i);
                        System.out.println("e4: " + i);
                        continue;
                    }
                }
                else if(wordCount == 3) {
                    if(c == '[' && s1 == false) {
                        start1 = i+1;
                        //tracker = i;
                        s1 = true;
                        numTags++;
                        startTags.add(i);
                        System.out.println("s1: " + i);
                        continue;
                    }
                    if(c == ']' && e1 == false) {
                        end1 = i;
                        //tracker = i;
                        e1 = true;
                        numTags++;
                        endTags.add(i);
                        System.out.println("e1: " + i);
                        continue;
                    }
                    if(c == '[' && s2 == false) {
                        start2 = i+1;
                        //tracker = i;
                        s2 = true;
                        numTags++;
                        startTags.add(i);
                        System.out.println("s2: " + i);
                        continue;
                    }
                    if(c == ']' && e2 == false) {
                        end2 = i;
                        //tracker = i;
                        e2 = true;
                        numTags++;
                        endTags.add(i);
                        System.out.println("e2: " + i);
                        continue;
                    }
                    if(c == '[' && s3 == false) {
                        start3 = i+1;
                        //tracker = i;
                        s3 = true;
                        numTags++;
                        startTags.add(i);
                        System.out.println("s3: " + i);
                        continue;
                    }
                    if(c == ']' && e3 == false) {
                        end3 = i;
                        //tracker = i;
                        e3 = true;
                        numTags++;
                        endTags.add(i);
                        System.out.println("e3: " + i);
                        continue;
                    }
                    start4 = 0;
                    end4 = 0;
                }
                else if(wordCount == 2) {
                    if(c == '[' && s1 == false) {
                        start1 = i+1;
                        //tracker = i;
                        s1 = true;
                        numTags++;
                        startTags.add(i);
                        System.out.println("s1: " + i);
                        continue;
                    }
                    if(c == ']' && e1 == false) {
                        end1 = i;
                        //tracker = i;
                        e1 = true;
                        numTags++;
                        endTags.add(i);
                        System.out.println("e1: " + i);
                        continue;
                    }
                    if(c == '[' && s2 == false) {
                        start2 = i+1;
                        //tracker = i;
                        s2 = true;
                        numTags++;
                        startTags.add(i);
                        System.out.println("s2: " + i);
                        continue;
                    }
                    if(c == ']' && e2 == false) {
                        end2 = i;
                        //tracker = i;
                        e2 = true;
                        numTags++;
                        endTags.add(i);
                        System.out.println("e2: " + i);
                        continue;
                    }
                    start3 = 0;
                    start4 = 0;
                    end3 = 0;
                    end4 = 0; 
                }
                else if(wordCount == 1) {
                    if(c == '[' && s1 == false) {
                        start1 = i+1;
                        //tracker = i;
                        s1 = true;
                        numTags++;
                        startTags.add(i);
                        System.out.println("s1: " + i);
                        continue;
                    }
                    if(c == ']' && e1 == false) {
                        end1 = i;
                        //tracker = i;
                        e1 = true;
                        numTags++;
                        endTags.add(i);
                        System.out.println("e1: " + i);
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
        //    temp++;
        //}
//        System.out.println("Start1: " + start1);
//        System.out.println("End1: " + end1);
//        System.out.println("Start2: " + start2);
//        System.out.println("End3: " + end2);
//        System.out.println("Start3: " + start3);
//        System.out.println("End3: " + end3);
        for(int i : startTags) {
            System.out.println("start tag: " + i);
        }
        for(int i : endTags) {
            System.out.println("end tag: " + i);
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
            int index = 0;

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

        clips = backend.getClips();
        //System.out.println(clip);

        current = textList.get(page - 1);
        System.out.println("wsize: " + wordsList.size());
        
        backend.findWords(current, wordsList);
        if(wordsList.size() >= 4) {
            wordCount = 4;
        }
        else if(wordsList.size() == 3) {
            wordCount = 3;
        }
        else if(wordsList.size() == 2) {
            wordCount = 2;
        }
        else if(wordsList.size() == 1) {
            wordCount = 1;
        }
        System.out.println("before blanks: " + current);
        System.out.println("wordCount: " + wordCount);
        current = backend.setBlanks(current, wordsList);
        System.out.println("current: " + current);
        findStartEnd(current);
        jTextPane1.setText(current);
        
        
        try {
            highlightAll(current);
        } catch (BadLocationException ex) {
            Logger.getLogger(Practice.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("wsize: " + wordsList.size());
        for(String w : wordsList) {
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jHomeMenu = new javax.swing.JMenu();
        jEncMenu = new javax.swing.JMenu();
        jNasMenu = new javax.swing.JMenu();
        jToneTableMenu = new javax.swing.JMenu();
        jNaMaMenu = new javax.swing.JMenu();
        jUserMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(700, 430));
        setResizable(false);

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
        jPageLabel.setText("Page 1");

        jTextPane1.setColumns(20);
        jTextPane1.setRows(5);
        jScrollPane1.setViewportView(jTextPane1);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/transcription/blue.png"))); // NOI18N

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
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPageLabel)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(playButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 105, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(playButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPageLabel)
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        clicks++;
        String phrase = jTextPane1.getText();
        findStartEnd(phrase);
        setupDoc();
        try {
            checkAnswers();
        } catch (BadLocationException ex) {
            Logger.getLogger(Practice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                            
    
    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
       page--;
       clip.stop();
       clip.close();
       timer.stop();
       jPageLabel.setText("Page " + page);
       backend.closeAudio(); 
       clip = backend.makeClip(page);
       if(page == 1){
           prevButton.setText("Current");
           prevButton.setEnabled(false);
       }else if(page == 19){
           nextButton.setEnabled(true);
           nextButton.setText("Next");
       }
       playButton1.setForeground(new java.awt.Color(0, 153, 51));
       playButton1.setText("Play");
       backend.closeAudio();
       initAudio();
       //backend.findWords(textList.get(page - 1), wordsList);
    }//GEN-LAST:event_prevButtonActionPerformed

    private void jHomeMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeMenuMouseClicked
        enc.dispose();
        if(NaMaCount > 0) {
            na.dispose();
        }
        tone.dispose();
        na.dispose();
        new Home(user).setVisible(true);
        backend.closeAudio();
        dispose();
    }//GEN-LAST:event_jHomeMenuMouseClicked

    private void jEncMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEncMenuMouseClicked
        if(!enc.isShowing()) {
            enc.setVisible(true);
        } else {
            enc.toFront();
        }
    }//GEN-LAST:event_jEncMenuMouseClicked

    private void jNasMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNasMenuMouseClicked
        if(!nas.isShowing()) {
            nas.setVisible(true);
        } else {
            nas.toFront();
        }
    }//GEN-LAST:event_jNasMenuMouseClicked

    private void jToneTableMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToneTableMenuMouseClicked
        if(!tone.isShowing()) {
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
        playButton1.setText("Play");
        playButton1.setForeground(new java.awt.Color(0, 153, 51));
        if(!clip.isRunning()) {
            clip.setMicrosecondPosition(timesVar);
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

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        page++;
        clip.stop();
        clip.close();
        timer.stop();
        jPageLabel.setText("Page " + page);
        backend.closeAudio();
        clip = backend.makeClip(page);
        if(page==20) {
           nextButton.setText("Current");
           nextButton.setEnabled(false);
       } else if(page==2) {
           prevButton.setEnabled(true);
           prevButton.setText("Previous");
       }
       playButton1.setForeground(new java.awt.Color(0, 153, 51));
       playButton1.setText("Play");
       backend.closeAudio();
       initAudio();
       //backend.findWords(textList.get(page - 1), wordsList);
    }//GEN-LAST:event_nextButtonActionPerformed

    private void jNaMaMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNaMaMenuMouseClicked
        if(NaMaCount == 0){
            na = new NamaTable();
        }
        if (!na.isShowing()) {
            na.setVisible(true);
        } else {
            na.toFront();
        }
        NaMaCount++;
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
