package com.github.schmittjoaopedro.thesis;

import com.github.schmittjoaopedro.vrp.thesis.Solver;
import com.github.schmittjoaopedro.vrp.thesis.problem.Instance;
import com.github.schmittjoaopedro.vrp.thesis.problem.Reader;
import com.github.schmittjoaopedro.vrp.thesis.problem.Solution;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.Random;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class StaticNvTcMinimizerTest {

    private static int maxIterations = 25000;

    private static final String pdptw200Directory;

    static {
        pdptw200Directory = Paths.get(StaticNvMinimizerTest.class.getClassLoader().getResource("pdp_200").getFile().substring(1)).toString();
    }

    @Test
    public void minimizeNvAndTc_lc1_2_3_Test() throws Exception {
        Instance instance = Reader.getInstance(Paths.get(pdptw200Directory, "lc1_2_3.txt").toFile());
        Solver solver = new Solver(instance, new Random(1), maxIterations, true, true);
        solver.init();
        solver.run();
        Solution solutionBest = solver.getSolutionBest();
        int counter = 0;
        assertThat(solver.getLogs().get(counter++)).isEqualTo("Initial solution = [F = true, NV = 20, TC = 4385.17]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 20, TC = 4377.03]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 20, TC = 4224.21]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 20, TC = 4119.91]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 20, TC = 3624.44]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 20, TC = 3408.08]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 19, TC = 4054.02]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 19, TC = 3947.11]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 19, TC = 3929.74]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 19, TC = 3858.88]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 19, TC = 3519.83]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 19, TC = 3393.42]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 19, TC = 3248.23]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 3938.34]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 3932.8]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 3405.92]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 3404.32]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 3057.25]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 3056.15]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 3055.58]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 2925.31]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 2912.81]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 2893.25]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 2838.28]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 2838.07]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 2836.89]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 2832.19]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 2817.16]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 2816.76]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 2814.55]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 2813.18]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 2794.72]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 2779.15]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 2773.39]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3510.8]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3449.26]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3448.42]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3442.66]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3382.88]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3379.55]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3269.79]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3259.86]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3154.19]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3147.56]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3147.36]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3145.15]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3144.29]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3143.34]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3143.04]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3141.83]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3140.09]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3139.48]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3138.37]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3138.26]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3137.73]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 3137.62]");

        assertThat(solutionBest.feasible).isTrue();
        assertThat(solutionBest.totalCost).isEqualTo(3137.619348850628);
        assertThat(solutionBest.tours.size()).isEqualTo(17);
        // Check tours
        counter = 0;
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 45 178 173 154 24 61 100 64 27 149 68 76 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 116 164 66 160 47 205 91 70 191 4 72 90 175 203 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 78 201 60 180 35 125 84 82 128 46 193 126 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 21 23 182 75 163 194 145 195 52 92 198 74 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 148 103 206 197 124 141 69 200 77 162 179 109 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 113 73 129 11 6 122 139 34 95 158 190 67 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 32 171 65 86 115 94 51 174 136 189 147 12 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 114 159 38 204 150 22 151 16 140 187 142 111 63 56 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 48 26 152 40 153 14 59 105 15 89 169 30 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 57 118 83 143 176 36 33 121 165 188 202 108 119 71 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 93 55 135 58 184 37 138 99 53 102 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 62 120 44 192 196 97 96 130 28 19 146 131 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 20 41 85 80 31 25 172 110 39 107 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 161 104 18 54 185 132 7 181 117 49 81 137 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 10 5 106 167 43 144 9 1 17 2 13 155 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 170 134 50 156 112 168 79 29 87 42 123 133 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 177 3 88 8 186 127 98 157 199 183 101 166 0");
        // Check requests
        counter = 0;
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("92 79 32 88 14 24");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("98 58 2 89 82 35 25");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("63 41 93 31 39 18");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("12 74 94 102 100 37");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("50 76 71 101 62 38");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("80 46 55 4 36 8");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("57 28 17 44 34 87");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("77 81 70 19 13 72 56");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("78 9 52 26 15 21");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("97 59 42 84 29 60 90");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("45 68 69 30 48");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("33 65 61 47 99 75");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("20 11 22 43 16");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("83 5 66 51 95 10");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("0 73 3 53 7 85");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("40 27 86 67 54 23");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("1 64 96 6 91 49");
    }

    @Test
    public void minimizeNvAndTc_lr1_2_3_Test() throws Exception {
        Instance instance = Reader.getInstance(Paths.get(pdptw200Directory, "lr1_2_3.txt").toFile());
        Solver solver = new Solver(instance, new Random(1), maxIterations, true, true);
        solver.init();
        solver.run();
        Solution solutionBest = solver.getSolutionBest();
        int counter = 0;
        assertThat(solver.getLogs().get(counter++)).isEqualTo("Initial solution = [F = true, NV = 19, TC = 5436.06]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 18, TC = 5079.29]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 4618.28]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 4410.36]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 4407.26]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 4400.49]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 4397.14]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 4239.85]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 4219.58]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 16, TC = 4471.39]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 16, TC = 4442.41]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 16, TC = 4414.64]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 16, TC = 3949.4]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 16, TC = 3942.9]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 5029.22]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4903.48]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4800.68]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4769.99]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4750.37]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4604.47]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4575.27]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4568.73]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4549.83]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4510.16]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4269.84]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4268.71]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4235.34]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4222.92]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4222.56]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4217.15]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4127.11]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4110.29]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4105.68]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4102.87]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4094.33]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4091.5]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4039.5]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 4016.62]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3988.63]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3901.2]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3860.48]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3834.03]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3771.85]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3720.12]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3693.79]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3692.2]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3686.82]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3680.36]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3677.24]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3676.58]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3676.04]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3674.43]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3669.44]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3668.14]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3666.83]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3664.9]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3664.22]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3623.05]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3619.22]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3618.03]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3612.64]");

        assertThat(solutionBest.feasible).isTrue();
        assertThat(solutionBest.totalCost).isEqualTo(3612.639044272317);
        assertThat(solutionBest.tours.size()).isEqualTo(15);
        // Check tours
        counter = 0;
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 156 51 206 26 143 204 21 123 124 181 161 42 53 60 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 73 45 57 198 19 13 38 84 32 138 111 52 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 196 30 35 99 183 34 194 98 142 128 200 192 154 81 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 46 15 70 208 129 141 164 54 89 12 22 95 127 178 23 29 96 114 74 174 108 97 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 175 72 184 71 191 151 125 110 37 39 207 9 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 55 67 150 36 137 68 25 116 5 61 49 180 195 27 133 64 80 91 201 7 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 4 56 188 153 167 166 33 193 186 144 203 179 190 135 147 107 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 155 120 160 130 11 176 165 69 134 101 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 132 103 92 48 169 185 148 149 202 119 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 146 16 115 162 171 170 187 78 139 168 126 113 31 1 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 140 62 20 163 104 100 136 159 10 83 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 157 93 199 109 28 182 41 75 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 87 145 121 17 2 8 122 205 76 118 152 88 40 112 59 105 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 63 44 3 117 86 131 66 50 158 79 172 18 14 197 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 106 43 85 65 94 82 47 58 77 6 189 177 102 173 90 24 0");
        // Check requests
        counter = 0;
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("27 8 85 82 95 72 60");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("22 102 42 7 3 38");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("15 12 101 100 63 16 97");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("11 23 46 56 4 28 71 9 2 64 35");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("37 18 19 92 61 36");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("69 94 10 68 48 34 29 17 26 78");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("98 73 14 1 30 80 99 89");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("57 93 81 88 65");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("67 52 25 76 77");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("39 86 5 75 13 90 62");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("53 70 50 31 87");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("49 96 103 83");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("79 45 44 74 58 6 55 59");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("21 40 91 32 84 66 0");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("43 54 20 24 33 41 51 47");
    }

    @Test
    public void minimizeNvAndTc_lrc1_2_3_Test() throws Exception {
        Instance instance = Reader.getInstance(Paths.get(pdptw200Directory, "lrc1_2_3.txt").toFile());
        Solver solver = new Solver(instance, new Random(1), maxIterations, true, true);
        solver.init();
        solver.run();
        Solution solutionBest = solver.getSolutionBest();
        int counter = 0;
        assertThat(solver.getLogs().get(counter++)).isEqualTo("Initial solution = [F = true, NV = 17, TC = 4663.77]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 4481.25]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 4198.95]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 17, TC = 4193.58]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 16, TC = 4156.59]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 16, TC = 4113.47]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 16, TC = 3959.17]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 16, TC = 3828.06]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3824.39]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 15, TC = 3769.56]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 14, TC = 3780.33]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 14, TC = 3757.15]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 14, TC = 3673.41]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 14, TC = 3672.82]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 14, TC = 3568.02]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 14, TC = 3546.37]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 14, TC = 3546.26]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3582.77]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3579.98]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3525.27]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3521.88]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3512.36]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3500.2]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3461.09]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3460.05]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3458.2]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3453.11]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3452.37]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3449.86]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3448.98]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3447.28]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3445.22]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3441.96]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3423.81]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3388.27]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3386.21]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3383.61]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3376.32]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3376.2]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3375.78]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3374.04]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3352.18]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3349.97]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3336.62]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3331.7]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3330.38]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3327.02]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3325.76]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3286.72]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3285.65]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3284.25]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3259.71]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3254.26]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3247.1]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3246.66]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3246.59]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3233.4]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3232.62]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3231.66]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3229.24]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3225.51]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3221.46]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3220.21]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3218.72]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3218.55]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3217.55]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3216.94]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3212.68]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3209.55]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3209.18]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3200.81]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3200.44]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3199.87]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3199.38]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3198.09]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3197.34]");
        assertThat(solver.getLogs().get(counter++)).isEqualTo("New best = [F = true, NV = 13, TC = 3196.97]");

        assertThat(solutionBest.feasible).isTrue();
        assertThat(solutionBest.totalCost).isEqualTo(3196.968006953539);
        assertThat(solutionBest.tours.size()).isEqualTo(13);
        // Check tours
        counter = 0;
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 4 173 165 45 108 38 32 23 52 86 117 114 207 85 50 160 74 31 106 55 154 209 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 54 168 53 151 99 125 189 101 192 56 33 66 89 143 139 210 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 163 49 5 62 159 20 46 138 186 135 96 76 185 26 2 175 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 131 156 7 68 18 206 91 111 198 61 126 24 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 140 100 208 37 12 204 59 9 188 29 21 107 129 81 194 158 150 187 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 92 182 57 133 147 40 16 98 161 72 41 195 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 174 84 199 127 118 137 123 13 8 75 60 202 1 34 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 142 169 48 180 43 3 136 203 119 22 70 184 196 102 183 15 179 110 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 152 167 27 190 51 148 44 83 95 145 80 116 205 103 200 39 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 88 155 87 69 176 113 191 58 134 17 30 201 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 28 47 6 14 132 171 130 153 124 36 178 90 79 73 93 146 170 19 193 42 149 63 162 78 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 82 166 128 65 94 109 112 157 177 121 115 144 11 71 105 97 64 67 0");
        assertThat(StringUtils.join(solutionBest.tours.get(counter++), " ")).isEqualTo("0 172 197 35 164 104 25 10 77 122 181 141 120 0");
        // Check requests
        counter = 0;
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("20 42 28 59 56 80 85 23 17 91 1");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("44 87 30 29 73 65 51 100");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("26 34 2 83 70 98 12 48");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("35 102 10 3 68 45");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("39 82 19 74 7 52 32 5 13");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("21 95 46 50 31 9");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("92 41 33 60 4 103 72");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("96 97 0 75 25 71 53 88 61");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("78 47 27 22 14 58 77 104");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("16 93 55 43 99 81");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("24 64 89 79 67 15 38 76 11 8 69 37");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("57 36 49 66 62 54 86 94 40");
        assertThat(StringUtils.join(solutionBest.requestIds.get(counter++), " ")).isEqualTo("90 18 63 6 101 84");
    }
}