package gui2;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.Observer;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements Listeners {

    private AbouteFrame a = new AbouteFrame();
    public MainFrame() {
        Models m = new Models();
        cont = new Controllers(m);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();

        Refresh = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        Number = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        Exit = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        About = new javax.swing.JMenuItem();

        Field1 = new Fielde() {
            @Override
            public void update(Models m) {
                Field1.setText(((Models) m).getRub());
            }
        };
        Field2 = new Fielde() {
            @Override
            public void update(Models m) {
                Field2.setText(((Models) m).getDol());
            }
        };
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Field1.setText("");
        Field1.setEditable(false);
        Field2.setText("");
        Field2.setEditable(false);
        cont.register(Field1);
        cont.register(Field2);

        Refresh.setText("Обновить");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"RUB", "DOL"}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        Number.setText("значение");
        Number.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NumberKeyPressed(evt);
            }
        });

        File.setText("File");
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        File.add(Exit);

        jMenuBar1.add(File);

        Help.setText("Help");
        Help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpActionPerformed(evt);
            }
        });

        About.setText("About");
        About.setToolTipText("");
        Help.add(About);

        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(Field1)
                .addGap(218, 218, 218)
                .addComponent(Field2))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Refresh))
                .addGroup(layout.createSequentialGroup()
                .addComponent(Number)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(275, 275, 275)))
                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(142, 142, 142)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(Refresh)
                .addContainerGap()));

        pack();
    }

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void HelpActionPerformed(java.awt.event.ActionEvent evt) {
        a.setVisible(true);
    }

    private void NumberKeyPressed(java.awt.event.KeyEvent evt) {
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            String Snum = Number.getText();
            try {
                double num = Double.parseDouble(Snum);
                cont.changeisMade((String) jComboBox1.getSelectedItem(), Snum);
            } catch (NumberFormatException e) {
                error();
            }
        }
    }

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            begining();
            String Snum = Number.getText();
            try {
                double num = Double.parseDouble(Snum);
                cont.changeisMade((String) jComboBox1.getSelectedItem(), Snum);
            } catch (NumberFormatException e) {
                error();
            }
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        String Snum = Number.getText();
        try {
            double num = Double.parseDouble(Snum);
            cont.changeisMade((String) jComboBox1.getSelectedItem(), Snum);

        } catch (NumberFormatException e) {
            error();
        }
    }

    public void error() {
       /* final JFrame form2 = new JFrame("form2");
        form2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form2.setSize(350, 150);
        form2.setResizable(false);
        form2.setVisible(true);
        JTextField text = new JTextField("Ошибка при чтении");
        text.setBounds(0, 0, 350, 30);
        form2.add(text);
        JButton ex = new JButton("ОК");
        ex.setLocation(100, 50);
        ex.setSize(150, 40);
        form2.add(ex);

        ex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                form2.setVisible(false);
            }
        });*/
        error.settext(" ");
        error.setVisible(true);
        
    }
    
    public void HELP(ActionEvent evt) {
        a.setVisible(true);
    }

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    private Controllers cont;
    private javax.swing.JMenuItem About;
    private javax.swing.JMenuItem Exit;
    private Fielde Field1;
    private Fielde Field2;
    private javax.swing.JMenu File;
    private javax.swing.JMenu Help;
    private javax.swing.JTextField Number;
    private javax.swing.JButton Refresh;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JList jList2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private SendFrame send = new SendFrame();
    private Send sende = new Send();
    private ErrorFrame error = new ErrorFrame(); 
    @Override
    public void finished(boolean success) {
        Refresh.setEnabled(true);
        send.setVisible(false);
    }
    @Override
    public void begining() {
        Refresh.setEnabled(false);
        send.setVisible(true);
        send.setLocationRelativeTo(send);
        sende.sending(this);
    }
}
