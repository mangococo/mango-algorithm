package stu.mango.algorithm.exam.stack.hanoii;

/**
 * 堆栈解决汉诺塔问题
 *
 * @author mangococo
 * <p>
 * 2018/4/11 11:25
 */
public class HanoiProblem {
    private boolean debug;

    public HanoiProblem(boolean debug) {
        this.debug = debug;
    }

    public void hanoi(int num, String left, String mid, String right) {
        if (num < 1) {
            System.out.println("It will not move.");
            return;
        }

        int steps = process(num, left, mid, right, left, right);
        System.out.println("It will move " + steps +" steps");
    }

    private int process(int num, String left, String mid, String right, String from, String to) {
        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                return printAction(from, to, 1);
            }

            return printAction(from, mid, to);
        }

        if (from.equals(mid) || to.equals(mid)) {
            String aide = (from.equals(left) || to.equals(left)) ? right : left;

            int part1 = process(num -1, left, mid, right, from, aide);
            int part2 = printAction(from, to, 1);

            return part1 + part2 + process(num -1, left, mid, right, aide, to);
        }

        int part1 = process(num -1, left, mid, right, from, to);
        int part2 = printAction(from, mid, num);
        int part3 = process(num - 1, left, mid, right, to, from);
        int part4 = printAction(mid, to, num);

        return part1 + part2 + part3 + part4 +
                process(num -1, left, mid, right, from, to);
    }

    private int printAction(String from, String to, int num) {
        if (debug) {
            System.out.println("Move " + num + " form " + from + " to " + to);
        }

        return 1;
    }

    private int printAction(String from, String mid, String to) {
        return printAction(from, mid, 1) + printAction(mid, to, 1);
    }
}

