//package BoardDetails;
//
//import Pieces.Piece;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//
//public class DisplayBoard extends JPanel {
//    // board size in pixels
//    public static int BOARDWIDTH = 500;
//    public static int BOARDHEIGHT = 500;
//
//    private final int myRows;
//    private final int myCols;
//
//    private GridLayout gridLayout;
//
//    private int[] coords;
//
//    private boolean piecePicked;
//
//
//    public DisplayBoard(int rows, int cols) {
//
//        myRows = rows;
//        myCols = cols;
//        setPreferredSize(new Dimension(BOARDWIDTH, BOARDHEIGHT));
//        setLayout(new GridLayout(myRows, myCols));
//
//        for (int r = 1; r <= myRows; r++)
//            for (int c = 1; c <= myCols; c++)
//                add(new JButton());
//
//        gridLayout = new GridLayout(myRows, myCols);
//        JFrame lifeFrame = new JFrame();
//        lifeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        lifeFrame.setContentPane(this);
//        lifeFrame.pack();
//        lifeFrame.setVisible(true);
//        coords = new int[]{0,0};
//        piecePicked = false;
//    }
//
//    public void display(Piece[][] inputBoard) {
//        display(inputBoard, null);
//    }
//
//    public void display(Piece[][] inputBoard, ArrayList<Coordinate> inputPossibleMoves) {
//
//        String currentColor = "White";
//        setLayout(gridLayout);
//
//        this.removeAll();
//
//        boolean threatened = false;
//
//        JButton jButton;
//
//        for (int x = 0; x < 8; x++) {
//            for (int y = myCols-1; y > 0; y--) {
//                if (inputPossibleMoves != null) {
//                    for (int k = 0; k < inputPossibleMoves.size(); k++) {
//                        if (inputPossibleMoves.get(k).getX() == x && inputPossibleMoves.get(k).getY() == y) {
//                            threatened = true;
//                            break;
//                        } else {
//                            threatened = false;
//                        }
//                    }
//                }
//                Font font = new Font(Font.DIALOG_INPUT, Font.PLAIN, 80);
//                if(inputBoard != null) {
//                    jButton = inputBoard[x][y];
//                    inputBoard[x][y].setThreatened(threatened);
//                }
//                else jButton = new JButton();
//
//
//
//                jButton.setFont(font);
//                jButton.setBackground(threatened ? Color.yellow : Color.white);
//                JButton finalJButton = jButton;
//                String finalCurrentColor = currentColor;
//                jButton.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        Piece p = (Piece) e.getSource();
//                        coords = p.coords();
//                        piecePicked = true;
//                    }
//
//                });
//                currentColor = currentColor.equals("White") ? "Black" : "White";
//                add(jButton);
//            }
//        }
//        this.revalidate();
//        this.repaint();
//
//    }
//
//    public int[] getCoords() {
//        return coords;
//    }
//
//    public void pickedFalse(){
//        piecePicked = false;
//    }
//
//    public boolean isPiecePicked() {
//        return piecePicked;
//    }
//}
//
