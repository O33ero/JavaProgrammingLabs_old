

/**
 * {@code TestComplexNumber} - тестирующий класс для {@code ComplexNumber}
 */
public class ComplexNumberTest {
    public static void main(String[] args) {
        ComplexNumber a;
        ComplexNumber b;
        
        try {
            a = new ComplexNumber(1, 1);
            b = new ComplexNumber(2, 2);
            assert new ComplexNumber(3, 3).equals(a.add(b)) : "Failed test #1";
            assert !(new ComplexNumber(1, 1).equals(a.add(b))) : "Failed test #2";
            
            a = new ComplexNumber(1, 1);
            b = new ComplexNumber(2, 2);
            assert new ComplexNumber(-1, -1).equals(a.minus(b)) : "Failed test #3";
            assert new ComplexNumber(0, 0).equals(b.minus(b)) : "Failed test #4";

            a = new ComplexNumber(1, 1);
            b = new ComplexNumber(2, 2);
            assert !a.equals(b) : "Failed test #5";
            
            b = new ComplexNumber(1, 1);
            assert a.equals(b) : "Failed test #6";
            
            a = new ComplexNumber(0, 0);
            b = new ComplexNumber();
            assert a.equals(b) : "Failed test #7"; 

            a = new ComplexNumber(1, 1);
            assert Math.sqrt(2) == a.getAbs() : "Failed test #8";

            a = new ComplexNumber(0, 0);
            assert 0 == a.getAbs() : "Failed test #9";

            a = new ComplexNumber(1, 1);
            assert Math.PI / 4 == a.getArg() : "Failed test #10";

            a = new ComplexNumber(0, 1);
            assert Math.PI / 2 == a.getArg() : "Failed test #11";

            a = new ComplexNumber(0, -1);
            assert 3 * Math.PI / 2 == a.getArg() : "Failed test #12";

            a = new ComplexNumber(0, 1);
            assert 1 == a.getImage() : "Failed test #13";

            a = new ComplexNumber(0, 1);
            assert 0 == a.getReal() : "Failed test #14";

            a = new ComplexNumber(0, 1);
            a.setImage(2);
            assert 2 == a.getImage() : "Failed test #15";

            a.setImage(3);
            assert 3 == a.getImage() : "Failed test #16";

            a.setImage(4);
            assert 4 == a.getImage() : "Failed test #17";

            a = new ComplexNumber(0, 1);
            a.setReal(2);
            assert 2 == a.getReal() : "Failed test #18";

            a.setReal(3);
            assert 3 == a.getReal() : "Failed test #19";

            a.setReal(4);
            assert 4 == a.getReal() : "Failed test #20";

            System.gc();
            
        }
        catch(AssertionError e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("All tests passed!");

    }
}