using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace renwu3
{
    class Teacher:Person
    {
        protected int tAge;
        protected string tId;
        protected string tstarYear;
        public Teacher(string name,string gender,string yearOfBirth,string MyTId,string MyTstarYear):base(name,gender,yearOfBirth)
        {
            this.tId = MyTId;
            this.tstarYear = MyTstarYear;
            this.tAge = 2016 - int.Parse(tstarYear) + 1;
        }

        public new void Print()
        {
            base.Print();
            Console.WriteLine("工号：{0}, 教龄：{1}", tId, tAge);
        }
    }
}
