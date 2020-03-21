package server;

import model.PointProcessor;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.codebase", "file://C:/Users/Anastasia/workspace/javaRMILab2Sem4/out/production/javaRMILab2Sem4/model");

            PointProcessor pointProcessorServer = new PointProcessorServer();
            PointProcessor pointProcessor = (PointProcessor) UnicastRemoteObject.exportObject(pointProcessorServer, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("processor", pointProcessor);

            System.out.println("Server is ready");

        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
