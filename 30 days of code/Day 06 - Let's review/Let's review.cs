/**
 *              LET'S REVIEW | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 06
 */

class Program
{
    //static TextReader read = Console.In;
    static StreamReader read = new StreamReader("input.txt");

    static void Main(string[] args)
    {
        int testCases = int.Parse(read.ReadLine());
        while (testCases-- > 0)
        {
            string input = read.ReadLine();
            LetsReview(input);
        }
        read.Close();
    }

    private static void LetsReview(string input)
    {
        string even = string.Empty;
        string odd = string.Empty;

        for (int i = 0; i < input.Length; ++i)
        {
            if (i % 2 == 0)
            {
                even += input[i];
            }
            else
            {
                odd += input[i];
            }
        }

        Console.WriteLine($"{even} {odd}");
    }
}