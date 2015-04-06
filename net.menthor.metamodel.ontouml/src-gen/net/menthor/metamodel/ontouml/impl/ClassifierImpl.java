/**
 */
package net.menthor.metamodel.ontouml.impl;

import com.google.common.collect.Iterables;

import java.lang.Iterable;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.List;

import net.menthor.metamodel.ontouml.Classifier;
import net.menthor.metamodel.ontouml.GeneralizationSet;
import net.menthor.metamodel.ontouml.OntoumlPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassifierImpl#getIsSpecializedVia <em>Is Specialized Via</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassifierImpl#getSpecializesVia <em>Specializes Via</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ClassifierImpl extends ContainedElementImpl implements Classifier {
	/**
	 * The cached value of the '{@link #getIsSpecializedVia() <em>Is Specialized Via</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsSpecializedVia()
	 * @generated
	 * @ordered
	 */
	protected EList<GeneralizationSet> isSpecializedVia;

	/**
	 * The cached value of the '{@link #getSpecializesVia() <em>Specializes Via</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializesVia()
	 * @generated
	 * @ordered
	 */
	protected EList<GeneralizationSet> specializesVia;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OntoumlPackage.Literals.CLASSIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GeneralizationSet> getIsSpecializedVia() {
		if (isSpecializedVia == null) {
			isSpecializedVia = new EObjectWithInverseResolvingEList<GeneralizationSet>(GeneralizationSet.class, this, OntoumlPackage.CLASSIFIER__IS_SPECIALIZED_VIA, OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASSIFIER);
		}
		return isSpecializedVia;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GeneralizationSet> getSpecializesVia() {
		if (specializesVia == null) {
			specializesVia = new EObjectWithInverseResolvingEList.ManyInverse<GeneralizationSet>(GeneralizationSet.class, this, OntoumlPackage.CLASSIFIER__SPECIALIZES_VIA, OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSIFIER);
		}
		return specializesVia;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> children() {
		net.menthor.metamodel.ontouml.Class[] list = null;
		EList<GeneralizationSet> _isSpecializedVia = this.getIsSpecializedVia();
		for (final GeneralizationSet gs : _isSpecializedVia) {
			final net.menthor.metamodel.ontouml.Class[] _converted_list = (net.menthor.metamodel.ontouml.Class[])list;
			EList<Classifier> _specializingClassifier = gs.getSpecializingClassifier();
			Iterables.<Classifier>addAll(((Collection<Classifier>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list)), _specializingClassifier);
		}
		final net.menthor.metamodel.ontouml.Class[] _converted_list_1 = (net.menthor.metamodel.ontouml.Class[])list;
		return ECollections.<Classifier>toEList(((Iterable<? extends Classifier>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> parents() {
		Classifier[] list = null;
		EList<GeneralizationSet> _specializesVia = this.getSpecializesVia();
		for (final GeneralizationSet gs : _specializesVia) {
			final Classifier[] _converted_list = (Classifier[])list;
			Classifier _specializedClassifier = gs.getSpecializedClassifier();
			((List<Classifier>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list)).add(_specializedClassifier);
		}
		final Classifier[] _converted_list_1 = (Classifier[])list;
		return ECollections.<Classifier>toEList(((Iterable<? extends Classifier>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void allParents(final Classifier c, final EList<Classifier> result) {
		EList<GeneralizationSet> _specializesVia = this.getSpecializesVia();
		for (final GeneralizationSet gs : _specializesVia) {
			{
				Classifier _specializedClassifier = gs.getSpecializedClassifier();
				result.add(_specializedClassifier);
				Classifier _specializedClassifier_1 = gs.getSpecializedClassifier();
				this.allParents(_specializedClassifier_1, result);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> allParents() {
		Classifier[] list = null;
		final Classifier[] _converted_list = (Classifier[])list;
		EList<Classifier> _eList = ECollections.<Classifier>toEList(((Iterable<? extends Classifier>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list)));
		this.allParents(this, _eList);
		final Classifier[] _converted_list_1 = (Classifier[])list;
		return ECollections.<Classifier>toEList(((Iterable<? extends Classifier>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void allChildren(final Classifier c, final EList<Classifier> result) {
		EList<GeneralizationSet> _isSpecializedVia = this.getIsSpecializedVia();
		for (final GeneralizationSet gs : _isSpecializedVia) {
			{
				EList<Classifier> _specializingClassifier = gs.getSpecializingClassifier();
				result.addAll(_specializingClassifier);
				EList<Classifier> _specializingClassifier_1 = gs.getSpecializingClassifier();
				for (final Classifier children : _specializingClassifier_1) {
					this.allChildren(children, result);
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> allChildren() {
		Classifier[] list = null;
		final Classifier[] _converted_list = (Classifier[])list;
		EList<Classifier> _eList = ECollections.<Classifier>toEList(((Iterable<? extends Classifier>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list)));
		this.allChildren(this, _eList);
		final Classifier[] _converted_list_1 = (Classifier[])list;
		return ECollections.<Classifier>toEList(((Iterable<? extends Classifier>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list_1)));
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
			case OntoumlPackage.CLASSIFIER__IS_SPECIALIZED_VIA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsSpecializedVia()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.CLASSIFIER__SPECIALIZES_VIA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecializesVia()).basicAdd(otherEnd, msgs);
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
			case OntoumlPackage.CLASSIFIER__IS_SPECIALIZED_VIA:
				return ((InternalEList<?>)getIsSpecializedVia()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.CLASSIFIER__SPECIALIZES_VIA:
				return ((InternalEList<?>)getSpecializesVia()).basicRemove(otherEnd, msgs);
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
			case OntoumlPackage.CLASSIFIER__IS_SPECIALIZED_VIA:
				return getIsSpecializedVia();
			case OntoumlPackage.CLASSIFIER__SPECIALIZES_VIA:
				return getSpecializesVia();
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
			case OntoumlPackage.CLASSIFIER__IS_SPECIALIZED_VIA:
				getIsSpecializedVia().clear();
				getIsSpecializedVia().addAll((Collection<? extends GeneralizationSet>)newValue);
				return;
			case OntoumlPackage.CLASSIFIER__SPECIALIZES_VIA:
				getSpecializesVia().clear();
				getSpecializesVia().addAll((Collection<? extends GeneralizationSet>)newValue);
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
			case OntoumlPackage.CLASSIFIER__IS_SPECIALIZED_VIA:
				getIsSpecializedVia().clear();
				return;
			case OntoumlPackage.CLASSIFIER__SPECIALIZES_VIA:
				getSpecializesVia().clear();
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
			case OntoumlPackage.CLASSIFIER__IS_SPECIALIZED_VIA:
				return isSpecializedVia != null && !isSpecializedVia.isEmpty();
			case OntoumlPackage.CLASSIFIER__SPECIALIZES_VIA:
				return specializesVia != null && !specializesVia.isEmpty();
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
			case OntoumlPackage.CLASSIFIER___CHILDREN:
				return children();
			case OntoumlPackage.CLASSIFIER___PARENTS:
				return parents();
			case OntoumlPackage.CLASSIFIER___ALL_PARENTS__CLASSIFIER_ELIST:
				allParents((Classifier)arguments.get(0), (EList<Classifier>)arguments.get(1));
				return null;
			case OntoumlPackage.CLASSIFIER___ALL_PARENTS:
				return allParents();
			case OntoumlPackage.CLASSIFIER___ALL_CHILDREN__CLASSIFIER_ELIST:
				allChildren((Classifier)arguments.get(0), (EList<Classifier>)arguments.get(1));
				return null;
			case OntoumlPackage.CLASSIFIER___ALL_CHILDREN:
				return allChildren();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ClassifierImpl
