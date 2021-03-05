package programmers;

import java.util.ArrayList;

public class skill_tree {
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		int result = 0;
		for(int i=0; i<skill_trees.length; i++) {
			if(check_skill(skill, skill_trees[i])) {
				result++;
			}
		}
		System.out.println(result);
		
 	}
	static boolean check_skill(String skill, String skill_tree) {
		boolean result = true;
		int[] visit = new int[skill.length()];
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i=0; i<skill.length(); i++) {
			list.add(skill.charAt(i));
		}
		for(int i=0; i<skill_tree.length(); i++) {
			if(list.contains(skill_tree.charAt(i))) {
				int index = list.indexOf(skill_tree.charAt(i));
				visit[index] = 1;
				for(int j=index; j>=0; j--) {
					if(visit[j]==0) {
						return false;
					}
				}
			}
		}
		return result;
	}
}
