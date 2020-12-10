package com.bramerlabs.simple_math.vector;

import java.util.Objects;

public class Vector3f {

    // x, y, z components of this vector
    private float x, y, z;

    /**
     * constructor for 3 specified values
     * @param x - the x component of this vector
     * @param y - the y component of this vector
     * @param z - the z component of this vector
     */
    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * constructor for float array
     * @param vals - float array containing 0 or more values representing the components of this vector
     */
    public Vector3f(float[] vals) {
        this.x = vals.length > 0 ? vals[0] : 0;
        this.y = vals.length > 1 ? vals[1] : 0;
        this.z = vals.length > 2 ? vals[2] : 0;
    }

    /**
     * constructor for one specified val
     * @param val - value for all 3 components
     */
    public Vector3f(float val) {
        this.x = val;
        this.y = val;
        this.z = val;
    }

    /**
     * constructor for 1 specified value
     * @param n - which value to change (x = 0, y = 1, z = 2)
     * @param val - the value
     */
    public Vector3f(int n, float val) {
        x = n == 0 ? val : 0;
        y = n == 1 ? val : 0;
        z = n == 2 ? val : 0;
    }

    /**
     * constructor for copying another vector
     * @param v - the vector to be copied
     */
    public Vector3f(Vector3f v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    /**
     * default constructor
     * default vector specified as (0, 0, 0)
     */
    public Vector3f() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    /**
     * creates a unit vector
     * @return - a unit vector in the x direction
     */
    public static Vector3f unitX() {
        return new Vector3f(1, 0, 0);
    }

    /**
     * creates a unit vector
     * @return - a unit vector in the y direction
     */
    public static Vector3f unitY() {
        return new Vector3f(0, 1, 0);
    }

    /**
     * creates a unit vector
     * @return - a unit vector in the z direction
     */
    public static Vector3f unitZ() {
        return new Vector3f(0, 0, 1);
    }

    /**
     * adds to each component
     * @param val - the value to be added
     * @return - this vector
     */
    public Vector3f add(float val) {
        this.x = val;
        this.y = val;
        this.z = val;
        return this;
    }

    /**
     * adds a vector to this vector
     * @param v - the vector to be added to this vector
     * @return - this vector
     */
    public Vector3f add(Vector3f v) {
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
        return this;
    }

    /**
     * subtracts a vector from this vector
     * @param v - the vector for this vector to be subtracted by
     * @return - this vector
     */
    public Vector3f sub(Vector3f v) {
        this.x -= v.x;
        this.y -= v.y;
        this.z -= v.z;
        return this;
    }

    /**
     * subtracts to each component
     * @param val - the value to be subtracted
     * @return - this vector
     */
    public Vector3f sub(float val) {
        this.x -= val;
        this.y -= val;
        this.z -= val;
        return this;
    }

    /**
     * scales a vector
     * @param val - the value for the vector to be scaled by
     * @return - this vector
     */
    public Vector3f scale(float val) {
        this.x *= val;
        this.y *= val;
        this.z *= val;
        return this;
    }

    /**
     * calculates the magnitude of this vector
     * @return - the magnitude of this vector
     */
    public float magnitude() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * normalizes this vector
     * @return - this vector
     */
    public Vector3f unitize() {
        return this.scale(1/this.magnitude());
    }

    /**
     * normalizes this vector
     * @return - this vector
     */
    public Vector3f normalize() {
        return this.scale(1/this.magnitude());
    }

    /**
     * normalizes this vector
     * @param val - the magnitude for this vector to be normalized to
     * @return - this vector
     */
    public Vector3f normalize(float val) {
        return this.scale(val/this.magnitude());
    }

    /**
     * creates a new unit vector in the same direction as this vector
     * @return - the new unit vector
     */
    public Vector3f getUnitVector() {
        return new Vector3f(this).scale(1/this.magnitude());
    }

    /**
     * dots another vector against this vector
     * @param v - the other vector
     * @return - the dot product
     */
    public float dot(Vector3f v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    /**
     * dots two vectors together
     * @param v - vector 1
     * @param u - vector 2
     * @return - the dot product of vector 1 and vector 2
     */
    public static float dot(Vector3f v, Vector3f u) {
        return v.x * u.x + v.y * u.y + v.z * u.z;
    }

    /**
     * crosses two vectors
     * @param v - the vector for this vector to be crossed by
     * @return - the cross product
     */
    public Vector3f cross(Vector3f v) {
        float x = this.y * v.z - this.z * v.y;
        float y = this.z * v.x - this.x * v.z;
        float z = this.x * v.y - this.y * v.x;
        return new Vector3f(x, y, z);
    }

    /**
     * crosses two vectors together
     * @param v - vector 1
     * @param u - vector 2
     * @return - the cross product of vector 1 and vector 2
     */
    public static Vector3f cross(Vector3f v, Vector3f u) {
        float x = v.y * u.z - v.z * u.y;
        float y = v.z * u.x - v.x * u.z;
        float z = v.x * u.y - v.y * u.x;
        return new Vector3f(x, y, z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector3f)) return false;
        Vector3f v = (Vector3f) o;
        return v.x == this.x && v.y == this.y && v.z == this.z;
    }

    @Override
    public int hashCode() {
        return 97 * (int)x + 89 * (int)y + 83 * (int)z;
    }

    @Override
    public String toString() {
        return "<" + x + ", " + y + ", " + z + ">";
    }
}