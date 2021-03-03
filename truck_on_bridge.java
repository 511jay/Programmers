package jhlee;

import java.util.*;

public class truck_on_bridge {
	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int[] truck = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		System.out.println(solution(bridge_length, weight, truck));
	}
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> truck= new LinkedList<Integer>();
        Queue<Integer> bridge= new LinkedList<Integer>();
        Queue<Integer> finish= new LinkedList<Integer>();
        int time = 0;
        int W = weight;
        
        for(int i=0; i<bridge_length; i++){
            bridge.offer(0);
        }
        for(int i=0; i<truck_weights.length; i++){
            truck.offer(truck_weights[i]);
        }
        
        while(finish.size() != truck_weights.length){
            if((truck.isEmpty()==true)){
                if(bridge.peek() == 0){
                    bridge.remove();
                    bridge.offer(0);
                }else if(bridge.peek() != 0){
                    finish.offer(bridge.peek());
                    W = W+bridge.peek();
                    bridge.remove();
                    bridge.offer(0);
                }
            }
            else{
                if(bridge.peek() == 0){
                    if((W-truck.peek()) >= 0){
                        bridge.remove();
                        bridge.offer(truck.peek());
                        W = W-truck.peek();
                        truck.remove();
                    }else if((W-truck.peek()) < 0){
                        bridge.remove();
                        bridge.offer(0);
                    }
                }else if(bridge.peek() != 0){
                    if((W-truck.peek()+bridge.peek()) >= 0){
                        finish.offer(bridge.peek());
                        W = W+bridge.peek();
                        bridge.remove();
                        bridge.offer(truck.peek());
                        W = W-truck.peek();
                        truck.remove();
                    }else if((W-truck.peek()+bridge.peek()) < 0){
                        finish.offer(bridge.peek());
                        W = W+bridge.peek();
                        bridge.remove();
                        bridge.offer(0);
                    }
                }
            }
            time++;
        }        
        return time;
    }
}
