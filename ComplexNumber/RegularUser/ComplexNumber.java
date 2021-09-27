
/**
 * {@code ComplexNumber} - класс для описания поля комплексных чисел.
 * Как и обычные комплексные числа, {@code ComplexNumber} задается двумя значениями: {@code real} и {@code image}.
 */ 
public class ComplexNumber {
    private double real;
    private double image;
    private double abs;
    private double phi;

    // Constructors
    public ComplexNumber() {
        this.real = 0;
        this.image = 0;
        this.abs = 0;
        this.phi = 0;
    }
    public ComplexNumber(double real, double image) {
        this.real = real;
        this.image = image;
        this.abs = caclAbs(real, image);
        this.phi = caclArg(real, image);
    }

    //Overrides
    @Override
    public String toString() {
        return Double.toString(real) + " + " + Double.toString(image) + "i";
    }

    @Override
    public int hashCode() {
        return (int) (abs * real * Math.PI + abs * image * Math.PI + real * image * Math.PI);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof ComplexNumber))
            return false;

        ComplexNumber cn = (ComplexNumber) obj;

        return (cn.real == this.real) && (cn.image == this.image);
    }

    // Private methods
    private double caclAbs(double real, double image) {
        return Math.sqrt(real * real + image * image);
    }

    private double caclArg(double real, double image) {
        if (real == 0 && image == 0) return Double.NaN;

        if(real == 0)
            return image > 0 ? Math.PI / 2 : 3 * Math.PI / 2;
        else 
            return Math.atan(image/real);
    }

    // Public non-methods
    public ComplexNumber add(ComplexNumber other) {
        this.real += other.real;
        this.image += other.image;

        return this;
    }

    public ComplexNumber minus(ComplexNumber other) {
        this.real -= other.real;
        this.image -= other.image;

        return this;
    }

    


    // Getters and Setters
    public double getArg() {
        return this.phi;
    }

    public double getReal() {
        return this.real;
    }
    
    public double getImage() {
        return this.image;
    }
    
    public double getAbs() {
        return this.abs;
    }

    public ComplexNumber setReal(double r) {
        this.real = r;
        this.abs = caclAbs(this.real, this.image);
        this.phi = caclArg(this.real, this.image);

        return this;
    }

    public ComplexNumber setImage(double i) {
        this.image = i;
        this.abs = caclAbs(this.real, this.image);
        this.phi = caclArg(this.real, this.image);

        return this;
    }

}








