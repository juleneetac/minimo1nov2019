package edu.upc.dsa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameManagerTest {

    private GameManger mm;

    @Before
    public void SetUp() throws Exception {
        mm = GameManagerImpl.getInstance();

        mm.addJugador("u1", "Julen", "vava");
        mm.addObjeto("espada", "u1");
        mm.addObjeto("martillo", "u1");
        mm.addObjeto("moneda", "u1");
    }



    @Test
    public void testAddObjeto() throws Exception {
        mm.addObjeto("llave", "u1");
        Assert.assertEquals(1, mm.listadoObjetos("Julen").size());

        mm.addObjeto("vara", "u2");
        Assert.assertEquals(2, mm.listadoObjetos("Julen").size());
    }

    @After
    public void tearDown(){
        mm.clear();
    }
}
