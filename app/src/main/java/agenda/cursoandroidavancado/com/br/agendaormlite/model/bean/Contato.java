package agenda.cursoandroidavancado.com.br.agendaormlite.model.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by root on 19/01/15.
 */
@DatabaseTable
public class Contato {

    @DatabaseField(generatedId = true)
    private Long id;
    @DatabaseField
    private String nome;
    @DatabaseField
    private String email;
    @DatabaseField
    private String telefone;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



    @Override
    public String toString(){
        return nome+"["+telefone+"]";
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || getClass()!=o.getClass()) return false;

        Contato contato = (Contato) o;

        if(id!=null?!id.equals(contato.id):contato.id!=null);
        return true;

    }
    @Override
    public int hashCode(){
        return id!=null?id.hashCode():0;
    }



}
