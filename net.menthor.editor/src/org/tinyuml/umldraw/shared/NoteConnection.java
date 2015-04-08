package org.tinyuml.umldraw.shared;

/**
 * Copyright 2007 Wei-ju Wu
 *
 * This file is part of TinyUML.
 *
 * TinyUML is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * TinyUML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with TinyUML; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

import org.tinyuml.draw.SimpleConnection;

import RefOntoUML.NamedElement;
import RefOntoUML.Relationship;

/**
 * This class implements a connection with a Note.
 *
 * @author Wei-ju Wu
 */
public final class NoteConnection extends BaseConnection {

	private static final long serialVersionUID = 5536230656063402250L;
	private static NoteConnection prototype = new NoteConnection();

	/**
	 * Returns the prototype instance for this Connection.
	 * @return the prototype instance
	 */
	public static NoteConnection getPrototype() { return prototype; }

	/**
	 * Constructor.
	 */
	private NoteConnection() {
		setConnection(new SimpleConnection(this));
		setIsDashed(true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRelationship(Relationship relationship) { }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NamedElement getClassifier() { return null; }
}
