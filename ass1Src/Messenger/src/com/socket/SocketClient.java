package com.socket;

import com.ui.LoginFrame;
import com.ui.ChatFrame;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;


public class SocketClient implements Runnable{
    
    public int port;
    public String serverAddr;
    public Socket socket;
    public LoginFrame ui_login;
    public ChatFrame ui_chat;
    public ObjectInputStream In;
    public ObjectOutputStream Out;
    
    public SocketClient(LoginFrame frame) throws IOException{
        ui_login = frame;
        this.serverAddr = ui_login.serverAddr;
        this.port = ui_login.port;
        InetAddress a=InetAddress.getByName(serverAddr);
        socket = new Socket(a, port);
        Out = new ObjectOutputStream(socket.getOutputStream());
        Out.flush();
        In = new ObjectInputStream(socket.getInputStream());
    }
    
    @Override
    public void run(){
        boolean keepRunning = true;
        while(keepRunning){
            try {
                Message msg = (Message) In.readObject();
                System.out.println("Incoming : "+msg.toString());
                
                if(msg.type.equals("message")){
                    if(msg.recipient.equals(ui_chat.username)){
                        StringBuffer  s1 = new StringBuffer ("");
                        s1.append("["+msg.sender +" -> Me] : ");
            
                        ui_chat.jTextChatroom.append(s1 + msg.content + "\n");
                    }
                    else{
                        ui_chat.jTextChatroom.append("["+ msg.sender +" -> "+ msg.recipient +"] : " + msg.content + "\n");
                    }
                }
                else if(msg.type.equals("login")){
                    if(msg.content.equals("TRUE")){
                        ui_login.setVisible(false);
                        ui_chat = new ChatFrame(this);
                    }
                    else{
                        ui_login.loginFail(0);
                    }
                }
                else if(msg.type.equals("test")){
                }
                else if(msg.type.equals("newuser")){
                    if(!msg.content.equals(ui_login.username)){
                        boolean exists = false;
                        for(int i = 0; i < ui_chat.model.getSize(); i++){
                            if(ui_chat.model.getElementAt(i).equals(msg.content)){
                                exists = true;
                                break;
                            }
                        }
                        if(!exists){ ui_chat.model.addElement(msg.content); }
                    }
                }
                else if(msg.type.equals("signup")){
                    if(msg.content.equals("TRUE")){
                        
                    }
                    else{
                        ui_login.loginFail(1);
                    }
                }
                else if(msg.type.equals("signout")){
                    if(msg.content.equals(ui_login.username)){
                        ui_chat.jTextChatroom.append("["+ msg.sender +" -> Me] : Bye\n");
                        
                        for(int i = 1; i < ui_chat.model.size(); i++){
                            ui_chat.model.removeElementAt(i);
                        }
                        ui_chat.dispose();
                        ui_login.setVisible(true);
                    }
                    else{
                        ui_chat.model.removeElement(msg.content);
                        ui_chat.jTextChatroom.append("["+ msg.sender +" -> All] : "+ msg.content +" has signed out\n");
                    }
                }
                else if(msg.type.equals("upload_req")){
                    
                    if(JOptionPane.showConfirmDialog(ui_login, ("Accept '"+msg.content+"' from "+msg.sender+" ?")) == 0){
                        
                        JFileChooser jf = new JFileChooser();
                        jf.setSelectedFile(new File(msg.content));
                        int returnVal = jf.showSaveDialog(ui_login);
                        
                        String saveTo = jf.getSelectedFile().getPath();
                        if(saveTo != null && returnVal == JFileChooser.APPROVE_OPTION){
                            Download dwn = new Download(saveTo, ui_chat);
                            Thread t = new Thread(dwn);
                            t.start();
                            send(new Message("upload_res", ui_login.username, (""+dwn.port), msg.sender));
                        }
                        else{
                            send(new Message("upload_res", ui_login.username, "NO", msg.sender));
                        }
                    }
                    else{
                        send(new Message("upload_res", ui_login.username, "NO", msg.sender));
                    }
                }
                else if(msg.type.equals("upload_res")){
                    if(!msg.content.equals("NO")){
                        int port  = Integer.parseInt(msg.content);
                        String addr = msg.sender;
                        
                        ui_chat.jButtonFile.setEnabled(false);
                        try{
                            Upload upl = new Upload(addr, port, ui_chat.file, ui_chat);
                            Thread t = new Thread(upl);
                            t.start();
                        }
                        catch (Exception ex){
                            ui_chat.jTextChatroom.append("[Application -> Me] : Upload file Failure\n");
                        }
                        finally{
                            ui_chat.jButtonFile.setEnabled(true);
                            ui_chat.file = null;
                        }
                    }
                    else{
                        ui_chat.jTextChatroom.append("[SERVER -> Me] : "+msg.sender+" rejected file request\n");
                    }
                }
                else{
                    ui_chat.jTextChatroom.append("[SERVER -> Me] : Unknown message type\n");
                }
            }
            catch(Exception ex) {
                keepRunning = false;
                ui_chat.jTextChatroom.append("[Application -> Me] : Connection Failure\n");
                ui_chat.jButtonSend.setEnabled(false);
                ui_chat.jButtonFile.setEnabled(false);
                
                for(int i = 1; i < ui_chat.model.size(); i++){
                    ui_chat.model.removeElementAt(i);
                }
                
                ui_login.clientThread.stop();
                
                System.out.println("Exception SocketClient run()");
                ex.printStackTrace();
            }
        }
    }
    
    public void send(Message msg){
        try {
            Out.writeObject(msg);
            Out.flush();
            System.out.println("Outgoing : "+msg.toString());
        }
        catch (IOException ex) {
            System.out.println("Exception SocketClient send()");
        }
    }
    
    public void closeThread(Thread t){
        t = null;
    }
}
