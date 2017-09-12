using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace renwu2
{
    class Circle : IShape, IDisplayresult
    {
        public double radius;
        public decimal initialize(double radius)
        {
            this.radius = radius;
            return (decimal)(this.radius);
        }
        public decimal getPerimeter()
        {
            return (decimal)(2 * 3.14 * radius);
        }
        public decimal getArea()
        {
            return (decimal)(3.14 * radius * radius);
        }

        public void Display()
        {
            Console.WriteLine("周长：{0} 面积：{1}", getPerimeter(), getArea());
        }
    }
}
