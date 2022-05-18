package ServerSock;

import java.io.*;
import java.net.*;

public class ServerSock {
    private Socket m_Socket = null;

    private ServerSocket m_ServerSocket = null;

    private int m_Port = 0;

    // Data streams.
    private DataInputStream m_DataInputStream = null;
    private DataOutputStream m_DataOutputStream = null;

    public ServerSock(int Port) {
        this.m_Port = Port;
    }

    // Since we cant access the m_Socket variable outside the class,
    // this is a way to tell if the socket is connected or not.
    public boolean IsConnected() {
        return m_Socket.isConnected();
    }

    public void CloseConnecion() throws IOException {
        m_Socket.close();
        m_DataInputStream = null;
        m_DataOutputStream = null;
    }

    private void SetDataInputStream(InputStream stream) {
        m_DataInputStream = new DataInputStream(stream);
    }

    private void SetDataOutputStream(OutputStream stream) {
        m_DataOutputStream = new DataOutputStream(stream);
    }

    // the socket is be able to send a message at any time as m_DataOutPutstream is valid.
    public void Send(String message) {
        try {
            assert m_DataOutputStream != null;
            m_DataOutputStream.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // the socket is be able to read a message at any time as m_DataInputPutstream is valid
    public String ReadString() {
        try {
            assert m_DataInputStream != null;
            return m_DataInputStream.readUTF();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Function to start the main loop of the socket, will keep on running until the close function is called.
    public void Run() {
        System.out.println("Attempting to start server on port " + m_Port);
        try {
            m_ServerSocket = new ServerSocket(this.m_Port);
            System.out.println("Waiting for connections on:  " + m_Port);

            m_Socket = m_ServerSocket.accept();
            System.out.println("Client connected!");

            SetDataInputStream(m_Socket.getInputStream());
            SetDataOutputStream(m_Socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
