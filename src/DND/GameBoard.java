package DND;

import DND.Tiles.Tile;

public class GameBoard {

    private Tile[][] board;
    private MessageHandler m;
    public GameBoard(Tile[][]board,MessageHandler m){
        this.board = board;
        this.m = m;
    }

    public String builtBoard(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[i].length ; j++) {
                sb.append(board[i][j].getTile());
            }
        }
        return sb.toString();
    }
    public void printBoard(){
        m.sendMessage(builtBoard());
    }

}
