using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;


namespace Lesson1
{
    class Program
    {
        static void Main(string[] args)
        {
            DirectoryInfo dir = new DirectoryInfo("D:/TestDir");
            if (!dir.Exists)
            {
                dir.Create();
            }
            /*if (!File.Exists("D:/TestDir/money.txt"))
            {
                File.CreateText("D:/TestDir/money.txt");

            }*/

            StreamWriter sw = File.AppendText("D:/TestDir/money.txt");            

            Console.WriteLine("Привет!");
                        
            double debit, credit, balance;
            double debitSum = 0;

            // Вводим доход
            for (int i = 0; i<5; i++)
            {
                Console.Write("Введите Ваш доход (грн.): ");

                double.TryParse(Console.ReadLine(), out debit);

                debitSum+=debit;                               
            }
            sw.WriteLine(DateTime.Now);
            sw.WriteLine("Ваш доход: {0} грн.", debitSum);
            
            // Вводим расход
            Console.Write("Введите Ваш расход (грн.): ");
            double.TryParse(Console.ReadLine(), out credit);

            sw.WriteLine("Ваш расход: {0} грн.", credit);

            /* расчет
            баланса */

            balance = debitSum - credit;
            sw.WriteLine("Ваш баланс: {0} грн.", balance);

            if (balance > 0)
            {
                sw.WriteLine("Поздравляем! Вы в плюсе!");
            }
            else
            {
                sw.WriteLine("Увы! У Вас долги");
            }

            sw.Close();

            Console.WriteLine("Пока!");
            Console.ReadKey();
        }
    }
}
