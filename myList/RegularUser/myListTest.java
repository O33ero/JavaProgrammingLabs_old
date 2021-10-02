package com.ozzero;

import java.util.Iterator;

public class myListTest {
    public static void main(String[] args) {
        try {
            myList<Integer> lst = new myList<>(5);
            lst.set(0, 1);
            lst.set(1, 2);
            lst.set(2, 3);
            lst.set(3, 4);
            lst.set(4, 5);
            assert 1 == lst.get(0).intValue() : "Failed test #1";
            assert 2 == lst.get(1).intValue() : "Failed test #1";
            assert 3 == lst.get(2).intValue() : "Failed test #1";
            assert 4 == lst.get(3).intValue() : "Failed test #1";
            assert 5 == lst.get(4).intValue() : "Failed test #1";


            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


        
        try {
            myList<Integer> lst = new myList<>(5);
            lst.set(0, 1);
            lst.set(1, 2);
            lst.set(2, 3);
            lst.set(3, 4);
            lst.set(4, 5);

            myList<Integer> other = new myList<>(lst);
            assert 1 == other.get(0).intValue() : "Failed test #2";
            assert 2 == other.get(1).intValue() : "Failed test #2";
            assert 3 == other.get(2).intValue() : "Failed test #2";
            assert 4 == other.get(3).intValue() : "Failed test #2";
            assert 5 == other.get(4).intValue() : "Failed test #2";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            myList<Integer> lst = new myList<>(5);
            lst.set(0, 1);
            lst.set(1, 2);
            lst.set(2, 3);
            lst.set(3, 4);
            lst.set(4, 4);

            lst.pushFront(0);
            assert 0 == lst.get(0).intValue() : "Failed test #3";
            assert 1 == lst.get(1).intValue() : "Failed test #3";
            assert 2 == lst.get(2).intValue() : "Failed test #3";
            assert 6 == lst.size() : "Failed test #3";

            lst.pushFront(-1);
            assert -1 == lst.get(0).intValue() : "Failed test #4";
            assert 0 == lst.get(1).intValue() : "Failed test #4";
            assert 1 == lst.get(2).intValue() : "Failed test #4";
            assert 7 == lst.size() : "Failed test #4";
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            myList<Integer> lst = new myList<>(5);
            lst.set(0, 1);
            lst.set(1, 2);
            lst.set(2, 3);
            lst.set(3, 4);
            lst.set(4, 5);

            lst.pushBack(0);
            assert 0 == lst.get(5).intValue() : "Failed test #5";
            assert 5 == lst.get(4).intValue() : "Failed test #5";
            assert 4 == lst.get(3).intValue() : "Failed test #5";
            assert 6 == lst.size() : "Failed test #5";

            lst.pushBack(-1);
            assert -1 == lst.get(6).intValue() : "Failed test #6";
            assert 0 == lst.get(5).intValue() : "Failed test #6";
            assert 5 == lst.get(4).intValue() : "Failed test #6";
            assert 7 == lst.size() : "Failed test #6";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }




        try {
            myList<Integer> lst = new myList<>(5);
            lst.set(0, 1);
            lst.set(1, 2);
            lst.set(2, 3);
            lst.set(3, 4);
            lst.set(4, 5);

            Integer t = lst.popFront();
            assert 1 == t.intValue() : "Failed test #7";
            assert 4 == lst.size() : "Failed test #7";

            t = lst.popFront();
            assert 2 == t.intValue() : "Failed test #8";
            assert 3 == lst.size() : "Failed test #8";

            t = lst.popFront();
            t = lst.popFront();
            t = lst.popFront();
            assert 5 == t.intValue() : "Failed test #9";
            assert 0 == lst.size() : "Failed test #9";            
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            myList<Integer> lst = new myList<>(5);
            lst.set(0, 1);
            lst.set(1, 2);
            lst.set(2, 3);
            lst.set(3, 4);
            lst.set(4, 5);

            Integer t = lst.popBack();
            assert 5 == t.intValue() : "Failed test #10";
            assert 4 == lst.size() : "Failed test #10";

            t = lst.popBack();
            assert 4 == t.intValue() : "Failed test #11";
            assert 3 == lst.size() : "Failed test #11";

            t = lst.popBack();
            t = lst.popBack();
            t = lst.popBack();
            assert 1 == t.intValue() : "Failed test #12";
            assert 0 == lst.size() : "Failed test #12";            
            
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
        myList<Integer> lst = new myList<>(5);
        lst.set(0, 1);
        lst.set(1, 2);
        lst.set(2, 3);
        lst.set(3, 4);
        lst.set(4, 5);

        int t = lst.erase(2);
        assert 1 == t : "Failed test #13";
        assert 4 == lst.size() : "Failed test #13";

        t = lst.erase(5);
        assert 3 == t : "Failed test #14";
        assert 3 == lst.size() : "Failed test #14";

        t = lst.erase(2);
        assert -1 == t : "Failed test #15";
        assert 3 == lst.size() : "Failed test #15";
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            
            myList<Integer> lst = new myList<>(5);
            lst.set(0, 1);
            lst.set(1, 2);
            lst.set(2, 3);
            lst.set(3, 4);
            lst.set(4, 5);

            int t = lst.erase(1);
            assert 0 == t : "Failed test #16";
            assert 4 == lst.size() : "Failed test #16";

            t = lst.erase(5);
            assert 3 == t : "Failed test #17";
            assert 3 == lst.size() : "Failed test #17";

            t = lst.erase(2);
            assert 0 == t : "Failed test #18";
            assert 2 == lst.size() : "Failed test #18";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            
            myList<Integer> lst = new myList<>(5);
            lst.set(0, 1);
            lst.set(1, 2);
            lst.set(2, 3);
            lst.set(3, 4);
            lst.set(4, 5);

            lst.clear();
            assert 0 == lst.size() : "Faailed test #19";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // try {
            
        //     myList<Integer> lst = new myList<>(5);
        //     lst.set(0, 1);
        //     lst.set(1, 2);
        //     lst.set(2, 3);
        //     lst.set(3, 4);
        //     lst.set(4, 5);

        //     Iterator<Integer> iter = lst.iterator();

        //     Integer a = iter.next();
        //     assert 1 == a.intValue() : "Failed test #20";

        //     Integer b = iter.next();
        //     b = iter.next();
        //     b = iter.next();
        //     assert 4 == b.intValue() : "Failed test #21";

        //     b = iter.next();
        //     assert false == iter.hasNext() : "Failed test #22";
        // }
        // catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }



        // try {
            
        //     myList<Integer> lst = new myList<>(5);
        //     lst.set(0, 1);
        //     lst.set(1, 2);
        //     lst.set(2, 3);
        //     lst.set(3, 4);
        //     lst.set(4, 5);

        //     int i = 0;
        //     for(Integer now : lst) {
        //         assert now.equals(lst.get(i)) : "Failed test #2" + Integer.toString(i + 3);
        //         i++;
        //     }
        // }
        // catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }
    }
}
