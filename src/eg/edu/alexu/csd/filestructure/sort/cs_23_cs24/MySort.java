package eg.edu.alexu.csd.filestructure.sort.cs_23_cs24;

import java.util.ArrayList;
import java.util.Collections;

import eg.edu.alexu.csd.filestructure.sort.IHeap;
import eg.edu.alexu.csd.filestructure.sort.INode;
import eg.edu.alexu.csd.filestructure.sort.ISort;
import eg.edu.alexu.csd.filestructure.sort.cs_23_cs24.MyHeap.MyNode;

public class MySort<T extends Comparable<T>> implements ISort<T> {

	@Override
	public IHeap heapSort(ArrayList<T> unordered) {
		// TODO Auto-generated method stub
		IHeap<T> heap = new MyHeap<T>();
		//INode<T> newNode = new MyNode<T>();
		heap.build(unordered);
		int size = unordered.size();
		for (int i = 0; i < unordered.size(); i++) {
			((MyHeap<T>)heap).swap(0, size - i);
			((MyHeap<T>) heap).heapifySize(size - i, heap.getRoot());
		}
		return heap;
	}

	@Override
	public void sortSlow(ArrayList<T> unordered) {
		// TODO Auto-generated method stub
		boolean swaped = true;
		for (int i = 0; i < unordered.size() && swaped; i++) {
			swaped = false;
			for (int j = 0; j < unordered.size() - 1; j++) {
				if (((Comparable<T>) unordered.get(j + 1)).compareTo((T) unordered.get(j)) < 0) {
					Collections.swap(unordered, j, j + 1);
					swaped = true;
				}
			}
		}
	}

	

	@Override
	public void sortFast(ArrayList<T> unordered) {
		quickSort(unordered,0,unordered.size()-1);
		
	}
	
	private void quickSort(ArrayList<T> unordered,int left , int right) {
		if(left < right) {
		int q = raondomized_partition(unordered,left,right);
		quickSort(unordered,left,q-1);
		quickSort(unordered,q+1,right);
	}
	}
	
	private int raondomized_partition(ArrayList<T> unordered,int left , int right) {
		int random = (int) (Math.random()*(left-right+1)+left); 
		T value = unordered.get(right);
		unordered.set(right, unordered.get(random));
		unordered.set(random, value);
		return partition(unordered,left,right);
	}
	
	private int partition(ArrayList<T> unordered,int left , int right) {
		T elemnt = unordered.get(right);
		int pointer = left;
		for(int counter=0;counter<right;counter++) {
			if(unordered.get(counter).compareTo(elemnt) < 0 ) {
				T value = unordered.get(counter);
				unordered.set(counter, unordered.get(pointer));
				unordered.set(pointer, value);
				pointer++;
			}
		}
		return pointer;
	}

}
