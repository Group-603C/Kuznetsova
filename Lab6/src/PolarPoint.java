public class PolarPoint {

    private double rho;
    private double phi;

    PolarPoint(double rho, double phi)
    {
        this.rho=rho;
        this.phi=phi;
    }

    double getRho()
    {
        return rho;
    }

    double getPhi()
    {
        return phi;
    }

    Point toCartesian() {

        return new Point(rho * Math.cos(phi), rho * Math.sin(phi));
    }
}
