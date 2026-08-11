package DiscountCoupan.managers;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import DiscountCoupan.Coupon.Coupan;
import DiscountCoupan.models.Cart;
import DiscountCouponApplication.coupons.Coupon;
public class CouponManager {
    private static CouponManager instance=new CouponManager();
    private Coupan head;
    private Lock lock=new ReentrantLock();
    
   private CouponManager(){

    }
    public static CouponManager getInstance(){
        return instance;
    }
    public void registerCoupan(Coupan coupan){
        lock.lock();
        try{
            if(head==null){
                head=coupan;
            }
            else{
                Coupan curr=head;
                while(curr.getNext()!=null){
                    curr=curr.getNext();
                }
                curr.setNext(coupan);
            }

        }
        finally{
                lock.unlock();
        }
    }
     public List<String> getApplicable(Cart cart) {
        lock.lock();
        try {
            List<String> res = new ArrayList<>();
            Coupon cur = head;
            while (cur != null) {
                if (cur.isApplicable(cart)) {
                    res.add(cur.name());
                }
                cur = cur.getNext();
            }
            return res;
        } finally {
            lock.unlock();
        }
    }

    public double applyAll(Cart cart) {
        lock.lock();
        try {
            if (head != null) {
                head.applyDiscount(cart);
            }
            return cart.getCurrentPrice();
        } finally {
            lock.unlock();
        }
    }
    
}
