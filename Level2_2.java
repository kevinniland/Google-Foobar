package google;

import java.util.Arrays;
import java.util.Comparator;

public class Level2_2 implements Comparator<String> {
    public static String[] solution(String[] l) {
		Arrays.sort(l, new Level2_2());
		String[] newArr = new String[l.length];

		for (int i = 0; i < l.length; i++) {
			newArr[i] = l[i];
		}
		
		for (int i = 0; i < newArr.length; i++) {
			System.out.println(newArr[i]);
		}
		
		return newArr;
    }
    
    public static void main(String[] args) {
		String[] l = {"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"};
		
		Level2_2.solution(l);
	}
    
    @Override
	public int compare(String o1, String o2) {
		String[] parts1 = splitByParts(o1);
		String[] parts2 = splitByParts(o2);
		
		for (int i = 0; i < Math.min(parts1.length, parts2.length); i++) {
			int comparison = compareParts(parts1[i], parts2[i]);
			
			if (comparison != 0) {
				return comparison;
			}
		}
		
		return Integer.compare(parts1.length, parts2.length);
	}

	private int compareParts(String string, String string2) {
		int first = Integer.parseInt(string);
		int second = Integer.parseInt(string2);
		
		return Integer.compare(first, second);
	}

	protected String[] splitByParts(String o) {
		return o.split("\\.");
	}
}
