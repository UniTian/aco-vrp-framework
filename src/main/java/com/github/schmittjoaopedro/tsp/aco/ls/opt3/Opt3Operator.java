package com.github.schmittjoaopedro.tsp.aco.ls.opt3;

import com.github.schmittjoaopedro.tsp.aco.ls.LocalSearchUtils;
import com.github.schmittjoaopedro.tsp.graph.Graph;
import com.github.schmittjoaopedro.tsp.graph.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Opt3Operator {

    private int[] tour;

    private int distances[][];

    private int n;

    private int nn_ls = 20;

    private int nn_list[][];

    boolean symmetric = true;

    private Graph graph;

    private int subTourMap[];

    private int[] route;

    private int phase;

    private int max = 0;

    private int min = Integer.MAX_VALUE;

    private boolean subTourOptimization = false;

    private boolean keepOriginalDepotPosition = false;

    private Random random;

    public boolean init(Graph graph, Random random, int[] route, int phase) {
        int subGraphLength = graph.getVertexCount() - phase;
        if (phase < 0) {
            return init(graph, random, route);
        } else if (hasSufficientVertices(subGraphLength)) { // number of minimum vertices for US of sub-tour
            this.phase = phase;
            this.route = route;
            subTourOptimization = true;
            subTourMap = LocalSearchUtils.createSubTourMap(route, phase, subGraphLength);
            Graph newGraph = LocalSearchUtils.createSubGraph(subTourMap, graph, route[0], subGraphLength);
            return init(newGraph, random, LocalSearchUtils.createSubTour(subTourMap));
        } else {
            return false;
        }
    }

    public boolean init(Graph graph, Random random, int[] tour) {
        if (hasSufficientVertices(graph.getVertexCount())) { // number of minimum vertices for US
            this.graph = graph;
            this.random = random;
            n = graph.getVertexCount();
            defineStructures(graph, tour);
            symmetric = LocalSearchUtils.isSymmetric(distances);
            if (!symmetric) {
                distances = LocalSearchUtils.asymmetricToSymmetric(distances, min - 1, max + 1);
                tour = LocalSearchUtils.convertToAssymetricTour(tour);
                n = tour.length - 1;
            }
            nn_list = LocalSearchUtils.createNNList(n, nn_ls, distances);
            this.tour = tour;
            // Init from git
            return true;
        } else {
            return false;
        }
    }

    public boolean initStaticVersion(Graph graph, Random random, int[] tour) {
        if (hasSufficientVertices(graph.getVertexCount())) { // number of minimum vertices for US
            this.graph = graph;
            this.random = random;
            if (distances == null) {
                n = graph.getVertexCount();
                defineStructures(graph, tour);
                symmetric = LocalSearchUtils.isSymmetric(distances);
                if (!symmetric) {
                    distances = LocalSearchUtils.asymmetricToSymmetric(distances, min - 1, max + 1);
                    tour = LocalSearchUtils.convertToAssymetricTour(tour);
                    n = tour.length - 1;
                }
                nn_list = LocalSearchUtils.createNNList(n, nn_ls, distances);
            } else if (!symmetric) {
                tour = LocalSearchUtils.convertToAssymetricTour(tour);
            }
            this.tour = tour;
            // Init from git
            return true;
        } else {
            return false;
        }
    }

    public void optimize() {
        LocalSearch3Opt.three_opt_first(random, tour, n, distances, nn_list, nn_ls);
    }

    public int[] getResult() {
        List<Vertex> newRoute = new ArrayList<>();
        for (int i = 0; i < tour.length; i++) {
            if (graph.getVertex(tour[i]) != null) {
                newRoute.add(graph.getVertex(tour[i]));
            }
        }
        int[] newTour = new int[newRoute.size()];
        for (int i = 0; i < newRoute.size(); i++) {
            newTour[i] = newRoute.get(i).getId();
        }
        if (isKeepOriginalDepotPosition()) {
            // Differently of US, the 3-opt operator rotate the depot along the route.
            // Therefore, in sub-tour optimization we fix the first node as depot
            newTour = LocalSearchUtils.getRotatedRouteToFirstNode(newTour, 0);
        }
        return LocalSearchUtils.getResult(subTourOptimization, subTourMap, newTour, route, phase);
    }

    public boolean isKeepOriginalDepotPosition() {
        return keepOriginalDepotPosition;
    }

    public void setKeepOriginalDepotPosition(boolean keepOriginalDepotPosition) {
        this.keepOriginalDepotPosition = keepOriginalDepotPosition;
    }

    private void defineStructures(Graph graph, int[] tour) {
        distances = new int[tour.length - 1][tour.length - 1];
        for (int i = 0; i < graph.getVertexCount(); i++) {
            for (int j = 0; j < graph.getVertexCount(); j++) {
                if (i != j) {
                    distances[i][j] = (int) graph.getEdge(i, j).getCost();
                    max = Math.max(max, distances[i][j]);
                    min = Math.min(min, distances[i][j]);
                }
            }
        }
    }

    private boolean hasSufficientVertices(int i) {
        return i > 9; // Num of min edges necessary to US, to make the operators fair we assume the same value for 3-opt
    }
}
