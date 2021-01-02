package com.janliao.compare;

class Annoyance extends Exception{
    public void test(){
        System.out.println("===========");
    }
}

class Sneeze extends Annoyance{
    public void test1(){
        System.out.println("========");
    }
}

public class Human {
    public static void main(String[] args) {
        Sneeze sn = new Sneeze();
        Annoyance an = new Annoyance();
        Sneeze sne = (Sneeze) an;
        sne.test();
        try{
            try{
                throw new Sneeze();
            } catch (Annoyance a){
                System.out.println("Annoyance");
                throw a;
            }
        } catch (Sneeze s){
            System.out.println("Sneeze");
            return ;
        } finally {
            System.out.println("finally");
        }
    }
}
