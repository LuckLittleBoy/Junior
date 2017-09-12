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
    public partial class Main : Form
    {
        // 变量 ***************************************************************
        DBCL.dbSSEntities db;

        // 函数 ***************************************************************
        // 构造
        public Main()
        {
            InitializeComponent();
        }

        // 事件 ***************************************************************
        // 关闭
        private void Main_FormClosed(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
        }

        // 退出
        private void 退出ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        // 添加
        private void btnAdd_Click(object sender, EventArgs e)
        {
            StudentAdd frmStudentAdd = new StudentAdd();
            frmStudentAdd.ShowDialog(this);
        }

        // 编辑
        private void btnEdit_Click(object sender, EventArgs e)
        {
            db = new DBCL.dbSSEntities();
            string strID = "";

            strID = tbID.Text.Trim();
            if (strID == "")
            {
                MessageBox.Show("请输入要编辑的学号!");
                return;
            }
            if (db.Students.Any(m => m.ID == strID) == false)
            {
                MessageBox.Show("该学号在数据库中不存在!");
                return;
            }

            StudentEdit frmStudentEdit = new StudentEdit(strID);
            frmStudentEdit.ShowDialog(this);
            var model = db.Students.Select(m => m);
            string strTemp = "";
            foreach (var item in model)
            {

                strTemp += "学号:" + item.ID + "  ";
                strTemp += "姓名:" + item.Name + "  ";
                strTemp += "年龄:" + item.Age.ToString() + "岁 \r\n";
            }

            tbResult.Text = strTemp;
        }

        // 查询
        private void btnQuery_Click(object sender, EventArgs e)
        {
            db = new DBCL.dbSSEntities();
            string strID = "";
            string strName = "";

            strID = tbID.Text.Trim();
            strName = tbName.Text.Trim();
            
            var model = db.Students.Select(m => m);

            // 学号
            if (strID != "")
            {
                model = model.Where(m => m.ID.IndexOf(strID) >= 0);
            }

            // 姓名
            if (strName != "")
            {
                model = model.Where(m => m.Name.IndexOf(strName) >= 0);
            }

            string strTemp = "";
            foreach (var item in model)
            {

                strTemp += "学号:" + item.ID + "  ";
                strTemp += "姓名:" + item.Name + "  ";
                strTemp += "年龄:" + item.Age.ToString() + "岁 \r\n";
            }

            tbResult.Text = strTemp;
        }


    }
}
