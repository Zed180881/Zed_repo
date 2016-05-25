using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Les2Tasks
{
    class Program
    {
        static void Main(string[] args)
        {
            User user = new User("zed1981", "Petro", "Zelyonka", 34);
            user.Show();           

            Console.ReadKey();
        }
    }
}
