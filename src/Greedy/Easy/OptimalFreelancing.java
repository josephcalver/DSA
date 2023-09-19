package Greedy.Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OptimalFreelancing {

    public static void main(String[] args) {

        Map<String, Integer> job1 = Map.ofEntries(Map.entry("deadline", 1), Map.entry("payment", 1));
        Map<String, Integer> job2 = Map.ofEntries(Map.entry("deadline", 2), Map.entry("payment", 1));
        Map<String, Integer> job3 = Map.ofEntries(Map.entry("deadline", 2), Map.entry("payment", 2));

        ArrayList<Map<String, Integer>> jobs = new ArrayList(List.of(job1, job2, job3));

        int maxProfit = optimalFreelancing(jobs);

        System.out.println(maxProfit);

    }

    public static int optimalFreelancing(ArrayList<Map<String, Integer>> jobs) {

        Collections.sort(jobs, (a, b) -> b.get("payment").compareTo(a.get("payment")));

        boolean[] schedule = new boolean[8];

        int deadline = 0, payment = 0, profit = 0, jobCount = 0;

        for (Map<String, Integer> job : jobs) {

            if (jobCount >= 7) break;

            deadline = job.get("deadline") > 7 ? 7 : job.get("deadline");
            payment = job.get("payment");

            while (deadline > 0) {

                if (schedule[deadline] == false) {

                    schedule[deadline] = true;
                    profit += payment;
                    jobCount++;
                    break;

                } else {

                    deadline--;

                }

            }

        }

        return profit;

    }

}
