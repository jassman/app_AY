/*
 * Copyright (C) 2014 raznara
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
package net.daw.helper;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author raznara
 */
public class Aleatorio {

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    
        public static String randString() {
        Random rand = new Random();
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("hola");
        lista.add("buenas");
        lista.add("adios");
        int randomNum = rand.nextInt(2);
        String palabra = lista.get(randomNum);
        return palabra;
    }
}
