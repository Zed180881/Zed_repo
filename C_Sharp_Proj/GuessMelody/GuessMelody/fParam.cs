using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GuessMelody
{
    public partial class fParam : Form
    {
        public fParam()
        {
            InitializeComponent();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            Set();
            this.Hide();
        }

        private void btnOk_Click(object sender, EventArgs e)
        {
            Victorina.allDirectories = cbInclFolders.Checked;
            Victorina.gameDuration = Convert.ToInt32(cmbGameDuration.Text);
            Victorina.musicDuration = Convert.ToInt32(cmbMusicDuration.Text);
            Victorina.randomStart = cbRandomStart.Checked;
            Victorina.WriteParam();
            this.Hide();
        }

        private void btnClearList_Click(object sender, EventArgs e)
        {
            lbSongList.Items.Clear();
        }

        private void btnSelectFolder_Click(object sender, EventArgs e)
        {
            FolderBrowserDialog fbd = new FolderBrowserDialog();
            
            if (fbd.ShowDialog() != DialogResult.Cancel)
            {
                string[] music_list = System.IO.Directory.GetFiles(fbd.SelectedPath, "*.mp3", cbInclFolders.Checked?System.IO.SearchOption.AllDirectories:System.IO.SearchOption.TopDirectoryOnly);
                Victorina.lastFolder = fbd.SelectedPath;
                lbSongList.Items.Clear();
                lbSongList.Items.AddRange(music_list);
                Victorina.list.Clear();
                Victorina.list.AddRange(music_list);
            }
        }

        private void fParam_Load(object sender, EventArgs e)
        {
            Set();
            lbSongList.Items.Clear();
            lbSongList.Items.AddRange(Victorina.list.ToArray());
        }

        void Set()
        {
            cbInclFolders.Checked = Victorina.allDirectories;
            cmbGameDuration.Text = Victorina.gameDuration.ToString();
            cmbMusicDuration.Text = Victorina.musicDuration.ToString();
            cbRandomStart.Checked = Victorina.randomStart;
        }
    }
}
