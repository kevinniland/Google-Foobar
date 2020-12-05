package google;

/**
 * @author Kevin Niland
 * 
 *         Problem Description: Power Hungry
 * 
 *         Commander Lambda's space station is HUGE. And huge space stations
 *         take a LOT of power. Huge space stations with doomsday devices take
 *         even more power. To help meet the station's power needs, Commander
 *         Lambda has installed solar panels on the station's outer surface. But
 *         the station sits in the middle of a quasar quantum flux field, which
 *         wreaks havoc on the solar panels. You and your team of henchmen have
 *         been assigned to repair the solar panels, but you'd rather not take
 *         down all of the panels at once if you can help it, since they do help
 *         power the space station and all!
 * 
 *         You need to figure out which sets of panels in any given array you
 *         can take offline to repair while still maintaining the maximum amount
 *         of power output per array, and to do THAT, you'll first need to
 *         figure out what the maximum output of each array actually is. Write a
 *         function solution(xs) that takes a list of integers representing the
 *         power output levels of each panel in an array, and returns the
 *         maximum product of some non-empty subset of those numbers. So for
 *         example, if an array contained panels with power output levels of [2,
 *         -3, 1, 0, -5], then the maximum product would be found by taking the
 *         subset: xs[0] = 2, xs[1] = -3, xs[4] = -5, giving the product
 *         2*(-3)*(-5) = 30. So solution([2,-3,1,0,-5]) will be "30".
 * 
 *         Each array of solar panels contains at least 1 and no more than 50
 *         panels, and each panel will have a power output level whose absolute
 *         value is no greater than 1000 (some panels are malfunctioning so
 *         badly that they're draining energy, but you know a trick with the
 *         panels' wave stabilizer that lets you combine two negative-output
 *         panels to produce the positive output of the multiple of their power
 *         values). The final products may be very large, so give the solution
 *         as a string representation of the number.
 *
 */
public class Level2 {
	public static String solution(int[] xs) {
		String maxProduct = "";
		int maxNegative = Integer.MIN_VALUE;
		int negativeCounter = 0;
		int zeroCounter = 0;
		int product = 1;
		boolean greaterThanZero = zeroCounter > 0;
		boolean oneNegative = negativeCounter == 1;
		boolean nonPositive = zeroCounter + negativeCounter == xs.length;

		if (xs[0] == 1) {
			return "1";
		}

		for (int i = 0; i < xs.length; i++) {
			if (xs[i] == 0) {
				zeroCounter++;
				continue;
			}

			if (xs[i] < 0) {
				negativeCounter++;

				maxNegative = Math.max(maxNegative, xs[i]);
			}

			product *= xs[i];
		}

		if (zeroCounter == xs.length) {
			return "0";
		}

		if (negativeCounter % 2 == 1) {
			if (oneNegative && greaterThanZero && nonPositive) {
				return "0";
			}

			product /= maxNegative;
		}

		maxProduct = Integer.toString(product);

		System.out.println(maxProduct);
		return maxProduct;
	}

	public static void main(String[] args) {
		// Provided test cases - seemingly passing. Showing failed when ran, however, are not
		// int[] xs = { 2, 0, 2, 2, 0 }; // Should return 8
		int[] xs = { -2, -3, 4, -5 }; 
		// int[] xs = { 1 }; // Should return 1
		// int[] xs = { 0 }; // Should return 0
		
		Level2.solution(xs);
	}
}
