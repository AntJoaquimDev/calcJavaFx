package calcDao;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CrudGenecDao<T> { //CRUD generico

    public boolean salvar(T tipo) {
        // conectar e abrir uma conexao depois tem q feichar
        try {
            Session session = ConexaoBanco.getSessionFcatory().openSession();
            session.beginTransaction(); //iniciar transaçao
            session.merge(tipo); //pegar os dados do form
            session.getTransaction().commit(); //gtavar no banco
            session.close(); //encerrar conexao
            return true;
        } catch (Exception erro) {
            System.out.println("Erro " + erro);
            //criar arquivo de logs
            return false;
        }

    }

    //buscar lista no banco e mostrar na tableview
    public List<T> consultar( String nomeClasse) {

        List<T> lista = new ArrayList<>();
        Session session = ConexaoBanco.getSessionFcatory().openSession();
        session.beginTransaction();

        lista = session.createQuery(" from " + nomeClasse).getResultList();
        // -> esse comando seria para retornar td da tabela tds os registros


        session.getTransaction().commit(); //gtavar no banco
        session.close(); //encerrar conexao

        return lista;
    }

    public void excluir(T tipo) {
        try {
            Session session = ConexaoBanco.getSessionFcatory().openSession();
            session.beginTransaction();
            session.delete(tipo);
            session.getTransaction().commit();
            session.close();
        } catch (Exception erro) {
            System.out.println("Erro " + erro);
        }

    }
}
