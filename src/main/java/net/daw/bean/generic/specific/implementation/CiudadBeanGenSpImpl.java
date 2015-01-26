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

package net.daw.bean.generic.specific.implementation;

import com.google.gson.annotations.Expose;
import net.daw.bean.generic.implementation.BeanGenImpl;
import net.daw.bean.publicinterface.BeanInterface;

/**
 *
 * @author asus-pc
 */
public class CiudadBeanGenSpImpl extends BeanGenImpl implements BeanInterface {
    
    private String nombre;
    @Expose(serialize = false)
    private Integer id_autor = 0;
    @Expose(deserialize = false)
    private AutorBeanGenSpImpl obj_autor = null;
    
    public CiudadBeanGenSpImpl(){ 
        
    }
    public CiudadBeanGenSpImpl(int id){
        super(id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_autor() {
        return id_autor;
    }

    public void setId_autor(Integer id_autor) {
        this.id_autor = id_autor;
    }

    public AutorBeanGenSpImpl getObj_autor() {
        return obj_autor;
    }

    public void setObj_autor(AutorBeanGenSpImpl obj_autor) {
        this.obj_autor = obj_autor;
    }
    
 
    
}
