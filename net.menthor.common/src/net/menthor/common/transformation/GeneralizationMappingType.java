package net.menthor.common.transformation;

public enum GeneralizationMappingType {
	allClasses {
		@Override
		public String toString() {
			return "All Classes";
		}
	}, 
	leafClasses{
		@Override
		public String toString() {
			return "Leaf Classes";
		}
	},  
	_1stClasses{
		@Override
		public String toString() {
			return "1st Classes";
		}
	};
	
	public static String[] valuesStr(){
		int length = GeneralizationMappingType.values().length;
		String[] values = new String[length];
		
		for (int i = 0; i < length; i++) {
			values[i] = GeneralizationMappingType.values()[i].toString();
		}
		
		return values;
	}
}
