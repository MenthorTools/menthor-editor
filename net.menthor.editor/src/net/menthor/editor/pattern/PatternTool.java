package net.menthor.editor.pattern;

import java.util.List;

import org.tinyuml.draw.DiagramElement;

import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.editor.explorer.ProjectBrowser;
import net.menthor.editor.model.ElementType;
import net.menthor.pattern.dynamic.ui.ModelCompleterIdentity;
import net.menthor.pattern.impl.AbstractPattern;
import net.menthor.pattern.impl.MixinPattern;
import net.menthor.pattern.impl.MixinPatternWithSubkind;
import net.menthor.pattern.impl.PhasePartition;
import net.menthor.pattern.impl.RelatorPattern;
import net.menthor.pattern.impl.RoleMixinPattern;
import net.menthor.pattern.impl.RolePartition;
import net.menthor.pattern.impl.SubkindPartition;
import net.menthor.pattern.impl.SubstanceSortalPartition;

/**
 * @author Victor Amorim
 */
public class PatternTool {
	/**
	 * Public methods 
	 */

	@SuppressWarnings("incomplete-switch")
	public static Fix tryToRun(ElementType elem,double x,double y){
		AbstractPattern pm = null;
		ModelCompleterIdentity mci = null;

		switch (elem) {
		case PATTERN_MIXIN_PATTERN:
			pm = new MixinPattern(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y); 
			break;
		case PATTERN_MIXIN_PATTERN_WITH_SUBKIND:
			pm = new MixinPatternWithSubkind(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y);
			break;
		case PATTERN_PHASE_PARTITION:
			pm = new PhasePartition(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y);
			break;
		case PATTERN_RELATOR:
			pm = new RelatorPattern(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y);
			break;
		case PATTERN_ROLEMIXIN_PATTERN:
			pm = new RoleMixinPattern(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y);
			break;
		case PATTERN_ROLE_PARTITION:
			pm = new RolePartition(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y);
			break;
		case PATTERN_SUBKIND_PARTITION:
			pm = new SubkindPartition(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y);
			break;
		case PATTERN_SUBSTANCE_SORTAL_PARTITION:
			pm = new SubstanceSortalPartition(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y);
			break;
		case PATTERN_COMPLETER:
			mci = ModelCompleterIdentity.createDialog(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y);
			break;
		}
		Fix fix = null;
		if(pm != null){
			pm.runPattern();
			if(pm.canGetFix())
				fix = pm.getFix();
		}

		if(mci != null){
			mci.open();
			fix = mci.getFix();
		}
		
		return fix;
	}


	@SuppressWarnings("incomplete-switch")
	public static Fix tryToRun(ElementType elem, List<DiagramElement> selectedElements) {
		Fix fix = null;

		switch (elem) {
		case ADDSUBTYPE:
			break;
		case ADDSUPERTYPE:
			break;
		case GENERALIZATIONSPECIALIZATION:
			break;
		case PATTERN_PRINCIPLE_IDENTITY:
			break;
		}

		return fix;
	}
}