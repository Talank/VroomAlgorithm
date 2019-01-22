package Vroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    static List<Customer> customerList;

    Test1(){
        customerList=new ArrayList<>(2);
    }

    static int getMax(){
        return 4;
    }


    static int base_fare=250;
    static int per_km_ride=60;

    public static void main(String[] args){

        //System.out.print("Size "+size +","+customerList.size();

    }
    public static int getValue(String value){

        return Integer.parseInt(value.substring(5));
    }
    public int[] getTest(){
        int total=0;
//        String[] a={"abcdefghijklmnopqrstuvwyz"};
        int arr[]={0,0};
        for(int i=0;i<customerList.size();i++){

            switch (customerList.size()){
                case 1:
                    total=Test.base_fare+Test.per_km_ride*customerList.get(i).getDistance();
                    arr[0]=0;
                    arr[1]=total;
                    break;
                case 2:
                    int x=0,total2=0;
                       /*
                       The sum of each component
                       is always equal to
                        base_fare+ per_km_ride* km
                        */
                    //if starting point of the two customers dont match
                    if (customerList.get(0).getStart_point() != customerList.get(1).getStart_point()) {
                        int m_distance = getValue(customerList.get(1).getStart_point()) - getValue(customerList.get(0).getStart_point());
                        int diff1 = getValue(customerList.get(1).getDest_point()) - getValue(customerList.get(0).getDest_point());
                        //if destination point of second one is greater than first one
                        if (diff1 > 0) {
                            total = Test.base_fare / 2 + m_distance * Test.per_km_ride + (getValue(customerList.get(0).getDest_point()) -getValue(customerList.get(1).getStart_point())) * 30;
                            total2 = total - m_distance * Test.per_km_ride + (getValue(customerList.get(1).getDest_point()) - getValue(customerList.get(0).getDest_point())) * Test.per_km_ride;
                        }
                        //if second one gets drop before first one
                        else{
                            total=Test.base_fare/2 +m_distance*Test.per_km_ride + (getValue(customerList.get(1).getDest_point())-getValue(customerList.get(1).getStart_point()))*30+ (getValue(customerList.get(0).getDest_point())-getValue(customerList.get(1).getDest_point()))*per_km_ride;
                            total2=Test.base_fare/2 +(getValue(customerList.get(1).getDest_point())-getValue(customerList.get(1).getStart_point()))*30;
                        }
                    }
                    else {
                        //this means that the starting of first and second starts from same point
                        int diff=getValue(customerList.get(1).getDest_point())-getValue(customerList.get(0).getDest_point());

                        if(diff>0) {
                            total = Test.base_fare / 2 + Test.per_km_ride / 2 * (getValue(customerList.get(0).getDest_point())-getValue(customerList.get(0).getStart_point()));
                            total2 = total + Test.per_km_ride * diff;
                        }
                        else{
                            total2= Test.base_fare / 2 + Test.per_km_ride / 2 * (getValue(customerList.get(1).getDest_point())-getValue(customerList.get(1).getStart_point()));
                            total=total2-Test.per_km_ride*diff;
                        }

                    }
                    System.out.println("Total:"+total +"Total2:"+total2);
                    arr[0]=total;
                    arr[1]=total2;
                    // total = Test.base_fare / 2 + Test.per_km_ride / 2 * customerList.get(x).getDistance();
                    break;
                case 3:  total=Test.base_fare/3+Test.per_km_ride/3*customerList.get(i).getDistance();
                    break;

                case 4: total=Test.base_fare/4+Test.per_km_ride/4*customerList.get(i).getDistance();

                default: break;
            }
            System.out.println("Id "+customerList.get(i).getId()+"Starting point"+customerList.get(i).getStart_point()+",dest_name"+customerList.get(i).getDest_point()+ "total:"+total);

        }
        return arr;
    }
}


