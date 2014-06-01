/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agameoflife;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Contreiras
 */
public class Grid {

    private int grid[][];
    private int gridSol[][];
    private int size;

    public Grid(int tam) {
        this.size = tam;
        grid = new int[size][size];
        gridSol = new int[size][size];

        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                grid[16][j] = 1;
            }
        }

    }

    //Getters and setters
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public int checkAlrededor(int x, int y) {

        int suma = 0;
        try {
            suma += grid[x - 1][y - 1];
        } catch (Exception e) {
        }

        try {
            suma += grid[x][y - 1];
        } catch (Exception e) {
        }

        try {
            suma += grid[x + 1][y - 1];
        } catch (Exception e) {
        }

        try {
            suma += grid[x - 1][y];
        } catch (Exception e) {
        }

        try {
            suma += grid[x + 1][y];
        } catch (Exception e) {
        }

        try {

            suma += grid[x - 1][y + 1];
        } catch (Exception e) {
        }

        try {
            suma += grid[x][y + 1];
        } catch (Exception e) {
        }

        try {
            suma += grid[x + 1][y + 1];
        } catch (Exception e) {
        }

        return suma;
    }

    public void LiveorDie(int x, int y) {

        if (checkAlrededor(x, y) == 2) {
            gridSol[x][y] = grid[x][y];
        }

        if (checkAlrededor(x, y) == 3) {
            gridSol[x][y] = 1;
        }

        if (checkAlrededor(x, y) < 2) {
            gridSol[x][y] = 0;
        }
        if (checkAlrededor(x, y) > 3) {
            gridSol[x][y] = 0;
        }
    }

    public void Recorrer() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {

                LiveorDie(i, j);
            }
        }
    }

    public void infiniteTsukuyomi() {

        Recorrer();
        this.grid = this.gridSol;
        this.gridSol = new int[size][size];

    }

    //Metodo para dibujar
    public void drawGrid(Graphics g) {

        int squareSize = 10;
        int x = 0;
        int y = 0;

        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {

                if (this.grid[i][j] == 0) {
                    g.setColor(Color.white);
                    g.fillRect(x, y, squareSize, squareSize);
                } else {
                    g.setColor(Color.black);
                    g.fillRect(x, y, squareSize, squareSize);
                }

                g.setColor(Color.BLACK);
                g.drawRect(x, y, squareSize, squareSize);
                x += squareSize;
            }
            x = 0;
            y += squareSize;
        }
    }

    //Para imprimir las soluciones
    public void imprimirGrid() {
        for (int[] item : grid) {

            for (int i : item) {
                System.out.print(i + "  ");
            }
            System.out.println("");
        }
    }

    public void imprimirGridSol() {
        for (int[] item : gridSol) {

            for (int i : item) {
                System.out.print(i + "  ");
            }
            System.out.println("");
        }
    }
}
