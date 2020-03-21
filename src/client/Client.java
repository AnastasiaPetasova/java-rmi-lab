package client;

import model.Point;
import model.PointProcessor;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry();

            PointProcessor processor = (PointProcessor) registry.lookup("processor");

            Scanner in = new Scanner(System.in);

            Point a = new Point(in.nextInt(), in.nextInt());
            Point b = new Point(in.nextInt(), in.nextInt());

            System.out.println(processor.distance(a, b));
            System.out.println(processor.circleLengthByCenter(a, b));
            System.out.println(processor.circleSquareByCenter(a, b));
            System.out.println(processor.circleLengthByDiameter(a, b));
            System.out.println(processor.circleSquareByDiameter(a, b));
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
