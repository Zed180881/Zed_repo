using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lesson2
{
    class Program
    {
        static void Main(string[] args)
        {
            MoneyEntry me = new MoneyEntry();

            Console.WriteLine("Здравствуйте!");
            Console.Write("Введите сумму: ");

            string amount = Console.ReadLine();

            Console.Write("Введите дату: ");
            string date = Console.ReadLine();

            me.InitWithString(amount, date);

            Console.WriteLine("Ваша запись: ");
            Console.WriteLine(me.ToString());

            if (me.IsDebit)
                Console.WriteLine("У Вас новый доход!");
            else
                Console.WriteLine("У Вас навый расход!");

            Console.ReadKey();
        }
    }
}
