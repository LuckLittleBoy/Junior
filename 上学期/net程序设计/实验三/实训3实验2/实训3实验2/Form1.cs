using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 实训3实验2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            string name = this.tbName.Text;
            string classname = this.cbClass.Text;
            string sex = "";
            string like = "";
            if (this.rbMan.Checked)
            {
                sex = this.rbMan.Text;
            }

            if (this.rbWoman.Checked)
            {
                sex = this.rbWoman.Text;
            }

            if (this.cbLookBook.Checked)
            {
                like += this.cbLookBook.Text;
            }
            if (this.cbPlayBall.Checked)
            {
                like += this.cbPlayBall.Text;
            }
            if (this.cbWalk.Checked)
            {
                like += this.cbWalk.Text;
            }
            
            this.lbView.Items.Add("姓名：" + name + "   班级：" + classname + "    性别：" + sex + "  爱好：" + like);
        }
    }
}
