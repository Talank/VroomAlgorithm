package Vroom;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

/* This represents the test cases of different sitaation for 1 or 2 customers sharing ride  */

    @Test
    public void doTest1(){
        //single customer on taxi
        int arr[]={0,670};
        Test1 test1=new Test1();
        Test1.customerList.add(new Customer("ram","point0","point7","2"));

        assertArrayEquals(arr,test1.getTest());

    }

    /*
        for two customers there would be 6 cases namely,
        a. Two customers on taxi with different initial location in which first customer drops earlier
        b. Two customers on taxi with different initial location in which second customer drops earlier
        c. Two customers on taxi with same initial locations in which first customer drops earlier
        d. Two customers on taxi with same initial locations in which second customer drops earlier
        e. Two customers on taxi with same initial locations and drop off location
        f. Two customers on taxi with same different initial locations but same drop off location
    */

    @Test
    public void doTest2(){
        //case a
         int arr[]={275,395};
        Test1 test1=new Test1();
        Test1.customerList.add(new Customer("ram","point0","point4","2"));
        Test1.customerList.add(new Customer("ramesh","point1","point7","2"));

        assertArrayEquals(arr,test1.getTest());

    }
    @Test
    public void doTest3(){
        //case b
        int arr[]={455,215};
        Test1 test1=new Test1();
        Test1.customerList.add(new Customer("ram","point0","point7","2"));
        Test1.customerList.add(new Customer("ramesh","point1","point4","2"));

        assertArrayEquals(arr,test1.getTest());

    }
    @Test
    public void doTest4(){
        //case c
        int arr[]={245,425};
        Test1 test1=new Test1();
        Test1.customerList.add(new Customer("ram","point0","point4","2"));
        Test1.customerList.add(new Customer("ramesh","point0","point7","2"));

        assertArrayEquals(arr,test1.getTest());

    }
    @Test
    public void doTest5(){
        //case d
        int arr[]={425,245};
        Test1 test1=new Test1();
        Test1.customerList.add(new Customer("ram","point0","point7","2"));
        Test1.customerList.add(new Customer("ramesh","point0","point4","2"));

        assertArrayEquals(arr,test1.getTest());

    }
    @Test
    public void doTest6(){
        //case e
        int arr[]={335,335};
        Test1 test1=new Test1();
        Test1.customerList.add(new Customer("ram","point0","point7","2"));
        Test1.customerList.add(new Customer("ramesh","point0","point7","2"));

        assertArrayEquals(arr,test1.getTest());

    }
    @Test
    public void doTest7(){
        //case e
        int arr[]={275,215};
        Test1 test1=new Test1();
        Test1.customerList.add(new Customer("ram","point0","point4","2"));
        Test1.customerList.add(new Customer("ramesh","point1","point4","2"));

        assertArrayEquals(arr,test1.getTest());

    }

}