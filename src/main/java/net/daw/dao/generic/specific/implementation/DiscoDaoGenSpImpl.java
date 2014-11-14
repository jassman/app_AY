/*
 * Copyright (C) July 2014 Rafael Aznar
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

import net.daw.dao.generic.implementation.TableDaoGenImpl;
import java.sql.Connection;
import net.daw.bean.generic.specific.implementation.DiscoBeanGenSpImpl;
import net.daw.helper.ExceptionBooster;

public class DiscoDaoGenSpImpl extends TableDaoGenImpl<DiscoBeanGenSpImpl> {

    public DiscoDaoGenSpImpl(String strObject, Connection pooledConnection) throws Exception {
        super(strObject, pooledConnection);
    }

    public int changeforeign(String campo, int id1, int id2) {
        int regs = 0;
        try {
            regs = oMysql.updateSomeIds(strTabla, campo, id1, id2);
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":changeforeign ERROR: " + ex.getMessage()));
        }
        return regs;
    }

}
