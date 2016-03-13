using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MiniPrograms
{
    public partial class MainForm : Form
    {
        int count = 0;

        Random rnd = new Random();

        char[] special_chars = new char[] {'(', ')', '%', '*', '?', '&', '!', '@', '$', '#'};

        Dictionary<string, double> metrica;


        public MainForm()
        {
            InitializeComponent();
            metrica = new Dictionary<string, double>();
            metrica.Add("mm", 1);
            metrica.Add("cm", 10);
            metrica.Add("dm", 100);
            metrica.Add("m", 1000);
            metrica.Add("km", 1000000);
            metrica.Add("mile", 1609344);            
        }

        private void файлToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void оПрограммеToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Программа Мои Утилиты. Автор: Зелёнка П.М.", "О программе");
        }

        private void tsmiExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnPlus_Click(object sender, EventArgs e)
        {
            count++;
            lblCount.Text = count.ToString();
        }

        private void btnMinus_Click(object sender, EventArgs e)
        {
            count--;
            lblCount.Text = count.ToString();
        }

        private void btnReset_Click(object sender, EventArgs e)
        {
            count=0;
            lblCount.Text = count.ToString();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void btnRandom_Click(object sender, EventArgs e)
        {
            if (numericUpDownMin.Value>numericUpDownMax.Value)
            {
                numericUpDownMax.Value = numericUpDownMin.Value;
            }
            int n = rnd.Next(Convert.ToInt32(numericUpDownMin.Value), Convert.ToInt32(numericUpDownMax.Value)+1);
            lblRandom.Text = n.ToString();
            if (cbRandom.Checked)
            {
                if (tbRandom.Text.IndexOf(n.ToString()) == -1) tbRandom.AppendText(n + "\n");
            } else tbRandom.AppendText(n + "\n");            
        }

        private void btnClear_Click(object sender, EventArgs e)
        {
            tbRandom.Clear();
        }

        private void btnRandomCopy_Click(object sender, EventArgs e)
        {
            Clipboard.SetText(tbRandom.Text);
        }

        private void cbRandom_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void блокнотToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void tsmiAddDate_Click(object sender, EventArgs e)
        {
            rtbNotepad.AppendText(DateTime.Now.ToShortDateString()+"\n");
        }

        private void tsmiAddTime_Click(object sender, EventArgs e)
        {
            rtbNotepad.AppendText(DateTime.Now.ToShortTimeString() + "\n");
        }

        private void tsmiNotepadSave_Click(object sender, EventArgs e)
        {
            try
            {
                rtbNotepad.SaveFile("notepad.rtf");
            }
            catch
            {
                MessageBox.Show("Ошибка при сохранении");
            }
        }

        void LoadNotepad()
        {
            try
            {
                rtbNotepad.LoadFile("notepad.rtf");
            }
            catch
            {
                MessageBox.Show("Ошибка при загрузке");
            }
        }
        private void tsmiNotepadLoad_Click(object sender, EventArgs e)
        {
            LoadNotepad();
        }

        private void MainForm_Load(object sender, EventArgs e)
        {
            LoadNotepad();
            clbPassword.SetItemChecked(0, true);
            clbPassword.SetItemChecked(1, true);
        }

        private void tsmiNotepadClear_Click(object sender, EventArgs e)
        {
            rtbNotepad.Clear();
        }

        private void btnPassword_Click(object sender, EventArgs e)
        {
            if (clbPassword.CheckedItems.Count == 0) return;
            string password = "";
            for (int i = 0; i < nudPassword.Value; i++)
            {
                int n = rnd.Next(0, clbPassword.CheckedItems.Count);
                string s = clbPassword.CheckedItems[n].ToString();
                switch (s)
                {
                    case "Цыфры": password += rnd.Next(10).ToString();
                        break;
                    case "Прописные буквы": password += Convert.ToChar(rnd.Next(65, 88));
                        break;
                    case "Строчные буквы": password += Convert.ToChar(rnd.Next(97, 122));
                        break;
                    default:
                        password += special_chars[rnd.Next(special_chars.Length)];
                        break;
                }
                tbPassword.Text = password;
                Clipboard.SetText(password);
            }
        }

        private void btnConvert_Click(object sender, EventArgs e)
        {
            double n1 = metrica[cbFrom.Text];
            double n2 = metrica[cbTo.Text];
            double n = Convert.ToDouble(tbFrom.Text);
            tbTo.Text = (n * n1 / n2).ToString();
        }

        private void btnSwap_Click(object sender, EventArgs e)
        {
            string t = cbFrom.Text;
            cbFrom.Text = cbTo.Text;
            cbTo.Text = t;
        }

        private void cbMetric_SelectedIndexChanged(object sender, EventArgs e)
        {
            switch (cbMetric.Text)
            {
                case "длина":
                    metrica.Clear();
                    metrica.Add("mm", 1);
                    metrica.Add("cm", 10);
                    metrica.Add("dm", 100);
                    metrica.Add("m", 1000);
                    metrica.Add("km", 1000000);
                    metrica.Add("mile", 1609344);
                    cbFrom.Items.Clear();
                    cbFrom.Items.Add("mm");
                    cbFrom.Items.Add("cm");
                    cbFrom.Items.Add("dm");
                    cbFrom.Items.Add("m");
                    cbFrom.Items.Add("km");
                    cbFrom.Items.Add("mile");
                    cbTo.Items.Clear();
                    cbTo.Items.Add("mm");
                    cbTo.Items.Add("cm");
                    cbTo.Items.Add("dm");
                    cbTo.Items.Add("m");
                    cbTo.Items.Add("km");
                    cbTo.Items.Add("mile");
                    cbFrom.Text = "mm";
                    cbTo.Text = "mm";
                    break;

                case "вес":
                    metrica.Clear();
                    metrica.Add("g", 1);
                    metrica.Add("kg", 1000);
                    metrica.Add("t", 1000000);
                    metrica.Add("lb", 453.6);
                    metrica.Add("oz", 28.3);                   
                    cbFrom.Items.Clear();
                    cbFrom.Items.Add("g");
                    cbFrom.Items.Add("kg");
                    cbFrom.Items.Add("t");
                    cbFrom.Items.Add("lb");
                    cbFrom.Items.Add("oz");                    
                    cbTo.Items.Clear();
                    cbTo.Items.Add("g");
                    cbTo.Items.Add("kg");
                    cbTo.Items.Add("t");
                    cbTo.Items.Add("lb");
                    cbTo.Items.Add("oz");                    
                    cbFrom.Text = "g";
                    cbTo.Text = "g";
                    break;

                default:
                    break;
            }
        }
    }
}
