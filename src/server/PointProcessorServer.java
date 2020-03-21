package server;

import model.Point;
import model.PointProcessor;

import java.rmi.RemoteException;

public class PointProcessorServer
        implements PointProcessor {

    @Override
    public double distance(Point a, Point b) throws RemoteException {
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();

        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public double circleLengthByCenter(Point center, Point pointOnCircle) throws RemoteException{
        return 2 * Math.PI * distance(center, pointOnCircle);
    }

    @Override
    public double circleSquareByCenter(Point center, Point pointOnCircle) throws RemoteException {
        double radius = distance(center, pointOnCircle);
        return Math.PI * radius * radius;
    }

    @Override
    public double circleLengthByDiameter(Point a, Point b) throws RemoteException {
        return Math.PI * distance(a, b);
    }

    @Override
    public double circleSquareByDiameter(Point a, Point b) throws RemoteException {
        double diameter = distance(a, b);
        return Math.PI * diameter * diameter / 4;
    }
}
