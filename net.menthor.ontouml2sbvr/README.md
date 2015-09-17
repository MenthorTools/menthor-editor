OntoUMLx-to-SBVR
================

The current document contains anhigh level description of how the OntoUMO-to-SBVR conversion is performed by the following code.

Namespace abbreviations
-----------------------
`ROU` stands for `RefOntoUML`.

RefOntoUML object model
-----------------------
All the classes, where not indicated, are from the `RefOntoUML` namespace.

* `Element` (I) extends `org.eclipse.emf.ecore.EModelElement`
* `NamedElement` (I) extends `Element`
* `PackageableElement` (I) extends `NamedElement`
* `RedefinableElement` (I) extends `NamedElement`
* `Namespace` (I) extends `NamedElement`
* `Type` (I) extends `PackageableElement`
* `Package` (I) extends `Namespace`, `PackageableElement`
* `Classifier` (I) extends `Namespace`, `RedefinableElement`, `Type`
* `Class` (I) extends `Classifier`
* `Relationship` (I) extends `Element`
* `Association` (I) extends `Classifier`, `Relationship`
* `Feature` (I) extends `RedefinableElement`
* `TypedElement` (I) extends `NamedElement`
* `MultiplicityElement` (I) extends `Element`
* `StructuralFeature` (I) extends `Feature`, `TypedElement`, `MultiplicityElement`
* `Property` (I) extends `StructuralFeature`

Transformation walk-through (simplified)
----------------------------------------
Everything must be intended as in the package `br.ufes.inf.nemo.ontouml2sbvr.core`, otherwise the package will explicitly defined. Anyway, the common prefix `br.ufes.inf.nemo` could be omitted.

`OntoUML2SBVR` is the transformation entry point (i.e. the `main` method). A `Transformation` instance is created for the input file, inside the constructor a new `FileManager` instance is created for the input file. `Transformation.Transform()` method is invoked, passing the value `false` for the parameter `serial`. The transformation relies on two classes' instances which are the `FileManager` aforementioned and a `TreeProcessor` instance, both initialized in the `Transformation`'s constructor. The `Transformation.Transform()` method just cast the input model to a `RefOntoUML.Package` instance and bounce it to the `Transformation.Tree()` method, which orchestrate the main transformation steps: 

* recursively invokes itself for all the packaged `Package` instances
* all `Class` instances are processed, i.e. trasnformed into `Node` instances
* all `Association` instances are processed, i.e. end `Property`s are retrieved, and then correspondent `Node`s associations are added (for the first node, also an *owned* one is added). If the `Property` has a valid name, a new association role (i.e. peoperty's name and the property type casted into a `Classifier` is added). **QUESTIONS**: what if the association end `Property`'s type is not a `Class`? What if the `Property` doesn't have a valid name?
* the `Node`s are processed (via `TreeProcessor.ProcessNodes()` method) and their hierarchy is built, considering also their `GeneralizationSet`s.

Now we have all the `Node`s indexed along with their `Generalization`s, `GeneralizationSet`s, `Association`s and their reoles within. The translation starts here:

* the main nodes (i.e. top-level nodes in the generalization hierarchy) are processed. The main method is `FileManager.DealNode()`. First the `FileManager.DealClassBasic()` so that the concept name, its generalization and generalizations sets it is involved in are represented in the same fragment. Then, if the node has children or is involved in an association, a collapsible section is added (please, note that if the flag 'serial' is set, only the *owned associations* are considered).
* if they are `RefOntoUML.DataType`, they are sent to the `FileManager.DealDataType()` method (after casting).
* the `TreeProcessor.getAssociationRoles()` returns all the association roles which are iterated and then treated by the `FileManager.DealAssociationRole()` method. 

### Mappings
In the `FileManager.getClassConcept()` method code you can find the mapping form the OntoUML type of universal to the SBVR concept type. 
