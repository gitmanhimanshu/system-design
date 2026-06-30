package ParkingLot.Payment;

import java.util.Scanner;

public class PaymentService {
  private Payment payment;
  Scanner sc;
  PaymentService(){
      sc=new Scanner(System.in);
      System.out.println("enter money to do payment");
      double amount = sc.nextDouble();
      System.out.println("enter payment method (1 for Credit Card 2 for Net Banking)");
      int choice=sc.nextInt();
      if(choice==1){
        payment=new Payment(new CreditCardPayment());      
  }
  else if (choice==2){
    payment=new Payment(new NetBankingPayment());
  }else {
    System.out.println("Invalid choice");
  }
  payment.processPayment(amount);
}
}
