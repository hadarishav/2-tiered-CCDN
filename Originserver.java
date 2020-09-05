/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minifinal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Sohi
 */
public class Originserver extends javax.swing.JFrame {

    int p,size;
    String filename;
    File f;
    /**
     * Creates new form Originserver
     */
    public Originserver() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        chunksize = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        start = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        fname = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Central Node");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Origin System For Video Streaming");

        jButton1.setText("Choose File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        chunksize.setText("1000");
        chunksize.setToolTipText("");

        jLabel2.setText("Chunk Size(>=1000KB)");

        start.setText("Start");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Chunk Id", "Cache Server Id", "File Name", "Remaning chunks"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(115, 115, 115))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chunksize, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(start))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel1)))
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chunksize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(start)))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser ch=new JFileChooser();
        ch.showOpenDialog(null);
        File f= ch.getSelectedFile();
        String fname1=f.getAbsolutePath();
        fname.setText(fname1);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        
        //sohi insert here
        transferfile tx= new transferfile();
        try {     
            tx.cfile();
        } catch (Exception ex) {
            Logger.getLogger(Originserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServerSocket soc=null;
        try {
            soc = new ServerSocket(5217);
        } catch (IOException ex) {
            Logger.getLogger(Originserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("FTP Server Started on Port Number 5217");
        Responder h = new Responder();
        while(true)
        {
            System.out.println("Waiting for Connection ...");
             try {
                 Socket ss=soc.accept();
                 transferfile t=new transferfile(ss);
                 Thread th = new Thread(new MyServer(h,ss));
             } catch (IOException ex) {
                 Logger.getLogger(Originserver.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }
        
        
    }//GEN-LAST:event_startActionPerformed
//*************************************************************************************************************


class chunking
{
    public ArrayList<String> readAndFragment ( String SourceFileName, int CHUNK_SIZE ) throws IOException
 {
  System.out.println("File Is Reading "+ SourceFileName );
  File willBeRead = new File (SourceFileName);
  int FILE_SIZE = (int) willBeRead.length();
  ArrayList<String> nameList = new ArrayList<String> ();
  System.out.println("Total File Size: "+FILE_SIZE);
  
  int NUMBER_OF_CHUNKS = 0;
  byte[] temporary = null;
  
  try {
   InputStream inStream = null;
   int totalBytesRead = 0;
   
   try {
    inStream = new BufferedInputStream ( new FileInputStream( willBeRead ));
    
    while ( totalBytesRead < FILE_SIZE )
    {
     String PART_NAME ="data"+NUMBER_OF_CHUNKS+".mp4";
     int bytesRemaining = FILE_SIZE-totalBytesRead;
     if ( bytesRemaining < CHUNK_SIZE ) // Remaining Data Part is Smaller Than CHUNK_SIZE
               // CHUNK_SIZE is assigned to remain volume
     {
      CHUNK_SIZE = bytesRemaining;
      System.out.println("CHUNK_SIZE: "+CHUNK_SIZE);
     }
     temporary = new byte[CHUNK_SIZE]; //Temporary Byte Array
     int bytesRead = inStream.read(temporary, 0, CHUNK_SIZE);
     
     if ( bytesRead > 0) // If bytes read is not empty
     {
      totalBytesRead += bytesRead;
      NUMBER_OF_CHUNKS++;
     }
     
     write(temporary,PART_NAME);
     nameList.add(PART_NAME);
     System.out.println("Total Bytes Read: "+totalBytesRead);
     
    }
    
   }
   finally {
    inStream.close();
   }
  }
  catch (FileNotFoundException ex)
  {
   ex.printStackTrace();
  }
  catch (IOException ex)
  {
   ex.printStackTrace();
  }
  return nameList;
 }
 
 void write(byte[] DataByteArray, String DestinationFileName){
    try {
      OutputStream output = null;
      try {
        output = new BufferedOutputStream(new FileOutputStream(DestinationFileName));
        output.write( DataByteArray );
        System.out.println("Writing Process Was Performed");
      }
      finally {
        output.close();
      }
    }
    catch(FileNotFoundException ex){
     ex.printStackTrace();
    }
    catch(IOException ex){
     ex.printStackTrace();
    }
 }
 
 public void mergeParts ( ArrayList<String> nameList, String DESTINATION_PATH )
 {
  File[] file = new File[nameList.size()];
  byte AllFilesContent[] = null;
  
  int TOTAL_SIZE = 0;
  int FILE_NUMBER = nameList.size();
  int FILE_LENGTH = 0;
  int CURRENT_LENGTH=0;
  
  for ( int i=0; i<FILE_NUMBER; i++)
  {
   file[i] = new File (nameList.get(i));
   TOTAL_SIZE+=file[i].length();
  }
  
  try {
   AllFilesContent= new byte[TOTAL_SIZE]; // Length of All Files, Total Size
   InputStream inStream = null;
   
   for ( int j=0; j<FILE_NUMBER; j++)
   {
    inStream = new BufferedInputStream ( new FileInputStream( file[j] ));
    FILE_LENGTH = (int) file[j].length();
    inStream.read(AllFilesContent, CURRENT_LENGTH, FILE_LENGTH);
    CURRENT_LENGTH+=FILE_LENGTH;
    inStream.close();
   }
   
  }
  catch (FileNotFoundException e)
  {
   System.out.println("File not found " + e);
  }
  catch (IOException ioe)
  {
   System.out.println("Exception while reading the file " + ioe);
  }
  finally 
  {
   write (AllFilesContent,DESTINATION_PATH);
  }
  
  System.out.println("Merge was executed successfully.!");
  
 }
}
class Responder {
 
    String serverSentence;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // on client process termination or
     // client sends EXIT then to return false to close connection
     // else return true to keep connection alive
     // and continue conversation
    synchronized public boolean responderMethod(Socket connectionSocket) {
    try 
    {
        BufferedReader inFromClient =  new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        DataOutputStream outToClient =new DataOutputStream(connectionSocket.getOutputStream());
        String clientSentence = inFromClient.readLine();
        // if client process terminates it get null, so close connection
        if (clientSentence == null || clientSentence.equals("EXIT")) {
         return false;
         }
        if (clientSentence != null) {
         System.out.println("client : " + clientSentence);
         }
        serverSentence = br.readLine() + "\n";
        outToClient.writeBytes(serverSentence);
        return true;
    } 
    catch (SocketException e) {
         System.out.println("Disconnected");
        return false;
     } catch (Exception e) {
     e.printStackTrace();
     return false;
     }
 }
}
class MyServer implements Runnable {
 
    Responder h;
    Socket connectionSocket;

    public MyServer(Responder h, Socket connectionSocket) {
        this.h = h;
        this.connectionSocket = connectionSocket;
    }
    @Override
    public void run() {

    while (h.responderMethod(connectionSocket)) {
        try {
        // once an conversation with one client done,give chance to other threads so make this thread sleep
            Thread.sleep(1);
        } catch (InterruptedException ex) {
        ex.printStackTrace();
        }
     }

    try {
        connectionSocket.close();
     } catch (IOException ex) {
     //Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
     }

    }

    }
class transferfile extends Thread
{
    Socket ClientSoc;

    DataInputStream din;
    DataOutputStream dout;
    
    transferfile(Socket soc)
    {
        try
        {
            ClientSoc=soc;                        
            din=new DataInputStream(ClientSoc.getInputStream());
            dout=new DataOutputStream(ClientSoc.getOutputStream());
            System.out.println("FTP Client Connected ...");
            start();
            
        }
        catch(Exception ex)
        {
        }        
    }
    transferfile()
    {
        
    }
    void cfile() throws Exception
    {
        String wfilename=fname.getText();
        System.out.println("Old name: "+wfilename);
        filename = wfilename.replace("\\","\\\\");
        System.out.println("New name:"+filename);
        chunking b= new chunking();
        ArrayList a1=new ArrayList();
        p=Integer.parseInt(chunksize.getText());
        a1=b.readAndFragment(filename,(1000*p));
        f=new File(filename);
        double bytes=f.length();
        size=(int)bytes/(1000*p);
    }
    void SendFile() throws Exception
    {        
        
        //FileNameUtils.separatorsToSystem(filename);
        
        dout.writeUTF(filename);
        int i=0;
        //dout.writeUTF(filename); //sending the file name to the client
        System.out.println("Stage 1");
        System.out.println(f.exists());
        if(!f.exists())
        {
            System.out.println("File not found!!!!!!!");
            dout.writeUTF("File Not Found");
            return;
        }
        System.out.println("Here!");
        dout.writeUTF("READY");
        FileInputStream fin=new FileInputStream(f);
//************************************************************************************************
        System.out.println("Size:"+size);
        dout.writeUTF(Integer.toString(size));
//*************************************************************************************************
            int j=0;
            String name;
            for(j=0;j<size+1;j++)                      //correct this later, use ceil
            {
                name="data"+j+".mp4";
                File sf=new File(name);
                FileInputStream in=new FileInputStream(sf);
                if(!sf.exists())
                {
                    dout.writeUTF("File Not Found");
                    System.out.println("File not found");
                    return;
                }
                else
                {
                    //dout.writeUTF("READY");

                    int ch;
                    do
                    {
                        ch=in.read();
                        dout.writeUTF(String.valueOf(ch));
                    }
                    while(ch!=-1);    
                    in.close();    
                    //dout.writeUTF("File Received Successfully");
                }
            }
            System.out.println("I am out here!");
            
            //JOptionPane.showConfirmDialog(null, "Do you want to stop server?");
    }
    
    public void run()
    {
        
            try
            {
            System.out.println("Waiting for Command ...");
            System.out.println("\tGET Command Received ...");
            SendFile();
            }
            catch(Exception ex)
            {
            }
        
    }
    
}//***************************************************************************************************


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
            java.util.logging.Logger.getLogger(Originserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Originserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Originserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Originserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Originserver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField chunksize;
    private javax.swing.JTextField fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton start;
    // End of variables declaration//GEN-END:variables
}
