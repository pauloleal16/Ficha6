import org.example.ex3.Nota;
import org.example.ex3.UC;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Exercicio3Teste {

    static UC uc;

    @BeforeAll
    public static void setupAll() {
        System.out.println("Imprimir antes de tudo");
        ArrayList<Nota> notas = new ArrayList<>();
        uc = new UC("qs", notas, notas.size());

    }

    @ParameterizedTest
    @DisplayName("Deve registar uma nota")
    @CsvSource(value={"43105,16","43002,14","1,0"})
    public void testeRegistarNota(int numAluno, int nota) {
        assertTrue(uc.insereNotaUC(numAluno, nota),"nota inválida");

    }

    @Test
    @DisplayName("Deve calcular media")
    public void testeCalcularMedia() {
        assertEquals(10, uc.media(), "média errada");
    }


    @DisplayName("Pesquisar Aluno")
    @ParameterizedTest
    @ValueSource(ints = {43105, 5, 2000, 43002})
    public void testePesquisaAluno(int numAluno){
        assertTrue(uc.pesquisaALuno(numAluno), "aluno não econtrado");
    }


    @DisplayName("Verificar aluno aprovado")
    @ParameterizedTest
    @ValueSource(ints = {43105, 43002, 1})
    public void testeAlunoAprovado(int numAluno){
        assertTrue(uc.aprovado(numAluno), "aluno reprovado");
    }

}




