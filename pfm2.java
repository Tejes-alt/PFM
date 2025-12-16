package demo2;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class pfm2
{
    public static Scanner obj = new Scanner(System.in);

    public static void main(String[] args) throws IOException 
    {
        File file = new File("Transactionlog.csv");
        boolean isNewFile = file.createNewFile();
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

        if (isNewFile) 
        {
            bw.write("Date,TransactionType,Amount,CurrentBalance\n");
            bw.flush();
        }

        String user = "user";
        int password = 123;

        System.out.println("Enter username : ");
        String usercheck = obj.nextLine();
        System.out.println("Enter password : ");
        int passwordcheck = obj.nextInt();
        obj.nextLine();

        if (!usercheck.equals(user) || passwordcheck != password) 
        {
            System.out.println("Invalid Username or Password!");
            bw.close();
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        while (Menu.choice != 8) 
        {
            new Menu();

            String date = sdf.format(new Date());

            switch (Menu.choice) 
            {

                case 1:
                    new Balance();
                    bw.write(date + ",BALANCE_CHECK,0," + Balance.currentbalance + "\n");
                    break;

                case 2:
                    new Add();
                    bw.write(date + ",ADD," + Add.add + "," + Balance.currentbalance + "\n");
                    break;

                case 3:
                    new Delete();
                    bw.write(date + ",DELETE," + Delete.delete + "," + Balance.currentbalance + "\n");
                    break;

                case 4:
                    new Update();
                    bw.write(date + ",UPDATE,0," + Balance.currentbalance + "\n");
                    break;

                case 5:
                    Report.showSummary();
                    break;

                case 6:
                    Report.weeklyReport();
                    break;

                case 7:
                    Report.monthlyReport();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
            bw.flush();
        }

        bw.close();
        System.out.println("CSV log saved successfully!");
    }
}

class Menu                          
{
    static int choice;

    Menu() 
    {
        System.out.println("----------------------------\nPERSONAL FINANCE MANAGER :\n----------------------------\n1.Check Balance \n2.Add Amount \n3.Delete Amount \n4.Update Balance \n5.Total Report\n6.Weekly Report \n7.Monthly Report \n8.Exit");
        choice = pfm2.obj.nextInt();
        pfm2.obj.nextLine();
    }
}

class Balance 
{
    static double currentbalance = 50000;

    Balance() 
    {
        System.out.println("Current Balance : " + currentbalance);
    }
}

class Add extends Balance 
{
    static double add;

    Add() 
    {
        System.out.println("Enter amount to add : ");
        add = pfm2.obj.nextDouble();
        currentbalance += add;
        new Balance();
    }
}

class Delete 
{
    static double delete;

    Delete()
    {
        System.out.println("Enter amount to delete : ");
        delete = pfm2.obj.nextDouble();
        
        if (Balance.currentbalance >= delete) 
        {
            Balance.currentbalance -= delete;
        } 
        else 
        {
            System.out.println("Insufficient Funds!");
        }
        new Balance();
    }
}

class Update 
{
    Update() 
    {
        System.out.println("Enter new balance : ");
        Balance.currentbalance = pfm2.obj.nextDouble();
    }
}

class Report 
{

    static void showSummary() 
    {
        HashMap<String, Double> totals = new HashMap<>();
        totals.put("ADD", 0.0);
        totals.put("DELETE", 0.0);

        try 
        {
            BufferedReader br = new BufferedReader(new FileReader("Transactionlog.csv"));
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) 
            {
                String[] data = line.split(",");
                String type = data[1];
                double amount = Double.parseDouble(data[2]);
                if (totals.containsKey(type)) 
                {
                    totals.put(type, totals.get(type) + amount);
                }
            }
            br.close();

            System.out.println("Total Added : " + totals.get("ADD"));
            System.out.println("Total Deleted : " + totals.get("DELETE"));

        } 
        
        catch (Exception e) 
        {
            System.out.println("Error");
        }
    }

    static void weeklyReport() 
    {
        double total = 0;
        Calendar now = Calendar.getInstance();
        int week = now.get(Calendar.WEEK_OF_YEAR);

        try 
        {
            BufferedReader br = new BufferedReader(new FileReader("Transactionlog.csv"));
            String line;
            br.readLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            while ((line = br.readLine()) != null) 
            {
                String[] data = line.split(",");
                if (!data[1].equals("DELETE"))
                    continue;

                Date d = sdf.parse(data[0]);
                Calendar c = Calendar.getInstance();
                c.setTime(d);

                if (c.get(Calendar.WEEK_OF_YEAR) == week) 
                {
                    total += Double.parseDouble(data[2]);
                }
            }
            br.close();

            System.out.println("Weekly Expense : " + total);
            
        } 
        
        catch (Exception e) 
        {
            System.out.println("Error");
        }
    }

    static void monthlyReport() 
    {
        double total = 0;
        Calendar now = Calendar.getInstance();
        int month = now.get(Calendar.MONTH);

        try 
        {
            BufferedReader br = new BufferedReader(new FileReader("Transactionlog.csv"));
            String line;
            br.readLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            while ((line = br.readLine()) != null) 
            {
                String[] data = line.split(",");
                if (!data[1].equals("DELETE"))
                    continue;

                Date d = sdf.parse(data[0]);
                Calendar c = Calendar.getInstance();
                c.setTime(d);

                if (c.get(Calendar.MONTH) == month) 
                {
                    total += Double.parseDouble(data[2]);
                }
            }
            br.close();

            System.out.println("Monthly Expense : " + total);

        } 
   
        catch (Exception e) 
        {
            System.out.println("Error");
        }
    }
}

