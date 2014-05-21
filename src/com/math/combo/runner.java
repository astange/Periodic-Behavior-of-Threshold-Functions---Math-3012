package com.math.combo;

import java.util.LinkedList;

import Jama.Matrix;



public class runner {
	static int recur = 0;
	static LinkedList<MyIntArray> previousVectorx = new LinkedList<MyIntArray>();
	static int m = -1;
	static int t;

	public static void periodicBehavior(Matrix a, double[] vectorTheta, MyIntArray vectorx0){
		int n = vectorx0.size();
		int i;
		int j;
		double sum;
		MyIntArray vectorxCopy = new MyIntArray(n);
		previousVectorx.add(vectorx0);

		for(i = 0; i < n; i++){
			sum = 0;
			for(j = 0; j< n ; j++){
				sum += a.get(i, j) * vectorx0.get(j);
			}
			if(sum < vectorTheta[i]){
				vectorxCopy.put(i, 0);
			}else{
				vectorxCopy.put(i, 1);
			}
		}
		vectorx0 = vectorxCopy;
		int index = 0;

		if((index = previousVectorx.lastIndexOf(vectorx0)) == -1){
			periodicBehavior(a,vectorTheta,vectorx0);
		}else{
			if(m == -1){
				m = index;
			}
			t = previousVectorx.size() - index;
			recur++;
			if(recur == 2){
				previousVectorx.add(vectorx0);
				return;
			}
			periodicBehavior(a,vectorTheta,vectorx0);
		}
	}
	
	public static void main(String[] args){
		Matrix a = new Matrix(5,5);
		a.set(0, 0, 0);
		a.set(0, 1, 1);
		a.set(0, 2, 1);
		a.set(0, 3, 1);
		a.set(0, 4, 1);

		a.set(1, 0, 1);
		a.set(1, 1, 0);
		a.set(1, 2, 1);
		a.set(1, 3, 1);
		a.set(1, 4, 1);

		a.set(2, 0, 1);
		a.set(2, 1, 1);
		a.set(2, 2, 0);
		a.set(2, 3, 1);
		a.set(2, 4, 1);

		a.set(3, 0, 1);
		a.set(3, 1, 1);
		a.set(3, 2, 1);
		a.set(3, 3, 0);
		a.set(3, 4, 1);

		a.set(4, 0, 1);
		a.set(4, 1, 1);
		a.set(4, 2, 1);
		a.set(4, 3, 1);
		a.set(4, 4, 0);

		double[] vectorTheta = new double[5];
		vectorTheta[0] = 1;
		vectorTheta[1] = 2;
		vectorTheta[2] = 3;
		vectorTheta[3] = 4;
		vectorTheta[4] = 1.5;

		MyIntArray vectorx0 = new MyIntArray(5);
		vectorx0.put(0, 0);
		vectorx0.put(1, 1);		
		vectorx0.put(2, 0);
		vectorx0.put(3, 1);
		vectorx0.put(4, 0);

		periodicBehavior(a,vectorTheta,vectorx0);
		System.out.println("M: " + m + " T: " + t);
		System.out.println("Path that X0 followed: ");
		for(int i = 0; i < previousVectorx.size(); i++){
			System.out.print("Vector " + i + " has values: ");
			MyIntArray array = previousVectorx.get(i);
			for(int j = 0; j < array.size(); j++){
				System.out.print(array.get(j) + " ");
			}
			System.out.println();
		}
		checkAll();
		System.out.println(t);
		//checkAll10();
		//System.out.println(t);

	}
	public static MyIntArray checkAll(){
		Matrix a = new Matrix(5,5);
		a.set(0, 0, 0);
		a.set(0, 1, 1);
		a.set(0, 2, 1);
		a.set(0, 3, 1);
		a.set(0, 4, 1);

		a.set(1, 0, 1);
		a.set(1, 1, 0);
		a.set(1, 2, 1);
		a.set(1, 3, 1);
		a.set(1, 4, 1);

		a.set(2, 0, 1);
		a.set(2, 1, 1);
		a.set(2, 2, 0);
		a.set(2, 3, 1);
		a.set(2, 4, 1);

		a.set(3, 0, 1);
		a.set(3, 1, 1);
		a.set(3, 2, 1);
		a.set(3, 3, 0);
		a.set(3, 4, 1);

		a.set(4, 0, 1);
		a.set(4, 1, 1);
		a.set(4, 2, 1);
		a.set(4, 3, 1);
		a.set(4, 4, 0);
		double[] vectorTheta;
		MyIntArray vectorx0;
		for(int b = 0; b < 6; b++){
			for(int c = 0; c < 6; c++){
				for(int d = 0; d < 6; d++){
					for(int e = 0; e< 6; e++){
						for(int f = 0; f < 6; f++){
							vectorTheta = new double[5];
							vectorTheta[0] = b;
							vectorTheta[1] = c;
							vectorTheta[2] = d;
							vectorTheta[3] = e;
							vectorTheta[4] = f;
							for(int g = 0; g < 2; g++){
								for(int h = 0; h < 2; h++){
									for(int j = 0; j < 2; j++){
										for(int k = 0; k < 2; k++){
											for(int l = 0; l < 2; l++){
												vectorx0 = new MyIntArray(5);
												vectorx0.put(0, g);
												vectorx0.put(1, h);		
												vectorx0.put(2, j);
												vectorx0.put(3, k);
												vectorx0.put(4, l);
												MyIntArray vectorx0Copy = vectorx0;
												previousVectorx = new LinkedList<MyIntArray>();
												recur = 0;
												m = -1;
												t = 0;
												periodicBehavior(a,vectorTheta,vectorx0);
												if(t > 2){
													return vectorx0Copy;
												}
											}
										}
									}
								}
							}

						}
					}
				}
			}
		}
		return null;
	}

