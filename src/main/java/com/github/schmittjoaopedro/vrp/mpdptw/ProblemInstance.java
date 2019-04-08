package com.github.schmittjoaopedro.vrp.mpdptw;

import com.github.schmittjoaopedro.vrp.mpdptw.alns.Solution;

import java.util.*;

public class ProblemInstance {

    private int numNodes;

    private int numReq;

    private int numMaxVehicles;

    private double vehicleCapacity;

    private ArrayList<ArrayList<Integer>> neighbors = new ArrayList<>();

    private double[][] distances;

    private double maxDistance;

    private Depot depot;

    private Request[] requests;

    private List<Request>[] pickups;

    private Request[] delivery;

    /*
     * GETTERS and SETTERS
     */

    public int getNumNodes() {
        return numNodes;
    }

    public void setNumNodes(int numNodes) {
        this.numNodes = numNodes;
    }

    public int getNumReq() {
        return numReq;
    }

    public void setNumReq(int numReq) {
        this.numReq = numReq;
    }

    public int getNumMaxVehicles() {
        return numMaxVehicles;
    }

    public void setNumMaxVehicles(int numMaxVehicles) {
        this.numMaxVehicles = numMaxVehicles;
    }

    public double getVehicleCapacity() {
        return vehicleCapacity;
    }

