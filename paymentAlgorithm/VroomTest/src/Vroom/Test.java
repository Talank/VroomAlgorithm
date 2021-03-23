package Vroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    Test(){

    }

static int getMax(){
        return 4;
}


    static int base_fare=250;
    static int per_km_ride=60;

    public static void main(String[] args){
        int total=0;
        char[] b={'a','b','c','d','e','f','g','h','i','j','k','l'};
        String points[]={"point1","point2","point3","point4"};
//        String[] a={"abcdefghijklmnopqrstuvwyz"};
        List<Customer> customerList=new ArrayList<>(2);

        int size=getMax();
        boolean status=true;



        do {
                if(customerList.size()<size) {

                    System.out.println("Is there a customer?");
                    boolean arrived=true;
                    Scanner value=new Scanner(System.in);
                    arrived=value.nextBoolean();
                    if (arrived) {
                        System.out.println("Hello Customer," + (customerList.size() + 1));
                        System.out.println("How much seats ?");
                        Scanner scanner = new Scanner(System.in);
                        int order = scanner.nextInt();

                        if (order > 0 && order <= 2) {
                            Customer customer;
                            for (int i = 0; i < order; i++) {
                                if (customerList.size() < size) {
                                    System.out.println("Name" + (i + 1));
                                    scanner = new Scanner(System.in);
                                    String input = scanner.next();
                                    System.out.println("Starting Point");
                                    String i_point=scanner.next();
                                    System.out.println("Destination point");
                                    String f_point=scanner.next();
                                    customer=new Customer(input, i_point,f_point, "5:00pm");
                                    customerList.add(customer);
                                    System.out.println(customer.getDistance());
                                }
                            }

                        } else {
                            System.out.println("Sorry!Per customer at most 2 seats");
                            break;
                        }
                    }
                    else{
                        status=false;

                    }
                }
                else {
                        System.out.println("Full stack");
                        status = false;
                        break;
                    }
//            customerList.add(new Customer("B", "P_02", "5:04pm"));
//            customerList.add(new Customer("B", "P_02", "5:04pm"));
        }
        while (status);


        for(int i=0;i<customerList.size();i++){

            switch (customerList.size()){
                case 1:
                        total=Test.base_fare+Test.per_km_ride*customerList.get(i).getDistance();
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
                       // total = Test.base_fare / 2 + Test.per_km_ride / 2 * customerList.get(x).getDistance();
                    break;
                case 3:  total=Test.base_fare/3+Test.per_km_ride/3*customerList.get(i).getDistance();
                            break;

                case 4: total=Test.base_fare/4+Test.per_km_ride/4*customerList.get(i).getDistance();

                default: break;
            }
            System.out.println("Id "+customerList.get(i).getId()+"Starting point"+customerList.get(i).getStart_point()+",dest_name"+customerList.get(i).getDest_point()+ "total:"+total);

        }
        //System.out.print("Size "+size +","+customerList.size();

    }
        public static int getValue(String value){

            return Integer.parseInt(value.substring(5));
        }
}


