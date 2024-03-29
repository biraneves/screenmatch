package br.dev.biraneves.screenmatch.service;

public interface IConverteDados {

    <T> T obterDados(String json, Class<T> classe);

}
