package SmasherClient;

import javax.management.ObjectInstance;
import java.io.*;
import java.net.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.PublicKey;

public class Client {
    private Socket socket = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private final int port;

    public Client(int port){
        this.port = port;
        try{
            socket = new Socket("localhost", port);
            System.out.println("Client start!");
            System.out.println("Sever-Client are connected!");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

        }catch(IOException e)
        {
            System.out.println("Connection Error!");
        }

    }

    public void sendPuzzle(int[][] board){
        try {
            ObjectOutputStream obj_out= new ObjectOutputStream(socket.getOutputStream());
            obj_out.writeObject(board);
        }catch (IOException e)  {System.out.println(e);}
    }

    public void sendInput(String lines){
        // send input to server
        try {
            out.writeUTF(lines);
        }catch(IOException e) {
            System.out.println("Sending Error");
        }

    }

    public int[][] getPuzzle()
    {
        int[][] board = new int[9][9];
        try {
            ObjectInputStream obj_in = new ObjectInputStream(socket.getInputStream());

            board = (int[][]) obj_in.readObject();

        }catch (IOException e){System.out.println(e);}
        catch (ClassNotFoundException e) {e.printStackTrace();}
        return board;
    }

    public String receiveSolver(){
        String line = "";
        try{
            line = new String(in.readUTF());
        }catch(IOException e){
            System.out.println("Client can not receive message!");
            System.exit(0);
        }
        return line;
    }
    public void setSocket(){
        try {
            socket = new Socket("localhost", port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
