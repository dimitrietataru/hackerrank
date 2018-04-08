/**
 *              EXCEPTIONS (STRING TO INTEGER) | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 16
 */

class Program
{
    //static TextReader read = Console.In;
    static StreamReader read = new StreamReader("input.txt");

    static void Main(string[] args)
    {
        string input = read.ReadLine();
        read.Close();

        try
        {
            int n = Int32.Parse(input);
            Console.WriteLine(n);
        }
        catch (FormatException fe)
        {
            Console.WriteLine("Bad String");
        }
    }
}