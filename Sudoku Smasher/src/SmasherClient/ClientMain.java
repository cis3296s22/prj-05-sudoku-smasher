package SmasherClient;

import SmasherClient.Frame;
import SmasherServer.Debugger;

public class ClientMain {
    public static void main(String[] args)
    {
        int[][] badTestBoard = new int[][] {
                { 3, 3, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 1, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 2 }
        };

        //        int[][] testBoard = new int[][] {
//                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
//                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
//                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
//                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
//                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
//                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
//                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
//                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
//                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
//        };

        //Frame.createAndShowGUI();
        int port = 3000;
        Client client = new Client(port);
        client.sendPuzzle(badTestBoard);
        Debugger.showMatrix(client.getPuzzle());
    }
}
