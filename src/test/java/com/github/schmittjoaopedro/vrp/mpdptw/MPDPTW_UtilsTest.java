package com.github.schmittjoaopedro.vrp.mpdptw;

import com.github.schmittjoaopedro.vrp.dvrptw.DVRPTW_ACS_Test;
import com.github.schmittjoaopedro.vrp.mpdptw.coelho.InsertionOperator;
import com.github.schmittjoaopedro.vrp.mpdptw.coelho.RemovalOperator;
import com.github.schmittjoaopedro.vrp.mpdptw.coelho.Req;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class MPDPTW_UtilsTest {

    private static final String rootDirectory;

    static {
        rootDirectory = Paths.get(DVRPTW_ACS_Test.class.getClassLoader().getResource("mpdptw").getFile().substring(1)).toString();
    }

    @Test
    public void mpdptw_large_4_25_1_test() throws IOException {
        ProblemInstance problemInstance = DataReader.getProblemInstance(Paths.get(rootDirectory, "l_4_25_1.txt").toFile());
        assertThat(problemInstance.noNodes).isEqualTo(26);
        assertThat(problemInstance.noReq).isEqualTo(8);
        assertThat(problemInstance.noMaxVehicles).isEqualTo(15);
        assertThat(problemInstance.vehicleCapacity).isEqualTo(200);
        // Depot
        assertThat(problemInstance.depot.nodeId).isEqualTo(0);
        assertThat(problemInstance.depot.x).isEqualTo(250);
        assertThat(problemInstance.depot.y).isEqualTo(250);
        assertThat(problemInstance.depot.twStart).isEqualTo(0);
        assertThat(problemInstance.depot.twEnd).isEqualTo(1925);

        // Request 1
        assertThat(problemInstance.pickups.get(0).get(0).nodeId).isEqualTo(1);
        assertThat(problemInstance.pickups.get(0).get(0).requestId).isEqualTo(0);
        assertThat(problemInstance.pickups.get(0).get(0).x).isEqualTo(396);
        assertThat(problemInstance.pickups.get(0).get(0).y).isEqualTo(417);
        assertThat(problemInstance.pickups.get(0).get(0).demand).isEqualTo(13);
        assertThat(problemInstance.pickups.get(0).get(0).twStart).isEqualTo(520);
        assertThat(problemInstance.pickups.get(0).get(0).twEnd).isEqualTo(1130);
        assertThat(problemInstance.pickups.get(0).get(0).serviceTime).isEqualTo(10);
        assertThat(problemInstance.pickups.get(0).get(0).isPickup).isTrue();
        assertThat(problemInstance.pickups.get(0).get(0).isDeliver).isFalse();

        assertThat(problemInstance.delivery.get(0).nodeId).isEqualTo(2);
        assertThat(problemInstance.delivery.get(0).requestId).isEqualTo(0);
        assertThat(problemInstance.delivery.get(0).x).isEqualTo(51);
        assertThat(problemInstance.delivery.get(0).y).isEqualTo(286);
        assertThat(problemInstance.delivery.get(0).demand).isEqualTo(-13);
        assertThat(problemInstance.delivery.get(0).twStart).isEqualTo(1169);
        assertThat(problemInstance.delivery.get(0).twEnd).isEqualTo(1779);
        assertThat(problemInstance.delivery.get(0).serviceTime).isEqualTo(10);
        assertThat(problemInstance.delivery.get(0).isPickup).isFalse();
        assertThat(problemInstance.delivery.get(0).isDeliver).isTrue();

        // Request 2
        assertThat(problemInstance.pickups.get(1).get(0).nodeId).isEqualTo(3);
        assertThat(problemInstance.pickups.get(1).get(0).requestId).isEqualTo(1);
        assertThat(problemInstance.pickups.get(1).get(0).x).isEqualTo(288);
        assertThat(problemInstance.pickups.get(1).get(0).y).isEqualTo(439);
        assertThat(problemInstance.pickups.get(1).get(0).demand).isEqualTo(16);
        assertThat(problemInstance.pickups.get(1).get(0).twStart).isEqualTo(0);
        assertThat(problemInstance.pickups.get(1).get(0).twEnd).isEqualTo(593);
        assertThat(problemInstance.pickups.get(1).get(0).serviceTime).isEqualTo(10);
        assertThat(problemInstance.pickups.get(1).get(0).isPickup).isTrue();
        assertThat(problemInstance.pickups.get(1).get(0).isDeliver).isFalse();

        assertThat(problemInstance.pickups.get(1).get(1).nodeId).isEqualTo(4);
        assertThat(problemInstance.pickups.get(1).get(1).requestId).isEqualTo(1);
        assertThat(problemInstance.pickups.get(1).get(1).x).isEqualTo(399);
        assertThat(problemInstance.pickups.get(1).get(1).y).isEqualTo(175);
        assertThat(problemInstance.pickups.get(1).get(1).demand).isEqualTo(13);
        assertThat(problemInstance.pickups.get(1).get(1).twStart).isEqualTo(457);
        assertThat(problemInstance.pickups.get(1).get(1).twEnd).isEqualTo(1067);
        assertThat(problemInstance.pickups.get(1).get(1).serviceTime).isEqualTo(10);
        assertThat(problemInstance.pickups.get(1).get(1).isPickup).isTrue();
        assertThat(problemInstance.pickups.get(1).get(1).isDeliver).isFalse();

        assertThat(problemInstance.pickups.get(1).get(2).nodeId).isEqualTo(5);
        assertThat(problemInstance.pickups.get(1).get(2).requestId).isEqualTo(1);
        assertThat(problemInstance.pickups.get(1).get(2).x).isEqualTo(247);
        assertThat(problemInstance.pickups.get(1).get(2).y).isEqualTo(306);
        assertThat(problemInstance.pickups.get(1).get(2).demand).isEqualTo(33);
        assertThat(problemInstance.pickups.get(1).get(2).twStart).isEqualTo(0);
        assertThat(problemInstance.pickups.get(1).get(2).twEnd).isEqualTo(366);
        assertThat(problemInstance.pickups.get(1).get(2).serviceTime).isEqualTo(10);
        assertThat(problemInstance.pickups.get(1).get(2).isPickup).isTrue();
        assertThat(problemInstance.pickups.get(1).get(2).isDeliver).isFalse();

        assertThat(problemInstance.delivery.get(1).nodeId).isEqualTo(6);
        assertThat(problemInstance.delivery.get(1).requestId).isEqualTo(1);
        assertThat(problemInstance.delivery.get(1).x).isEqualTo(274);
        assertThat(problemInstance.delivery.get(1).y).isEqualTo(261);
        assertThat(problemInstance.delivery.get(1).demand).isEqualTo(-62);
        assertThat(problemInstance.delivery.get(1).twStart).isEqualTo(1417);
        assertThat(problemInstance.delivery.get(1).twEnd).isEqualTo(1925);
        assertThat(problemInstance.delivery.get(1).serviceTime).isEqualTo(10);
        assertThat(problemInstance.delivery.get(1).isPickup).isFalse();
        assertThat(problemInstance.delivery.get(1).isDeliver).isTrue();

        // Request 3
        assertThat(problemInstance.pickups.get(2).get(0).nodeId).isEqualTo(7);
        assertThat(problemInstance.pickups.get(2).get(0).requestId).isEqualTo(2);
        assertThat(problemInstance.pickups.get(2).get(0).x).isEqualTo(176);
        assertThat(problemInstance.pickups.get(2).get(0).y).isEqualTo(199);
        assertThat(problemInstance.pickups.get(2).get(0).demand).isEqualTo(28);
        assertThat(problemInstance.pickups.get(2).get(0).twStart).isEqualTo(0);
        assertThat(problemInstance.pickups.get(2).get(0).twEnd).isEqualTo(399);
        assertThat(problemInstance.pickups.get(2).get(0).serviceTime).isEqualTo(10);
        assertThat(problemInstance.pickups.get(2).get(0).isPickup).isTrue();
        assertThat(problemInstance.pickups.get(2).get(0).isDeliver).isFalse();

        assertThat(problemInstance.delivery.get(2).nodeId).isEqualTo(8);
        assertThat(problemInstance.delivery.get(2).requestId).isEqualTo(2);
        assertThat(problemInstance.delivery.get(2).x).isEqualTo(461);
        assertThat(problemInstance.delivery.get(2).y).isEqualTo(182);
        assertThat(problemInstance.delivery.get(2).demand).isEqualTo(-28);
        assertThat(problemInstance.delivery.get(2).twStart).isEqualTo(339);
        assertThat(problemInstance.delivery.get(2).twEnd).isEqualTo(949);
        assertThat(problemInstance.delivery.get(2).serviceTime).isEqualTo(10);
        assertThat(problemInstance.delivery.get(2).isPickup).isFalse();
        assertThat(problemInstance.delivery.get(2).isDeliver).isTrue();

        // Request 4
        assertThat(problemInstance.pickups.get(3).get(0).nodeId).isEqualTo(9);
        assertThat(problemInstance.pickups.get(3).get(0).requestId).isEqualTo(3);
        assertThat(problemInstance.pickups.get(3).get(0).x).isEqualTo(489);
        assertThat(problemInstance.pickups.get(3).get(0).y).isEqualTo(159);
        assertThat(problemInstance.pickups.get(3).get(0).demand).isEqualTo(29);
        assertThat(problemInstance.pickups.get(3).get(0).twStart).isEqualTo(1138);
        assertThat(problemInstance.pickups.get(3).get(0).twEnd).isEqualTo(1748);
        assertThat(problemInstance.pickups.get(3).get(0).serviceTime).isEqualTo(10);
        assertThat(problemInstance.pickups.get(3).get(0).isPickup).isTrue();
        assertThat(problemInstance.pickups.get(3).get(0).isDeliver).isFalse();

        assertThat(problemInstance.pickups.get(3).get(1).nodeId).isEqualTo(10);
        assertThat(problemInstance.pickups.get(3).get(1).requestId).isEqualTo(3);
        assertThat(problemInstance.pickups.get(3).get(1).x).isEqualTo(323);
        assertThat(problemInstance.pickups.get(3).get(1).y).isEqualTo(29);
        assertThat(problemInstance.pickups.get(3).get(1).demand).isEqualTo(7);
        assertThat(problemInstance.pickups.get(3).get(1).twStart).isEqualTo(847);
        assertThat(problemInstance.pickups.get(3).get(1).twEnd).isEqualTo(1457);
        assertThat(problemInstance.pickups.get(3).get(1).serviceTime).isEqualTo(0);
        assertThat(problemInstance.pickups.get(3).get(1).isPickup).isTrue();
        assertThat(problemInstance.pickups.get(3).get(1).isDeliver).isFalse();

        assertThat(problemInstance.pickups.get(3).get(2).nodeId).isEqualTo(11);
        assertThat(problemInstance.pickups.get(3).get(2).requestId).isEqualTo(3);
        assertThat(problemInstance.pickups.get(3).get(2).x).isEqualTo(385);
        assertThat(problemInstance.pickups.get(3).get(2).y).isEqualTo(58);
        assertThat(problemInstance.pickups.get(3).get(2).demand).isEqualTo(24);
        assertThat(problemInstance.pickups.get(3).get(2).twStart).isEqualTo(115);
        assertThat(problemInstance.pickups.get(3).get(2).twEnd).isEqualTo(725);
        assertThat(problemInstance.pickups.get(3).get(2).serviceTime).isEqualTo(10);
        assertThat(problemInstance.pickups.get(3).get(2).isPickup).isTrue();
        assertThat(problemInstance.pickups.get(3).get(2).isDeliver).isFalse();

        assertThat(problemInstance.delivery.get(3).nodeId).isEqualTo(12);
        assertThat(problemInstance.delivery.get(3).requestId).isEqualTo(3);
        assertThat(problemInstance.delivery.get(3).x).isEqualTo(226);
        assertThat(problemInstance.delivery.get(3).y).isEqualTo(175);
        assertThat(problemInstance.delivery.get(3).demand).isEqualTo(-60);
        assertThat(problemInstance.delivery.get(3).twStart).isEqualTo(1404);
        assertThat(problemInstance.delivery.get(3).twEnd).isEqualTo(1925);
        assertThat(problemInstance.delivery.get(3).serviceTime).isEqualTo(10);
        assertThat(problemInstance.delivery.get(3).isPickup).isFalse();
        assertThat(problemInstance.delivery.get(3).isDeliver).isTrue();

        // Request 5
        assertThat(problemInstance.pickups.get(4).get(0).nodeId).isEqualTo(13);
        assertThat(problemInstance.pickups.get(4).get(0).requestId).isEqualTo(4);
        assertThat(problemInstance.pickups.get(4).get(0).x).isEqualTo(471);
        assertThat(problemInstance.pickups.get(4).get(0).y).isEqualTo(368);
        assertThat(problemInstance.pickups.get(4).get(0).demand).isEqualTo(19);
        assertThat(problemInstance.pickups.get(4).get(0).twStart).isEqualTo(138);
        assertThat(problemInstance.pickups.get(4).get(0).twEnd).isEqualTo(748);
        assertThat(problemInstance.pickups.get(4).get(0).serviceTime).isEqualTo(10);
        assertThat(problemInstance.pickups.get(4).get(0).isPickup).isTrue();
        assertThat(problemInstance.pickups.get(4).get(0).isDeliver).isFalse();

        assertThat(problemInstance.delivery.get(4).nodeId).isEqualTo(14);
        assertThat(problemInstance.delivery.get(4).requestId).isEqualTo(4);
        assertThat(problemInstance.delivery.get(4).x).isEqualTo(490);
        assertThat(problemInstance.delivery.get(4).y).isEqualTo(286);
        assertThat(problemInstance.delivery.get(4).demand).isEqualTo(-19);
        assertThat(problemInstance.delivery.get(4).twStart).isEqualTo(232);
        assertThat(problemInstance.delivery.get(4).twEnd).isEqualTo(842);
        assertThat(problemInstance.delivery.get(4).serviceTime).isEqualTo(10);
        assertThat(problemInstance.delivery.get(4).isPickup).isFalse();
        assertThat(problemInstance.delivery.get(4).isDeliver).isTrue();

        // Request 6
        assertThat(problemInstance.pickups.get(5).get(0).nodeId).isEqualTo(15);
        assertThat(problemInstance.pickups.get(5).get(0).requestId).isEqualTo(5);
        assertThat(problemInstance.pickups.get(5).get(0).x).isEqualTo(253);
        assertThat(problemInstance.pickups.get(5).get(0).y).isEqualTo(50);
        assertThat(problemInstance.pickups.get(5).get(0).demand).isEqualTo(27);
        assertThat(problemInstance.pickups.get(5).get(0).twStart).isEqualTo(0);
        assertThat(problemInstance.pickups.get(5).get(0).twEnd).isEqualTo(546);
        assertThat(problemInstance.pickups.get(5).get(0).serviceTime).isEqualTo(10);
        assertThat(problemInstance.pickups.get(5).get(0).isPickup).isTrue();
        assertThat(problemInstance.pickups.get(5).get(0).isDeliver).isFalse();

        assertThat(problemInstance.pickups.get(5).get(1).nodeId).isEqualTo(16);
        assertThat(problemInstance.pickups.get(5).get(1).requestId).isEqualTo(5);
        assertThat(problemInstance.pickups.get(5).get(1).x).isEqualTo(0);
        assertThat(problemInstance.pickups.get(5).get(1).y).isEqualTo(356);
        assertThat(problemInstance.pickups.get(5).get(1).demand).isEqualTo(13);
        assertThat(problemInstance.pickups.get(5).get(1).twStart).isEqualTo(796);
        assertThat(problemInstance.pickups.get(5).get(1).twEnd).isEqualTo(1406);
        assertThat(problemInstance.pickups.get(5).get(1).serviceTime).isEqualTo(10);
        assertThat(problemInstance.pickups.get(5).get(1).isPickup).isTrue();
        assertThat(problemInstance.pickups.get(5).get(1).isDeliver).isFalse();

        assertThat(problemInstance.delivery.get(5).nodeId).isEqualTo(17);
        assertThat(problemInstance.delivery.get(5).requestId).isEqualTo(5);
        assertThat(problemInstance.delivery.get(5).x).isEqualTo(209);
        assertThat(problemInstance.delivery.get(5).y).isEqualTo(212);
        assertThat(problemInstance.delivery.get(5).demand).isEqualTo(-40);
        assertThat(problemInstance.delivery.get(5).twStart).isEqualTo(1238);
        assertThat(problemInstance.delivery.get(5).twEnd).isEqualTo(1848);
        assertThat(problemInstance.delivery.get(5).serviceTime).isEqualTo(10);
        assertThat(problemInstance.delivery.get(5).isPickup).isFalse();
        assertThat(problemInstance.delivery.get(5).isDeliver).isTrue();

        // Request 7
        assertThat(problemInstance.pickups.get(6).get(0).nodeId).isEqualTo(18);
        assertThat(problemInstance.pickups.get(6).get(0).requestId).isEqualTo(6);
        assertThat(problemInstance.pickups.get(6).get(0).x).isEqualTo(144);
        assertThat(problemInstance.pickups.get(6).get(0).y).isEqualTo(35);
        assertThat(problemInstance.pickups.get(6).get(0).demand).isEqualTo(26);
        assertThat(problemInstance.pickups.get(6).get(0).twStart).isEqualTo(0);
        assertThat(problemInstance.pickups.get(6).get(0).twEnd).isEqualTo(549);
        assertThat(problemInstance.pickups.get(6).get(0).serviceTime).isEqualTo(10);
        assertThat(problemInstance.pickups.get(6).get(0).isPickup).isTrue();
        assertThat(problemInstance.pickups.get(6).get(0).isDeliver).isFalse();

        assertThat(problemInstance.pickups.get(6).get(1).nodeId).isEqualTo(19);
        assertThat(problemInstance.pickups.get(6).get(1).requestId).isEqualTo(6);
        assertThat(problemInstance.pickups.get(6).get(1).x).isEqualTo(154);
        assertThat(problemInstance.pickups.get(6).get(1).y).isEqualTo(374);
        assertThat(problemInstance.pickups.get(6).get(1).demand).isEqualTo(36);
        assertThat(problemInstance.pickups.get(6).get(1).twStart).isEqualTo(647);
        assertThat(problemInstance.pickups.get(6).get(1).twEnd).isEqualTo(1257);
        assertThat(problemInstance.pickups.get(6).get(1).serviceTime).isEqualTo(10);
        assertThat(problemInstance.pickups.get(6).get(1).isPickup).isTrue();
        assertThat(problemInstance.pickups.get(6).get(1).isDeliver).isFalse();

        assertThat(problemInstance.pickups.get(6).get(2).nodeId).isEqualTo(20);
        assertThat(problemInstance.pickups.get(6).get(2).requestId).isEqualTo(6);
        assertThat(problemInstance.pickups.get(6).get(2).x).isEqualTo(452);
        assertThat(problemInstance.pickups.get(6).get(2).y).isEqualTo(484);
        assertThat(problemInstance.pickups.get(6).get(2).demand).isEqualTo(26);
        assertThat(problemInstance.pickups.get(6).get(2).twStart).isEqualTo(988);
        assertThat(problemInstance.pickups.get(6).get(2).twEnd).isEqualTo(1598);
        assertThat(problemInstance.pickups.get(6).get(2).serviceTime).isEqualTo(0);
        assertThat(problemInstance.pickups.get(6).get(2).isPickup).isTrue();
        assertThat(problemInstance.pickups.get(6).get(2).isDeliver).isFalse();

        assertThat(problemInstance.delivery.get(6).nodeId).isEqualTo(21);
        assertThat(problemInstance.delivery.get(6).requestId).isEqualTo(6);
        assertThat(problemInstance.delivery.get(6).x).isEqualTo(485);
        assertThat(problemInstance.delivery.get(6).y).isEqualTo(428);
        assertThat(problemInstance.delivery.get(6).demand).isEqualTo(-88);
        assertThat(problemInstance.delivery.get(6).twStart).isEqualTo(1200);
        assertThat(problemInstance.delivery.get(6).twEnd).isEqualTo(1810);
        assertThat(problemInstance.delivery.get(6).serviceTime).isEqualTo(10);
        assertThat(problemInstance.delivery.get(6).isPickup).isFalse();
        assertThat(problemInstance.delivery.get(6).isDeliver).isTrue();

        // Request 8
        assertThat(problemInstance.pickups.get(7).get(0).nodeId).isEqualTo(22);
        assertThat(problemInstance.pickups.get(7).get(0).requestId).isEqualTo(7);
        assertThat(problemInstance.pickups.get(7).get(0).x).isEqualTo(441);
        assertThat(problemInstance.pickups.get(7).get(0).y).isEqualTo(7);
        assertThat(problemInstance.pickups.get(7).get(0).demand).isEqualTo(20);
        assertThat(problemInstance.pickups.get(7).get(0).twStart).isEqualTo(102);
        assertThat(problemInstance.pickups.get(7).get(0).twEnd).isEqualTo(712);
        assertThat(problemInstance.pickups.get(7).get(0).serviceTime).isEqualTo(10);
        assertThat(problemInstance.pickups.get(7).get(0).isPickup).isTrue();
        assertThat(problemInstance.pickups.get(7).get(0).isDeliver).isFalse();

        assertThat(problemInstance.pickups.get(7).get(1).nodeId).isEqualTo(23);
        assertThat(problemInstance.pickups.get(7).get(1).requestId).isEqualTo(7);
        assertThat(problemInstance.pickups.get(7).get(1).x).isEqualTo(235);
        assertThat(problemInstance.pickups.get(7).get(1).y).isEqualTo(288);
        assertThat(problemInstance.pickups.get(7).get(1).demand).isEqualTo(18);
        assertThat(problemInstance.pickups.get(7).get(1).twStart).isEqualTo(0);
        assertThat(problemInstance.pickups.get(7).get(1).twEnd).isEqualTo(350);
        assertThat(problemInstance.pickups.get(7).get(1).serviceTime).isEqualTo(10);
        assertThat(problemInstance.pickups.get(7).get(1).isPickup).isTrue();
        assertThat(problemInstance.pickups.get(7).get(1).isDeliver).isFalse();

        assertThat(problemInstance.pickups.get(7).get(2).nodeId).isEqualTo(24);
        assertThat(problemInstance.pickups.get(7).get(2).requestId).isEqualTo(7);
        assertThat(problemInstance.pickups.get(7).get(2).x).isEqualTo(392);
        assertThat(problemInstance.pickups.get(7).get(2).y).isEqualTo(1);
        assertThat(problemInstance.pickups.get(7).get(2).demand).isEqualTo(11);
        assertThat(problemInstance.pickups.get(7).get(2).twStart).isEqualTo(315);
        assertThat(problemInstance.pickups.get(7).get(2).twEnd).isEqualTo(925);
        assertThat(problemInstance.pickups.get(7).get(2).serviceTime).isEqualTo(10);
        assertThat(problemInstance.pickups.get(7).get(2).isPickup).isTrue();
        assertThat(problemInstance.pickups.get(7).get(2).isDeliver).isFalse();

        assertThat(problemInstance.delivery.get(7).nodeId).isEqualTo(25);
        assertThat(problemInstance.delivery.get(7).requestId).isEqualTo(7);
        assertThat(problemInstance.delivery.get(7).x).isEqualTo(60);
        assertThat(problemInstance.delivery.get(7).y).isEqualTo(5);
        assertThat(problemInstance.delivery.get(7).demand).isEqualTo(-49);
        assertThat(problemInstance.delivery.get(7).twStart).isEqualTo(754);
        assertThat(problemInstance.delivery.get(7).twEnd).isEqualTo(1364);
        assertThat(problemInstance.delivery.get(7).serviceTime).isEqualTo(10);
        assertThat(problemInstance.delivery.get(7).isPickup).isFalse();
        assertThat(problemInstance.delivery.get(7).isDeliver).isTrue();

        for (int i = 0; i < problemInstance.distances.length; i++) {
            for (int j = 0; j < problemInstance.distances[i].length; j++) {
                if (i == j) {
                    assertThat(problemInstance.distances[i][j]).isEqualTo(0.0);
                } else {
                    assertThat(problemInstance.distances[i][j]).isGreaterThan(1.0);
                    assertThat(problemInstance.distances[i][j]).isLessThan(1925.0);
                }
            }
        }
    }

    @Test
    public void requestPathTreeTest() throws IOException {
        // Biggest problem
        ProblemInstance problemInstance = DataReader.getProblemInstance(Paths.get(rootDirectory, "w_8_100_1.txt").toFile());
        OptimalRequestSolver optimalRequestSolver[] = new OptimalRequestSolver[problemInstance.noReq];
        for (int i = 0; i < problemInstance.noReq; i++) {
            optimalRequestSolver[i] = new OptimalRequestSolver(i, problemInstance);
            optimalRequestSolver[i].optimize();
        }
        // Request 0
        assertThat(optimalRequestSolver[0].getBestRoute()).containsExactly(0, 1, 2, 0);
        assertThat(optimalRequestSolver[0].getBestCost()).isEqualTo(813.0);
        // Request 1
        assertThat(optimalRequestSolver[1].getBestRoute()).containsExactly(0, 4, 9, 5, 7, 8, 6, 3, 10, 0);
        assertThat(optimalRequestSolver[1].getBestCost()).isEqualTo(1150.0);
        // Request 2
        assertThat(optimalRequestSolver[2].getBestRoute()).containsExactly(0, 11, 12, 0);
        assertThat(optimalRequestSolver[2].getBestCost()).isEqualTo(533.0);
        // Request 3
        assertThat(optimalRequestSolver[3].getBestRoute()).containsExactly(0, 15, 13, 14, 16, 0);
        assertThat(optimalRequestSolver[3].getBestCost()).isEqualTo(1062.0);
        // Request 4
        assertThat(optimalRequestSolver[4].getBestRoute()).containsExactly(0, 21, 22, 20, 17, 18, 19, 23, 0);
        assertThat(optimalRequestSolver[4].getBestCost()).isEqualTo(876.0);
        // Request 5
        assertThat(optimalRequestSolver[5].getBestRoute()).containsExactly(0, 24, 26, 25, 27, 0);
        assertThat(optimalRequestSolver[5].getBestCost()).isEqualTo(722.0);
        // Request 6
        assertThat(optimalRequestSolver[6].getBestRoute()).containsExactly(0, 29, 33, 31, 32, 28, 30, 34, 0);
        assertThat(optimalRequestSolver[6].getBestCost()).isEqualTo(1236.0);
        // Request 7
        assertThat(optimalRequestSolver[7].getBestRoute()).containsExactly(0, 36, 37, 35, 39, 38, 40, 41, 0);
        assertThat(optimalRequestSolver[7].getBestCost()).isEqualTo(1003.0);
        // Request 8
        assertThat(optimalRequestSolver[8].getBestRoute()).containsExactly(0, 42, 45, 46, 47, 44, 43, 48, 0);
        assertThat(optimalRequestSolver[8].getBestCost()).isEqualTo(821.0);
        // Request 9
        assertThat(optimalRequestSolver[9].getBestRoute()).containsExactly(0, 49, 50, 0);
        assertThat(optimalRequestSolver[9].getBestCost()).isEqualTo(583.0);
        // Request 10
        assertThat(optimalRequestSolver[10].getBestRoute()).containsExactly(0, 53, 54, 51, 52, 55, 0);
        assertThat(optimalRequestSolver[10].getBestCost()).isEqualTo(1169.0);
        // Request 11
        assertThat(optimalRequestSolver[11].getBestRoute()).containsExactly(0, 59, 58, 56, 57, 60, 0);
        assertThat(optimalRequestSolver[11].getBestCost()).isEqualTo(1276.0);
        // Request 12
        assertThat(optimalRequestSolver[12].getBestRoute()).containsExactly(0, 61, 64, 63, 62, 65, 0);
        assertThat(optimalRequestSolver[12].getBestCost()).isEqualTo(1209.0);
        // Request 13
        assertThat(optimalRequestSolver[13].getBestRoute()).containsExactly(0, 69, 68, 66, 67, 70, 0);
        assertThat(optimalRequestSolver[13].getBestCost()).isEqualTo(708.0);
        // Request 14
        assertThat(optimalRequestSolver[14].getBestRoute()).containsExactly(0, 73, 72, 74, 71, 75, 0);
        assertThat(optimalRequestSolver[14].getBestCost()).isEqualTo(937.0);
        // Request 15
        assertThat(optimalRequestSolver[15].getBestRoute()).containsExactly(0, 80, 76, 79, 81, 77, 78, 82, 83, 0);
        assertThat(optimalRequestSolver[15].getBestCost()).isEqualTo(1359.0);
        // Request 16
        assertThat(optimalRequestSolver[16].getBestRoute()).containsExactly(0, 84, 85, 86, 0);
        assertThat(optimalRequestSolver[16].getBestCost()).isEqualTo(830.0);
        // Request 17
        assertThat(optimalRequestSolver[17].getBestRoute()).containsExactly(0, 87, 88, 0);
        assertThat(optimalRequestSolver[17].getBestCost()).isEqualTo(455.0);
        // Request 18
        assertThat(optimalRequestSolver[18].getBestRoute()).containsExactly(0, 89, 90, 0);
        assertThat(optimalRequestSolver[18].getBestCost()).isEqualTo(743.0);
        // Request 19
        assertThat(optimalRequestSolver[19].getBestRoute()).containsExactly(0, 94, 93, 91, 92, 95, 0);
        assertThat(optimalRequestSolver[19].getBestCost()).isEqualTo(1170.0);
        // Request 20
        assertThat(optimalRequestSolver[20].getBestRoute()).containsExactly(0, 96, 97, 0);
        assertThat(optimalRequestSolver[20].getBestCost()).isEqualTo(661.0);
        // Request 21
        assertThat(optimalRequestSolver[21].getBestRoute()).containsExactly(0, 98, 101, 99, 104, 100, 103, 102, 105, 0);
        assertThat(optimalRequestSolver[21].getBestCost()).isEqualTo(1037.0);
    }

    @Test
    public void relocateSimpleLocalSearchTest() throws IOException {
        ProblemInstance problemInstance = DataReader.getProblemInstance(Paths.get(rootDirectory, "l_4_25_1.txt").toFile());
        Ant ant = AntUtils.createEmptyAnt(problemInstance);
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 5, 24, 22, 23, 3, 4, 6, 25, 0)));
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 7, 15, 8, 13, 14, 1, 2, 16, 17, 0)));
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 10, 11, 9, 12, 0)));
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 18, 19, 20, 21, 0)));
        ant.requests.add(new ArrayList<>(Arrays.asList(1, 7)));
        ant.requests.add(new ArrayList<>(Arrays.asList(2, 5, 4, 0)));
        ant.requests.add(new ArrayList<>(Arrays.asList(3)));
        ant.requests.add(new ArrayList<>(Arrays.asList(6)));

        problemInstance.restrictionsEvaluation(ant);
        assertThat(ant.totalCost).isEqualTo(6909.0);
        assertThat(ant.timeWindowPenalty).isEqualTo(2011.0);
        assertThat(ant.feasible).isFalse();

        LocalSearchRelocate localSearchRelocate = new LocalSearchRelocate(problemInstance);
        Ant improvedAnt = localSearchRelocate.relocate(ant);
        assertThat(improvedAnt.totalCost).isEqualTo(6495.0);
        assertThat(improvedAnt.timeWindowPenalty).isEqualTo(1956.0);
        assertThat(improvedAnt.feasible).isFalse();
    }

    @Test
    public void relocateLoopLocalSearchTest() throws IOException {
        ProblemInstance problemInstance = DataReader.getProblemInstance(Paths.get(rootDirectory, "l_4_25_1.txt").toFile());
        Ant ant = AntUtils.createEmptyAnt(problemInstance);
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 15, 24, 22, 16, 23, 17, 25, 0)));
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 5, 7, 8, 4, 3, 1, 6, 2, 0)));
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 13, 14, 11, 10, 9, 12, 0)));
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 18, 19, 20, 21, 0)));
        ant.requests.add(new ArrayList<>(Arrays.asList(5, 7)));
        ant.requests.add(new ArrayList<>(Arrays.asList(1, 2, 0)));
        ant.requests.add(new ArrayList<>(Arrays.asList(4, 3)));
        ant.requests.add(new ArrayList<>(Arrays.asList(6)));

        problemInstance.restrictionsEvaluation(ant);
        assertThat(ant.totalCost).isEqualTo(6786.0);
        assertThat(ant.timeWindowPenalty).isEqualTo(1422.0);
        assertThat(ant.feasible).isFalse();

        LocalSearchRelocate localSearchRelocate = new LocalSearchRelocate(problemInstance);
        Ant improvedAnt = localSearchRelocate.relocate(ant);
        assertThat(improvedAnt.totalCost).isEqualTo(6086.0);
        assertThat(improvedAnt.timeWindowPenalty).isEqualTo(0.0);
        assertThat(improvedAnt.feasible).isTrue();
    }

    @Test
    public void feasibilityLocalSearch() throws IOException {
        ProblemInstance problemInstance = DataReader.getProblemInstance(Paths.get(rootDirectory, "n_4_25_1.txt").toFile());
        Ant ant = AntUtils.createEmptyAnt(problemInstance);
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 5, 3, 13, 14, 4, 1, 2, 6, 0)));
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 15, 18, 16, 19, 20, 21, 17, 0)));
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 23, 7, 11, 22, 24, 25, 10, 9, 8, 12, 0)));
        ant.requests.add(new ArrayList<>(Arrays.asList(1, 4, 0)));
        ant.requests.add(new ArrayList<>(Arrays.asList(5, 6)));
        ant.requests.add(new ArrayList<>(Arrays.asList(7, 2, 3)));
        problemInstance.restrictionsEvaluation(ant);
        assertThat(ant.totalCost).isEqualTo(5305.0);
        assertThat(ant.timeWindowPenalty).isEqualTo(844.0);
        assertThat(ant.feasible).isFalse();

        FeasibilitySearch feasibilitySearch = new FeasibilitySearch(problemInstance);
        Ant improvedAnt = feasibilitySearch.feasibility(ant);
        assertThat(improvedAnt.feasible).isTrue();
        assertThat(improvedAnt.totalCost).isEqualTo(8307.0);
        assertThat(improvedAnt.timeWindowPenalty).isEqualTo(0.0);
    }

    @Test
    public void expensiveRequestsRemovalOperatorFromCoelhoTest() throws IOException {
        ProblemInstance problemInstance = DataReader.getProblemInstance(Paths.get(rootDirectory, "n_4_25_1.txt").toFile());
        Ant ant = AntUtils.createEmptyAnt(problemInstance);
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 5, 3, 13, 14, 4, 1, 2, 6, 0)));
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 15, 18, 16, 19, 20, 21, 17, 0)));
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 23, 7, 11, 22, 24, 25, 10, 9, 8, 12, 0)));
        ant.requests.add(new ArrayList<>(Arrays.asList(1, 4, 0)));
        ant.requests.add(new ArrayList<>(Arrays.asList(5, 6)));
        ant.requests.add(new ArrayList<>(Arrays.asList(7, 2, 3)));
        problemInstance.restrictionsEvaluation(ant);
        assertThat(ant.totalCost).isEqualTo(5305.0);
        assertThat(ant.timeWindowPenalty).isEqualTo(844.0);
        assertThat(ant.feasible).isFalse();

        RemovalOperator removalOperator = new RemovalOperator(problemInstance, new Random(1));
        List<Req> removedRequests = removalOperator.removeExpensiveRequests(ant.tours, ant.requests, 6);

        assertThat(removedRequests).hasSize(6);
        assertThat(removedRequests.get(0).vehicleId).isEqualTo(2);
        assertThat(removedRequests.get(0).requestId).isEqualTo(2);
        assertThat(removedRequests.get(0).cost).isEqualTo(0.0);
        assertThat(removedRequests.get(1).vehicleId).isEqualTo(1);
        assertThat(removedRequests.get(1).requestId).isEqualTo(5);
        assertThat(removedRequests.get(1).cost).isEqualTo(-349.0);
        assertThat(removedRequests.get(2).vehicleId).isEqualTo(1);
        assertThat(removedRequests.get(2).requestId).isEqualTo(6);
        assertThat(removedRequests.get(2).cost).isEqualTo(-470.0);
        assertThat(removedRequests.get(3).vehicleId).isEqualTo(2);
        assertThat(removedRequests.get(3).requestId).isEqualTo(3);
        assertThat(removedRequests.get(3).cost).isEqualTo(-108.0);
        assertThat(removedRequests.get(4).vehicleId).isEqualTo(0);
        assertThat(removedRequests.get(4).requestId).isEqualTo(1);
        assertThat(removedRequests.get(4).cost).isEqualTo(-275.0);
        assertThat(removedRequests.get(5).vehicleId).isEqualTo(0);
        assertThat(removedRequests.get(5).requestId).isEqualTo(0);
        assertThat(removedRequests.get(5).cost).isEqualTo(-91.0);
        try {
            problemInstance.restrictionsEvaluation(ant);
        } catch (Exception ex) {
            assertThat(ex).hasMessage("Infeasible number of requests"); // We expect this error because we removed the requests
        }
        assertThat(ant.tours).hasSize(2);
        assertThat(ant.requests).hasSize(2);
        assertThat(ant.tourLengths).hasSize(2);
        assertThat(ant.totalCost).isEqualTo(1859.0);
        assertThat(ant.timeWindowPenalty).isEqualTo(0.0);
        assertThat(ant.feasible).isFalse();

        InsertionOperator insertionOperator = new InsertionOperator(problemInstance, new Random(1));
        insertionOperator.insertRequests(ant.tours, ant.requests, removedRequests);
        problemInstance.restrictionsEvaluation(ant);
        assertThat(ant.tours).hasSize(5);
        assertThat(ant.requests).hasSize(5);
        assertThat(ant.tourLengths).hasSize(5);
        assertThat(ant.totalCost).isEqualTo(7994.0);
        assertThat(ant.timeWindowPenalty).isEqualTo(0.0);
        assertThat(ant.feasible).isTrue();
    }

    @Test
    public void randomRequestsRemovalOperatorFromCoelhoTest() throws IOException {
        ProblemInstance problemInstance = DataReader.getProblemInstance(Paths.get(rootDirectory, "n_4_25_1.txt").toFile());
        Ant ant = AntUtils.createEmptyAnt(problemInstance);
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 5, 3, 13, 14, 4, 1, 2, 6, 0)));
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 15, 18, 16, 19, 20, 21, 17, 0)));
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 23, 7, 11, 22, 24, 25, 10, 9, 8, 12, 0)));
        ant.requests.add(new ArrayList<>(Arrays.asList(1, 4, 0)));
        ant.requests.add(new ArrayList<>(Arrays.asList(5, 6)));
        ant.requests.add(new ArrayList<>(Arrays.asList(7, 2, 3)));
        problemInstance.restrictionsEvaluation(ant);
        assertThat(ant.totalCost).isEqualTo(5305.0);
        assertThat(ant.timeWindowPenalty).isEqualTo(844.0);
        assertThat(ant.feasible).isFalse();

        RemovalOperator removalOperator = new RemovalOperator(problemInstance, new Random(1));
        List<Req> removedRequests = removalOperator.removeRandomRequest(ant.tours, ant.requests, 6);

        assertThat(removedRequests).hasSize(6);
        assertThat(removedRequests.get(0).vehicleId).isEqualTo(2);
        assertThat(removedRequests.get(0).requestId).isEqualTo(2);
        assertThat(removedRequests.get(0).cost).isEqualTo(0.0);
        assertThat(removedRequests.get(1).vehicleId).isEqualTo(0);
        assertThat(removedRequests.get(1).requestId).isEqualTo(4);
        assertThat(removedRequests.get(1).cost).isEqualTo(0.0);
        assertThat(removedRequests.get(2).vehicleId).isEqualTo(0);
        assertThat(removedRequests.get(2).requestId).isEqualTo(0);
        assertThat(removedRequests.get(2).cost).isEqualTo(0.0);
        assertThat(removedRequests.get(3).vehicleId).isEqualTo(2);
        assertThat(removedRequests.get(3).requestId).isEqualTo(3);
        assertThat(removedRequests.get(3).cost).isEqualTo(0.0);
        assertThat(removedRequests.get(4).vehicleId).isEqualTo(0);
        assertThat(removedRequests.get(4).requestId).isEqualTo(1);
        assertThat(removedRequests.get(4).cost).isEqualTo(0.0);
        assertThat(removedRequests.get(5).vehicleId).isEqualTo(2);
        assertThat(removedRequests.get(5).requestId).isEqualTo(7);
        assertThat(removedRequests.get(5).cost).isEqualTo(0.0);
        try {
            problemInstance.restrictionsEvaluation(ant);
        } catch (Exception ex) {
            assertThat(ex).hasMessage("Infeasible number of requests"); // We expect this error because we removed the requests
        }
        assertThat(ant.tours).hasSize(1);
        assertThat(ant.requests).hasSize(1);
        assertThat(ant.tourLengths).hasSize(1);
        assertThat(ant.totalCost).isEqualTo(1930.0);
        assertThat(ant.timeWindowPenalty).isEqualTo(195.0);
        assertThat(ant.feasible).isFalse();

        InsertionOperator insertionOperator = new InsertionOperator(problemInstance, new Random(1));
        insertionOperator.insertRequests(ant.tours, ant.requests, removedRequests);
        problemInstance.restrictionsEvaluation(ant);
        assertThat(ant.tours).hasSize(4);
        assertThat(ant.requests).hasSize(4);
        assertThat(ant.tourLengths).hasSize(4);
        assertThat(ant.totalCost).isEqualTo(6815.0);
        assertThat(ant.timeWindowPenalty).isEqualTo(195.0);
        assertThat(ant.feasible).isFalse();
    }

    @Test
    public void shawRequestsRemovalOperatorFromCoelhoTest() throws IOException {
        ProblemInstance problemInstance = DataReader.getProblemInstance(Paths.get(rootDirectory, "n_4_25_1.txt").toFile());
        Ant ant = AntUtils.createEmptyAnt(problemInstance);
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 5, 3, 13, 14, 4, 1, 2, 6, 0)));
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 15, 18, 16, 19, 20, 21, 17, 0)));
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 23, 7, 11, 22, 24, 25, 10, 9, 8, 12, 0)));
        ant.requests.add(new ArrayList<>(Arrays.asList(1, 4, 0)));
        ant.requests.add(new ArrayList<>(Arrays.asList(5, 6)));
        ant.requests.add(new ArrayList<>(Arrays.asList(7, 2, 3)));
        problemInstance.restrictionsEvaluation(ant);
        assertThat(ant.totalCost).isEqualTo(5305.0);
        assertThat(ant.timeWindowPenalty).isEqualTo(844.0);
        assertThat(ant.feasible).isFalse();

        RemovalOperator removalOperator = new RemovalOperator(problemInstance, new Random(1));
        List<Req> removedRequests = removalOperator.removeShawRequests(ant.tours, ant.requests, 6);

        assertThat(removedRequests).hasSize(6);
        assertThat(removedRequests.get(0).vehicleId).isEqualTo(2);
        assertThat(removedRequests.get(0).requestId).isEqualTo(2);
        assertThat(removedRequests.get(0).cost).isEqualTo(0.0);
        assertThat(removedRequests.get(1).vehicleId).isEqualTo(0);
        assertThat(removedRequests.get(1).requestId).isEqualTo(1);
        assertThat(removedRequests.get(1).cost).isEqualTo(203.0);
        assertThat(removedRequests.get(2).vehicleId).isEqualTo(1);
        assertThat(removedRequests.get(2).requestId).isEqualTo(5);
        assertThat(removedRequests.get(2).cost).isEqualTo(81.0);
        assertThat(removedRequests.get(3).vehicleId).isEqualTo(0);
        assertThat(removedRequests.get(3).requestId).isEqualTo(4);
        assertThat(removedRequests.get(3).cost).isEqualTo(291.0);
        assertThat(removedRequests.get(4).vehicleId).isEqualTo(0);
        assertThat(removedRequests.get(4).requestId).isEqualTo(0);
        assertThat(removedRequests.get(4).cost).isEqualTo(439.0);
        assertThat(removedRequests.get(5).vehicleId).isEqualTo(2);
        assertThat(removedRequests.get(5).requestId).isEqualTo(3);
        assertThat(removedRequests.get(5).cost).isEqualTo(98.0);
        try {
            problemInstance.restrictionsEvaluation(ant);
        } catch (Exception ex) {
            assertThat(ex).hasMessage("Infeasible number of requests"); // We expect this error because we removed the requests
        }
        assertThat(ant.tours).hasSize(2);
        assertThat(ant.requests).hasSize(2);
        assertThat(ant.tourLengths).hasSize(2);
        assertThat(ant.totalCost).isEqualTo(2879.0);
        assertThat(ant.timeWindowPenalty).isEqualTo(0);
        assertThat(ant.feasible).isFalse();

        InsertionOperator insertionOperator = new InsertionOperator(problemInstance, new Random(1));
        insertionOperator.insertRequests(ant.tours, ant.requests, removedRequests);
        problemInstance.restrictionsEvaluation(ant);
        assertThat(ant.tours).hasSize(4);
        assertThat(ant.requests).hasSize(4);
        assertThat(ant.tourLengths).hasSize(4);
        assertThat(ant.totalCost).isEqualTo(6504.0);
        assertThat(ant.timeWindowPenalty).isEqualTo(0);
        assertThat(ant.feasible).isTrue();
    }

    @Test
    public void mostExpensiveNodesRequestsRemovalOperatorFromCoelhoTest() throws IOException {
        ProblemInstance problemInstance = DataReader.getProblemInstance(Paths.get(rootDirectory, "n_4_25_1.txt").toFile());
        Ant ant = AntUtils.createEmptyAnt(problemInstance);
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 5, 3, 13, 14, 4, 1, 2, 6, 0)));
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 15, 18, 16, 19, 20, 21, 17, 0)));
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 23, 7, 11, 22, 24, 25, 10, 9, 8, 12, 0)));
        ant.requests.add(new ArrayList<>(Arrays.asList(1, 4, 0)));
        ant.requests.add(new ArrayList<>(Arrays.asList(5, 6)));
        ant.requests.add(new ArrayList<>(Arrays.asList(7, 2, 3)));
        problemInstance.restrictionsEvaluation(ant);
        assertThat(ant.totalCost).isEqualTo(5305.0);
        assertThat(ant.timeWindowPenalty).isEqualTo(844.0);
        assertThat(ant.feasible).isFalse();

        RemovalOperator removalOperator = new RemovalOperator(problemInstance, new Random(1));
        List<Req> removedRequests = removalOperator.removeMostExpensiveNodes(ant.tours, ant.requests, 6);

        assertThat(removedRequests).hasSize(6);
        assertThat(removedRequests.get(0).vehicleId).isEqualTo(2);
        assertThat(removedRequests.get(0).requestId).isEqualTo(2);
        assertThat(removedRequests.get(0).cost).isEqualTo(0.0);
        assertThat(removedRequests.get(1).vehicleId).isEqualTo(0);
        assertThat(removedRequests.get(1).requestId).isEqualTo(0);
        assertThat(removedRequests.get(1).cost).isEqualTo(-395.0);
        assertThat(removedRequests.get(2).vehicleId).isEqualTo(2);
        assertThat(removedRequests.get(2).requestId).isEqualTo(3);
        assertThat(removedRequests.get(2).cost).isEqualTo(-299.0);
        assertThat(removedRequests.get(3).vehicleId).isEqualTo(1);
        assertThat(removedRequests.get(3).requestId).isEqualTo(6);
        assertThat(removedRequests.get(3).cost).isEqualTo(-65.0);
        assertThat(removedRequests.get(4).vehicleId).isEqualTo(1);
        assertThat(removedRequests.get(4).requestId).isEqualTo(5);
        assertThat(removedRequests.get(4).cost).isEqualTo(-483.0);
        assertThat(removedRequests.get(5).vehicleId).isEqualTo(0);
        assertThat(removedRequests.get(5).requestId).isEqualTo(1);
        assertThat(removedRequests.get(5).cost).isEqualTo(-103.0);
        try {
            problemInstance.restrictionsEvaluation(ant);
        } catch (Exception ex) {
            assertThat(ex).hasMessage("Infeasible number of requests"); // We expect this error because we removed the requests
        }
        assertThat(ant.tours).hasSize(2);
        assertThat(ant.requests).hasSize(2);
        assertThat(ant.tourLengths).hasSize(2);
        assertThat(ant.totalCost).isEqualTo(1859.0);
        assertThat(ant.timeWindowPenalty).isEqualTo(0);
        assertThat(ant.feasible).isFalse();

        InsertionOperator insertionOperator = new InsertionOperator(problemInstance, new Random(1));
        insertionOperator.insertRequests(ant.tours, ant.requests, removedRequests);
        problemInstance.restrictionsEvaluation(ant);
        assertThat(ant.tours).hasSize(5);
        assertThat(ant.requests).hasSize(5);
        assertThat(ant.tourLengths).hasSize(5);
        assertThat(ant.totalCost).isEqualTo(7994.0);
        assertThat(ant.timeWindowPenalty).isEqualTo(0);
        assertThat(ant.feasible).isTrue();
    }

    @Test
    public void feasibilitySearchDuplicationOfRequestsTest() throws IOException {
        ProblemInstance problemInstance = DataReader.getProblemInstance(Paths.get(rootDirectory, "l_4_25_4.txt").toFile());
        Ant ant = AntUtils.createEmptyAnt(problemInstance);
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 17, 8, 5, 1, 3, 2, 7, 16, 9, 18, 4, 6, 0)));
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 20, 24, 12, 21, 19, 23, 25, 22, 13, 0)));
        ant.tours.add(new ArrayList<>(Arrays.asList(0, 10, 14, 15, 11, 0)));
        ant.requests.add(new ArrayList<>(Arrays.asList(6, 2, 1, 0)));
        ant.requests.add(new ArrayList<>(Arrays.asList(4, 8, 7)));
        ant.requests.add(new ArrayList<>(Arrays.asList(3, 5)));

        problemInstance.restrictionsEvaluation(ant);

        assertThat(ant.tourLengths).hasSize(3);
        assertThat(ant.totalCost).isEqualTo(4885.0);
        assertThat(ant.timeWindowPenalty).isEqualTo(798.0);
        assertThat(ant.feasible).isFalse();

        FeasibilitySearch feasibilitySearch = new FeasibilitySearch(problemInstance);
        ant = feasibilitySearch.feasibility(ant);

        assertThat(ant.feasible).isTrue();
        assertThat(ant.tourLengths).hasSize(7);
        assertThat(ant.totalCost).isEqualTo(8705.0);
        assertThat(ant.timeWindowPenalty).isEqualTo(0.0);

        assertThat(ant.tours.get(0)).containsExactly(0, 17, 16, 18, 0);
        assertThat(ant.requests.get(0)).containsExactly(6);
        assertThat(ant.tourLengths.get(0)).isEqualTo(781.0);

        assertThat(ant.tours.get(1)).containsExactly(0, 20, 19, 21, 22, 0);
        assertThat(ant.requests.get(1)).containsExactly(7);
        assertThat(ant.tourLengths.get(1)).isEqualTo(1020.0);

        assertThat(ant.tours.get(2)).containsExactly(0, 10, 14, 15, 11, 0);
        assertThat(ant.requests.get(2)).containsExactly(3, 5);
        assertThat(ant.tourLengths.get(2)).isEqualTo(1368.0);

        assertThat(ant.tours.get(3)).containsExactly(0, 5, 3, 4, 6, 0);
        assertThat(ant.requests.get(3)).containsExactly(1);
        assertThat(ant.tourLengths.get(3)).isEqualTo(1483.0);

        assertThat(ant.tours.get(4)).containsExactly(0, 8, 7, 9, 0);
        assertThat(ant.requests.get(4)).containsExactly(2);
        assertThat(ant.tourLengths.get(4)).isEqualTo(1358.0);

        assertThat(ant.tours.get(5)).containsExactly(0, 1, 12, 2, 13, 0);
        assertThat(ant.requests.get(5)).containsExactly(0, 4);
        assertThat(ant.tourLengths.get(5)).isEqualTo(1246.0);

        assertThat(ant.tours.get(6)).containsExactly(0, 24, 23, 25, 0);
        assertThat(ant.requests.get(6)).containsExactly(8);
        assertThat(ant.tourLengths.get(6)).isEqualTo(1449.0);
    }

}
