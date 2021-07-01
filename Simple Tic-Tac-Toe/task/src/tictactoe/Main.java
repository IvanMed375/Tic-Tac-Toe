package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] cells = new char[3][3];
        char[][] diag = new char[2][3];
        int coordI;
        int coordJ;
        int counter = 0;
        boolean winner = false;
        boolean x = false;
        boolean emptySpaces;
        String status;

        //making empty field
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }

        do {
            counter++;
            emptySpaces = false;


            //printing field
            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(cells[i][j] + " ");
                    if (cells[i][j] == ' ') {
                        emptySpaces = true;
                    }
                    if (i == j) {
                        diag[0][i] = cells[i][j];
                    }
                    if (i == 2 - j) {
                        diag[1][i] = cells[i][j];
                    }
                }
                System.out.println('|');
            }
            System.out.println("---------");


            //checking for rows of X or O
            for (int i = 0; i < 2; i++) {
                if (diag[i][0] != ' ' && diag[i][0] == diag[i][1] &&
                        diag[i][1] == diag[i][2]) {
                    winner = true;
                    if (diag[i][0] == 'X') {
                        x = true;
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                if (cells[i][0] != ' ' && cells[i][0] == cells[i][1] &&
                        cells[i][1] == cells[i][2]) {
                    winner = true;
                    if (cells[i][0] == 'X') {
                        x = true;
                    }
                }
                if (cells[0][i] != ' ' && cells[0][i] == cells[1][i] &&
                        cells[1][i] == cells[2][i]) {
                    winner = true;
                    if (cells[0][i] == 'X') {
                        x = true;
                    }
                }
            }

            //ending if draw or someone won
            if (winner) {
                if (x) {
                    status = "X wins";
                } else {
                    status = "O wins";
                }
                System.out.println(status);
                break;
            } else {
                if (!emptySpaces) {
                    System.out.println("Draw");
                    break;
                }
            }


            //scanning new coordinates
            do {
                if (scanner.hasNextInt()) {
                    coordI = scanner.nextInt();
                    if (scanner.hasNextInt()) {
                        coordJ = scanner.nextInt();
                    } else {
                        System.out.println("You should enter numbers!");
                        scanner.nextLine();
                        continue;
                    }
                } else {
                    System.out.println("You should enter numbers!");
                    scanner.nextLine();
                    continue;
                }

                if (coordI <= 3 && coordJ <= 3 && coordI >= 1 && coordJ >= 1) {
                    if (cells[coordI - 1][coordJ - 1] == ' ') {
                        if (counter % 2 == 1){
                            cells[coordI - 1][coordJ - 1] = 'X';
                        } else {
                            cells[coordI - 1][coordJ - 1] = 'O';
                        }

                        break;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } while (true);

        } while (true);
    }
}
