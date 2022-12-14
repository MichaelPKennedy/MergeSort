import java.util.Random;

public class MergeSort {  
	
	public static void main(String[] args) {   //this creates the array of nodes
		Node[] table = new Node[1000000]; 

		Random rand = new Random();

		for (int i = 0; i<table.length; i++) {
			table[i] = new Node();
			table[i].key = rand.nextInt(100000000); 
		}
		/*for (int i = 0; i<table.length;i++) {  //to test sort on smaller number set
			System.out.println(table[i].key);
		}*/
		long start = System.currentTimeMillis();
		sort(table);
		
		long runTime = System.currentTimeMillis()-start;
		System.out.println("The merge sort took " + runTime + " milliseconds");
		/*
		System.out.println();
		for (int i = 0; i<table.length;i++) { //to test sort on smaller number set 
			System.out.println(table[i].key);
		}*/
	}


	public static void sort(Node[] list) {
		if (list.length <10) {
			selection(list);
			return;
		}
		Node[] lista, listb;
		lista = new Node[list.length/2];
		listb = new Node[list.length - lista.length];
		for (int i = 0; i<lista.length;i++) {                //this copies the first half of the array to lista
			lista[i] = list[i];
		}
		for (int i = lista.length; i<list.length; i++) {    //this copies the last half of the array to listb
			listb[i-lista.length] = list[i];
		}
		sort(lista);
		sort(listb);

		merge(lista, listb, list);
	}

	public static void merge(Node[]lista, Node[]listb, Node[]list) {
		int a = 0;
		int b = 0;
		int i = 0;

		while (a<lista.length && b<listb.length) {
			if (lista[a].key<= listb[b].key) {
				list[i] = lista[a];
				a++;

			}else { 
				list[i] = listb[b];
				b++;
			}
			i++;
		}
		while (a<lista.length) {
			list[i] = lista[a];
			a++;
			i++;
		}
		while (b<listb.length) {
			list[i] = listb[b];
			b++;
			i++;
		}

	}
	
	public static void selection(Node[] list) {
		int minValue, minIndex;
		Node temp;
		for (int i = 0; i<list.length; i++) {
			minValue = list[i].key;
			minIndex = i;
			for (int j = i; j<list.length; j++) {
				if (list[j].key<minValue) {
					minValue = list[j].key;
					minIndex = j;
				}
				
			}
			if (minValue < list[i].key) {
				temp = list[i];
				list[i] = list[minIndex];
				list[minIndex] = temp;
			}
		}
	}


}