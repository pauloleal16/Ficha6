import org.example.ex2.Numero;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercicio2Teste {

    private Numero numeros;

    @BeforeAll
    public static void setupAll() {
        System.out.println("INICIO");
    }

    @BeforeEach
    public void setup() {
        System.out.println("Instantiating Contact Manager");
        numeros = new Numero();
    }

    @Nested
    class ParameterizedTests {
        @DisplayName("Verificar primos")
        @ParameterizedTest
        @ValueSource(ints = {3, 23, 311, 487, 653, 947})
        public void verificarNumeroPrimo(int number) {
            assertTrue(numeros.isPrime(number));
        }

        @DisplayName("Verificar pares")
        @ParameterizedTest
        @ValueSource(ints = {32, 64, 2, 20, 30, 26})
        public void verificarNumeroPar(int number) {
            assertTrue(numeros.isEven(number));
        }

        @DisplayName("Verificar múltiplos")
        @ParameterizedTest
        @ValueSource(ints = {23, 46, 115, 184, 207, 230})
        public void verificarNumeroMultiplo(int number) {
            assertTrue(numeros.isMultiple(number,23));
        }
    }

}
