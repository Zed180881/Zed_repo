using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lesson4
{
    class ContactEntry
    {
        public string LastName { get; set; }
        public string FirstName { get; set; }
        public string PhoneNumber { get; set; }
        public string Email { get; set; }
        public ContactEntry()
        {
            LastName = "";
            FirstName = "";
            PhoneNumber = "";
            Email = "";
        }
        public override string ToString()
        {
            return string.Format("{0} {1}; Tel.: {2}; Email: {3}", FirstName, LastName, PhoneNumber, Email);
        }

    }
}
