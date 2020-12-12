package com.bramerlabs.simple_math.matrix;

import com.bramerlabs.simple_math.vector.Vector3f;

public class Matrix3f {

    // the values in this matrix
    public float e11, e12, e13, e21, e22, e23, e31, e32, e33;

    /**
     * constructor for all specified values
     *
     * @param e11 - value at (1, 1)
     * @param e12 - value at (1, 2)
     * @param e13 - value at (1, 3)
     * @param e21 - value at (2, 1)
     * @param e22 - value at (2, 2)
     * @param e23 - value at (2, 3)
     * @param e31 - value at (3, 1)
     * @param e32 - value at (3, 2)
     * @param e33 - value at (3, 3)
     */
    public Matrix3f(float e11, float e12, float e13, float e21, float e22, float e23, float e31, float e32, float e33) {
        this.e11 = e11;
        this.e12 = e12;
        this.e13 = e13;
        this.e21 = e21;
        this.e22 = e22;
        this.e23 = e23;
        this.e31 = e31;
        this.e32 = e32;
        this.e33 = e33;
    }

    /**
     * constructor for an array of specified float values
     *
     * @param v - the array of specified float values in the form [e11, e12, ..., e32, e33]
     *          0 or more float values may be used, constructor will automatically fill empty values with 0
     */
    public Matrix3f(float[] v) {
        this.e11 = v.length > 0 ? v[0] : 0;
        this.e12 = v.length > 1 ? v[0] : 0;
        this.e13 = v.length > 2 ? v[0] : 0;
        this.e21 = v.length > 3 ? v[0] : 0;
        this.e22 = v.length > 4 ? v[0] : 0;
        this.e23 = v.length > 5 ? v[0] : 0;
        this.e31 = v.length > 6 ? v[0] : 0;
        this.e32 = v.length > 7 ? v[0] : 0;
        this.e33 = v.length > 8 ? v[0] : 0;
    }

    /**
     * constructor for a 2d array of float values
     * @param v - the array of specified float values in the form [[e11, e12, e13], [...], [...]]
     *          all values must be specified
     */
    public Matrix3f(float[][] v) {
        this.e11 = v[0][0];
        this.e12 = v[0][1];
        this.e13 = v[0][2];
        this.e21 = v[1][0];
        this.e22 = v[1][1];
        this.e23 = v[1][2];
        this.e31 = v[2][0];
        this.e32 = v[2][1];
        this.e33 = v[2][2];
    }

    /**
     * creates a new identity matrix
     * @return - I
     */
    public static Matrix3f identity() {
        return new Matrix3f(new float[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}});
    }

    /**
     * creates a new identity matrix
     * @return - I
     */
    public static Matrix3f I() {
        return new Matrix3f(new float[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}});
    }

    /**
     * performs scalar multiplication on this matrix
     * @param val - the scalar
     * @return - this matrix
     */
    public Matrix3f scalarMult(float val) {
        this.e11 *= val;
        this.e12 *= val;
        this.e13 *= val;
        this.e21 *= val;
        this.e22 *= val;
        this.e23 *= val;
        this.e31 *= val;
        this.e32 *= val;
        this.e33 *= val;
        return this;
    }

    /**
     * generates a scaling matrix from a Vector3f
     * @param v - the vector
     * @return - the scaling matrix
     */
    public Matrix3f createScaleMat(Vector3f v) {
        return new Matrix3f(new float[][]{{v.x, 0, 0}, {0, v.y, 0}, {0, 0, v.z}});
    }
}
