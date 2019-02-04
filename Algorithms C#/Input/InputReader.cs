using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Linq;

namespace Input
{
    public class InputReader
    {
        private TextReader input;

        public InputReader(bool fromFile)
        {
            input = fromFile ? new StreamReader("input.txt") : Console.In;
        }

        public string NextLine => input.ReadLine();

        public int NextInt => int.Parse(NextLine);
        public int[] NextArrInt => Array.ConvertAll(NextLine.Split(), int.Parse);
        public List<int> NextInts => NextArrInt.ToList();

        public long NextLong => long.Parse(NextLine);
        public long[] NextArrLong => Array.ConvertAll(NextLine.Split(), long.Parse);
        public List<long> NextLongs => NextArrLong.ToList();

        public double NextDouble => double.Parse(NextLine, CultureInfo.InvariantCulture);
        public double[] NextArrDouble => Array.ConvertAll(NextLine.Split(), d => double.Parse(d, CultureInfo.InvariantCulture));
        public List<double> NextDoubles => NextArrDouble.ToList();

        public char NextChar => Convert.ToChar(NextLine);
        public char[] NextArrChar => NextLine.Replace(" ", "").ToCharArray();
        public List<char> NextChars => NextArrChar.ToList();

        public string NextString => NextLine;
        public string[] NextArrString => NextLine.Split();
        public List<string> NextStrings => NextArrString.ToList();

        public void Close() => input.Close();
    }
}
