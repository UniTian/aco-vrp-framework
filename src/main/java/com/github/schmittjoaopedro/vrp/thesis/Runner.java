package com.github.schmittjoaopedro.vrp.thesis;

import com.github.schmittjoaopedro.vrp.thesis.problem.Instance;
import com.github.schmittjoaopedro.vrp.thesis.problem.Reader;
import com.github.schmittjoaopedro.vrp.thesis.problem.Solution;

import java.nio.file.Paths;
import java.util.Random;

public class Runner {

    private static int maxIterations = 25000;

    private static final String pdptw100Directory;
    private static final String pdptw200Directory;
    private static final String pdptw400Directory;

    private static String[] instances_100 = {
            "lc101", "lc102", "lc103", "lc104", "lc105", "lc106", "lc107", "lc108", "lc109",
            "lc201", "lc202", "lc203", "lc204", "lc205", "lc206", "lc207", "lc208",
            "lr101", "lr102", "lr103", "lr104", "lr105", "lr106", "lr107", "lr108", "lr109", "lr110", "lr111", "lr112",
            "lr201", "lr202", "lr203", "lr204", "lr205", "lr206", "lr207", "lr208", "lr209", "lr210", "lr211",
            "lrc101", "lrc102", "lrc103", "lrc104", "lrc105", "lrc106", "lrc107", "lrc108",
            "lrc201", "lrc202", "lrc203", "lrc204", "lrc205", "lrc206", "lrc207", "lrc208"
    };

    private static String[] instances_200 = {
            "lc1_2_1", "lc1_2_2", "lc1_2_3", "lc1_2_4", "lc1_2_5", "lc1_2_6", "lc1_2_7", "lc1_2_8", "lc1_2_9", "lc1_2_10",
            "lc2_2_1", "lc2_2_2", "lc2_2_3", "lc2_2_4", "lc2_2_5", "lc2_2_6", "lc2_2_7", "lc2_2_8", "lc2_2_9", "lc2_2_10",
            "lr1_2_1", "lr1_2_2", "lr1_2_3", "lr1_2_4", "lr1_2_5", "lr1_2_6", "lr1_2_7", "lr1_2_8", "lr1_2_9", "lr1_2_10",
            "lr2_2_1", "lr2_2_2", "lr2_2_3", "lr2_2_4", "lr2_2_5", "lr2_2_6", "lr2_2_7", "lr2_2_8", "lr2_2_9", "lr2_2_10",
            "lrc1_2_1", "lrc1_2_2", "lrc1_2_3", "lrc1_2_4", "lrc1_2_5", "lrc1_2_6", "lrc1_2_7", "lrc1_2_8", "lrc1_2_9", "lrc1_2_10",
            "lrc2_2_1", "lrc2_2_2", "lrc2_2_3", "lrc2_2_4", "lrc2_2_5", "lrc2_2_6", "lrc2_2_7", "lrc2_2_8", "lrc2_2_9", "lrc2_2_10"
    };

    private static String[] instances_400 = {
            "lc1_4_1", "lc1_4_2", "lc1_4_3", "lc1_4_4", "lc1_4_5", "lc1_4_6", "lc1_4_7", "lc1_4_8", "lc1_4_9", "lc1_4_10",
            "lc2_4_1", "lc2_4_2", "lc2_4_3", "lc2_4_4", "lc2_4_5", "lc2_4_6", "lc2_4_7", "lc2_4_8", "lc2_4_9", "lc2_4_10",
            "lr1_4_1", "lr1_4_2", "lr1_4_3", "lr1_4_4", "lr1_4_5", "lr1_4_6", "lr1_4_7", "lr1_4_8", "lr1_4_9", "lr1_4_10",
            "lr2_4_1", "lr2_4_2", "lr2_4_3", "lr2_4_4", "lr2_4_5", "lr2_4_6", "lr2_4_7", "lr2_4_8", "lr2_4_9", "lr2_4_10",
            "lrc1_4_1", "lrc1_4_2", "lrc1_4_3", "lrc1_4_4", "lrc1_4_5", "lrc1_4_6", "lrc1_4_7", "lrc1_4_8", "lrc1_4_9", "lrc1_4_10",
            "lrc2_4_1", "lrc2_4_2", "lrc2_4_3", "lrc2_4_4", "lrc2_4_5", "lrc2_4_6", "lrc2_4_7", "lrc2_4_8", "lrc2_4_9", "lrc2_4_10"
    };

    static {
        pdptw100Directory = Paths.get(Runner.class.getClassLoader().getResource("pdp_100").getFile().substring(1)).toString();
        pdptw200Directory = Paths.get(Runner.class.getClassLoader().getResource("pdp_200").getFile().substring(1)).toString();
        pdptw400Directory = Paths.get(Runner.class.getClassLoader().getResource("pdp_400").getFile().substring(1)).toString();
    }

    public static void main(String[] args) throws Exception {
        for (String instance : instances_400) {
            executeProblemSolver(pdptw400Directory, instance);
        }
    }

    private static void executeProblemSolver(String directory, String problem) throws Exception {
        Instance instance = Reader.getInstance(Paths.get(directory, problem + ".txt").toFile());
        Solver solver = new Solver(instance, new Random(1), maxIterations, true, true);
        solver.init();
        solver.run();
        Solution solution = solver.getSolutionBest();
        System.out.println(instance.name + " = " + solution);
    }
}
