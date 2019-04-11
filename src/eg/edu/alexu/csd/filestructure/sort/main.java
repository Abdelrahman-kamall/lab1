package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;

import eg.edu.alexu.csd.filestructure.sort.cs_23_cs24.MySort;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList a = new ArrayList();
		a.add(5);
		a.add(10);
		a.add(7);
		a.add(17);
		a.add(35);
		a.add(1);
		a.add(0);
		a.add(8);
		
		ISort sort = new MySort();
		sort.heapSort(a);
	}

}
