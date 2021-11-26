package org.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {


    public static void main(String[] args) {
        List<String> restDays = new ArrayList<>();
        restDays.add("SU");
        restDays.add("MO");
        restDays.add("TU");
        List<String> rsiaDays = new ArrayList<>();
        rsiaDays.add("MO");
//        rsiaDays.add("TU");
        List<String> result = rsiaDays.stream().filter(rsiaDay -> restDays.contains(rsiaDay)).collect(Collectors.toList());
        System.out.println(result);
        System.out.println(extracted(rsiaDays, result));
    }

    private static boolean extracted(List<String> rsiaDays, List<String> result) {
        return result.size() == rsiaDays.size();
    }
}

class Board {
    String brdNbr;
    String jobNbr;

    public Board(String brdNbr, String jobNbr) {
        this.brdNbr = brdNbr;
        this.jobNbr = jobNbr;
    }

    public String getBrdNbr() {
        return brdNbr;
    }

    public void setBrdNbr(String brdNbr) {
        this.brdNbr = brdNbr;
    }

    public String getJobNbr() {
        return jobNbr;
    }

    public void setJobNbr(String jobNbr) {
        this.jobNbr = jobNbr;
    }
}
