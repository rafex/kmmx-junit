package mx.kmmx.junit5.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class AppTest {


    @Test
    void esVerdadero(){
        Assertions.assertTrue(true);
    }

    @Test
    void otroVerdadero(){
        assertTrue(true);
    }

    @Test
    @Disabled("no lo he terminado porque faltan insumos")
    @DisplayName("Yo soy el test que falla")
    void otroVerdadero2(){
        assertTrue(false);
    }

    @Test
    @DisplayName("Aqui va el nombre del test")
    void test1(){
        System.out.println("HOla!");

    }

    @Test
    void convertirCadenaANumero(){
        String algo = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Integer.valueOf(algo);
        });
    }

    @Test
    public void validarLista(){
        List<Integer> listNumeros = List.of(2,4,6,8,10);

        for(Integer number : listNumeros){
            //assertEquals(0,number%2);
            assertTrue(number%2==0);
        }
        //assertEquals(0,listNumeros.get(4)%2);

        assertEquals(10,listNumeros.get(4));
    }

    @Test
    void estoEsFalso(){
        assertFalse(false);
    }

    @Test
    void comprobarContenidoDeCadena(){
        String string = "abc";
        assertFalse(string.contains("Z"));
    }

}
