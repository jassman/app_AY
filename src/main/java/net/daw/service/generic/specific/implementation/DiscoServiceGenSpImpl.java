/*
 * Copyright (C) 2014 Rafael Aznar
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
package net.daw.service.generic.specific.implementation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import net.daw.bean.generic.specific.implementation.AutorBeanGenSpImpl;
import net.daw.bean.generic.specific.implementation.DiscoBeanGenSpImpl;
import net.daw.bean.generic.specific.implementation.GeneroBeanGenSpImpl;
import net.daw.bean.generic.specific.implementation.TituloBeanGenSpImpl;
import net.daw.dao.generic.specific.implementation.AutorDaoGenSpImpl;
import net.daw.dao.generic.specific.implementation.DiscoDaoGenSpImpl;
import net.daw.dao.generic.specific.implementation.GeneroDaoGenSpImpl;
import net.daw.dao.generic.specific.implementation.TituloDaoGenSpImpl;
import net.daw.helper.ExceptionBooster;
import net.daw.service.generic.implementation.TableServiceGenImpl;

public class DiscoServiceGenSpImpl extends TableServiceGenImpl {

    public DiscoServiceGenSpImpl(String strObject, Connection con) {
        super(strObject, con);
    }

    public String populate(Integer numDiscos) throws Exception {
        try {

            for (int contador = 1; contador <= numDiscos; contador++) {
                oConnection.setAutoCommit(false);

                TituloDaoGenSpImpl oTituloDao = new TituloDaoGenSpImpl("titulo", oConnection);
                AutorDaoGenSpImpl oAutorDao = new AutorDaoGenSpImpl("autor", oConnection);
                GeneroDaoGenSpImpl oGeneroDao = new GeneroDaoGenSpImpl("genero", oConnection);

                TituloBeanGenSpImpl oTitulo = oTituloDao.getRandomOne();
                AutorBeanGenSpImpl oAutor = oAutorDao.getRandomOne();
                GeneroBeanGenSpImpl oGenero = oGeneroDao.getRandomOne();

                DiscoDaoGenSpImpl oDiscoDao = new DiscoDaoGenSpImpl("disco", oConnection);
                DiscoBeanGenSpImpl oDisco = new DiscoBeanGenSpImpl();

                oDisco.setNombre(oTitulo.getdescripcion());
                oDisco.setId_genero(oGenero.getId());
                oDisco.setId_autor(oAutor.getId());

                oDiscoDao.set(oDisco);

                oConnection.commit();
            }

        } catch (Exception ex) {
            oConnection.rollback();
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":set ERROR: " + ex.getMessage()));
        }
        return "los discos han sido creados con éxito";
    }

    public String changeforeign(int id1, int id2) throws Exception {
        DiscoDaoGenSpImpl oDiscoDao = new DiscoDaoGenSpImpl("disco", oConnection);
        int total = oDiscoDao.changeforeign("id_genero", id1, id2);
        return "se han actualizado " + total + " claves ajenas con éxito";
    }

    public String porGenero(int id_genero) throws Exception {
        String json = "";
        try {
            oConnection.setAutoCommit(false);
            DiscoDaoGenSpImpl oDiscoDao = new DiscoDaoGenSpImpl("disco", oConnection);
            DiscoBeanGenSpImpl oDisco = new DiscoBeanGenSpImpl();
            DiscoBeanGenSpImpl oDisco2 = new DiscoBeanGenSpImpl();
            
            
            oDisco.setId(1);
            oDisco2.setId(4);
            oDisco = oDiscoDao.get(oDisco, 1);
            oDisco2 = oDiscoDao.get(oDisco2, 4);
            List<DiscoBeanGenSpImpl> discos = new ArrayList<>();
            discos.add(oDisco);
            discos.add(oDisco2);
            List<DiscoBeanGenSpImpl> listaDiscosPorGenero = new ArrayList<>();

            for (int i = 0; i <= discos.size() -1; i++) {
                oDisco = discos.get(i);
                if (oDisco.getId_genero() == id_genero) {
                    listaDiscosPorGenero.add(oDisco);
                }
            }

            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            String data = gson.toJson(listaDiscosPorGenero.get(0));
            json = "{\"disco\":" + data + "}";
            oConnection.commit();
        } catch (Exception ex) {
            oConnection.rollback();
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":set ERROR: " + ex.getMessage()));
        }

        return json;
    }

}
