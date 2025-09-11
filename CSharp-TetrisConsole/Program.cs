namespace CSharp_TetrisConsole;

class Program
{
    static void Main(string[] args)
    {
        for (int i = 0; i < 5; i++)
        {
            Console.WriteLine("Piece: " + i);
            Piece myPiece = new Piece(i);
            Console.WriteLine();
        }
        Console.ReadKey();

        string[,] pieceA = { { "[*]", "[ ]", "[ ]" }, { "[*]", "[*]", "[*]" } };

        for (int i = 0; i < pieceA.GetLength(0); i++)
        {
            for (int j = 0; j < pieceA.GetLength(1); j++)
            {
                Console.Write(pieceA[i, j]);
            }
            Console.WriteLine();
        }

        Console.WriteLine("----ROTATED----");
        string[,] pieceB = { { "[*]", "[*]" }, { "[*]", "[ ]" }, { "[*]", "[ ]" } };

        for (int i = 0; i < pieceB.GetLength(0); i++)
        {
            for (int j = 0; j < pieceB.GetLength(1); j++)
            {
                Console.Write(pieceB[i, j]);
            }
            Console.WriteLine();
        }
        /*
        Console.WriteLine("----ROTATED----");
        string[,] pieceC = { { "[*]", "[*]", "[*]" }, { "[ ]", "[ ]", "[*]" } };

        for (int i = 0; i < pieceC.GetLength(0); i++)
        {
            for (int j = 0; j < pieceC.GetLength(1); j++)
            {
                Console.Write(pieceC[i, j]);
            }
            Console.WriteLine();
        }

        Console.WriteLine("----ROTATED----");
        string[,] pieceD = { { "[ ]", "[*]" }, { "[ ]", "[*]" }, { "[*]", "[*]" } };

        for (int i = 0; i < pieceD.GetLength(0); i++)
        {
            for (int j = 0; j < pieceD.GetLength(1); j++)
            {
                Console.Write(pieceD[i, j]);
            }
            Console.WriteLine();
        }
        */
    }
}
