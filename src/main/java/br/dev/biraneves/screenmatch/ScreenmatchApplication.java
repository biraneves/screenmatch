package br.dev.biraneves.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.dev.biraneves.screenmatch.model.DadosSerie;
import br.dev.biraneves.screenmatch.service.ConsumoAPI;
import br.dev.biraneves.screenmatch.service.ConverteDados;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoAPI();

		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=b9437958");
		System.out.println(json);

		// json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		// System.out.println(json);

		var conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);

		System.out.println(dados);
	}

}
