package net.menthor.virtuoso.instances;

public class MyKey {
	private String source, predicate, object;
	
	public MyKey(String source, String predicate, String object) {
		this.predicate = predicate;
		this.object = object;
	}

	public String getPredicate() {
		return predicate;
	}

	public String getObject() {
		return object;
	}
	
	public String getSource(){
		return source;
	}
}
