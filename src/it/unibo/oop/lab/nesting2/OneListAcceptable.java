package it.unibo.oop.lab.nesting2;


import java.util.Iterator;
import java.util.List;

public class OneListAcceptable <T> implements Acceptable<T>{

	private final List<T> elements;
	
	public OneListAcceptable(List<T> elements) {
		super();
		this.elements = elements;
	}



	@Override
	public Acceptor<T> acceptor() {
		// TODO Auto-generated method stub
		return new Acceptor<T>() {
			
			private Iterator<T> iterator = OneListAcceptable.this.elements.iterator();
			
			@Override
			public void accept(T newElement) throws ElementNotAcceptedException {
				if (!this.iterator.hasNext() || !this.iterator.next().equals(newElement)) {
					throw new ElementNotAcceptedException(newElement);
				}				
			}

			@Override
			public void end() throws EndNotAcceptedException {
				if (!this.iterator.hasNext()) {
					throw new EndNotAcceptedException();
				}
				
			}
			
		};
	}

}
