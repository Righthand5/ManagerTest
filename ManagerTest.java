package ManagerTest;
import java.util.*;
import java.sql.SQLOutput;
import java.util.GregorianCalendar;

public class ManagerTest {
    public static void main(String[] args) {
        Manager boss=new Manager("Carl Cracker",80000,1987,12,15);
        boss.setBonus(5000);
        Employee[] staff=new Employee[3];//定义三个雇员的数组将经理和雇员都放在数组中
        staff[0]=boss;
        staff[1]=new Employee("Harry Hacker",50000,1989,10,1);
        staff[2]=new Employee("Tommy Tester",40000,1990,3,15);
        for(Employee e:staff)//虚拟机知道e的实际应用的对象类型能够正确的调用，一个对象变量可以以应用多种实际类型的现象被称为多态性，在
            //在运行中能够自动选择调用的适当的方法得现象被称为动态绑定。
        {
            System.out.println("name="+e.getName()+",salary="+e.getSalary());
        }
    }
}
class Employee
{
    public  Employee(String n,double s,int year,int month,int day){
        name=n;
        salary=s;
        GregorianCalendar calendar=new GregorianCalendar(year,month-1,day);
        hireDay=calendar.getTime();
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return  salary;
    }
    public Date getHireDay(){
        return hireDay;
    }
    public void raiseSalary(double byPercent)
    {
        double raise=salary * byPercent/100;
        salary+=raise;
    }
    private String name;
    private double salary;
    private Date hireDay;
}
class Manager extends Employee{
    public Manager(String n,double s,int year,int month,int day)
    {
        super(n,s,year,month,day);//是调用超类super在构造器中的作用调用超类Employee中含有n,s,year,month,day参数的构造器的简写形式
        bonus=0;
    }
    public double getSalary()
    {
        double baseSalary=super.getSalary();
        return baseSalary+bonus;
    }
    public void setBonus(double b)//在Manager类中，增加了一个用于储存奖金信息的域，以及一个用于设置这个域方法的
    {
        bonus = b;
    }
    private double bonus;
}

