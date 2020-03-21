package model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PointProcessor extends Remote {
    double distance (Point a, Point b) throws RemoteException;
    double circleLengthByCenter(Point center, Point pointOnCircle) throws RemoteException;
    double circleSquareByCenter(Point center, Point pointOnCircle) throws RemoteException;
    double circleLengthByDiameter(Point a, Point b) throws RemoteException;
    double circleSquareByDiameter(Point a, Point b) throws RemoteException;
}
