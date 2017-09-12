using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace renwu2
{
    class Square:IShape,IDisplayresult
    {
        public double len;
        public decimal initialize(double len)
        {
            this.len = len;
            return (decimal)(this.len);
        }
        public decimal getPerimeter()
        {
            return (decimal)(4 * len);
        }
        public decimal getArea()
        {
            return (decimal)(len * len);
        }

        public void Display()
        {
            Console.WriteLine("周长：{0} 面积：{1}",getPerimeter(),getArea());
        }
    }
}
