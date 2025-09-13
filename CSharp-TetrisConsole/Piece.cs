using System;

namespace CSharp_TetrisConsole;

public class Piece
{
    public int X { get; set; }
    public int Y { get; set; }
    public int[,] PieceShape { get; set; }

    int[][] shapes = new int[][] {
        new int[]{ 2, 3, 1, 0, 0, 1, 1, 1},
        new int[]{ 2, 3, 0, 1, 0, 1, 1, 1 },
        new int[]{ 1, 4, 1, 1, 1, 1, 0, 0, 0, 0},
        new int[]{ 2, 3, 0, 1, 1, 1, 1, 0},
        new int[]{ 2, 2, 1, 1, 1, 1}
    };

    // need to create rotation
    // added a coment

    public Piece(int shapeIndex)
    {
        X = shapes[shapeIndex][0];
        Y = shapes[shapeIndex][1];
        PieceShape = new int[X, Y];
        int n = 2;
        for (int i = 0; i < X; i++)
        {
            for (int j = 0; j < Y; j++)
            {
                PieceShape[i, j] = shapes[shapeIndex][n];
                n++;
            }
        }

        for (int i = 0; i < X; i++)
        {
            for (int j = 0; j < Y; j++)
            {
                Console.Write(PieceShape[i, j] == 1 ? "[*]" : "   ");
            }
            Console.WriteLine();
        }
    }
}
