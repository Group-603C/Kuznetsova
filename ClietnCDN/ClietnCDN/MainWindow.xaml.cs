using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using xNet;

namespace ClietnCDN
{
    /// <summary>
    /// Логика взаимодействия для MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        HttpRequest http = new HttpRequest();
        string url = "http://www.zerocdn.com/";



        private void signIn_Click(object sender, RoutedEventArgs e)
        {



            try
            {
                string login = txtLogin.Text;
                string password = txtPassword.Text;
                http.Cookies = new CookieDictionary();
                string html = http.Get(url).ToString();
                html = http.Post("http://mng.zerocdn.com/api/v2/users/files.json?username=" + "username=" + txtLogin + "&api_key=" + txtPassword).ToString();

            }
            catch (Exception ex)
            {
                throw new xNet.HttpException("Ошибка");
            }


        }
    }

}