	public static MyIntArray checkAll10(){
		Matrix a = new Matrix(10,10);
		a.set(0, 0, 0);
		a.set(0, 1, 1);
		a.set(0, 2, 1);
		a.set(0, 3, 1);
		a.set(0, 4, 1);
		a.set(0, 5, 1);
		a.set(0, 6, 1);
		a.set(0, 7, 1);
		a.set(0, 8, 1);
		a.set(0, 9, 1);		

		a.set(1, 0, 1);
		a.set(1, 1, 0);
		a.set(1, 2, 1);
		a.set(1, 3, 1);
		a.set(1, 4, 1);
		a.set(1, 5, 1);
		a.set(1, 6, 1);
		a.set(1, 7, 1);
		a.set(1, 8, 1);
		a.set(1, 9, 1);

		a.set(2, 0, 1);
		a.set(2, 1, 1);
		a.set(2, 2, 0);
		a.set(2, 3, 1);
		a.set(2, 4, 1);
		a.set(2, 5, 1);
		a.set(2, 6, 1);
		a.set(2, 7, 1);
		a.set(2, 8, 1);
		a.set(2, 9, 1);

		a.set(3, 0, 1);
		a.set(3, 1, 1);
		a.set(3, 2, 1);
		a.set(3, 3, 0);
		a.set(3, 4, 1);
		a.set(3, 5, 1);
		a.set(3, 6, 1);
		a.set(3, 7, 1);
		a.set(3, 8, 1);
		a.set(3, 9, 1);

		a.set(4, 0, 1);
		a.set(4, 1, 1);
		a.set(4, 2, 1);
		a.set(4, 3, 1);
		a.set(4, 4, 0);
		a.set(4, 5, 1);
		a.set(4, 6, 1);
		a.set(4, 7, 1);
		a.set(4, 8, 1);
		a.set(4, 9, 1);

		a.set(5, 0, 1);
		a.set(5, 1, 1);
		a.set(5, 2, 1);
		a.set(5, 3, 1);
		a.set(5, 4, 1);
		a.set(5, 5, 0);
		a.set(5, 6, 1);
		a.set(5, 7, 1);
		a.set(5, 8, 1);
		a.set(5, 9, 1);

		a.set(6, 0, 1);
		a.set(6, 1, 1);
		a.set(6, 2, 1);
		a.set(6, 3, 1);
		a.set(6, 4, 1);
		a.set(6, 5, 1);
		a.set(6, 6, 0);
		a.set(6, 7, 1);
		a.set(6, 8, 1);
		a.set(6, 9, 1);

		a.set(7, 0, 1);
		a.set(7, 1, 1);
		a.set(7, 2, 1);
		a.set(7, 3, 1);
		a.set(7, 4, 1);
		a.set(7, 5, 1);
		a.set(7, 6, 1);
		a.set(7, 7, 0);
		a.set(7, 8, 1);
		a.set(7, 9, 1);

		a.set(8, 0, 1);
		a.set(8, 1, 1);
		a.set(8, 2, 1);
		a.set(8, 3, 1);
		a.set(8, 4, 1);
		a.set(8, 5, 1);
		a.set(8, 6, 1);
		a.set(8, 7, 1);
		a.set(8, 8, 0);
		a.set(8, 9, 1);

		a.set(9, 0, 1);
		a.set(9, 1, 1);
		a.set(9, 2, 1);
		a.set(9, 3, 1);
		a.set(9, 4, 1);
		a.set(9, 5, 1);
		a.set(9, 6, 1);
		a.set(9, 7, 1);
		a.set(9, 8, 1);
		a.set(9, 9, 0);
		double[] vectorTheta;
		MyIntArray vectorx0;
		for(int b = 0; b < 11; b++){
			for(int c = 0; c <11; c++){
				for(int d = 0; d < 11; d++){
					for(int e = 0; e< 11; e++){
						for(int f = 0; f < 11; f++){
							for(int q = 0; q < 11; q++){
								for(int w = 0; w < 11; w++){
									for(int y = 0; y < 11; y++){
										for(int r = 0; r < 11; r++){
											for(int t = 0; t < 11; t++){
												vectorTheta = new double[10];
												vectorTheta[0] = b;
												vectorTheta[1] = c;
												vectorTheta[2] = d;
												vectorTheta[3] = e;
												vectorTheta[4] = f;
												vectorTheta[5] = q;
												vectorTheta[6] = w;
												vectorTheta[7] = y;
												vectorTheta[8] = r;
												vectorTheta[9] = t;
												for(int g = 0; g < 2; g++){
													for(int h = 0; h < 2; h++){
														for(int j = 0; j < 2; j++){
															for(int k = 0; k < 2; k++){
																for(int l = 0; l < 2; l++){
																	for(int z = 0; z < 2; z++){
																		for(int x = 0; x < 2; x++){
																			for(int v = 0; v < 2; v++){
																				for(int n = 0; n < 2; n++){
																					for(int m = 0; m < 2; m++){
																						vectorx0 = new MyIntArray(10);
																						vectorx0.put(0, g);
																						vectorx0.put(1, h);		
																						vectorx0.put(2, j);
																						vectorx0.put(3, k);
																						vectorx0.put(4, l);
																						vectorx0.put(5, z);
																						vectorx0.put(6, x);
																						vectorx0.put(7, v);
																						vectorx0.put(8, n);
																						vectorx0.put(9, m);
																						MyIntArray vectorx0Copy = vectorx0;
																						previousVectorx = new LinkedList<MyIntArray>();
																						recur = 0;
																						m = -1;
																						t = 0;
																						periodicBehavior(a,vectorTheta,vectorx0);
																						if(t > 2){
																							return vectorx0Copy;
																						}
																					}
																				}
																			}
																		}
																	}

																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		return null;
	}

	/*		


		vectorTheta = new double[10];
		vectorTheta[0] = 4;
		vectorTheta[1] = 5;
		vectorTheta[2] = 6;
		vectorTheta[3] = 7;
		vectorTheta[4] = 4.5;
		vectorTheta[5] = 4;
		vectorTheta[6] = 5;
		vectorTheta[7] = 6;
		vectorTheta[8] = 7;
		vectorTheta[9] = 4.5;


		vectorx0 = new MyIntArray(10);
		vectorx0.put(0, 1);
		vectorx0.put(1, 0);		
		vectorx0.put(2, 1);
		vectorx0.put(3, 0);
		vectorx0.put(4, 1);
		vectorx0.put(5, 0);
		vectorx0.put(6, 1);
		vectorx0.put(7, 0);
		vectorx0.put(8, 1);
		vectorx0.put(9, 0);


		previousVectorx = new LinkedList<MyIntArray>();
		recur = 0;
		m = -1;
		t = 0;
		System.out.println();
		periodicBehavior(a,vectorTheta,vectorx0);
		System.out.println("M: " + m + " T: " + t);
		System.out.println("Path that X0 followed: ");
		for(int i = 0; i < previousVectorx.size(); i++){
			System.out.print("Vector " + i + " has values: ");
			MyIntArray array = previousVectorx.get(i);
			for(int j = 0; j < array.size(); j++){
				System.out.print(array.get(j) + " ");
			}
			System.out.println();
		}
	}*/



	private static class MyIntArray{
		private int[] array;

		public MyIntArray(int size){
			array = new int[size];
		}

		public void put(int index, int number){
			array[index] = number;
		}

		public int get(int index){
			return array[index];
		}

		public int size(){
			return array.length;
		}

		public boolean equals(Object o){
			if(o == null){
				return false;
			}
			if(!(o instanceof MyIntArray)){
				return false;
			}
			MyIntArray obj = (MyIntArray) o;
			for(int i = 0; i < array.length; i++){
				if(this.get(i) != obj.get(i)){
					return false;
				}
			}
			return true;
		}
	}
}
