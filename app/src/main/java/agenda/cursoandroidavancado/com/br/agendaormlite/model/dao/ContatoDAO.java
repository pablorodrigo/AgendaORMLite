package agenda.cursoandroidavancado.com.br.agendaormlite.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

import agenda.cursoandroidavancado.com.br.agendaormlite.model.bean.Contato;

/**
 * Created by root on 19/01/15.
 */


public class ContatoDAO extends OrmLiteSqliteOpenHelper {

private static final String DATABASE_NAME = "agenda.db";

private static final int DATABASE_VERSION=1;

private Dao<Contato,Long> dao = null;

public ContatoDAO(Context context){
    super(context,DATABASE_NAME,null,DATABASE_VERSION);
}
    @Override
    public void onCreate(SQLiteDatabase database,ConnectionSource connectionSource){
        try {
            Log.i(ContatoDAO.class.getSimpleName(),"onCreate()");
            //coneccao para ignorar erros
            TableUtils.createTable(connectionSource,Contato.class);
            Contato contato = new Contato();
            contato.setNome("Adm");
            contato.setEmail("teste@teste.com.br");
            contato.setTelefone("99999999");
            cadastrar(contato);

        }catch (SQLException ex){
            Log.e(ContatoDAO.class.getSimpleName(),"Oncreate falha",ex);
        }


    }
    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource source,int oldVersion,int newVersion){
        try {
            Log.i(ContatoDAO.class.getSimpleName(),"onUpgrade()");
            TableUtils.dropTable(source,Contato.class,true);
            onCreate(database,source);
        }catch (SQLException ex){
            Log.e(ContatoDAO.class.getSimpleName(),"onUpgrade falha",ex);
        }




    }
    public Dao<Contato,Long> getDao(){
        if (dao==null){
            try{
                dao= getDao(Contato.class);

            }catch (SQLException e){

                Log.e(ContatoDAO.class.getSimpleName(),"getDAO: falha",e);


            }

        }
    return dao;
    }



    @Override
    public void close() {
        super.close();
        dao = null;
    }

    public void cadastrar(Contato contato) throws SQLException{
        getDao().create(contato);
    }

    public void excluir(Contato contato) throws SQLException{
        getDao().delete(contato);
    }

    public void alterar(Contato contato) throws SQLException{
        getDao().update(contato);

    }

    public List<Contato> listar() throws SQLException{
        return getDao().queryForAll();
    }
}
