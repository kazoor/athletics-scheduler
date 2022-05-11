package ClientSocket;

import java.net.*;
import java.io.*;

public class ClientSocket {
    private Socket m_Socket = null;
    private String m_Address = null;
    private int m_Port = 0;

    // Boolean that can stop the
    private final boolean m_Stop = false;
    
    // Data streams.
    private DataInputStream m_DataInputStream = null;

    private DataOutputStream m_DataOutputStream = null;

    public ClientSocket(String Address, int Port) {
        this.m_Address = Address;
        this.m_Port = Port;
    }

    // Since we cant access the m_Socket variable outside the class,
    // this is a way to tell if the socket is connected or not.
    public boolean IsConnected() {
        return m_Socket.isConnected();
    }

    public void CloseConnecion() throws IOException {
        m_Socket.close();
    }

    private void SetDataInputStream(InputStream stream) {
        m_DataInputStream = new DataInputStream(stream);
    }

    private void SetDataOutputStream(OutputStream stream) {
        m_DataOutputStream = new DataOutputStream(stream);
    }

    // the socket will be able to send a message at any time as m_DataOutPutstream is valid.
    public void Send(String message) {
        if (m_DataOutputStream == null)
            return;

        try {
            m_DataOutputStream.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // the socket will be able to read a message at any time as m_DataInputPutstream is valid
    public String ReadString() {
        if(m_DataInputStream != null) {
            try {
                return m_DataInputStream.readUTF();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public void Run() {
        System.out.println("Attempting to connect to " + m_Address + ":" + m_Port);
        try {
            m_Socket = new Socket(this.m_Address, this.m_Port);

            if (IsConnected()) {
                System.out.println("Successfully connected to " + m_Socket.getRemoteSocketAddress());

                SetDataInputStream(m_Socket.getInputStream());
                SetDataOutputStream(m_Socket.getOutputStream());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
