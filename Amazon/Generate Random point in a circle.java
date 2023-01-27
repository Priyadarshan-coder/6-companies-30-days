class Solution {

    double a;
    double b;
    double r;
    Random rand = null;
    public Solution(double radius, double x_center, double y_center) {
        this.a= x_center;
        this.b= y_center;
        this.r = radius;
        rand = new Random();
    }
    public double[] randPoint() {
        double x = Coordinate(r, a);
         double y = Coordinate(r, b);
        while(dist(x,y) >= r*r){
            x = Coordinate(r, a);
            y = Coordinate(r, b);
        }
        return new double[]{x,y};
    }
    private double dist(double x, double y){
        return (x-a)*(x-a) + (y-b)*(y-b);
    }
    private double Coordinate(double r, double l){
        return l-r+Math.random()*(2*r);
    }
}