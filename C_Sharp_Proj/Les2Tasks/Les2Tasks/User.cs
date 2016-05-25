using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Les2Tasks
{
    class User
    {
        string login;
        string firstname;
        string lastname;
        int age;
        readonly string anketfilldate;

        public User (string login, string firstname, string lastname, int age)
        {
            this.login = login;
            this.firstname = firstname;
            this.lastname = lastname;
            this.age = age;
            this.anketfilldate = Convert.ToString(System.DateTime.Now);
        }
        public void Show()
        {
            Console.WriteLine(login);
            Console.WriteLine(firstname);
            Console.WriteLine(lastname);
            Console.WriteLine(age);
            Console.WriteLine(anketfilldate);
        }

    }
}
