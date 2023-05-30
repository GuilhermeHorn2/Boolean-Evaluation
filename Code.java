package misc;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class main_misc2 {
	
   
	
	
	public static void main(String[] args) {
	//(a+b)%k = ((a % k)+(b % k)) % k    || ||
	
		String s1 = "1^0|0|1";
		String s2 = "0&0&0&1^1|0";
		/*int i = 1;
		String left = s1.substring(0,i);
		String right = s1.substring(i+1,s1.length());
		System.out.println(left);
		System.out.println(right);*/
		
		System.out.println(count_eval(s2,true));
		
	}	
	
	
	
	private static int count_eval(String s,boolean result){
		
		if(s.length() == 1) {
			int a =  Integer.parseInt(s);
			if(a == 1){
				if(result){
					return 1;
				}
				return 0;
			}
			else {
				if(!result) {
					return 1;
				}
				return 0;
			}
		}
		
		
		int total = 0;
		for(int k = 1;k < s.length();k+= 2){
			
			String x = s.substring(k, k+1);
			
				String left = s.substring(0,k);
				String right = s.substring(k+1,s.length());
				int left_true = count_eval(left,true);
				int left_false = count_eval(left,false);
				int right_true = count_eval(right,true);
				int right_false = count_eval(right,false);
				if(x.equals("^")){
					
					if(!result) {
						//XOR must be false:
						total += (left_true * right_true) + (left_false * right_false);
					}
					else {
						//XOR must be true
						total += (left_true * right_false) + (left_false * right_true);
					}
					
				}
				if(x.equals("|")){
					if(!result){
						//OR must be false:				
						total += left_false + right_false;
					}
					else {
						//OR must be true:
						total += (left_true * right_true) + (left_true * right_false) + (left_false * right_true);
					}
				}
				if(x.equals("&")){
					if(result){
						//AND must be true:
						total += left_true * right_true;
					}
					else {
						//AND must be false:
						total += (left_false * right_false) + (left_true * right_false) + (left_false * right_true); 
					}
				}
				
			}
			
		
		return total;
		
	}
	
	
	
	} 
	