    public void setVehicleCapacity(double vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

    public ArrayList<ArrayList<Integer>> getNeighbors() {
        return neighbors;
    }

    public void setDistances(double[][] distances) {
        this.distances = distances;
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public Request[] getRequests() {
        return requests;
    }

    public void setRequests(Request[] requests) {
        this.requests = requests;
    }

    public void setPickups(List<Request>[] pickups) {
        this.pickups = pickups;
    }

    public void setDelivery(Request[] delivery) {
        this.delivery = delivery;
    }

    /*
     * Functional methods
     */

    public Request getDelivery(int requestId) {
        return delivery[requestId];
    }

    public List<Request> getPickups(int requestId) {
        return pickups[requestId];
    }

    public double dist(int i, int j) {
        return distances[i][j];
    }

    public Integer getRequestId(int node) {
        if (node == getDepot().nodeId) {
            return -1;
        } else {
            return requests[node - 1].requestId;
        }
    }

    public Request getRequest(int node) {
        if (node == getDepot().nodeId) {
            return null;
        } else {
            return requests[node - 1];
        }
    }

    public double twStart(int node) {
        if (node == getDepot().nodeId) {
            return getDepot().twStart;
        } else {
            return getRequest(node).twStart;
        }
    }

    public double twEnd(int node) {
        if (node == getDepot().nodeId) {
            return getDepot().twEnd;
        } else {
            return getRequest(node).twEnd;
        }
    }

    public double demand(int node) {
        if (node == getDepot().nodeId) {
            return 0.0;
        } else {
            return getRequest(node).demand;
        }
    }

    public double serviceTime(int node) {
        if (node == getDepot().nodeId) {
            return 0.0;
        } else {
            return getRequest(node).serviceTime;
        }
    }

    public void calculateMaxDistance() {
        for (int i = 0; i < distances.length; i++) {
            for (int j = 0; j < distances.length; j++) {
                if (i != j) {
                    if (distances[i][j] > maxDistance) {
                        maxDistance = distances[i][j];
                    }
                }
            }
        }
    }

    public void solutionEvaluation(Ant ant) {
        ant.tourCosts = new ArrayList<>(ant.tours.size());
        ant.capacity = new double[getNumNodes()];
        ant.departureTime = new ArrayList<>(ant.tours.size());
        ant.arrivalTime = new ArrayList<>(ant.tours.size());
        ant.departureSlackTimes = new ArrayList<>(ant.tours.size());
        ant.arrivalSlackTimes = new ArrayList<>(ant.tours.size());
        ant.waitingTimes = new ArrayList<>(ant.tours.size());
        ant.delays = new ArrayList<>(ant.tours.size());
        ant.toVisit = getNumNodes();
        ant.totalCost = 0.0;
        ant.feasible = true;
        ant.timeWindowPenalty = 0.0;
        ant.capacityPenalty = 0.0;
        int[] numNodesByRequest = new int[getNumReq()];
        double[] pickupByRequestTime = new double[getNumReq()];
        double[] deliveryByRequestTime = new double[getNumReq()];
        ant.toVisit--; // Remove depot from nodes to visit count
        // For each vehicle
        for (int k = 0; k < ant.tours.size(); k++) {
            List<Integer> tour = ant.tours.get(k);
            ant.arrivalTime.add(new ArrayList<>());
            ant.departureTime.add(new ArrayList<>());
            ant.waitingTimes.add(new ArrayList<>());
            ant.delays.add(new ArrayList<>());
            ant.departureSlackTimes.add(new ArrayList<>());
            ant.arrivalSlackTimes.add(new ArrayList<>());
            double currentTime = depot.twStart;
            double tourCost = 0.0;
            double capacity = 0.0;
            int curr, next;
            Request request;
            LinkedList<Integer> attendedRequests = new LinkedList<>();
            ant.waitingTimes.get(k).add(0.0);
            ant.delays.get(k).add(0.0);
            ant.arrivalTime.get(k).add(currentTime);
            ant.departureTime.get(k).add(currentTime);
            for (int i = 0; i < tour.size() - 1; i++) {
                curr = tour.get(i);
                next = tour.get(i + 1);
                tourCost += dist(curr, next);
                currentTime += dist(curr, next);
                ant.arrivalTime.get(k).add(currentTime);
                ant.waitingTimes.get(k).add(Math.max(0, twStart(next) - ant.arrivalTime.get(k).get(i + 1)));
                currentTime = Math.max(currentTime, twStart(next));
                capacity += demand(next);
                ant.capacity[next] = capacity;
                // For precedence and attendance restrictions
                request = getRequest(next);
                if (request != null) { // Ignore node depot
                    if (request.isPickup) {
                        numNodesByRequest[request.requestId]++;
                        pickupByRequestTime[request.requestId] = currentTime;
                    } else {
                        attendedRequests.add(request.requestId);
                        deliveryByRequestTime[request.requestId] = currentTime;
                    }
                }
                // Check time windows feasibility
                if (currentTime > twEnd(next)) {
                    ant.delays.get(k).add(currentTime - twEnd(next));
                    ant.timeWindowPenalty += ant.delays.get(k).get(i);
                    ant.feasible = false;
                } else {
                    ant.delays.get(k).add(0.0);
                }
                // Check capacity feasibility
                if (capacity > vehicleCapacity) {
                    ant.capacityPenalty += capacity - vehicleCapacity;
                    ant.feasible = false;
                }
                currentTime += serviceTime(next);
                ant.departureTime.get(k).add(currentTime);
            }
            for (Integer requestId : attendedRequests) {
                // Check if all nodes of each request is attended by the same vehicle
                if (numNodesByRequest[requestId] != getPickups(requestId).size()) {
                    ant.feasible = false;
                }
                ant.toVisit -= numNodesByRequest[requestId];
                // Check if all pickups are attended before the delivery
                if (pickupByRequestTime[requestId] >= deliveryByRequestTime[requestId]) {
                    ant.feasible = false;
                } else {
                    ant.toVisit--;
                }
            }
            // Calculate slack times accordingly: Savelsbergh MW. The vehicle routing problem with time windows: Minimizing
            // route duration. ORSA journal on computing. 1992 May;4(2):146-54.
            /*int prev; TODO: Remove after validate with Jean.
            for (int i = 0; i < tour.size(); i++) {
                double cost = 0.0;
                curr = tour.get(i);
                double startTime = Math.max(ant.arrivalTime.get(k).get(i), twStart(curr)); // Departure time of depot will change for each vehicle
                ant.departureSlackTimes.get(k).add(Double.MAX_VALUE);
                for (int j = i; j < tour.size(); j++) {
                    int node = tour.get(j);
                    if (j - i > 0) {
                        prev = tour.get(j - 1);
                        cost = cost + distances[prev][node];
                        if (prev != curr) {
                        }
                    }
                    ant.departureSlackTimes.get(k).set(i, Math.min(ant.departureSlackTimes.get(k).get(i), twEnd(node) - (startTime + cost)));
                    // Service time is aggregated in the cost function after tested the slack time minimization. This is necessary because
                    // service time is not considered to be attended before the end time window of the current client, but is considered
                    // in the cost calculation to achieve the next client.
                    cost += serviceTime(node);
                }
                ant.arrivalSlackTimes.get(k).add(ant.departureSlackTimes.get(k).get(i) + ant.waitingTimes.get(k).get(i));
            }*/
            double slackTime = Double.MAX_VALUE;
            for (int i = tour.size() - 1; i >= 0; i--) {
                curr = tour.get(i);
                slackTime = Math.min(slackTime, twEnd(curr) - ant.departureTime.get(k).get(i) + serviceTime(curr));
                ant.departureSlackTimes.get(k).add(slackTime);
                slackTime += ant.waitingTimes.get(k).get(i);
                ant.arrivalSlackTimes.get(k).add(slackTime);
            }
            Collections.reverse(ant.departureSlackTimes.get(k));
            Collections.reverse(ant.arrivalSlackTimes.get(k));
            ant.tourCosts.add(tourCost);
            ant.totalCost += tourCost;
        }
        // Check that all requests were attended
        if (ant.toVisit != 0) {
            ant.feasible = false;
        }
    }


    public FitnessResult restrictionsEvaluation(List<Integer> tour) {
        FitnessResult fitnessResult = new FitnessResult();
        double currentTime = 0.0;
        double capacity = 0.0;
        double demand, twStart, twEnd, serviceTime;
        int curr, next, reqId;
        for (int i = 0; i < tour.size() - 1; i++) {
            curr = tour.get(i);
            next = tour.get(i + 1);
            if (next == depot.nodeId) {
                twStart = depot.twStart;
                twEnd = depot.twEnd;
                demand = 0.0;
                serviceTime = 0.0;
            } else {
                reqId = next - 1;
                twStart = requests[reqId].twStart;
                twEnd = requests[reqId].twEnd;
                demand = requests[reqId].demand;
                serviceTime = requests[reqId].serviceTime;
            }
            currentTime += distances[curr][next];
            currentTime = Math.max(currentTime, twStart);
            capacity += demand;
            if (currentTime > twEnd) {
                fitnessResult.timeWindowPenalty += currentTime - twEnd;
                fitnessResult.feasible = false;
            }
            if (capacity > vehicleCapacity) {
                fitnessResult.capacityPenalty += capacity - vehicleCapacity;
                fitnessResult.feasible = false;
            }
            currentTime += serviceTime;
        }
        fitnessResult.cost = currentTime;
        return fitnessResult;
    }

    public void restrictionsEvaluation(Ant ant) {
        restrictionsEvaluation(ant, true);
    }

    public void restrictionsEvaluation(Ant ant, boolean noReqsRestriction) {
        ant.totalCost = 0.0;
        ant.feasible = true;
        ant.timeWindowPenalty = 0.0;
        ant.capacityPenalty = 0.0;
        ant.tourCosts.clear();
        for (int k = 0; k < ant.tours.size(); k++) {
            isPrecedenceValid(ant.tours.get(k), ant.requests.get(k));
            ProblemInstance.FitnessResult fitnessResult = restrictionsEvaluation(ant.tours.get(k));
            ant.tourCosts.add(k, fitnessResult.cost);
            ant.totalCost += fitnessResult.cost;
            ant.feasible &= fitnessResult.feasible;
            ant.timeWindowPenalty += fitnessResult.timeWindowPenalty;
            ant.capacityPenalty += fitnessResult.capacityPenalty;
        }
        int attendedRequests = 0;
        for (int i = 0; i < ant.requests.size(); i++) {
            attendedRequests += ant.requests.get(i).size();
        }
        ant.feasible &= ant.tours.size() < getNumMaxVehicles();
        if (attendedRequests != getNumReq() && noReqsRestriction) {
            ant.feasible = false;
        }
        double total = 0.0;
        for (int k = 0; k < ant.tours.size(); k++) {
            ant.tourCosts.set(k, costEvaluation(ant.tours.get(k)));
            total += ant.tourCosts.get(k);
        }
        ant.totalCost = total;
    }

    public void restrictionsEvaluation(Solution solution) {
        solution.totalCost = 0.0;
        solution.feasible = true;
        solution.tourLengths.clear();
        for (int k = 0; k < solution.tours.size(); k++) {
            isPrecedenceValid(solution.tours.get(k), solution.requests.get(k));
            ProblemInstance.FitnessResult fitnessResult = restrictionsEvaluation(solution.tours.get(k));
            solution.tourLengths.add(k, fitnessResult.cost);
            solution.totalCost += fitnessResult.cost;
            solution.feasible &= fitnessResult.feasible;
        }
        int attendedRequests = 0;
        for (int i = 0; i < solution.requests.size(); i++) {
            attendedRequests += solution.requests.get(i).size();
        }
        solution.feasible &= solution.tours.size() < getNumMaxVehicles();
        if (attendedRequests != getNumReq()) {
            solution.feasible = false;
            throw new RuntimeException("Infeasible number of requests");
        }
        double total = 0.0;
        for (int k = 0; k < solution.tours.size(); k++) {
            solution.tourLengths.set(k, costEvaluation(solution.tours.get(k)));
            total += solution.tourLengths.get(k);
        }
        solution.totalCost = total;
    }

    public void isPrecedenceValid(ArrayList<Integer> antTour, ArrayList<Integer> requests) {
        int node;
        Request req;
        Set<Integer> requestsTemp = new HashSet<>();
        Map<Integer, Integer> lastPickupPosition = new HashMap<>();
        Map<Integer, Integer> deliveryPosition = new HashMap<>();
        Map<Integer, Integer> totalPickups = new HashMap<>();
        for (int i = 1; i < antTour.size() - 1; i++) {
            node = antTour.get(i);
            req = this.requests[node - 1];
            if (req.isDeliver) {
                requestsTemp.add(req.requestId);
                deliveryPosition.put(req.requestId, i);
            } else {
                Integer last = lastPickupPosition.get(req.requestId);
                Integer total = totalPickups.get(req.requestId);
                if (last == null || i > last) {
                    last = i;
                }
                lastPickupPosition.put(req.requestId, last);
                if (total == null) {
                    total = 1;
                } else {
                    total++;
                }
                totalPickups.put(req.requestId, total);
            }
        }
        if (requestsTemp.size() != requests.size()) {
            throw new RuntimeException("Invalid number of requests");
        }
        for (int reqId : requests) {
            if (!requestsTemp.contains(reqId)) {
                throw new RuntimeException("Invalid assigned request");
            }
            if (totalPickups.get(reqId) != getPickups(reqId).size()) {
                throw new RuntimeException("Invalid number of pickups assigned");
            }
            if (deliveryPosition.get(reqId) < lastPickupPosition.get(reqId)) {
                throw new RuntimeException("Invalid precedence of pickups and deliveries assigned");
            }
        }
    }

    /**
     * Accordingly: Lu, Q., & Dessouky, M. M. (2006). Discrete Optimization A new insertion-based construction
     * heuristic for solving the pickup and delivery problem with time windows, 175, 672–687.
     */
    public double[] calculateSlackTimesLu(ArrayList<Integer> route) {
        int node, prev, reqId;
        double ei, si, li, cost = 0.0;
        double arrivalTimes[] = new double[route.size()];
        double waitingTimes[] = new double[route.size()];
        for (int k = 1; k < route.size(); k++) {
            prev = route.get(k - 1);
            node = route.get(k);
            if (node == depot.nodeId) {
                ei = depot.twStart;
                si = 0.0;
            } else {
                reqId = node - 1;
                ei = requests[reqId].twStart;
                si = requests[reqId].serviceTime;
            }
            arrivalTimes[k] = cost + distances[prev][node];
            waitingTimes[k] = Math.max(0, ei - arrivalTimes[k]);
            cost = Math.max(ei, arrivalTimes[k]);
            cost += si;
        }
        double[] slackTimes = new double[route.size()];
        for (int k = route.size() - 1; k >= 0; k--) {
            node = route.get(k);
            if (node == depot.nodeId) {
                ei = depot.twStart;
                li = depot.twEnd;
            } else {
                reqId = node - 1;
                ei = requests[reqId].twStart;
                li = requests[reqId].twEnd;
            }
            if (k == route.size() - 1) { // Is last node
                slackTimes[k] = li - Math.max(arrivalTimes[k], ei);
            } else { // Intermediary nodes
                slackTimes[k] = Math.min(li - Math.max(arrivalTimes[k], ei), slackTimes[k + 1] + waitingTimes[k + 1]);
            }
        }
        return slackTimes;
    }

    /**
     * Savelsbergh MW. The vehicle routing problem with time windows: Minimizing route duration.
     * ORSA journal on computing. 1992 May;4(2):146-54.
     */
    public double[] slackTimesSavelsbergh(ArrayList<Integer> route, boolean sumWaitingTimes) {
        double[] slackTimes = new double[route.size()];
        double[] departureTimes = new double[route.size()];
        double[] waitingTimes = new double[route.size()];
        int node, prev, reqId;
        double ei, si, li, arrivalTime = 0.0, waitingTime;
        for (int k = 0; k < route.size(); k++) {
            node = route.get(k);
            if (node == depot.nodeId) {
                ei = depot.twStart;
                si = 0.0;
            } else {
                reqId = node - 1;
                ei = requests[reqId].twStart;
                si = requests[reqId].serviceTime;
            }
            if (k > 0) {
                prev = route.get(k - 1);
                arrivalTime = departureTimes[k - 1] + distances[prev][node]; // Calculate cost to next vertex
            }
            waitingTime = Math.max(0, ei - arrivalTime); // Calculate waiting time
            departureTimes[k] = arrivalTime + waitingTime + si; // Departure time of the current position
            if (k > 0) {
                waitingTimes[k] = waitingTime;
            }
        }
        double departureTime, cost;
        for (int i = 0; i < route.size(); i++) {
            departureTime = departureTimes[i];
            slackTimes[i] = Double.MAX_VALUE;
            cost = 0.0;
            for (int k = i; k < route.size(); k++) {
                node = route.get(k);
                if (node == depot.nodeId) {
                    li = depot.twEnd;
                    si = 0.0;
                } else {
                    reqId = node - 1;
                    li = requests[reqId].twEnd;
                    si = requests[reqId].serviceTime;
                }
                if (k - i > 0) {
                    prev = route.get(k - 1);
                    cost = cost + distances[prev][node] + si;
                }
                slackTimes[i] = Math.min(slackTimes[i], li - (departureTime + cost));
            }
        }
        if (sumWaitingTimes) {
            for (int i = 0; i < slackTimes.length; i++) {
                slackTimes[i] = slackTimes[i] + waitingTimes[i];
            }
        }
        return slackTimes;
    }

    public double costEvaluation(List<Integer> tour) {
        double cost = 0.0;
        for (int i = 0; i < tour.size() - 1; i++) {
            cost += distances[tour.get(i)][tour.get(i + 1)];
        }
        return cost;
    }

    public double costEvaluation(List<Integer> tour, Integer requestToIgnore) {
        double cost = 0.0;
        int from, to;
        int i = 0;
        while (i < tour.size()) {
            from = tour.get(i);
            i++;
            to = tour.get(i);
            while (to != depot.nodeId && requests[to - 1].requestId == requestToIgnore) {
                i++;
                to = tour.get(i);
            }
            cost += distances[from][to];
            if (to == depot.nodeId) {
                break;
            }
        }
        return cost;
    }

    public double costEvaluation(List<Integer> tour, Integer requestToIgnore, int nodeToConsider) {
        double cost = 0.0;
        int from, to;
        int i = 0;
        while (i < tour.size()) {
            from = tour.get(i);
            i++;
            to = tour.get(i);
            while (to != depot.nodeId && requests[to - 1].requestId == requestToIgnore && to != nodeToConsider) {
                i++;
                to = tour.get(i);
            }
            cost += distances[from][to];
            if (to == depot.nodeId) {
                break;
            }
        }
        return cost;
    }

    public class FitnessResult {

        public double cost;

        public double timeWindowPenalty;

        public double capacityPenalty;

        public boolean feasible;

        public FitnessResult() {
            feasible = true;
            timeWindowPenalty = 0.0;
            capacityPenalty = 0.0;
            cost = 0.0;
        }
    }

    // Check if the end time window of node j is achievable departing from node i
    public boolean isFeasible(int i, int j) {
        boolean feasible;
        int reqJ, reqI;
        if (i == 0 && j == 0) {
            feasible = true;
        } else if (i == 0 && j != 0) {
            // from depot we only can go to pickups
            reqJ = j - 1;
            feasible = requests[reqJ].isPickup;
        } else if (i != 0 && j == 0) {
            // from deliveries we can go to depot
            reqI = i - 1;
            feasible = requests[reqI].isDeliver;
        } else {
            reqI = i - 1;
            reqJ = j - 1;
            feasible = requests[reqI].twStart + requests[reqI].serviceTime + distances[i][j] < requests[reqJ].twEnd; // is time feasible
        }
        return feasible;
    }

}
