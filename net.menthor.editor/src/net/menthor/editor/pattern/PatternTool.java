package net.menthor.editor.pattern;

import org.eclipse.swt.widgets.Display;

import RefOntoUML.Classifier;
import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.editor.ui.DiagramManager;
import net.menthor.editor.ui.MenthorEditor;
import net.menthor.editor.ui.Models;
import net.menthor.editor.v2.managers.UpdateManager;
import net.menthor.editor.v2.types.PatternType;
import net.menthor.editor.v2.util.Util;
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

/**
 * @author Victor Amorim
 */
public class PatternTool {
	@SuppressWarnings("incomplete-switch")
	private static Fix tryToRun(DiagramManager diagramManager, PatternType elem,double x,double y){
		AbstractPattern pm = null;

		switch (elem) {
		case MIXIN:
			pm = new MixinPattern(Models.getRefparser(), x, y); 
			break;
		case MIXIN_WITH_SUBKIND:
			pm = new MixinPatternWithSubkind(Models.getRefparser(), x, y);
			break;
		case PHASE_PARTITION:
			pm = new PhasePartition(Models.getRefparser(), x, y);
			break;
		case RELATOR:
			pm = new RelatorPattern(Models.getRefparser(), x, y);
			break;
		case ROLEMIXIN:
			pm = new RoleMixinPattern(Models.getRefparser(), x, y);
			break;
		case ROLE_PARTITION:
			pm = new RolePartition(Models.getRefparser(), x, y);
			break;
		case SUBKIND_PARTITION:
			pm = new SubkindPartition(Models.getRefparser(), x, y);
			break;
		case KIND_PARTITION:
			pm = new KindPartition(Models.getRefparser(), x, y);
			break;
		case COLLECTIVE_PARTITION:
			pm = new CollectivePartition(Models.getRefparser(), x, y);
			break;
		case QUANTITY_PARTITION:
			pm = new QuantityPartition(Models.getRefparser(), x, y);
			break;
		case CATEGORY:
			pm = new CategoryPattern(Models.getRefparser(), x, y);
			break;
		case DEPENDENT_ROLEMIXIN:
			pm = new RoleMixinDependentPattern(Models.getRefparser(), x, y);
			break;
		case GENERIC_RELATOR:
			pm = new GenericMultipleRelator(Models.getRefparser(), x, y);
			break;
		case CHARACTERIZATION:
			pm = new CharacterizationPattern(Models.getRefparser(), x, y);
			break;
		case RIGID_WEAK_SUPPLEMENTATION:
			pm = new RigidWeakSupplementation(Models.getRefparser(), x, y);
			break;
		case ANTIRIGID_WEAK_SUPPLEMENTATION:
			pm = new AntiRigidWeakSupplementation(Models.getRefparser(), x, y);
			break;
		}

		Fix fix = null;
		if(pm != null){
			pm.runPattern();
			if(pm.canGetFix()){
				fix = pm.getFix();
				UpdateManager.get().update(fix);
				_runModelCompleter(diagramManager, x, y,false);
			}
		}else{
			if(elem == PatternType.COMPLETER)
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
			ModelCompleterManager mcm = new ModelCompleterManager(Models.getRefparser(), mcw, x, y);

			mcm.runAnalysis();
			if(mcw.isEmpty()){
				mcw.showMessageBox();
				return;
			}

			mcw.open();

			if(mcw.wasClosed())
				return;

			Fix fix = mcw.getFix();
			UpdateManager.get().update(fix);

			_runModelCompleter(diagramManager, x, y);
		}catch(Exception e){
			//do not show the stacktrace, everything is ok...
			e.printStackTrace();
		}
	}

	private static void _runModelCompleter(final DiagramManager diagramManager,final double x, final double y, boolean showCompleteMessage) {
		try{
			ModelCompleter mcw = ModelCompleter.createDialog(showCompleteMessage);
			ModelCompleterManager mcm = new ModelCompleterManager(Models.getRefparser(), mcw, x, y);

			mcm.runAnalysis();
			if(mcw.isEmpty())
				return;

			mcw.open();

			if(mcw.wasClosed())
				return;

			Fix fix = mcw.getFix();
			UpdateManager.get().update(fix);

			_runModelCompleter(diagramManager, x, y, showCompleteMessage);
		}catch(Exception e){
			//do not show the stacktrace, everything is ok...
			e.printStackTrace();
		}
	}

	public static void runPattern(final DiagramManager diagramManager,final PatternType elementType, final double x, final double y) {
		if(Util.onMac()){
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

		if(Util.onMac()){
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