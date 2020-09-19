package com.coffeepoweredcrew.state;

public class Paid implements OrderState {

    @Override
    public double handleCancellation() {
        System.out.println("Contact." +
                "0ing payment gateway to roll back transaction");
        return 10;
    }
}
