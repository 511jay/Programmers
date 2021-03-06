package programmers;

import java.util.ArrayList;

public class cache_algo {
	public static void main(String[] args) {
		int cache_size = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		Cache cache = new Cache(cache_size);
		int sum = 0;
		for(int i=0; i<cities.length; i++) {
			sum+=cache.search(cities[i]);
		}
		System.out.println(sum);
	}
	static class Cache{
		ArrayList<String> str_cache;
		ArrayList<Integer> usage;
		int max_size;
		public Cache(int size) {
			// TODO Auto-generated constructor stub
			str_cache = new ArrayList<String>();
			usage = new ArrayList<Integer>();
			max_size = size;
		}
		public int search(String in_data) {
			String data = in_data.toUpperCase();
			int result = 0;
			if(max_size == 0) {
				return 5;
			}
			if(str_cache.contains(data)) {
				result = 1;
				int index = str_cache.indexOf(data);
				usage.set(index, 0);
			}else {
				result = 5;
				if(str_cache.size() == max_size) {
					int max_index = 0;
					for(int i=1; i<usage.size(); i++) {
						if(usage.get(i)>usage.get(max_index)) {
							max_index = i;
						}
					}
					str_cache.remove(max_index);
					usage.remove(max_index);
					str_cache.add(data);
					usage.add(0);
				}else {
					str_cache.add(data);
					usage.add(0);
				}
			}
			for(int i=0; i<usage.size(); i++) {
				int temp = usage.get(i);
				usage.set(i, temp+1);
			}
			return result;
		}
	}
}
