using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace renwu2
{
    class Program
    {
        static void Main(string[] args)
        {
            Circle c = new Circle();
            c.initialize(3);
            c.Display();

            Square s = new Square();
            s.initialize(4);
            s.Display();
            Console.ReadLine();
        }
    }
}
