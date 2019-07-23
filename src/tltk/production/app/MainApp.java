/*
 * Author :  Tzahi Levi.
 */
package tltk.production.app;

import java.awt.AWTException;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.Robot;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Tzahi Levi
 */
public class MainApp extends javax.swing.JFrame implements DocumentListener, ChangeListener {

    /**
     * Creates new form MainApp
     */
    public MainApp() {
        initComponents();
        text2key = new HashMap<>();
        MainPanel.add(set, "set");
        MainPanel.add(ready, "ready");
        GO = new AtomicBoolean(true);
        ((CardLayout) MainPanel.getLayout()).show(MainPanel, "set");
        addShortcut();

        super.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                MainPanelGetRequest();
            }

        });

        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                File f = FileHandler.getFile();
                if (f != null) {
                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));) {
                        out.writeObject(tabPane.getTabCompoments());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        set = new javax.swing.JPanel();
        runBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        undoBtn = new javax.swing.JButton();
        times = new javax.swing.JTextField();
        multiBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        ready = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        currentState = new javax.swing.JLabel();
        repaet = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        itemsScrollPane = new javax.swing.JScrollPane();
        itemList = new javax.swing.JList<>();
        helpPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        MainPanel = new javax.swing.JPanel();

        set.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setMouseEntered(evt);
            }
        });
        set.setLayout(new java.awt.GridBagLayout());

        runBtn.setText("הפעל");
        runBtn.setEnabled(false);
        runBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        set.add(runBtn, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton1.setText("?");
        jButton1.setAlignmentY(0.0F);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        set.add(jButton1, gridBagConstraints);

        addBtn.setText("הוסף");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
                mainPanelGetRequestAfterButtonPress(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        set.add(addBtn, gridBagConstraints);

        jLabel1.setText("חזרות");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        set.add(jLabel1, gridBagConstraints);

        undoBtn.setText("בטל");
        undoBtn.setEnabled(false);
        undoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoBtnActionPerformed(evt);
                mainPanelGetRequestAfterButtonPress(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        set.add(undoBtn, gridBagConstraints);

        times.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        times.setText("1");
        times.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                timesKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                timesKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 2.0;
        set.add(times, gridBagConstraints);

        multiBtn.setText("הכפל");
        multiBtn.setEnabled(false);
        multiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        set.add(multiBtn, gridBagConstraints);

        resetBtn.setText("אפס");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
                mainPanelGetRequestAfterButtonPress(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        set.add(resetBtn, gridBagConstraints);

        tabPane.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tabPaneComponentAdded(evt);
            }
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                tabPaneComponentRemoved(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        set.add(tabPane, gridBagConstraints);

        jTextField1.setText("רובוט אוטמטי בפעולה סמן את החלון שבו תרצה שיתבצעו הלחיצות");

        currentState.setText("jLabel1");

        repaet.setText("100");

        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setText("בטל");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout readyLayout = new javax.swing.GroupLayout(ready);
        ready.setLayout(readyLayout);
        readyLayout.setHorizontalGroup(
            readyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, readyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(repaet, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addGroup(readyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentState, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(160, 160, 160))
        );
        readyLayout.setVerticalGroup(
            readyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(readyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(readyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(readyLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(currentState, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(readyLayout.createSequentialGroup()
                        .addComponent(repaet)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        itemList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "לחצן", "המתנה", "Tab" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        itemsScrollPane.setViewportView(itemList);

        jLabel2.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("קיצורי דרך");

        jTable2.setBorder(null);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"פעולה","מקש"},
                {"הוספת לחיצה","K"},
                { "הוספת המתנה","P"},
                { "הוספת  Tab","T"},
                {"בטל פעולה אחרונה","U"},
                {"הכפל מקש אחרון","M"},
                {"איפוס","R"}
            },
            new String [] {
                null, null
            }
        ));
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable2.setOpaque(false);
        jTable2.setRowSelectionAllowed(false);
        jTable2.setShowHorizontalLines(false);
        jTable2.setShowVerticalLines(false);
        jTable2.getTableHeader().setResizingAllowed(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.setTableHeader(null);
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout helpPanelLayout = new javax.swing.GroupLayout(helpPanel);
        helpPanel.setLayout(helpPanelLayout);
        helpPanelLayout.setHorizontalGroup(
            helpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, helpPanelLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(helpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        helpPanelLayout.setVerticalGroup(
            helpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Press for me");
        setIconImage(createImage("icon.png", "icon")
        );
        setMinimumSize(new java.awt.Dimension(403, 216));
        setPreferredSize(new java.awt.Dimension(400, 300));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        MainPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(410, 330));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addShortcut() {
        MainPanel.getInputMap().put(KeyStroke.getKeyStroke("P"), "pause");
        MainPanel.getInputMap().put(KeyStroke.getKeyStroke("K"), "addKey");
        MainPanel.getInputMap().put(KeyStroke.getKeyStroke("R"), "reset");
        MainPanel.getInputMap().put(KeyStroke.getKeyStroke("U"), "undo");
        MainPanel.getInputMap().put(KeyStroke.getKeyStroke("T"), "tab");
        MainPanel.getInputMap().put(KeyStroke.getKeyStroke("M"), "multi");
        MainPanel.getActionMap().put("pause", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPause();
            }
        });
        MainPanel.getActionMap().put("addKey", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showKeyPress();
            }
        });

        MainPanel.getActionMap().put("reset", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetBtnActionPerformed(e);
            }
        });
        MainPanel.getActionMap().put("undo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undoBtnActionPerformed(e);
            }
        });
        MainPanel.getActionMap().put("tab", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTab();
            }
        });

        MainPanel.getActionMap().put("multi", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (multiBtn.isEnabled()) {
                    multiBtnActionPerformed(e);
                }
            }
        });
    }
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        JOptionPane.showOptionDialog(this, itemsScrollPane, "בחר לחצן או המתנה", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        switch (itemList.getSelectedIndex()) {
            case 0: {
                showKeyPress();
                break;
            }
            case 1: {
                addPause();
                break;
            }
            case 2: {
                addTab();
                break;
            }
            default: {
            }
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void addTab() {
        final JTextArea keysArea = tabPane.getCurrentTextArea();
        int key = KeyEvent.VK_TAB;
        String name = "Tab";
        if (keysArea.getText().length() > 0 && keysArea.getText().charAt(keysArea.getText().length() - 1) != '\n') {
            keysArea.append(" + ");
        }

        text2key.put(name, key);
        keysArea.append(name);

    }
    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        tabPane.getCurrentTextArea().setText(null);
    }//GEN-LAST:event_resetBtnActionPerformed

    private void addPause() {
        final JTextArea keysArea = tabPane.getCurrentTextArea();
        String format;
        if (keysArea.getText().length() == 0 || keysArea.getText().endsWith("\n")) {
            format = "%s\n";
        } else {
            format = "\n%s\n";
        }
        keysArea.append(String.format(format, WAIT));
    }

    private void showKeyPress() {
        final JFrame f = new JFrame();
        f.setSize(150, 150);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        final JPanel p = new JPanel();
        final TextField tf = new TextField();
        p.setSize(150, 150);
        p.add(new JLabel("הקש על מקש"));
        p.add(tf);
        f.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                f.requestFocus();
                tf.requestFocus();
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                MainPanelGetRequest();
            }

        });
        tf.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                e.consume();
                final JTextArea keysArea = tabPane.getCurrentTextArea();
                if (keysArea.getText().length() > 0 && keysArea.getText().charAt(keysArea.getText().length() - 1) != '\n') {
                    keysArea.append(" + ");
                }
                int k = e.getKeyCode();
                // System.out.println("k : " + k);
                String name;
                if (k > 0 && k < 255) {
                    name = KeyEvent.getKeyText(k);
                } else {
                    k = heb2eng((int) e.getKeyChar());
                    name = String.valueOf(e.getKeyChar());
                }
                //System.out.println("key " + k + " name : " + name);

                text2key.put(name, k);
                keysArea.append(name);
                f.setVisible(false);
                f.dispose();
                MainPanelGetRequest();
            }
        });
        f.getContentPane().add(p);
        f.setSize(new java.awt.Dimension(150, 150));
        f.setLocationRelativeTo(this);
        f.setVisible(true);
    }
    private void runBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runBtnActionPerformed
        String keys = tabPane.getCurrentTextArea().getText();
        if (times.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "הכנס חזרות");
            times.requestFocusInWindow();
            return;
        }
        if (keys.length() > 0) {

            new Thread(() -> {
                ((CardLayout) MainPanel.getLayout()).show(MainPanel, "ready");
                int r = Integer.parseInt(times.getText());
                repaet.setText(String.valueOf(r));
                for (int i = 5; i > 0; i--) {
                    currentState.setText(String.valueOf(i));
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainApp.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }
                String[] lines = keys.split("\n");
                GO.set(true);
                for (int i = r; i > 0 && GO.get(); i--) {
                    repaet.setText(String.valueOf(i));
                    for (int j = 0; j < lines.length; j++) {
                        String line = lines[j];
                        //System.out.println(line);
                        if (line.startsWith("המתנה")) {

                            currentState.setText("ממתין");
                            try {
                                Thread.sleep(10);

                            } catch (InterruptedException ex) {
                                Logger.getLogger(MainApp.class
                                        .getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            String[] k = line.split("[+]");
                            // System.out.println("keys to press : " + Arrays.toString(k));
                            currentState.setText(line);
                            try {
                                robotMyKey(k);

                            } catch (AWTException ex) {
                                Logger.getLogger(MainApp.class
                                        .getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }

                ((CardLayout) MainPanel.getLayout()).show(MainPanel, "set");
            }).start();
        }
    }//GEN-LAST:event_runBtnActionPerformed

    private void undoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoBtnActionPerformed
        final JTextArea keysArea = tabPane.getCurrentTextArea();
        try {
            int line = keysArea.getLineCount() - 1;
            int start = keysArea.getLineStartOffset(line);
            int end = keysArea.getLineEndOffset(line);
            if (end == 0) {
                return;
            }
            String s = keysArea.getText().substring(start, end);
            //  System.out.println(String.format("s: %s , start: %d , end: %d", s, start, end));
            if (s.length() == 0) {
                if (start == 6) {
                    keysArea.setText(null);
                } else {
                    start = keysArea.getLineEndOffset(line - 2) - 1;
                    s = "";
                }
            } else if (s.equals(WAIT)) {
                start = start == 0 ? start : start - 1;
                s = "";
            } else {
                int l = s.lastIndexOf(" + ");
                if (l == -1) {
                    s = "";
                } else {

                    s = s.substring(0, l);
                }
                //    keysArea.replaceRange(s, start, end);
            }
            keysArea.replaceRange(s, start, end);
        } catch (BadLocationException ex) {
            System.err.println("ERROR : " + ex);
        }
    }//GEN-LAST:event_undoBtnActionPerformed

    private void timesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timesKeyTyped
        int key = (int) evt.getKeyChar();
        //System.out.println(evt.getKeyChar());
        if (key == 10) {
            MainPanelGetRequest();
        } else if ((key < (int) '0' || key > (int) '9') && key != 8 && key != 127) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "ניתן לרשום רק מספרים", "שגיאה", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_timesKeyTyped

    private void mainPanelGetRequestAfterButtonPress(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainPanelGetRequestAfterButtonPress
        MainPanelGetRequest();
    }//GEN-LAST:event_mainPanelGetRequestAfterButtonPress

    private void setMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setMouseEntered
        MainPanelGetRequest();
    }//GEN-LAST:event_setMouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(this, helpPanel);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        GO.set(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void timesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timesKeyPressed
        if (evt.isControlDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_timesKeyPressed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        int w = evt.getComponent().getWidth();
        int h = evt.getComponent().getHeight();
        if (w < 400) {
            w = 400;
        }
        if (h < 300) {
            h = 300;
        }
        setSize(w, h);
    }//GEN-LAST:event_formComponentResized

    private void multiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiBtnActionPerformed

        final JTextField tf = new JTextField("1", 10);
        tf.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e); //To change body of generated methods, choose Tools | Templates.
                e.getComponent().requestFocusInWindow();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                super.componentMoved(e); //To change body of generated methods, choose Tools | Templates.
                e.getComponent().requestFocusInWindow();
            }

        });
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) || e.isControlDown() || e.isShiftDown() || e.isAltDown()) {
                    e.consume();
                }
            }
        });
        JOptionPane.showMessageDialog(this, tf, "הכנס מספר כפילויות", JOptionPane.QUESTION_MESSAGE);
        int m = 1;
        try {
            m = Integer.parseInt(tf.getText().trim());
        } catch (NumberFormatException e) {
            //JOptionPane.showMessageDialog(this, "שגיאה", null, JOptionPane.ERROR_MESSAGE);
        }
        tabPane.getCurrentTextArea().append(String.format("(%d)", m));
    }//GEN-LAST:event_multiBtnActionPerformed

    private void tabPaneComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tabPaneComponentAdded
        if (tabPane.getSelectedIndex() != tabPane.getTabCount() - 1) {
            updateState();
        }
    }//GEN-LAST:event_tabPaneComponentAdded

    private void tabPaneComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tabPaneComponentRemoved
        if (tabPane.getSelectedIndex() != tabPane.getTabCount() - 1) {
            updateState();
        }
    }//GEN-LAST:event_tabPaneComponentRemoved

    private int heb2eng(int heb) {
        System.out.println("heb2eng : " + String.valueOf(heb));
        char[] letters = {'T', 'C', 'D', 'S', 'V', 'U', 'Z', 'J', 'T', 'H', 'L', 'F', 'K',
            'O', 'N', 'I', 'B', 'X', 'G', ':', 'P', '<', 'M', 'E', 'R', 'A', '>'};
        char letter = letters[heb - 'א'];
        return (int) letter;
    }

    private void robotMyKey(String[] keys) throws AWTException {
        Robot robot = new Robot();
        robot.setAutoDelay(10);
        for (String key : keys) {
            String[] s = key.trim().split("[()]");
            int key2press = text2key.get(s[0]);
            if (s.length > 1) {
                int m = Integer.parseInt(s[1]);
                for (int i = 0; i < m; i++) {
                    robot.keyPress(key2press);
                    robot.keyRelease(key2press);
                }
            } else {
                robot.keyPress(text2key.get(key.trim()));
            }
        }
        for (String key : keys) {
            String[] s = key.trim().split("[()]");
            if (s.length == 1) {
                robot.keyRelease(text2key.get(key.trim()));
            }
        }
    }

    private void MainPanelGetRequest() {
        MainPanel.requestFocusInWindow();
    }

    private Image createImage(String path, String description) {
        URL imageURL = MainApp.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }

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
            java.util.logging.Logger.getLogger(MainApp.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }

    private final Map<String, Integer> text2key;
    private final String WAIT = "המתנה";
    private final AtomicBoolean GO;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel currentState;
    private javax.swing.JPanel helpPanel;
    private javax.swing.JList<String> itemList;
    private javax.swing.JScrollPane itemsScrollPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton multiBtn;
    private javax.swing.JPanel ready;
    private javax.swing.JLabel repaet;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton runBtn;
    private javax.swing.JPanel set;
    private final tltk.production.app.PressForMeTabPane tabPane = getTabbedPane();
    private javax.swing.JTextField times;
    private javax.swing.JButton undoBtn;
    // End of variables declaration//GEN-END:variables

    private PressForMeTabPane getTabbedPane() {
        File f = FileHandler.getFile();
        PressForMeTabPane tabbed = new PressForMeTabPane(this);
        if (f.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));) {
                HashMap<String, String> allTab = (HashMap<String, String>) in.readObject();
                if (allTab != null) {
                    tabbed.updateFromOther(allTab);
                }
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("e " + e.getMessage());
            }
        }
        return tabbed;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        updateState();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateState();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateState();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateState();
    }

    private void updateState() {
        JTextArea keysArea = tabPane.getCurrentTextArea();
        if (keysArea == null) {
            return;
        }

        if (keysArea.getText().length() == 0) {
            runBtn.setEnabled(false);
            undoBtn.setEnabled(false);
        } else {
            runBtn.setEnabled(true);
            undoBtn.setEnabled(true);
        }

        int l = keysArea.getLineCount() - 1;
        String s = "";
        try {
            s = getLine(l);
        } catch (BadLocationException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

        String[] p = s.split("[+]");
        s = p[p.length - 1];
        if (s.length() > 0 && text2key.containsKey(s.trim())) {
            multiBtn.setEnabled(true);
        } else {
            multiBtn.setEnabled(false);
        }
    }

    private String getLine(int line) throws BadLocationException {
        JTextArea ta = tabPane.getCurrentTextArea();
        return ta.getText().substring(ta.getLineStartOffset(line), ta.getLineEndOffset(line));
    }
}
