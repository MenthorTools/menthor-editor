/**
 */
package stories.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;


import stories.Action;
import stories.Node;
import stories.Classification_statement;
import stories.StoriesPackage;
import stories.World;
import net.menthor.story.ui.StoryElementTimeline;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link stories.impl.NodeImpl#getPerformed <em>Performed</em>}</li>
 *   <li>{@link stories.impl.NodeImpl#getInstance_of <em>Instance of</em>}</li>
 *   <li>{@link stories.impl.NodeImpl#getIs_referred_to_in <em>Is referred to in</em>}</li>
 *   <li>{@link stories.impl.NodeImpl#getNot_instance_of <em>Not instance of</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeImpl extends IndividualImpl implements Node {
	protected static final String LABEL_EDEFAULT = "Node";
	/**
	 * The cached value of the '{@link #getPerformed() <em>Performed</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerformed()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> performed;

	/**
	 * The cached value of the '{@link #getInstance_of() <em>Instance of</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstance_of()
	 * @generated
	 * @ordered
	 */
	protected EList<RefOntoUML.Class> instance_of;

	/**
	 * The cached value of the '{@link #getIs_referred_to_in() <em>Is referred to in</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIs_referred_to_in()
	 * @generated
	 * @ordered
	 */
	protected EList<Classification_statement> is_referred_to_in;
	/**
	 * The cached value of the '{@link #getNot_instance_of() <em>Not instance of</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNot_instance_of()
	 * @generated
	 * @ordered
	 */
	protected EList<RefOntoUML.Class> not_instance_of;
	private StoryElementTimeline storyElTl = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}
	
	public void setSETL(StoryElementTimeline stl){
		this.storyElTl = stl;
	}

	@Override
	protected String getDefaultLabel() {
		
		return NodeImpl.LABEL_EDEFAULT;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoriesPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getPerformed() {
		if (performed == null) {
			performed = new EObjectContainmentWithInverseEList<Action>(Action.class, this, StoriesPackage.NODE__PERFORMED, StoriesPackage.ACTION__PERFORMED_BY);
		}
		return performed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RefOntoUML.Class> getInstance_of() {
		if (instance_of == null) {
			instance_of = new EObjectResolvingEList<RefOntoUML.Class>(RefOntoUML.Class.class, this, StoriesPackage.NODE__INSTANCE_OF);
		}
		return instance_of;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classification_statement> getIs_referred_to_in() {
		if (is_referred_to_in == null) {
			is_referred_to_in = new EObjectContainmentEList<Classification_statement>(Classification_statement.class, this, StoriesPackage.NODE__IS_REFERRED_TO_IN);
		}
		return is_referred_to_in;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RefOntoUML.Class> getNot_instance_of() {
		if (not_instance_of == null) {
			not_instance_of = new EObjectResolvingEList<RefOntoUML.Class>(RefOntoUML.Class.class, this, StoriesPackage.NODE__NOT_INSTANCE_OF);
		}
		return not_instance_of;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StoriesPackage.NODE__PERFORMED:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPerformed()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StoriesPackage.NODE__PERFORMED:
				return ((InternalEList<?>)getPerformed()).basicRemove(otherEnd, msgs);
			case StoriesPackage.NODE__IS_REFERRED_TO_IN:
				return ((InternalEList<?>)getIs_referred_to_in()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StoriesPackage.NODE__PERFORMED:
				return getPerformed();
			case StoriesPackage.NODE__INSTANCE_OF:
				return getInstance_of();
			case StoriesPackage.NODE__IS_REFERRED_TO_IN:
				return getIs_referred_to_in();
			case StoriesPackage.NODE__NOT_INSTANCE_OF:
				return getNot_instance_of();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StoriesPackage.NODE__PERFORMED:
				getPerformed().clear();
				getPerformed().addAll((Collection<? extends Action>)newValue);
				return;
			case StoriesPackage.NODE__INSTANCE_OF:
				getInstance_of().clear();
				getInstance_of().addAll((Collection<? extends RefOntoUML.Class>)newValue);
				return;
			case StoriesPackage.NODE__IS_REFERRED_TO_IN:
				getIs_referred_to_in().clear();
				getIs_referred_to_in().addAll((Collection<? extends Classification_statement>)newValue);
				return;
			case StoriesPackage.NODE__NOT_INSTANCE_OF:
				getNot_instance_of().clear();
				getNot_instance_of().addAll((Collection<? extends RefOntoUML.Class>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StoriesPackage.NODE__PERFORMED:
				getPerformed().clear();
				return;
			case StoriesPackage.NODE__INSTANCE_OF:
				getInstance_of().clear();
				return;
			case StoriesPackage.NODE__IS_REFERRED_TO_IN:
				getIs_referred_to_in().clear();
				return;
			case StoriesPackage.NODE__NOT_INSTANCE_OF:
				getNot_instance_of().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StoriesPackage.NODE__PERFORMED:
				return performed != null && !performed.isEmpty();
			case StoriesPackage.NODE__INSTANCE_OF:
				return instance_of != null && !instance_of.isEmpty();
			case StoriesPackage.NODE__IS_REFERRED_TO_IN:
				return is_referred_to_in != null && !is_referred_to_in.isEmpty();
			case StoriesPackage.NODE__NOT_INSTANCE_OF:
				return not_instance_of != null && !not_instance_of.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	public String static_classification(){
		String rule = "";
		for(RefOntoUML.Class c : this.getInstance_of()){
			rule = rule + '\t'+ this.getLabel() + " in World." +c.getName()+'\n';
		}
		return  rule;
	}
	

	
	public String existance(){
		String exists ="";
		for(World w : this.getPresent_in()){
			exists = exists+'\t'+this.getLabel()+" in "+w.getLabel()+".exists" +'\n';
		}
		for(World w : this.getAbsent_from()){
			exists = exists+'\t'+this.getLabel()+" not in "+w.getLabel()+".exists" +'\n';
		}
		return exists;
	}

	@Override
	public String is_referred_to_in() {
		String states ="";
		for(Classification_statement ns: this.getIs_referred_to_in()){
			states = states + ns.existance(this);
		}
		return states;
	}

	public StoryElementTimeline getStoryElementTimeline() {
		return storyElTl;
	}

	public void getStoryElementTimeline(StoryElementTimeline storyElTl) {
		this.storyElTl = storyElTl;
	}
	
	
} //NodeImpl
