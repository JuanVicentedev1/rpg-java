package tech.buildrun.TaskFlow;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorTarefa {
    private Map<String, Tarefa> tarefas = new HashMap<>();

    public GerenciadorTarefa() {}

    public void adicionarTarefa(String id, String descricao){
        Tarefa t = new Tarefa(id, descricao);
        if (tarefas.get(id) == null) {
            tarefas.put(t.getId(), t);

            System.out.println(String.format("Tarefa [%s] adicionada com sucesso!", descricao));
        }else {
            System.out.println("Tarefa com este indentificador já existe.");
        }
    }

    public void removerTarefa(String id){
        if (tarefas.get(id) == null) {
            System.out.println("Tarefa  com este indentificador não foi encontrada");
        }else {
            tarefas.remove(id);
            System.out.println(String.format("Tarefa [%s] removida com sucesso!", id));
        }
    }

    public void imprimirTarefas(){
        // listando todas minhas tarefas
        System.out.println("Imprimindo Tarefas: ");
       for (Tarefa t : tarefas.values()){
           System.out.println(t);
       }
    }

    public void finalizarTarefa(String id){
        Tarefa tarefa = tarefas.get(id);
        if (tarefa == null) {
            System.out.println("Tarefa não localizada!");
        }else {
            tarefa.finalizarTarefa();
            System.out.println(String.format("Tarefa [%s] [%s] foi finalizada vamo embora among!", tarefa.getId(), tarefa.getDescricao()));
        }
    }

    public void procurarTarefa(String descricao) {
        boolean encontrada = false;

        for (Tarefa tarefa : tarefas.values()) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                System.out.println(String.format(
                        "Tarefa encontrada: [%s] [%s]",
                        tarefa.getId(),
                        tarefa.getDescricao()
                ));
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("Nenhuma tarefa encontrada com essa descrição!");
        }
    }
}
