package net.menthor.ontouml2simpleowl.transform;

import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.util.OWLClassExpressionVisitorAdapter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Copyright (C) 2007, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

/**
 * <p>A visitor that collects existential restrictions. If the given expression is
 * an intersection, then the visitor will recurse and visit the operands.
 * Otherwise, if it's an existential restriction, the visitor will add the
 * restriction to the collection.</p>
 * <p/>
 * <p>The visitor returns a map of properties to collections of fillers using that
 * property.</p>
 * <p/>
 * <p/>
 * Author: Sean Bechhofer<br>
 * The University Of Manchester<br>
 * Information Management Group<br>
 * Date: 24-April-2007<br>
 * <br>
 */
public class ExistentialCollector extends OWLClassExpressionVisitorAdapter {
    /* Collected axioms */
    private Map<OWLObjectPropertyExpression, Set<OWLClassExpression>> restrictions;

    public ExistentialCollector(
            Map<OWLObjectPropertyExpression, Set<OWLClassExpression>> restrictions) {
        this.restrictions = restrictions;
    }

    @Override
    public void visit(OWLObjectIntersectionOf expression) {
        for (OWLClassExpression operand : expression.getOperands()) {
            operand.accept(this);
        }
    }

    @Override
    public void visit(OWLObjectSomeValuesFrom classExpression) {
        Set<OWLClassExpression> fillers = restrictions.get(classExpression.getProperty());
        if (fillers == null) {
            fillers = new HashSet<OWLClassExpression>();
            restrictions.put(classExpression.getProperty(), fillers);
        }
        fillers.add(classExpression.getFiller());
    }

}