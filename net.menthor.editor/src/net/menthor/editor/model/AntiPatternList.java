/**
 * Copyright(C) 2011-2014 by John Guerson, Tiago Prince, Antognoni Albuquerque
 *
 * This file is part of OLED (OntoUML Lightweight BaseEditor).
 * OLED is based on TinyUML and so is distributed under the same
 * license terms.
 *
 * OLED is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * OLED is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OLED; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package net.menthor.editor.model;

import java.util.ArrayList;

import net.menthor.antipattern.AntipatternOccurrence;
import net.menthor.antipattern.GSRig.GSRigAntipattern;
import net.menthor.antipattern.asscyc.AssCycAntipattern;
import net.menthor.antipattern.binover.BinOverAntipattern;
import net.menthor.antipattern.decint.DecIntAntipattern;
import net.menthor.antipattern.depphase.DepPhaseAntipattern;
import net.menthor.antipattern.freerole.FreeRoleAntipattern;
import net.menthor.antipattern.hetcoll.HetCollAntipattern;
import net.menthor.antipattern.homofunc.HomoFuncAntipattern;
import net.menthor.antipattern.impabs.ImpAbsAntipattern;
import net.menthor.antipattern.mixiden.MixIdenAntipattern;
import net.menthor.antipattern.mixrig.MixRigAntipattern;
import net.menthor.antipattern.multidep.MultiDepAntipattern;
import net.menthor.antipattern.partover.PartOverAntipattern;
import net.menthor.antipattern.relcomp.RelCompAntipattern;
import net.menthor.antipattern.relover.RelOverAntipattern;
import net.menthor.antipattern.relrig.RelRigAntipattern;
import net.menthor.antipattern.relspec.RelSpecAntipattern;
import net.menthor.antipattern.reprel.RepRelAntipattern;
import net.menthor.antipattern.undefformal.UndefFormalAntipattern;
import net.menthor.antipattern.undefphase.UndefPhaseAntipattern;
import net.menthor.antipattern.wholeover.WholeOverAntipattern;

/**
 * 
 * This class represents a AntiPattern List Model.
 * 
 * @author John Guerson
 */

public class AntiPatternList {
	
	private AssCycAntipattern assCyc; 	
	private BinOverAntipattern binOver;		
	private DepPhaseAntipattern depPhase;
	private FreeRoleAntipattern freeRole;
	private GSRigAntipattern gsRig;
	private HetCollAntipattern hetColl;
	private HomoFuncAntipattern homoFunc;
	private ImpAbsAntipattern impAbs;
	private MixIdenAntipattern mixIden;
	private MixRigAntipattern mixRig;
	private MultiDepAntipattern multiDep;
	private RelCompAntipattern relComp;
	private RelOverAntipattern relOver;
	private RelRigAntipattern relRig;
	private RelSpecAntipattern relSpec;
	private RepRelAntipattern repRel;
	private UndefFormalAntipattern undefFormal;
	private UndefPhaseAntipattern undefPhase;
	private WholeOverAntipattern wholeOver;
	private PartOverAntipattern partOver;
	private DecIntAntipattern decInt;
	
	public AssCycAntipattern getAssCyc() {
		return assCyc;
	}
	public AntiPatternList(AssCycAntipattern assCyc,
			BinOverAntipattern binOver, DepPhaseAntipattern depPhase, FreeRoleAntipattern freeRole, GSRigAntipattern gsRig,
			HetCollAntipattern hetColl, HomoFuncAntipattern homoFunc, ImpAbsAntipattern impAbs,
			MixIdenAntipattern mixIden, MixRigAntipattern mixRig, MultiDepAntipattern multiDep, RelCompAntipattern relComp,
			RelOverAntipattern relOver, RelRigAntipattern relRig, RelSpecAntipattern relSpec, RepRelAntipattern repRel,
			UndefFormalAntipattern undefFormal, UndefPhaseAntipattern undefPhase, WholeOverAntipattern wholeOver,
			PartOverAntipattern partOver, DecIntAntipattern decInt) {

		this.assCyc = assCyc;
		this.binOver = binOver;
		this.depPhase = depPhase;
		this.freeRole = freeRole;
		this.gsRig = gsRig;
		this.hetColl = hetColl;
		this.homoFunc = homoFunc;
		this.impAbs = impAbs;
		this.mixIden = mixIden;
		this.mixRig = mixRig;
		this.multiDep = multiDep;
		this.relComp = relComp;
		this.relOver = relOver;
		this.relRig = relRig;
		this.relSpec = relSpec;
		this.repRel = repRel;
		this.undefFormal = undefFormal;
		this.undefPhase = undefPhase;
		this.wholeOver = wholeOver;
		this.partOver = partOver;
		this.decInt = decInt;
	}
	
	public AntiPatternList() {

	}
	
