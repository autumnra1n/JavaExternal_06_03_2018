package controller;

import entity.Train;
import entity.Tunnel;
import service.TrainAdder;
import service.TunnelAdder;
import service.TunnelManager;

import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Train> trains = TrainAdder.addTrains();
        List<Tunnel> tunnels = TunnelAdder.addTunnels();

        TunnelManager tunnelManager = TunnelManager.getInstance(tunnels, trains);
        tunnelManager.processTrains();
    }
}



