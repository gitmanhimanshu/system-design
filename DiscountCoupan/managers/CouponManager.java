package DiscountCoupan.managers;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class CouponManager {
    private static CouponManager instance=new CouponManager();
    
   private CouponManager(){

    }
    public static CouponManager getInstance(){
        return instance;
    }
    
}
