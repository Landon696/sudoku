package com.landon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Landon on 3/18/16.
 */
public class Board {
    final int MAX_ROW_SIZE = 9;
    final int MAX_COL_SIZE = 9;
    String[][] board = new String[MAX_ROW_SIZE][MAX_COL_SIZE];
    String boardContents;

    public Board(String contents) {
        boardContents = contents;
        loadBoard(contents);
    }

    public boolean areRowsValid() {
        boolean rowValid = true;
        String content;
        Map<Integer, String> lookedAtBefore;

        //rows
        for (int i=0; i <=8; i++) {
            rowValid = true;
            lookedAtBefore = new HashMap<Integer, String>();
            for (int j = 0; j <= 8; j++) {
                content = board[i][j];
                if (!content.equalsIgnoreCase("-")) {
                    if (lookedAtBefore.containsValue(content)) {
                        //no need to continue
                        rowValid = false;
                        break;
                    }
                }
                lookedAtBefore.put(j, content);
            }

            if (!rowValid) {
                System.out.println("row : " + (i + 1) + " rowValid:" + rowValid);
                //no need to continue
                break;
            }

        }
        return rowValid;
    }

    public boolean areColsValid() {

        boolean colValid = true;
        String content;
        Map<Integer, String> lookedAtBefore;

        for (int i=0; i <=8; i++) {
            colValid = true;
            lookedAtBefore = new HashMap<Integer, String>();
            for (int j = 0; j <= 8; j++) {
                content = board[j][i];
                if (!content.equalsIgnoreCase("-")) {
                    if (lookedAtBefore.containsValue(content)) {
                        colValid = false;
                        break;
                    }
                }
                lookedAtBefore.put(j, content);
            }

            if (!colValid) {
                System.out.println("col : " + (i + 1) + " colValid:" + colValid);
                //no need to continue
                break;
            }

        }

        return colValid;
    }

    public boolean areSubMatricesValid(int matrixSize) {

        boolean matrixValid = true;
        String content;
        Map<String, String> lookedAtBefore;

        System.out.println("List of sub matrices");
        for (int l=0; l < MAX_ROW_SIZE; l++) {
            lookedAtBefore = new HashMap<String, String>();
            //every 3rd row
            if (l % matrixSize == 0) {

                for (int z = 0; z < MAX_COL_SIZE; z++) {

                    //every 3rd column
                    if (z % matrixSize ==0) {

                        for (int i = l; i <  l + matrixSize; i++) {
                            matrixValid = true;
                            for (int j = z; j < z + matrixSize; j++) {
                                System.out.print("[" + i + "," + j + "]");
                                content = board[i][j];
                                System.out.println(content);
                                if (!content.equalsIgnoreCase("-")) {
                                    if (lookedAtBefore.containsValue(content)) {
                                        //no need to continue
                                        matrixValid = false;
                                        break;
                                    }
                                }
                                lookedAtBefore.put("[" + i + "," + j + "]", content);
                            }

                            if (!matrixValid) {
                                System.out.println("Matrix starting at : ( " + (l + 1) + ", " + (z +1) + ") is invalid");
                                //no need to continue
                                break;
                            }
                        }
                        System.out.println("[.................] ");
                        lookedAtBefore.clear();
                    }
                }

            }
        }

        return matrixValid;
    }
    private void loadBoard(String boardContents) {
        int rowCounter =0;
        int colCounter =0;
        for (int i=0;   i < boardContents.length(); i++) {
            char c = boardContents.charAt(i);
            if (i % MAX_ROW_SIZE == 0 && i != 0) {
                rowCounter++;
                colCounter = 0;
            }

            board[rowCounter][colCounter] = String.valueOf(c);

            colCounter++;

        }
    }
}
