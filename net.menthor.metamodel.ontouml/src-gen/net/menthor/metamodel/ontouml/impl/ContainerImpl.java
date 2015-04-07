/**
 */
package net.menthor.metamodel.ontouml.impl;

import java.lang.Iterable;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.List;

import net.menthor.metamodel.ontouml.ContainedElement;
import net.menthor.metamodel.ontouml.GeneralizationSet;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Relationship;
import net.menthor.metamodel.ontouml.Structure;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ContainerImpl#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ContainerImpl extends NamedElementImpl implements net.menthor.metamodel.ontouml.Container {
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ContainedElement> elements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OntoumlPackage.Literals.CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ContainedElement> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentWithInverseEList<ContainedElement>(ContainedElement.class, this, OntoumlPackage.CONTAINER__ELEMENTS, OntoumlPackage.CONTAINED_ELEMENT__HOLDER);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<net.menthor.metamodel.ontouml.Package> packages() {
		net.menthor.metamodel.ontouml.Package[] result = null;
		EList<ContainedElement> _elements = this.getElements();
		for (final ContainedElement e : _elements) {
			if ((e instanceof net.menthor.metamodel.ontouml.Package)) {
				final net.menthor.metamodel.ontouml.Package[] _converted_result = (net.menthor.metamodel.ontouml.Package[])result;
				((List<net.menthor.metamodel.ontouml.Package>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(((net.menthor.metamodel.ontouml.Package)e));
			}
		}
		final net.menthor.metamodel.ontouml.Package[] _converted_result_1 = (net.menthor.metamodel.ontouml.Package[])result;
		return ECollections.<net.menthor.metamodel.ontouml.Package>toEList(((Iterable<? extends net.menthor.metamodel.ontouml.Package>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void allPackages(final net.menthor.metamodel.ontouml.Container c, final EList<net.menthor.metamodel.ontouml.Package> result) {
		EList<ContainedElement> _elements = this.getElements();
		for (final ContainedElement e : _elements) {
			if ((e instanceof net.menthor.metamodel.ontouml.Package)) {
				result.add(((net.menthor.metamodel.ontouml.Package)e));
				this.allPackages(((net.menthor.metamodel.ontouml.Container)e), result);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<net.menthor.metamodel.ontouml.Package> allPackages() {
		net.menthor.metamodel.ontouml.Package[] result = null;
		final net.menthor.metamodel.ontouml.Package[] _converted_result = (net.menthor.metamodel.ontouml.Package[])result;
		EList<net.menthor.metamodel.ontouml.Package> _eList = ECollections.<net.menthor.metamodel.ontouml.Package>toEList(((Iterable<? extends net.menthor.metamodel.ontouml.Package>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)));
		this.allPackages(this, _eList);
		final net.menthor.metamodel.ontouml.Package[] _converted_result_1 = (net.menthor.metamodel.ontouml.Package[])result;
		return ECollections.<net.menthor.metamodel.ontouml.Package>toEList(((Iterable<? extends net.menthor.metamodel.ontouml.Package>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Relationship> relationships() {
		Relationship[] result = null;
		EList<ContainedElement> _elements = this.getElements();
		for (final ContainedElement e : _elements) {
			if ((e instanceof Relationship)) {
				final Relationship[] _converted_result = (Relationship[])result;
				((List<Relationship>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(((Relationship)e));
			}
		}
		final Relationship[] _converted_result_1 = (Relationship[])result;
		return ECollections.<Relationship>toEList(((Iterable<? extends Relationship>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void allRelationships(final net.menthor.metamodel.ontouml.Container c, final EList<Relationship> result) {
		EList<ContainedElement> _elements = this.getElements();
		for (final ContainedElement e : _elements) {
			{
				if ((e instanceof Relationship)) {
					result.add(((Relationship)e));
				}
				if ((e instanceof net.menthor.metamodel.ontouml.Package)) {
					this.allRelationships(((net.menthor.metamodel.ontouml.Container)e), result);
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Relationship> allRelationships() {
		Relationship[] result = null;
		final Relationship[] _converted_result = (Relationship[])result;
		EList<Relationship> _eList = ECollections.<Relationship>toEList(((Iterable<? extends Relationship>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)));
		this.allRelationships(this, _eList);
		final Relationship[] _converted_result_1 = (Relationship[])result;
		return ECollections.<Relationship>toEList(((Iterable<? extends Relationship>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GeneralizationSet> generalizationSets() {
		GeneralizationSet[] result = null;
		EList<ContainedElement> _elements = this.getElements();
		for (final ContainedElement e : _elements) {
			if ((e instanceof GeneralizationSet)) {
				final GeneralizationSet[] _converted_result = (GeneralizationSet[])result;
				((List<GeneralizationSet>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(((GeneralizationSet)e));
			}
		}
		final GeneralizationSet[] _converted_result_1 = (GeneralizationSet[])result;
		return ECollections.<GeneralizationSet>toEList(((Iterable<? extends GeneralizationSet>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void allGeneralizationSets(final net.menthor.metamodel.ontouml.Container c, final EList<GeneralizationSet> result) {
		EList<ContainedElement> _elements = this.getElements();
		for (final ContainedElement e : _elements) {
			{
				if ((e instanceof GeneralizationSet)) {
					result.add(((GeneralizationSet)e));
				}
				if ((e instanceof net.menthor.metamodel.ontouml.Package)) {
					this.allGeneralizationSets(((net.menthor.metamodel.ontouml.Container)e), result);
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GeneralizationSet> allGeneralizationSets() {
		GeneralizationSet[] result = null;
		final GeneralizationSet[] _converted_result = (GeneralizationSet[])result;
		EList<GeneralizationSet> _eList = ECollections.<GeneralizationSet>toEList(((Iterable<? extends GeneralizationSet>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)));
		this.allGeneralizationSets(this, _eList);
		final GeneralizationSet[] _converted_result_1 = (GeneralizationSet[])result;
		return ECollections.<GeneralizationSet>toEList(((Iterable<? extends GeneralizationSet>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<net.menthor.metamodel.ontouml.Class> classes() {
		net.menthor.metamodel.ontouml.Class[] result = null;
		EList<ContainedElement> _elements = this.getElements();
		for (final ContainedElement e : _elements) {
			if ((e instanceof net.menthor.metamodel.ontouml.Class)) {
				final net.menthor.metamodel.ontouml.Class[] _converted_result = (net.menthor.metamodel.ontouml.Class[])result;
				((List<net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(((net.menthor.metamodel.ontouml.Class)e));
			}
		}
		final net.menthor.metamodel.ontouml.Class[] _converted_result_1 = (net.menthor.metamodel.ontouml.Class[])result;
		return ECollections.<net.menthor.metamodel.ontouml.Class>toEList(((Iterable<? extends net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void allClasses(final net.menthor.metamodel.ontouml.Container c, final EList<net.menthor.metamodel.ontouml.Class> result) {
		EList<ContainedElement> _elements = this.getElements();
		for (final ContainedElement e : _elements) {
			{
				if ((e instanceof net.menthor.metamodel.ontouml.Class)) {
					result.add(((net.menthor.metamodel.ontouml.Class)e));
				}
				if ((e instanceof net.menthor.metamodel.ontouml.Package)) {
					this.allClasses(((net.menthor.metamodel.ontouml.Container)e), result);
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<net.menthor.metamodel.ontouml.Class> allClasses() {
		net.menthor.metamodel.ontouml.Class[] result = null;
		final net.menthor.metamodel.ontouml.Class[] _converted_result = (net.menthor.metamodel.ontouml.Class[])result;
		EList<net.menthor.metamodel.ontouml.Class> _eList = ECollections.<net.menthor.metamodel.ontouml.Class>toEList(((Iterable<? extends net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)));
		this.allClasses(this, _eList);
		final net.menthor.metamodel.ontouml.Class[] _converted_result_1 = (net.menthor.metamodel.ontouml.Class[])result;
		return ECollections.<net.menthor.metamodel.ontouml.Class>toEList(((Iterable<? extends net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Structure> structures() {
		Structure[] result = null;
		EList<ContainedElement> _elements = this.getElements();
		for (final ContainedElement e : _elements) {
			if ((e instanceof Structure)) {
				final Structure[] _converted_result = (Structure[])result;
				((List<Structure>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(((Structure)e));
			}
		}
		final Structure[] _converted_result_1 = (Structure[])result;
		return ECollections.<Structure>toEList(((Iterable<? extends Structure>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void allStructures(final net.menthor.metamodel.ontouml.Container c, final EList<Structure> result) {
		EList<ContainedElement> _elements = this.getElements();
		for (final ContainedElement e : _elements) {
			{
				if ((e instanceof Structure)) {
					result.add(((Structure)e));
				}
				if ((e instanceof net.menthor.metamodel.ontouml.Package)) {
					this.allStructures(((net.menthor.metamodel.ontouml.Container)e), result);
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Structure> allStructures() {
		Structure[] result = null;
		final Structure[] _converted_result = (Structure[])result;
		EList<Structure> _eList = ECollections.<Structure>toEList(((Iterable<? extends Structure>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)));
		this.allStructures(this, _eList);
		final Structure[] _converted_result_1 = (Structure[])result;
		return ECollections.<Structure>toEList(((Iterable<? extends Structure>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));
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
			case OntoumlPackage.CONTAINER__ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getElements()).basicAdd(otherEnd, msgs);
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
			case OntoumlPackage.CONTAINER__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
			case OntoumlPackage.CONTAINER__ELEMENTS:
				return getElements();
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
			case OntoumlPackage.CONTAINER__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends ContainedElement>)newValue);
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
			case OntoumlPackage.CONTAINER__ELEMENTS:
				getElements().clear();
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
			case OntoumlPackage.CONTAINER__ELEMENTS:
				return elements != null && !elements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case OntoumlPackage.CONTAINER___PACKAGES:
				return packages();
			case OntoumlPackage.CONTAINER___ALL_PACKAGES__CONTAINER_ELIST:
				allPackages((net.menthor.metamodel.ontouml.Container)arguments.get(0), (EList<net.menthor.metamodel.ontouml.Package>)arguments.get(1));
				return null;
			case OntoumlPackage.CONTAINER___ALL_PACKAGES:
				return allPackages();
			case OntoumlPackage.CONTAINER___RELATIONSHIPS:
				return relationships();
			case OntoumlPackage.CONTAINER___ALL_RELATIONSHIPS__CONTAINER_ELIST:
				allRelationships((net.menthor.metamodel.ontouml.Container)arguments.get(0), (EList<Relationship>)arguments.get(1));
				return null;
			case OntoumlPackage.CONTAINER___ALL_RELATIONSHIPS:
				return allRelationships();
			case OntoumlPackage.CONTAINER___GENERALIZATION_SETS:
				return generalizationSets();
			case OntoumlPackage.CONTAINER___ALL_GENERALIZATION_SETS__CONTAINER_ELIST:
				allGeneralizationSets((net.menthor.metamodel.ontouml.Container)arguments.get(0), (EList<GeneralizationSet>)arguments.get(1));
				return null;
			case OntoumlPackage.CONTAINER___ALL_GENERALIZATION_SETS:
				return allGeneralizationSets();
			case OntoumlPackage.CONTAINER___CLASSES:
				return classes();
			case OntoumlPackage.CONTAINER___ALL_CLASSES__CONTAINER_ELIST:
				allClasses((net.menthor.metamodel.ontouml.Container)arguments.get(0), (EList<net.menthor.metamodel.ontouml.Class>)arguments.get(1));
				return null;
			case OntoumlPackage.CONTAINER___ALL_CLASSES:
				return allClasses();
			case OntoumlPackage.CONTAINER___STRUCTURES:
				return structures();
			case OntoumlPackage.CONTAINER___ALL_STRUCTURES__CONTAINER_ELIST:
				allStructures((net.menthor.metamodel.ontouml.Container)arguments.get(0), (EList<Structure>)arguments.get(1));
				return null;
			case OntoumlPackage.CONTAINER___ALL_STRUCTURES:
				return allStructures();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ContainerImpl
