package programmers;

import java.util.ArrayList;

public class arr_zip {
	public static void main(String[] args) {
		String str1 = "aabbaccc";
		String str2 = "ababcdcdababcdcd";
		String str3 = "abcabcdede";
		String str4 = "abcabcabcabcdededededede";//0-2, 3-5, 6-8
		String str5 = "xababcdcdababcdcd";
		
		//String temp = str1.substring(1, 4);
		//str[1]~[3]
		//System.out.println(temp+" "+str1);
		System.out.println(zip_size(str1));
		System.out.println(zip_size(str2));
		System.out.println(zip_size(str3));
		System.out.println(zip_size(str4));
		System.out.println(zip_size(str5));
	}
	
	static int zip_size(String str) {
		int result = 0;
		int pivot =str.length()/2;
		int min_size = str.length();
		for(int i=pivot; i>0; i--) {
			zip_master test = new zip_master();
			int count = str.length()/i;
			for(int j=0; j<count; j++) {
				String temp = str.substring(j*i, (j*i)+(i));
				
				test.add_str(temp);
			}
			String final_str = test.make_str()+str.substring(str.length()-str.length()%i, str.length());
			if(final_str.length()<min_size) {
				min_size = final_str.length();
			}
		}
		result = min_size;
		return result;
	}
	
	static class zip_master{
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Integer> zipper = new ArrayList<Integer>();
		
		public void add_str(String str) {
			if(list.isEmpty()) {
				list.add(str);
				zipper.add(1);
			}else {
				if(list.get(list.size()-1).equals(str)) {
					int temp = zipper.get(list.size()-1);
					zipper.set(list.size()-1, temp+1);
				}else {
					list.add(str);
					zipper.add(1);
				}
			}
		}
		public String make_str() {
			String result = "";
			for(int i=0; i<list.size(); i++) {
				String temp = list.get(i);
				if(zipper.get(i) != 1) {
					temp = zipper.get(i)+temp;
				}
				result+=temp;
			}
			return result;
		}
	}
}
