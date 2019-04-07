import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC0403_FrogJump {

    public static void main(String[] args) {
        int[] example1 = {0,1,3,5,6,8,12,17};

        System.out.println(new LC0403_FrogJump().canCross(example1));
    }

    Map<String, Boolean> canCrossResults = new HashMap<>();

    public boolean canCross(int[] stones) {
        return canCross(stones, 0, 0);
    }

    public boolean canCross(int[] stones, int atLocation, int previousJump) {

        System.out.println("at location " + atLocation + ", previous jump: " + previousJump);

        if (canCrossResults.containsKey(atLocation + "|" + previousJump)) {
            return canCrossResults.get(atLocation + "|" + previousJump);
        }

        if (atLocation == stones.length - 1) {

        }

        boolean canCross = false;

        int distance;
        for (int i = atLocation + 1; i < stones.length; ++i) {

            distance = stones[i] - stones[atLocation];


            if (i == stones.length - 1 && (previousJump - 1 <= distance && distance <= previousJump + 1)) {
                canCross = true; // this is the only way we make it, by landing on the final rock
            }

            if (distance > previousJump + 1) {
                canCross = false;
                break;
            } else if (distance == previousJump - 1 && canCross(stones, i, previousJump - 1)) {
                System.out.println("Can jump " + (previousJump - 1) + " to location [" + i + "]");
                canCross = true;
                break;
            } else if (distance == previousJump && canCross(stones, i, previousJump)) {
                System.out.println("Can jump " + previousJump + " to location [" + i + "]");
                canCross = true;
                break;
            } else if (distance == previousJump + 1 && canCross(stones, i, previousJump + 1)) {
                System.out.println("Can jump " + (previousJump + 1) + " to location [" + i + "]");
                canCross = true;
                break;
            }

        }



        canCrossResults.put(atLocation + "|" + previousJump, canCross);
        return canCross;
    }

    public boolean canJump(int previousJump, int start, int target) {
        return start + previousJump - 1 <= target && target <= start + previousJump + 1;
    }

}