	public ArrayList<AntipatternOccurrence> getAll()
	{
		ArrayList<AntipatternOccurrence> result = new ArrayList<AntipatternOccurrence>();
		result.addAll(assCyc.getOccurrences());
		result.addAll(binOver.getOccurrences());
		result.addAll(depPhase.getOccurrences());
		result.addAll(freeRole.getOccurrences());
		result.addAll(gsRig.getOccurrences());
		result.addAll(hetColl.getOccurrences());
		result.addAll(homoFunc.getOccurrences());
		result.addAll(impAbs.getOccurrences());
		result.addAll(mixIden.getOccurrences());
		result.addAll(mixRig.getOccurrences());
		result.addAll(multiDep.getOccurrences());
		result.addAll(relComp.getOccurrences());
		result.addAll(relOver.getOccurrences());
		result.addAll(relRig.getOccurrences());
		result.addAll(relSpec.getOccurrences());
		result.addAll(repRel.getOccurrences());
		result.addAll(undefFormal.getOccurrences());
		result.addAll(undefPhase.getOccurrences());
		result.addAll(wholeOver.getOccurrences());
		result.addAll(partOver.getOccurrences());
		result.addAll(decInt.getOccurrences());
		return result;
	}
	
	public PartOverAntipattern getPartOver() {
		return partOver;
	}
	public void setPartOver(PartOverAntipattern partOver) {
		this.partOver = partOver;
	}
	public DecIntAntipattern getDecInt() {
		return decInt;
	}
	public void setDecInt(DecIntAntipattern decInt) {
		this.decInt = decInt;
	}
	public void setAssCyc(AssCycAntipattern assCyc) {
		this.assCyc = assCyc;
	}
	
	public BinOverAntipattern getBinOver() {
		return binOver;
	}
	public void setBinOver(BinOverAntipattern binOver) {
		this.binOver = binOver;
	}
	public DepPhaseAntipattern getDepPhase() {
		return depPhase;
	}
	public void setDepPhase(DepPhaseAntipattern depPhase) {
		this.depPhase = depPhase;
	}
	public FreeRoleAntipattern getFreeRole() {
		return freeRole;
	}
	public void setFreeRole(FreeRoleAntipattern freeRole) {
		this.freeRole = freeRole;
	}
	public GSRigAntipattern getGsRig() {
		return gsRig;
	}
	public void setGsRig(GSRigAntipattern gsRig) {
		this.gsRig = gsRig;
	}
	public HetCollAntipattern getHetColl() {
		return hetColl;
	}
	public void setHetColl(HetCollAntipattern hetColl) {
		this.hetColl = hetColl;
	}
	public HomoFuncAntipattern getHomoFunc() {
		return homoFunc;
	}
	public void setHomoFunc(HomoFuncAntipattern homoFunc) {
		this.homoFunc = homoFunc;
	}
	public ImpAbsAntipattern getImpAbs() {
		return impAbs;
	}
	public void setImpAbs(ImpAbsAntipattern impAbs) {
		this.impAbs = impAbs;
	}
	
	public MixIdenAntipattern getMixIden() {
		return mixIden;
	}
	public void setMixIden(MixIdenAntipattern mixIden) {
		this.mixIden = mixIden;
	}
	public MixRigAntipattern getMixRig() {
		return mixRig;
	}
	public void setMixRig(MixRigAntipattern mixRig) {
		this.mixRig = mixRig;
	}
	public MultiDepAntipattern getMultiDep() {
		return multiDep;
	}
	public void setMultiDep(MultiDepAntipattern multiDep) {
		this.multiDep = multiDep;
	}
	public RelCompAntipattern getRelComp() {
		return relComp;
	}
	public void setRelComp(RelCompAntipattern relComp) {
		this.relComp = relComp;
	}
	public RelOverAntipattern getRelOver() {
		return relOver;
	}
	public void setRelOver(RelOverAntipattern relOver) {
		this.relOver = relOver;
	}
	public RelRigAntipattern getRelRig() {
		return relRig;
	}
	public void setRelRig(RelRigAntipattern relRig) {
		this.relRig = relRig;
	}
	public RelSpecAntipattern getRelSpec() {
		return relSpec;
	}
	public void setRelSpec(RelSpecAntipattern relSpec) {
		this.relSpec = relSpec;
	}
	public RepRelAntipattern getRepRel() {
		return repRel;
	}
	public void setRepRel(RepRelAntipattern repRel) {
		this.repRel = repRel;
	}
	public UndefFormalAntipattern getUndefFormal() {
		return undefFormal;
	}
	public void setUndefFormal(UndefFormalAntipattern undefFormal) {
		this.undefFormal = undefFormal;
	}
	public UndefPhaseAntipattern getUndefPhase() {
		return undefPhase;
	}
	public void setUndefPhase(UndefPhaseAntipattern undefPhase) {
		this.undefPhase = undefPhase;
	}
	public WholeOverAntipattern getWholeOver() {
		return wholeOver;
	}
	public void setWholeOver(WholeOverAntipattern wholeOver) {
		this.wholeOver = wholeOver;
	}
	
	
	
}
