package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Matrix {

    private double a11;
    private double a12;
    private double a21;
    private double a22;

    public Matrix(double a11, double a12, double a21, double a22) {
        this.a11 = a11;
        this.a12 = a12;
        this.a21 = a21;
        this.a22 = a22;
    }

    public Matrix(Matrix matrix) {
        this.a11 = matrix.a11;
        this.a12 = matrix.a12;
        this.a21 = matrix.a21;
        this.a22 = matrix.a22;
    }

    public Matrix() {
    }

    public double getA11() {
        return a11;
    }

    @XmlElement
    public void setA11(double a11) {
        this.a11 = a11;
    }

    public double getA12() {
        return a12;
    }

    @XmlElement
    public void setA12(double a12) {
        this.a12 = a12;
    }

    public double getA21() {
        return a21;
    }

    @XmlElement
    public void setA21(double a21) {
        this.a21 = a21;
    }

    public double getA22() {
        return a22;
    }

    @XmlElement
    public void setA22(double a22) {
        this.a22 = a22;
    }

    public void sumMatrix(Matrix matrix) {
        this.a11 += matrix.a11;
        this.a12 += matrix.a12;
        this.a21 += matrix.a21;
        this.a22 += matrix.a22;
    }

    public void mulipMatrixleft(Matrix matrix) {
        double tmp11 = this.a11 * matrix.a11 + this.a12 * matrix.a21;
        double tmp12 = this.a11 * matrix.a12 + this.a12 * matrix.a22;
        double tmp21 = this.a21 * matrix.a11 + this.a22 * matrix.a21;
        double tmp22 = this.a21 * matrix.a12 + this.a22 * matrix.a22;
        this.a11 = tmp11;
        this.a12 = tmp12;
        this.a21 = tmp21;
        this.a22 = tmp22;
    }

    public void mulipMatrixright(Matrix matrix) {
        double tmp11 = matrix.a11 * this.a11 + matrix.a12 * this.a21;
        double tmp12 = matrix.a11 * this.a12 + matrix.a12 * this.a22;
        double tmp21 = matrix.a21 * this.a11 + matrix.a22 * this.a21;
        double tmp22 = matrix.a21 * this.a12 + matrix.a22 * this.a22;
        this.a11 = tmp11;
        this.a12 = tmp12;
        this.a21 = tmp21;
        this.a22 = tmp22;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "a11=" + a11 +
                ", a12=" + a12 +
                "\n a21=" + a21 +
                ", a22=" + a22 +
                '}';
    }
}
