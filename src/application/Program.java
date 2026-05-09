package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        SellerDao sld= DaoFactory.createSellerDao();
        System.out.println("====TEST 1: seller findById==========");
        Seller sl=sld.findById(3);
        System.out.println(sl);

        System.out.println("\n====TEST 2: seller findByDepartment==========");
        Department department=new Department(2,null);
        List<Seller> list=sld.findByDepartment(department);
        for (Seller obj:list){
            System.out.println(obj);
        }

        System.out.println("\n====TEST 3: seller findAll==========");
        list =sld.findAll();
        for (Seller obj:list){
            System.out.println(obj);
        }


        System.out.println("\n====TEST 4: seller insert==========");
        Seller news=new Seller(null,"Greg","greg@gmail.com",new Date(),4000.0,department);
        sld.insert(news);
        System.out.println("inserted! new id="+news.getId());

        System.out.println("\n====TEST 5: seller update==========");
        Seller sell = sld.findById(1);
        sell.setName("Martha Waine");
        sld.update(sell);
        System.out.println("update completed"+sell);

        System.out.println("\n====TEST 6: seller delete==========");
        System.out.println("Enter id for delete teste: ");
        int id=sc.nextInt();
        sld.delete(id);
        System.out.println("Delete completed!");
        sc.close();

    }
}
