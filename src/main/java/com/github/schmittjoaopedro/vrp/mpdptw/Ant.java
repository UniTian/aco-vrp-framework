package com.github.schmittjoaopedro.vrp.mpdptw;

import java.util.ArrayList;

public class Ant {

    public ArrayList<ArrayList<Integer>> tours;

    public ArrayList<ArrayList<Integer>> requests;

    public ArrayList<Double> tourCosts;

    public boolean[] visited;

    public double[] capacity;

    public boolean[] visitedRequests;

    public double[] departureTime;

    public double[] arrivalTime;

    public double[] slackTimes;

    public double[] waitingTimes;

    public double[] slackWaitTimes;

    public double[] delays;

    public int toVisit;

    public double totalCost;

    public boolean feasible;

    public double timeWindowPenalty;

    public double capacityPenalty;

    public double getCost() {
        return totalCost;
    }

}
