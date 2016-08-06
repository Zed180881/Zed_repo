package part1.chapter18;

import java.io.*;
import java.util.Properties;

class PhoneBook {
    public static void main(String[] args) throws IOException {
        Properties ht = new Properties();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name, number;
        FileInputStream fin = null;
        boolean changed = false;
        try {
            fin = new FileInputStream("phonebook.dat");
        } catch (FileNotFoundException e) {
        }

        try {
            if (fin != null) {
                ht.load(fin);
                fin.close();
            }
        } catch (IOException e) {
            System.out.println("File read error");
        }
        do {
            System.out.println("Enter name ('exit' for finish):");
            name = br.readLine();
            if (name.equals("exit")) continue;
            System.out.println("Enter number:");
            number = br.readLine();
            ht.put(name, number);
            changed = true;
        } while (!name.equals("exit"));

        if (changed) {
            FileOutputStream fout = new FileOutputStream("phonebook.dat");
            ht.store(fout, "PhoneBook");
            fout.close();
        }
        do {
            System.out.println("Enter name ('exit' for finish):");
            name = br.readLine();
            if (name.equals("exit")) continue;
            number = (String) ht.get(name);
            System.out.println(number);
        } while (!name.equals("exit"));

    }
}
