package eg.edu.alexu.csd.filestructure.sort.cs_23_cs24;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.management.RuntimeErrorException;

import eg.edu.alexu.csd.filestructure.sort.IHeap;
import eg.edu.alexu.csd.filestructure.sort.INode;

public class MyHeap < T extends Comparable<T>> implements IHeap<T>{
	
	private ArrayList<INode<T>> heap = new ArrayList<INode<T>>();

	@Override
	public INode<T> getRoot() {
		if(heap.size()==0) {
			throw new RuntimeErrorException(null);
		}else {
		return heap.get(0);
	}
	}

	@Override
	public int size() {
		
		return heap.size();
	}

	@Override
	public void heapify(INode<T> node) {
		// a4t8al nodes walla indeces walla m4 far2a ?
		
		INode<T> lChild = node.getLeftChild();
		INode<T> rChild = node.getRightChild();
		INode<T> greatest = node;
		
		if(node.getValue().compareTo(lChild.getValue()) < 0) {
			greatest = lChild;
		}
		
		if(greatest.getValue().compareTo(rChild.getValue()) < 0) {
			greatest = rChild;
		}
		
		if(((MyNode<T>)greatest).get_index() != ((MyNode<T>)node).get_index()) {
			T val =  greatest.getValue();
			greatest.setValue(node.getValue());
			node.setValue(val);
			heapify(greatest);
		}
		
		
	}

	@Override
	public T extract() {
		INode<T> root = getRoot();
		INode<T>  last = heap.get(size()-1);
		T val = root.getValue();
		root.setValue(last.getValue());
		last.setValue(val);
		heap.remove(heap.size()-1);
		heapify(root);
		return val;
	}

	@Override
	public void insert(T element) {
		INode<T> newNode = new MyNode<T>();
		newNode.setValue(element);
		((MyNode<T>)newNode).set_index(heap.size());
		heap.add(newNode);
		
		INode<T> parent = newNode.getParent();
		while(parent.getValue().compareTo(element) < 0 ) {
			newNode.setValue(parent.getValue());
			parent.setValue(element);
			parent=parent.getParent();
		}
	}

	@Override
	public void build(Collection<T> unordered) {
		 Iterator<T> iterator = unordered.iterator();
		 while (iterator.hasNext()) {
			 T element = iterator.next();
			 insert(element);
			 
		}
		
		/**heap = (ArrayList<INode>) unordered;
		for(int counter= (heap.size()-1)/2 ; counter >1 ; counter--) {
			heapify(heap.get(counter));
		}*/
		
	}
	
	public void heapifySize(int size, INode<T> iNode) {
		INode<T> conIndex;
		if (((MyNode<T>) iNode).get_index() > size) {
			return;
		} else {
			if (iNode.getLeftChild().getValue().compareTo(iNode.getValue()) > 0) {
				conIndex = iNode.getLeftChild();
			}
			conIndex = iNode;
			if (iNode.getRightChild().getValue().compareTo(conIndex.getValue()) > 0) {
				conIndex = iNode.getRightChild();
			}
			if (conIndex.getValue().compareTo(iNode.getValue()) != 0) {
				this.swap(((MyNode<T>)conIndex).get_index(),((MyNode<T>) iNode).get_index());
				heapifySize(size, (MyHeap<T>.MyNode<T>) conIndex);
			}

		}
	}
	
	public void swap(int i, int j) {
		// TODO Auto-generated method stub
		T temp = heap.get(i).getValue();
		heap.get(i).setValue(heap.get(j).getValue());
		heap.get(j).setValue(temp);
	}
	
	
	
	
	class MyNode< T extends Comparable<T>> implements INode<T>{
		
		private int index ;
		private T value;
		
		
		@Override
		public INode<T> getLeftChild() {
			int LeftChild = index*2+1;
			if(heap.size() <= LeftChild) {
				throw new RuntimeErrorException(null);
			}else {
			return (INode<T>) heap.get(LeftChild);
		}
		}

		@Override
		public INode<T> getRightChild() {
			int rightChild = index*2+2;
			if(heap.size() <= rightChild) {
				throw new RuntimeErrorException(null);
			}else {
			return (INode<T>) heap.get(rightChild);
		}
		}

		@Override
		public INode<T> getParent() {
			int parent = (index-1)/2;
			if(parent <0 ) {
				throw new RuntimeErrorException(null);
			}
			return (INode<T>) heap.get(parent);
		}

		@Override
		public T getValue() {
			if(value == null) {
				throw new RuntimeErrorException(null);
			}else {
			return  value;
		}
		}

		@Override
		public void setValue(T value) {
			this.value = value; 
			
		}
		
		private void set_index(int ind) {
			index = ind;
		}
		
		private int get_index() {
			return index;
		}
	}

}





