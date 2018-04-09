# HACKERRANK

175+ solutions (...and counting)

* 30 days of code
  - Java
  - C++
  - C#
* Algorithms
  - Warmup
  - Implementation
  - Strings
* Java
  - Introduction
  - Strings
  - BigNumber
  - Data structures
  - Object oriented programming
  - Exception handling
  - Advanded

## HANDLING INPUT

```java
/* Java - read from file */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int i = scan.nextInt();
        scan.close();
    }
}


/* Java - read from console */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        scan.close();
    }
}
```

```cpp
/* C++ - read from file */
#include <iostream>
#include <fstream>

using namespace std;

ifstream file("input.txt");
istream& f = file;

void main() {
    int n;
    f >> n;
}


/* C++ - read from console */
#include <iostream>

using namespace std;

istream& f = cin;

void main() {
    int n;
    f >> n;
}
```

```csharp
/* C# - read from file */
using System;
using System.IO;

class Program
{
    static StreamReader read = new StreamReader("input.txt");
    static void Main(string[] args)
    {
        int i = Int32.Parse(read.ReadLine());
        read.Close();
    }
}


/* C# - read from console */
using System;
using System.IO;

class Program
{
    static TextReader read = Console.In;
    static void Main(string[] args)
    {
        int i = Int32.Parse(read.ReadLine());
        read.Close();
    }
}
```
