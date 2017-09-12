using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace StudentMis
{
    public partial class Login : Form
    {
        // 变量 ***************************************************************

        // 函数 ***************************************************************
        // 构造
        public Login()
        {
            InitializeComponent();
        }

        // 事件 ***************************************************************
        // 退出
        private void btnExit_Click(object sender, EventArgs e)
        {
            Close();
        }

        // 登录
        private void btnLogin_Click(object sender, EventArgs e)
        {
            string strUserName = "";
            string strPWD = "";

            strUserName = tbUserName.Text.Trim();
            strPWD = tbPWD.Text.Trim();

            if(strUserName=="1" && strPWD=="1")
            {
                this.Hide();
                Main frmMain = new Main();
                frmMain.Show();
            }
            else
            {
                MessageBox.Show("用户名或密码错误!");
            }




        }


    }
}
