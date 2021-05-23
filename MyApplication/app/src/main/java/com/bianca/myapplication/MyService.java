package com.bianca.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MyService extends Service {
    private final IBinder mBinder = (IBinder) new MyBinder();

    public class MyBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public double calculate(String txtExpression){
        try{
            Expression expression = new ExpressionBuilder(txtExpression).build();
            double result = expression.evaluate();
            return result;
            }catch(Exception e){

        }
        return 0;

    }
}