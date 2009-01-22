package mergesort;

import java.util.*;

class Sorter {
	int[] items;
	public void mergesort(int begin,int end) {
		if(begin - end > 1) {
			int nextend = (begin - end) / 2;
			mergesort(begin,nextend);
			mergesort(nextend+1,end);
			merge(begin,nextend,nextend+1,end);
		}
	}
	public void merge(int abegin,int aend,int bbegin,int bend) {
		int[] result = new int[bend-abegin];
		int firstres = 0;
		int firstleft = abegin;
		int firstright = bbegin;
		while((firstleft <= aend) && (firstright <= bend) && (firstres < bend-abegin)) {
			if(items[firstleft] <= items[firstright]) {
				result[firstres] = items[firstleft];
				firstleft++;
				firstres++;
			}
			else {
				result[firstres] = items[firstright];
				firstright++;
				firstres++;
			}
		}
		for(int i=0;i<(bend-abegin);i++)
			items[abegin + i] = result[i];
	}
	public int[] get_items() {
		return items;
	}
}

class LoggingEnforcedSorter extends LoggingAspect<WrappingAspect<Sorter,SortContractWrapper>> { }

class SortContractWrapper implements Wrapper<Sorter> {
	public void enter(Sorter x) throws Exception {
		if(x.get_items() == null)
			throw new Exception("Sorter.items empty.");
	}
	public void exit(Sorter x) throws Exception {
		if(x.get_items() == null)
			throw new Exception("Sorter.items empty.");
	}
}

//MorphJ really needs to learn to handle interface in morphing.
interface Wrapper<T> {
	void enter(T x) throws Exception;
	void exit(T x) throws Exception;
}

interface FilterOut<class T,class W> {
    <R,A*,E*>[m] for(R m(A,W) throws E : T.methods)
	public R m(A args,W wrapper) throws E;
}
		

class WrappingAspect<class T,class W extends Wrapper<T>> extends T {
	<R,A*,E*>[m] for(R m(A) throws E : T.methods ; 
			 no R m(A, W) throws E : FilterOut<T,W>.methods; 
			 no !final R m (A,W) throws E : T.methods )
	public R m(A args,W wrapper) throws E {
	    try {
		wrapper.enter(this);
		R result = super.m(args);
		wrapper.exit(this);
		return result;
	    } catch ( Exception e ) {
		throw new Error(e.getMessage());
	    }
	}
}

class Logging<class T> implements Wrapper<T> {
	public void enter(T x) {
		System.out.println("Entering method.");
	}

	public void exit(T x) {
		System.out.println("Exiting method.");
	}
}

class LoggingAspect<class T> extends WrappingAspect<T,Logging<T>> { }

