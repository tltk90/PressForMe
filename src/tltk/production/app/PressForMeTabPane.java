package tltk.production.app;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.HashMap;
import java.util.function.BiConsumer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Tzahi Levi
 */
public class PressForMeTabPane extends JTabbedPane implements Serializable {

    private final DocumentListener dl;

    public PressForMeTabPane(DocumentListener documentlistener) {
        super();
        initilizeTabPane();
        listenToClick();
        dl = documentlistener;

    }

    public void updateFromOther(HashMap<String, String> tabPane) {

        tabPane.forEach(new BiConsumer<String, String>() {
            int index = 0;

            @Override
            public void accept(String t, String u) {
                addTabToPane(t, index++, u);
            }
        });
    }

    public JTextArea getCurrentTextArea() {
        JScrollPane scroll = (JScrollPane) getSelectedComponent();
        JTextArea ta = (JTextArea) scroll.getViewport().getComponent(0);
        return ta;
    }

    public HashMap<String, String> getTabCompoments() {
        HashMap<String, String> comps = new HashMap<>();
        for (int i = 0; i < getTabCount() - 1; i++) {
            Component c = getTabComponentAt(i);

            String s = null;
            for (Component c2 : ((JPanel) c).getComponents()) {
                if (c2 instanceof JLabel) {
                    s = ((JLabel) c2).getText();
                }
            }
            setSelectedIndex(i);

            if (s != null) {
                comps.put(s, getCurrentTextArea().getText());
            }
        }
        return comps;
    }

    private void addTabToPane(String title, int index) {
        JScrollPane scroll = createTabArea();
        JPanel panel = createTabCompoment(title);
        insertTab(title, null, scroll, title, index);
        setTabComponentAt(index, panel);
        setSelectedIndex(index);
        getCurrentTextArea().setEnabled(true);
        
    }

    private void addTabToPane(String title, int index, String text) {
        addTabToPane(title, index);
        try{
            getCurrentTextArea().setText(text);
        }catch(NullPointerException e){}
    }

    private void initilizeTabPane() {
        JTextArea jTextPane1 = new JTextArea();
        JScrollPane jScrollPane1 = new JScrollPane();
        jTextPane1.setEditable(false);
        jTextPane1.setEnabled(false);
        jScrollPane1.setViewportView(jTextPane1);
        addTab("+", jScrollPane1);
    }

    private void listenToClick() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final int last = getTabCount() - 1;
                if (getSelectedIndex() == last) {
                    String name = JOptionPane.showInputDialog(null, "הכנס שם לצירוף: ");
                    if (name != null) {
                        addTabToPane(name, last);
                    }
                }
            }

        });
    }


    private JScrollPane createTabArea() {
        JTextArea t = new JTextArea();
        t.setEditable(false);
        t.getDocument().addDocumentListener(dl);
        javax.swing.JScrollPane js = new javax.swing.JScrollPane();
        js.setViewportView(t);
        return js;
    }

    private JPanel createTabCompoment(String s) {
        JPanel p = new JPanel(new GridBagLayout());
        p.setOpaque(false);
        final JLabel label = new JLabel(s);
        final JButton btn = new JButton("X");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        p.add(label, gbc);

        gbc.gridx++;
        gbc.weightx = 0;
        p.add(btn, gbc);
        btn.addActionListener(new CloseTabListner(s));
        return p;
    }

    class CloseTabListner implements ActionListener {

        private final String name;

        public CloseTabListner(String n) {
            name = n;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int index = indexOfTab(name);
            if (index >= 0) {
                JPanel p = (JPanel) getTabComponentAt(index);
                for (Component c : p.getComponents()) {
                    if (c instanceof JButton) {
                        ((JButton) c).removeActionListener(((JButton) c).getActionListeners()[0]);
                    }
                }
                removeTabAt(index);
            }
        }

    }

}
