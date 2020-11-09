package it.unibo.oop.lab.nesting2;


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
			
			private int index = 0;
			
			@Override
			public void accept(T newElement) throws ElementNotAcceptedException {
				if (index >= elements.size() || elements.get(index) != newElement) {
					throw new ElementNotAcceptedException(newElement);
				}else {
					index += 1;
				}
				
			}

			@Override
			public void end() throws EndNotAcceptedException {
				if (index < elements.size()) {
					throw new EndNotAcceptedException();
				}
				
			}
			
		};
	}

}
