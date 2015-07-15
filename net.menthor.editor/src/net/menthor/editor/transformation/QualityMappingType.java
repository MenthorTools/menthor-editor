package net.menthor.editor.transformation;

public enum QualityMappingType {
	hideQuality{
		@Override
		public String toString() {
			return "Ignore (hide) the quality";
		}
	},
	maintainQuality{
		@Override
		public String toString() {
			return "Maintain the quality";
		}
	}
}
