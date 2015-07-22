package net.menthor.editor.pattern;

import javax.swing.SwingUtilities;

import org.eclipse.swt.widgets.Display;

import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.editor.DiagramManager;
import net.menthor.editor.Main;
import net.menthor.editor.explorer.ProjectBrowser;
import net.menthor.editor.model.ElementType;
import net.menthor.pattern.dynamic.ui.ModelCompleter;
import net.menthor.pattern.impl.AbstractPattern;
import net.menthor.pattern.impl.AntiRigidWeakSupplementation;
import net.menthor.pattern.impl.CategoryPattern;
import net.menthor.pattern.impl.CharacterizationPattern;
import net.menthor.pattern.impl.CollectivePartition;
import net.menthor.pattern.impl.GenericMultipleRelator;
import net.menthor.pattern.impl.KindPartition;
import net.menthor.pattern.impl.MixinPattern;
import net.menthor.pattern.impl.MixinPatternWithSubkind;
import net.menthor.pattern.impl.PhasePartition;
import net.menthor.pattern.impl.QuantityPartition;
import net.menthor.pattern.impl.RelatorPattern;
import net.menthor.pattern.impl.RigidWeakSupplementation;
import net.menthor.pattern.impl.RoleMixinDependentPattern;
import net.menthor.pattern.impl.RoleMixinPattern;
import net.menthor.pattern.impl.RolePartition;
import net.menthor.pattern.impl.SubkindPartition;
import net.menthor.pattern.ui.manager.ModelCompleterManager;
import RefOntoUML.Classifier;

/**
 * @author Victor Amorim
 */
public class PatternTool {
	@SuppressWarnings("incomplete-switch")
	private static Fix tryToRun(DiagramManager diagramManager, ElementType elem,double x,double y){
		AbstractPattern pm = null;

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
		case PATTERN_ROLEMIXIN:
			pm = new RoleMixinPattern(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y);
			break;
		case PATTERN_ROLE_PARTITION:
			pm = new RolePartition(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y);
			break;
		case PATTERN_SUBKIND_PARTITION:
			pm = new SubkindPartition(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y);
			break;
		case KIND_PARTITION:
			pm = new KindPartition(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y);
			break;
		case COLLECTIVE_PARTITION:
			pm = new CollectivePartition(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y);
			break;
		case QUANTITY_PARTITION:
			pm = new QuantityPartition(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y);
			break;
		case CATEGORY_PATTERN:
			pm = new CategoryPattern(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y);
			break;
		case DEPENDENT_ROLEMIXIN:
			pm = new RoleMixinDependentPattern(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y);
			break;
		case GENERIC_RELATOR:
			pm = new GenericMultipleRelator(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y);
			break;
		case CHARACTERIZATION_PATTERN:
			pm = new CharacterizationPattern(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y);
			break;
		case RIGID_WEAK_SUPPLEMENTATION:
			pm = new RigidWeakSupplementation(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y);
			break;
		case ANTIRIGID_WEAK_SUPPLEMENTATION:
			pm = new AntiRigidWeakSupplementation(ProjectBrowser.frame.getProjectBrowser().getParser(), x, y);
			break;
		}

		Fix fix = null;
		if(pm != null){
			pm.runPattern();
			if(pm.canGetFix()){
				fix = pm.getFix();
				diagramManager.updateMenthor(fix);
				_runModelCompleter(diagramManager, x, y,false);
			}
		}else{
			if(elem == ElementType.PATTERN_COMPLETER)
				_runModelCompleter(diagramManager, x, y);
		}

		return fix;
	}

	/*
	 * Called when clicked at Toolbar
	 * */
	private static void _runModelCompleter(final DiagramManager diagramManager,final double x, final double y) {
		try{
			ModelCompleter mcw = ModelCompleter.createDialog();
			ModelCompleterManager mcm = new ModelCompleterManager(ProjectBrowser.frame.getProjectBrowser().getParser(), mcw, x, y);

			mcm.runAnalysis();
			if(mcw.isEmpty()){
				mcw.showMessageBox();
				return;
			}

			mcw.open();

			if(mcw.wasClosed())
				return;

			Fix fix = mcw.getFix();
			diagramManager.updateMenthor(fix);

			_runModelCompleter(diagramManager, x, y);
		}catch(Exception e){
			//do not show the stacktrace, everything is ok...
			e.printStackTrace();
		}
	}

	private static void _runModelCompleter(final DiagramManager diagramManager,final double x, final double y, boolean showCompleteMessage) {
		try{
			ModelCompleter mcw = ModelCompleter.createDialog(showCompleteMessage);
			ModelCompleterManager mcm = new ModelCompleterManager(ProjectBrowser.frame.getProjectBrowser().getParser(), mcw, x, y);

			mcm.runAnalysis();
			if(mcw.isEmpty())
				return;

			mcw.open();

			if(mcw.wasClosed())
				return;

			Fix fix = mcw.getFix();
			diagramManager.updateMenthor(fix);

			_runModelCompleter(diagramManager, x, y, showCompleteMessage);
		}catch(Exception e){
			//do not show the stacktrace, everything is ok...
			e.printStackTrace();
		}
	}

	public static void runPattern(final DiagramManager diagramManager,final ElementType elementType, final double x, final double y) {
		if(Main.onMac()){
			com.apple.concurrent.Dispatch.getInstance().getNonBlockingMainQueueExecutor().execute( new Runnable(){        	
				@Override
				public void run() {
					PatternTool.tryToRun(diagramManager, elementType, x, y);					
				}
			});
		}else{
			Display.getDefault().syncExec(new Runnable(){
			       public void run(){
					PatternTool.tryToRun(diagramManager, elementType, x, y);					
				}
			});						
		}
	}
	
	/*
	 * Called when triggered by a new class.
	 * The ModelCompleter feature is ON 
	 * */
	public static void runModelCompleter(final DiagramManager diagramManager, final Classifier elem, final double x, final double y) {
		//Needs to rename the class
		diagramManager.renameElement(elem);

		if(Main.onMac()){
			com.apple.concurrent.Dispatch.getInstance().getNonBlockingMainQueueExecutor().execute( new Runnable(){        	
				@Override
				public void run() {
					_runModelCompleter(diagramManager, x, y-75.0,false);
				}
			});
		}else{
			_runModelCompleter(diagramManager, x, y-75.0,false);			
		}
	} 
}