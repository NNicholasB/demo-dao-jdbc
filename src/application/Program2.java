package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        DepartmentDao dp= DaoFactory.createDepartmentDao();

        System.out.println("1 test ==Department== findbyId");
        Department dep=dp.findById(1);
        System.out.println(dep);

        System.out.println("\n 2 test ==Department== findAll");
        List<Department> list=new ArrayList<>();
        list=dp.findAll();
        for (Department dt:list){
            System.out.println(dt);
        }

        System.out.println("\n 3 test ==Department== insert");
        Department deps=new Department(null,"HQs");
        System.out.println("Inserted! new dep="+deps);

        System.out.println("\n 4 test ==Department== update");
        Department depa=dp.findById(3);
        depa.setName("ToyFigures");
        dp.update(depa);
        System.out.println("Updated!"+depa);

        System.out.println("\n 5 test ==Department== remove");
        System.out.println("Insert Id for remove test:");
        int id=sc.nextInt();
        dp.deleteById(id);
        System.out.println("Deleted");
        sc.close();
    }


}
