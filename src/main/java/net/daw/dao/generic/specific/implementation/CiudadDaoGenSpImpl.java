/*
 * Copyright (C) 2015 asus-pc
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package net.daw.dao.generic.specific.implementation;

import java.sql.Connection;
import net.daw.bean.generic.specific.implementation.CiudadBeanGenSpImpl;
import net.daw.dao.generic.implementation.TableDaoGenImpl;
import net.daw.dao.publicinterface.MetaDaoInterface;
import net.daw.dao.publicinterface.TableDaoInterface;
import net.daw.dao.publicinterface.ViewDaoInterface;

/**
 *
 * @author asus-pc
 */
public class CiudadDaoGenSpImpl extends TableDaoGenImpl<CiudadBeanGenSpImpl> implements TableDaoInterface<CiudadBeanGenSpImpl>, ViewDaoInterface<CiudadBeanGenSpImpl>, MetaDaoInterface {

    public CiudadDaoGenSpImpl(String strObject, Connection pooledConnection) throws Exception {
        super(strObject, pooledConnection);
    }
}
