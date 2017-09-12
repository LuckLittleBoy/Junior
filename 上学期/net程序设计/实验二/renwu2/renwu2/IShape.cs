using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace renwu2
{
    public interface IShape
    {
        decimal initialize(double l);
        decimal getPerimeter();
        decimal getArea();
    }
}
