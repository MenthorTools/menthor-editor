/**
 */
package net.menthor.metamodel.ontouml.impl;

import net.menthor.metamodel.ontouml.ComplexDataType;
import net.menthor.metamodel.ontouml.DataType;
import net.menthor.metamodel.ontouml.DataTypeAttribute;
import net.menthor.metamodel.ontouml.OntoumlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.DataTypeAttributeImpl#getIsOfType <em>Is Of Type</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.DataTypeAttributeImpl#getComplexDataType <em>Complex Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataTypeAttributeImpl extends NamedElementImpl implements DataTypeAttribute {
	/**
	 * The cached value of the '{@link #getIsOfType() <em>Is Of Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsOfType()
	 * @generated
	 * @ordered
	 */
	protected DataType isOfType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OntoumlPackage.Literals.DATA_TYPE_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getIsOfType() {
		if (isOfType != null && isOfType.eIsProxy()) {
			InternalEObject oldIsOfType = (InternalEObject)isOfType;
			isOfType = (DataType)eResolveProxy(oldIsOfType);
			if (isOfType != oldIsOfType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.DATA_TYPE_ATTRIBUTE__IS_OF_TYPE, oldIsOfType, isOfType));
			}
		}
		return isOfType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetIsOfType() {
		return isOfType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsOfType(DataType newIsOfType) {
		DataType oldIsOfType = isOfType;
		isOfType = newIsOfType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.DATA_TYPE_ATTRIBUTE__IS_OF_TYPE, oldIsOfType, isOfType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexDataType getComplexDataType() {
		if (eContainerFeatureID() != OntoumlPackage.DATA_TYPE_ATTRIBUTE__COMPLEX_DATA_TYPE) return null;
		return (ComplexDataType)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexDataType basicGetComplexDataType() {
		if (eContainerFeatureID() != OntoumlPackage.DATA_TYPE_ATTRIBUTE__COMPLEX_DATA_TYPE) return null;
		return (ComplexDataType)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComplexDataType(ComplexDataType newComplexDataType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newComplexDataType, OntoumlPackage.DATA_TYPE_ATTRIBUTE__COMPLEX_DATA_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComplexDataType(ComplexDataType newComplexDataType) {
		if (newComplexDataType != eInternalContainer() || (eContainerFeatureID() != OntoumlPackage.DATA_TYPE_ATTRIBUTE__COMPLEX_DATA_TYPE && newComplexDataType != null)) {
			if (EcoreUtil.isAncestor(this, newComplexDataType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newComplexDataType != null)
				msgs = ((InternalEObject)newComplexDataType).eInverseAdd(this, OntoumlPackage.COMPLEX_DATA_TYPE__ATTRIBUTES, ComplexDataType.class, msgs);
			msgs = basicSetComplexDataType(newComplexDataType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.DATA_TYPE_ATTRIBUTE__COMPLEX_DATA_TYPE, newComplexDataType, newComplexDataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OntoumlPackage.DATA_TYPE_ATTRIBUTE__COMPLEX_DATA_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetComplexDataType((ComplexDataType)otherEnd, msgs);
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
			case OntoumlPackage.DATA_TYPE_ATTRIBUTE__COMPLEX_DATA_TYPE:
				return basicSetComplexDataType(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case OntoumlPackage.DATA_TYPE_ATTRIBUTE__COMPLEX_DATA_TYPE:
				return eInternalContainer().eInverseRemove(this, OntoumlPackage.COMPLEX_DATA_TYPE__ATTRIBUTES, ComplexDataType.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OntoumlPackage.DATA_TYPE_ATTRIBUTE__IS_OF_TYPE:
				if (resolve) return getIsOfType();
				return basicGetIsOfType();
			case OntoumlPackage.DATA_TYPE_ATTRIBUTE__COMPLEX_DATA_TYPE:
				if (resolve) return getComplexDataType();
				return basicGetComplexDataType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OntoumlPackage.DATA_TYPE_ATTRIBUTE__IS_OF_TYPE:
				setIsOfType((DataType)newValue);
				return;
			case OntoumlPackage.DATA_TYPE_ATTRIBUTE__COMPLEX_DATA_TYPE:
				setComplexDataType((ComplexDataType)newValue);
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
			case OntoumlPackage.DATA_TYPE_ATTRIBUTE__IS_OF_TYPE:
				setIsOfType((DataType)null);
				return;
			case OntoumlPackage.DATA_TYPE_ATTRIBUTE__COMPLEX_DATA_TYPE:
				setComplexDataType((ComplexDataType)null);
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
			case OntoumlPackage.DATA_TYPE_ATTRIBUTE__IS_OF_TYPE:
				return isOfType != null;
			case OntoumlPackage.DATA_TYPE_ATTRIBUTE__COMPLEX_DATA_TYPE:
				return basicGetComplexDataType() != null;
		}
		return super.eIsSet(featureID);
	}

} //DataTypeAttributeImpl
