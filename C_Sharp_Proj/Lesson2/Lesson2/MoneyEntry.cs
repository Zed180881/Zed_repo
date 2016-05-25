using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lesson2
{
    class MoneyEntry
    {
        private double _amount;
        /// <summary>
        /// Стандартный конструктор
        /// </summary>
        public MoneyEntry()
        {
            _amount = 0;
            EntryDate = DateTime.Now;
        }

        /// <summary>
        /// Конструктор
        /// </summary>
        /// <param name="amount">Сумма записи</param>
        /// <param name="date">Дата записи</param>

        public MoneyEntry(double amount, DateTime date)
        {
            _amount = amount;
            EntryDate = date;
        }
        /// <summary>
        /// Инициализирует обьект с помощью строк
        /// </summary>
        /// <param name="amount"></param>
        /// <param name="date"></param>
        public void InitWithString(string amount, string date)
        {
            Double.TryParse(amount, out _amount);
            DateTime dt;
            DateTime.TryParse(date, out dt);
            EntryDate = dt;
        }

        public override string ToString()
        {
            return string.Format("{0} от {1}", _amount, EntryDate.Date);
        }
        /// <summary>
        /// Определяет являеться ли запись доходом
        /// </summary>
        public bool IsDebit
        {
            get
            {
                return (_amount >= 0);
            }
            set
            {
                if (value && _amount < 0)
                    _amount = -_amount;
            }
        }

        public double Amount
        {
            get { return _amount; }
            set { _amount = value; }
        }

        public DateTime EntryDate { get; set; }

        
    }
}
