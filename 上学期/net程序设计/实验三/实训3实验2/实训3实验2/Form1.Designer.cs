namespace 实训3实验2
{
    partial class Form1
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.tbName = new System.Windows.Forms.TextBox();
            this.cbLookBook = new System.Windows.Forms.CheckBox();
            this.cbClass = new System.Windows.Forms.ComboBox();
            this.lbView = new System.Windows.Forms.ListBox();
            this.rbMan = new System.Windows.Forms.RadioButton();
            this.gbSex = new System.Windows.Forms.GroupBox();
            this.rbWoman = new System.Windows.Forms.RadioButton();
            this.lbName = new System.Windows.Forms.Label();
            this.lbClass = new System.Windows.Forms.Label();
            this.lbHobbly = new System.Windows.Forms.Label();
            this.cbPlayBall = new System.Windows.Forms.CheckBox();
            this.cbWalk = new System.Windows.Forms.CheckBox();
            this.btnAdd = new System.Windows.Forms.Button();
            this.gbSex.SuspendLayout();
            this.SuspendLayout();
            // 
            // tbName
            // 
            this.tbName.Location = new System.Drawing.Point(199, 23);
            this.tbName.Name = "tbName";
            this.tbName.Size = new System.Drawing.Size(121, 21);
            this.tbName.TabIndex = 0;
            // 
            // cbLookBook
            // 
            this.cbLookBook.AutoSize = true;
            this.cbLookBook.Location = new System.Drawing.Point(154, 265);
            this.cbLookBook.Name = "cbLookBook";
            this.cbLookBook.Size = new System.Drawing.Size(48, 16);
            this.cbLookBook.TabIndex = 1;
            this.cbLookBook.Text = "看书";
            this.cbLookBook.UseVisualStyleBackColor = true;
            // 
            // cbClass
            // 
            this.cbClass.FormattingEnabled = true;
            this.cbClass.Items.AddRange(new object[] {
            "信1405-1班",
            "信1405-2班",
            "信1406-1班",
            "信1406-2班"});
            this.cbClass.Location = new System.Drawing.Point(199, 72);
            this.cbClass.Name = "cbClass";
            this.cbClass.Size = new System.Drawing.Size(121, 20);
            this.cbClass.TabIndex = 2;
            // 
            // lbView
            // 
            this.lbView.FormattingEnabled = true;
            this.lbView.ItemHeight = 12;
            this.lbView.Location = new System.Drawing.Point(39, 358);
            this.lbView.Name = "lbView";
            this.lbView.Size = new System.Drawing.Size(407, 124);
            this.lbView.TabIndex = 3;
            // 
            // rbMan
            // 
            this.rbMan.AutoSize = true;
            this.rbMan.Location = new System.Drawing.Point(29, 29);
            this.rbMan.Name = "rbMan";
            this.rbMan.Size = new System.Drawing.Size(35, 16);
            this.rbMan.TabIndex = 4;
            this.rbMan.TabStop = true;
            this.rbMan.Text = "男";
            this.rbMan.UseVisualStyleBackColor = true;
            // 
            // gbSex
            // 
            this.gbSex.Controls.Add(this.rbWoman);
            this.gbSex.Controls.Add(this.rbMan);
            this.gbSex.Location = new System.Drawing.Point(154, 121);
            this.gbSex.Name = "gbSex";
            this.gbSex.Size = new System.Drawing.Size(166, 100);
            this.gbSex.TabIndex = 5;
            this.gbSex.TabStop = false;
            this.gbSex.Text = "性别";
            // 
            // rbWoman
            // 
            this.rbWoman.AutoSize = true;
            this.rbWoman.Location = new System.Drawing.Point(29, 63);
            this.rbWoman.Name = "rbWoman";
            this.rbWoman.Size = new System.Drawing.Size(35, 16);
            this.rbWoman.TabIndex = 4;
            this.rbWoman.TabStop = true;
            this.rbWoman.Text = "女";
            this.rbWoman.UseVisualStyleBackColor = true;
            // 
            // lbName
            // 
            this.lbName.AutoSize = true;
            this.lbName.Location = new System.Drawing.Point(152, 26);
            this.lbName.Name = "lbName";
            this.lbName.Size = new System.Drawing.Size(41, 12);
            this.lbName.TabIndex = 6;
            this.lbName.Text = "姓名：";
            // 
            // lbClass
            // 
            this.lbClass.AutoSize = true;
            this.lbClass.Location = new System.Drawing.Point(152, 75);
            this.lbClass.Name = "lbClass";
            this.lbClass.Size = new System.Drawing.Size(41, 12);
            this.lbClass.TabIndex = 6;
            this.lbClass.Text = "班级：";
            // 
            // lbHobbly
            // 
            this.lbHobbly.AutoSize = true;
            this.lbHobbly.Location = new System.Drawing.Point(152, 241);
            this.lbHobbly.Name = "lbHobbly";
            this.lbHobbly.Size = new System.Drawing.Size(41, 12);
            this.lbHobbly.TabIndex = 7;
            this.lbHobbly.Text = "爱好：";
            // 
            // cbPlayBall
            // 
            this.cbPlayBall.AutoSize = true;
            this.cbPlayBall.Location = new System.Drawing.Point(214, 265);
            this.cbPlayBall.Name = "cbPlayBall";
            this.cbPlayBall.Size = new System.Drawing.Size(48, 16);
            this.cbPlayBall.TabIndex = 1;
            this.cbPlayBall.Text = "打球";
            this.cbPlayBall.UseVisualStyleBackColor = true;
            // 
            // cbWalk
            // 
            this.cbWalk.AutoSize = true;
            this.cbWalk.Location = new System.Drawing.Point(272, 265);
            this.cbWalk.Name = "cbWalk";
            this.cbWalk.Size = new System.Drawing.Size(48, 16);
            this.cbWalk.TabIndex = 1;
            this.cbWalk.Text = "跑步";
            this.cbWalk.UseVisualStyleBackColor = true;
            // 
            // btnAdd
            // 
            this.btnAdd.Location = new System.Drawing.Point(199, 312);
            this.btnAdd.Name = "btnAdd";
            this.btnAdd.Size = new System.Drawing.Size(75, 23);
            this.btnAdd.TabIndex = 8;
            this.btnAdd.Text = "添加";
            this.btnAdd.UseVisualStyleBackColor = true;
            this.btnAdd.Click += new System.EventHandler(this.btnAdd_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(484, 523);
            this.Controls.Add(this.btnAdd);
            this.Controls.Add(this.lbHobbly);
            this.Controls.Add(this.lbClass);
            this.Controls.Add(this.lbName);
            this.Controls.Add(this.gbSex);
            this.Controls.Add(this.lbView);
            this.Controls.Add(this.cbClass);
            this.Controls.Add(this.cbWalk);
            this.Controls.Add(this.cbPlayBall);
            this.Controls.Add(this.cbLookBook);
            this.Controls.Add(this.tbName);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Form1";
            this.Text = "增加学生信息";
            this.gbSex.ResumeLayout(false);
            this.gbSex.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox tbName;
        private System.Windows.Forms.CheckBox cbLookBook;
        private System.Windows.Forms.ComboBox cbClass;
        private System.Windows.Forms.ListBox lbView;
        private System.Windows.Forms.RadioButton rbMan;
        private System.Windows.Forms.GroupBox gbSex;
        private System.Windows.Forms.RadioButton rbWoman;
        private System.Windows.Forms.Label lbName;
        private System.Windows.Forms.Label lbClass;
        private System.Windows.Forms.Label lbHobbly;
        private System.Windows.Forms.CheckBox cbPlayBall;
        private System.Windows.Forms.CheckBox cbWalk;
        private System.Windows.Forms.Button btnAdd;
    }
}

