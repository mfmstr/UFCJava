package ufc.l19.main;

import java.util.ArrayList;

public class NumString<T> {
	private T min;
	private T max;
	private T avr;
	
	public T getMin() {
		return min;
	}

	public void setMin(T min) {
		this.min = min;
	}

	public T getMax() {
		return max;
	}

	public void setMax(T max) {
		this.max = max;
	}

	public T getAvr() {
		return avr;
	}

	public void setAvr(T avr) {
		this.avr = avr;
	}
	
	@SuppressWarnings("unchecked")
	public static <U extends Number> NumString<U> doNum(ArrayList<U> u) {
		
		U min = u.get(0);
		U max = u.get(0);
		
		NumString<U> x = new NumString<>();
		
		if(min instanceof Integer) {
			int avr = 0;
			for(U n : u) {
				if((int) min > (int) n) {
					min = n;
				}
				if((int) max < (int) n) {
					max = n;
				}
				avr = (int)avr + (int)n;
			}
			
			// ვინაიდან და რადგანაც T-ტიპის ცვლადს ინტეჯერის სახით არ იღებს ევერიჯი, დავქასთე ობჯექთზე და ობჯექთიდან ჩამოვქასთე U-ტიპზე, რომელიც შემდგომში მისაღები გახდა.
			
			avr = avr / u.size();
			Object avarage = (Object) avr;
			x.setAvr((U) avarage);
		
		}else if(min instanceof Double) {
			double avr = 0;
			for(U n : u) {
				if((double) min > (double) n) {
					min = n;
				}
				if((double) max < (double) n) {
					max = n;
				}
				avr = (double)avr + (double)n;
			}
			avr = avr / u.size();
			Object avarage = (Object) avr;
			x.setAvr((U) avarage);
		}else if(min instanceof Float) {
			float avr = 0;
			for(U n : u) {
				if((float) min > (float) n) {
					min = n;
				}
				if((float) max < (float) n) {
					max = n;
				}
				avr = (float)avr + (float)n;
			}
			avr = avr / u.size();
			Object avarage = (Object) avr;
			x.setAvr((U) avarage);
			
		}else if(min instanceof Long) {
			long avr = 0;
			for(U n : u) {
				if((long) min > (long) n) {
					min = n;
				}
				if((long) max < (long) n) {
					max = n;
				}
				avr = (long)avr + (long)n;
			}
			avr = avr / u.size();
			Object avarage = (Object) avr;
			x.setAvr((U) avarage);
		}else if(min instanceof Short) {
			short avr = 0;
			for(U n : u) {
				if((short) min > (short) n) {
					min = n;
				}
				if((short) max < (short) n) {
					max = n;
				}
				avr = (short) ((short)avr + (short)n);
			}
			avr = (short) (avr / u.size());
			Object avarage = (Object) avr;
			x.setAvr((U) avarage);
		}
		
		x.setMin(min);
		x.setMax(max);
	    return x;
		
	}
	
	public static NumString<Double> doString(ArrayList<String> u) {
		
		double min = u.get(0).length();
		double max = 0;
		double avr = 0;
		
		for(int i = 0; i < u.size(); i++) {
			if(max < u.get(i).length()) {
				max = u.get(i).length();
			}
			if(min > u.get(i).length()) {
				min = u.get(i).length();
			}
			avr += u.get(i).length();
		}
		
		avr = avr / u.size();
		
		NumString<Double> x = new NumString<>();
		
		x.setMin(min);
		x.setMax(max);
		
		return x;
	}
	
	public static void main(String[] args) {
		ArrayList<String> strList = new ArrayList<>();
		strList.add("1");
		strList.add("Kharebava");
		strList.add("JAVA");
		strList.add("TBC/UFC");
		
		System.out.println("The shortest string size: " + doString(strList).getMin());
		System.out.println("The Longest string size: " + doString(strList).getMax());
		System.out.println("The Average string size: " + doString(strList).getAvr());
		
		ArrayList<Integer> numList = new ArrayList<>();
		numList.add(10);
		numList.add(20);
		numList.add(30);
		
		ArrayList<Double> numList2 = new ArrayList<>();
		numList2.add(10.3);
		numList2.add(1.2);
		numList2.add(300.4);
		
		
		// მუშაობს ინტეჯერებზე
		System.out.println("The min number: " + doNum(numList2).getMin());
		System.out.println("The max number: " + doNum(numList2).getMax());
		System.out.println("The Average number: " + doNum(numList2).getAvr());
		
		// მუშაობს დაბლისთვის, შესაბამისად იმუშავებს ზემოთ მოცემული ტიპებისთვის.
		System.out.println("The min number: " + doNum(numList2).getMin());
		System.out.println("The max number: " + doNum(numList2).getMax());
		System.out.println("The Average number: " + doNum(numList2).getAvr());
		
	}
		
	}

