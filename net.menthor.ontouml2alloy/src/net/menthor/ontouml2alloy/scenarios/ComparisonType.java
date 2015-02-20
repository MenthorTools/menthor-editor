package net.menthor.ontouml2alloy.scenarios;

public enum ComparisonType {
	SIZE {
		@Override
		public String toString() {
			return "Size";
		}
	}, 
	EXT{
		@Override
		public String toString() {
			return "Extension";
		}
	}
}