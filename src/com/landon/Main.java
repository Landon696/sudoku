package com.landon;

public class Main {

    public static void main(String[] args) {

        //String boardContents = "534678912672195348198342567859761423426853791713924856961537284287419635345286179";
        String boardContents = "53--7----6--195----98----6-8---6---34--8-3--17---2---6-6----28----419--5----8--79";

        Board board = new Board(boardContents);

        boolean areRowsValid = board.areRowsValid();
        System.out.println("Valid rows: " + areRowsValid);

        boolean areColsValid = board.areColsValid();
        System.out.println("Valid cols: " + areColsValid);

        boolean areSubMatricesValid = board.areSubMatricesValid(3);
        System.out.println("Valid Matrices: " + areSubMatricesValid);

    }
}
