using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Numerics;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);
        int[] dimensions = reader.NextArrInt;

        var lineTrack = new Dictionary<long, List<Range>>();
        while (dimensions[2]-- > 0)
        {
            int[] line = reader.NextArrInt;
            var row = line[0];
            var start = line[1] - 1;
            var end = line[2] - 1;

            if (lineTrack.ContainsKey(row))
            {
                lineTrack[row].Add(new Range(start, end));
            }
            else
            {
                lineTrack.Add(row, new List<Range> { new Range(start, end) });
            }
        }

        reader.Close();

        var result = new BigInteger(dimensions[0]) * new BigInteger(dimensions[1]); // n * m
        foreach (var rowTracks in lineTrack.Values)
        {
            result -= Solve(rowTracks);
        }

        Console.WriteLine(result);
    }

    static int Solve(List<Range> tracks)
    {
        var ordered = tracks.OrderBy(range => range.Start).ThenBy(range => range.End).ToList();

        for (int i = 0; i < ordered.Count; ++i)
        {
            var toConcat = ordered.Skip(i + 1).FirstOrDefault(range => range.Start <= ordered[i].End);
            if (toConcat != null)
            {
                ordered[i] = new Range(ordered[i].Start, Math.Max(ordered[i].End, toConcat.End));
                ordered.Remove(toConcat);
                i--;
            }
        }

        return ordered.Select(range => (range.End - range.Start + 1)).Sum();
    }
}

class Range
{
    public int Start { get; }
    public int End { get; }

    public Range(int start, int end)
    {
        Start = start;
        End = end;
    }
}

class InputReader
{
    private TextReader input;

    public InputReader(bool fromFile)
    {
        input = fromFile ? new StreamReader("input.txt") : Console.In;
    }

    public int[] NextArrInt => Array.ConvertAll(input.ReadLine().Split(), int.Parse);

    public long[] NextArrLong => Array.ConvertAll(input.ReadLine().Split(), long.Parse);

    public void Close() => input.Close();
}
