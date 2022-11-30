package com.ui;

import com.socket.Message;
import com.socket.SocketClient;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Color;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;


public class LoginFrame extends javax.swing.JFrame {

    public SocketClient client;
    public int port;
    public String serverAddr, username, password;
    public Thread clientThread;
    
    public LoginFrame() {
        initComponents();
        this.setTitle("Login");
        jLabelAllert.setVisible(false);

        this.addWindowListener(new WindowListener() {
            @Override public void windowOpened(WindowEvent e) {}
            @Override public void windowClosing(WindowEvent e) {try{clientThread.stop();} catch (Exception ex){}}
            @Override public void windowClosed(WindowEvent e) {}
            @Override public void windowIconified(WindowEvent e) {}
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) {}
            @Override public void windowDeactivated(WindowEvent e) {}
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPassword = new javax.swing.JPasswordField();
        jTextUsername = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jButtonSignup = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextHost = new javax.swing.JTextField();
        jLabelAllert = new javax.swing.JLabel();
        jTextPort = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonConnect = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(186, 79, 84));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPassword.setBackground(new java.awt.Color(186, 79, 84));
        jPassword.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jPassword.setForeground(new java.awt.Color(187, 187, 187));
        jPassword.setText("password");
        jPassword.setBorder(null);
        jPassword.setNextFocusableComponent(jButtonLogin);
        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });
        jPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordKeyTyped(evt);
            }
        });

        jTextUsername.setBackground(new java.awt.Color(186, 79, 84));
        jTextUsername.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jTextUsername.setForeground(new java.awt.Color(187, 187, 187));
        jTextUsername.setText("Username");
        jTextUsername.setBorder(null);
        jTextUsername.setNextFocusableComponent(jPassword);
        jTextUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextUsernameActionPerformed(evt);
            }
        });
        jTextUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextUsernameKeyTyped(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setForeground(new java.awt.Color(187, 187, 187));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ui/icons8-user-20.png"))); // NOI18N

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setForeground(new java.awt.Color(187, 187, 187));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ui/icons8-lock-20.png"))); // NOI18N

        jButtonLogin.setBackground(new java.awt.Color(186, 79, 84));
        jButtonLogin.setForeground(new java.awt.Color(187, 187, 187));
        jButtonLogin.setText("Login");
        jButtonLogin.setFocusCycleRoot(true);
        jButtonLogin.setNextFocusableComponent(jButtonSignup);
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jButtonSignup.setBackground(new java.awt.Color(186, 79, 84));
        jButtonSignup.setForeground(new java.awt.Color(187, 187, 187));
        jButtonSignup.setText("SignUp");
        jButtonSignup.setNextFocusableComponent(jTextHost);
        jButtonSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSignupActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 153));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ui/icons8-messages-60.png"))); // NOI18N
        jLabel5.setText(" MESSENGER");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPassword)
                            .addComponent(jTextUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLogin)
                    .addComponent(jButtonSignup))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(74, 31, 61));
        jPanel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(186, 79, 84));
        jLabel1.setText("Host Address ");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ui/icons8-earth-globe-95 (1).png"))); // NOI18N

        jTextHost.setBackground(new java.awt.Color(74, 31, 61));
        jTextHost.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jTextHost.setForeground(new java.awt.Color(187, 187, 187));
        jTextHost.setText("localhost");
        jTextHost.setNextFocusableComponent(jTextPort);
        jTextHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextHostActionPerformed(evt);
            }
        });
        jTextHost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextHostKeyTyped(evt);
            }
        });

        jLabelAllert.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAllert.setForeground(java.awt.Color.red);
        jLabelAllert.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAllert.setText("jLabelAllert");

        jTextPort.setBackground(new java.awt.Color(74, 31, 61));
        jTextPort.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jTextPort.setForeground(new java.awt.Color(187, 187, 187));
        jTextPort.setText("13000");
        jTextPort.setNextFocusableComponent(jButtonConnect);
        jTextPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPortActionPerformed(evt);
            }
        });
        jTextPort.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPortKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(186, 79, 84));
        jLabel2.setText("Host Port ");

        jButtonConnect.setBackground(new java.awt.Color(74, 31, 61));
        jButtonConnect.setForeground(new java.awt.Color(187, 187, 187));
        jButtonConnect.setText("Connect");
        jButtonConnect.setNextFocusableComponent(jTextUsername);
        jButtonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextHost, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(31, 31, 31)
                                .addComponent(jTextPort))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAllert))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel8)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jButtonConnect)
                .addGap(18, 18, 18)
                .addComponent(jLabelAllert)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonConnect.getAccessibleContext().setAccessibleParent(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnectActionPerformed
        serverAddr = jTextHost.getText();
        port = Integer.parseInt(jTextPort.getText());
        if(!serverAddr.isEmpty() && !jTextPort.getText().isEmpty()){
            try{
                if (client == null) client = new SocketClient(this);
                if (clientThread == null) {
                    clientThread = new Thread(client);
                    clientThread.start();
                }                
                client.send(new Message("test", "testUser", "testContent", "SERVER"));
                jLabelAllert.setVisible(true);
                jLabelAllert.setText("Server OK");
                jLabelAllert.setForeground(Color.GREEN.darker());
            }
            catch(Exception ex){
                jLabelAllert.setVisible(true);
                jLabelAllert.setForeground(Color.RED);
                jLabelAllert.setText("Server not found");
            }
        }
    }//GEN-LAST:event_jButtonConnectActionPerformed
    public void loginFail(int n){
        if (n==0) jLabelAllert.setText("Login Failed");
        else if (n==1) jLabelAllert.setText("Signup Failed");
        jLabelAllert.setForeground(Color.RED);
        jLabelAllert.setVisible(true);
    }
    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        serverAddr = jTextHost.getText();
        port = Integer.parseInt(jTextPort.getText());
        if(!serverAddr.isEmpty() && !jTextPort.getText().isEmpty()){
            try{
                if (client == null) client = new SocketClient(this);
                if (clientThread == null) {
                    clientThread = new Thread(client);
                    clientThread.start();
                }
                client.send(new Message("test", "testUser", "testContent", "SERVER"));
                username = jTextUsername.getText();
                password = jPassword.getText();
                
                if(!username.isEmpty() && !password.isEmpty()){
                    try{
                        client.send(new Message("login", username, password, "SERVER"));
                        jLabelAllert.setVisible(false);
                    }
                    catch (Exception ex){
                        jLabelAllert.setVisible(true);
                        jLabelAllert.setForeground(Color.RED);
                        jLabelAllert.setText("Login Failed");
                    }
                }
            }
            catch(Exception ex){
                jLabelAllert.setVisible(true);
                jLabelAllert.setForeground(Color.RED);
                jLabelAllert.setText("Server not found");
            }
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed
    
    private void jButtonSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSignupActionPerformed
        serverAddr = jTextHost.getText();
        port = Integer.parseInt(jTextPort.getText());
        if(!serverAddr.isEmpty() && !jTextPort.getText().isEmpty()){
            try{
                if (client == null) client = new SocketClient(this);
                if (clientThread == null) {
                    clientThread = new Thread(client);
                    clientThread.start();
                }
                client.send(new Message("test", "testUser", "testContent", "SERVER"));
                username = jTextUsername.getText();
                password = jPassword.getText();
                
                if(!username.isEmpty() && !password.isEmpty()){
                    try{
                        client.send(new Message("signup", username, password, "SERVER"));
                        jLabelAllert.setVisible(false);
                    }
                    catch (Exception ex){
                        jLabelAllert.setVisible(true);
                        jLabelAllert.setForeground(Color.RED);
                        jLabelAllert.setText("Signup Failed");
                    }
                }
            }
            catch (Exception ex){
                jLabelAllert.setVisible(true);
                jLabelAllert.setForeground(Color.RED);
                jLabelAllert.setText("Server not found");
            }
        }
    }//GEN-LAST:event_jButtonSignupActionPerformed
    
    private void jTextUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextUsernameKeyTyped
        jLabelAllert.setText("");
    }//GEN-LAST:event_jTextUsernameKeyTyped

    private void jPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordKeyTyped
        jLabelAllert.setText("");
    }//GEN-LAST:event_jPasswordKeyTyped

    private void jTextHostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextHostKeyTyped
        jLabelAllert.setText("");
    }//GEN-LAST:event_jTextHostKeyTyped

    private void jTextPortKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPortKeyTyped
        jLabelAllert.setText("");
    }//GEN-LAST:event_jTextPortKeyTyped

    private void jTextUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextUsernameActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordActionPerformed

    private void jTextPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPortActionPerformed

    private void jTextHostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextHostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextHostActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch(Exception ex){
            System.out.println("Look & Feel exception");
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonConnect;
    public javax.swing.JButton jButtonLogin;
    public javax.swing.JButton jButtonSignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAllert;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPasswordField jPassword;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JTextField jTextHost;
    public javax.swing.JTextField jTextPort;
    public javax.swing.JTextField jTextUsername;
    // End of variables declaration//GEN-END:variables

}
