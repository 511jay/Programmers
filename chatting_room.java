package day2021_01;

import java.util.ArrayList;
import java.util.HashMap;

public class chatting_room {
	static Log log = new Log();
	public static void main(String[] args) {
		String[] in_str = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
				"Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] temp = Algo(in_str);
		for(int i=0; i<temp.length; i++) {
			System.out.println(temp[i]);
		}
	}
	static String[] Algo(String[] str) {
		HashMap<String, String> hash = new HashMap<String, String>();
		for(int i=0; i<str.length; i++) {
			int command = getCommand(str[i]);
			String ssn = getSsn(str[i]);
			String name = "";
			if(command == 1) {
				name = getName(str[i]);
				if(hash.containsKey(ssn)) {
					hash.replace(ssn, name);
				}else {
					hash.put(ssn, name);
				}
				log.addlog(command, ssn);
			}
			else if(command == 2) {
				log.addlog(command, ssn);
			}else if(command == 3) {
				name = getName(str[i]);
				hash.replace(ssn, name);
			}
		}
		String[] result = new String[log.logSize()];
		for(int i=0; i<log.logSize(); i++) {
			String temp = "";
			temp+=hash.get(log.ssn.get(i))+"님이 ";
			switch (log.command.get(i)) {
			case 1: 
				temp+="들어왔습니다.";
				break;
			case 2: 
				temp+="나갔습니다.";
				break;
			default:
				break;
			}
			result[i] = temp;
		}
		return result;
	}
	static int getCommand(String str) {
		int result = 0;
		String temp = ""; 
		for(int i=0; i<str.length(); i++) {
			temp+=str.charAt(i);
			if(temp.equals("Enter")) {
				result = 1;
				break;
			}else if(temp.equals("Leave")) {
				result = 2;
				break;
			}else if(temp.equals("Change")) {
				result = 3;
				break;
			}
		}
		return result;
	}
	static String getSsn(String str) {
		String result = "";
		int flag = 0;
		for(int i=0; i<str.length(); i++) {
			if(flag == 2)
				break;
			if(str.charAt(i) == ' ') {
				flag++;
			}else {
				if(flag == 1) {
					result+=str.charAt(i);
				}
			}
		}
		return result;
	}
	static String getName(String str) {
		String result = "";
		int flag = 0;
		for(int i=0; i<str.length(); i++) {
			if(flag == 2) {
				result+=str.charAt(i);
			}else {
				if(str.charAt(i) == ' ') {
					flag++;
				}
			}
		}
		return result;
	}
	public static class Log{		
		ArrayList<Integer> command = new ArrayList<Integer>();
		ArrayList<String> ssn = new ArrayList<String>();
		
		public void addlog(int command, String ssn) {
			this.command.add(command);
			this.ssn.add(ssn);
		}
		public int logSize() {
			return command.size();
		}
	}
}
