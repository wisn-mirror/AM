package com.wisn.test;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TestGeneric {
    public static void main(String[] args){
        B<String,Integer> a=new  B<String,Integer>();
        a.test1(new callBack<String>() {
            @Override
            public void call(String o) {

            }
        });
        Bi<String,Integer> b=new  Bi<String,Integer>();
        b.test1(new callBack<String>() {
            @Override
            public void call(String o) {

            }
        });
    }
}

class B<String,Integer> extends A<String,Integer>{

}
class Bi<String,Integer> implements Ai<String,Integer>{
    @Override
    public void test1(callBack<String> t) {
        if(t!=null){
            Type[] genericSuperclass = getClass().getGenericInterfaces();
            System.out.println("  "+genericSuperclass);
            for(Type typeOne:genericSuperclass){
                if(typeOne instanceof ParameterizedType){
                    Type type= ((ParameterizedType) typeOne).getActualTypeArguments()[0];
                    System.out.println(" ii "+type);
                    Type[] types= ((ParameterizedType) typeOne).getActualTypeArguments();
                    for(Type aa:types){
                        System.out.println(" ii one : "+ aa);
                    }

                }else if(typeOne instanceof Class<?>){
                    System.out.println(" ii rew"+ (Class<?>)typeOne);
                }
            }
        }
    }
}

class  A<T,B> implements Serializable{
    public void test1(callBack<T> callBack){
        if(callBack!=null){
            Type genericSuperclass = getClass().getGenericSuperclass();
            System.out.println("  "+genericSuperclass);
            if(genericSuperclass instanceof ParameterizedType){
//                clazz = (Class<T>) ;
               Type type= ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
                System.out.println(" dd "+type);
                Type[] types= ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                for(Type typeOne:types){
                    System.out.println(" dd one : "+ typeOne);
                }
            }else if(genericSuperclass instanceof Class<?>){
                System.out.println(" dd rew"+ (Class<?>)genericSuperclass);
            }


        }
    }
}
interface Ai<T,B>{
    void test1(callBack<T> t);
}
interface callBack<T>{
    void  call(T t);
}
