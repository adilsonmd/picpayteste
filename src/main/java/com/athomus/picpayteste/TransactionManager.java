package com.athomus.picpayteste;

public class TransactionManager {
    // TODO implementar funcionalidade de transação
    public TransactionManager() {
    }

    public void commit() {
        System.out.println("Commit realizado");
    }

    public void rollback() {
        System.out.println("Rollback realizado");
    }

    public void close() {
        System.out.println("Fechando transação");
    }
}
