/**
 */
package stories.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import RefOntoUML.parser.OntoUMLParser;
import stories.Node;
import stories.Classification_statement;
import stories.StoriesPackage;
import stories.World;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node state</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link stories.impl.Classification_statementImpl#getHolds_in <em>Holds in</em>}</li>
 *   <li>{@link stories.impl.Classification_statementImpl#getNot_holds_in <em>Not holds in</em>}</li>
 *   <li>{@link stories.impl.Classification_statementImpl#getAntiRigidClasses <em>Anti Rigid Classes</em>}</li>
 *   <li>{@link stories.impl.Classification_statementImpl#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Classification_statementImpl extends MinimalEObjectImpl.Container implements Classification_statement {
	/**
	 * The cached value of the '{@link #getHolds_in() <em>Holds in</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHolds_in()
	 * @generated
	 * @ordered
	 */
	protected EList<World> holds_in;

	/**
	 * The cached value of the '{@link #getNot_holds_in() <em>Not holds in</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNot_holds_in()
	 * @generated
	 * @ordered
	 */
	protected EList<World> not_holds_in;

	/**
	 * The cached value of the '{@link #getAntiRigidClasses() <em>Anti Rigid Classes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAntiRigidClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<RefOntoUML.Class> antiRigidClasses;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Classification_statementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoriesPackage.Literals.CLASSIFICATION_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<World> getHolds_in() {
		if (holds_in == null) {
			holds_in = new EObjectResolvingEList<World>(World.class, this, StoriesPackage.CLASSIFICATION_STATEMENT__HOLDS_IN);
		}
		return holds_in;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<World> getNot_holds_in() {
		if (not_holds_in == null) {
			not_holds_in = new EObjectResolvingEList<World>(World.class, this, StoriesPackage.CLASSIFICATION_STATEMENT__NOT_HOLDS_IN);
		}
		return not_holds_in;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RefOntoUML.Class> getAntiRigidClasses() {
		if (antiRigidClasses == null) {
			antiRigidClasses = new EObjectResolvingEList<RefOntoUML.Class>(RefOntoUML.Class.class, this, StoriesPackage.CLASSIFICATION_STATEMENT__ANTI_RIGID_CLASSES);
		}
		return antiRigidClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoriesPackage.CLASSIFICATION_STATEMENT__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StoriesPackage.CLASSIFICATION_STATEMENT__HOLDS_IN:
				return getHolds_in();
			case StoriesPackage.CLASSIFICATION_STATEMENT__NOT_HOLDS_IN:
				return getNot_holds_in();
			case StoriesPackage.CLASSIFICATION_STATEMENT__ANTI_RIGID_CLASSES:
				return getAntiRigidClasses();
			case StoriesPackage.CLASSIFICATION_STATEMENT__LABEL:
				return getLabel();
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
			case StoriesPackage.CLASSIFICATION_STATEMENT__HOLDS_IN:
				getHolds_in().clear();
				getHolds_in().addAll((Collection<? extends World>)newValue);
				return;
			case StoriesPackage.CLASSIFICATION_STATEMENT__NOT_HOLDS_IN:
				getNot_holds_in().clear();
				getNot_holds_in().addAll((Collection<? extends World>)newValue);
				return;
			case StoriesPackage.CLASSIFICATION_STATEMENT__ANTI_RIGID_CLASSES:
				getAntiRigidClasses().clear();
				getAntiRigidClasses().addAll((Collection<? extends RefOntoUML.Class>)newValue);
				return;
			case StoriesPackage.CLASSIFICATION_STATEMENT__LABEL:
				setLabel((String)newValue);
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
			case StoriesPackage.CLASSIFICATION_STATEMENT__HOLDS_IN:
				getHolds_in().clear();
				return;
			case StoriesPackage.CLASSIFICATION_STATEMENT__NOT_HOLDS_IN:
				getNot_holds_in().clear();
				return;
			case StoriesPackage.CLASSIFICATION_STATEMENT__ANTI_RIGID_CLASSES:
				getAntiRigidClasses().clear();
				return;
			case StoriesPackage.CLASSIFICATION_STATEMENT__LABEL:
				setLabel(LABEL_EDEFAULT);
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
			case StoriesPackage.CLASSIFICATION_STATEMENT__HOLDS_IN:
				return holds_in != null && !holds_in.isEmpty();
			case StoriesPackage.CLASSIFICATION_STATEMENT__NOT_HOLDS_IN:
				return not_holds_in != null && !not_holds_in.isEmpty();
			case StoriesPackage.CLASSIFICATION_STATEMENT__ANTI_RIGID_CLASSES:
				return antiRigidClasses != null && !antiRigidClasses.isEmpty();
			case StoriesPackage.CLASSIFICATION_STATEMENT__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (label: ");
		result.append(label);
		result.append(')');
		return result.toString();
	}

	private String isClassifiedIn(Node n, RefOntoUML.Class c, World w, OntoUMLParser modelParser){
		System.out.println(c);
		return '\t'+ n.getLabel()+" in "+w.getLabel()+"."+modelParser.getAlias(c)+'\n';
	}
	@Override
	public String existance(Node target,OntoUMLParser modelParser) {
		String existance = "";
		for( World w: this.getHolds_in()){
			for(RefOntoUML.Class c : this.getAntiRigidClasses()){
				existance = existance+ this.isClassifiedIn(target,c,w, modelParser);
			}
		}
		for( World w: this.getNot_holds_in()){
			for(RefOntoUML.Class c : this.getAntiRigidClasses()){
				existance = existance+ "not "+this.isClassifiedIn(target,c,w, modelParser);
			}
		}
		return existance;
	}

} //Classification_statementImpl
